package com.rossettimonicadigiorgio.winestoremanagement.classes;

/**
 * The {@code User} is a class that defines:
 * the type of person that can:
 * login,register and buy products
 * @author 297398
 *
 */
public class User extends Person{
	/**
	 * Class constructor
	 * @param name of the user
	 * @param surname of the user
	 * @param email of the user
	 * @param password of the user
	 */
	public User(String name, String surname, String email, String password) {
		super(name, surname, email, password);
	}
}
