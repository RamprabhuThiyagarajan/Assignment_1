package Pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Base.Page;
import Pages.locators.SelectedItemPageLocators;

public class SelectedItemPage extends Page {

	public SelectedItemPageLocators SelectedItem;

	public SelectedItemPage() {
		this.SelectedItem = new SelectedItemPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
		PageFactory.initElements(factory, this.SelectedItem);
	}

	int amount;
	String stringAmount;

	// Method for validating the price
	public SelectedItemPage price() {
		try {
			// Asserting whether the price is displayed
			Assert.assertTrue(SelectedItem.phoneCasePrice.isDisplayed());
			test.log(Status.PASS, "Price is displayed");
		} catch (Throwable t) {
			test.log(Status.FAIL, "Price is not displayed");
			test.fail(t.getMessage());
		}

		// Getting the displayed price as string
		stringAmount = SelectedItem.phoneCasePrice.getText();
		// Removing the other characters in the string to get only numbers
		stringAmount = stringAmount.replaceAll("[^0-9]", "");
		// Converting string to integer
		amount = Integer.parseInt(stringAmount);

		try {
			// Asserting whether the price is greater than 10
			Assert.assertTrue(!(amount < 10));
			test.log(Status.PASS, "Price is greater than Rs.10");
		} catch (Throwable t) {
			test.log(Status.FAIL, "Price is less than Rs.10");
			test.fail(t.getMessage());
		}
		return this;
	}

	// Method for validating "ADD TO BAG" button
	public void addToBag() {
		try {
			// Asserting whether the "ADD TO BAG" button is displayed
			Assert.assertTrue(SelectedItem.addToBagButton.isDisplayed());
			test.log(Status.PASS, "ADD TO BAG button is displayed");
		} catch (Throwable t) {
			test.log(Status.FAIL, "ADD TO BAG button is not displayed");
			test.fail(t.getMessage());
		}
	}
}
