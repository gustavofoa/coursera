import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProcessadorArquivo {
	
	private static String SOURCE_FOLDER = "arquivos/";

	public static Map<String, String> processar(String arquivo) throws LeituraArquivoException {
		Map<String, String> mapa = new HashMap<>();

		Scanner scanner = null;
		try {

			InputStream stream = new FileInputStream(SOURCE_FOLDER + arquivo);

			scanner = new Scanner(stream);

			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				String[] palavras = linha.split("->");
				if (palavras.length != 2)
					throw new LeituraArquivoException("Formato de arquivo inválido");
				mapa.put(palavras[0], palavras[1]);
			}

			if (mapa.isEmpty())
				throw new LeituraArquivoException("Arquivo vazio");

		} catch (IOException e) {
			throw new LeituraArquivoException("Erro ao abrir o arquivo: " + e.getMessage());
		} finally {
			if (scanner != null)
				scanner.close();
		}

		return mapa;
	}

}
