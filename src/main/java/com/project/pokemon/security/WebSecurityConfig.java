package com.project.pokemon.security;

import com.project.pokemon.filter.RestLoginFailureHandler;
import com.project.pokemon.filter.RestLoginSuccessHandler;
import com.project.pokemon.filter.RestLogoutSuccessHandler;
import com.project.pokemon.filter.RestUsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder encodePassword() {

        return new BCryptPasswordEncoder();
    }

    @Autowired
    private RestLogoutSuccessHandler restLogoutSuccessHandler;

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http
                .cors()
                .configurationSource(corsConfigurationSource());

        http.authorizeRequests()

                .antMatchers("/").permitAll()
                .antMatchers("/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/user/**").permitAll()
                .anyRequest().permitAll();

        http.formLogin().disable();
        http.addFilterAt(getAuthenticationFilter(), RestUsernamePasswordAuthenticationFilter.class);

        http.logout()
                .logoutUrl("/user/logout")
                .logoutSuccessHandler(restLogoutSuccessHandler)
                .permitAll();
        http.exceptionHandling();
    }

    protected RestUsernamePasswordAuthenticationFilter getAuthenticationFilter() {
        RestUsernamePasswordAuthenticationFilter authFilter = new RestUsernamePasswordAuthenticationFilter();
        try {
            authFilter.setFilterProcessesUrl("/user/login");
            authFilter.setUsernameParameter("email");
            authFilter.setPasswordParameter("password");
            authFilter.setAuthenticationManager(this.authenticationManagerBean());
            authFilter.setAuthenticationSuccessHandler(successHandler());
            authFilter.setAuthenticationFailureHandler(failureHandler());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return authFilter;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:3000"); // local FE test
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.addExposedHeader("Authorization");
        configuration.addAllowedOriginPattern("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {

        return new RestLoginSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler failureHandler() {

        return new RestLoginFailureHandler();
    }

//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
}
