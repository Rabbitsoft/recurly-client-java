package com.kwanzoo.recurly;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.jersey.api.client.GenericType;

/**
 * Class for retrieving subscription plans. Other CRUD methods 
 * are not tested and therefore not recommended to use.  
 */
@XmlRootElement(name="plans")
public class SubscriptionPlans extends Base {
	private final static String resourcePath = "/company/plans";

	@XmlElement(name="plan")
	public List<Plan> all; 
	
	@Override
	protected String getResourcePath() {
		return resourcePath;
	}

	@Override
	protected String getResourceCreationPath() {
		return getResourcePath();
	}
	
	private static String getPlansResourcePath() { 
		return resourcePath;
	}

	private static String getPlansResourcePath(String planCode) { 
		return resourcePath + "/" + planCode;
	}
	
	public static SubscriptionPlans get() { 
		return getWebResourceBuilder(
			getPlansResourcePath()).get(new GenericType<SubscriptionPlans>(){});
	}
	
	public static Plan get(String planCode) { 
		SubscriptionPlans subscriptionPlans = getWebResourceBuilder(
			getPlansResourcePath(planCode)).get(new GenericType<SubscriptionPlans>(){});
		
		List<Plan> plans = subscriptionPlans.all;
		if (plans.isEmpty()) { 
			return null; 
		}
		return plans.get(0);
	}
}
