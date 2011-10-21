package com.kwanzoo.recurly.push;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.kwanzoo.recurly.Account;

@XmlRootElement(name = "new_account_notification")
public class NewAccountNotification {
	@XmlElement
	public Account account;
}
