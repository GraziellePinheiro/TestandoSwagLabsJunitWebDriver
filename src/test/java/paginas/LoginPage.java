package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver navegador;

    public LoginPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public LoginPage informarUsuario(String usuario){
        navegador.findElement(By.id("user-name")).sendKeys(usuario);

        return this;
    }

    public LoginPage informarSenha(String senha){
        navegador.findElement(By.name("password")).sendKeys(senha);

        return this;
    }

    public ListaDeProdutosPage submeterFormularioLoginComSucesso(){
        navegador.findElement(By.cssSelector("input[type='submit']")).click();

        return new ListaDeProdutosPage(navegador);
    }

    public LoginPage submeterFormularioComErro(){
        navegador.findElement(By.cssSelector("input[type='submit']")).click();

        return new LoginPage(navegador);
    }

    public String capturarMsnApresentada(){
        return navegador.findElement(By.cssSelector("div[class='error-message-container error']")).getText();
    }

    
}
