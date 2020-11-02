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
	
	Person Login() {return null;}
	
	boolean RegisterUser() {return false;}
	
	Wine FindWine() {return null;}
	
	boolean ShipOrder() {return false;}
	
	boolean StockWine() {return false;}
	
	boolean Order() {return false;}
	
}
