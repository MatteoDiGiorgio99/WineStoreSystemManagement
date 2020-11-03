package com.rossettimonicadigiorgio.winestoremanagement.classes;

import java.util.*;

public class Wine {
	private String Name;
	private String Producer;
	private int Year;
	private String Notes;
	private int BottlesNumber;
	private List<String> Vines; 
	
	public Wine(String name, String producer, int year, String notes, int bottlesnumber, List<String> vines)
	{
		this.Name = name;
		this.Producer = producer;
		this.Year = year;
		this.Notes = notes;
		this.BottlesNumber = bottlesnumber;
		this.Vines = vines;
	}
	
	protected int ProcessOrder(int bottlesnumber) {
		this.BottlesNumber -= bottlesnumber;
		return this.BottlesNumber;
	}
	
	protected String getName() { return this.Name; }
	
	protected String getProducer() { return this.Producer; }
	
	protected int getYear() { return this.Year; }
	
	protected String getNotes() { return this.Notes; }
	
	protected int getBottlesNumber() { return this.BottlesNumber; }
	
	protected void setBottlesNumber(int newBottlesNumber) { this.BottlesNumber = newBottlesNumber; }

	protected List<String> getVines() { return this.Vines; }
	
	protected boolean CheckAvailability() { return this.BottlesNumber > 0; }
	
	protected boolean Restock(int numberofbottles) { this.BottlesNumber += numberofbottles; return true; }
	
	protected boolean EqualTo(Wine wine) {
		return wine.Name == this.Name && wine.Producer == this.Producer && wine.Year == this.Year;  
	}
	
	protected boolean EqualTo(String name, String producer, int year) {
		return name == this.Name && producer == this.Producer && year == this.Year;  
	}
}
