package com.rossettimonicadigiorgio.winestoremanagement.classes;

/**
 * The {@code StatusEnum} defines the status of an order 
 * @author 297398
 *
 */
public enum StatusEnum {
	/**
	 * if the user completed the order and it's waiting for shipment
	 */
     Confirmed, 
     /**
      * if the order has been shipped
      */
     Shipped
}
