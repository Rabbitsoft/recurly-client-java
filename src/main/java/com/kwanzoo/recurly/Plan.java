package com.kwanzoo.recurly;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="plan")
public class Plan {
	@XmlElement(name="plan_code") 
	public String 	planCode;
	
	@XmlElement(name="name") 
	public String 	name;
	
	@XmlElement(name="version") 
	public Integer	version;
	
	@XmlElement(name="description")
	public String description; 
	
	@XmlElement(name="plan_interval_length")
	public Integer planLength; 
	
	@XmlElement(name="plan_interval_unit")
	public String planUnit; 
	
	@XmlElement(name="unit_amount_in_cents")
	public Integer amountInCents;
}