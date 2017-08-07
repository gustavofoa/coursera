import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteFuncionalTradutor {
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
	public void testTraducaoCavalo() throws Exception {
		driver.get(baseUrl + "Tradutor");
		driver.findElement(By.name("palavra")).clear();
		driver.findElement(By.name("palavra")).sendKeys("horse");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("A tradução de horse é: cavalo", driver.findElement(By.cssSelector("h1")).getText());
	}

	@Test
	public void testTraducaoGato() throws Exception {
		driver.get(baseUrl + "Tradutor");
		driver.findElement(By.name("palavra")).clear();
		driver.findElement(By.name("palavra")).sendKeys("cat");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("A tradução de cat é: gato", driver.findElement(By.cssSelector("h1")).getText());
	}

	@Test
	public void testTraducaoRei() throws Exception {
		driver.get(baseUrl + "Tradutor");
		driver.findElement(By.name("palavra")).clear();
		driver.findElement(By.name("palavra")).sendKeys("king");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("A tradução de king é: rei", driver.findElement(By.cssSelector("h1")).getText());
	}

	@Test
	public void testTraducaoDesconhecida() throws Exception {
		driver.get(baseUrl + "Tradutor");
		driver.findElement(By.name("palavra")).clear();
		driver.findElement(By.name("palavra")).sendKeys("desconhecido");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("A tradução de desconhecido é: desconhecido", driver.findElement(By.cssSelector("h1")).getText());
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
