package com.project.pokemon.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDto {
    private String email;
    private String password;
}
