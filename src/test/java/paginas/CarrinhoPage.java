package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoPage {
    private WebDriver navegador;

    public CarrinhoPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public CarrinhoPage removerProduto(){
        navegador.findElement(By.id("remove-sauce-labs-onesie")).click();

        return this;
    }

    public CheckoutPage checkout(){
        navegador.findElement(By.id("checkout")).click();

        return new CheckoutPage(navegador);
    }
}
