import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

/**
 * 
 */

/**
 * @author michel
 *
 */
public class TestesConverterCamelCase {
	
	ConversoraCamelCase ccc;
	
	
	@Test
	public void testUmaPalavraMinusculo() {		 
		assertEquals("bom", ccc.converterCamelCase("bom").get(0));
	}
	
	@Test
	public void testUmaPalavraMaiusculo() {		 
		assertEquals("bom", ccc.converterCamelCase("Bom").get(0));
	}
	
	@Test
	public void testDividePalavras() {		
		List<String> palavras = ccc.dividePalavras("bomDia");
		assertEquals("bom",palavras.get(0) );
		assertEquals("dia",palavras.get(1) );
	}
	
	@Test
	public void testDuasPalavrasSimples() {		
		List<String> palavras = ccc.converterCamelCase("bomDia");
		assertEquals("bom",palavras.get(0) );
		assertEquals("dia",palavras.get(1) );
	}
	
	@Test
	public void testIsMaiuscula() {		
		
		assertEquals(true,ccc.isMaiuscula('A'));
		assertEquals(false,ccc.isMaiuscula('a'));
	}
	
	@Test
	public void testQuebraTextoEmArrayListChar() {		
		char[] letras = {'a','b','c'};
		assertEquals(letras[0],ccc.quebraTextoEmArrayListChar("abc")[0]);
		assertEquals(letras[1],ccc.quebraTextoEmArrayListChar("abc")[1]);
		assertEquals(letras[2],ccc.quebraTextoEmArrayListChar("abc")[2]);
	}
	
	@Test
	public void testNomeComposto() {		
		List<String> palavras = ccc.converterCamelCase("NomeComposto");
		assertEquals("nome",palavras.get(0) );
		assertEquals("composto",palavras.get(1) );
	}
	
	
	
	
	@Test
	public void testComSigla() {		
		
		List<String> palavras = ccc.converterCamelCase("bomCPFFunfando");
		assertEquals("bom",palavras.get(0) );
		assertEquals("CPF",palavras.get(1) );
		assertEquals("funfando",palavras.get(2) );		

	}
	
	
	@Test
	public void testRecupera10Primeiros() {		
		
		List<String> palavras = ccc.converterCamelCase("recupera10Primeiros");
		assertEquals("recupera",palavras.get(0) );
		assertEquals("10",palavras.get(1) );
		assertEquals("primeiros",palavras.get(2) );		

	}
	
	
	@Test
	public void testIsNumber() {		
		
		assertEquals(true,ccc.isNumber("1"));
		assertEquals(false,ccc.isNumber("a"));		


	}
	
	@Test
	public void testValidarNaoComecarComNumero() {		
		
		assertEquals(true,ccc.isValido("a1"));
		assertEquals(false,ccc.isValido("1a"));
		assertEquals(false,ccc.isValido("115AAA"));

	}
	
	@Test
	public void testHasSpecialCarecteres() {		
		
		assertEquals(false,ccc.hasSpecialCaracteres("adsfasdff"));
		assertEquals(false,ccc.hasSpecialCaracteres("adsfasd657ff"));
		assertEquals(true,ccc.hasSpecialCaracteres("#adsfasdff"));
		assertEquals(true,ccc.hasSpecialCaracteres("adsfasd$ff"));
		assertEquals(true,ccc.hasSpecialCaracteres("adsfasdff@"));

	}
	
	@Test
	public void testTodasPalavrasDoExercicio() {
		String[][] nomes = {{"oi"},{"oi"}};
		String[] palavrasATestar = {"nome","Nome","nomeComposto","NomeComposto","CPF","nomeroCPF","numeroCPFContribuinte","recupera10Primeiros","10Primeiros","nome#Composto"};
		String[][] resultadosEsperados ={{"nome"},{"nome"},{"nome","composto"},{"nome","composto"},{"CPF"},{"nomero","CPF"},{"numero","CPF","contribuinte"},{"recupera","10","primeiros"},{"inválido"},{"inválido"}};
		for (int i = 0; i < palavrasATestar.length; i++) {
			List<String> retorno = ccc.converterCamelCase(palavrasATestar[i]);
			for (int j = 0; j < resultadosEsperados[i].length; j++) {
				assertEquals(resultadosEsperados[i][j],retorno.get(j));
			}			
		}
	}
	
	
	
	
	

}