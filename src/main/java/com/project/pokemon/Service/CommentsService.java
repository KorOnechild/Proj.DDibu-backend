package com.project.pokemon.Service;

import com.project.pokemon.model.dto.requestDto.CommentsDto;
import com.project.pokemon.model.repository.CommentsRepository;
import com.project.pokemon.model.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public List<CommentsDto> getComments(Long pokemonId) {
        commentsRepository.findAllById(pokemonId);
    }
}
