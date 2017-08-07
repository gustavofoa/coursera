import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestePessoa {

	@BeforeClass
	public static void configuraRelogio() {
		Relogio.tempoFixo = 1461168436857L;
	}

	@Test
	public void testePessoa1() {
		Calendar cal = new GregorianCalendar();

		Pessoa pessoa = new Pessoa();
		cal.set(1989, 9, 26);
		pessoa.setDataDeNascimento(cal.getTime());

		assertEquals("Libra", pessoa.getSigno());
		assertEquals(26, pessoa.getIdade());
	}

	@Test
	public void testePessoa2() {
		Calendar cal = new GregorianCalendar();

		Pessoa pessoa = new Pessoa();
		cal.set(1988, 2, 21);
		pessoa.setDataDeNascimento(cal.getTime());

		assertEquals("Peixes", pessoa.getSigno());
		assertEquals(28, pessoa.getIdade());
	}

	@Test
	public void testePessoa3() {
		Calendar cal = new GregorianCalendar();

		Pessoa pessoa = new Pessoa();
		cal.set(1983, 11, 14);
		pessoa.setDataDeNascimento(cal.getTime());

		assertEquals("Escorpião", pessoa.getSigno());
		assertEquals(32, pessoa.getIdade());
	}
}
