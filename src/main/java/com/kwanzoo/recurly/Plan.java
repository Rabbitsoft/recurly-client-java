package com.kwanzoo.recurly;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@XmlRootElement(name="plan")
public class Plan extends Base {
	public static String pluralResourceName = "plans";

	@XmlElement(name="plan_code")
	public String planCode;
	
	@XmlElement(name="name") 
	public String name;
	
	@XmlElement(name="description")
	public String description; 
	
	@XmlElement(name="plan_interval_length")
	public Integer planLength; 
	
	@XmlElement(name="plan_interval_unit")
	public String planUnit;

	@XmlTransient
	public List<Amount> unitAmounts;

	@XmlAnyElement
	public Element getUnitAmounts() {
		Document document;
		try {
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		}
		Element element = document.createElement("unit_amount_in_cents");
		if (unitAmounts != null) {
			for (Amount amount : unitAmounts) {
				Element node = document.createElement(amount.currency);
				node.setTextContent(amount.amount.toString());
				element.appendChild(node);
			}
		}
		return element;
	}
	public void setUnitAmounts(Element element) {
		if ("unit_amount_in_cents".equals(element.getNodeName())) {
			unitAmounts = new ArrayList<Amount>();
			NodeList childNodes = ((Node) element).getChildNodes();
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node item = childNodes.item(i);
				if (item instanceof Element) {
					unitAmounts.add(new Amount(item.getNodeName(), Integer.valueOf(item.getTextContent())));
				}
			}
		}
	}

    @Override
	protected String getResourcePath() {
		return pluralResourceName + "/" + planCode;
	}

	@Override
	protected String getResourceCreationPath() {
		return pluralResourceName;
	}
}