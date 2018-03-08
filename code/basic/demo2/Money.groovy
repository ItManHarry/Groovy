package groovy.basic.demo2

class Money {
	private int amount;
	private String currency;
	
	Money(amount, currency){
		this.amount = amount;
		this.currency = currency;
	}
	
	boolean equals(Object o){
		if(o == null)
			return false;
		if(!(o instanceof Money))
			return false;
		if(amount != o.amount)
			return false;
		if(currency != o.currency)
			return false;
		return true;
	}
	
	int hasCode(){
		amount.hashCode() + currency.hashCode();
	}
	
	Money plus(Money o){
		if(o == null)
			return null;
		if(o.currency != currency)
			throw new IllegalArgumentException("can't add $o.currency to $currency");
		return new Money(amount + o.amount , currency);
	}
}
