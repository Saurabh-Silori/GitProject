package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableMethods {

	public static WebDriver driver;
	public static Properties prop;
	
	public void launchApp(String strAppURL)
	{
		driver.get(strAppURL);
		
	}
	// Constructor
	public ReusableMethods() {
	}

		
	public ReusableMethods(String strConfFileName) {
		this.prop = loadPropertyFile(strConfFileName);
	}

	public Properties loadPropertyFile(String strConfFileName) {
		Properties prop = new Properties();
		try {
			File file = new File(strConfFileName);
			FileInputStream ip = new FileInputStream(file);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
		
	
	public WebElement waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	
	public WebElement getElementFromLocator(By elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
		return element;
	}

	
	}

