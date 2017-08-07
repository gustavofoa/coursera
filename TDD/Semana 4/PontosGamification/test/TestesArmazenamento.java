import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class TestesArmazenamento extends TestesComArquivos {
	
	/**
	 * CT01 - Armazenar X pontos do tipo Y para o usuário Z
	 * @throws IOException 
	 */
	@Test
	public void armazenar10PontosDoTipoEstrelaParaOUsuarioGustavo() throws IOException {

		Armazenamento armazenamento = new Armazenamento(arquivo);
		
		armazenamento.armazenarPontos("Gustavo", "Estrela", 10);

		criaLeitorDoArquivo();
		assertEquals("Gustavo:Estrela:10", leitor.readLine());
		fechaLeitorDoArquivo();
		
	}

	/**
	 * CT01 - Armazenar X pontos do tipo Y para o usuário Z
	 * @throws IOException 
	 */
	@Test
	public void armazenar30PontosDoTipoCurtidaParaOUsuarioJoao() throws IOException {
		
		Armazenamento armazenamento = new Armazenamento(arquivo);
		
		armazenamento.armazenarPontos("João", "Curtida", 15);
		armazenamento.armazenarPontos("Gustavo", "Compartilhamento", 2);
		armazenamento.armazenarPontos("João", "Compartilhamento", 1);

		List<String> linhas = obtemLinhasDoArquivo();
		
		assertEquals(new Integer(3), new Integer(linhas.size()));
		assertTrue(linhas.contains("Gustavo:Compartilhamento:2"));
		assertTrue(linhas.contains("João:Curtida:15"));
		assertTrue(linhas.contains("João:Compartilhamento:1"));
		
	}

	/**
	 * CT02 - Recuperar quantidade de pontos do tipo X para o usuário Y
	 * @throws IOException
	 */
	@Test
	public void recuperarQuantidadeDePontosDoTipoXParaOUsuarioY() throws IOException{
		
		criaEscritorDoArquivo();
		escreveLinhaNoArquivo("Gustavo:Cerveja:20");
		escreveLinhaNoArquivo("Cesar:Vinho:2");
		escreveLinhaNoArquivo("Gustavo:Vinho:50");
		escreveLinhaNoArquivo("Marcos:Destilado:20");
		escreveLinhaNoArquivo("Cesar:Cerveja:10");
		fechaEscritorDoArquivo();
		
		Armazenamento armazenamento = new Armazenamento(arquivo);
		
		assertEquals(new Integer(20), armazenamento.obterPontos("Gustavo", "Cerveja"));
		assertEquals(new Integer(2), armazenamento.obterPontos("Cesar", "Vinho"));
		assertEquals(new Integer(10), armazenamento.obterPontos("Cesar", "Cerveja"));
		assertEquals(new Integer(20), armazenamento.obterPontos("Marcos", "Destilado"));
		assertEquals(new Integer(50), armazenamento.obterPontos("Gustavo", "Vinho"));
		
	}

	/**
	 * CT03 - Listar usuários que já receberam algum tipo de ponto
	 * @throws IOException
	 */
	@Test
	public void listarUsuariosQueJaReceberamPontos() throws IOException{
		
		criaEscritorDoArquivo();
		escreveLinhaNoArquivo("Gustavo:Cerveja:20");
		escreveLinhaNoArquivo("Cesar:Vinho:2");
		escreveLinhaNoArquivo("Gustavo:Vinho:50");
		escreveLinhaNoArquivo("Marcos:Destilado:20");
		escreveLinhaNoArquivo("Cesar:Cerveja:10");
		escreveLinhaNoArquivo("Otávio:Fruta:5");
		escreveLinhaNoArquivo("Otávio:Verdura:10");
		escreveLinhaNoArquivo("Otávio:Legume:2");
		fechaEscritorDoArquivo();
		
		Armazenamento armazenamento = new Armazenamento(arquivo);
		
		List<String> usuariosQuePontuaram = armazenamento.usuariosQuePontuaram();
		
		assertEquals(new Integer(4), new Integer(usuariosQuePontuaram.size()));
		assertTrue(usuariosQuePontuaram.contains("Gustavo"));
		assertTrue(usuariosQuePontuaram.contains("Cesar"));
		assertTrue(usuariosQuePontuaram.contains("Marcos"));
		assertTrue(usuariosQuePontuaram.contains("Otávio"));
		
	}

	/**
	 * CT04 - Listar os tipos de ponto que já foram registrados para o usuário X
	 * @throws IOException
	 */
	@Test
	public void listarTiposDePontoDeUmUsuario() throws IOException{
		
		criaEscritorDoArquivo();
		escreveLinhaNoArquivo("Gustavo:Cerveja:20");
		escreveLinhaNoArquivo("Cesar:Vinho:2");
		escreveLinhaNoArquivo("Gustavo:Vinho:50");
		escreveLinhaNoArquivo("Marcos:Destilado:20");
		escreveLinhaNoArquivo("Cesar:Cerveja:10");
		escreveLinhaNoArquivo("Otávio:Fruta:5");
		escreveLinhaNoArquivo("Otávio:Verdura:10");
		escreveLinhaNoArquivo("Otávio:Legume:2");
		fechaEscritorDoArquivo();
		
		Armazenamento armazenamento = new Armazenamento(arquivo);
		
		List<String> tiposDePontoDoGustavo = armazenamento.tiposDePontoRegistrados("Gustavo");
		assertEquals(new Integer(2), new Integer(tiposDePontoDoGustavo.size()));
		assertTrue(tiposDePontoDoGustavo.contains("Cerveja"));
		assertTrue(tiposDePontoDoGustavo.contains("Vinho"));
		
		List<String> tiposDePontoDoCesar = armazenamento.tiposDePontoRegistrados("Cesar");
		assertEquals(new Integer(2), new Integer(tiposDePontoDoCesar.size()));
		assertTrue(tiposDePontoDoCesar.contains("Cerveja"));
		assertTrue(tiposDePontoDoCesar.contains("Vinho"));
		
		List<String> tiposDePontoDoMarcos = armazenamento.tiposDePontoRegistrados("Marcos");
		assertEquals(new Integer(1), new Integer(tiposDePontoDoMarcos.size()));
		assertTrue(tiposDePontoDoMarcos.contains("Destilado"));
		
		List<String> tiposDePontoDoOtavio = armazenamento.tiposDePontoRegistrados("Otávio");
		assertEquals(new Integer(3), new Integer(tiposDePontoDoOtavio.size()));
		assertTrue(tiposDePontoDoOtavio.contains("Fruta"));
		assertTrue(tiposDePontoDoOtavio.contains("Verdura"));
		assertTrue(tiposDePontoDoOtavio.contains("Legume"));
		
	}

}
