package com.kwanzoo.recurly.push;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.kwanzoo.recurly.Account;
import com.kwanzoo.recurly.Transaction;

@XmlRootElement(name = "updated_subscription_notification")
public class UpdateSubscriptionNotification {
	@XmlElement
	public Account account;
	
	@XmlElement
	public Transaction transaction;
}
