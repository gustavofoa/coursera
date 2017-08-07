import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import org.junit.Test;

import jogo.BancoDePalavras;

public class TesteBancoDePalavras {

	@Test(expected=InvalidAttributesException.class)
	public void testeCriaInstanciaComListaVazia() throws InvalidAttributesException {
		new BancoDePalavras(new ArrayList<String>());
	}

	@Test(expected=InvalidAttributesException.class)
	public void testeCriaInstanciaListaNula() throws InvalidAttributesException {
		new BancoDePalavras(null);
	}
	
	@Test
	public void testeRetornoPalavraDaLista() throws InvalidAttributesException{
		List<String> palavras = getListaPalavras();
		
		BancoDePalavras banco = new BancoDePalavras(palavras);
		
		assertTrue(palavras.contains(banco.getPalavra()));
	}

	@Test
	public void testeRetornoPalavraAleatoria() throws InvalidAttributesException{
		List<String> palavras = getListaPalavras();
		
		BancoDePalavras banco = new BancoDePalavras(palavras);
		
		String palavraExistente = banco.getPalavra();
		
		int alteracoes = 0;
		
		for(int i=0;i<100000;i++){
			String novaPalavra = banco.getPalavra();
			if(!palavraExistente.equals(novaPalavra))
				alteracoes++;
		}
		
		assertNotEquals(0, alteracoes);
		
	}

	private List<String> getListaPalavras() {
		List<String> palavras = new ArrayList<>();
		palavras.add("palavra1");
		palavras.add("palavra2");
		palavras.add("palavra3");
		palavras.add("palavra4");
		return palavras;
	}

}
