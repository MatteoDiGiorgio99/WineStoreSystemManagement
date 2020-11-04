package com.rossettimonicadigiorgio.winestoremanagement.classes;
import java.util.*;

public class System {
	private ArrayList<Wine> wines;
	private ArrayList<User> users;
	private ArrayList<Employee> employees; 
	private ArrayList<Order> orders;
	
	public System (ArrayList<Wine> wines, ArrayList<User> users, ArrayList<Employee> emplyees)
	{
		this.wines = wines;
		this.users = users;
		this.employees = emplyees;
		this.orders = new ArrayList<Order>();
	}
	
	public ArrayList<Wine> getWines() {
		return this.wines;
	}
	
	public ArrayList<Order> getOrder() {
		return this.orders;
	}
	
	public Person Login(String email,String password) throws IllegalAccessException {
		for (Person person : this.users) {
			if(person.getEmail() == email && person.getPassword() == password)
			{
				return person;
			}	
		}
		
		throw new IllegalAccessException();
	}
	
	public boolean RegisterUser(User person) {
		if(person == null) 
			return false;
		
		return this.users.add(person);
	}
	
	public Wine FindWine(String name, String producer, int year) { 
		for (Wine wine : this.wines) {
			if(wine.EqualTo(name, producer, year))
				return wine;
		}
		
		return null;
	}
	
	public Order BuyOrder(Person user, ArrayList<Wine> wines) {
		
		for (Wine wine : wines) {
			if(!wine.CheckAvailability()) {
				return null;
			}
			
			for (Wine globalwine: this.wines)  {
			   if(globalwine.EqualTo(wine))
			   {
				   globalwine.ProcessOrder(wine.getBottlesNumber());
			   }
			}
		}
		
		Order order = new Order(user,wines); 
		this.orders.add(order);
		
		return order;
	}
	
	public boolean ShipOrder(Order order) {
		if(order == null) {
			return false;
		}
		
		Order orderToShip = this.orders.get(this.orders.indexOf(order));
		
		if(orderToShip == null) 
			return false;
		
		return orderToShip.ship();
	}
	
	public boolean StockWine(Employee user, Wine type, int numberOfBottles) {
		if(user == null)		
			return false;
		
		if(this.employees.indexOf(user) < 0)
			return false;
		
		int winenum = this.wines.indexOf(type);
		
		if(winenum < 0)
			return false;
		
		if(!type.Restock(numberOfBottles))
			return false;
		
		this.wines.remove(winenum);
		this.wines.add(winenum, type);
		
		return true;
	}
	
	private Wine FindWine(Wine wine) { 
		for (Wine globalwine : this.wines) {
			if(globalwine.EqualTo(wine))
				return wine;
		}
		
		return null;
	}
}
