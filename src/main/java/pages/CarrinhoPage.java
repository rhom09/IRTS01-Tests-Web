package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoPage {
	
	private WebDriver driver;
	
	private By nomeProduto = By.cssSelector("div.product-line-info a.label");
	private By precoProduto = By.cssSelector("div.current-price span.price");
	private By tamanhoProduto = By.cssSelector("div.product-line-info:nth-child(4) span.value");
	private By corProduto = By.cssSelector("div.product-line-info:nth-child(5) span.value");
	private By input_quantidadeProduto = By.cssSelector("input.form-control");
	private By subTotalProduto = By.cssSelector("span.product-price strong");
	
	private By numeroItensTotal = By.cssSelector("span.js-subtotal");
	private By subTotalTotal = By.cssSelector("div#cart-subtotal-products span.value");
	private By shippingTotal = By.cssSelector("div#cart-subtotal-shipping span.value");
	private By totalTaxExclTotal = By.cssSelector("div.cart-summary-totals div.cart-summary-line:nth-child(1) span.value");
	private By totalTaxIncTotal = By.cssSelector("div.cart-summary-totals div.cart-summary-line:nth-child(2) span.value");
	private By taxesTotal = By.cssSelector("div.cart-summary-totals div.cart-summary-line:nth-child(3) span.value");
	
	public CarrinhoPage(WebDriver driver) {
		this.driver = driver;
	}
	

}
