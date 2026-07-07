package com.spring.volttrace.device_service;

import com.spring.volttrace.device_service.entity.Device;
import com.spring.volttrace.device_service.enums.DeviceType;
import com.spring.volttrace.device_service.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
class DeviceServiceApplicationTests {

	private final DeviceRepository deviceRepository;

	public static final Integer NO_OF_DEVICES = 150;

	@Test
	void contextLoads() {
	}

	@Test
	void createDevices(){
		for(int i = 1; i < NO_OF_DEVICES; i++){
			var device = new Device();
			device.setName("Device" + i);
			device.setType(DeviceType.values()[i % DeviceType.values().length]);
			device.setLocation("Location" + ((i % 3) + 1));
			device.setUserId("Id " + ((i % 10) + 1));
			deviceRepository.save(device);
		}
		log.info("Created {} devices", NO_OF_DEVICES - 1);
	}


}
