package Pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePageLocators {
	
	@FindBy(xpath = "//a[@data-group='men']")
	public WebElement menTab;

	@FindBy(xpath = "//a[text()='Phone Cases']")
	public WebElement phoneCasesOption;
}
