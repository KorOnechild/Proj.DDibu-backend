package com.project.pokemon.model.dto.requestDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDto { // 필터 사용을 위한 dto

    private String email;
    private String password;

}
