package com.project.pokemon.Controller;

import com.project.pokemon.Service.PokemonService;
import com.project.pokemon.model.entity.Pokemon;
import com.project.pokemon.model.repository.PokemonRepository;
import com.project.pokemon.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PokemonController {

    private final PokemonRepository pokemonRepository;
    private final PokemonService pokemonService;

    //메인페이지 로드
    @Controller
    class MainViewController {

        @GetMapping("/")
        public List<Pokemon> main() {
            return pokemonRepository.findAllByOrderByID();
        }

        //디테일페이지 로드
        @Controller
        class DetailViewController {

            @GetMapping("/detail/{pokemonId}")
            public Pokemon detail(@PathVariable Long pokemonIdid) {
             return pokemonRepository.findById(pokemonIdid).orElseThrow(
                     ()-> new IllegalArgumentException("존재하지않는 포켓몬입니다!")
             );
            }
        }

    }
}