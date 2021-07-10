package com.project_testing.testing;

import static org.junit.Assert.*;



import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*author Joan Federico Marin Ruiz*/

public class SearchingSection {
	
	private  WebDriver driver;
	By linkSearching = By.cssSelector("svg[class= 'search-icon']");
	By linkSearching2 = By.cssSelector("button[class='is-search-submit']");
	By blankSearching = By.name("s");
	By language = By.xpath("//a[@href ='#pll_switcher']");
	By englishButton = By.xpath("//a[@href='https://www.choucairtesting.com/en/jobs/']");
	By boxScroll = By.className("sub-menu");
	

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/empleos-testing/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void searchingWithBlank() {
		driver.findElement(linkSearching).click();
		assertTrue(driver.findElement(blankSearching).isDisplayed());	 
		
	}
	
	@Test
	public void searchingWithMatch() {
		
		driver.findElement(linkSearching).click();
		driver.findElement(blankSearching).sendKeys("test");
		driver.findElement(linkSearching2).submit();
		
		List<WebElement> titles = driver.findElements(By.tagName("h3"));
		
		assertEquals("Search Results for: test", titles.get(0).getText());
		
	}
	
	@Test
	public void searchingWithNoMatch() {
		
		driver.findElement(linkSearching).click();
		driver.findElement(blankSearching).sendKeys("asdfad");
		driver.findElement(linkSearching2).submit();
		
		assertEquals("Nothing Found", driver.findElement(By.cssSelector("h1.page-title")).getText());
		
	}
	
	@Test
	public void selectLanguage() {
		
		driver.findElement(language).click();
		if (driver.findElement(boxScroll).isDisplayed()){
			
			driver.findElement(englishButton).click();
			
			List<WebElement> titles = driver.findElements(By.tagName("h2"));
			assertEquals("BE CHOUCAIR", titles.get(0).getText());		
			
			
			
		}
			
			
		
		
	}
	
	

}
