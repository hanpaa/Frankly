package com.frankly.restapi.mapper;

import com.frankly.restapi.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;


/**
 * @author 최제현
 * @date 2021/06/30
 * mybatis 프레임워크
 * user interface
 */

@Mapper
public interface UserMapper {

    public void joinUser(UserDTO userDTO) throws Exception;

    public void loginUser(UserDTO userDTO) throws Exception;

    public void logoutUser(UserDTO userDTO) throws Exception;

    Optional<UserDTO> findByEmail(String email);

    boolean existsByEmail(String email);

    public List<UserDTO> userList() throws Exception;

    public UserDTO findUserByEmail(String email) throws Exception;

    public UserDTO readUser(int userID) throws Exception;

    public void updateUser(UserDTO userDTO) throws Exception;

    public void deleteUser(int userID) throws Exception;
}
