package com.kwanzoo.recurly.push;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.kwanzoo.recurly.Account;

@XmlRootElement(name = "billing_info_updated_notification")
public class BillingInfoUpdateNotification {
	@XmlElement
	public Account account; 
}
