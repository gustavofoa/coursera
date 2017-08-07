import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DicionarioFactory {

	private String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null)
				sb.append(line);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}

	public Map<String, String> dicionarioDoArquivo(String arquivo) {
		Map<String, String> dicionario = new HashMap<String, String>();
		
 		String conteudoDoArquivo = getStringFromInputStream(getClass().getResourceAsStream(arquivo));		
		for(String linha : conteudoDoArquivo.split(";")){
			String[] traducao = linha.split("=");
			dicionario.put(traducao[0], traducao[1]);
		}
		
		return dicionario;
	}

}
