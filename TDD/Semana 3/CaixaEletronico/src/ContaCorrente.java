
public class ContaCorrente {
	
	private int saldo;

	public ContaCorrente(int saldoInicialDaContaCorrente) {
		saldo = saldoInicialDaContaCorrente;
	}

	public int getSaldo() {
		return saldo;
	}

	public void sacar(int valor) {
		saldo -= valor;
	}

	public void depositar(int valor) {
		saldo += valor;
	}

}
