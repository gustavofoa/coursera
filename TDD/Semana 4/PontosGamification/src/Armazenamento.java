import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Armazenamento {
	
	//Formato escolhido para o registro -> usuario:tipo_de_pontos:pontos
	//se um registro do tipo usuario:tipo_de_pontos for encontrado,
	//a quantidade de pontos deve ser incrementada
	//Os dados serão mantidos em cache de um Map<String, Map<String, Integer>> - usuário, tipo de pontos e pontos
	//A leitura do arquivo é feita apenas na construção da classe Armazenamento
	//Os dados serão salvos no arquivo no final do método armazenarPontos
	
	private Map<String, Map<String, Integer>> cache;
	private File arquivo;
	
	public Armazenamento(File arquivo) {
		this.arquivo = arquivo;
		cache = new HashMap<>();
		ArquivoUtils.leArquivo(cache, arquivo);
	}
	
	public void armazenarPontos(String usuario, String tipo, int pontos) throws IOException{
		
		Map<String, Integer> registroDoUsuario = cache.get(usuario);
		
		if(registroDoUsuario == null){
			registroDoUsuario = new HashMap<>();
			cache.put(usuario, registroDoUsuario);
		}

		Integer pontuacaoAtual = registroDoUsuario.get(tipo);
		
		if(pontuacaoAtual == null){
			pontuacaoAtual = 0;
		}
		
		registroDoUsuario.put(tipo, pontuacaoAtual + pontos);		
		
		ArquivoUtils.escreveArquivo(cache, arquivo);
		
	}

	public Integer obterPontos(String usuario, String tipo){
		return cache.get(usuario).get(tipo);
	}
	
	public List<String> usuariosQuePontuaram(){
		Set<String> usuariosQuePontuaram = cache.keySet();
		return new ArrayList<>(usuariosQuePontuaram);
	}
	
	public List<String> tiposDePontoRegistrados(String usuario){
		Set<String> tiposDePontoDoUsuario = cache.get(usuario).keySet();
		return new ArrayList<>(tiposDePontoDoUsuario);
	}

}
