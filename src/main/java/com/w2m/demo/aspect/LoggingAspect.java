package com.w2m.demo.aspect;

import java.util.Arrays;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

  @Before("execution(* com.w2m.demo.controller.ShipsController.findShipById(..))")
  public void negativeIdLog(JoinPoint joinPoint) {
    final Long id = (Long) Arrays.stream(joinPoint.getArgs()).collect(Collectors.toList()).get(0);
    if (id < 0) {
      log.info("Error processing a negative id");
    }
  }

}
