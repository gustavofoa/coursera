public class Respeitoso implements FormatadorNome {

	private char sexo;

	public Respeitoso(char sexo) {
		if (sexo == 'M' || sexo == 'F' || sexo == 'm' || sexo == 'f')
			this.sexo = sexo;
	}

	public String formatarNome(String nome, String sobrenome) {

		if (sexo == 'M' || sexo == 'm')
			return "Sr. " + sobrenome;
		else if (sexo == 'F' || sexo == 'f')
			return "Sra. " + sobrenome;

		return "";
	}

}
