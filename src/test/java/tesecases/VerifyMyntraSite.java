package tesecases;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Page;
import Pages.actions.HomePage;
import Pages.actions.PhoneCasesPage;
import Pages.actions.SelectedItemPage;
import Utilities.ExcelReader;

public class VerifyMyntraSite {

	public static WebDriver driver;

	// Method that run before suite to setup the browser
		@BeforeSuite
		public void browserSetUp() {
			// Calling the method initConfiguration in base page class
			// for configuring browser and extent report
			Page.initConfiguration();
		}

	// Test case
	@Test(dataProviderClass = ExcelReader.class, dataProvider = "dataProvider")
	public void Myntra(Hashtable<String, String> data) {
		HomePage home = new HomePage();
		String ExpectedTitle = data.get("ExpectedTitle");
		// Calling isPageLoaded method for page URL assertion
		home.isPageLoaded();
		// Calling homePageTitle method for title assertion
		home.homePageTitle(ExpectedTitle);
		// Calling selectMenTab and selectPhoneCases methods
		// for selecting "phone cases" option under "men" tab
		home.selectMenTab().selectPhoneCases();

		PhoneCasesPage phoneCase = new PhoneCasesPage();
		// Calling selectingItem method for selecting phone case
		phoneCase.selectingItem();

		SelectedItemPage selectedItem = new SelectedItemPage();
		// Calling price method for asserting price displayed
		selectedItem.price();
		// Calling addToBag method for asserting "addToBag" button
		selectedItem.addToBag();

	}

	/*
	 * @Test(dataProviderClass = ExcelReader.class, dataProvider = "dp", priority =
	 * 1) public void homePageTitleTest(Hashtable<String, String> data) { HomePage
	 * home = new HomePage(); String ExpectedTitle = data.get("ExpectedTitle");
	 * System.out.println(ExpectedTitle);
	 * 
	 * home.homePageTitle(ExpectedTitle);
	 * 
	 * }
	 * 
	 * @Test(priority = 2) public void selectPhoneCasesTest() throws
	 * InterruptedException { HomePage home = new HomePage();
	 * 
	 * home.selectMenTab().selectPhoneCases();
	 * 
	 * }
	 * 
	 * @Test(priority = 3) public void selectingItemTest() { PhoneCasesPage
	 * phoneCase = new PhoneCasesPage(); phoneCase.selectingItem();
	 * 
	 * }
	 * 
	 * @Test(priority = 4) public void priceTest() { SelectedItemPage selectedItem =
	 * new SelectedItemPage(); selectedItem.price();
	 * 
	 * }
	 * 
	 * @Test(priority = 5) public void addToBagTest() { SelectedItemPage
	 * selectedItem = new SelectedItemPage(); selectedItem.addToBag(); }
	 */

	// Method that run before test for configuring extent report
	@BeforeTest
	public void reportConfiguration() {
		// Calling the method reportConfiguration in base class
		// for configuring extent report
		Page.reportConfiguration();
	}

	// Method that run after test to flush the report
	@AfterTest
	public void flushReport() {
		// Calling the method flushReport in base class
		// for flushing extent report
		Page.flushReport();
	}

	// Method that run after suite for quitting the browser
	@AfterSuite
	public void quitBrowser() {
		// Calling the method tearDown in base class
		// for quitting the browser
		Page.tearDown();
	}

}
