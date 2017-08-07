import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

	private List<Pizza> pizzas = new ArrayList<Pizza>();

	public void adicionarPizza(Pizza pizza) {
		if (pizza.getTotalIngredientes() > 0)
			this.pizzas.add(pizza);
	}

	public double getTotal() {
		double total = 0;
		for (Pizza pizza : pizzas) {
			total += pizza.getPreco();
		}
		return total;
	}

	public int getTotalPizzas() {
		return pizzas.size();
	}

}
