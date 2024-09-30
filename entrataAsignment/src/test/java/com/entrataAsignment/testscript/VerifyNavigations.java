package com.entrataAsignment.testscript;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.entrataAsignment.utils.SeleniumUtility;
import com.entrataAsignment.webpages.Navigations;

public class VerifyNavigations extends SeleniumUtility {

	Navigations navigations;

	@BeforeMethod
	public void navigateTotheWebsite() {
		navigations = new Navigations(driver);
		setUp("Chrome", "https://www.entrata.com/c");
	}

	@Test
	public void navigateTothePropertyMngt() {
		navigations.navigateToPropertyMngt();
		Assert.assertEquals(driver.getTitle(), "Property Management | Entrata");
	}

	@Test
	public void navigateTothemarketingLeas() {
		navigations.navigateToMarketingLease();
		Assert.assertEquals(driver.getTitle(),
				"Entrata Marketing & Leasing Products for your property management needs");
	}

	@Test
	public void navigateTotheAccounting() {
		navigations.navigateToAccounting();
		Assert.assertEquals(driver.getTitle(), "Accounting Solutions for Real Estate Property Management");
	}

	@Test
	public void navigateTotheUtilities() {
		navigations.navigateToResources();
		Assert.assertEquals(driver.getTitle(), "Helpful Resources for the Multifamily Industry");
	}
	
	@Test 
	public void navigateToWatchDemo() {
		navigations.navigateToWatchDemo();
	}
	@Test 
	public void navigateToScheduleDemo() {
		navigations.navigateToScheduleDemo();
	}

}
