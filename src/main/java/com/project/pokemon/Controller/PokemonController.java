package com.project.pokemon.Controller;

import com.project.pokemon.security.Service.PokemonService;
import com.project.pokemon.model.dto.requestDto.SearchDto;
import com.project.pokemon.model.entity.Pokemon;
import com.project.pokemon.model.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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
            return pokemonService.load();
        }

        //디테일페이지 로드
        @Controller
        class DetailViewController {

            @GetMapping("/detail/{pokemonId}")
            public Pokemon detail(@PathVariable Long pokemonIdid) {
             return pokemonService.detail(pokemonIdid);
            }
        }
        //포켓몬 크롤링
        @GetMapping("/data")
        public String upload() throws IOException {
            return pokemonService.data();
        }
        // 포켓몬 검색기능
        @ResponseBody
        @PostMapping("/search")
        public Pokemon search(@RequestBody SearchDto searchDto) {
            return pokemonService.search(searchDto);


        }
    }
}