package jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FabricaMecanicaDoJogo {

	private List<MecanicaDoJogo> mecanicas = new ArrayList<MecanicaDoJogo>();

	public FabricaMecanicaDoJogo(List<String> palavras) {
		mecanicas.add(new Jogo10Palavras1Chute(palavras));
		mecanicas.add(new Jogo7Erros(palavras));
	}

	public MecanicaDoJogo getMecanicaDoJogo() {
		int index = new Random().nextInt(mecanicas.size());
		return mecanicas.get(index);
	}

}
