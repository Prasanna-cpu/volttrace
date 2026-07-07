package com.spring.volttrace.device_service.mapper;

import com.spring.volttrace.device_service.dto.DeviceDTO;
import com.spring.volttrace.device_service.entity.Device;

public class DeviceMapper {

    public static DeviceDTO mapToDeviceDTO(Device device) {
        DeviceDTO deviceDTO = new DeviceDTO();

        deviceDTO.setId(device.getId());
        deviceDTO.setName(device.getName());
        deviceDTO.setType(device.getType());
        deviceDTO.setLocation(device.getLocation());
        deviceDTO.setUserId(device.getUserId());

        return deviceDTO;
    }

    public static Device mapToDevice(DeviceDTO deviceDTO){
        Device device = new Device();

        device.setName(deviceDTO.getName());
        device.setType(deviceDTO.getType());
        device.setLocation(deviceDTO.getLocation());
        device.setUserId(deviceDTO.getUserId());

        return device;
    }

    public static void updateDeviceFromDeviceDTO(Device device, DeviceDTO deviceDTO){
        if(deviceDTO.getName() != null) {
            device.setName(deviceDTO.getName());
        }

        if(deviceDTO.getType() != null) {
            device.setType(deviceDTO.getType());
        }

        if(deviceDTO.getLocation() != null) {
            device.setLocation(deviceDTO.getLocation());
        }

        if(deviceDTO.getUserId() != null) {
            device.setUserId(deviceDTO.getUserId());
        }
    }

}
