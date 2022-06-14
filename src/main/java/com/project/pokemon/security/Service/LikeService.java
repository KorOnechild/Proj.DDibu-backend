package com.project.pokemon.security.Service;

import com.project.pokemon.model.entity.Likes;
import com.project.pokemon.model.entity.Pokemon;
import com.project.pokemon.model.entity.Users;
import com.project.pokemon.model.repository.LikeRepository;
import com.project.pokemon.model.repository.PokemonRepository;
import com.project.pokemon.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final PokemonRepository pokemonRepository;
    private final LikeRepository likeRepository;

    @Transactional
    public void uplike(UserDetailsImpl userDetails,
                       Long pokemonId, String behavior) {

        Users user = userDetails.getUser();
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(
                () -> new IllegalArgumentException("해당 포켓몬이 존재하지 않습니다.")
        );

        Likes like = new Likes(user, pokemon);

        if(behavior.equals("like")){
            likeRepository.save(like);
        }else if(behavior.equals("unlike")){
            likeRepository.delete(like);
        }

        Long count = (long) likeRepository.findAllByPokemon(pokemonId).size();
        pokemon.setLikesCnt(count);
    }
}
