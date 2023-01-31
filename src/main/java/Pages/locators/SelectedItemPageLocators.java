package Pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectedItemPageLocators {

	@FindBy(xpath = "//span[@class='pdp-price']//child::strong")
	public WebElement phoneCasePrice;
	
	@FindBy(xpath = "//div[contains(@class,'add-to-bag')]")
	public WebElement addToBagButton;
}
