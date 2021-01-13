package prueba;


import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	private WebDriver driver;
	
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.webdriver", "/prueba/src/test/resources/driver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
	@Test
	public void TeestGooglePage() {
		//validamos usuario
		WebElement searchbox = driver.findElement(By.name("email"));
		searchbox.clear();
		searchbox.sendKeys("blabla@bla.bla");
		//Validamos Password
		WebElement searchbox2 = driver.findElement(By.name("passwd"));
		searchbox2.clear();
		searchbox2.sendKeys("blabla");
		searchbox2.submit();
		//damos 10segundos(demasiado) para respuesta
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//comparamos contra el titulo de la pagina(validacion unicamente)
		assertEquals("My account - My Store", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
