import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TesteCamelCase {

	private List<String> callConverter(String palavra) {
		CamelCase c = new CamelCase();
		List<String> retorno = c.converterCamelCase(palavra);
		return retorno;
	}

	@Test
	public void testeNomeMinusculo() {
		List<String> retorno = callConverter("nome");
		assertEquals(1, retorno.size());
		assertEquals("nome", retorno.get(0));
	}

	@Test
	public void testeNomeMaiusculo() {
		List<String> retorno = callConverter("Nome");
		assertEquals(1, retorno.size());
		assertEquals("nome", retorno.get(0));
	}

	@Test
	public void testeNomeCompostoMinusculo() {
		List<String> retorno = callConverter("nomeComposto");
		assertEquals(2, retorno.size());
		assertEquals("nome", retorno.get(0));
		assertEquals("composto", retorno.get(1));
	}

	@Test
	public void testeNomeCompostoMaiusculo() {
		List<String> retorno = callConverter("NomeComposto");
		assertEquals(2, retorno.size());
		assertEquals("nome", retorno.get(0));
		assertEquals("composto", retorno.get(1));
	}

	@Test
	public void testeCPF() {
		List<String> retorno = callConverter("CPF");
		assertEquals(1, retorno.size());
		assertEquals("CPF", retorno.get(0));
	}

	@Test
	public void testeNumeroCPF() {
		List<String> retorno = callConverter("numeroCPF");
		assertEquals(2, retorno.size());
		assertEquals("numero", retorno.get(0));
		assertEquals("CPF", retorno.get(1));
	}

	@Test
	public void testeNumeroCPFContribuinte() {
		List<String> retorno = callConverter("numeroCPFContribuinte");
		assertEquals(3, retorno.size());
		assertEquals("numero", retorno.get(0));
		assertEquals("CPF", retorno.get(1));
		assertEquals("contribuinte", retorno.get(2));
	}

	@Test
	public void testeRecupera10Primeiros() {
		List<String> retorno = callConverter("recupera10Primeiros");
		assertEquals(3, retorno.size());
		assertEquals("recupera", retorno.get(0));
		assertEquals("10", retorno.get(1));
		assertEquals("primeiros", retorno.get(2));
	}

	@Test
	public void teste10Primeiros() {
		try {
			callConverter("10Primeiros");
			fail();
		} catch (CamelCaseException cce) {
		}
	}

	@Test
	public void testeNomeSharpComposto() {
		try {
			callConverter("nome#Composto");
			fail();
		} catch (CamelCaseException cce) {
		}

	}

	@Test
	public void testeCaracterEspecial() {
		try {
			callConverter("testeAsdfskjh*sdf");
			fail();
		} catch (CamelCaseException cce) {
		}

	}

	@Test
	public void testeContem15Numeros() {
		List<String> retorno = callConverter("Contem15Numeros");
		assertEquals(3, retorno.size());
		assertEquals("contem", retorno.get(0));
		assertEquals("15", retorno.get(1));
		assertEquals("numeros", retorno.get(2));
	}

	@Test
	public void testeNumeroCNPJ() {
		List<String> retorno = callConverter("numeroCNPJ");
		assertEquals(2, retorno.size());
		assertEquals("numero", retorno.get(0));
		assertEquals("CNPJ", retorno.get(1));
	}

	@Test
	public void testeNumeroCNPJContribuinte() {
		List<String> retorno = callConverter("numeroCNPJEmpresa");
		assertEquals(3, retorno.size());
		assertEquals("numero", retorno.get(0));
		assertEquals("CNPJ", retorno.get(1));
		assertEquals("empresa", retorno.get(2));
	}

}
