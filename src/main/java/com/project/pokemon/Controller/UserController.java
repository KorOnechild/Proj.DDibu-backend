package com.project.pokemon.Controller;

import com.project.pokemon.Service.UserService;
import com.project.pokemon.model.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    // TODO : String으로 내보내는 방법 알아내기

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {

        return "login";
    }

    // 회원가입 페이지
    @GetMapping("/user/signup")
    public String signup() {

        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(SignupDto Dto) {

        userService.registerUser(Dto);
        return "redirect:/user/login";
    }

}