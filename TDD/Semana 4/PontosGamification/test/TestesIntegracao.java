import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestesIntegracao extends TestesComArquivos {

	/**
	 * CT01 - Registrar X pontos do tipo Y para o usuário Z no arquivo de armazenamento. (Arquivo vazio)
	 * @throws IOException 
	 */
	@Test
	public void registrar10PontosDoTipoEstrelaParaUsuarioGustavoNoArquivoSendoArquivoVazio() throws IOException {
		
		Placar placar = new Placar(new Armazenamento(arquivo));
		
		placar.registrarPontos("Gustavo", "Estrela", 10);
		
		criaLeitorDoArquivo();
		assertEquals("Gustavo:Estrela:10", leitor.readLine());
		fechaLeitorDoArquivo();
		
	}

	/**
	 * CT02 - Registrar X pontos do tipo Y para o usuário Z no arquivo de armazenamento. (Arquivo com dados)
	 * @throws IOException 
	 */
	@Test
	public void registrar10PontosDoTipoCoracaoParaUsuarioGustavoNoArquivoSendoArquivoJaComDados() throws IOException {

		criaEscritorDoArquivo();
		escreveLinhaNoArquivo("Gustavo:nuvem:20");
		escreveLinhaNoArquivo("Gustavo:sol:3");
		fechaEscritorDoArquivo();
		
		Placar placar = new Placar(new Armazenamento(arquivo));
		
		placar.registrarPontos("Carlos", "coração", 10);

		List<String> linhas = obtemLinhasDoArquivo();
		
		assertEquals(new Integer(3), new Integer(linhas.size()));
		assertTrue(linhas.contains("Gustavo:nuvem:20"));
		assertTrue(linhas.contains("Carlos:coração:10"));
		assertTrue(linhas.contains("Gustavo:sol:3"));
		
	}

	/**
	 * CT03 - Obter do arquivo de armazenamento os pontos do Usuário X
	 * @throws IOException 
	 */
	@Test
	public void obterPontosDosUsuariosGustavoEJoaoDoArquivo() throws IOException {

		criaEscritorDoArquivo();
		escreveLinhaNoArquivo("Gustavo:nuvem:20");
		escreveLinhaNoArquivo("Gustavo:sol:2");
		escreveLinhaNoArquivo("Marcos:nuvem:2");
		escreveLinhaNoArquivo("João:estrela:5");
		escreveLinhaNoArquivo("Gustavo:lua:12");
		fechaEscritorDoArquivo();
		
		Placar placar = new Placar(new Armazenamento(arquivo));
		
		Map<String, Integer> pontosDoUsuario = placar.obterPontosDoUsuario("Gustavo");

		assertEquals(new Integer(3), new Integer(pontosDoUsuario.size()));
		assertEquals(new Integer(2), pontosDoUsuario.get("sol"));
		assertEquals(new Integer(20), pontosDoUsuario.get("nuvem"));
		assertEquals(new Integer(12), pontosDoUsuario.get("lua"));

		pontosDoUsuario = placar.obterPontosDoUsuario("João");

		assertEquals(new Integer(1), new Integer(pontosDoUsuario.size()));
		assertEquals(new Integer(5), pontosDoUsuario.get("estrela"));
		
	}

}

