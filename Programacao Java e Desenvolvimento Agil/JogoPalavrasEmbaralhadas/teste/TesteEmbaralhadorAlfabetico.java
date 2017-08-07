import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import embaralhamento.Embaralhador;
import embaralhamento.EmbaralhadorAlfabetico;

public class TesteEmbaralhadorAlfabetico {

	private Embaralhador em;
	
	@Before
	public void criaInstanciaEmbaralhador(){
		em = new EmbaralhadorAlfabetico();
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
	public void testaEmbaralhamentoAlfabetico(){
		String palavra = em.embaralhar("cadeira");
		assertEquals("aacdeir", palavra);
	}

	@Test
	public void testaEmbaralhamentoAlfabetico2(){
		String palavra = em.embaralhar("palavraembaralhada");
		assertEquals("aaaaaaabdehllmprrv", palavra);
	}
	
}
