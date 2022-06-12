package com.project.pokemon.Service;

import com.project.pokemon.model.dto.requestDto.CommentsDto;
import com.project.pokemon.model.dto.responseDto.CommentsListDto;
import com.project.pokemon.model.entity.Comments;
import com.project.pokemon.model.repository.CommentsRepository;
import com.project.pokemon.model.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;
    private final PokemonRepository pokemonRepository;

    //댓글 작성 로직
    public String createComments(CommentsDto commentsDto) {
        pokemonRepository.findById(commentsDto.getPokemonId()).orElseThrow(
                ()-> new IllegalArgumentException("해당 포켓몬이 없습니다.")
        );
        commentsRepository.save(commentsDto);
        return "댓글이 작성되었습니다.";
    }

    //댓글 조회 로직
    public List<CommentsListDto> getComments(Long pokemonId) {
        List<Comments> commentsList = commentsRepository.findAllById(pokemonId);

        return createResponse(commentsList);
    }

    //댓글 수정 로직
    @Transactional
    public String updateComments(Long commentId, String newcomments) {
        Comments comments = commentsRepository.findById(commentId).orElseThrow(
                ()-> new NullPointerException("해당 댓글이 없거나 삭제되었습니다.")
        );
        comments.setComments(newcomments);
        commentsRepository.save(comments);
        return "댓글이 수정되었습니다.";
    }


    /*CommentsService에서 필요한 메서드 정의*/

    //댓글 ResponseDto 생성함수
    private List<CommentsListDto> createResponse(List<Comments> commentsList) {
        List<CommentsListDto> commentsListDtos = new ArrayList<>();

        for(Comments comments : commentsList){
            CommentsListDto commentsListDto = new CommentsListDto();
            commentsListDto.setComments(comments.getComments());
            commentsListDto.setNickname(comments.getUsers().getNickname());
            commentsListDto.setCreatedAt(comments.getCreatedAt());
            commentsListDtos.add(commentsListDto);
        }

        return commentsListDtos;
    }


}
