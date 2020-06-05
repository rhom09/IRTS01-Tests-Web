package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.LoginPage;
import pages.ModalProdutoPage;
import pages.ProdutoPage;

public class homePageTests extends BaseTests {

	@Test
	public void testContarProdutos_oitosProdutosDiferentes() {
		carregarPaginaInicial();
		assertThat(homePage.contarProdutos(), is(8));
	}

	@Test
	public void testValidarCarrinhoZerado_ZeroitensNoCarrinho() {
		int produtosNoCarrinho = homePage.obterQuantidadeProdutosNoCarrinho();
		assertThat(produtosNoCarrinho, is(0));
	}

	ProdutoPage produtoPage;

	@Test
	public void testValidarDetalhesDoProduto_DescricaoEValorIguais() {
		int indice = 0;
		String nomeProduto_Home_Page = homePage.obterNomeProduto(indice);
		String precoProduto_Home_Page = homePage.obterPrecoProduto(indice);

		produtoPage = homePage.clicarProduto(indice);

		String nomeProduto_ProdutoPage = produtoPage.obterNomeProduto();
		String precoProduto_ProdutoPage = produtoPage.obterPrecoProduto();

		assertThat(nomeProduto_Home_Page.toUpperCase(), is(nomeProduto_ProdutoPage.toUpperCase()));
		assertThat(precoProduto_Home_Page, is(precoProduto_ProdutoPage));
	}

	LoginPage loginPage;

	@Test
	public void testLoginComSucesso_UsuarioLogado() {
		// Clicar no botão SignIn na home page
		loginPage = homePage.clicarBotaoSignIn();

		// Preencher usuário e senha
		loginPage.preencherEmail("rhom0909@teste.com");
		loginPage.preencherPassword("pwd123");

		// Clicar no botão SignIn para logar
		loginPage.clicarBotaoSignIn();

		// Validar se o usuário está logado de fato
		assertThat(homePage.estaLogado("Romilton Viana Paixão"), is(true));

		carregarPaginaInicial();

	}

	@Test
	public void testIncluirProdutoNoCarrinho_ProdutoIncluidoComSucesso() {
		
		String tamanhoProduto = "M";
		String corProduto = "Black";
		int quantidadeProduto = 2;
		
		// --Pré-condição
		// Usuário logado
		if (!homePage.estaLogado("Romilton Viana Paixão")) {
			testLoginComSucesso_UsuarioLogado();
		}

		// --Teste
		// Selecionando produto
		testValidarDetalhesDoProduto_DescricaoEValorIguais();

		// Selecionar tamanho
		List<String> listaOpcoes = produtoPage.obterOpcoesSelecionadas();

		produtoPage.selecionarOpcaoDropDown(tamanhoProduto);

		// Selecionar cor
		produtoPage.selecionarCorPreta();

		// Selecionar quantidade
		produtoPage.alterarQuantidade(2);
		
		// Adicionar no carrinho
		ModalProdutoPage modalProdutoPage = produtoPage.clicarBotaoAddToCart();
	
		//VALIDAÇÕES//
		
		//assertThat(modalProdutoPage.obterMensagemProdutoAdicionado(), is("Product successfully added to your shopping cart"));
		assertTrue(modalProdutoPage.obterMensagemProdutoAdicionado().endsWith("Product successfully added to your shopping cart"));
	}

}
