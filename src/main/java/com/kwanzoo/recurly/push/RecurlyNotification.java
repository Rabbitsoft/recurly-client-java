package com.kwanzoo.recurly.push;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class RecurlyNotification {
	private static Map<String, Class<?>> typeMapping = new HashMap<String, Class<?>>();
	
	/**
	 * Defines the binding for each notification type to its POJO object. The 
	 * root node defines the object class. Later JAXB unmarshaler used to bind 
	 * to the instance. 
	 * 
	 * For more information see:
	 * http://docs.recurly.com/integration/push-notifications/
	 */
	static {
		typeMapping.put("new_account_notification", NewAccountNotification.class);
		typeMapping.put("canceled_account_notification", CancelAccountNotification.class);
		typeMapping.put("billing_info_updated_notification", BillingInfoUpdateNotification.class);
		
		typeMapping.put("new_subscription_notification", NewSubscriptionNotification.class);
		typeMapping.put("updated_subscription_notification", UpdateSubscriptionNotification.class);
		typeMapping.put("expired_subscription_notification", ExpiredSubscriptionNotification.class);
		typeMapping.put("canceled_subscription_notification", CancelSubscriptionNotification.class);
		typeMapping.put("renewed_subscription_notification", RenewedSubscriptionNotification.class);

		typeMapping.put("successful_payment_notification", SuccessfulPaymentNotification.class);
		typeMapping.put("failed_payment_notification", FailedPaymentNotification.class);
		typeMapping.put("successful_refund_notification", SuccessfulRefundNotification.class);
		typeMapping.put("void_payment_notification", VoidPaymentSuccessful.class);
	}
	
	
	private Object mappedObject = null;
	
	
	public RecurlyNotification(InputStream inputStream) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try { 
			Document document = 
				builderFactory.newDocumentBuilder().parse(inputStream);
			mappedObject = bindXmlNotification(document.getFirstChild());
		} catch (Throwable ex) {
			handleException(ex); 
		}
	}
	
	private Object bindXmlNotification(Node node) throws JAXBException {
		Class<?> clazz = typeMapping.get(node.getNodeName());
		if (clazz == null) {
			throw new IllegalStateException(
				"Unknown notification type: " + node.getNodeName());
		}
		JAXBContext context = JAXBContext.newInstance(clazz);
		return context.createUnmarshaller().unmarshal(node);
	}
	
	private void handleException(Throwable ex) {
		throw new IllegalStateException(ex);
	}

	public String getType() {
		return mappedObject.getClass().getSimpleName();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getMappedObject() {
		return (T) mappedObject;
	}
}
