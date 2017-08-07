package embaralhamento;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FabricaEmbaralhadores {
	
	private List<Embaralhador> embaralhadores = new ArrayList<>();

	public FabricaEmbaralhadores() {
		embaralhadores.add(new EmbaralhadorAleatorio(new Random()));
		embaralhadores.add(new EmbaralhadorAlfabetico());
	}
	
	public Embaralhador getEmbaralhador(){
		int index = new Random().nextInt(embaralhadores.size());
		return embaralhadores.get(index);
	}

}
