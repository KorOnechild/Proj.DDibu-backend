package com.project.pokemon.Service;

import com.project.pokemon.model.dto.SignupDto;
import com.project.pokemon.model.entity.Users;
import com.project.pokemon.model.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(SignupDto Dto) {
        // 회원 ID 중복 확인
        String nickname = Dto.getNickname();
        Optional<Users> found = userRepository.findByNickname(nickname);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 닉네임이 존재합니다.");
        }

        String email = Dto.getEmail();
        Optional<Users> found2 = userRepository.findByEmail(email);
        if (found2.isPresent()) {
            try {
                throw new IllegalAccessException("중복된 사용자 ID 가 존재합니다.");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        // 패스워드 암호화
        String password = passwordEncoder.encode(Dto.getPassword());

        Users user = new Users(email, nickname, password);
        System.out.println(Dto.getEmail());
        System.out.println(Dto.getNickname());
        userRepository.save(user);
    }

    public Boolean checkEmailDuplicate(String email) {
        Users user = userRepository.findByEmail(email).orElse(null);

        try {
            if (user.getEmail().equals(email)) {
                return false;
            }
        } catch (NullPointerException e) {
            return true;
        }
        return true;
    }

    public Boolean checkNameDuplicate(String nickname) {
        Users user = userRepository.findByNickname(nickname).orElse(null);

        try {
            if (user.getNickname().equals(nickname)) {
                return false;
            }
        } catch (NullPointerException e) {
            return true;
        }
        return true;
    }

}
