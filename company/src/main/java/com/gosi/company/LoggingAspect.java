package com.gosi.company;

import com.gosi.company.departments.Department;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  @Before("execution(* com.gosi.company.departments.*.*(..))")
  public void logMethod(final JoinPoint joinPoint) {
    System.out.println(
        "Before " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
  }

  @After("execution(* com.gosi.company.departments.*.*(..))")
  public void afterLogMethod(final JoinPoint joinPoint) {
    System.out.println(
        "After " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
  }

  @Around("execution(* com.gosi.company.departments.DepartmentService.getDepartmentById(..))")
  public Object aroundLogMethod(final ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("Around " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    Object result = joinPoint.proceed();
    if (result == null){
      result = new Department(-1L, "Around", "Not found");
    }
    return result;
  }

}
