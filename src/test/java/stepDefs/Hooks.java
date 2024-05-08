package stepDefs;



import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public static void setupDriver() throws IOException   {
		TestBase.initDriver();
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			TakesScreenshot screen=(TakesScreenshot)TestBase.getDriver();
			byte[] imgByte=screen.getScreenshotAs(OutputType.BYTES);
			scenario.attach(imgByte, "image/png", "ScreenshotImage");
		}
	}

}
