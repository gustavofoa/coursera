import java.sql.SQLException;
import java.util.List;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteUsuarioDAO {
	
	private JdbcDatabaseTester jdt;
	private UsuarioDAO usuarioDAO;
	
	@Before
	public void database() throws Exception {
		jdt = new JdbcDatabaseTester("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/usuario?user=usuario&password=usuario");
		
		DataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet dataSet = loader.load("/dbunit.xml");
		jdt.setDataSet(dataSet);
		jdt.onSetup();
		
		usuarioDAO = new UsuarioDAOImpl();
		
	}

	@Test
	public void testeInserir() throws SQLException, Exception{
		
		Usuario usuario = new Usuario();
		usuario.setLogin("julia");
		usuario.setNome("Julia");
		usuario.setEmail("julia@gmail.com");
		usuario.setSenha("julia1");
		usuario.setPontos(10);
		
		usuarioDAO.inserir(usuario);

		ITable currentTable = jdt.getConnection().createDataSet().getTable("usuario");
		
		Assert.assertEquals(4, currentTable.getRowCount());
		
		ITable currentRowJulia = jdt.getConnection().createQueryTable("registroJulia", "select * from usuario where login = 'julia'");

		Assert.assertEquals("Julia", currentRowJulia.getValue(0, "nome"));
		Assert.assertEquals("julia@gmail.com", currentRowJulia.getValue(0, "email"));
		Assert.assertEquals("julia1", currentRowJulia.getValue(0, "senha"));
		Assert.assertEquals(new Integer(10), currentRowJulia.getValue(0, "pontos"));
		
	}

	@Test
	public void testeRecuperar(){
		
		Usuario usuario = usuarioDAO.recuperar("wellington");
		
		Assert.assertEquals("Wellington", usuario.getNome());
		Assert.assertEquals("wellington1", usuario.getSenha());
		Assert.assertEquals(new Integer(3), usuario.getPontos());
		
	}

	@Test
	public void testeAdicionarPontos() throws DataSetException, SQLException, Exception{
		
		usuarioDAO.adicionarPontos("daiana", 10);

		ITable currentRowDaiana = jdt.getConnection().createQueryTable("registroDaiana", "select * from usuario where login = 'daiana'");
		
		Integer pontosAtuais = (Integer) currentRowDaiana.getValue(0, "pontos");
		
		Assert.assertEquals(new Integer(16), pontosAtuais);
		
	}


	@Test
	public void testeRanking(){
		
		List<Usuario> ranking = usuarioDAO.ranking();
		
		Assert.assertEquals(3, ranking.size());
		Assert.assertEquals("daiana", ranking.get(0).getLogin());
		Assert.assertEquals("wellington", ranking.get(1).getLogin());
		Assert.assertEquals("gustavo", ranking.get(2).getLogin());
		
	}

}
