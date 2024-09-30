package com.entrataAsignment.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.entrataAsignment.utils.SeleniumUtility;

public class Navigations extends SeleniumUtility {

	// Constructor
	public Navigations(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators for various menu items
	@FindBy(css = "#w-dropdown-toggle-0 > div.dropdown-menu-text---brix")
	WebElement productNavMenu;

	@FindBy(css = "#w-dropdown-list-0 > div > div.mega-nav > div:nth-child(1) > a.main-page.w-inline-block")
	WebElement propertymngtSubMenu;

	@FindBy(css = "#w-dropdown-list-0 > div > div.mega-nav > div:nth-child(2) > a.main-page.w-inline-block > h3")
	WebElement marketingleasSubMenu;

	@FindBy(css = "#w-dropdown-list-0 > div > div.mega-nav > div:nth-child(3) > a.main-page.w-inline-block > h3")
	WebElement accountingSubMenu;

	@FindBy(css = "#w-dropdown-toggle-5 > div.dropdown-menu-text---brix")
	WebElement solutionsNavMenu;

	@FindBy(css = "#w-dropdown-list-5 > div > a.main-page.head.w-inline-block > h3")
	WebElement allSolutionsMenu;

	@FindBy(css = "#w-dropdown-list-6 > div > a.main-page.head.w-inline-block > h3")
	WebElement allResourcesMenu;

	@FindBy(css = "nav > div.nav-button > a.white-button.mb-full.w-inline-block")
	WebElement watchDemoNavBtn;

	@FindBy(css = "div.nav-button > a.signin-button.mb-full")
	WebElement signUpBtn;

	@FindBy(css = "#w-node-_8dd0d511-faef-57fa-5e27-00f24bd455df-47af4adb > a > div.position-relative")
	WebElement scheduleDemoBtn;

	// Navigation methods

	public void navigateToPropertyMngt() {
		clickOnElement(productNavMenu);
		waitForElementDisplayed(propertymngtSubMenu);
		clickOnElement(propertymngtSubMenu);
	}

	public void navigateToMarketingLease() {
		clickOnElement(productNavMenu);
		waitForElementDisplayed(marketingleasSubMenu);
		clickOnElement(marketingleasSubMenu);
	}

	public void navigateToAccounting() {
		clickOnElement(productNavMenu);
		waitForElementDisplayed(accountingSubMenu);
		clickOnElement(accountingSubMenu);
	}

	public void navigateToResources() {
		clickOnElement(productNavMenu);
		waitForElementDisplayed(allResourcesMenu);
		clickOnElement(allResourcesMenu);
	}

	public void navigateToWatchDemo() {
		clickOnElement(watchDemoNavBtn);
	}

	public void navigateToScheduleDemo() {
		clickOnElement(scheduleDemoBtn);
	}

	public WebElement getProductNavMenu() {
		// TODO Auto-generated method stub
		return null;
	}
}
