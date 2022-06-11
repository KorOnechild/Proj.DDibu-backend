package com.project.pokemon.Service;

import com.project.pokemon.model.dto.SignupDto;
import com.project.pokemon.model.entity.Users;
import com.project.pokemon.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(SignupDto dto) {
        String email = dto.getEmail();
        String nickname = dto.getNickname();
        String password = dto.getPassword();

        Users user = new Users(email, nickname, password);
        userRepository.save(user);
    }

}
