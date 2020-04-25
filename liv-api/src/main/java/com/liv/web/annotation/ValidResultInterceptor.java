package com.liv.web.annotation;

import com.google.common.collect.Lists;
import com.liv.web.exception.ValidateException;
import com.liv.web.utils.LivContextUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author LiV
 * @Title:
 * @Package com.liv.web.annotation
 * @Description: 校验解决注解处理器
 * @date 2020.4.19  14:45
 * @email 453826286@qq.com
 */

@Aspect
@Component
public class ValidResultInterceptor {
    public ValidResultInterceptor() {
    }

    @Pointcut("@annotation(com.liv.web.annotation.ValidResult)")
    private void anyMethod() {
    }

    @Around("anyMethod()")
    public Object checkRequestHead(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] o = joinPoint.getArgs();
        for (Object o1 : o) {
            if(o1 instanceof BindingResult){
                BindingResult result = (BindingResult)o1;
                if(result.hasErrors()){
                    List<String> msg = Lists.newArrayList();
                    for (ObjectError error : result.getAllErrors()) {
                        msg.add(error.getDefaultMessage());
                    }
                    LivContextUtils.getRequest().setAttribute("msg",msg);
                    //交给系统处理异常
                    throw new ValidateException();
                }
            }
        }
       return joinPoint.proceed();
    }

}
