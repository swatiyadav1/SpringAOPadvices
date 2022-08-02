package com.springDemo.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springDemo.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDefaultLogAspect {
	
	@Pointcut("execution(public void addAccount())")
	public void method1() {
		
	}
	
	@Before("method1()")
	public void beforeAccountAddAdvice() {
		System.out.println("executing 1 @before on addAccount() ");
	}
	@Before("method1()")
	public void beforeAccountAddAdvice2() {
		System.out.println("executing 2 @before on addAccount() ");
	}
	
	@AfterReturning(
			pointcut="execution(* com.springDemo.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningAdviceFind(JoinPoint joinpoint , List<Account> result) {
		
		String method = joinpoint.getSignature().toShortString();
		System.out.println("trying to execute @afterReturn findAccount : "+method);
		
		System.out.println(result);
		
	}
	@After("execution(* com.springDemo.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterAdviceFind() {
		System.out.println("after advice ");
		
	}
	
	@AfterThrowing(pointcut = "execution(* com.springDemo.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowFindAccount(JoinPoint joinpoint , Throwable theExc) {
		System.out.println("execute after error");
		
		String method = joinpoint.getSignature().toShortString();
		System.out.println("trying to execute @afterReturn findAccount : "+method);
		
		System.out.println("exception is - "+theExc);
	}
	
	@Around("execution(* com.springDemo.aopdemo.service.*.getFortue(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint)throws Throwable {
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("trying to execute @afterReturn getFotune : "+method);
		
		long begin = System.currentTimeMillis();
		
		Object result = theProceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		System.out.println(duration);
		return result;
	}
	
	

}



//pattern ?