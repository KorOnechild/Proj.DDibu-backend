package com.project.pokemon.Controller;

import com.project.pokemon.Service.CommentsService;
import com.project.pokemon.model.dto.requestDto.CommentsDto;
import com.project.pokemon.model.dto.responseDto.CommentsListDto;
import com.project.pokemon.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class CommentsController {

    private final CommentsService commentsService;

    //댓글 작성 API
    @PostMapping("comment/{pokemonId}")
    public String createComments(@PathVariable Long pokemonId,
                                 @RequestBody CommentsDto commentsDto,
                                 @AuthenticationPrincipal UserDetailsImpl userDetails) {

        return commentsService.createComments(pokemonId, commentsDto, userDetails);
    }

    //댓글 조회 API
    @GetMapping("/comment/{pokemonId}")
    public List<CommentsListDto> getComments(@PathVariable Long pokemonId) {
        return commentsService.getComments(pokemonId);
    }

    //댓글 수정 API
    @PatchMapping("/comment/{commentId}")
    public String updateComments(@PathVariable Long commentId,
                                 @RequestBody CommentsDto commentsDto,
                                 @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentsService.updateComments(commentId, commentsDto, userDetails);
    }

    //댓글 삭제 API
    @DeleteMapping("/comment/{commentId}")
    public String deleteComments(@PathVariable Long commentId,
                                 @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentsService.deleteComments(commentId, userDetails);
    }

}
