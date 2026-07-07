CREATE TABLE IF NOT EXISTS devices (
                   id VARCHAR(255) NOT NULL PRIMARY KEY ,
                   name VARCHAR(255) NOT NULL,
                   type ENUM('SPEAKER', 'CAMERA', 'THERMOSTAT', 'LIGHT', 'LOCK', 'DOORBELL', 'TELEVISION', 'AIR_CONDITIONER', 'REFRIGERATOR', 'WASHING_MACHINE') NOT NULL,
                   location VARCHAR(255) NOT NULL,
                   user_id VARCHAR(255) NOT NULL,

                   created_at DATETIME(6),
                   created_by VARCHAR(255),
                   updated_at DATETIME(6),


                   KEY `idx_device_user_id` (`user_id`),
                   CONSTRAINT `fk_device_user`
                       FOREIGN KEY (`user_id`) REFERENCES users (`id`)
                           ON DELETE CASCADE

)