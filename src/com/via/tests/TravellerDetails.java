package com.via.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravellerDetails {
	WebDriver driver;
	WebDriverWait wait;
	String voucherCode;
	By voucherDiv = By.xpath("//div[text()='Available Vouchers']/following-sibling::div");
	By voucherTxtBox = By.xpath("//input[@id='voucherCode']");
	By voucherValidateBtn = By.xpath("//div[@id='voucherValidate']");

	public TravellerDetails(WebDriver driver) {
		this.wait = new WebDriverWait(driver, 40);
	}

	public void getVoucherCode() {

		voucherCode = wait.until(ExpectedConditions.visibilityOfElementLocated(voucherDiv)).getText();
	}

	public void setVoucherCode() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(voucherTxtBox)).sendKeys(voucherCode);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(voucherValidateBtn)).click();

	}

}
