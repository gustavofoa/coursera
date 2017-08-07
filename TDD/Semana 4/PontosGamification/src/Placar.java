import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Placar {
	
	private static final Comparator<? super Map<String, Integer>> comparadorRanking = new ComparadorRanking();
	private Armazenamento armazenamento;

	public Placar(Armazenamento armazenamento) {
		this.armazenamento = armazenamento;
	}

	public void registrarPontos(String usuario, String tipo, int pontos) throws IOException {
		armazenamento.armazenarPontos(usuario, tipo, pontos);
	}

	public Map<String, Integer> obterPontosDoUsuario(String usuario) {
		
		Map<String, Integer> pontosPorTipo = new HashMap<>();
		
		for(String tipoDePonto : armazenamento.tiposDePontoRegistrados(usuario))
			pontosPorTipo.put(tipoDePonto, armazenamento.obterPontos(usuario, tipoDePonto));
		
		return pontosPorTipo;
		
	}

	public List<Map<String, Integer>> obterRanking(String tipo) {
		
		List<Map<String, Integer>> ranking = new ArrayList<>();
		
		for(String usuario : armazenamento.usuariosQuePontuaram()){
			Integer pontosDoUsuario = armazenamento.obterPontos(usuario, tipo);
			adicionaUsuarioNoRanking(ranking, usuario, pontosDoUsuario);
		}
		
		ranking.sort(comparadorRanking);
		
		return ranking;
		
	}

	private void adicionaUsuarioNoRanking(List<Map<String, Integer>> ranking, String usuario, Integer pontosDoUsuario) {
		if(pontosDoUsuario > 0){
			Map<String, Integer> usuarioPontos = new HashMap<>();
			usuarioPontos.put(usuario, pontosDoUsuario);
			ranking.add(usuarioPontos);
		}
	}

}
