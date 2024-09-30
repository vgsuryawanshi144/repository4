package com.entrataAsignment.testscript;

import org.openqa.selenium.WebElement;
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
	 @Test
	    public void validateHomePageTitle() {
	        // Navigate to the homepage
	        driver.get(baseUrl);

	        // Validate the page title
	        String expectedTitle = "Property Management Software | Entrata";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle, "Home page title is incorrect.");
	    }

	    @Test
	    public void validateLogoDisplayed() {
	        // Check if the logo is displayed on the homepage
	        WebElement logo = driver.findElement(By.xpath("//img[@alt='Entrata Logo']"));
	        Assert.assertTrue(logo.isDisplayed(), "Entrata logo is not visible.");
	    }

	    @Test
	    public void navigateToSolutionsPage() {
	        // Click on the 'Solutions' link from the homepage
	        WebElement solutionsLink = driver.findElement(By.xpath("//a[text()='Solutions']"));
	        solutionsLink.click();

	        // Validate that the Solutions page is loaded
	        String expectedSolutionsTitle = "Solutions | Entrata";
	        String actualSolutionsTitle = driver.getTitle();
	        Assert.assertEquals(actualSolutionsTitle, expectedSolutionsTitle, "Solutions page title is incorrect.");
	    }

	    @Test
	    public void navigateToLoginPage() {
	        // Click on the 'Sign In' link from the homepage
	        WebElement loginLink = driver.findElement(By.xpath("//a[text()='Sign In']"));
	        loginLink.click();

	        // Validate that the login page is loaded
	        String expectedLoginTitle = "Login | Entrata";
	        String actualLoginTitle = driver.getTitle();
	        Assert.assertEquals(actualLoginTitle, expectedLoginTitle, "Login page title is incorrect.");
	    }
	    
	    @Test
	    public void validateContactUsForm() {
	        // Navigate to the Contact Us page
	        WebElement contactUsLink = driver.findElement(By.xpath("//a[text()='Contact Us']"));
	        contactUsLink.click();

	        // Fill in the contact form fields
	        WebElement nameField = driver.findElement(By.id("name"));
	        WebElement emailField = driver.findElement(By.id("email"));
	        WebElement phoneField = driver.findElement(By.id("phone"));
	        WebElement messageField = driver.findElement(By.id("message"));
	        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));

	        nameField.sendKeys("John Doe");
	        emailField.sendKeys("johndoe@example.com");
	        phoneField.sendKeys("1234567890");
	        messageField.sendKeys("This is a test message.");

	        // Submit the form
	        submitButton.click();

	        // Validate successful form submission (e.g., a success message or redirection)
	        WebElement successMessage = driver.findElement(By.id("success-message"));
	        Assert.assertTrue(successMessage.isDisplayed(), "Contact form submission failed.");
	    }
	    

	    @Test
	    public void validateWatchDemo() {
	        // Locate and click on the 'Watch Demo' button/link
	        WebElement watchDemoButton = driver.findElement(By.xpath("//a[text()='Watch Demo']"));
	        watchDemoButton.click();

	        // Assert that the demo video or content is displayed (e.g., video iframe)
	        WebElement demoVideo = driver.findElement(By.xpath("//iframe[@title='Demo Video']"));
	        Assert.assertTrue(demoVideo.isDisplayed(), "Demo video is not visible.");
	    }

	    @Test
	    public void validateScheduleDemoForm() {
	        // Locate and click on the 'Schedule Demo' button/link
	        WebElement scheduleDemoButton = driver.findElement(By.xpath("//a[text()='Schedule Demo']"));
	        scheduleDemoButton.click();

	        // Fill in the form fields
	        WebElement nameField = driver.findElement(By.id("name"));
	        WebElement emailField = driver.findElement(By.id("email"));
	        WebElement phoneField = driver.findElement(By.id("phone"));
	        WebElement companyField = driver.findElement(By.id("company"));
	        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));

	        nameField.sendKeys("John Doe");
	        emailField.sendKeys("johndoe@example.com");
	        phoneField.sendKeys("1234567890");
	        companyField.sendKeys("Test Company");

	        // Submit the form
	        submitButton.click();

	        // Validate the success message after submission
	        WebElement successMessage = driver.findElement(By.id("success-message"));
	        Assert.assertTrue(successMessage.isDisplayed(), "Demo scheduling failed.");
	    }
	    
	    @Test
	    public void validateMultipleSubMenus() {
	        // Locate the main menu (e.g., 'Solutions')
	        WebElement mainMenu = driver.findElement(By.xpath("//a[text()='Solutions']"));

	        // Hover over the main menu to reveal the submenus
	        Actions actions = new Actions(driver);
	        actions.moveToElement(mainMenu).perform();

	        // Locate all submenus under the main menu
	        List<WebElement> subMenus = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//a"));

	        // Loop through all the submenus and validate them
	        for (WebElement subMenu : subMenus) {
	            String subMenuName = subMenu.getText();
	            Assert.assertTrue(subMenu.isDisplayed(), "Submenu " + subMenuName + " is not displayed.");

	            // Click the submenu and validate navigation
	            subMenu.click();
	            String expectedTitle = subMenuName + " | Entrata";
	            String actualTitle = driver.getTitle();
	            Assert.assertEquals(actualTitle, expectedTitle, "Navigation to " + subMenuName + " failed.");

	            // Go back to the main menu and hover again to check the next submenu
	            driver.navigate().back();
	            actions.moveToElement(mainMenu).perform();
	        }
	    }
	    
	    @Test
	    public void validateFooterLinks() {
	        // Locate all footer links (assumed to be within a <footer> tag)
	        List<WebElement> footerLinks = driver.findElements(By.xpath("//footer//a"));

	        // Iterate through each footer link, click it, and validate the navigation
	        for (WebElement link : footerLinks) {
	            String linkText = link.getText();
	            String expectedUrl = link.getAttribute("href");

	            // Click on the footer link
	            link.click();

	            // Validate the page URL or title
	            String actualUrl = driver.getCurrentUrl();
	            Assert.assertTrue(actualUrl.contains(expectedUrl), "Navigation to " + linkText + " failed.");

	            // Go back to the homepage after each link validation
	            driver.navigate().back();

	            // Relocate the footer links after going back
	            footerLinks = driver.findElements(By.xpath("//footer//a"));
	        }
	    }

}
