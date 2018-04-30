package waits;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by design on 11/17/17.
 */
public class FluentWaitTest {

    public static void main(String[] args) {
        // Configuration lines: Set system Property for context execution.
//        Path currentRelativePath = Paths.get("");
//        String pathToDriver = currentRelativePath.toAbsolutePath().toString() + File.separator + "DriverEXE" + File.separator;
//        System.setProperty("webdriver.chrome.driver", pathToDriver + "chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.mx");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement searchBox = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("lst-ib"));
            }
        });

        searchBox.sendKeys("Quinta generacion de computadoras");

        WebElement searchButton = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.className("lsb"));
            }
        });

        searchButton.click();
    }
}
