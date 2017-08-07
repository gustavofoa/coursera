import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockArmazenamentoObterPontos extends Armazenamento {

	public MockArmazenamentoObterPontos() {
		super(new File("."));		
	}

	private Map<String, Map<String, Integer>> pontosDoTipoParaUsuario = new HashMap<>();
	private String usuarioListaDeTiposDePontosObtida;
	private boolean obteveListaDeTiposDePontos;
	private List<String> tiposDePontoDoUsuario;
	private String usuarioAObterTiposDePonto;
	private Map<String, Map<String, Boolean>> obtevePontos = new HashMap<>();

	//Requisitos
	
	public void retornarEstaListaDeTiposDePontoParaUsuario(List<String> tiposDePonto, String usuario) {
		tiposDePontoDoUsuario = tiposDePonto;
		usuarioAObterTiposDePonto = usuario;
	}

	public void retornarEstesPontosDoTipoParaUsuario(int pontos, String tipo, String usuario) {
		Map<String, Integer> pontosPorTipo = pontosDoTipoParaUsuario.get(usuario);
		
		if(pontosPorTipo == null){
			pontosPorTipo = new HashMap<>();
			pontosDoTipoParaUsuario.put(usuario, pontosPorTipo);
		}
			
		pontosPorTipo.put(tipo, pontos);
	}

	//Verificações

	public void verificaObtevePontosDoTipoParaUsuario(String tipo, String usuario) {
		assertTrue(obtevePontos.get(usuario).get(tipo));		
	}

	public void verificaSeObteveListaDeTiposDePontosDoOUsuario() {
		assertTrue(obteveListaDeTiposDePontos);
		assertEquals(usuarioAObterTiposDePonto, usuarioListaDeTiposDePontosObtida);
	}

	//implementações

	@Override
	public List<String> tiposDePontoRegistrados(String usuario){
		obteveListaDeTiposDePontos = true;
		usuarioListaDeTiposDePontosObtida = usuario;
		return tiposDePontoDoUsuario;
	}

	@Override
	public Integer obterPontos(String usuario, String tipo){
		Map<String, Boolean> tiposObtidos = obtevePontos.get(usuario);
		if(tiposObtidos == null){
			tiposObtidos = new HashMap<>();
			obtevePontos.put(usuario, tiposObtidos);
		}
		
		tiposObtidos.put(tipo, true);
		
		Map<String, Integer> pontosPorTipo = pontosDoTipoParaUsuario.get(usuario);
		return pontosPorTipo.get(tipo);
	}
	
}
