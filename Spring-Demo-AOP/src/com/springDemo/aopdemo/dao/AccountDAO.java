package com.springDemo.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springDemo.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	
	
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public List<Account> findAccounts(boolean tripWire){
		
		if(tripWire) {
			throw new RuntimeException("a new exception occured");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		Account t1=new Account("john","silver");
		Account t2=new Account("swati","gold");
		
		Account t3=new Account("arya","diamond");
		Account t4=new Account("akshay","platinum");
		
		myAccounts.add(t1);
		myAccounts.add(t2);
		myAccounts.add(t3);
		myAccounts.add(t4);
		
		return myAccounts;
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	
	
}





