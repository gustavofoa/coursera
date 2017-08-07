import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jogo.FabricaMecanicaDoJogo;
import jogo.MecanicaDoJogo;

public class Principal {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		lerPalavras(palavras);

		FabricaMecanicaDoJogo fabricaMecanicaDoJogo = new FabricaMecanicaDoJogo(palavras);

		String jogarNovamente = "N";

		do {
			MecanicaDoJogo mecanicaDoJogo = fabricaMecanicaDoJogo.getMecanicaDoJogo();

			mecanicaDoJogo.iniciarJogo();

			System.out.println(mecanicaDoJogo.getInstrucoesDaMecanica());

			do {

				String palavraEmbaralhada = mecanicaDoJogo.getPalavraEmbaralhada();

				System.out.println("Adivinhe a palavra a partir das seguintes letras: " + palavraEmbaralhada);

				System.out.print("Que palavra você acha que é: ");
				String chute = scanner.nextLine();

				mecanicaDoJogo.jogar(chute);

				System.out.println(mecanicaDoJogo.getFeedbackDoChute());

			} while (!mecanicaDoJogo.terminou());

			System.out.println("Fim de jogo!");
			System.out.println("Sua pontuação final é: " + mecanicaDoJogo.getPontuacao());

			System.out.print("Deseja jogar novamente (S/N)?  ");

			jogarNovamente = scanner.nextLine();

		} while (jogarNovamente.equalsIgnoreCase("S"));

		System.out.println("Jogo finalizado!");

	}

	private static void lerPalavras(List<String> palavras) {
		Scanner scPalavras = null;
		try {
			scPalavras = new Scanner(new FileInputStream("palavras.txt"));
			while (scPalavras.hasNext()) {
				String palavra = scPalavras.nextLine();
				if (!palavra.isEmpty())
					palavras.add(palavra);
			}
		} catch (FileNotFoundException e) {
			System.out.println("O arquivo com as palavras do jogo não foi encontrado.");
			return;
		} finally {
			if (scPalavras != null)
				scPalavras.close();
		}
	}

}
