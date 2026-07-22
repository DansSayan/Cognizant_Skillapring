package com.library.aspect;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {

    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[AOP BEFORE] Entering method: " + joinPoint.getSignature().getName());
    }

    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[AOP AFTER] Exiting method: " + joinPoint.getSignature().getName());
    }
}