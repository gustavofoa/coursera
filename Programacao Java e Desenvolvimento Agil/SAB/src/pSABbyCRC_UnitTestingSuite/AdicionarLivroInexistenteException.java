package pSABbyCRC_UnitTestingSuite;

@SuppressWarnings("serial")
public class AdicionarLivroInexistenteException extends Exception {
	public AdicionarLivroInexistenteException() {}

    public AdicionarLivroInexistenteException(String message)
    {
       super(message);
    }
}