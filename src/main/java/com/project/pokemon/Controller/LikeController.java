package com.project.pokemon.Controller;

import com.project.pokemon.security.Service.LikeService;
import com.project.pokemon.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LikeController {

    private final LikeService likeService;

    @PostMapping("like/{pokemonId}")
    public void uplike(@AuthenticationPrincipal UserDetailsImpl userDetails,
                       @PathVariable Long pokemonId,
                       String behavior){
        likeService.uplike(userDetails, pokemonId, behavior);
    }
}
