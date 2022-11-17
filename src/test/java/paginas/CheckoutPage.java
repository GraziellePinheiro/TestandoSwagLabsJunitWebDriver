package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver navegador;

    public CheckoutPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public CheckoutPage fillInFirstName(String firstName){
        navegador.findElement(By.id("first-name")).sendKeys(firstName);

        return this;
    }

    public CheckoutPage fillInLastName(String lastName){
        navegador.findElement(By.id("last-name")).sendKeys(lastName);

        return this;
    }

    public CheckoutPage fillInPostalCode(String postalCode){
        navegador.findElement(By.id("postal-code")).sendKeys(postalCode);

        return this;
    }

    public TelaFinalPage submeterFormulariodeCompra(){
        navegador.findElement(By.cssSelector("input[type='submit']")).click();

        return new TelaFinalPage(navegador);
    }
}
