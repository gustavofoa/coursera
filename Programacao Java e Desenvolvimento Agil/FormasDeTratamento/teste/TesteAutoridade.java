import static org.junit.Assert.*;

import org.junit.Test;


public class TesteAutoridade {

	@Test
	public void testeGetTratamentoInformal() {
		Autoridade autoridade = new Autoridade("nome", "sobrenome", new Informal());
		assertEquals("nome", autoridade.getTratamento());
	}
	
	@Test
	public void testeGetTratamentoRespeitosoMasculino() {
		Autoridade autoridade = new Autoridade("nome", "sobrenome", new Respeitoso('M'));
		assertEquals("Sr. sobrenome", autoridade.getTratamento());
	}
	
	@Test
	public void testeGetTratamentoRespeitosoFeminino() {
		Autoridade autoridade = new Autoridade("nome", "sobrenome", new Respeitoso('F'));
		assertEquals("Sra. sobrenome", autoridade.getTratamento());
	}
	
	@Test
	public void testeGetTratamentoRespeitosoMasculinoMinusculo() {
		Autoridade autoridade = new Autoridade("nome", "sobrenome", new Respeitoso('m'));
		assertEquals("Sr. sobrenome", autoridade.getTratamento());
	}
	
	@Test
	public void testeGetTratamentoRespeitosoFemininoMaiusculo() {
		Autoridade autoridade = new Autoridade("nome", "sobrenome", new Respeitoso('f'));
		assertEquals("Sra. sobrenome", autoridade.getTratamento());
	}
	
	@Test
	public void testeGetTratamentoRespeitosoSexoInvalido() {
		Autoridade autoridade = new Autoridade("nome", "sobrenome", new Respeitoso('x'));
		assertEquals("", autoridade.getTratamento());
	}
	
	@Test
	public void testeGetTratamentoComTitulo() {
		Autoridade autoridade = new Autoridade("nome", "sobrenome", new ComTitulo("Respeitoso"));
		assertEquals("Respeitoso nome sobrenome", autoridade.getTratamento());
	}
	

}
