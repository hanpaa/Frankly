package com.frankly.restapi.service;

import com.frankly.restapi.config.JwtTokenProvider;
import com.frankly.restapi.domain.ResponseDTO;
import com.frankly.restapi.domain.UserDTO;
import com.frankly.restapi.domain.UserRequestDTO;
import com.frankly.restapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final RedisTemplate redisTemplate;
    private final ResponseDTO responseDTO;

    @Override
    public void joinUser(UserDTO userDTO) throws Exception {

        String password = userDTO.getPassword();
        String encryptedpassword = passwordEncoder.encode(password);
        userDTO.setPassword(encryptedpassword);

        userMapper.joinUser(userDTO);
    }

    @Override
    public void loginUser(UserDTO userDTO) throws Exception {
        userMapper.loginUser(userDTO);
    }
    public ResponseEntity<?> logoutUser(UserRequestDTO.Logout logout) throws Exception {
        // 1. Access Token 검증
        if (!jwtTokenProvider.validateToken(logout.getAccessToken())) {
            return responseDTO.fail("잘못된 요청입니다.", HttpStatus.BAD_REQUEST);
        }

        // 2. Access Token 에서 User email 을 가져옵니다.
        Authentication authentication = jwtTokenProvider.getAuthentication(logout.getAccessToken());

        // 3. Redis 에서 해당 User email 로 저장된 Refresh Token 이 있는지 여부를 확인 후 있을 경우 삭제합니다.
        if (redisTemplate.opsForValue().get("RT:" + authentication.getName()) != null) {
            // Refresh Token 삭제
            redisTemplate.delete("RT:" + authentication.getName());
        }

        // 4. 해당 Access Token 유효시간 가지고 와서 BlackList 로 저장하기
        Long expiration = jwtTokenProvider.getExpiration(logout.getAccessToken());
        redisTemplate.opsForValue()
                .set(logout.getAccessToken(), "logout", expiration, TimeUnit.MILLISECONDS);

        return responseDTO.success("로그아웃 되었습니다.");
    }

    @Override
    public List<UserDTO> userList() throws Exception {
        return userMapper.userList();
    }

    @Override
    public UserDTO findUserByEmail(String email) throws Exception {
        return userMapper.findUserByEmail(email);
    }

    @Override
    public UserDTO readUser(int userID) throws Exception {
        return userMapper.readUser(userID);
    }

    @Override
    public void updateUser(UserDTO userDTO) throws Exception {
        userMapper.updateUser(userDTO);
    }

    @Override
    public void deleteUser(int userID) throws Exception {
        userMapper.deleteUser(userID);

    }




}
