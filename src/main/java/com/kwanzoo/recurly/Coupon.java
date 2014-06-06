package com.kwanzoo.recurly;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;

@XmlRootElement(name = "coupon")
public class Coupon extends Base {
	public static String pluralResourceName = "coupons";
	
	@XmlType
	public static class CouponDiscount {
		@XmlElement
		public Integer EUR, USD, GBP;
	}	
	
    @XmlElement(name="coupon_code")
    public String couponCode;
    
    @XmlElement(name="name")
    public String name;
    
    @XmlElement(name="discount_type")
    public String type;
    
    @XmlElement(name="state")
    public String state;
    
    @XmlElement(name="discount_in_cents")
    public Coupon.CouponDiscount discountInCents;
    
    @XmlElement(name="discount_percent")
    public Integer discountPercent;
    
    public Coupon() {
    }
    
    private static String getResourcePath(String couponCode){
		return pluralResourceName + "/" + couponCode;
	}
    
	@Override
	protected String getResourcePath() {
		return getResourcePath(couponCode);
	}

	@Override
	protected String getResourceCreationPath() {
		return pluralResourceName;
	}
	
    public static Coupon get(final String couponCode) throws Exception{
    	try{
    		return getWebResourceBuilder(getResourcePath(couponCode)).get(new GenericType<Coupon>(){});
    	}
    	catch(final UniformInterfaceException uie){
    		throwStatusBasedException(uie.getResponse());
    		return null;
    	}
    }
}
