import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockArmazenamentoRanking extends Armazenamento {

	public MockArmazenamentoRanking() {
		super(new File("."));
	}

	private Map<String, Map<String, Integer>> pontosDoTipoParaUsuario = new HashMap<>();
	private Map<String, Map<String, Boolean>> obtevePontos = new HashMap<>();
	private List<String> usuariosQuePontuaram;
	private boolean obteveUsuariosQuePontuaram;

	//Requisitos

	public void retornarEstesUsuariosQuePontuaram(List<String> usuariosQuePontuaram) {
		this.usuariosQuePontuaram = usuariosQuePontuaram;
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
	
	public void verificaSeObteveUsuariosQuePontuaram() {
		assertTrue(obteveUsuariosQuePontuaram);
	}
	
	//implementações

	@Override
	public List<String> usuariosQuePontuaram(){
		obteveUsuariosQuePontuaram = true;
		return usuariosQuePontuaram;
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
