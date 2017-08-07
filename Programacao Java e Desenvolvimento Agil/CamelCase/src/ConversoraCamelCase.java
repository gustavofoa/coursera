import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConversoraCamelCase {

	/**
	 * Método de acesso à API para conversão de texto em CamelCase para palavras e números
	 * Corpo com 7 linhas
	 * */
	public static List<String> converterCamelCase(String string) {
		if (!isValido(string)) {
			List<String> lista = new ArrayList<String>();
			lista.add("inválido");
			return lista;
		}
		List<String> lista = comSigla(dividePalavras(string));
		return lista;
	}

	/**
	 * Método responsável por dividir uma string em um array de chars
	 * Corpo com 1 linha
	 * */
	public static char[] quebraTextoEmArrayListChar(String texto) {
		return texto.toCharArray();
	}


	/**
	 * Método responsável por dividir uana string em palavras separadas
	 * Corpo com 10 linhas
	 * */
	public static List<String> dividePalavras(String texto) {
		List<String> lista = new ArrayList<String>();
		char[] letras = quebraTextoEmArrayListChar(texto);
		String palavra = "";
		for (int i = 0; i < letras.length; i++) {
			Object[] ob = estruturaDivisao(lista, letras[i], palavra);
			lista=(List<String>) ob[0];
			palavra = (String) ob[1];
		}
		if (!palavra.equals("")) lista.add(palavra);
		return lista;
	}
	
	/**
	 * Método resultante de refatoração do método dividePalavras que auxilia na estruturação da divisão das palavras da String
	 * Corpo com 9 linhas
	 * */
	public static Object[] estruturaDivisao(List<String> lista,char letra,String palavra){
		if (isNumber("" + letra)) {
			Object[] ob = estruturaDivisaoIsNumber(lista, letra, palavra);
			palavra = (String) ob[1];
			lista = (List<String>) ob[0];
		} else if (isMaiuscula(letra)) {
			if (!palavra.equals(""))lista.add(palavra);
			palavra = ("" + letra).toLowerCase();
		} else	palavra += letra;
		return new Object[]{lista,palavra};	
	}
	
	/**
	 * Método resultante da refatoração de do método estruturaDivisao responsável por auxiliar na identificação e separação dos números
	 * Corpo com 7 linhas
	 * */
	public static Object[] estruturaDivisaoIsNumber(List<String> lista,char letra,String palavra){
		if (isNumber(palavra))	palavra += letra;
		else if (!palavra.equals("")) {
			lista.add(palavra);
			palavra = "" + letra;
		}
		if (palavra.equals(""))	palavra = ("" + letra);	
		return new Object[]{lista,palavra};	
	}
	
	/**
	 * Método que verifica se uma determinada letra é maiúscula ou minúscula
	 * Corpo com 6 linhas
	 * */
	public static boolean isMaiuscula(char letra) {
		String letraString = "";
		letraString += letra;
		String letraMinusculaString = "";
		letraMinusculaString += letra;
		letraMinusculaString = letraMinusculaString.toLowerCase();
		return !letraString.equals(letraMinusculaString);
	}

	
	/**
	 * Método responsável por tratar strings com Sigla na composição
	 * Corpo com 9 linhas
	 * */
	public static List<String> comSigla(List<String> lista) {
		List<String> listaComSiglas = new ArrayList<String>();
		String sigla = "";
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).length() == 1) {
				if (i + 1 < lista.size() && lista.get(i + 1).length() == 1) sigla += lista.get(i);
				else {	sigla += lista.get(i);
						listaComSiglas.add(sigla.toUpperCase());}
			} else { listaComSiglas.add(lista.get(i));}
		}	return listaComSiglas;
	}

	/**
	 * Método que verifica se alguma string é um número
	 * Corpo com 7 linhas
	 * */
	public static boolean isNumber(String string) {
		int numero = 0;
		try {
			numero = Integer.parseInt(string);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Método que verifica se uma String é válida conforme as regras fornecidas
	 * Corpo com 6 linhas
	 * */
	public static boolean isValido(String string) {
		char[] caracteres = quebraTextoEmArrayListChar(string);
		if (isNumber("" + caracteres[0]))
			return false;
		if (hasSpecialCaracteres(string))
			return false;
		return true;
	}

	/**
	 * Método que verifica se uma String possui algum caractere especial
	 * Corpo com 3 linhas
	 * */
	public static boolean hasSpecialCaracteres(String string) {
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(string);
		return m.find();
	}

}