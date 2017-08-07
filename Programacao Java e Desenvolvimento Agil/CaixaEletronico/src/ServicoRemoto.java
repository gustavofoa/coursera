
public interface ServicoRemoto {
	
	ContaCorrente recuperarConta(String numero);
	
	void persistirConta(ContaCorrente cc);

}
