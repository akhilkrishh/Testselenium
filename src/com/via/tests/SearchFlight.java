package com.via.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFlight {
	WebDriver driver;
	WebDriverWait wait;
	By noThanksBtn = By.xpath("//button[text()='No thanks!']");
	By roundTripBtn = By.xpath("//label[text()='Round trip']");
	By sourceLocation = By.xpath("//input[@id='source']");
	By souceSelected = By.xpath("//span[text()='Kochi Airport,Kochi - Japan']");
	By destLocation = By.xpath("//input[@id='destination']");
	By destSelected = By.xpath("//span[text()='Bangalore,Bangalore - India']");
	By departureCalndr = By.xpath("//input[@id ='departure']/parent::div");
	By departureDate = By.xpath("(//div[@id='depart-cal']/div[3]/div[2]/div/div[@class='vc-cell '])[1]");

	By returnCalndr = By.xpath("//input[@id ='return']/parent::div");
	By returnDate = By.xpath("(//div[@id='return-cal']/div[3]/div[2]/div/div[@class='vc-cell '])[4]");

	By adultsCount = By.xpath("//label[text()='Adults ']/parent::div/div/child::div[3]");
	By childrenCount = By.xpath("//label[text()='Children ']/parent::div/div/child::div[3]");
	By infantCount = By.xpath("//label[text()='Infants ']/parent::div/div/child::div[3]");

	By searchFlightBtn = By.xpath("//div[text()='Search Flights']");

	public SearchFlight(WebDriver driver) {
		this.wait = new WebDriverWait(driver, 40);
	}

	public void enterSourceLocation(String sourceLoc) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(noThanksBtn)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(roundTripBtn)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocation)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocation)).sendKeys(sourceLoc);
		wait.until(ExpectedConditions.visibilityOfElementLocated(souceSelected)).click();
	}

	public void enterDestLocation(String destLoc) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(destLocation)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(destLocation)).sendKeys(destLoc);
		wait.until(ExpectedConditions.visibilityOfElementLocated(destSelected)).click();
	}

	public void selectDepartureDate() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(departureCalndr)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(departureDate)).click();
	}

	public void selectReturnDate() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(returnCalndr)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(returnDate)).click();
	}

	public void selectPassengers() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(adultsCount)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(childrenCount)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(infantCount)).click();
	}

	public void searchFlight() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(searchFlightBtn)).click();
	}

}
