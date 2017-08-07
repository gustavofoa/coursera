import static org.junit.Assert.*;

import org.junit.Test;

public class TesteCompra {

	@Test
	public void testeCompraSimples() {
		Compra compra = new Compra(50);
		assertEquals(50, compra.total(), 0);
	}

	@Test
	public void testeCompraParcelada1Vez() {
		Compra compra = new CompraParcelada(50, 1, 0.02);
		assertEquals(50 * Math.pow(1.02, 1), compra.total(), 0);
	}

	@Test
	public void testeCompraParcelada2Vezez() {
		Compra compra = new CompraParcelada(50, 2, 0.02);
		assertEquals(50 * Math.pow(1.02, 2), compra.total(), 0);
	}

	@Test
	public void testeCompraParcelada5Vezez() {
		Compra compra = new CompraParcelada(50, 5, 0.02);
		assertEquals(50 * Math.pow(1.02, 5), compra.total(), 0);
	}

	@Test
	public void testeCompraParcelada10Vezez() {
		Compra compra = new CompraParcelada(50, 10, 0.02);
		assertEquals(50 * Math.pow(1.02, 10), compra.total(), 0);
	}

}
