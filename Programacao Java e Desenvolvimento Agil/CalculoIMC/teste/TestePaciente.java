import static org.junit.Assert.*;

import org.junit.Test;


public class TestePaciente {

	@Test
	public void testeBaixoPesoMuitoGrave() {
		Paciente paciente = new Paciente(50, 1.80);
		
		assertTrue(paciente.calcularIMC() < 16);		
		assertEquals("Baixo peso muito grave", paciente.diagnostico());
	}
	
	@Test
	public void testeBaixoPesoGrave() {
		Paciente paciente = new Paciente(50, 1.75);
		
		assertTrue(paciente.calcularIMC() >= 16);
		assertTrue(paciente.calcularIMC() < 17);
		assertEquals("Baixo peso grave", paciente.diagnostico());
	}
	
	@Test
	public void testeBaixoPeso() {
		Paciente paciente = new Paciente(62, 1.88);
		
		assertTrue(paciente.calcularIMC() >= 17);
		assertTrue(paciente.calcularIMC() < 18.5);
		assertEquals("Baixo peso", paciente.diagnostico());
	}
	
	@Test
	public void testePesoNormal() {
		Paciente paciente = new Paciente(70.3, 1.82);
		
		assertTrue(paciente.calcularIMC() >= 18.5);
		assertTrue(paciente.calcularIMC() < 25);
		assertEquals("Peso normal", paciente.diagnostico());
	}
	
	@Test
	public void testeSobrepeso() {
		Paciente paciente = new Paciente(75.8, 1.65);
		
		assertTrue(paciente.calcularIMC() >= 25);
		assertTrue(paciente.calcularIMC() < 30);
		assertEquals("Sobrepeso", paciente.diagnostico());
	}
	
	@Test
	public void testeObesidadeGrauI() {
		Paciente paciente = new Paciente(92, 1.70);
		
		assertTrue(paciente.calcularIMC() >= 30);
		assertTrue(paciente.calcularIMC() < 35);
		assertEquals("Obesidade grau I", paciente.diagnostico());
	}
	
	@Test
	public void testeObesidadeGrauII() {
		Paciente paciente = new Paciente(107, 1.71);
		
		assertTrue(paciente.calcularIMC() >= 35);
		assertTrue(paciente.calcularIMC() < 40);
		assertEquals("Obesidade grau II", paciente.diagnostico());
	}
	
	@Test
	public void testeObesidadeGrauIII() {
		Paciente paciente = new Paciente(145, 1.75);
		
		assertTrue(paciente.calcularIMC() >= 40);
		assertEquals("Obesidade grau III (obesidade mórbida)", paciente.diagnostico());
	}

}
