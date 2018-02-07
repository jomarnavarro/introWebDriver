package classExercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookAddFriend {

	static WebDriver driver; 

	public static void main(String[] args) { 

		//configurarNavegador 

		configurarNavegador(); 

		//login 

		logearFacebook("clase.selenium.victor@gmail.com", "Test1234"); 

		//buscar 

		buscarAmigo("nombreAmigo"); 

		//agregar 

		agregarAmigo("nombreAmigo"); 
		
		destruirConfiguracion();

	} 


	private static void destruirConfiguracion() {
		driver.close();
		
	}


	private static void configurarNavegador() {  

		//System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe"); 
		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		driver.get("http://www.facebook.com"); 

	} 

	private static void logearFacebook(String usuario, String password) { 
		WebElement campoUsuario; //id=email
		WebElement campoPassword; //id="pass"
		WebElement botonLogin; //data-testid="royal_login_button"
		
		campoUsuario = driver.findElement(By.id("email"));
		campoPassword = driver.findElement(By.id("pass"));
		botonLogin = driver.findElement(By.xpath("//input[@data-testid='royal_login_button']"));
		
		campoUsuario.clear();
		campoUsuario.sendKeys(usuario);
		campoPassword.clear();
		campoPassword.sendKeys(password);
		botonLogin.click();
	} 

	private static void agregarAmigo(String string) {
		

	}

	private static void buscarAmigo(String string) {

	}


}
