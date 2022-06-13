package com.project.pokemon.Service;

import com.project.pokemon.model.dto.ResponseDto;
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

    public ResponseDto registerUser(SignupDto Dto) {
        Boolean result = true;
        String err_msg = "사용 가능한 ID 입니다.";
        String email = Dto.getEmail();
        String nickname = Dto.getNickname();

        Optional<Users> foundemail = userRepository.findByEmail(email);
        Optional<Users> foundnickname = userRepository.findByNickname(nickname);

        // 회원 ID 중복 확인
        if (foundemail.isPresent()) {
            err_msg = "중복된 사용자 ID가 존재합니다.";
            result = false;
            return new ResponseDto(result, err_msg, email);
        }

        if (foundnickname.isPresent()) {
            err_msg = "중복된 닉네임이 존재합니다.";
            result = false;
            return new ResponseDto(result, err_msg, nickname);
        }

        // 패스워드 암호화
        String password = passwordEncoder.encode(Dto.getPassword());

        Users user = new Users(email, nickname, password);
        System.out.println(Dto.getEmail());
        System.out.println(Dto.getNickname());
        userRepository.save(user);

        ResponseDto responseDto = new ResponseDto(result,err_msg,nickname);
        return responseDto;
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
