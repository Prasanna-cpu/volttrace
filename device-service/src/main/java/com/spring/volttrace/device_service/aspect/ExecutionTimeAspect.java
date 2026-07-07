package com.spring.volttrace.device_service.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExecutionTimeAspect {

    @Pointcut("execution(* com.spring.volttrace.device_service.controller.*.*(..))")
    public void controllerMethods(){

    }

    @Around("controllerMethods()")
    public Object measureExecutionTime(ProceedingJoinPoint pjp){

        long start = System.nanoTime();

        try{
            return pjp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            long executionTime = System.nanoTime() - start;
            log.info("Execution time of {} is {} ms", pjp.getSignature().toShortString(), executionTime / 1_000_000);
        }

    }

}
