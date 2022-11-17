package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelaFinalPage {
    private WebDriver navegador;

    public TelaFinalPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public TheEndPage finalizar(){
        navegador.findElement(By.id("finish")).click();

        return new TheEndPage(navegador);
    }
    
}
