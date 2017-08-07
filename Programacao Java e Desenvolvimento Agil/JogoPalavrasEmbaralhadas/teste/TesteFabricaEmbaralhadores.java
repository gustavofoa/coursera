import static org.junit.Assert.*;

import org.junit.Test;

import embaralhamento.Embaralhador;
import embaralhamento.FabricaEmbaralhadores;

public class TesteFabricaEmbaralhadores {

	@Test
	public void testeGetEmbaralhador() {
		FabricaEmbaralhadores fabrica = new FabricaEmbaralhadores();
		Embaralhador em = fabrica.getEmbaralhador();
		Class<? extends Embaralhador> classeAtual = em.getClass();
		
		int alteracoes = 0;
		
		for(int i=0;i<1000;i++){
			Class<? extends Embaralhador> novaClasse = fabrica.getEmbaralhador().getClass();
			if(!classeAtual.equals(novaClasse))
				alteracoes++;
		}

		assertNotEquals(0, alteracoes);
	}

}
