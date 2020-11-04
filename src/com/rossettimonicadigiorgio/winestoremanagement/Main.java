package com.rossettimonicadigiorgio.winestoremanagement;

import java.util.ArrayList;
import com.rossettimonicadigiorgio.winestoremanagement.classes.*;
import com.rossettimonicadigiorgio.winestoremanagement.classes.System;

/**
 * @author 296666
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		ArrayList<User> users = initUsers();
		ArrayList<Employee> employees = initEmployees();
		ArrayList<Wine> wines = initWines();
		
		System system = new System(wines, users, employees);
		
		java.lang.System.out.println("UX Bottles before purchase: " + wines.get(0).getBottlesNumber());
		java.lang.System.out.println("UY Bottles before purchase: " + wines.get(wines.size() - 1).getBottlesNumber());
		
		/// User Registration
		User UX = new User("provaregistrazione", "provaregistrazione", "provaregistrazione@aa.it", "1234");
		system.RegisterUser(UX);
		
		User UY = new User("provaregistrazione", "provaregistrazione", "provaregistrazione@aa.it", "1234");
		system.RegisterUser(UY);
		
		/// Test buy UX
		ArrayList<Wine> tobuy = new ArrayList<Wine>();
		Wine wine1 = wines.get(0).clone();
		wine1.setBottlesNumber(1);
		tobuy.add(wine1);
		
		system.BuyOrder(UX, tobuy);
		
		tobuy.clear();
		
		/// Test buy UY
		Wine wine2 = wines.get(wines.size() - 1).clone();
		tobuy.add(wine2);
		
		system.BuyOrder(UY, tobuy);
		
		wines = system.getWines();
		
		java.lang.System.out.println("UX Bottles after purchase: " + wines.get(0).getBottlesNumber());
		java.lang.System.out.println("UY Bottles after purchase: " + wines.get(wines.size() - 1).getBottlesNumber());
		java.lang.System.out.println("Numero ordini eseguiti: " + system.getOrder().size());
	}

	
	private static ArrayList<User> initUsers() {
		ArrayList<User> users = new ArrayList<User>();
		
		users.add(new User("user1", "user1", "user1@aa.it", "1234"));
		users.add(new User("user2", "user2", "user2@aa.it", "1234"));
		users.add(new User("user3", "user3", "user3@aa.it", "1234"));
		
		return users;
	}
	
	private static ArrayList<Employee> initEmployees() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee("emp1", "emp1", "emp1@aa.it", "1234"));
		
		return employees;
	}
	
	private static ArrayList<Wine> initWines() {
		ArrayList<Wine> wines = new ArrayList<Wine>();
		
		ArrayList<String> vines = new ArrayList<String>();
		vines.add("vine1");
		vines.add("vine2");
		vines.add("vine3");
		
		
		wines.add(new Wine("wine1", "prod1", 2019, "note1", 3, vines));
		wines.add(new Wine("wine1", "prod1", 2018, "note2", 2, vines));
		wines.add(new Wine("wine1", "prod1", 2017, "note3", 5, vines));
		
		return wines;
	}
}
