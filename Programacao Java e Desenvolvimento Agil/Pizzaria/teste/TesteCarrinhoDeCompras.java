import static org.junit.Assert.*;

import org.junit.Test;

public class TesteCarrinhoDeCompras {

	@Test
	public void testeNaoPermitirAdicionarPizzaSemIngredientesNoCarrinho() {
		Pizza pizza = new Pizza();
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionarPizza(pizza);
		assertEquals(0, carrinho.getTotalPizzas());
	}

	@Test
	public void testePermitirAdicionarPizzaComIngredientesNoCarrinho() {
		Pizza pizza = new Pizza();
		pizza.adicionaIngrediente("Queijo");
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionarPizza(pizza);
		assertEquals(1, carrinho.getTotalPizzas());
	}

	@Test
	public void testeTotalCarrinho1Pizza() {
		Pizza pizza = new Pizza();
		pizza.adicionaIngrediente("Queijo");
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionarPizza(pizza);
		assertEquals(15, carrinho.getTotal(), 0);
	}

	@Test
	public void testeTotalCarrinho2PizzasDe15() {
		Pizza pizza = new Pizza();
		pizza.adicionaIngrediente("Queijo");
		Pizza pizza2 = new Pizza();
		pizza2.adicionaIngrediente("Presunto");
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionarPizza(pizza);
		carrinho.adicionarPizza(pizza2);
		assertEquals(30, carrinho.getTotal(), 0);
	}

	@Test
	public void testeTotalCarrinho1PizzaDe15EUmaPizzaDe20() {
		Pizza pizza = new Pizza();
		pizza.adicionaIngrediente("Queijo");
		Pizza pizza2 = new Pizza();
		pizza2.adicionaIngrediente("Presunto");
		pizza2.adicionaIngrediente("Queijo");
		pizza2.adicionaIngrediente("Calabresa");
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionarPizza(pizza);
		carrinho.adicionarPizza(pizza2);
		assertEquals(35, carrinho.getTotal(), 0);
	}

	@Test
	public void testeTotalCarrinho1PizzaDe15EUmaPizzaDe23() {
		Pizza pizza = new Pizza();
		pizza.adicionaIngrediente("Queijo");
		Pizza pizza2 = new Pizza();
		pizza2.adicionaIngrediente("Presunto");
		pizza2.adicionaIngrediente("Queijo");
		pizza2.adicionaIngrediente("Calabresa");
		pizza2.adicionaIngrediente("Palmito");
		pizza2.adicionaIngrediente("Azeitona");
		pizza2.adicionaIngrediente("Cebola");
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionarPizza(pizza);
		carrinho.adicionarPizza(pizza2);
		assertEquals(38, carrinho.getTotal(), 0);
	}

	@Test
	public void testeTotalCarrinho1PizzaDe20EUmaPizzaDe23() {
		Pizza pizza = new Pizza();
		pizza.adicionaIngrediente("Queijo");
		pizza.adicionaIngrediente("Presunto");
		pizza.adicionaIngrediente("Calabresa");
		Pizza pizza2 = new Pizza();
		pizza2.adicionaIngrediente("Presunto");
		pizza2.adicionaIngrediente("Queijo");
		pizza2.adicionaIngrediente("Calabresa");
		pizza2.adicionaIngrediente("Palmito");
		pizza2.adicionaIngrediente("Azeitona");
		pizza2.adicionaIngrediente("Cebola");
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionarPizza(pizza);
		carrinho.adicionarPizza(pizza2);
		assertEquals(43, carrinho.getTotal(), 0);
	}

	@Test
	public void testeTotalCarrinho2PizzasDe20() {
		Pizza pizza = new Pizza();
		pizza.adicionaIngrediente("Queijo");
		pizza.adicionaIngrediente("Presunto");
		pizza.adicionaIngrediente("Calabresa");
		Pizza pizza2 = new Pizza();
		pizza2.adicionaIngrediente("Palmito");
		pizza2.adicionaIngrediente("Azeitona");
		pizza2.adicionaIngrediente("Cebola");
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionarPizza(pizza);
		carrinho.adicionarPizza(pizza2);
		assertEquals(40, carrinho.getTotal(), 0);
	}

	@Test
	public void testeTotalCarrinho1PizzaDe15UmaPizzaDe20EUmaPizzaDe23() {
		Pizza pizza = new Pizza();
		pizza.adicionaIngrediente("Queijo");
		pizza.adicionaIngrediente("Presunto");
		Pizza pizza2 = new Pizza();
		pizza2.adicionaIngrediente("Queijo");
		pizza2.adicionaIngrediente("Presunto");
		pizza2.adicionaIngrediente("Calabresa");
		Pizza pizza3 = new Pizza();
		pizza3.adicionaIngrediente("Presunto");
		pizza3.adicionaIngrediente("Queijo");
		pizza3.adicionaIngrediente("Calabresa");
		pizza3.adicionaIngrediente("Palmito");
		pizza3.adicionaIngrediente("Azeitona");
		pizza3.adicionaIngrediente("Cebola");
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionarPizza(pizza);
		carrinho.adicionarPizza(pizza2);
		carrinho.adicionarPizza(pizza3);
		assertEquals(58, carrinho.getTotal(), 0);
	}

}
