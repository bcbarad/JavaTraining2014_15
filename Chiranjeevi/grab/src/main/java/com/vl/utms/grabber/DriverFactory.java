package com.vl.utms.grabber;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory implements Runnable {

    private static AppiumDriver<WebElement> driver;
    private static boolean isDriverAlive;

    public static void launchApp() throws MalformedURLException {
        // TODO Auto-generated method stub
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "capabilities");// HT514WV01170  HT485WM02342
//        capabilities.setCapability("platformName", "iOS");
//        capabilities.setCapability("platformVersion", "4.4.2");
//        capabilities.setPlatform(Platform.fromString("ANDROID"));
//        capabilities.setCapability("appPackage", "net.one97.paytm");
        capabilities.setCapability("newCommandTimeout", 0);
//        capabilities.setCapability("udid", udid);
//        capabilities.setPlatform(Platform.MAC);
//        System.out.println("Platform : " + Platform.MAC);
        capabilities.setCapability("app", "/home/chiranjeevi/Downloads/in.amazon.mShop.android.shopping.apk");
//        capabilities.setCapability("app", "/Users/utms/Downloads/Rango.ipa");
//        capabilities.setCapability("appActivity", "net.one97.paytm.AJRJarvisSplash");
        capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
        driver = new AndroidDriver<>(new URL("http://localhost:4444/wd/hub"), capabilities);
        isDriverAlive = true;
        // driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
    }

    public static AppiumDriver<WebElement> getDriver() throws MalformedURLException {
        if (driver == null) {
            launchApp();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        // To make thread safe
        driver = null;
        isDriverAlive = false;
    }
    
    /*public static String getScreenshot(AppiumDriver<WebElement> driver2){
    	System.out.println("Capturing the snapshot of the page ");
    	String srcFiler=((TakesScreenshot)driver2).getScreenshotAs(OutputType.BASE64);
    	//String filename ="/home/chiranjeevi/Desktop/apache-tomcat-8.0.24/webapps/grabber/GrabbedScreenShots/" + UUID.randomUUID().toString();
    	return srcFiler;
    }*/

    @Override
    public void run() {
        // TODO Auto-generated method stub
        isDriverAlive = true;
        for (; isDriverAlive;) {
            if (driver != null) {
                driver.getContext();
            }
            try {
                    Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
