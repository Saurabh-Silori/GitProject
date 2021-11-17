package StepDefinitions;



import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReusableMethods;

public class Hooks extends ReusableMethods {

	
	@Before
	public void beforeScenario(Scenario scenario) {
	
		System.out.println(scenario.getName());
		
		WebDriverManager.chromedriver().setup();
		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
//	
		
		 driver = new ChromeDriver();
		
		
	}
	
	@After()
	
	public void teardown()
	{
		
		driver.quit();
	}
}
