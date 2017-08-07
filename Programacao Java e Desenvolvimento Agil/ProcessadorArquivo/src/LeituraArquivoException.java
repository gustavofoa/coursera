
public class LeituraArquivoException extends Exception {

	private static final long serialVersionUID = -2680025656756411307L;

	private String message;

	public LeituraArquivoException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
