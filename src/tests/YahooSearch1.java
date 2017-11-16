package tests;

public class YahooSearch1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.yahoo.com");
		//verificar que este la caja de busqueda
		if(driver.findElement(By.id("uh-search-box")).isDisplayed()) {
			System.out.println("Verification 1 pasada");
		} else {
			System.out.println("Verification 1 fallada");
			System.exit(-1);
		}
		//introducir texto en la caja de busqueda
		driver.findElement(By.id("uh-search-box")).clear();
		driver.findElement(By.id("uh-search-box")).sendKeys("Selenium");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//verificar que exista el boton de buscar
		//dar click en el boton de buscar
		
		driver.close();
		driver.quit();

	}

}
