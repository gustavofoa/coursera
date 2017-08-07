
public interface Hardware {
	
	public String pegarNumeroDaContaCartao() throws FalhaDeHardwareException;
	
	public void entregarDinheiro(int valor) throws FalhaDeHardwareException;
	
	public void lerEnvelope() throws FalhaDeHardwareException;

}
