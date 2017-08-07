import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class ArquivoUtils {

	private static FileOutputStream fileOutputStream;
	private static OutputStreamWriter outputStreamWriter;
	private static FileInputStream fileInputStream;
	private static InputStreamReader inputStreamReader;
	private static BufferedWriter escritor;
	private static BufferedReader leitor;

	public static void leArquivo(Map<String, Map<String, Integer>> cache, File arquivo) {
		try{
			criaLeitorDoArquivo(arquivo);
			
			String linha = null;
			
			while((linha = leitor.readLine()) != null){
				String[] registro = linha.split(":");
				adicionaRegistroNoCache(registro[0], registro[1], Integer.parseInt(registro[2]), cache);
			}
			
			fechaLeitorDoArquivo();
		} catch (Exception e) {}
	}

	public static void escreveArquivo(Map<String, Map<String, Integer>> cache, File arquivo) throws IOException{
		
		criaEscritorDoArquivo(arquivo);
		
		for(String usuario : cache.keySet()){
			for(String tipo : cache.get(usuario).keySet()){
				Integer pontos = cache.get(usuario).get(tipo);
				escritor.write(String.format("%s:%s:%d%s", usuario, tipo, pontos, System.lineSeparator()));
			}
		}
		
		fechaEscritorDoArquivo();
		
	}

	private static void adicionaRegistroNoCache(String usuario, String tipo, Integer pontos, Map<String, Map<String, Integer>> cache) {
		if(cache.get(usuario) != null){
			cache.get(usuario).put(tipo, pontos);
		} else {
			Map<String, Integer> tipo_ponto = new HashMap<>();
			tipo_ponto.put(tipo, pontos);
			cache.put(usuario, tipo_ponto);
		}
	}
	
	private static void criaLeitorDoArquivo(File arquivo) throws FileNotFoundException {
		fileInputStream = new FileInputStream(arquivo);
		inputStreamReader = new InputStreamReader(fileInputStream);
		leitor = new BufferedReader(inputStreamReader);
	}

	private static void criaEscritorDoArquivo(File arquivo) throws FileNotFoundException {
		fileOutputStream = new FileOutputStream(arquivo);
		outputStreamWriter = new OutputStreamWriter(fileOutputStream);
		escritor = new BufferedWriter(outputStreamWriter);
	}

	private static void fechaLeitorDoArquivo() throws IOException {
		leitor.close();
		inputStreamReader.close();
		fileInputStream.close();		
	}

	private static void fechaEscritorDoArquivo() throws IOException {
		escritor.flush();
		escritor.close();
		outputStreamWriter.close();
		fileOutputStream.close();		
	}

}
