package groovy.in.action.classes

class Money {

	Money(amountValue, currencyValue){
		amount = amountValue;
		currency = currencyValue;
	}
	
	boolean equals(Object other){
		if(other == null) 
			return false;
		if(!(other instanceof Money)) 
			return false;
		if(currency != other.currency)
			return false;	
		if(amount != other.amount)
			return false;
		return true;
	}
	
	int hashCode(){
		return amount.hashCode() + currency.hashCode();
	}
	
	Money plus(Integer other){
		return new Money(amount+other, currency);
	}
	
	Money plus(Money other){
		if(other == null)
			return null;
		if(other.currency != currency)
			throw new IllegalArgumentException("Currency is different!");
		return new Money(amount+other.amount, currency);
	}
	
	private int amount;
	private String currency;
}
