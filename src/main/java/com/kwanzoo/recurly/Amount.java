package com.kwanzoo.recurly;


public class Amount {

	public String currency;

    public Integer amount;

    public Amount(String currency, Integer amount) {
		this.currency = currency;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Amount [currency=" + currency + ", amount=" + amount + "]";
	}
}
