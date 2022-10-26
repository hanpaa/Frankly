package com.frankly.restapi.service;

import com.frankly.restapi.Exception.LoginFailedException;
import com.frankly.restapi.config.JwtTokenUtil;
import com.frankly.restapi.domain.JwtRequest;
import com.frankly.restapi.domain.JwtResponse;
import com.frankly.restapi.domain.UserDTO;
import com.frankly.restapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserMapper userMapper;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;
    private final JwtRequest jwtRequest;
    private final JwtResponse jwtResponse;
    private final JwtTokenUtil jwtTokenUtil;
    private JwtUserDetailsService userDetailsService;


    @Override
    public void registerUser(UserDTO userDTO) throws Exception {

        String password = userDTO.getPassword();
        String encryptedpassword = passwordEncoder.encode(password);
        userDTO.setPassword(encryptedpassword);

        userMapper.createUser(userDTO);
    }

    @Override
    public UserDTO getUser(int userID) throws Exception {
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

    @Override
    public List<UserDTO> userList() throws Exception {
        return userMapper.userList();
    }

    @Override
    public void loginUser(UserDTO userDTO) throws Exception {

        userMapper.getUserByEmail(jwtRequest.getEmail());

        if (!passwordEncoder.matches(jwtRequest.getPassword(), userDTO.getPassword())) {
            throw new LoginFailedException("잘못된 비밀번호입니다");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getEmail());
        String token = jwtTokenUtil.generateToken(userDetails);
    }
}
