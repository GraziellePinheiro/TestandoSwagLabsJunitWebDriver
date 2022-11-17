package modulos.produtos;

import java.time.Duration;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import paginas.LoginPage;

@DisplayName("Testando o site SwagLabs.")
public class ProdutosTest{

    protected WebDriver navegador;
    private static final String URL_BASE = "https://www.saucedemo.com/";
    private static final String CAMINHO_NAVEGADOR = "C:/drivers/chromedriver-107.0.5304.62.exe";

    
    @BeforeEach
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_NAVEGADOR);
        this.navegador = new ChromeDriver();

        this.navegador.manage().window().maximize();

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        this.navegador.get(URL_BASE);
    }

    @Test
    @DisplayName("Deve logar com email e senha corretos")
    public void TC001logarComsucesso(){
        new LoginPage(navegador)
        .informarUsuario("standard_user")
        .informarSenha("secret_sauce")
        .submeterFormularioLoginComSucesso()
        .selecionarMochila()
        .adicionarMochilaCarrinho()
        .retornarListaDeProdutos()
        .selecionarRoupaInfantil()
        .adicionarRoupaInfantil()
        .retornarListaDeProdutos()
        .verDetalhesDaCompra()
        .removerProduto()
        .checkout()
        .fillInFirstName("Fulano")
        .fillInLastName("Ciclano")
        .fillInPostalCode("08215330")
        .submeterFormulariodeCompra()
        .finalizar();

        String textFinal = "THANK YOU FOR YOUR ORDER";

        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", textFinal);
        
    }

    @Test
    @DisplayName("Tentar logar com o campo email vazio.")
    public void TC002logarEmailVazio(){
        new LoginPage(navegador)
        .informarUsuario("")
        .informarSenha("secret_sauce")
        .submeterFormularioComErro()
        .capturarMsnApresentada();
        
        String msg = "Epic sadface: Username is required";
        Assertions.assertEquals("Epic sadface: Username is required", msg);
    }

    @Test
    @DisplayName("Tentar logar com o campo senha vazio.")
    public void TC003logarCampoSenhaVazio(){
        new LoginPage(navegador)
        .informarUsuario("standard_user")
        .informarSenha("")
        .submeterFormularioComErro()
        .capturarMsnApresentada();

        String msg = "Epic sadface: Password is required";
        Assertions.assertEquals("Epic sadface: Password is required", msg);
        
    }

    @Test
    @DisplayName("Tentar logar com o campo email e senha vazio.")
    public void TC004logarCampoEmailSenhaVazio(){
        new LoginPage(navegador)
        .informarUsuario("")
        .informarSenha("")
        .submeterFormularioComErro()
        .capturarMsnApresentada();

        String msg = "Epic sadface: Username is required";
        Assertions.assertEquals("Epic sadface: Username is required", msg);
        
    }

    @AfterEach
    public void afterEach(){
        navegador.quit();
    }
    
}
