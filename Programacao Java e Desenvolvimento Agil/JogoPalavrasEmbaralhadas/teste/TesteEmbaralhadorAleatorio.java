import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import embaralhamento.Embaralhador;
import embaralhamento.EmbaralhadorAleatorio;

public class TesteEmbaralhadorAleatorio {

	private Embaralhador em;
	
	@Before
	public void criaInstanciaEmbaralhador(){
		em = new EmbaralhadorAleatorio(new Random());
	}
	
	@Test
	public void testaEmbaralharComPalavraNula() {
		assertNull(em.embaralhar(null));
	}
	
	@Test
	public void testaEmbaralharComPalavraVazia() {
		assertEquals("", em.embaralhar(""));
	}
	
	@Test
	public void testaEmbaralharComUmaLetra() {
		assertEquals("a", em.embaralhar("a"));
	}

	@Test
	public void testaEmbaralharAleatorioComDuasLetra() {
		List<String> possibilidades = Arrays.asList(new String[]{"ab","ba"});
		
		String palavraExistente = "ab";
		
		int alteracoes = 0;
		
		for(int i=0;i<100000;i++){
			String novaPalavra = em.embaralhar("ab");
			if(!palavraExistente.equals(novaPalavra))
				alteracoes++;
			if(!possibilidades.contains(novaPalavra))
				fail();
		}
		
		assertNotEquals(0, alteracoes);
	}

	@Test
	public void testaEmbaralharAleatorioComTresLetra() {
		List<String> possibilidades = Arrays.asList(new String[]{"abc","acb","bac","cab","bca","cba"});
		
		String palavraExistente = "abc";
		
		int alteracoes = 0;
		
		for(int i=0;i<100000;i++){
			String novaPalavra = em.embaralhar("abc");
			if(!palavraExistente.equals(novaPalavra))
				alteracoes++;
			if(!possibilidades.contains(novaPalavra))
				fail();
		}
		
		assertNotEquals(0, alteracoes);
	}
	

	@Test
	public void testaEmbaralharComSemente() {
		em = new EmbaralhadorAleatorio(new Random(1564));
		
		String palavra = "abcdefgh";
		
		String palavraEmbaralhada = em.embaralhar(palavra);
		
		assertEquals("efahcdbg", palavraEmbaralhada);
		
	}

}
