package Pages.actions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Base.Page;
import Pages.locators.PhoneCasesPageLocators;

public class PhoneCasesPage extends Page {

	public PhoneCasesPageLocators PhoneCase;

	public PhoneCasesPage() {
		this.PhoneCase = new PhoneCasesPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
		PageFactory.initElements(factory, this.PhoneCase);
	}

	String window2;
	// Method for validating the phone case item in the list of phone cases
	public void selectingItem() {
		try {
			// Scrolling the page till the element is found
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", PhoneCase.selectingPhoneCase);

			// Calling the click method in page class
			// for doing click operation on 3rd row 3rd Element
			click(PhoneCase.selectingPhoneCase, "3rd row 3rd Element");
		} catch (Throwable t) {
			test.fail(t.getMessage());
		}

		// Getting the window handles
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		itr.next();
		window2 = itr.next();

		// Switching the window
		driver.switchTo().window(window2);
		test.info("Window switched");

	}
}
