package com.project.pokemon.Controller;

import com.project.pokemon.Service.CommentsService;
import com.project.pokemon.model.dto.requestDto.CommentsDto;
import com.project.pokemon.model.dto.responseDto.CommentsListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public List<CommentsListDto> getComments(@PathVariable Long pokemonId){
        return commentsService.getComments(pokemonId);
    }

    //댓글 수정 API
    @PatchMapping("/comment/update/{commentId}")
    public String updateComments(@PathVariable Long commentId, String newcomments){
        return commentsService.updateComments(commentId, newcomments);
    }

    //댓글 삭제 API

}
