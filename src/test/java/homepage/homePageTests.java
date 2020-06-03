package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.LoginPage;
import pages.ProdutoPage;

public class homePageTests extends BaseTests {

	@Test
	public void testcontarProdutos_oitosProdutosDiferentes() {
		carregarPaginaInicial();
		assertThat(homePage.contarProdutos(), is(8));
	}

	@Test
	public void testValidarCarrinhoZerado_ZeroitensNoCarrinho() {
		int produtosNoCarrinho = homePage.obterQuantidadeProdutosNoCarrinho();
		assertThat(produtosNoCarrinho, is(0));
	}

	@Test
	public void testValidarDetalhesDoProduto_DescricaoEValorIguais() {
		int indice = 0;
		String nomeProduto_Home_Page = homePage.obterNomeProduto(indice);
		String precoProduto_Home_Page = homePage.obterPrecoProduto(indice);

		ProdutoPage produtoPage = homePage.clicarProduto(indice);

		String nomeProduto_ProdutoPage = produtoPage.obterNomeProduto();
		String precoProduto_ProdutoPage = produtoPage.obterPrecoProduto();

		assertThat(nomeProduto_Home_Page.toUpperCase(), is(nomeProduto_ProdutoPage.toUpperCase()));
		assertThat(precoProduto_Home_Page, is(precoProduto_ProdutoPage));
	}
	
	@Test
	public void testLoginComSucesso_UsuarioLogado() {
		// Clicar no botão SignIn na home page
		LoginPage loginPage = homePage.clicarBotaoSignIn();
		
		// Preencher usuário e senha
		loginPage.preencherEmail("rhom0909@teste.com");
		loginPage.preencherPassword("pwd123");
		
		// Clicar no botão SignIn para logar
		loginPage.clicarBotaoSignIn();
		
		// Validar se o usuário está logado de fato
		assertThat(homePage.estaLogado("Romilton Viana Paixão"), is(true));
		
		
		
	}
	
	
	
	
	

}
