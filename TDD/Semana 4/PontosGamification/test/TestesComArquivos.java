import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

public class TestesComArquivos {

	@Rule
	public TemporaryFolder folder;
	public File arquivo;
	private FileOutputStream fileOutputStream;
	private OutputStreamWriter outputStreamWriter;
	private FileInputStream fileInputStream;
	private InputStreamReader inputStreamReader;
	protected BufferedWriter escritor;
	protected BufferedReader leitor;

	public TestesComArquivos() {
		super();
	}

	@Before
	public void criaArquivo() throws IOException {
		arquivo = new File("dados.txt");
		arquivo.createNewFile();
	}

	@After
	public void excluiArquivo() throws IOException {
		arquivo = new File("dados.txt");
		arquivo.delete();
	}

	protected void criaLeitorDoArquivo() throws FileNotFoundException {
		fileInputStream = new FileInputStream(arquivo);
		inputStreamReader = new InputStreamReader(fileInputStream);
		leitor = new BufferedReader(inputStreamReader);
	}

	protected void criaEscritorDoArquivo() throws FileNotFoundException {
		fileOutputStream = new FileOutputStream(arquivo);
		outputStreamWriter = new OutputStreamWriter(fileOutputStream);
		escritor = new BufferedWriter(outputStreamWriter);
	}

	protected void fechaLeitorDoArquivo() throws IOException {
		leitor.close();
		inputStreamReader.close();
		fileInputStream.close();		
	}

	protected void fechaEscritorDoArquivo() throws IOException {
		escritor.flush();
		escritor.close();
		outputStreamWriter.close();
		fileOutputStream.close();		
	}
	

	protected List<String> obtemLinhasDoArquivo() throws FileNotFoundException, IOException {
		List<String> linhas = new ArrayList<>();

		criaLeitorDoArquivo();
		String linha = null;
		while( (linha = leitor.readLine()) !=null )
			linhas.add(linha);
		fechaLeitorDoArquivo();
		return linhas;
	}

	protected void escreveLinhaNoArquivo(String linha) throws IOException {
		escritor.write(linha + System.lineSeparator());
	}
	

}