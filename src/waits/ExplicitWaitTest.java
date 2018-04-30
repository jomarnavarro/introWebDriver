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
        // Configuration lines: Set system Property for context execution.
        Path currentRelativePath = Paths.get("");
        String pathToDriver = currentRelativePath.toAbsolutePath().toString() + File.separator + "DriverEXE" + File.separator;
        System.setProperty("webdriver.chrome.driver", pathToDriver + "chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://twitter.com/");

        WebDriverWait wait = new WebDriverWait(driver, 15);

        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signin-email")));
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signin-password")));

        emailField.sendKeys("test.selenium@gmail.com");
        passwordField.sendKeys("n07MyPassw0rd");

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        signInButton.click();

        WebElement forgotPass = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Forgot password?")));
        forgotPass.click();
    }
}
