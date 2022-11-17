package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosPage {
    private WebDriver navegador;

    public ListaDeProdutosPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public PerfilProdutoPage selecionarMochila(){
        navegador.findElement(By.cssSelector("a[id='item_4_title_link']")).click();

        return new PerfilProdutoPage(navegador);
    }

    public PerfilProdutoPage selecionarRoupaInfantil(){
        navegador.findElement(By.cssSelector("a[id='item_2_title_link']")).click();

        return new PerfilProdutoPage(navegador);
    }

    public CarrinhoPage verDetalhesDaCompra(){
        navegador.findElement(By.cssSelector("a[class='shopping_cart_link']")).click();

        return new CarrinhoPage(navegador);
    }
}
