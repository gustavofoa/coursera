import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestesCaixaEletronico {
	
	private MockHardware mockHardware;
	private MockServicoRemoto mockServicoRemoto;
	private CaixaEletronico caixaEletronico;
	
	@Before
	public void criaMocks(){
		mockHardware = new MockHardware();
		mockServicoRemoto = new MockServicoRemoto();
		caixaEletronico = new CaixaEletronico(mockHardware, mockServicoRemoto);
	}

	@After
	public void verificaPersistenciaDaConta(){
		//Se o m�todo mockServicoRemoto.devePersistirAContaCorrente() n�o for chamado,
		//Esta verifica��o garante que a conta n�o foi persistida
		mockServicoRemoto.verificaSePersistiuOuNaoAConta();
	}
	
	@Test
	public void logarComSucesso() throws FalhaDeHardwareException {
		String mensagem = caixaEletronico.logar();
		
		assertEquals("Usu�rio Autenticado", mensagem);
		mockHardware.verificaObtencaoDeNumeroDoCartao();
		mockServicoRemoto.verificaNumeroRecebido(mockHardware.pegarNumeroDaContaCartao());
	}

	@Test
	public void falhaAoObterNumeroDaConta() {
		mockHardware.lancarExcecaoAoObterNumeroDaConta();
		
		String mensagem = caixaEletronico.logar();
		
		assertEquals("N�o foi poss�vel autenticar o usu�rio", mensagem);
	}

	@Test
	public void contaInexistente() {
		mockServicoRemoto.retornarContaNula();
		
		String mensagem = caixaEletronico.logar();
		
		assertEquals("N�o foi poss�vel autenticar o usu�rio", mensagem);
	}

	@Test
	public void naoObterSaldoSemLogin(){
		String mensagem = caixaEletronico.saldo();
		assertEquals("Usu�rio N�O Autenticado", mensagem);
	}

	@Test
	public void obterSaldo1000ComSucesso(){
		mockServicoRemoto.saldoInicial(1000);
		
		caixaEletronico.logar();
		
		String mensagem = caixaEletronico.saldo();
		assertEquals("O saldo � R$1000,00", mensagem); 
	}

	@Test
	public void obterSaldo2000ComSucesso(){
		mockServicoRemoto.saldoInicial(2000);
		
		caixaEletronico.logar();
		
		String mensagem = caixaEletronico.saldo();
		assertEquals("O saldo � R$2000,00", mensagem); 
	}
	
	@Test
	public void naoSacarSemLogin(){
		String mensagem = caixaEletronico.sacar(10);
		assertEquals("Usu�rio N�O Autenticado", mensagem);
	}

	@Test
	public void sacarComSucesso(){
		mockServicoRemoto.saldoInicial(1000);
		
		caixaEletronico.logar();
		
		String mensagem = caixaEletronico.sacar(100);
		
		assertEquals("Retire seu dinheiro", mensagem);
		
		mensagem = caixaEletronico.saldo();
		assertEquals("O saldo � R$900,00", mensagem); 
		
		mockHardware.deveEntregarDinheiro();
		
		mockServicoRemoto.devePersistirAContaCorrente();
	}

	@Test
	public void sacarTudoComSucesso(){
		mockServicoRemoto.saldoInicial(1000);
		
		caixaEletronico.logar();
		
		String mensagem = caixaEletronico.sacar(1000);
		
		assertEquals("Retire seu dinheiro", mensagem);
		
		mensagem = caixaEletronico.saldo();
		assertEquals("O saldo � R$0,00", mensagem); 
		
		mockHardware.deveEntregarDinheiro();
		
		mockServicoRemoto.devePersistirAContaCorrente();
	}

	@Test
	public void naoSacarSeSaldoInsuficiente(){
		mockServicoRemoto.saldoInicial(1000);
		
		caixaEletronico.logar();
		
		String mensagem = caixaEletronico.sacar(1001);
		
		assertEquals("Saldo insuficiente", mensagem);
		
		mensagem = caixaEletronico.saldo();
		assertEquals("O saldo � R$1000,00", mensagem);

		mockHardware.naoDeveEntregarDinheiro();		
	}

	@Test
	public void naoPersistirSaqueSeAcontecerFalhaAoEntregarDinheiro(){
		mockServicoRemoto.saldoInicial(1000);
		mockHardware.lancarExcecaoAoEntregarDinheiro();
		
		caixaEletronico.logar();
		
		String mensagem = caixaEletronico.sacar(10);
		
		assertEquals("Falha ao entregar o dinheiro, sua conta N�O foi debitada", mensagem);
		
		mensagem = caixaEletronico.saldo();
		assertEquals("O saldo � R$1000,00", mensagem);
	}

	@Test
	public void naoDepositarSemLogin(){
		String mensagem = caixaEletronico.depositar(10);
		assertEquals("Usu�rio N�O Autenticado", mensagem);
	}

	@Test
	public void depositarComSucesso(){
		mockServicoRemoto.saldoInicial(1000);
		
		caixaEletronico.logar();
		
		String mensagem = caixaEletronico.depositar(100);
		
		assertEquals("Dep�sito recebido com sucesso", mensagem);
		
		mensagem = caixaEletronico.saldo();
		assertEquals("O saldo � R$1100,00", mensagem); 
		
		mockHardware.deveReceberEnvelope();
		
		mockServicoRemoto.devePersistirAContaCorrente();
	}

	@Test
	public void naoPersistirDepositoSeAcontecerFalhaAoLerEnvelope(){
		mockServicoRemoto.saldoInicial(1000);
		mockHardware.lancarExcecaoAoLerEnvelope();
		
		caixaEletronico.logar();
		
		String mensagem = caixaEletronico.depositar(10);
		
		assertEquals("Falha ao ler o envelope de dinheiro", mensagem);
		
		mensagem = caixaEletronico.saldo();
		assertEquals("O saldo � R$1000,00", mensagem);
	}

}
