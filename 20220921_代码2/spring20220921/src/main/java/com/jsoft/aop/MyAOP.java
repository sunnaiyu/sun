package com.jsoft.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
* 通知类，我要让目标方法在执行前后各执行一个方法
* */
@Component
@Aspect
public class MyAOP {

    @Before("execution(* com.jsoft.service.impl.*.*(..))")
//    @Before("@annotation(com.jsoft.annotation.MyLog)")
    public void before(JoinPoint joinPoint) {
        System.out.println("执行方法之前打印一条日志！");
        // 获取目标方法的参数们
        Object[] args = joinPoint.getArgs();
        // 调用目标方法的那个对象
        Object aThis = joinPoint.getThis();
        // 代理对象
        Object target = joinPoint.getTarget();
    }
//    @After("execution(* com.jsoft.service.impl.*.*(..))")
    public void after() {
        System.out.println("执行方法之后打印一条日志！");
    }
//    @AfterThrowing(value = "execution(* com.jsoft.service.impl.*.*(..))",throwing = "e")
    public void throwing(JoinPoint joinPoint,Throwable e) {
        System.out.println("出现了异常...");
        // 获取到异常信息
        System.out.println(e.getMessage());
        // 获取到异常类型
        System.out.println(e.getClass());
    }
//    @AfterReturning(value = "execution(* com.jsoft.service.impl.*.*(..))",returning = "result")
    public void returning(JoinPoint joinPoint,Object result) {
        System.out.println("正常的返回结果...");
        // 方法的返回值
        System.out.println(result);
    }

//    @Around("execution(* com.jsoft.service.impl.*.*(..))")
    public void around(ProceedingJoinPoint joinPoint) {

        System.out.println("before...");
        try {
            // 执行目标方法
            Object o = joinPoint.proceed();
            System.out.println(o);
            System.out.println("returning...");
        }catch (Throwable e){
            System.out.println("throwing...");
        }
        System.out.println("after...");
    }
}
