package embaralhamento;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmbaralhadorAleatorio implements Embaralhador {

	private Random random;

	public EmbaralhadorAleatorio(Random random) {
		this.random = random;
	}

	@Override
	public String embaralhar(String palavra) {

		if (palavra == null || palavra.isEmpty())
			return palavra;

		String novaPalavra = shuffle(palavra);

		return novaPalavra;
	}

	private String shuffle(String input) {
		List<Character> characters = new ArrayList<Character>();
		for (char c : input.toCharArray()) {
			characters.add(c);
		}
		StringBuilder output = new StringBuilder(input.length());
		while (characters.size() != 0) {
			int randPicker = random.nextInt(characters.size());
			output.append(characters.remove(randPicker));
		}
		return output.toString();
	}

}
