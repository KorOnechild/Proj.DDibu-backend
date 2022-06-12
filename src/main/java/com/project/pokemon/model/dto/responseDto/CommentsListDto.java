package com.project.pokemon.model.dto.responseDto;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
public class CommentsListDto {
    String comments;
    String nickname;
    LocalDateTime createdAt;
}
