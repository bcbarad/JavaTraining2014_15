package com.vl.utms.grabber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XMLTest {
	public static void main(String[] args) throws FileNotFoundException {
		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xPath = xPathFactory.newXPath();
		InputSource iStream = new InputSource(new FileReader(new File("/home/chiranjeevi/Desktop/sample.xml")));
		
		String nodeValue = null;
		
		try {
			NodeList nodeList = (NodeList)  xPath.evaluate("//CUSTOMER/CITY", iStream, XPathConstants.NODESET);
			
			if (nodeList != null && nodeList.getLength() > 0) {
				Element element = (Element) nodeList.item(0);
				nodeValue = element.getTextContent();
				
			}
			System.out.println("XPath for given element is : " + nodeValue);
		} catch (XPathExpressionException e) {
			System.out.println("Error evaluating xPath: " + e.getMessage());
		}		
		
	}
}
