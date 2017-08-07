package jogo;

import java.util.List;

import embaralhamento.FabricaEmbaralhadores;

public class Jogo7Erros extends MecanicaDoJogo {

	private int errosRestantes;

	public Jogo7Erros(List<String> palavras) {
		super(palavras);
		this.embaralhador = new FabricaEmbaralhadores().getEmbaralhador();
	}

	@Override
	public void iniciarJogo() {
		pontuacao = 0;
		errosRestantes = 7;
		proximaRodada();
	}

	@Override
	public void jogar(String chute) {
		acertou = palavra.equals(chute);
		if (acertou)
			pontuacao++;
		else
			errosRestantes--;
		proximaRodada();

	}

	@Override
	public String getInstrucoesDaMecanica() {
		return "O jogo vai começar!\n" + "Você pode tentar acertar as palavras até atingir 7 erros.\n"
				+ "Vamos ver quantas palavras você acerta!";
	}

	@Override
	public boolean terminou() {
		return errosRestantes == 0;
	}

	@Override
	public String getFeedbackDoChute() {
		String retorno = super.getFeedbackDoChute();

		if (errosRestantes > 0)
			retorno += "Você ainda pode errar " + errosRestantes + " vez" + (errosRestantes == 1 ? "" : "es") + ".\n"
					+ "Você está com " + pontuacao + " ponto" + (pontuacao == 1 ? "" : "s") + ".\n"
					+ "Vamos para a próxima palavra!";

		return retorno;
	}

}
