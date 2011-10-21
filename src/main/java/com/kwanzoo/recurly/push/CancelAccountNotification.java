package com.kwanzoo.recurly.push;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.kwanzoo.recurly.Account;

@XmlRootElement(name = "canceled_account_notification")
public class CancelAccountNotification {
	@XmlElement
	public Account account; 
}
