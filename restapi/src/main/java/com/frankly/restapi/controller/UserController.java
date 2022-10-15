package com.frankly.restapi.controller;


import com.frankly.restapi.config.JwtTokenProvider;
import com.frankly.restapi.domain.ResponseDTO;
import com.frankly.restapi.domain.UserDTO;
import com.frankly.restapi.domain.UserRequestDTO;
import com.frankly.restapi.service.UserService;
import com.frankly.restapi.service.Helper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final ResponseDTO responseDTO;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> join(@Validated @RequestBody UserDTO userDTO)
            throws Exception{
        log.info("create User " + userDTO.getEmail());

        userService.joinUser(userDTO);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }


    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@Validated @RequestBody UserDTO userDTO)
            throws Exception{
        log.info("login User " + userDTO.getEmail());

        userService.loginUser(userDTO);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@Validated UserRequestDTO.Logout logout, Errors errors) throws Exception {
        // validation check
        if (errors.hasErrors()) {
            return responseDTO.invalidFields(Helper.refineErrors(errors));
        }
        return userService.logoutUser(logout);
    }


    //관리자 권한
    @GetMapping ("/list")
    public ResponseEntity<List<UserDTO>> userList()
            throws Exception {
        log.info("User List");

        return new ResponseEntity<>(userService.userList(), HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<?> readUser(@PathVariable("userID") int userID)
            throws Exception{
        log.info("read user : " + userID);

        userService.readUser(userID);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@Validated @RequestBody UserDTO userDTO)
            throws Exception{
        log.info("update User " + userDTO.getName());

        userService.updateUser(userDTO);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@PathVariable("userID")int userID)
            throws Exception{
        log.info("delete user : " + userID);

        userService.deleteUser(userID);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}