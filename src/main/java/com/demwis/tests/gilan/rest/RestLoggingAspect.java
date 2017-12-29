package com.demwis.tests.gilan.rest;

import com.google.common.base.Stopwatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import static java.util.Optional.ofNullable;

@Aspect
public class RestLoggingAspect {
    private final static Logger DEFAULT_LOGGER = LoggerFactory.getLogger(RestLoggingAspect.class);
    private final Map<Class<?>, Logger> loggers = new ConcurrentHashMap<>();

    @Around("@target(org.springframework.web.bind.annotation.RequestMapping)")
    public Object logRestRequestWithDuration(ProceedingJoinPoint joinPoint) throws Throwable {
        Class<?> targetClass = ofNullable(joinPoint.getTarget()).map(Object::getClass).orElse(null);
        Logger logger = getLogger(targetClass);
        logger.info("{}.{} method execution started", targetClass, joinPoint.getSignature().getName());
        Stopwatch stopwatch = Stopwatch.createStarted();

        try {
            Object result = joinPoint.proceed();
            logger.info("{}.{} method execution was successful. Time consumed {}ms", targetClass,
                    joinPoint.getSignature().getName(), stopwatch.elapsed(TimeUnit.MILLISECONDS));
            return result;
        } catch (Throwable throwable) {
            logger.info("{}.{} method execution finished with error. Time consumed {}ms", targetClass,
                    joinPoint.getSignature().getName(), stopwatch.elapsed(TimeUnit.MILLISECONDS));
            throw throwable;
        }
    }

    private Logger getLogger(Class<?> clazz) {
        return ofNullable(clazz)
                .map(cl -> loggers.computeIfAbsent(cl, LoggerFactory::getLogger))
                .orElse(DEFAULT_LOGGER);
    }
}
