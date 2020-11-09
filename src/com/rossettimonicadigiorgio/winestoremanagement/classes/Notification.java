package com.rossettimonicadigiorgio.winestoremanagement.classes;

public class Notification {
	private User user;
	private Wine wine;
	
	public Notification(User user, Wine wine) {
		this.user = user;
		this.wine = wine;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public Wine getWine() {
		return this.wine;
	}
}
