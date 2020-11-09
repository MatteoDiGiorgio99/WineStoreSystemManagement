package com.rossettimonicadigiorgio.winestoremanagement.classes;
import java.util.*;

public class System {
	private ArrayList<Wine> wines;
	private ArrayList<User> users;
	private ArrayList<Employee> employees; 
	private ArrayList<Order> orders;
	private ArrayList<Notification> notifications;
	
	public System (ArrayList<Wine> wines, ArrayList<User> users, ArrayList<Employee> emplyees)
	{
		this.wines = wines;
		this.users = users;
		this.employees = emplyees;
		this.orders = new ArrayList<Order>();
		this.notifications = new ArrayList<Notification>();
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
		
		for (Person person : this.employees) {
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
				return wine.clone();
		}
		
		return null;
	}
	
	public Order BuyOrder(User user, ArrayList<Wine> wines, boolean getNotified) {
		ArrayList<Wine> notAvailable = new ArrayList<Wine>();
		
		for (Wine wine : wines) {
			if(!wine.CheckAvailability()) {
				return null;
			}
			
			for (Wine globalwine: this.wines)  {
			   if(globalwine.EqualTo(wine))
			   {
				   if(!globalwine.ProcessOrder(wine.getBottlesNumber())) {
					   notAvailable.add(wine);
				   
					   if(getNotified)
						   this.subscribeNotification(user, globalwine);
				   }
			   }
			}
		}
		
		for (Wine wine : notAvailable) {
			wines.remove(wines.indexOf(wine));
		}
		
		if(wines.size() > 0) {
			Order order = new Order(user, wines); 
			this.orders.add(order);
			
			return order;
		}
		
		return null;
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
	
	public ArrayList<Notification> StockWine(Employee user, Wine type, int numberOfBottles) {
		if(user == null)		
			return null;
		
		if(this.employees.indexOf(user) < 0)
			return null;
		
		int winenum = this.FindWinePosition(type);
		
		if(winenum < 0)
			return null;
		
		if(!type.Restock(numberOfBottles))
			return null;
		
		this.wines.remove(winenum);
		this.wines.add(winenum, type);
		
		return notifyUsers(type);
	}
	
	public boolean subscribeNotification(User user, Wine wine) {
		if(user == null)
			return false;
		
		if(FindWine(wine) == null)
			return false;
		
		Notification notification = new Notification(user, wine);
		
		this.notifications.add(notification);
		
		return true;
	}
	
	private ArrayList<Notification> notifyUsers(Wine wine) {
		ArrayList<Notification> results = new ArrayList<Notification>();
		
		for (Notification notification : this.notifications) {
			if(!wine.EqualTo(notification.getWine()))
				continue;
			
			results.add(notification);
		}
		
		for (Notification notification : results) {
			this.notifications.remove(this.notifications.indexOf(notification));
		}
		
		return results;
	}
	
	private Wine FindWine(Wine wine) { 
		for (Wine globalwine : this.wines) {
			if(globalwine.EqualTo(wine))
				return wine;
		}
		
		return null;
	}
	
	private int FindWinePosition(Wine wine) { 
		for (int i = 0; i < this.wines.size(); i++) {
			if((this.wines.get(i)).EqualTo(wine))
				return i;
		}
		
		return -1;
	}
}
