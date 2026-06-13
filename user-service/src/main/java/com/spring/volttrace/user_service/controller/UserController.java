package com.spring.volttrace.user_service.controller;


import com.spring.volttrace.user_service.dto.UserDTO;
import com.spring.volttrace.user_service.response.ApiResponse;
import com.spring.volttrace.user_service.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<ApiResponse> createUserHandler(@RequestBody UserDTO userDTO) {
        log.info("Received request to create user: {}", userDTO.getAddress());
        UserDTO craetedUserDTO = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        new ApiResponse(
                                "User Created Successfully",
                                craetedUserDTO,
                                HttpStatus.CREATED.value(),
                                HttpStatus.CREATED
                        )
                );
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<ApiResponse> updateUserHandler(
            @RequestBody UserDTO userDTO,
            @PathVariable String id
    ){
        UserDTO updatedUserDTO = userService.updateUser(userDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse(
                        "User Updated Successfully",
                        updatedUserDTO,
                        HttpStatus.OK.value(),
                        HttpStatus.OK
                )
        );
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<ApiResponse> getUserByIdHandler(
            @PathVariable String id
    ){
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse(
                        "User Found Successfully",
                        userDTO,
                        HttpStatus.OK.value(),
                        HttpStatus.OK
                )
        );
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<ApiResponse> deleteUserHandler(
            @PathVariable String id
    ){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse(
                        "User Deleted Successfully",
                        null,
                        HttpStatus.OK.value(),
                        HttpStatus.OK
                )
        );
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<ApiResponse> getAllUsersHandler(){
        List<UserDTO> userDTOS = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse(
                        "Users Found Successfully",
                        userDTOS,
                        HttpStatus.OK.value(),
                        HttpStatus.OK
                )
        );
    }

}
