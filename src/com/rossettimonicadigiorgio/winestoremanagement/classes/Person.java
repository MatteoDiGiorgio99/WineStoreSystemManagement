package com.rossettimonicadigiorgio.winestoremanagement.classes;

/**
 * The {@code Person} is a class that defines:
 * details of every person that can access to the system
 * @author 297398
 *
 */
public abstract class Person {
	 private String Name;
	 private String Surname;
	 private String Email;
	 private String Password;
	
	 /**
	  * Class constructor
	  * @param name of the person
	  * @param surname of the person
	  * @param email of the person
	  * @param password of the person
	  */
	 public Person(String name, String surname, String email, String password)
	 {
		 this.Name = name;
		 this.Surname = surname;
		 this.Email = email;
		 this.Password = password;
	 }
	 
	 /**
	  * Fetch name of the person
	  * @return name of the person
	  */
	 public String getName() {return this.Name;}
	 
	 /**
	  * Fetch surname of the person
	  * @return surname of the person
	  */
	 protected String getSurname() { return this.Surname; }
	 
	 /**
	  * Fetch email of the person
	  * @return email of the person
	  */
	 protected String getEmail() { return this.Email; }
	 
	 /**
	  * Fetch password of the person
	  * @return password of the person
	  */
	 protected String getPassword() { return this.Password; }
}