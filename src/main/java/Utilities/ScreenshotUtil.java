package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.Page;

public class ScreenshotUtil extends Page{
	public static File ScreenShot  ;
	public static String Filename;
	public static void CaptureScreenShot(String name) throws IOException {

		Date d = new Date();
		Filename = name+"_"+d.toString().replace(":", " ").replace(" ", "_")+ ".jpg";
		ScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ScreenShot, new File(".//reports//screenshots//" + Filename));
	}

}
