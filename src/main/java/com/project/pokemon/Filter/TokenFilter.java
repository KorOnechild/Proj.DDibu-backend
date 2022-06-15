package com.project.pokemon.Filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.pokemon.model.TokenDecode;
import com.project.pokemon.model.dto.responseDto.UserTokenRespDto;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;

        UserTokenRespDto tokenRespDto= null;
        String url = httpRequest.getRequestURI();

        // 로그인, 회원가입은 jwt 토큰 인증이 필요 없음
        if(url.startsWith("/comment") || url.startsWith("/like")) {
            String authorization = httpRequest.getHeader("Authorization");

            if(authorization == null || !authorization.startsWith("Bearer ")) {
                // 에러 나는 부분
                tokenRespDto  = new UserTokenRespDto(false, "토큰이 유효하지 않습니다.");
            }

            if(tokenRespDto == null) {
                // 인증 성공 한 부분
                String token = authorization.substring(7);

                DecodedJWT jwt = null;

                try {
                    Algorithm algorithm = Algorithm.HMAC256("rlaalswnrkgoTdma"); //use more secure key
                    JWTVerifier verifier = JWT.require(algorithm)
                            .withIssuer("gkdgo99")
                            .build(); //Reusable verifier instance

                    jwt = verifier.verify(token);

                    TokenDecode tokenDecode = new TokenDecode(jwt);
                    httpRequest.setAttribute("decode", tokenDecode);
                } catch (JWTVerificationException exception){
                    tokenRespDto  = new UserTokenRespDto(false, exception.getMessage());
                }
            }
        }

        if(tokenRespDto != null) {
            httpResponse.setContentType("application/json");
            httpResponse.setCharacterEncoding("utf-8");
            httpResponse.setStatus(HttpServletResponse.SC_OK);

            OutputStream out = httpResponse.getOutputStream();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(out, tokenRespDto);
            out.flush();
            return;
        }


        chain.doFilter(httpRequest, httpResponse);


    }

}