package com.kwanzoo.recurly.push;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.kwanzoo.recurly.Account;
import com.kwanzoo.recurly.Transaction;

@XmlRootElement(name = "successful_payment_notification")
public class SuccessfulPaymentNotification {
	@XmlElement
	public Account account;
	
	@XmlElement
	public Transaction transaction;
}
