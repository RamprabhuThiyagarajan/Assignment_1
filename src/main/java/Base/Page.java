package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Page {

	public static WebDriver driver;

	public static WebDriverWait wait;
	public static ExtentTest test;
	public static ExtentReports extent = new ExtentReports();
	public static ExtentSparkReporter spark = new ExtentSparkReporter(
			System.getProperty("user.dir") + "\\reports\\extentReport.html");

	// Method for click operation
	public void click(WebElement element, String elementName) {
		element.click();
		test.log(Status.INFO, "Clicking on : " + elementName);
	}

	// Method for send keys operation
	public void type(WebElement element, String elementName, String value) {
		element.sendKeys(value);
		test.log(Status.INFO, "Typing in : " + elementName + "<br>" + "Entered value : " + value);
	}

	// Method for initial browser and extent report configuration
	public static void initConfiguration() {
		if (Constants.browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (Constants.browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Constants.browser.equals("edge")) {
			driver = new EdgeDriver();
		}

		driver.get(Constants.testUrl);
		driver.manage().window().maximize();

		spark.config().setEncoding("utf-8");
		spark.config().setDocumentTitle("Extent Report");
		spark.config().setReportName("Ramprabhu");
		spark.config().setTheme(Theme.DARK);

		extent.setSystemInfo("Tester", "Ramprabhu");
		extent.setSystemInfo("Orgainzation", "propel");
	}

	// Method for reportConfiguration
	public static void reportConfiguration() {
		extent.attachReporter(spark);
	}

	// Method for report flush function
	public static void flushReport() {
		extent.flush();
	}

	// Method for quitting the browser
	public static void tearDown() {
		driver.quit();
	}

}
