package com.spring.volttrace.device_service.controller;

import com.spring.volttrace.device_service.dto.DeviceDTO;
import com.spring.volttrace.device_service.response.ApiResponse;
import com.spring.volttrace.device_service.service.abstraction.DeviceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/devices")
@Slf4j
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping("/create-device")
    public ResponseEntity<ApiResponse> createDeviceHandler(@RequestBody DeviceDTO deviceDTO){
        DeviceDTO savedDeviceDTO = deviceService.createDevice(deviceDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        new ApiResponse(
                                "Device created successfully",
                                savedDeviceDTO,
                                HttpStatus.CREATED.value(),
                                HttpStatus.CREATED
                        )
                );
    }

    @PutMapping("/update-device/{id}")
    public ResponseEntity<ApiResponse> updateDeviceHandler(@RequestBody DeviceDTO deviceDTO, @PathVariable String id){
        DeviceDTO updatedDeviceDTO = deviceService.updateDevice(deviceDTO, id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        new ApiResponse(
                                "Device updated successfully",
                                updatedDeviceDTO,
                                HttpStatus.OK.value(),
                                HttpStatus.OK
                        )
                );
    }

    @DeleteMapping("/delete-device/{id}")
    public ResponseEntity<ApiResponse> deleteDeviceHandler(@PathVariable String id){
        deviceService.deleteDevice(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        new ApiResponse(
                                "Device deleted successfully",
                                null,
                                HttpStatus.OK.value(),
                                HttpStatus.OK
                        )
                );
    }

    @GetMapping("/device/{id}")
    public ResponseEntity<ApiResponse> getDeviceByIdHandler(@PathVariable String id){
        DeviceDTO deviceDTO = deviceService.getDeviceById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        new ApiResponse(
                                "Device retrieved successfully",
                                deviceDTO,
                                HttpStatus.OK.value(),
                                HttpStatus.OK
                        )
                );
    }

    @GetMapping("/all-devices")
    public ResponseEntity<ApiResponse> getAllDevicesHandler(){
        List<DeviceDTO> deviceDTOS = deviceService.getAllDevices();
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        new ApiResponse(
                                "All devices retrieved successfully",
                                deviceDTOS,
                                HttpStatus.OK.value(),
                                HttpStatus.OK
                        )
                );
    }

    @GetMapping("/devices-by-user/user/{userId}")
    public ResponseEntity<ApiResponse> getDevicesByUserIdHandler(@PathVariable String userId){
        List<DeviceDTO> deviceDTOS = deviceService.getDevicesByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        new ApiResponse(
                                "Devices retrieved successfully",
                                deviceDTOS,
                                HttpStatus.OK.value(),
                                HttpStatus.OK
                        )
                );
    }
}
