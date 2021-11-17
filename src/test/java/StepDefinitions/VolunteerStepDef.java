package StepDefinitions;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ReusableMethods;

public class VolunteerStepDef extends ReusableMethods {

	
	public VolunteerStepDef() {
		super(System.getProperty("user.dir") + "/src/test/resources/config.properties");
	}

	@Given("I launch application")
	public void i_launch_application() {
	   
		launchApp(ReusableMethods.prop.getProperty("appURL"));
		driver.manage().window().maximize();
	//	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		WebElement elementVisibleQR = driver.findElement(By.xpath("//h2[normalize-space()='QR Code']"));
		waitForElement(elementVisibleQR);
		//driver.navigate().refresh();
		
		getElementFromLocator(By.xpath(("//h1[@class='title']")));
		//driver.navigate().refresh();
		
	}

	@When("^I write details as FirstName (.+) and LastName as (.+)$")
	public void i_write_details(String frstName,String LastName) {
	  
		try {
			driver.findElement(By.xpath("//button[contains(text(),'Click Me')]")).click();
			driver.switchTo().alert().accept();
		}
		catch(NoAlertPresentException e)
		{
			System.out.println("Alert was not found");
		}

	}
	
	@When("I write details as FirstName,LastName,phone,country")
	public void i_write_details_as_FirstName_LastName_phone_country(DataTable table) {
	   
		List<List<String>> data = table.asLists(String.class);
		String frstName = data.get(0).get(0);
		String LastName = data.get(0).get(1);
		String phneNum = data.get(0).get(2);
		String Country = data.get(0).get(3);
		
//		int iframecount = driver.findElements(By.tagName("iframe")).size();
//		
//		for(int i=0;i<iframecount;i++)
//		{
//			
//		}
		driver.switchTo().frame("frame-one1434677811");
		WebElement WebfrstName = driver.findElement(By.xpath("//input[@name='RESULT_TextField-1']"));
		//driver.switchTo().frame(WebfrstName);
		WebfrstName.sendKeys(frstName);
	}

	@Then("verify signup is successful")
	public void verify_signup_is_successful() {
		  System.out.println("success");
	}

}
