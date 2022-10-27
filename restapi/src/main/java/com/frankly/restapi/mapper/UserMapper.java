package com.frankly.restapi.mapper;

import com.frankly.restapi.domain.JwtRequest;
import com.frankly.restapi.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author 최제현
 * @date 2021/06/30
 * mybatis 프레임워크
 * user interface
 */

@Mapper
public interface UserMapper {

    public List<UserDTO> userList() throws Exception;

    public UserDTO getUserByEmail(String email) throws Exception;

    public void createUser(UserDTO userDTO) throws Exception;

    public UserDTO readUser(int userID) throws Exception;

    public void updateUser(UserDTO userDTO) throws Exception;

    public void deleteUser(int userID) throws Exception;

}
