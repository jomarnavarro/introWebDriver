package fBatchRun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestCase implements Runnable {
    private static final long SHORT_WAIT = 10;
    private static final long MEDIUM_WAIT = 20;
    private static final long LONG_WAIT = 30;
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String userSuffix;

    public void setup(String url) {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(SHORT_WAIT, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, MEDIUM_WAIT);
        driver.get(url);
    }

    public static void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch(Exception e) {}
    }

    public void run() {
        //uses the child run method.
    }

    public static TestCase createTest(String tc) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> myClass = Class.forName(tc);
        Constructor<?> ctr = myClass.getConstructor();
        Object obj = ctr.newInstance(new Object[] {});

        return (TestCase) obj;
    }

    public void exitTest() {
        driver.quit();
    }

    public void clickRegisterLink() {
        driver.findElement(By.cssSelector("[href=\"/register\"]")).click();
    }

    public void inputRegistrationInfo(String userPreffix, String password) {
        userSuffix = new Random().nextInt(10000) + "";
        driver.findElement(By.name("username")).sendKeys(userPreffix+userSuffix);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("repeat_password")).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(By.cssSelector(".btn")).click();
    }

    public void validateHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table")));
    }

    public void clickLoginLink() {
        driver.findElement(By.cssSelector("[href=\"/login\"]")).click();
    }

    public void inputCredentials(String userName, String password) {
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);

    }
    public void inputPrefixCredentials(String userPreffix, String password) {
        driver.findElement(By.name("username")).sendKeys(userPreffix+userSuffix);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector(".btn")).click();
    }
}
