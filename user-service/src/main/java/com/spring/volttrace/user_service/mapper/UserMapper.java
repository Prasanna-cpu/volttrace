package com.spring.volttrace.user_service.mapper;

import com.spring.volttrace.user_service.dto.UserDTO;
import com.spring.volttrace.user_service.entity.User;

public class UserMapper {

    public static UserDTO mapToUserDTO(User user) {

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setAddress(user.getAddress());
        userDTO.setAlerting(user.getAlerting());
        userDTO.setEnergyAlertingThreshold(user.getEnergyAlertingThreshold());

        return userDTO;

    }

    public static User mapToUser(UserDTO userDTO) {

        User user = new User();

        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());
        user.setAlerting(userDTO.getAlerting());
        user.setEnergyAlertingThreshold(userDTO.getEnergyAlertingThreshold());

        return user;

    }

    public static void updateUserFromUserDTO(User user, UserDTO userDTO){

        if(userDTO.getName() != null) {
            user.setName(userDTO.getName());
        }

        if(userDTO.getSurname() != null) {
            user.setSurname(userDTO.getSurname());
        }

        if(userDTO.getEmail() != null){
            user.setEmail(userDTO.getEmail());
        }

        if(userDTO.getAddress() != null) {
            user.setAddress(userDTO.getAddress());
        }

        if(userDTO.getAlerting() != null) {
            user.setAlerting(userDTO.getAlerting());
        }

        if(userDTO.getEnergyAlertingThreshold() != null) {
            user.setEnergyAlertingThreshold(userDTO.getEnergyAlertingThreshold());
        }

    }

}
