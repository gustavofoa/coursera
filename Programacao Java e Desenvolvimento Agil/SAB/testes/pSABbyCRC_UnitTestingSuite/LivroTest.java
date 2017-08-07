package pSABbyCRC_UnitTestingSuite;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LivroTest {
	@Before
	public void SetUp() {
		livro = new Livro("Java Design Patterns", "Pankaj Kumar");
	}

	@Test
	public void whenSituaçãoInicialEntaoLivroDisponivelParaEmprestimo() {
		// T1: Testa condições de início!
		// Assumo que Biblioteca não deixa criar livro com
		// titulo e/ou autor com nomes vazios ou nulos!
		assertEquals(null, livro.getUsuario());
		assertEquals("Java Design Patterns", livro.getTitulo());
		assertEquals("Pankaj Kumar", livro.getAutor());
	}

	@Test
	public void whenAnexaUsuarioNaoNuloAoLivroEntaoLivroFicaIndisponivelParaEmprestimo() {
		// T2: Anexa usuario não nulo
		Usuario usuario1 = new Usuario("José");
		livro.anexaUsuarioAoLivro(usuario1);
		assertEquals(usuario1, livro.getUsuario());
	}

	@Test
	public void whenAnexaUsuarioNuloAoLivroEntaoLivroFicaDisponivelParaEmprestimo() {
		// T3: Anexa usuario nulo
		Usuario usuario1 = null;
		livro.anexaUsuarioAoLivro(usuario1);
		assertEquals(usuario1, livro.getUsuario());
	}

	@Test
	public void whenDesanexaUsuarioNaoNuloDoLivroEntaoLivroFicaDisponivelParaEmprestimo() {
		// T4: Desanexa usuario não nulo
		Usuario usuario1 = new Usuario("José");
		livro.anexaUsuarioAoLivro(usuario1);
		livro.desanexaUsuarioDoLivro();
		assertEquals(null, livro.getUsuario());
	}

	@Test
	public void whenDesanexaUsuarioNuloDoLivroEntaoLivroContinuaDisponivelParaEmprestimo() {
		// T5: Desanexa usuario nulo
		Usuario usuario1 = null;
		livro.anexaUsuarioAoLivro(usuario1);
		livro.desanexaUsuarioDoLivro();
		assertEquals(null, livro.getUsuario());
	}

	private Livro livro;
}