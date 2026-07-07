package com.spring.volttrace.device_service.service.abstraction;

import com.spring.volttrace.device_service.dto.DeviceDTO;

import java.util.List;

public interface DeviceService {
    DeviceDTO createDevice(DeviceDTO deviceDTO);
    DeviceDTO updateDevice(DeviceDTO deviceDTO, String id);
    void deleteDevice(String id);
    DeviceDTO getDeviceById(String id);
    List<DeviceDTO> getAllDevices();
    List<DeviceDTO> getDevicesByUserId(String userId);
}
