import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteFuncionalCelsiusFahrenheit {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\opt\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/";
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e){
			System.out.println("Error on set timeout: " + e.getMessage());
		}
	}

	@Test
	public void testCelsiusToFahrenheit() throws Exception {
		driver.get(baseUrl + "/CelsiusFahrenheit/");
		WebElement typeElement = driver.findElement(By.id("type"));
		typeElement.click();
		typeElement.sendKeys("Celsius para Fahrenheit");
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("100");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("100 graus Celsius equivale a 212 Fahrenheit!", driver.findElement(By.cssSelector("pre")).getText());
	}

	@Test
	public void testFahrenheitToCelsius() throws Exception {
		driver.get(baseUrl + "/CelsiusFahrenheit/");
		WebElement typeElement = driver.findElement(By.id("type"));
		typeElement.click();
		typeElement.sendKeys("Fahrenheit para Celsius");
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("212");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("212 Fahrenheit equivale a 100 graus Celsius!", driver.findElement(By.cssSelector("pre")).getText());
	}

	@After
	public void tearDown() throws Exception {
		try{
			driver.quit();
		} catch (Exception e){
			System.out.println("Error on quit browser: " + e.getMessage());
		}
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
