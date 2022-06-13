package com.project.pokemon.model.repository;

import com.project.pokemon.model.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserAndPokemon(Long userId, Long pokemonId);
    List<Like> findAllByPokemon(Long pokemonId);
}
