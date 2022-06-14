package com.project.pokemon.model.repository;

import com.project.pokemon.model.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByUserAndPokemon(Long userId, Long pokemonId);
    List<Likes> findAllByPokemon(Long pokemonId);
}
