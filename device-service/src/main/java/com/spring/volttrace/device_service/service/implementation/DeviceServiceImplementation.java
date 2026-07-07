package com.spring.volttrace.device_service.service.implementation;

import com.spring.volttrace.device_service.dto.DeviceDTO;
import com.spring.volttrace.device_service.entity.Device;
import com.spring.volttrace.device_service.exceptions.ObjectNotFoundException;
import com.spring.volttrace.device_service.mapper.DeviceMapper;
import com.spring.volttrace.device_service.repository.DeviceRepository;
import com.spring.volttrace.device_service.service.abstraction.DeviceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = {Exception.class})
@Slf4j
public class DeviceServiceImplementation implements DeviceService {

    private final DeviceRepository deviceRepository;

    @Override
    public DeviceDTO createDevice(DeviceDTO deviceDTO) {
        Device device = DeviceMapper.mapToDevice(deviceDTO);
        Device savedDevice = deviceRepository.save(device);
        DeviceDTO savedDeviceDTO = DeviceMapper.mapToDeviceDTO(savedDevice);
        return savedDeviceDTO;
    }

    @Override
    public DeviceDTO updateDevice(DeviceDTO deviceDTO, String id) {
        Device device = deviceRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Device not found with id: " + id));
        DeviceMapper.updateDeviceFromDeviceDTO(device, deviceDTO);
        Device updatedDevice = deviceRepository.save(device);
        DeviceDTO updatedDeviceDTO = DeviceMapper.mapToDeviceDTO(updatedDevice);
        return updatedDeviceDTO;
    }

    @Override
    public void deleteDevice(String id) {
        deviceRepository.findById(id)
                .ifPresentOrElse(deviceRepository::delete, () -> {
                    throw new ObjectNotFoundException("Device not found with id: " + id);
                });
    }

    @Override
    public DeviceDTO getDeviceById(String id) {
        Device device = deviceRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Device not found with id: " + id));
        DeviceDTO deviceDTO = DeviceMapper.mapToDeviceDTO(device);
        return deviceDTO;
    }

    @Override
    public List<DeviceDTO> getAllDevices() {
        List<Device> devices = deviceRepository.findAll();
        List<DeviceDTO> deviceDTOS = devices
                .stream()
                .map(DeviceMapper::mapToDeviceDTO)
                .toList();
        return deviceDTOS;
    }

    @Override
    public List<DeviceDTO> getDevicesByUserId(String userId) {
        List<Device> devices = deviceRepository.getDevicesByUserId(userId);
        List<DeviceDTO> deviceDTOS = devices
                .stream()
                .map(DeviceMapper::mapToDeviceDTO)
                .toList();
        return deviceDTOS;
    }
}
