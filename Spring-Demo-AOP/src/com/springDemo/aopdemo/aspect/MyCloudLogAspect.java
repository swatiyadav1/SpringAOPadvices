package com.springDemo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {

	
	@Pointcut("execution(public void addAccount())")
	public void method2() {
		
	}
	
	@Before("method2()")
	public void beforeAccountAddAdvice1() {
		System.out.println("executing 1 @before on addAccount() cloud");
	}
	@Before("method2()")
	public void beforeAccountAddAdvice3() {
		System.out.println("executing 2 @before on addAccount() cloud");
	}
	
}



