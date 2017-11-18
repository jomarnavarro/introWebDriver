package tests.sampleTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by design on 11/17/17.
 */


public class ChromeDriverTest {

    public static void main(String[] args){
        // Configuration lines: Set system Property for context execution.
        Path currentRelativePath = Paths.get("");
        String pathToDriver = currentRelativePath.toAbsolutePath().toString() + File.separator + "DriverEXE" + File.separator;
        System.setProperty("webdriver.chrome.driver", pathToDriver + "chromedriver");
        // Driver init
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.mx");
    }
}
