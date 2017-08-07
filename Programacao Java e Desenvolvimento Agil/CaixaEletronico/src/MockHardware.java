import static org.junit.Assert.*;

public class MockHardware implements Hardware {
	
	private String numeroDaConta;
	private boolean chamouPegarNumeroDaContaCartao = false;

	public String pegarNumeroDaContaCartao() {
		chamouPegarNumeroDaContaCartao = true;
		return numeroDaConta;
	}

	public void entregarDinheiro() {
		// TODO Auto-generated method stub
		
	}

	public void lerEnvelope() {
		// TODO Auto-generated method stub
		
	}

	public void setNumeroDaConta(String numeroDaConta) {
		this.numeroDaConta = numeroDaConta;		
	}

	public void verificaChamada() {
		assertTrue(chamouPegarNumeroDaContaCartao);
		
	}

}
