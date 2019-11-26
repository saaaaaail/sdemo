package com.example.sdemo.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OnePageAspect {

    @Pointcut(value = "execution(* com.example.sdemo.controller.*.*(..))")
    public void apiMethods() {
    }

    @Around("apiMethods() && (args(..,pageable))")
    public Object around(ProceedingJoinPoint joinPoint, Pageable pageable) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Pageable) {
                args[i] = new PageRequest(pageable.getPageNumber() > 0 ? pageable.getPageNumber() - 1 : 0, pageable.getPageSize(),
                        pageable.getSort());
            }
        }
        return joinPoint.proceed(args);
    }
}
