package com.project_testing.testing;

import static org.junit.Assert.assertEquals;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*author Joan Federico Marin Ruiz*/

public class Icons {
	
	private  WebDriver driver;
	By iconApply = By.cssSelector("img[title= 'empleosazulMesa de trabajo 1']");
	By iconWhatIs = By.cssSelector("img[title= 'serchazuleMesa de trabajo 1']");
	By jobButton = By.className("elementor-button-text");	
	

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
	public void onClickApply() {
		driver.findElement(iconApply).click();
		
		List<WebElement> titles = driver.findElements(By.tagName("h2"));
		assertEquals("PREPARARSE PARA APLICAR", titles.get(2).getText());	 
		
	}
	
	@Test
	public void onClickWhatis() {
		driver.findElement(iconWhatIs).click();
		
		List<WebElement> titles = driver.findElements(By.tagName("h2"));
		assertEquals("SER CHOUCAIR", titles.get(0).getText());	 
		
	}
	/*	
	@Test
	public void onClickJob() {
		
		driver.findElement(jobButton).submit();
		
		assertTrue(driver.findElement(By.id("elementor-popup-modal-11876")).isDisplayed());
		
		
	}*/

}
