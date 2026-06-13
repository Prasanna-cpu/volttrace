package com.spring.volttrace.user_service.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotBlank(message = "Id is required")
    private String id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Surname is required")
    private String surname;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Alerting is required")
    private Boolean alerting;

    @NotBlank(message = "Energy alerting threshold is required")
    @Min(value = 0, message = "Energy alerting threshold should be greater than or equal to 0")
    private Double energyAlertingThreshold;

}
