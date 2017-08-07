import static org.junit.Assert.*;

public class MockHardware implements Hardware {

	private boolean obteveNumeroDoCartao = false;
	private boolean deveLancarExcecaoAoObterNumeroDaConta = false;
	private boolean deveLancarExcecaoAoEntregarDinheiro = false;
	private boolean deveLancarExcecaoAoLerEnvelope = false;
	private boolean entregouDinheiro = false;
	private boolean leuEnvelope;

	@Override
	public String pegarNumeroDaContaCartao() throws FalhaDeHardwareException {
		obteveNumeroDoCartao = true;
		if (deveLancarExcecaoAoObterNumeroDaConta)
			throw new FalhaDeHardwareException();
		return "123456";
	}

	@Override
	public void entregarDinheiro(int valor) throws FalhaDeHardwareException {
		if (deveLancarExcecaoAoEntregarDinheiro)
			throw new FalhaDeHardwareException();
		entregouDinheiro = true;
	}

	@Override
	public void lerEnvelope() throws FalhaDeHardwareException {
		if (deveLancarExcecaoAoLerEnvelope)
			throw new FalhaDeHardwareException();
		leuEnvelope = true;
	}

	public void verificaObtencaoDeNumeroDoCartao() {
		assertTrue(obteveNumeroDoCartao);
	}

	public void lancarExcecaoAoObterNumeroDaConta() {
		deveLancarExcecaoAoObterNumeroDaConta = true;
	}

	public void lancarExcecaoAoEntregarDinheiro() {
		deveLancarExcecaoAoEntregarDinheiro = true;
	}

	public void lancarExcecaoAoLerEnvelope() {
		deveLancarExcecaoAoLerEnvelope = true;
	}

	public void deveEntregarDinheiro() {
		assertTrue(entregouDinheiro);
	}

	public void naoDeveEntregarDinheiro() {
		assertFalse(entregouDinheiro);
	}

	public void deveReceberEnvelope() {
		assertTrue(leuEnvelope);
	}

}
