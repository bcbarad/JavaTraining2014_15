package com.vl.utms.grabber;

import java.io.StringReader;
import java.util.AbstractList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlParser {

    public static JSONArray parse(String xml, String platform) throws XPathExpressionException {
    	XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xPath = xPathFactory.newXPath();
		InputSource is = new InputSource(new StringReader(xml));
		JSONArray allLeaves = new JSONArray();
		JSONObject leaf = null;
		if (platform != null && platform.equals("Android")) {
			NodeList leaves = (NodeList) xPath.evaluate("//*[not(*)]", is, XPathConstants.NODESET);
			for (int i = 0; i < leaves.getLength(); i++) {
				leaf = new JSONObject();
				Element element = (Element) leaves.item(i);
				String instance = element.getAttribute("instance");
				String resourceId = element.getAttribute("resource-id");
				String contentDesc = element.getAttribute("content-desc");
				String text = element.getAttribute("text");
				String xpath = "//*[@text = '" + text + "' and @content-desc = '" + contentDesc
						+ "' and @resource-id = '" + resourceId + "' and @instance = '" + instance + "']";
				leaf.put("xpath", xpath);
				String bounds = element.getAttribute("bounds");
				leaf.put("bounds", bounds);
				String coords = bounds.substring(1, bounds.length() - 1).replace("][", ",");
				leaf.put("coords", coords);
				allLeaves.put(leaf);
			}
		}else {
			//PArsing iOS XML file
			NodeList leaves = (NodeList) xPath.evaluate("//*[not(self::UIAStatusBar)]/*[not(*)]", is, XPathConstants.NODESET);
			for (int i = 0; i < leaves.getLength(); i++) {
				leaf = new JSONObject();
				Element element = (Element) leaves.item(i);
				String path = element.getAttribute("path");
				String name = element.getAttribute("name");
				String xpath = "//*[@path = '" + path + "' and @name = '" + name + "']";
				leaf.put("xpath", xpath);
				float x = Float.parseFloat(element.getAttribute("x"));
				float y = Float.parseFloat(element.getAttribute("y"));
				float width = Float.parseFloat(element.getAttribute("width"));
				float height = Float.parseFloat(element.getAttribute("height"));
				String bounds = "["+x+","+y+"]["+ (x+width)+","+(y+height)+"]";
				leaf.put("bounds", bounds);
				String coords = x+","+y+","+(x+width)+","+(y+height);
				System.out.println("Bounds : " + bounds + "\tCoords : " +coords);
				leaf.put("coords", coords);
				allLeaves.put(leaf);
			}
		}
		return allLeaves;
    }

    public static List<Node> list(final NodeList list) {
        return new AbstractList<Node>() {
            public int size() {
                return list.getLength();
            }

            public Node get(int index) {
                Node item = list.item(index);
                if (item == null)
                    throw new IndexOutOfBoundsException();
                return item;
            }
        };
    }

    public static List<Node> getElementsByTagName(Element e, String tag) {
        return list(e.getElementsByTagName(tag));
    }
}
