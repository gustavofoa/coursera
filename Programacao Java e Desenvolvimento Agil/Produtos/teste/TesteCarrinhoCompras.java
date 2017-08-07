import static org.junit.Assert.*;

import org.junit.Test;


public class TesteCarrinhoCompras {

	@Test
	public void testeAdicionaUmProduto() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionaProduto(new Produto("Produto1", 1, 20), 1);
		assertEquals(20, carrinho.getValorTotal(), 0);
	}

	@Test
	public void testeAdicionaUmProdutoDuasQuant() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionaProduto(new Produto("Produto1", 1, 20), 2);
		assertEquals(40, carrinho.getValorTotal(), 0);
	}

	@Test
	public void testeAdicionaDoisProdutosDif() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionaProduto(new Produto("Produto1", 1, 20), 1);
		carrinho.adicionaProduto(new Produto("Produto2", 2, 30), 1);
		assertEquals(50, carrinho.getValorTotal(), 0);
	}

	@Test
	public void testeAdicionaDoisProdutosIguais() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionaProduto(new Produto("Produto1", 1, 20), 1);
		carrinho.adicionaProduto(new Produto("Produto2", 1, 30), 1);
		assertEquals(40, carrinho.getValorTotal(), 0);
	}

	@Test
	public void testeAdicionaDoisProdutosIguaisComTam() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionaProduto(new ProdutoComTamanho("Produto1", 1, 20, 1), 1);
		carrinho.adicionaProduto(new ProdutoComTamanho("Produto2", 1, 30, 1), 1);
		assertEquals(40, carrinho.getValorTotal(), 0);
	}

	@Test
	public void testeAdicionaDoisProdutosDifComTam() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionaProduto(new ProdutoComTamanho("Produto1", 1, 20, 1), 1);
		carrinho.adicionaProduto(new ProdutoComTamanho("Produto2", 1, 30, 2), 1);
		assertEquals(50, carrinho.getValorTotal(), 0);
	}

	@Test
	public void testeAdicionaDoisProdutosDifComTamCodDif() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionaProduto(new ProdutoComTamanho("Produto1", 1, 20, 1), 1);
		carrinho.adicionaProduto(new ProdutoComTamanho("Produto2", 2, 30, 1), 1);
		assertEquals(50, carrinho.getValorTotal(), 0);
	}

	@Test
	public void testeRemoverProduto() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionaProduto(new ProdutoComTamanho("Produto1", 1, 20, 1), 1);
		carrinho.adicionaProduto(new ProdutoComTamanho("Produto2", 1, 30, 1), 2);
		assertEquals(60, carrinho.getValorTotal(), 0);
		carrinho.removerProduto(new ProdutoComTamanho("Produto3", 1, 50, 1), 1);
		assertEquals(40, carrinho.getValorTotal(), 0);
	}

}
