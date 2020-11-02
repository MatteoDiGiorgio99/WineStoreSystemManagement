package com.rossettimonicadigiorgio.winestoremanagement.classes;

import java.util.*;

public class Order {

	private StatusEnum Status; 
	private Person User;
	private List<Wine> Wines;

	public Order(StatusEnum status,Person user,List<Wine> wines)
	{
		this.Status=status;
		this.User=user;
		this.Wines=wines;
	}
	
	protected StatusEnum getStatus() {return this.Status;}
	
	protected Person getUser() {return this.User;}
	
	protected List<Wine> getWines(){return this.Wines;}
}
