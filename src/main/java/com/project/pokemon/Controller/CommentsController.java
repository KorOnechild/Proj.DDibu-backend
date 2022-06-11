package com.project.pokemon.Controller;

import com.project.pokemon.Service.CommentsService;
import com.project.pokemon.model.dto.CommentsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class CommentsController {

    private final CommentsService commentsService;

    //댓글 작성 API
    @PostMapping("comment/create")
    public String createComments(CommentsDto commentsDto){
        return commentsService.createComments(commentsDto);
    }

    //댓글 조회 API
    @GetMapping("/comment/{pokemonId}")
    public String getComments(@PathVariable Long pokemonId){
        return commentsService.getComments(pokemonId);
    }

    //댓글 수정 API


    //댓글 삭제 API

}
