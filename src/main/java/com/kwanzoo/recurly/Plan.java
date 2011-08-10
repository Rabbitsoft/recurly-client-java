package com.kwanzoo.recurly;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.jersey.api.client.UniformInterfaceException;

@XmlRootElement(name="plan")
public class Plan extends Base {

	// all 

	@XmlElement(name="plan_code") 
	public String planCode;
	
	@XmlElement(name="name") 
	public String name;

	// embedded

	@XmlElement(name="version") 
	public Integer version;

	// full

	@XmlElement(name="unit_amount_in_cents") 
	public Integer unitAmount;
	
	@XmlElement(name="plan_interval_length") 
	public Integer intervalLength;
	
	@XmlElement(name="plan_interval_unit") 
	public String intervalUnit;
	
	public static Plan get(final String planCode) throws Exception{
	   	try{
    		return getWebResourceBuilder("company/plans/" + planCode).get(Plan.class);
    	}
    	catch(final UniformInterfaceException uie){
    		throwStatusBasedException(uie.getResponse());
    		return null;
    	}
    }

	@Override
	protected String getResourcePath() {
		throw new UnsupportedOperationException();
	}

	@Override
	protected String getResourceCreationPath() {
		throw new UnsupportedOperationException();
	}
}