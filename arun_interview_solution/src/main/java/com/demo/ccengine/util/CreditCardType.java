package com.demo.ccengine.util;

public enum CreditCardType {
	VISA("4", "Visa"), MASTER("5", "Master"), AMEX("37", "Amex"), DISCOVER("6", "Discover");
	
	CreditCardType(String cardInitNumber, String cardType){
		this.cardInitialNumber = cardInitNumber;
		this.cardType = cardType;
	}
	
	private final String cardInitialNumber;
	private final String cardType;
	
	public String getCardInitialNumber(){
		return cardInitialNumber;
	}

	public String getCardType(){
		return cardType;
	}
	
	@Override
	public String toString() {
		return cardType;
	}
}
