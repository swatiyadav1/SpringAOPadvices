package com.springDemo.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springDemo.aopdemo.dao.AccountDAO;

public class MainDemoAfterReturn {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
	AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
	List<Account> theAccounts = null;
	
	
	try {
		boolean tripWire = true;
		theAccounts = theAccountDAO.findAccounts(tripWire);
	}
	catch(Exception exc) {
		System.out.println("caught exception "+exc);
	}
	
	System.out.println(theAccounts);
		
		// close the context
		context.close();
	}

}
