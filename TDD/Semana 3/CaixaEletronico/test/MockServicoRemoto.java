import static org.junit.Assert.*;

public class MockServicoRemoto implements ServicoRemoto {
	
	private String numeroRecebido;
	private boolean deveRetornarContaNula = false;
	private int saldoInicialDaContaCorrente;
	private boolean devePersistirConta;
	private boolean persistiuAConta;
	private ContaCorrente contaPersistida;

	@Override
	public ContaCorrente recuperarConta(String numero) {
		numeroRecebido = numero;
		
		if(deveRetornarContaNula)
			return null;
		
		return new ContaCorrente(saldoInicialDaContaCorrente);
		
	}

	@Override
	public void persistirConta(ContaCorrente contaCorrente) {
		persistiuAConta = true;
		contaPersistida = contaCorrente;
	}
	
	public void verificaNumeroRecebido(String numeroEsperado){
		assertEquals(numeroEsperado, numeroRecebido);
	}

	public void retornarContaNula() {
		deveRetornarContaNula  = true;		
	}

	public void saldoInicial(int valor) {
		saldoInicialDaContaCorrente = valor;
	}

	public void devePersistirAContaCorrente() {
		devePersistirConta = true;
	}

	public void verificaSePersistiuOuNaoAConta() {
		if(devePersistirConta)
			assertTrue(persistiuAConta && contaPersistida != null);
		else
			assertFalse(persistiuAConta);
	}

}
