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
		User UX = new User("UX", "UX", "UX@example.it", "1234");
		system.RegisterUser(UX);
		
		User UY = new User("UY", "UY", "UY@example.it", "1234");
		system.RegisterUser(UY);
		
		User UZ = new User("UZ", "UZ", "UZ@example.it", "1234");
		system.RegisterUser(UZ);
		
		/// Test buy UX
		ArrayList<Wine> tobuy = new ArrayList<Wine>();
		Wine wine1 = wines.get(0).clone();
		wine1.setBottlesNumber(1);
		tobuy.add(wine1);
		
		system.BuyOrder(UX, tobuy, false);
		
		tobuy.clear();
		
		/// Test buy UY
		Wine wine2 = wines.get(wines.size() - 1).clone();
		tobuy.add(wine2);
		
		system.BuyOrder(UY, tobuy, false);
		
		wines = system.getWines();
		
		java.lang.System.out.println("UX Bottles after purchase: " + wines.get(0).getBottlesNumber());
		java.lang.System.out.println("UY Bottles after purchase: " + wines.get(wines.size() - 1).getBottlesNumber());
		java.lang.System.out.println("Orders created: " + system.getOrder().size());
		
		/// Test Buy UZ
		tobuy.clear();
		Wine wineUZ = system.FindWine("wine1", "prod1", 2017);
		wineUZ.setBottlesNumber(2);
		tobuy.add(wineUZ);
		system.BuyOrder(UZ, tobuy, true);
		
		/// Restock Employee
		try {
			Employee employee = (Employee) system.Login("emp1@example.it", "1234");
			var notifications = system.StockWine(employee, system.FindWine("wine1", "prod1", 2017), 10);
			
			for (Notification notification : notifications) {
				java.lang.System.out.println("Notification for " + notification.getUser().getName() + ". Wine " + notification.getWine().getName() + " is now available");
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}		
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
		
		employees.add(new Employee("emp1", "emp1", "emp1@example.it", "1234"));
		
		return employees;
	}
	
	private static ArrayList<Wine> initWines() {
		ArrayList<Wine> wines = new ArrayList<Wine>();
		
		ArrayList<String> vines = new ArrayList<String>();
		vines.add("vine1");
		vines.add("vine2");
		vines.add("vine3");
		
		
		wines.add(new Wine("wine1", "prod1", 2019, "note1", 3, vines));
		wines.add(new Wine("wine2", "prod1", 2018, "note2", 2, vines));
		wines.add(new Wine("wine1", "prod1", 2017, "note3", 5, vines));
		
		return wines;
	}
}
