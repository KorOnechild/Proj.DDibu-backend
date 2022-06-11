package com.project.pokemon.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;

@AllArgsConstructor
@Setter
@Getter
public class SignupDto {

    private String email;
    private String username;
    private String password;
    
}
