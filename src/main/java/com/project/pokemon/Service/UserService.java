package com.project.pokemon.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.project.pokemon.model.dto.requestDto.SignInDto;
import com.project.pokemon.model.dto.requestDto.SignupDto;
import com.project.pokemon.model.dto.responseDto.UserLoginRespDto;
import com.project.pokemon.model.dto.responseDto.UserRegisterRespDto;
import com.project.pokemon.model.dto.responseDto.UserTokenRespDto;
import com.project.pokemon.model.entity.Users;
import com.project.pokemon.model.repository.UserRepository;
import com.project.pokemon.security.SHA256;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserTokenRespDto tokenTest(String token)
    {
        DecodedJWT jwt;

        try {
            jwt = JWT.decode(token);
        } catch (JWTVerificationException exception){
            return new UserTokenRespDto(false, "토큰이 유효하지 않습니다.");
        }

        System.out.println(jwt.getClaim("id"));
        System.out.println(jwt.getClaim("email"));
        System.out.println(jwt.getClaim("nickname"));

        return new UserTokenRespDto(true, jwt.getPayload(), "토큰 해석 성공");
    }


    public UserLoginRespDto loginUser(SignInDto Dto) throws NoSuchAlgorithmException {
        Boolean result = true;
        String errMsg = "로그인 성공";
        String token = "";

        String email = Dto.getEmail();
        String pw = Dto.getPassword();
        String pwSHA256 = SHA256.encrypt(pw);

        Optional<Users> user = userRepository.findByEmailAndPassword(email, pwSHA256);

        if(!user.isPresent()) {
            errMsg = "아이디 또는 비밀번호가 틀렸습니다.";
            result = false;
            return new UserLoginRespDto(result, errMsg);
        }

        try {
            // secret 키 노출되면 안돼서, secret.json 파일로 빼서 gitignore 파일에 secret.json 을 추가하는 식으로 막음
            // 테스트니까 그냥 아무 키 값 사용 하였음
            Algorithm algorithm = Algorithm.HMAC256("rlaalswnrkgoTdma");
            token = JWT.create()
                    .withIssuer("gkdgo99")
                    .withClaim("id", user.get().getId())
                    .withClaim("email", user.get().getEmail())
                    .withClaim("nickname", user.get().getNickname())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            errMsg = "토큰 생성에 실패 하였습니다.";
            result = false;
            return new UserLoginRespDto(result, errMsg);
        }

        return new UserLoginRespDto(result, token, errMsg);
    }

    public UserRegisterRespDto registerUser(SignupDto Dto) throws NoSuchAlgorithmException {
        Boolean result = true;
        String err_msg = "회원가입 성공";
        String email = Dto.getEmail();
        String nickname = Dto.getNickname();

        Optional<Users> foundemail = userRepository.findByEmail(email);
        Optional<Users> foundnickname = userRepository.findByNickname(nickname);

        // 회원 ID 중복 확인
        if (foundemail.isPresent()) {
            err_msg = "중복된 사용자 ID가 존재합니다.";
            result = false;
            return new UserRegisterRespDto(result, err_msg);
        }

        // 회원 닉네임 중복 확인
        if (foundnickname.isPresent()) {
            err_msg = "중복된 닉네임이 존재합니다.";
            result = false;
            return new UserRegisterRespDto(result, err_msg);
        }

        // 패스워드 암호화
        String password = SHA256.encrypt(Dto.getPassword());

        Users user = new Users(email, nickname, password);
        System.out.println(Dto.getEmail());
        System.out.println(Dto.getNickname());
        userRepository.save(user);

        UserRegisterRespDto responseDto = new UserRegisterRespDto(result, err_msg);
        return responseDto;
    }



    // Email 중복 확인
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

    // 닉네임 중복 확인
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
