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

public class NavigationBar {
	
	private  WebDriver driver;
	By linkServicios = By.linkText("Servicios");
	By linkNosotros = By.linkText("Nosotros");
	By imageNosotros = By.xpath("//img[@src ='https://www.choucairtesting.com/wp-content/uploads/2018/09/web1_8_original-4.png']");
	By imageServicios = By.xpath("//img[@src ='https://www.choucairtesting.com/wp-content/uploads/2018/10/mision.png']");

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
	public void onClickServicios() {
		driver.findElement(linkServicios).click();
		if (driver.findElement(imageServicios).isDisplayed()) {
		
			List<WebElement> titles = driver.findElements(By.tagName("h2"));
			assertEquals("Capacidades de Pruebas de software Centradas en el negocio", titles.get(0).getText());
		}
		else {System.out.print("page didn't load");}
	}
	
	@Test
	public void onClickNosotros() {
		driver.findElement(linkNosotros).click();
		if (driver.findElement(imageNosotros).isDisplayed()) {
			
			List<WebElement> titles = driver.findElements(By.tagName("h2"));
			assertEquals("Nuestra Misión", titles.get(0).getText());
			
		}
		else {System.out.print("page didn't load");}
				
		
		
		
		
	}

}