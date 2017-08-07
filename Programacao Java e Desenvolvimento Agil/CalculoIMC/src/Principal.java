public class Principal {

	public static void main(String[] args) {

		int a = 10;
		double b = raizOuZero(a, a / 2);

		System.out.println(b);

	}

	private static double raizOuZero(int numero, double metade) {

		System.out.println(metade);
			
		if (metade == 0 || metade == 1)
			return 1;

		double quadrado = metade * metade;

		if (quadrado == numero)
			return (int) metade;

		if (quadrado - numero > 0.1)
			return raizOuZero(numero, metade / 2);
		else if(numero - quadrado > 0.1)
			return raizOuZero(numero, (metade / 2) + metade);
		
		return (int)metade;

	}

}
