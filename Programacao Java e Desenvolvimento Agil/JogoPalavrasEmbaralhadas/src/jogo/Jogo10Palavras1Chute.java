package jogo;

import java.util.List;

import embaralhamento.FabricaEmbaralhadores;

public class Jogo10Palavras1Chute extends MecanicaDoJogo {

	private int palavrasRestantes;

	public Jogo10Palavras1Chute(List<String> palavras) {
		super(palavras);
		this.embaralhador = new FabricaEmbaralhadores().getEmbaralhador();
	}

	@Override
	public void iniciarJogo() {
		pontuacao = 0;
		palavrasRestantes = 10;
		proximaRodada();
	}

	@Override
	public void jogar(String chute) {
		acertou = palavra.equals(chute);
		if (acertou)
			pontuacao++;
		palavrasRestantes--;
		proximaRodada();
	}

	@Override
	public String getInstrucoesDaMecanica() {
		return "O jogo vai começar!\n" + "São 10 palavras e você só tem uma chance de acertar cada palavra!\n"
				+ "Vamos ver quantas palavras você acerta!";
	}

	@Override
	public boolean terminou() {
		return palavrasRestantes == 0;
	}

	@Override
	public String getFeedbackDoChute() {

		String retorno = super.getFeedbackDoChute();

		if (palavrasRestantes > 0)
			retorno += "Restam " + palavrasRestantes + " palavras.\n" + "Você está com " + pontuacao + " ponto"
					+ (pontuacao == 1 ? "" : "s") + ".\n" + "Vamos para a próxima palavra!";

		return retorno;

	}

}
