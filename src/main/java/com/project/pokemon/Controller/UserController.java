package com.project.pokemon.Controller;

import com.project.pokemon.Service.UserService;
import com.project.pokemon.model.dto.requestDto.SignupDto;
import com.project.pokemon.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {

        this.userService = userService;
        this.userRepository = userRepository;
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
    public String registerUser(@RequestBody SignupDto Dto) {

        userService.registerUser(Dto);
        return "success";
    }

    @ResponseBody
    @GetMapping("/user/emailDupCheck/{email}")
    public Boolean emailDupCheck(@PathVariable String email) {

        return userService.checkEmailDuplicate(email);
    }

    @ResponseBody
    @GetMapping("/user/nameDupCheck/{nickname}")
    public Boolean nameDupCheck(@PathVariable String nickname) {

        return userService.checkNameDuplicate(nickname);
    }

}