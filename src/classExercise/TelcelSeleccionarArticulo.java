package classExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TelcelSeleccionarArticulo {

    static WebDriver driver;

    public static void main(String[] args) {
        navegarSitio("https://www.telcel.com");
        verificarLandingPage();
        listarTelefonos();
        seleccionarEstado("Jalisco");
        verificarPaginaResultados();
        Celular primerCelular;
        primerCelular = capturarDatosCelular(1);
        seleccionarCelular(1);
        validarDatosCelular(primerCelular);
    }



    private static void navegarSitio(String url) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);
    }

    private static void verificarLandingPage() {
        //verificar que existen estos elementos
//        logoTelcel:  css="[src='/content/dam/htmls/img/icons/logo-telcel.svg']"
        WebElement logoTelcel = driver.findElement(By.cssSelector("[src='/content/dam/htmls/img/icons/logo-telcel.svg']"));
        WebElement tiendaEnLinea = driver.findElement(By.cssSelector("[data-nombreboton='Tienda en linea superior']"));
        WebElement campoBusqueda = driver.findElement(By.cssSelector("#buscador-menu-input"));
        if(logoTelcel.isDisplayed() &&
                tiendaEnLinea.isDisplayed() &&
                campoBusqueda.isDisplayed() && campoBusqueda.isEnabled()) {
            System.out.println("Si cargo la pagina principal de telcel");
        } else {
            System.out.println("No cargo la pagina");
            System.exit(-1);
        }
//        linkTiendaEnLinea:css="[data-nombreboton='Tienda en linea superior']"

//        campoBusqueda: css= "#buscador-menu-input" 


    }

    private static void listarTelefonos() {
        WebElement tiendaEnLinea = driver.findElement(By.cssSelector("[data-nombreboton='Tienda en linea superior']"));
        tiendaEnLinea.click();
        WebElement linkTelefonosCelulares = driver.findElement(By.cssSelector(".shortcut-container [data-nombreboton='Telefonos y smartphones']"));
        linkTelefonosCelulares.click();
    }

    private static void seleccionarEstado(String nombreEstado) {
        System.out.println("breakpoint instruction.");
        WebElement seleccionaEstadoDropdown = driver.findElement(By.cssSelector(".modal .chosen-single"));
        if(seleccionaEstadoDropdown.isDisplayed()) {
            seleccionaEstadoDropdown.click();
        } else {
            System.out.println("Fallo el modal");
            System.exit(-1);
        }
        WebElement inputEstado = driver.findElement(By.cssSelector(".chosen-search input"));
        inputEstado.sendKeys(nombreEstado);
        WebElement opcionEstado = driver.findElement(By.cssSelector(".chosen-results li"));
        opcionEstado.click();
        WebElement botonEntrar = driver.findElement(By.id("entrarPerfilador"));
        botonEntrar.click();
    }

    private static void verificarPaginaResultados() {
        List<WebElement> celulares = driver.findElements(By.cssSelector(".comp-telcel-mosaico-equipos li"));
        System.out.println(celulares.size());
        if(celulares.size() > 1) {
            System.out.println("La lista se desplego correctamente.");
        }
    }

    private static Celular capturarDatosCelular(int i) {
        WebElement textoMarcaModelo = driver.findElement(By.cssSelector(".telcel-mosaico-equipos-marca"));
        String mm = textoMarcaModelo.getText();

        WebElement textoNombre = driver.findElement(By.cssSelector(".telcel-mosaico-equipos-nombre-equipo"));
        String nombreEquipo = textoNombre.getText();


        WebElement textoPrecio = driver.findElement(By.cssSelector(".telcel-mosaico-equipos-precio"));
        String precioEquipo = textoPrecio.getText();
        precioEquipo = precioEquipo.replace(",", "");
        precioEquipo = precioEquipo.replace("$", "");
        double pe = Double.parseDouble(precioEquipo);


        WebElement textoCapacidad = driver.findElement(By.cssSelector(".telcel-mosaico-equipos-capacidad-numero"));
        String capacidadEquipo = textoCapacidad.getText();
        String[] datos = capacidadEquipo.split(" ");
        String capacidadString = datos[0];
        int numGigas = Integer.parseInt(capacidadString);


        return new Celular(mm, nombreEquipo, pe, numGigas);
    }

    private static void seleccionarCelular(int numCelular) {
        List<WebElement> celulares = driver.findElements(By.cssSelector(".comp-telcel-mosaico-equipos li"));
        System.out.println(celulares.size());
        WebElement celular = celulares.get(numCelular - 1);
        celular.click();
    }

    private static void validarDatosCelular(Celular primerCelular) {
    }
}
