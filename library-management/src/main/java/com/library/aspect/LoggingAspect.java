package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed(); 
        
        long executionTime = System.currentTimeMillis() - start; 

        System.out.println("[AOP TIMER] " + joinPoint.getSignature().getName() + " executed in " + executionTime + "ms");
        
        return result;
    }
}