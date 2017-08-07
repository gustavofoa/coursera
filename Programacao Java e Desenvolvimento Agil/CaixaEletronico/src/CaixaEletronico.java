
public class CaixaEletronico {

	private Hardware hardware;
	private ServicoRemoto servicoRemoto;
	
	public CaixaEletronico(Hardware hardware, ServicoRemoto servicoRemoto) {
		this.hardware = hardware;
		this.servicoRemoto = servicoRemoto;
	}

	public String logar() {
		String numeroDaConta = hardware.pegarNumeroDaContaCartao();
		ContaCorrente c = servicoRemoto.recuperarConta(numeroDaConta);
		return "Usuário Autenticado";
	}

	public String sacar() {
		return "";
	}

	public String depositar() {
		return "";
	}

	public String saldo() {
		return "";
	}

}
