package com.entrataAsignment.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.entrataAsignment.utils.SeleniumUtility;

public class ContactUs extends SeleniumUtility {
	WebDriver driver;

	public ContactUs(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
}
