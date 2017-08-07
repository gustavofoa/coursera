import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

public class MockArmazenamentoRegistrarPontos extends Armazenamento {

	public MockArmazenamentoRegistrarPontos() {
		super(new File("."));
	}

	private boolean armazenouPontos;
	private int pontosArmazenados;
	private String tipoArmazenado;
	private String usuarioArmazenado;

	//Verificações
	
	public void verificaSeArmazenouPontos(int pontosEsperados, String tipoEsperado, String usuarioEsperado) {
		assertTrue(armazenouPontos);
		assertEquals(pontosEsperados, pontosArmazenados);
		assertEquals(tipoEsperado, tipoArmazenado);
		assertEquals(usuarioEsperado, usuarioArmazenado);
	}

	//implementações

	@Override
	public void armazenarPontos(String usuario, String tipo, int pontos){
		armazenouPontos = true;
		usuarioArmazenado = usuario;
		tipoArmazenado = tipo;
		pontosArmazenados = pontos;
	}
	
}
