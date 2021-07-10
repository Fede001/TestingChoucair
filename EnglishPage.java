package com.project_testing.testing;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*author Joan Federico Marin Ruiz*/

public class EnglishPage {
	
	private  WebDriver driver;
	By keywords = By.name("search_keywords");
	By location = By.name("search_location");
	By searchButton = By.cssSelector("input[value= 'Search Jobs']");
	By result = By.cssSelector("li[class='no_job_listings_found']");
	

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/en/jobs/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	
	@Test
	public void searchingJob() {
		
		driver.findElement(keywords).sendKeys("software developer");
		driver.findElement(location).sendKeys("colombia");
		driver.findElement(searchButton).submit();
		
		assertEquals("There are no listings matching your search.", driver.findElement(result).getText());
		
	}
	
	

}
