package com.avinay.onlineticketreservation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*
        Pointcut that matches all repositories, services and web rest endpoints
    */
    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
        " || within(@org.springframework.stereotype.Service *)" +
        " || within(@org.springframework.web.bind.annotation.RestController *)" +
        "|| within(@org.springframework.stereotype.Controller *)")
    public void springBeanPointCut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advice
    }

    @Pointcut("within(com.avinay.onlineticketreservation.controller..*)" +
        " || within(com.avinay.onlineticketreservation.service..*)")
    public void applicationPackagePointCut() {
        // implementations in the advice
    }

    /*
        Advice that logs methods throwing exceptions

        @param joinPoint join point for advice
        @param e exception
    */
    @AfterThrowing(pointcut = "applicationPackagePointCut() && springBeanPointCut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        logger.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringType(),
                joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
    }

    /*
        Advice that logs when a method is entered and exited

        @param joinPoint join point for advice
        @return result
        @throws Throwable throws IllegalArgumentException
    */
    @Around("applicationPackagePointCut() && springBeanPointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        if (logger.isDebugEnabled()) {
            logger.debug("Enter: {}.{}() with argument(s): {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        }

        try {
            Object result = joinPoint.proceed();
            if (logger.isDebugEnabled()) {
                logger.debug("Exit: {}.{}() with result: {}", joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(), result);
            }
            return result;
        } catch (IllegalArgumentException e) {
            logger.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
            throw e;
        }
    }

}
