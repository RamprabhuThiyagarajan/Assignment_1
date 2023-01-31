package Pages.actions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Base.Constants;
import Base.Page;
import Pages.locators.HomePageLocators;

public class HomePage extends Page {

	public HomePageLocators Home;

	public HomePage() {
		this.Home = new HomePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
		PageFactory.initElements(factory, this.Home);
	}

	// Method for validating the correct page is loaded successfully
	public void isPageLoaded() {
		String pageURL = driver.getCurrentUrl();
		try {
			// Asserting the loaded page URL
			Assert.assertEquals(pageURL, Constants.testUrl);
			// Log for extent report
			test.log(Status.PASS, "Page loaded successfully");
		} catch (Throwable t) {
			// Log for extent report
			test.log(Status.FAIL, "Page load unsuccessful");
		}
	}

	// Method for validating the home page title
	public HomePage homePageTitle(String ExpectedTitle) {
		String actualTitle = driver.getTitle();
		try {
			//Asserting the home page title
			// to check the title is same as expected
			Assert.assertEquals(actualTitle, ExpectedTitle);
			test.log(Status.PASS, "Application title is same as expected");
		} catch (Throwable t) {
			test.log(Status.FAIL, "Application title is not same as expected");
			test.fail(t.getMessage());
		}
		return this;
	}

	// Method for validating the "men" tab in home page
	public HomePage selectMenTab() {
		try {
			// Calling the verifyEquals method in page class
			// to check the tab name is same as expected
			String actualTabName = Home.menTab.getText();
			Assert.assertEquals(actualTabName, "MEN");

			// Mouse hover action on men tab
			Actions action = new Actions(driver);
			action.moveToElement(Home.menTab).build().perform();
			test.info("Selected the tab : Men");
		} catch (Throwable t) {
			test.fail(t.getMessage());
		}
		return this;
	}

	// Method for validating the "phone cases" option under men tab
	public void selectPhoneCases() {
		try {
			// Calling the click method in page class
			// for doing click operation on phone cases option
			click(Home.phoneCasesOption, "Phone Cases");
		} catch (Throwable t) {
			test.fail(t.getMessage());
		}
	}

}
