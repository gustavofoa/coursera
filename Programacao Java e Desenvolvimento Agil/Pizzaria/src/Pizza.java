import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pizza {

	private List<String> ingredientes;
	public static Map<String, Integer> ingredientesContabilizados = new HashMap<String, Integer>();

	public Pizza() {
		ingredientes = new ArrayList<String>();
	}

	public void adicionaIngrediente(String ingrediente) {
		ingredientes.add(ingrediente);
		contabilizaIngrediente(ingrediente);
	}

	public double getPreco() {

		// 2 ingredientes ou menos custam 15 reais,
		// de 3 a 5 ingredientes custam 20 reais
		// e mais de 5 ingredientes custa 23 reais.

		if (ingredientes.size() <= 2)
			return 15;
		else if (ingredientes.size() <= 5)
			return 20;
		else
			return 23;
	}

	public int getTotalIngredientes() {
		return ingredientes.size();
	}

	private static void contabilizaIngrediente(String ingrediente) {

		ingredientesContabilizados.put(ingrediente,
				ingredientesContabilizados.getOrDefault(ingrediente, 0) + 1);
	}
	
	public static void zeraContabilizacaoIngredientes(){
		ingredientesContabilizados.clear();
	}

}
