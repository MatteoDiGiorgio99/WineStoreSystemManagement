package com.rossettimonicadigiorgio.winestoremanagement.classes;

import java.util.*;

public abstract class Person {
	
 private String Name;
 private String Surname;
 private String Email;
 private String Password;
 private List<Wine> AvailabilityNotification;

 public Person(String name,String surname,String email,List<Wine> availabilitynotification)
 {
	 this.Name=name;
	 this.Surname=surname;
	 this.Email=email;
	 this.AvailabilityNotification=availabilitynotification;
 }
 
 protected String getName() {return this.Name;}
 
 protected String getSurname() { return this.Surname; }
 
 protected String getEmail() { return this.Email; }
 
 protected String getPassword() { return this.Password; }
 
 protected List<Wine> getAvailabilityNotification(){return this.AvailabilityNotification;}
 
 protected void setAvailabilityNotification(List<Wine> availabilitynotification ) {this.AvailabilityNotification= availabilitynotification;}
 
}
