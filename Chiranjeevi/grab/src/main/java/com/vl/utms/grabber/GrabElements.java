package com.vl.utms.grabber;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.appium.java_client.AppiumDriver;

@RestController
public class GrabElements {
	AppiumDriver<WebElement> driver = null;
	Logger LOGGER = Logger.getLogger(GrabElements.class);
	/*
	 * private Thread thread; { thread = new Thread(new DriverFactory(),
	 * "FirstThread"); thread.start(); }
	 */

	@RequestMapping(value = "/launch", method = RequestMethod.GET)
	public ResponseEntity<String> launchDriver() throws InterruptedException, MalformedURLException {
		System.out.println("Launching...");//+ json);
		LOGGER.info("sample log4j INFO message");
//		JSONObject cap= new JSONObject(json);
//		System.out.println("UDID : " + cap.getString("udid"));
		driver = DriverFactory.getDriver();
		System.out.println("App Launched Successfully");
		return new ResponseEntity<String>("App Launched Successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/grab", method = RequestMethod.GET)
	public ResponseEntity<String> grabElements() throws InterruptedException, IOException {
		System.out.println("Got request for grab");
		JSONObject response = new JSONObject();
		if (driver == null)
			return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
		/*
		 * if(thread == null){ thread = new Thread(new DriverFactory(),
		 * "SecondThread"); thread.start(); }
		 */
		// driver = DriverFactory.getDriver();
		// Thread.sleep(10000);
		JSONArray leaves = null;
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		String orientation = driver.getOrientation().value();
		String uri = driver.getScreenshotAs(OutputType.BASE64);
		if (orientation.equals("landscape")) {
			// Image Processing for Landscape
			BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode(uri)));
			// Approach#1
			/*
			 * AffineTransform tx = new AffineTransform(); tx.rotate(Math.PI/2,
			 * bufferedImage.getWidth() / 2, bufferedImage.getHeight() / 2);
			 * 
			 * AffineTransformOp op = new AffineTransformOp(tx,
			 * AffineTransformOp.TYPE_BILINEAR);
			 */
			// Approach#2
			/*
			 * double rotationRequired = Math.toRadians(90); double locationX =
			 * bufferedImage.getWidth() / 2; double locationY =
			 * bufferedImage.getHeight() / 2; AffineTransform tx =
			 * AffineTransform.getRotateInstance(rotationRequired, locationX,
			 * locationY); AffineTransformOp op = new AffineTransformOp(tx,
			 * AffineTransformOp.TYPE_BILINEAR);
			 * 
			 * bufferedImage = op.filter(bufferedImage, null);
			 */

			// Approach#3
			AffineTransform tx = new AffineTransform();

			// last, width = height and height = width
			tx.translate(bufferedImage.getHeight() / 2, bufferedImage.getWidth() / 2);
			tx.rotate(Math.PI / 2);
			// first - center image at the origin so rotate works OK
			tx.translate(-bufferedImage.getWidth() / 2, -bufferedImage.getHeight() / 2);

			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

			// new destination image where height = width and width = height.
			BufferedImage newImage = new BufferedImage(bufferedImage.getHeight(), bufferedImage.getWidth(),
					bufferedImage.getType());
			op.filter(bufferedImage, newImage);

			ImageIO.write(newImage, "PNG", new File("/home/chiranjeevi/test.png"));
			final ByteArrayOutputStream os = new ByteArrayOutputStream();
			try {
				ImageIO.write(newImage, "png", Base64.getEncoder().wrap(os));
				uri = os.toString(StandardCharsets.ISO_8859_1.name());
				// response.put("rotated", "data:image/png;base64, "+rotated);
			} catch (final IOException ioe) {
				throw new UncheckedIOException(ioe);
			}
		}
		// System.out.println(uri);
		try {
			String platform = (String) driver.getCapabilities().getCapability("platformName");
			System.out.println("Platform : " + platform);
			leaves = XmlParser.parse(pageSource, platform);

		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		String imageSrc = "data:image/png;base64, " + uri;
		response.put("uielements", leaves);
		response.put("screenshot", imageSrc);
		response.put("orientation", orientation);
		System.out.println("GrabElements: " + leaves.toString());
		return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
	}

	/*
	 * Converting the byteArray to Base64 URI string
	 * 
	 * public static String encodeImage(byte[] imageByteArray) { return
	 * DatatypeConverter.printBase64Binary(imageByteArray); }
	 * 
	 * public String getScreenShot(String fileName) { String imageDataString =
	 * "";
	 * 
	 * //File pointing to the screenshot dir. File file = new File(fileName);
	 * String fileType = "png"; try { // Reading a Image file from file system
	 * FileInputStream imageInFile = new FileInputStream(file); byte[] imageData
	 * = new byte[(int) file.length()];
	 * 
	 * imageInFile.read(imageData);
	 * 
	 * // Converting Image byte array into Base64 String imageDataString =
	 * encodeImage(imageData);
	 * 
	 * imageInFile.close();
	 * 
	 * //LOGGER.info("Image Successfully Manipulated!"); } catch
	 * (FileNotFoundException e) { //LOGGER.debug("Image not found" + e); }
	 * catch (IOException ioe) { //LOGGER.debug(
	 * "Exception while reading the Image " + ioe); } return "data:image/" +
	 * fileType + ";base64," + imageDataString;
	 * 
	 * }
	 */

	@RequestMapping(value = "/kill", method = RequestMethod.GET)
	public ResponseEntity<String> quitDriver() throws InterruptedException {
		if (driver == null)
			return new ResponseEntity<String>("App not Available to kill", HttpStatus.OK);
		DriverFactory.closeDriver();
		/*
		 * System.out.println("Thread Status : " + thread.isAlive()); thread =
		 * null;
		 */
		return new ResponseEntity<String>("App Killed Successfully", HttpStatus.OK);
	}

}
