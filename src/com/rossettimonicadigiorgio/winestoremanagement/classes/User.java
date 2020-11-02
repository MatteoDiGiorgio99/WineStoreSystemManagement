package com.rossettimonicadigiorgio.winestoremanagement.classes;

import java.util.List;

public class User extends Person{

	public User(String name, String surname, String email, List<Wine> availabilitynotification) {
		super(name, surname, email, availabilitynotification);
		
	}

}
