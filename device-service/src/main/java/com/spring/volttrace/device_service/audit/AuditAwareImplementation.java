package com.spring.volttrace.device_service.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImplementation")
public class AuditAwareImplementation implements AuditorAware {
    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("DEVICE-SERVICE");
    }
}
