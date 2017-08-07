
public class Paciente {

	double peso;
	double altura;
	
	
	Paciente(double peso, double altura){
		this.peso = peso;
		this.altura = altura;
	}
	
	double calcularIMC(){
		return peso / (altura * altura);
	}
	
	String diagnostico(){
		double imc = calcularIMC();
		
		if (imc < 16)
			return "Baixo peso muito grave";
		else if(imc < 17)
			return "Baixo peso grave";
		else if(imc < 18.5)
			return "Baixo peso";
		else if(imc < 25)
			return "Peso normal";
		else if(imc < 30)
			return "Sobrepeso";
		else if(imc < 35)
			return "Obesidade grau I";
		else if(imc < 40)
			return "Obesidade grau II";
		else
			return "Obesidade grau III (obesidade mórbida)";
		
	}
	
}
