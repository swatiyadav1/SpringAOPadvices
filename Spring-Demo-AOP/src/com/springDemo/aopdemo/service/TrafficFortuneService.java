package com.springDemo.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;


@Component
public class TrafficFortuneService {

	public String getFortue() {
		
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		return "expect heavy traffic at the signal";
		
	}
}
