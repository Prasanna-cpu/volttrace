package com.spring.volttrace.device_service.repository;


import com.spring.volttrace.device_service.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {

    @Query("SELECT d FROM Device d WHERE d.userId = :userId")
    List<Device> getDevicesByUserId(String userId);

}
