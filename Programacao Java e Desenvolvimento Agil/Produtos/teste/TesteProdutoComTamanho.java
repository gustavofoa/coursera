import static org.junit.Assert.*;

import org.junit.Test;


public class TesteProdutoComTamanho {

	@Test
	public void testeCodigoIgualTamanhoIgualEqualsTrue() {
		Produto produto1 = new ProdutoComTamanho("Produto1", 1, 10, 10);
		Produto produto2 = new ProdutoComTamanho("Produto2", 1, 30, 10);
		assertTrue(produto1.equals(produto2));
	}
	
	@Test
	public void testeCodigoIgualTamanhoDifEqualsFalso() {
		Produto produto1 = new ProdutoComTamanho("Produto1", 1, 10, 10);
		Produto produto2 = new ProdutoComTamanho("Produto2", 1, 30, 11);
		assertFalse(produto1.equals(produto2));
	}

	@Test
	public void testeCodigoDifTamanhoIgualEqualsFalso() {
		Produto produto1 = new ProdutoComTamanho("Produto1", 1, 10, 10);
		Produto produto2 = new ProdutoComTamanho("Produto2", 2, 30, 10);
		assertFalse(produto1.equals(produto2));
	}
	
	@Test
	public void testeCodigoDifTamanhoDifEqualsFalso() {
		Produto produto1 = new ProdutoComTamanho("Produto1", 1, 10, 10);
		Produto produto2 = new ProdutoComTamanho("Produto2", 2, 30, 11);
		assertFalse(produto1.equals(produto2));
	}

}
