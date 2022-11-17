package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TheEndPage {
    private WebDriver navegador;

    public TheEndPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public String captureTextFinal(String textFinal){
        return navegador.findElement(By.cssSelector("h2[class='complete-header']")).getText();
    }
}
