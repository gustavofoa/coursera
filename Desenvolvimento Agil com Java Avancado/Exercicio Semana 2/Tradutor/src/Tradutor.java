import java.util.Map;

public class Tradutor {
	
	private Map<String, String> dicionario;
	
	public Tradutor(){
		dicionario = new DicionarioFactory().dicionarioDoArquivo("dicionario.txt");
	}

	public String traduzir(String palavraParaTraduzir) {
		
		if(dicionario.containsKey(palavraParaTraduzir))
			return dicionario.get(palavraParaTraduzir);
		
		return palavraParaTraduzir;
		
	}

}
