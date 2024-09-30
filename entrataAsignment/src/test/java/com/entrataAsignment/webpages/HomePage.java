package com.entrataAsignment.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.entrataAsignment.utils.SeleniumUtility;

public class HomePage extends SeleniumUtility {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#w-dropdown-toggle-7")
	private WebElement productNav;

	@FindBy(css = "div>div.container-5.black-nav.w-container>nav>div:nth-child(2)")
	private WebElement solutionNav;

	@FindBy(xpath = "#w-dropdown-toggle-13 > div.dropdown-menu-text---brix")
	private WebElement resourceNav;

	@FindBy(xpath = "//a[@href='https://summit.entrata.com/' and text()='Summit']")
	private WebElement summitNav;

	@FindBy(xpath = "//a[@href='https://www.entrata.webflow.io/sign-in' and text()='Sign In']")
	private WebElement signUpBtn;

//	@FindBy(css = "body > div.page-wrapper-2 > section > div.hp-a-stats-section > div > div > a > div")
//	private WebElement howsItWorkBtn;

	@FindBy(xpath = "body > div.navbar.w-nav > div.container.black-nav.w-container > a")
	private WebElement logo;

	public void pageLoadSuccessfully() {
		// waitForElementDisplayed(howsItWorkBtn);
		// Assert.assertEquals("Sign Up button is not clickable",
		// isElementExist(signUpBtn));
		waitForElementDisplayed(logo);
		Assert.assertEquals("Logo is not displayed", logo.isDisplayed());
	}
}
