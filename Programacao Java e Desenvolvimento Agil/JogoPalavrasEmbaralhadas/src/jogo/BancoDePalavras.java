package jogo;
import java.util.List;
import java.util.Random;

import javax.naming.directory.InvalidAttributesException;

public class BancoDePalavras {
	
	private List<String> palavras;

	public BancoDePalavras(List<String> palavras) throws InvalidAttributesException {
		if(palavras ==null || palavras.isEmpty())
			throw new InvalidAttributesException();
		this.palavras = palavras;
	}
	
	public String getPalavra(){
		
		int index = new Random().nextInt(palavras.size());
		
		return palavras.get(index);
	}

}
