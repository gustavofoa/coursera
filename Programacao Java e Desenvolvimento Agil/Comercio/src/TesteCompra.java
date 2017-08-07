import static org.junit.Assert.*;

import org.junit.Test;


public class TesteCompra {

	@Test
	public void compraAVista() {
		Compra c = new Compra(500);
		assertEquals(1,  c.getNumeroParcelas());
		assertEquals(500, c.getValorTotal());
		assertEquals(500, c.getValorParcela());
	}

	@Test
	public void compraParcelada() {
		Compra c = new Compra(4, 250);
		assertEquals(4,  c.getNumeroParcelas());
		assertEquals(1000, c.getValorTotal());
		assertEquals(250, c.getValorParcela());
	}
	
}
