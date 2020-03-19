package com.via.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Exit;

public class BookFlight {
	WebDriver driver;
	WebDriverWait wait;
	String htmlElement;
	By loadingIcon = By.xpath("//div[@class='loadPercent']");
	By bookBtn = By.xpath("(//div[@id='flightSearchResults']//div[@class='result'])[2]//button");

	public BookFlight(WebDriver driver) {
		this.wait = new WebDriverWait(driver, 40);
	}

	public boolean checkLoadingStatus() {
		boolean status = false;
		int test = 0;
		String value = wait.until(ExpectedConditions.visibilityOfElementLocated(loadingIcon)).getText();
		System.out.println("Before Loop " + value);
		/*
		 * while(!value.equalsIgnoreCase("100%")) { status = false;
		 * System.out.println("Inside Loop "+value); }
		 */

		/*
		 * while(!value.equals("99%")) {
		 * 
		 * 
		 * value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//div[@class='loadPercent']"))).getText().toString();
		 * System.out.println("Inside Loop "+value); System.out.println(htmlElement);
		 * System.out.println("Counter "+test); test++; }
		 */

		// while(!value.equals("100%"))
		while (wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon))) {
			System.out.println("Inside while");
			status = true;
			/*
			 * if(wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon)))
			 * { System.out.println("100% reached"); break; } else { value =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * "//div[@class='loadPercent']"))).getText().toString();
			 * System.out.println("Inside Loop "+value); }
			 */
			break;

		}
		// System.out.println("outside loop");

		// value = driver.findElement(loadingIcon).getText();

		// System.out.println("final value"+value);
		return status;
	}

	public void clickBookBtn() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(bookBtn)).click();
	}

}
