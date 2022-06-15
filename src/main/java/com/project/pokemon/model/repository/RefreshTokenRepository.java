package com.project.pokemon.model.repository;

import com.project.pokemon.model.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository  extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByAccessTokenAndRefreshToken(String accessToken, String refreshToken);
}
