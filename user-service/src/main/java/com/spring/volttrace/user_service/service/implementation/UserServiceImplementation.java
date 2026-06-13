package com.spring.volttrace.user_service.service.implementation;

import com.spring.volttrace.user_service.dto.UserDTO;
import com.spring.volttrace.user_service.entity.User;
import com.spring.volttrace.user_service.exception.ObjectNotFoundException;
import com.spring.volttrace.user_service.mapper.UserMapper;
import com.spring.volttrace.user_service.repository.UserRepository;
import com.spring.volttrace.user_service.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = {Exception.class, ObjectNotFoundException.class})
@Slf4j
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = UserMapper.mapToUser(userDTO);
        User savedUser = userRepository.save(user);
        UserDTO savedUserDTO = UserMapper.mapToUserDTO(savedUser);
        return savedUserDTO;

    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, String id) {

        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found with id: " + id));

        UserMapper.updateUserFromUserDTO(user, userDTO);
        User updatedUser = userRepository.save(user);
        UserDTO updatedUserDTO = UserMapper.mapToUserDTO(updatedUser);
        return updatedUserDTO;

    }

    @Override
    public UserDTO getUserById(String id) {

        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found with id: " + id));

        UserDTO userDTO = UserMapper.mapToUserDTO(user);

        return userDTO;

    }

    @Override
    public void deleteUser(String id) {

        userRepository.findById(id)
                .ifPresentOrElse(userRepository::delete, () -> {
                    throw new ObjectNotFoundException("User not found with id: " + id);
                });

    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = users.stream()
                .map(UserMapper::mapToUserDTO)
                .toList();
        return userDTOS;
    }
}
