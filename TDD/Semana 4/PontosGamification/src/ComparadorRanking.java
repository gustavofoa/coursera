import java.util.Comparator;
import java.util.Map;

public class ComparadorRanking implements Comparator<Map<String, Integer>> {

	@Override
	public int compare(Map<String, Integer> primeiroUsuario, Map<String, Integer> segundoUsuario) {
		int primeiroValor = (int)primeiroUsuario.values().toArray()[0];
		int segundoValor = (int)segundoUsuario.values().toArray()[0];
		return segundoValor - primeiroValor;
	}

}
