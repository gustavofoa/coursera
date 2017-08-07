import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class TesteProcessadorArquivo {

	@Test
	public void testeLeituraCorretaDeArquivo1() throws LeituraArquivoException {

		Map<String, String> mapa = ProcessadorArquivo.processar("arquivoCorreto1.txt");

		assertEquals("Gustavo", mapa.get("nome"));
		assertEquals("Furtado", mapa.get("sobrenome"));
		assertEquals("26", mapa.get("idade"));

	}

	@Test
	public void testeLeituraCorretaDeArquivo2() throws LeituraArquivoException {

		Map<String, String> mapa = ProcessadorArquivo.processar("arquivoCorreto2.txt");

		assertEquals("Eduardo", mapa.get("nome"));
		assertEquals("Guerra", mapa.get("sobrenome"));
		assertEquals("35", mapa.get("idade"));

	}

	@Test
	public void testeErroLeituraDeArquivo() {

		try {
			ProcessadorArquivo.processar("arquivoInexistente.txt");
			fail();
		} catch (LeituraArquivoException e) {
			assertTrue(e.getMessage().startsWith("Erro ao abrir o arquivo"));
		}

	}

	@Test
	public void testeLeituraDeArquivoVazio() {

		try {
			ProcessadorArquivo.processar("arquivoVazio.txt");
			fail();
		} catch (LeituraArquivoException e) {
			assertEquals("Arquivo vazio", e.getMessage());
		}

	}

	@Test
	public void testeLinhaComMaisDeUmSeparador() {

		try {
			ProcessadorArquivo.processar("arquivoMaisDeUmSeparador.txt");
			fail();
		} catch (LeituraArquivoException e) {
			assertEquals("Formato de arquivo inválido", e.getMessage());
		}

	}

	@Test
	public void testeLinhaSemSeparador() {

		try {
			ProcessadorArquivo.processar("arquivoSemSeparador.txt");
			fail();
		} catch (LeituraArquivoException e) {
			assertEquals("Formato de arquivo inválido", e.getMessage());
		}

	}

}
