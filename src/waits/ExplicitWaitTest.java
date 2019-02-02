package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * Created by design on 11/17/17.
 */
public class ExplicitWaitTest {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://songs-by-sinatra.herokuapp.com");

		WebDriverWait wait = new WebDriverWait(driver, 15);

		WebElement loginLink = wait
								.until(
										ExpectedConditions
										.presenceOfElementLocated(
												By.xpath("//a[@href='/login']")
										)
								);
		loginLink.click();
		WebElement usernameField = wait
								.until(
										ExpectedConditions
										.presenceOfElementLocated(
												By.id("username")
										)
								);

		WebElement passwordField = wait
								.until(
										ExpectedConditions
										.presenceOfElementLocated(
												By.id("password")
										)
								);
		//
		WebElement loginButton = wait
								.until(
										ExpectedConditions
										.presenceOfElementLocated(
												By.xpath("//input[@value = 'Log In']")
										)
								);

		usernameField.sendKeys("frank");
		passwordField.sendKeys("sinatra");
		loginButton.click();

		WebElement loggedInMessage = wait
									.until(
										ExpectedConditions
											.presenceOfElementLocated(
												By.id("flash")
											)
										);
		
		if (loggedInMessage.getText().equals("You are now logged in as frank"))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");

		driver.close();
	}
}
