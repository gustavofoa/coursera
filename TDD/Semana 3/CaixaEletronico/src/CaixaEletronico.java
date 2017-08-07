
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
			return "Usu�rio Autenticado";
		else
			return "N�o foi poss�vel autenticar o usu�rio";
		
	}

	public String sacar(int valor) {
		if(contaCorrente == null)
			return "Usu�rio N�O Autenticado";
		
		if(valor > contaCorrente.getSaldo())
			return "Saldo insuficiente";
		
		try {
			hardware.entregarDinheiro(valor);
		} catch (FalhaDeHardwareException e) {
			return "Falha ao entregar o dinheiro, sua conta N�O foi debitada";
		}

		contaCorrente.sacar(valor);

		servicoRemoto.persistirConta(contaCorrente);
		
		return "Retire seu dinheiro";
	}

	public String depositar(int valor) {
		if(contaCorrente == null)
			return "Usu�rio N�O Autenticado";
		
		try {
			hardware.lerEnvelope();
		} catch (FalhaDeHardwareException e) {
			return "Falha ao ler o envelope de dinheiro";
		}
		
		contaCorrente.depositar(valor);

		servicoRemoto.persistirConta(contaCorrente);
				
		return "Dep�sito recebido com sucesso";
	}

	public String saldo() {
		if(contaCorrente == null)
			return "Usu�rio N�O Autenticado";
		
		return String.format("O saldo � R$%d,00", contaCorrente.getSaldo());
	}

}
