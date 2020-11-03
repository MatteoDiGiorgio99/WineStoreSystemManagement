package com.rossettimonicadigiorgio.winestoremanagement.classes;
import java.util.*;

public class System {
	private ArrayList<Wine> Wines;
	private ArrayList<Person> Users;
	private ArrayList<Order> Orders;
	
	public System (ArrayList<Wine> wines, ArrayList<Person> users, ArrayList<Order> orders)
	{
		this.Wines = wines;
		this.Users = users;
		this.Orders = orders;
	}
	
	Person Login(String email,String password) throws IllegalAccessException {
		for (Person person : this.Users) {
			if(person.getEmail() == email && person.getPassword() == password)
			{
				return person;
			}	
		}
		
		throw new IllegalAccessException();
	}
	
	boolean RegisterUser(Person person) {
		if(person == null) 
			return false;
		
		return this.Users.add(person);
	}
	
	Wine FindWine(String name, String producer, int year) { 
		for (Wine wine : this.Wines) {
			if(wine.EqualTo(name, producer, year))
				return wine;
		}
		
		return null;
	}
	
	boolean BuyOrder(Person user, ArrayList<Wine> wines) {
		
		for (Wine wine : wines) {
			if(!wine.CheckAvailability()) {
				return false;
			}
			
			for (Wine globalwine: this.Wines)  {
			   if(globalwine.EqualTo(wine))
			   {
				   globalwine.ProcessOrder(wine.getBottlesNumber());
			   }
			}
		}
		
		Order order = new Order(user,wines); 
		this.Orders.add(order);
		
		return true;
	}
	
	boolean ShipOrder(Order order) {
		if(order == null) {
			return false;
		}
		
		Order orderToShip = this.Orders.get(this.Orders.indexOf(order));
		
		if(orderToShip == null) 
			return false;
		
		return orderToShip.ship();
	}
	
	boolean StockWine(Employee user, Wine type, int numberOfBottles) {
		return false;
	}
	
	private Wine FindWine(Wine wine) { 
		for (Wine globalwine : this.Wines) {
			if(globalwine.EqualTo(wine))
				return wine;
		}
		
		return null;
	}
}
