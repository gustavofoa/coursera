import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestesPlacar {
	
	private MockArmazenamentoRegistrarPontos mockArmazenamentoRegistrarPontos;
	private MockArmazenamentoObterPontos mockArmazenamentoObterPontos;
	private MockArmazenamentoRanking mockArmazenamentoRanking;
	private Placar placar;
	
	@Before
	public void setUpPlacar() {
		mockArmazenamentoRegistrarPontos = new MockArmazenamentoRegistrarPontos();
		mockArmazenamentoObterPontos = new MockArmazenamentoObterPontos();
		mockArmazenamentoRanking = new MockArmazenamentoRanking();
	}

	/**
	 * CT01 - Registrar X pontos do tipo Y para o usu�rio Z
	 * @throws IOException 
	 */
	@Test
	public void registrar10PontosDoTipoEstrelaParaUsuarioGustavo() throws IOException {
		
		placar = new Placar(mockArmazenamentoRegistrarPontos);
		
		placar.registrarPontos("Gustavo", "estrela", 10);
		
		mockArmazenamentoRegistrarPontos.verificaSeArmazenouPontos(10, "estrela", "Gustavo");
		
	}

	/**
	 * CT01 - Registrar X pontos do tipo Y para o usu�rio Z
	 * @throws IOException 
	 */
	@Test
	public void registrar20PontosDoTipoEstrelaParaUsuarioGustavo() throws IOException {

		placar = new Placar(mockArmazenamentoRegistrarPontos);
		
		placar.registrarPontos("Gustavo", "estrela", 20);
		
		mockArmazenamentoRegistrarPontos.verificaSeArmazenouPontos(20, "estrela", "Gustavo");
		
	}

	/**
	 * CT01 - Registrar X pontos do tipo Y para o usu�rio Z
	 * @throws IOException 
	 */
	@Test
	public void registrar10PontosDoTipoMunicaoParaUsuarioGustavo() throws IOException {

		placar = new Placar(mockArmazenamentoRegistrarPontos);
		
		placar.registrarPontos("Gustavo", "muni��o", 10);
		
		mockArmazenamentoRegistrarPontos.verificaSeArmazenouPontos(10, "muni��o", "Gustavo");
		
	}

	/**
	 * CT01 - Registrar X pontos do tipo Y para o usu�rio Z
	 * @throws IOException 
	 */
	@Test
	public void registrar10PontosDoTipoEstrelaParaUsuarioPedro() throws IOException {

		placar = new Placar(mockArmazenamentoRegistrarPontos);
		
		placar.registrarPontos("Pedro", "estrela", 10);
		
		mockArmazenamentoRegistrarPontos.verificaSeArmazenouPontos(10, "estrela", "Pedro");
		
	}
	
	/**
	 * CT02 - Obter pontos do Usu�rio X (Retornar um Map<String, Integer>)
	 */
	@Test
	public void obterPontosDoUsuarioGustavo(){

		placar = new Placar(mockArmazenamentoObterPontos);
		
		String usuario = "Gustavo";
		List<String> tiposDePontoDoGustavo = new ArrayList<>();
		tiposDePontoDoGustavo.add("estrela");
		tiposDePontoDoGustavo.add("cora��o");
		
		mockArmazenamentoObterPontos.retornarEstaListaDeTiposDePontoParaUsuario(tiposDePontoDoGustavo, usuario);
		mockArmazenamentoObterPontos.retornarEstesPontosDoTipoParaUsuario(20, "estrela", usuario);
		mockArmazenamentoObterPontos.retornarEstesPontosDoTipoParaUsuario(30, "cora��o", usuario);
		
		Map<String, Integer> pontos = placar.obterPontosDoUsuario(usuario);

		assertEquals(2, pontos.size());
		assertEquals(new Integer(20), pontos.get("estrela"));
		assertEquals(new Integer(30), pontos.get("cora��o"));
		mockArmazenamentoObterPontos.verificaSeObteveListaDeTiposDePontosDoOUsuario();
		mockArmazenamentoObterPontos.verificaObtevePontosDoTipoParaUsuario("estrela", usuario);
		mockArmazenamentoObterPontos.verificaObtevePontosDoTipoParaUsuario("cora��o", usuario);
		
	}

	/**
	 * CT02 - Obter pontos do Usu�rio X (Retornar um Map<String, Integer>)
	 */
	@Test
	public void obterPontosDoUsuarioPaulo(){
		
		placar = new Placar(mockArmazenamentoObterPontos);
		
		String usuario = "Paulo";
		List<String> tiposDePontoDoPaulo = new ArrayList<>();
		tiposDePontoDoPaulo.add("pedra");
		tiposDePontoDoPaulo.add("ouro");
		tiposDePontoDoPaulo.add("diamante");
		
		mockArmazenamentoObterPontos.retornarEstaListaDeTiposDePontoParaUsuario(tiposDePontoDoPaulo, usuario);
		mockArmazenamentoObterPontos.retornarEstesPontosDoTipoParaUsuario(1050, "pedra", usuario);
		mockArmazenamentoObterPontos.retornarEstesPontosDoTipoParaUsuario(30, "ouro", usuario);
		mockArmazenamentoObterPontos.retornarEstesPontosDoTipoParaUsuario(2, "diamante", usuario);
		
		Map<String, Integer> pontos = placar.obterPontosDoUsuario(usuario);

		assertEquals(3, pontos.size());
		assertEquals(new Integer(1050), pontos.get("pedra"));
		assertEquals(new Integer(30), pontos.get("ouro"));
		assertEquals(new Integer(2), pontos.get("diamante"));
		mockArmazenamentoObterPontos.verificaSeObteveListaDeTiposDePontosDoOUsuario();
		mockArmazenamentoObterPontos.verificaObtevePontosDoTipoParaUsuario("pedra", usuario);
		mockArmazenamentoObterPontos.verificaObtevePontosDoTipoParaUsuario("ouro", usuario);
		mockArmazenamentoObterPontos.verificaObtevePontosDoTipoParaUsuario("diamante", usuario);
		
	}

	/**
	 * CT03 - Obter ranking do tipo de pontos X
	 */
	@Test
	public void obterRankingDoTipoDePontosMoeda(){
		
		placar = new Placar(mockArmazenamentoRanking);
		
		List<String> usuariosQuePontuaram = new ArrayList<>();
		usuariosQuePontuaram.add("Gustavo");
		usuariosQuePontuaram.add("Maria");
		usuariosQuePontuaram.add("Jos�");
		usuariosQuePontuaram.add("Daiana");
		usuariosQuePontuaram.add("Wellington");
		usuariosQuePontuaram.add("Jo�o");
		
		mockArmazenamentoRanking.retornarEstesUsuariosQuePontuaram(usuariosQuePontuaram);
		mockArmazenamentoRanking.retornarEstesPontosDoTipoParaUsuario(20, "moeda", "Gustavo");
		mockArmazenamentoRanking.retornarEstesPontosDoTipoParaUsuario(30, "moeda", "Daiana");
		mockArmazenamentoRanking.retornarEstesPontosDoTipoParaUsuario(10, "moeda", "Jos�");
		mockArmazenamentoRanking.retornarEstesPontosDoTipoParaUsuario(80, "moeda", "Maria");
		mockArmazenamentoRanking.retornarEstesPontosDoTipoParaUsuario(150, "moeda", "Wellington");
		mockArmazenamentoRanking.retornarEstesPontosDoTipoParaUsuario(0, "moeda", "Jo�o");
		
		List<Map<String, Integer>> ranking = placar.obterRanking("moeda");
		
		mockArmazenamentoRanking.verificaSeObteveUsuariosQuePontuaram();
		
		assertEquals(new Integer(5), new Integer(ranking.size()));
		
		assertEquals(new Integer(150), ranking.get(0).get("Wellington"));
		assertEquals(new Integer(80), ranking.get(1).get("Maria"));
		assertEquals(new Integer(30), ranking.get(2).get("Daiana"));
		assertEquals(new Integer(20), ranking.get(3).get("Gustavo"));
		assertEquals(new Integer(10), ranking.get(4).get("Jos�"));
		//Jo�o n�o est� no ranking porque n�o tem pontos.
		
	}

	/**
	 * CT03 - Obter ranking do tipo de pontos X
	 */
	@Test
	public void obterRankingDoTipoDePontosCora��o(){
		
		placar = new Placar(mockArmazenamentoRanking);
		
		List<String> usuariosQuePontuaram = new ArrayList<>();
		usuariosQuePontuaram.add("Pedro");
		usuariosQuePontuaram.add("Marcos");
		usuariosQuePontuaram.add("Ana");
		usuariosQuePontuaram.add("Lucas");
		usuariosQuePontuaram.add("Philippe");
		usuariosQuePontuaram.add("Carlos");
		usuariosQuePontuaram.add("Larissa");
		usuariosQuePontuaram.add("Sandra");
		
		mockArmazenamentoRanking.retornarEstesUsuariosQuePontuaram(usuariosQuePontuaram);
		mockArmazenamentoRanking.retornarEstesPontosDoTipoParaUsuario(215, "cora��o", "Pedro");
		mockArmazenamentoRanking.retornarEstesPontosDoTipoParaUsuario(48, "cora��o", "Marcos");
		mockArmazenamentoRanking.retornarEstesPontosDoTipoParaUsuario(0, "cora��o", "Ana");
		mockArmazenamentoRanking.retornarEstesPontosDoTipoParaUsuario(15, "cora��o", "Lucas");
		mockArmazenamentoRanking.retornarEstesPontosDoTipoParaUsuario(198, "cora��o", "Philippe");
		mockArmazenamentoRanking.retornarEstesPontosDoTipoParaUsuario(125, "cora��o", "Carlos");
		mockArmazenamentoRanking.retornarEstesPontosDoTipoParaUsuario(0, "cora��o", "Larissa");
		mockArmazenamentoRanking.retornarEstesPontosDoTipoParaUsuario(25, "cora��o", "Sandra");
		
		List<Map<String, Integer>> ranking = placar.obterRanking("cora��o");
		
		mockArmazenamentoRanking.verificaSeObteveUsuariosQuePontuaram();
		
		assertEquals(new Integer(6), new Integer(ranking.size()));
		
		assertEquals(new Integer(215), ranking.get(0).get("Pedro"));
		assertEquals(new Integer(198), ranking.get(1).get("Philippe"));
		assertEquals(new Integer(125), ranking.get(2).get("Carlos"));
		assertEquals(new Integer(48), ranking.get(3).get("Marcos"));
		assertEquals(new Integer(25), ranking.get(4).get("Sandra"));
		assertEquals(new Integer(15), ranking.get(5).get("Lucas"));
		//Ana e Larissa n�o est�o no ranking porque n�o t�m pontos.
		
	}
	
}
