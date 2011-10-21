package com.kwanzoo.recurly.push;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.kwanzoo.recurly.Account;
import com.kwanzoo.recurly.Subscription;

@XmlRootElement(name = "renewed_subscription_notification")
public class RenewedSubscriptionNotification {
	@XmlElement
	public Account account;
	
	@XmlElement
	public Subscription subscription;
}
