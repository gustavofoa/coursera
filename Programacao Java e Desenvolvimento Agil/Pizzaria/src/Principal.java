public class Principal {

	public static void main(String[] args) {

		Pizza p1 = new Pizza();
		p1.adicionaIngrediente("Presunto");
		p1.adicionaIngrediente("Queijo Mussarela");
		p1.adicionaIngrediente("Calabresa");
		p1.adicionaIngrediente("Cebola");
		p1.adicionaIngrediente("Bacon");
		p1.adicionaIngrediente("Tomate");

		Pizza p2 = new Pizza();
		p2.adicionaIngrediente("Presunto");
		p2.adicionaIngrediente("Queijo Mussarela");

		Pizza p3 = new Pizza(); // Pizza 4 queijos rs
		p3.adicionaIngrediente("Queijo");
		p3.adicionaIngrediente("Queijo");
		p3.adicionaIngrediente("Queijo");
		p3.adicionaIngrediente("Queijo");

		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionarPizza(p1);
		carrinho.adicionarPizza(p2);
		carrinho.adicionarPizza(p3);

		System.out.println("Total do carrinho de compras: "
				+ carrinho.getTotal());

		System.out.println("Ingredientes contabilizados:");
		for (String key : Pizza.ingredientesContabilizados.keySet()) {
			System.out.println(key + ": "
					+ Pizza.ingredientesContabilizados.get(key));
		}

	}

}
