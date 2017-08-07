import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestePizza {

	@Before
	public void before() {
		Pizza.zeraContabilizacaoIngredientes();
	}

	@Test
	public void TestePreco1IngredienteValor15() {

		Pizza pizza = new Pizza();

		pizza.adicionaIngrediente("Tomate");

		assertEquals(15, pizza.getPreco(), 0);

	}

	@Test
	public void TestePreco2IngredientesValor15() {

		Pizza pizza = new Pizza();

		pizza.adicionaIngrediente("Tomate");
		pizza.adicionaIngrediente("Queijo");

		assertEquals(15, pizza.getPreco(), 0);

	}

	@Test
	public void TestePreco3IngredientesValor20() {

		Pizza pizza = new Pizza();

		pizza.adicionaIngrediente("Tomate");
		pizza.adicionaIngrediente("Queijo");
		pizza.adicionaIngrediente("Presunto");

		assertEquals(20, pizza.getPreco(), 0);

	}

	@Test
	public void TestePreco4IngredientesValor20() {

		Pizza pizza = new Pizza();

		pizza.adicionaIngrediente("Tomate");
		pizza.adicionaIngrediente("Queijo");
		pizza.adicionaIngrediente("Presunto");
		pizza.adicionaIngrediente("Calabresa");

		assertEquals(20, pizza.getPreco(), 0);

	}

	@Test
	public void TestePreco5IngredientesValor20() {

		Pizza pizza = new Pizza();

		pizza.adicionaIngrediente("Tomate");
		pizza.adicionaIngrediente("Queijo");
		pizza.adicionaIngrediente("Presunto");
		pizza.adicionaIngrediente("Calabresa");
		pizza.adicionaIngrediente("Cobola");

		assertEquals(20, pizza.getPreco(), 0);

	}

	@Test
	public void TestePreco6IngredientesValor23() {

		Pizza pizza = new Pizza();

		pizza.adicionaIngrediente("Tomate");
		pizza.adicionaIngrediente("Queijo");
		pizza.adicionaIngrediente("Presunto");
		pizza.adicionaIngrediente("Calabresa");
		pizza.adicionaIngrediente("Cebola");
		pizza.adicionaIngrediente("Azeitona");

		assertEquals(23, pizza.getPreco(), 0);

	}

	@Test
	public void TestePreco10IngredientesValor23() {

		Pizza pizza = new Pizza();

		pizza.adicionaIngrediente("Tomate");
		pizza.adicionaIngrediente("Queijo");
		pizza.adicionaIngrediente("Presunto");
		pizza.adicionaIngrediente("Calabresa");
		pizza.adicionaIngrediente("Cebola");
		pizza.adicionaIngrediente("Azeitona");
		pizza.adicionaIngrediente("Bacon");
		pizza.adicionaIngrediente("Frango");
		pizza.adicionaIngrediente("Parmesão");
		pizza.adicionaIngrediente("Ovos");

		assertEquals(23, pizza.getPreco(), 0);

	}

	@Test
	public void TesteTotalIngredientes() {
		Pizza pizza = new Pizza();
		pizza.adicionaIngrediente("Tomate");

		assertEquals(1, pizza.getTotalIngredientes());

		pizza.adicionaIngrediente("Queijo");

		assertEquals(2, pizza.getTotalIngredientes());

		pizza.adicionaIngrediente("Queijo");

		assertEquals(3, pizza.getTotalIngredientes());

	}

	@Test
	public void TesteIngredientesContabilizados() {
		Pizza pizza = new Pizza();
		pizza.adicionaIngrediente("Tomate");

		assertEquals(1, Pizza.ingredientesContabilizados.size());

		pizza.adicionaIngrediente("Queijo");

		assertEquals(2, Pizza.ingredientesContabilizados.size());

		pizza.adicionaIngrediente("Queijo");

		assertEquals(2, Pizza.ingredientesContabilizados.size());
		assertEquals(new Integer(1),
				Pizza.ingredientesContabilizados.get("Tomate"));
		assertEquals(new Integer(2),
				Pizza.ingredientesContabilizados.get("Queijo"));

		pizza.adicionaIngrediente("Queijo");

		assertEquals(new Integer(3),
				Pizza.ingredientesContabilizados.get("Queijo"));

	}

}
