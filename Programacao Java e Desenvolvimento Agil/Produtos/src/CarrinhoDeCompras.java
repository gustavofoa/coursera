import java.util.HashMap;
import java.util.Map;

public class CarrinhoDeCompras {

	private Map<Produto, Integer> mapa;

	public CarrinhoDeCompras() {
		mapa = new HashMap<Produto, Integer>();
	}

	public void adicionaProduto(Produto produto, Integer quantidade) {
		int quant = mapa.getOrDefault(produto, 0);
		quant += quantidade;
		mapa.put(produto, quant);
	}

	public void removerProduto(Produto produto, Integer quantidade) {
		int quant = mapa.getOrDefault(produto, 0);
		quant -= quantidade;
		if (quant < 0)
			quant = 0;
		mapa.put(produto, quant);
	}

	public double getValorTotal() {
		double total = 0;

		for (Produto produto : mapa.keySet())
			total += produto.getPreco() * mapa.get(produto);

		return total;
	}
}
