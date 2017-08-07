package embaralhamento;
import java.util.Arrays;

public class EmbaralhadorAlfabetico implements Embaralhador {

	@Override
	public String embaralhar(String palavra) {
		if (palavra == null || palavra.isEmpty())
			return palavra;

		char[] letras = palavra.toCharArray();
        Arrays.sort(letras);
        String sorted = new String(letras);

		return sorted;
	}

}
