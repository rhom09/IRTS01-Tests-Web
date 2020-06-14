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
	private By totalTaxExclTotal = By
			.cssSelector("div.cart-summary-totals div.cart-summary-line:nth-child(1) span.value");
	private By totalTaxIncTotal = By
			.cssSelector("div.cart-summary-totals div.cart-summary-line:nth-child(2) span.value");
	private By taxesTotal = By.cssSelector("div.cart-summary-totals div.cart-summary-line:nth-child(3) span.value");

	public CarrinhoPage(WebDriver driver) {
		this.driver = driver;
	}

	public String obter_nomeProduto() {
		return driver.findElement(nomeProduto).getText();
	}

	public String obter_precoProduto() {
		return driver.findElement(precoProduto).getText();
	}

	public String obter_tamanhoProduto() {
		return driver.findElement(tamanhoProduto).getText();
	}

	public String obter_corProduto() {
		return driver.findElement(corProduto).getText();
	}

	public String obter_input_quantidadeProduto() {
		return driver.findElement(input_quantidadeProduto).getAttribute("value");
	}

	public String obter_subTotalProduto() {
		return driver.findElement(subTotalProduto).getText();
	}

	public String obter_numeroItensTotal() {
		return driver.findElement(numeroItensTotal).getText();
	}

	public String obter_subTotalTotal() {
		return driver.findElement(subTotalTotal).getText();
	}

	public String obter_shippingTotal() {
		return driver.findElement(shippingTotal).getText();
	}

	public String obter_totalTaxExclTotal() {
		return driver.findElement(totalTaxExclTotal).getText();
	}

	public String obter_totalTaxIncTotal() {
		return driver.findElement(totalTaxIncTotal).getText();
	}

	public String obter_taxesTotal() {
		return driver.findElement(taxesTotal).getText();
	}

}
