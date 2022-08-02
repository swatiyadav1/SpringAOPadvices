package com.springDemo.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springDemo.aopdemo.service.TrafficFortuneService;

public class MainDemoAround {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
	
	String data = theTrafficFortuneService.getFortue();
	
	System.out.println("fortune for today is "+data);
	
		// close the context
		context.close();
	}

}
