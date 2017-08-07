import static org.junit.Assert.*;

public class MockServicoRemoto implements ServicoRemoto {

	private ContaCorrente contaCorrente;
	private boolean chamouRecuperarConta = false;

	public ContaCorrente recuperarConta(String numero) {
		chamouRecuperarConta = true;
		return contaCorrente;
	}

	public void persistirConta(ContaCorrente cc) {
		// TODO Auto-generated method stub

	}

	public void setContaCorrente(ContaCorrente cc) {
		this.contaCorrente = cc;
	}

	public void verificaChamada() {
		assertTrue(chamouRecuperarConta)
	}

}
