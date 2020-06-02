package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;
	
	List<WebElement> listaProdutos = new ArrayList();
	
	private By textoProdutosNoCarrinho = By.className("cart-products-count");
	private By produtos = By.className("product-description");
	
	// Construtor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public int contarProdutos() {
		carregarListaProdutos();
		return listaProdutos.size();
	}
	
	private void carregarListaProdutos() {
		listaProdutos = driver.findElements(produtos);
	}
	
	public int obterQuantidadeProdutosNoCarrinho() {
		String quantidadeProdutosNoCarrinho = driver.findElement(textoProdutosNoCarrinho).getText();
		// Tirando os parenteses para conversão em inteiro
		quantidadeProdutosNoCarrinho = quantidadeProdutosNoCarrinho.replace("(", "");
		quantidadeProdutosNoCarrinho = quantidadeProdutosNoCarrinho.replace(")", "");
		
		// Converter de String para Int
		int qtdProdutosNoCarrinho = Integer.parseInt(quantidadeProdutosNoCarrinho);
		
		return qtdProdutosNoCarrinho;
		
	}
	
	
	
	
	
	

}
