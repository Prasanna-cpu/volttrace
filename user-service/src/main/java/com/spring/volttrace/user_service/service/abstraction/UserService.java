package com.spring.volttrace.user_service.service.abstraction;

import com.spring.volttrace.user_service.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO, String id);

    UserDTO getUserById(String id);

    void deleteUser(String id);

    List<UserDTO> getAllUsers();


}
