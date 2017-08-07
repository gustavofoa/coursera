import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedrasPreciosas {

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		scan.nextLine();

		String[] pedras = new String[n];

		for (int i = 0; i < n; i++)
			pedras[i] = scan.nextLine();
		
		scan.close();

		System.out.println(identificaPedrasPreciosas(pedras));

	}

	private static int identificaPedrasPreciosas(String[] pedras) {

		char[] componentes = "abcdefghijklmnopqrstuvwxyz".toCharArray();

		List<Character> pedrasPreciosas = new ArrayList<Character>();

		comp: for (char c : componentes) {
			for (String pedra : pedras)
				if (!pedra.contains(new String(new char[] { c })))
					continue comp;
			pedrasPreciosas.add(c);
		}

		return pedrasPreciosas.size();

	}

}
