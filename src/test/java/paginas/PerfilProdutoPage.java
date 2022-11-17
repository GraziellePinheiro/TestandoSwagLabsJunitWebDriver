package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PerfilProdutoPage{
    private WebDriver navegador;

    public PerfilProdutoPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public PerfilProdutoPage adicionarMochilaCarrinho(){
        navegador.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        return this;
    }

    public PerfilProdutoPage adicionarRoupaInfantil(){
        navegador.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();

        return this;
    }

    public ListaDeProdutosPage retornarListaDeProdutos(){
        navegador.findElement(By.name("back-to-products")).click();

        return new ListaDeProdutosPage(navegador);
    }
}
