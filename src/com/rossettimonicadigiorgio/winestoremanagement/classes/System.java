package com.rossettimonicadigiorgio.winestoremanagement.classes;
import java.util.*;

public class System {
	
	private List<Wine> Wines;
	private List<Person> Users;
	private List<Order> Orders;
	
	public System (List<Wine> wines,List<Person> users,List<Order> orders)
	{
		this.Wines=wines;
		this.Users=users;
		this.Orders=orders;
	}
	
	Person Login(String email,String password) throws IllegalAccessException {
	
		for (Person person : Users) {
		
			if(person.getEmail()==email && person.getPassword()==password)
			{
				return person;
			}	
		}
		throw new IllegalAccessException();
	}
	
	boolean RegisterUser() {return false;}
	
	Wine FindWine() {return null;}
	
	boolean BuyOrder(Person user,List<Wine> wines ) {
		
		for (Wine wine : wines) {
			
			if(wine.CheckAvailability()==false)
			{
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
		Orders.add(order);
		return true;
	}
	
	boolean ShipOrder() {return false;}
	
	boolean StockWine() {return false;}
	
	
	
	
}
