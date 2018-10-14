package wsm_TrucNa;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginWSM {

	public String baseUrl = "https://wsm.framgia.vn/";
	public WebDriver driver;

	@BeforeClass
	public void access(){
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(baseUrl);
	}
	
	@Test(priority = 0)
	public void case1(){
		driver.findElement(By.linkText("LOGIN")).click();		
		String expectedTitle = "Login";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		driver.findElement(By.id("user_email"));
		driver.findElement(By.id("user_password"));
		driver.findElement(By.className("wsm-btn login-success"));
		driver.findElement(By.className("wsm-btn login-cancel"));
		driver.findElement(By.className("checkbox-remember"));
		driver.findElement(By.className("btn-forgot-password"));
	}
	
	@Test(priority = 1)
	public void case2() {
		boolean check = driver.findElement(By.id("user_remember_me")).isSelected();
		assertEquals(check, false);
	}
	
	@Test(priority = 2)
	public void case3() {

	}	
	
	@Test(priority = 3)
	public void case4() {
		String expectedPlaceholer = "";
		String actualPlaceholder = driver.findElement(By.id("user_email")).getAttribute("placeholder");
		assertEquals(actualPlaceholder, expectedPlaceholer);
	}
	
	@Test(priority = 4)
	public void case5() {
		String expectedPlaceholer = "";
		String actualPlaceholder = driver.findElement(By.id("user_password")).getAttribute("placeholder");
		assertEquals(actualPlaceholder, expectedPlaceholer);
	}
	
	@Test(priority = 5)
	public void case6() {
		//update correct username and password
		driver.findElement(By.id("user_email")).sendKeys("nguyen.thi.truc.na@framgia.com");
		driver.findElement(By.id("user_password")).sendKeys(("aaaa"));
		driver.findElement(By.name("button")).click();
	}
	@Test(priority = 6)
	public void case7() {
		String expectedTitle = "Working space";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		//System.out.println(actualTitle);
	}
}
