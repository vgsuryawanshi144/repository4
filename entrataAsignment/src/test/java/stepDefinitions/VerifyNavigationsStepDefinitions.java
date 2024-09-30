package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.entrataAsignment.utils.SeleniumUtility;
import com.entrataAsignment.webpages.Navigations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyNavigationsStepDefinitions extends SeleniumUtility {

	Navigations navigations;

	@Given("^I navigate to the website$")
	public void navigateToWebsite() {
		navigations = new Navigations(driver);
		setUp("Chrome", "https://www.entrata.com/c");
	}

	@Given("^I navigate to the homepage$")
	public void navigateToHomePage() {
		driver.get(baseUrl);
	}

	@When("^I navigate to the Property Management page$")
	public void navigateToPropertyMngtPage() {
		navigations.navigateToPropertyMngt();
	}

	@When("^I navigate to the Marketing & Leasing page$")
	public void navigateToMarketingLeasePage() {
		navigations.navigateToMarketingLease();
	}

	@When("^I navigate to the Accounting page$")
	public void navigateToAccountingPage() {
		navigations.navigateToAccounting();
	}

	@When("^I navigate to the Resources page$")
	public void navigateToResourcesPage() {
		navigations.navigateToResources();
	}

	@When("^I click on the \"Watch Demo\" button$")
	public void clickWatchDemo() {
		navigations.navigateToWatchDemo();
	}

	@When("^I click on the \"Schedule Demo\" button$")
	public void clickScheduleDemo() {
		navigations.navigateToScheduleDemo();
	}

	@Then("^the page title should be \"([^\"]*)\"$")
	public void verifyPageTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Then("^the Entrata logo should be displayed$")
	public void verifyLogoDisplayed() {
		WebElement logo = driver.findElement(By.xpath("//img[@alt='Entrata Logo']"));
		Assert.assertTrue(logo.isDisplayed());
	}

	@When("^I click on the \"Solutions\" link$")
	public void clickSolutionsLink() {
		WebElement solutionsLink = driver.findElement(By.xpath("//a[text()='Solutions']"));
		solutionsLink.click();
	}

	@When("^I click on the \"Sign In\" link$")
	public void clickSignInLink() {
		WebElement loginLink = driver.findElement(By.xpath("//a[text()='Sign In']"));
		loginLink.click();
	}

	@When("^I fill in the Contact Us form with valid details$")
	public void fillContactUsForm() {
		driver.findElement(By.id("name")).sendKeys("John Doe");
		driver.findElement(By.id("email")).sendKeys("johndoe@example.com");
		driver.findElement(By.id("phone")).sendKeys("1234567890");
		driver.findElement(By.id("message")).sendKeys("This is a test message.");
	}

	@When("^I submit the form$")
	public void submitForm() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}

	@Then("^I should see a success message$")
	public void verifySuccessMessage() {
		WebElement successMessage = driver.findElement(By.id("success-message"));
		Assert.assertTrue(successMessage.isDisplayed());
	}

	@When("^I hover over the \"Solutions\" menu$")
	public void hoverOverSolutionsMenu() {
		WebElement mainMenu = driver.findElement(By.xpath("//a[text()='Solutions']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(mainMenu).perform();
	}

	@Then("^I should see the submenus$")
	public void verifySubMenus() {
		List<WebElement> subMenus = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//a"));
		Assert.assertTrue(!subMenus.isEmpty(), "Submenus are not visible.");
	}

	@When("^I click on each footer link$")
	public void clickFooterLinks() {
		List<WebElement> footerLinks = driver.findElements(By.xpath("//footer//a"));
		for (WebElement link : footerLinks) {
			String expectedUrl = link.getAttribute("href");
			link.click();
			String actualUrl = driver.getCurrentUrl();
			Assert.assertTrue(actualUrl.contains(expectedUrl));
			driver.navigate().back();
		}
	}

	@Then("^the correct page should load for each footer link$")
	public void verifyFooterLinkPageLoad() {
		// Footer link verification is done in the previous step
	}
}
