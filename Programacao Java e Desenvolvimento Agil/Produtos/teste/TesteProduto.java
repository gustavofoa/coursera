import static org.junit.Assert.*;

import org.junit.Test;


public class TesteProduto {

	@Test
	public void testeCodigoIgualEqualsTrue() {
		Produto produto1 = new Produto("Produto1", 1, 10);
		Produto produto2 = new Produto("Produto2", 1, 30);
		assertTrue(produto1.equals(produto2));
	}

	@Test
	public void testeCodigoDifEqualsFalse() {
		Produto produto1 = new Produto("Produto1", 1, 10);
		Produto produto2 = new Produto("Produto1", 2, 10);
		assertFalse(produto1.equals(produto2));
	}

}
