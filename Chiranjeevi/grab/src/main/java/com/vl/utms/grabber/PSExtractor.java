package com.vl.utms.grabber;

import java.net.MalformedURLException;

import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class PSExtractor {
	public static void main(String[] args)
			throws MalformedURLException, InterruptedException, XPathExpressionException {
		AppiumDriver<WebElement> driver = DriverFactory.getDriver();
		Thread.sleep(10000);
		for (; true;) {
			printSource(driver);
			Thread.sleep(20000);
		}
	}

	public static void printSource(AppiumDriver<WebElement> driver) throws XPathExpressionException {
		System.out.println("start");
		driver.findElement(ById.id("net.one97.paytm:id/icon_cart")).click();//
		// .//*[not(*) and not(contains(@class, 'android.view.View') or
		// contains(@class, 'Layout'))][4]
		// driver.findElementByXPath("(//*[not(*) and not(contains(@class,
		// 'android.view.View' ) or contains(@class, 'Layout'))])[4]").click();
		System.out.println("end");
//		String xml = driver.getPageSource();
		// System.out.println(xml);
		// XmlParser.parse(xml);
	}
}
