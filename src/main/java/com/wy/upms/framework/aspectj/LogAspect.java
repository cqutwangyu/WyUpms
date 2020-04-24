package com.wy.upms.framework.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author wangyu
 * @title: LogAspect
 * @projectName WyUpms
 * @description: TODO
 * @date 2020/4/21 15:31
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 配置切入点
     */
    @Pointcut("@annotation(com.wy.upms.framework.aspectj.lang.annotation.Log)")
    public void logPointCut()
    {
    }
}
