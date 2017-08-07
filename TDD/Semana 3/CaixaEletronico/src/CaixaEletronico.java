
public class CaixaEletronico {
	
	private Hardware hardware;
	private ServicoRemoto servicoRemoto;
	private ContaCorrente contaCorrente;

	public CaixaEletronico(Hardware hardware, ServicoRemoto servicoRemoto) {
		this.hardware = hardware;
		this.servicoRemoto = servicoRemoto;
	}

	public String logar() {
		
		try {
			String numeroDoCartao = hardware.pegarNumeroDaContaCartao();
			contaCorrente = servicoRemoto.recuperarConta(numeroDoCartao);			
		} catch (FalhaDeHardwareException e) { }
		
		if(contaCorrente != null)
			return "Usuário Autenticado";
		else
			return "Não foi possível autenticar o usuário";
		
	}

	public String sacar(int valor) {
		if(contaCorrente == null)
			return "Usuário NÃO Autenticado";
		
		if(valor > contaCorrente.getSaldo())
			return "Saldo insuficiente";
		
		try {
			hardware.entregarDinheiro(valor);
		} catch (FalhaDeHardwareException e) {
			return "Falha ao entregar o dinheiro, sua conta NÃO foi debitada";
		}

		contaCorrente.sacar(valor);

		servicoRemoto.persistirConta(contaCorrente);
		
		return "Retire seu dinheiro";
	}

	public String depositar(int valor) {
		if(contaCorrente == null)
			return "Usuário NÃO Autenticado";
		
		try {
			hardware.lerEnvelope();
		} catch (FalhaDeHardwareException e) {
			return "Falha ao ler o envelope de dinheiro";
		}
		
		contaCorrente.depositar(valor);

		servicoRemoto.persistirConta(contaCorrente);
				
		return "Depósito recebido com sucesso";
	}

	public String saldo() {
		if(contaCorrente == null)
			return "Usuário NÃO Autenticado";
		
		return String.format("O saldo é R$%d,00", contaCorrente.getSaldo());
	}

}
