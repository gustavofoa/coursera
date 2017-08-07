package jogo;

import java.util.List;
import java.util.Random;

import embaralhamento.Embaralhador;

public abstract class MecanicaDoJogo {

	protected int pontuacao;
	protected List<String> palavras;
	protected String palavra;
	protected String palavraEmbaralhada;
	protected Embaralhador embaralhador;
	protected boolean acertou;

	MecanicaDoJogo(List<String> palavras) {
		this.palavras = palavras;
	}

	public String getPalavraEmbaralhada() {
		return palavraEmbaralhada;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	protected void proximaRodada() {
		palavra = obterNovaPalavra();
		palavraEmbaralhada = embaralhador.embaralhar(palavra);
	}

	protected String obterNovaPalavra() {
		int index = new Random().nextInt(palavras.size());
		return palavras.get(index);
	}

	public abstract void iniciarJogo();

	public abstract void jogar(String chute);

	public abstract String getInstrucoesDaMecanica();

	public abstract boolean terminou();

	public String getFeedbackDoChute() {
		String retorno;
		if (acertou)
			retorno = "Você acertou!\n";
		else
			retorno = "Você errou!\n";
		return retorno;
	}

}
