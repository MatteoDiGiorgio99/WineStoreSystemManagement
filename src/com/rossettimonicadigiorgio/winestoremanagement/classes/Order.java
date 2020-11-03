package com.rossettimonicadigiorgio.winestoremanagement.classes;

import java.util.*;

public class Order {
	private StatusEnum Status; 
	private Person User;
	private ArrayList<Wine> Wines;
	
	public Order(Person user, ArrayList<Wine> wines)
	{
		this.Status = StatusEnum.Confirmed;
		this.User = user;
		this.Wines = wines;
	}
	
	protected StatusEnum getStatus() { return this.Status; }
	
	protected boolean ship() { this.Status = StatusEnum.Shipped; return true; }
	
	protected Person getUser() { return this.User; }
	
	protected List<Wine> getWines() { return this.Wines; }
}
