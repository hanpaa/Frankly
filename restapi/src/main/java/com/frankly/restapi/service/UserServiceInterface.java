package com.frankly.restapi.service;

import com.frankly.restapi.domain.UserDTO;
import com.frankly.restapi.domain.UserRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceInterface {

    public void joinUser(UserDTO userDTO) throws Exception;

    public void loginUser(UserDTO userDTO) throws Exception;

    public ResponseEntity<?> logoutUser(UserRequestDTO.Logout logout) throws Exception;

    public List<UserDTO> userList() throws Exception;

    public UserDTO findUserByEmail(String email) throws Exception;

    public UserDTO readUser(int userID) throws Exception;

    public void updateUser(UserDTO userDTO) throws Exception;

    public void deleteUser(int userID) throws Exception;



}
