package com.kwanzoo.recurly.push;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.kwanzoo.recurly.Account;
import com.kwanzoo.recurly.Subscription;

@XmlRootElement(name = "expired_subscription_notification")
public class ExpiredSubscriptionNotification {
	@XmlElement
	public Account account; 

	@XmlElement
	public Subscription subscription;
}
