
public interface ServicoRemoto {
	
	public ContaCorrente recuperarConta(String numero);
	
	public void persistirConta(ContaCorrente contaCorrente);

}
