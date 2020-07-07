package Utility;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import myreports.ExtentManager;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class BaseTest extends TestListener implements ITestListener{
	
	static AppiumDriver<MobileElement> driver;
	protected static ExtentReports myExtent;
	protected  static ExtentTest myTest;
	static AppiumDriverLocalService service;

	@BeforeTest
	public void TestSetUp() throws InterruptedException, IOException
	{
//		System.out.println("Device Id      " + deviceId);
//		System.out.println("Device Name    " + deviceName);
//		System.out.println("Port Number    " + portNumber);
//		<parameter name="deviceId" value="emulator-5554"></parameter>
//		  <parameter name="deviceName" value="Google Pixe 2Xl" ></parameter>
//		  <parameter name="portNumber" value="4723"></parameter>

		
		//startAppiumServer();
		try {
		System.out.print("hi am in base test class");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung A50");
		caps.setCapability(MobileCapabilityType.UDID, "RZ8M41YBJWA");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\tkhan\\git\\appiumapi\\AppiumDemo\\fh.apk");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,caps);
		myExtent = ExtentManager.GetExtent();
		
	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
   }

	
	/*
	 * private void startAppiumServer() { String NodePath =
	 * "C:/Program Files/nodejs/node.exe"; String AppiumMainJSPath =
	 * "C:/Program Files/Appium/resources/app/node_modules/appium/build/lib/main.js"
	 * ;
	 * 
	 * service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
	 * .usingDriverExecutable(new File(NodePath)) .withAppiumJS( new
	 * File(AppiumMainJSPath)) .withIPAddress("127.0.0.1") .usingPort(4723));
	 * System.out.print("Hi am going to start a server"); service.start();
	 * System.out.print("Hi i have started the server"); }
	 */
	
	
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
		myExtent.flush();
		
	}

}
