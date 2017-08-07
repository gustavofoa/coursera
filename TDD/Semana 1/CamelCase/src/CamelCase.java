import java.util.ArrayList;
import java.util.List;

public class CamelCase {

	private List<String> palavras = new ArrayList<String>();
	private StringBuffer palavraAtual = new StringBuffer();
	private String novaPalavra = "";
	private boolean eSigla = false;

	public List<String> converterCamelCase(String palavra) {

		palavras.clear();

		for (int i = 0; i < palavra.length(); i++) {
			String letra = palavra.substring(i, i + 1);
			verificaLetra(letra, i);
		}

		adicionaPalavra();
		return palavras;

	}

	private void verificaLetra(String letra, int i) {
		validaNumeroInicial(letra, i);
		validaCaracterEspecial(letra);
		if (deveIniciarNovaPalavra(letra)) {
			adicionaPalavra();
		}
		palavraAtual.append(letra);
	}

	private void validaNumeroInicial(String letra, int i) {
		if (i == 0 && letra.matches("[\\d]"))
			throw new CamelCaseException("Inválido: não deve começar com números");
	}

	private void validaCaracterEspecial(String letra) {
		if (!letra.matches("[\\w\\d]"))
			throw new CamelCaseException(
					"Inválido: caracteres especiais não são permitidos, somente letras e números");
	}

	private boolean deveIniciarNovaPalavra(String letra) {

		if (verificaSigla() || verificaSequenciaNumerica(letra))
			return false;

		if (verificaTerminouSigla() || verificaSequenciaNaoNumerica(letra))
			return true;

		return verificaNovaPalavraSimples(letra);
	}

	private boolean verificaNovaPalavraSimples(String letra) {
		return palavraAtual.length() > 0 && letra.matches("[A-Z]");
	}

	private boolean verificaSigla() {
		if (palavraAtual.length() > 0 && verificaUltimaLetraMaiuscula()) {
			eSigla = palavraAtual.length() > 1;
			return true;
		}
		return false;
	}

	private boolean verificaTerminouSigla() {
		if (palavraAtual.length() > 2
				&& verificaPenultimaLetraMaiuscula()
				&& verificaUltimaLetraMinuscula()) {
			novaPalavra = palavraAtual.substring(palavraAtual.length() - 2);
			palavraAtual.replace(palavraAtual.length() - 2, palavraAtual.length(), "");
			return true;
		}

		return false;
	}

	private boolean verificaUltimaLetraMaiuscula() {
		return palavraAtual.substring(palavraAtual.length() - 1).matches("[A-Z]");
	}

	private boolean verificaUltimaLetraMinuscula() {
		return palavraAtual.substring(palavraAtual.length() - 1).matches("[a-z]");
	}

	private boolean verificaPenultimaLetraMaiuscula() {
		return palavraAtual.substring(palavraAtual.length() - 2, palavraAtual.length() - 1).matches("[A-Z]");
	}

	private boolean verificaSequenciaNumerica(String letra) {
		return palavraAtual.toString().matches("[\\d]") && letra.matches("[\\d]");
	}
	
	private boolean verificaSequenciaNaoNumerica(String letra) {
		return !palavraAtual.toString().matches("[\\d]") && letra.matches("[\\d]");
	}

	private void adicionaPalavra() {
		if (eSigla)
			palavras.add(palavraAtual.toString());
		else
			palavras.add(palavraAtual.toString().toLowerCase());
		palavraAtual = new StringBuffer(novaPalavra);
		novaPalavra = "";
		eSigla = false;
	}

}
