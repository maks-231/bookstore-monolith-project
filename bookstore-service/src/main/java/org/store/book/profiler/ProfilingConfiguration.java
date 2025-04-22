package org.store.book.profiler;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ProfilingConfiguration {
    @Pointcut("execution(* org.store.book.controller..*.*(..))")
    public void monitor() { }

    @Bean
    public PerformanceMonitorInterceptor interceptor() {
        return new PerformanceMonitorInterceptor();
    }

    @Bean
    public Advisor performanceMonitorAdvisor() {
        var pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("org.store.book.profiler.ProfilingConfiguration.monitor()");
        return new DefaultPointcutAdvisor(pointcut, new CustomPerformanceMonitorInterceptor());
    }
}
