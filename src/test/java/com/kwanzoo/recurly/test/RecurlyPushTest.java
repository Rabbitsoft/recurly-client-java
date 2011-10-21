package com.kwanzoo.recurly.test;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.kwanzoo.recurly.push.RecurlyNotification;

public class RecurlyPushTest {

	@Test
	public void test0() throws JAXBException, SAXException, IOException, ParserConfigurationException {
		File notificationDirectory = new File("src/test/resources/push");
		FileFilter filter = new FileFilter() {
			@Override	
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".xml");
			}
		};
		for (File file : notificationDirectory.listFiles(filter)) {
			RecurlyNotification notification = new RecurlyNotification(new FileInputStream(file));
			assertNotNull(notification.getType());
			assertNotNull(notification.getMappedObject());
		}
	}
	
}
