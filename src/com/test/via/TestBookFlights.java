package com.test.via;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.via.tests.BookFlight;
import com.via.tests.SearchFlight;
import com.via.tests.TravellerDetails;

public class TestBookFlights {

	/*
	 * public static void main(String[] args) throws InterruptedException,
	 * IOException { // TODO Auto-generated method stub
	 * System.setProperty("webdriver.chrome.driver",
	 * "F:\\Selenium Class\\Chromedriver\\chromedriver.exe"); WebDriver driver = new
	 * ChromeDriver(); driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	 */
	WebDriver driver;

	@Test
	public void testfunction() throws Exception {
		// Read url from properties file
		FileInputStream opropertyFile = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		Properties oProp = new Properties();
		oProp.load(opropertyFile);
		String webSiteUrl = oProp.getProperty("url");
		driver.get(webSiteUrl);

		// First page
		// From
		// button[@id='wzrk-cancel']
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wzrk-cancel']"))).click();

		/*
		 * String mainWindow = driver.getWindowHandle(); //Set<String> S1 =
		 * driver.getWindowHandles(); Thread.sleep(5000); Set<String> childWindows =
		 * driver.getWindowHandles(); Iterator<String> it = childWindows.iterator();
		 * 
		 * driver.switchTo().alert(); String parentWindowId = it.next();
		 * System.out.println("Parent: "+parentWindowId);
		 * 
		 * String childWindowId = it.next();
		 * System.out.println("Child :"+childWindowId);
		 */
		SearchFlight objSearchFlight = new SearchFlight(driver);
		objSearchFlight.enterSourceLocation("Kochi");
		objSearchFlight.enterDestLocation("Bangalore");
		objSearchFlight.selectDepartureDate();
		objSearchFlight.selectReturnDate();
		objSearchFlight.selectPassengers();
		objSearchFlight.searchFlight();
		BookFlight objBookFlight = new BookFlight(driver);
		if (objBookFlight.checkLoadingStatus()) {
			System.out.println("Code to book flight");
			objBookFlight.clickBookBtn();
			TravellerDetails objTravellerDetails = new TravellerDetails(driver);
			objTravellerDetails.getVoucherCode();
			objTravellerDetails.setVoucherCode();
		}
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Class\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// (dataProvider = "getData")
	@Test
	public void dummyfunction1(String startLoc, String destLoc)
	// public void dummyfunction1()
	{
		System.out.println("Inside dummy fn1");
		System.out.println(startLoc);
		System.out.println(destLoc);

	}

	@Test(dependsOnMethods = { "testfunction", "dummyfunction1" })
	public void dummyfunction2() {
		System.out.println("Inside dummy fn2");
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][2];
		data[0][0] = "Kochi";
		data[0][1] = "Bangalore";
		data[1][0] = "Kochi";
		data[1][1] = "Chennai";
		return data;
	}

}
