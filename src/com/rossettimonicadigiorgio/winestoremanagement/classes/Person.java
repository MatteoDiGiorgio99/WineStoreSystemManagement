package com.rossettimonicadigiorgio.winestoremanagement.classes;

public abstract class Person {
	 private String Name;
	 private String Surname;
	 private String Email;
	 private String Password;
	
	 public Person(String name, String surname, String email)
	 {
		 this.Name = name;
		 this.Surname = surname;
		 this.Email = email;
	 }
	 
	 protected String getName() {return this.Name;}
	 
	 protected String getSurname() { return this.Surname; }
	 
	 protected String getEmail() { return this.Email; }
	 
	 protected String getPassword() { return this.Password; }
}