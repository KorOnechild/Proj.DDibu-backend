package com.project.pokemon.validator;

import com.project.pokemon.model.dto.SignupDto;

import java.util.regex.Pattern;

public class UserValidator {

    public static void validatorUsersInput(SignupDto dto) {

        // TODO : 유효성 검사 테스트

        if (dto.getPassword().length() > 21) {
            try {
                throw new IllegalAccessException("패스워드 길이가 유효하지 않습니다.");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        if (!Pattern.matches("^([a-z|A-Z|0-9|.|_|%+-])+@([a-z|A-Z|0-9|-])+.([a-z|A-Z]){2,6}$", dto.getEmail())) {
            try {
                throw new IllegalAccessException("이메일 형식이 유효하지 않습니다.");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        if (dto.getNickname().length() > 10) {
            try {
                throw new IllegalAccessException("유저 닉네임 길이가 유효하지 않습니다");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
