package com.project.pokemon.Controller;

import com.project.pokemon.Service.LikeService;
import com.project.pokemon.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class LikeController {

    private final LikeService likeService;

    @GetMapping("like/{pokemonId}")
    public void uplike(@AuthenticationPrincipal UserDetailsImpl userDetails,
                       @PathVariable Long pokemonId,
                       String behavior){
        likeService.uplike(userDetails, pokemonId, behavior);
    }
}
