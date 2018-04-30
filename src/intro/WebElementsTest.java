package intro;

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
public class WebElementsTest {
	
    public static void main(String[] args) {
        // Configuration lines: Set system Property for context execution.
    	String pathToDriver = "C:/test_automation/drivers/";
        System.setProperty("webdriver.chrome.driver", pathToDriver + "chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://twitter.com/");

        WebElement emailField = driver.findElement(By.id("signin-email"));
        WebElement passwordField = driver.findElement(By.id("signin-password"));
        driver.findElement(By.tagName("button"));

        emailField.sendKeys("test.selenium@gmail.com");
        passwordField.sendKeys("n07MyPassw0rd");

        WebElement signInButton = driver.findElement(By.tagName("button"));
        signInButton.click();

        WebElement forgotPass = driver.findElement(By.linkText("Forgot password?"));
        forgotPass.click();
    }
}
