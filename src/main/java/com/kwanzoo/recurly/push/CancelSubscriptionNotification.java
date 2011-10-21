package com.kwanzoo.recurly.push;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.kwanzoo.recurly.Account;
import com.kwanzoo.recurly.Subscription;

@XmlRootElement(name = "canceled_subscription_notification")
public class CancelSubscriptionNotification {
	@XmlElement
	public Account account; 

	@XmlElement
	public Subscription subscription;
}
