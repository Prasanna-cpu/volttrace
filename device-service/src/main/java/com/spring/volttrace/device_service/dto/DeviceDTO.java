package com.spring.volttrace.device_service.dto;

import com.spring.volttrace.device_service.enums.DeviceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {
    private String id;
    private String name;
    private DeviceType type;
    private String location;
    private String userId;
}
