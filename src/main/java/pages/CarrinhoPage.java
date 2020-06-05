package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoPage {
	
	private WebDriver driver;
	
	private By nomeProduto = By.cssSelector("div.product-line-info a.label");
	private By precoProduto = By.cssSelector("div.current-price span.price");
	private By tamanhoProduto = By.cssSelector("div.product-line-info span.value");
	
	public CarrinhoPage(WebDriver driver) {
		this.driver = driver;
	}
	

}
