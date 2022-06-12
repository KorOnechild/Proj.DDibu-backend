package com.project.pokemon.model.entity;

import com.project.pokemon.model.dto.SignupDto;
import com.project.pokemon.validator.UserValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Users {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

    public Users(SignupDto dto) {
        UserValidator.validatorUsersInput(dto);

        this.email = dto.getEmail();
        this.nickname = dto.getNickname();
        this.password = dto.getPassword();
    }

    public Users(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

}
