package com.demo.ccengine.service;

import java.io.Serializable;

public class CreditCard implements Serializable {

	private static final long serialVersionUID = -1740401052804021410L;

	public CreditCard(String cardNumber, String cardType) {
		this.cardNumber = cardNumber;
		this.cardType = cardType;
	}
	
	
	private final String cardType;
	private final String cardNumber;
	private String expiryDate;
	

	public String getCardType() {
		return cardType;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(String expiryDate) {
		this.expiryDate=expiryDate;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cardNumber == null) ? 0 : cardNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CreditCard))
			return false;
		CreditCard other = (CreditCard) obj;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CreditCard: [cardType=" + cardType + ", cardNumber="
				+ cardNumber + ", expiryDate=" + expiryDate + "]";
	}

}
