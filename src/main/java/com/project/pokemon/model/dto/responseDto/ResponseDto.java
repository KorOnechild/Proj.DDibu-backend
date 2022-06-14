package com.project.pokemon.model.dto.responseDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDto { // 전달 값 dto

    private boolean result;
    private String err_msg;
    private String email;

    public ResponseDto(Boolean result, String err_msg, String email) {
        this.result = result;
        this.err_msg = err_msg;
        this.email = email;
    }

    public ResponseDto(Boolean result) {

        this.result = result;
    }

    public ResponseDto(String email, Boolean result) {

        this.email = email;
        this.result = result;
    }

    public ResponseDto(String email) {

        this.email = email;
    }

}
