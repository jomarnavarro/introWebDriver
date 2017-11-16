package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PeliculaEsoDos {
	
	static WebDriver driver;

	public static void main(String[] args) {
		setUp();
		testEso();
		tearDown();
		
		
	}

	private static void setUp() {
		driver = new ChromeDriver();
		
	}

	private static void testEso() {
		String [] actorNames = {"actor1","actor2","actor3","actor4","actor5"};
		String [] characterNames = {"character1","character2","character3","character4","character5"};
		
		for(int i = 0; i < actorNames.length; i++) {
			String xpathColumnaActor = 
					"//table[@class='cast_list']//td[@class='itemprop']";
			WebElement actor = 
					driver.findElement(By.xpath(xpathColumnaActor+"//span[text() = '" + actorNames[i] +"']"));
			WebElement character = 
					driver.findElement(By.xpath(xpathColumnaActor+"/following-sibling::td[@class='character']//a[text()='"+ characterNames[i]+ "']"));
			//validar que ambos existan
		}		// TODO Auto-generated method stub
	}

	private static void tearDown() {
		// TODO Auto-generated method stub
		
	}

}
