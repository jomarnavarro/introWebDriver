package bIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by design on 11/17/17.
 */
public class WebElementsTest {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://songs-by-sinatra.herokuapp.com");

		WebElement loginLink = driver.findElement(By.xpath("//a[@href='/login']"));
		loginLink.click();
		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@value = 'Log In']"));

		usernameField.sendKeys("frank");
		passwordField.sendKeys("sinatra");
		loginButton.click();

		WebElement loggedInMessage = driver.findElement(By.id("flash"));
		if (loggedInMessage.getText().equals("You are now logged in as frank"))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		driver.close();
	}
}
