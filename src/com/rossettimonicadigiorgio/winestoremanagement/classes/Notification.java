package com.rossettimonicadigiorgio.winestoremanagement.classes;

/**
 * The {@code Notification} is a class that defines:
 * Notifies the user if the wine has become available
 * @author 297402
 *
 */
public class Notification {
	private User user;
	private Wine wine;
	
	/**
	 * Class constructor
	 * @param user the user
	 * @param wine that we want to be notified
	 */
	public Notification(User user, Wine wine) {
		this.user = user;
		this.wine = wine;
	}
	
	/**
	 * Fetch the user to be notified
	 * @return user
	 */
	public User getUser() {
		return this.user;
	}
	
	/**
	 * Fetch the wine we want to be notified
	 * @return wine
	 */
	public Wine getWine() {
		return this.wine;
	}
}
