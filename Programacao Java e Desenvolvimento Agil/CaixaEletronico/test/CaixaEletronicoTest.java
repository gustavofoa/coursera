import static org.junit.Assert.*;

import org.junit.Test;

public class CaixaEletronicoTest {

	@Test
	public void testeCaixaEletronicoPossuiMetodosLogarSacarDepositarSaldo() {
		CaixaEletronico c = new CaixaEletronico(new MockHardware(), new MockServicoRemoto());
		String s = c.logar();
		assertNotNull(s);
		s = c.sacar();
		assertNotNull(s);
		s = c.depositar();
		assertNotNull(s);
		s = c.saldo();
		assertNotNull(s);
	}

	@Test
	public void testeRealizarLoginComSucesso() {

		MockHardware h = new MockHardware();
		h.setNumeroDaConta("123456");

		MockServicoRemoto s = new MockServicoRemoto();
		ContaCorrente cc = new ContaCorrente();
		s.setContaCorrente(cc);
		
		CaixaEletronico c = new CaixaEletronico(h, s);

		String retornoLogar = c.logar();

		assertEquals("Usuário Autenticado", retornoLogar);

		h.verificaChamada();
		s.verificaChamada();

	}

}
