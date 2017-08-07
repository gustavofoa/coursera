import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void inserir(Usuario u) {

		executeUpdate("INSERT INTO usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?);", 
				u.getLogin(), u.getEmail(), u.getNome(), u.getSenha(), u.getPontos());

	}

	@Override
	public Usuario recuperar(String login) {
		
		List<Usuario> usuarios = executeQuery("SELECT * FROM usuario WHERE login = ?;", login);
		
		if(usuarios.size() > 0)
			return usuarios.get(0);

		return null;

	}

	@Override
	public void adicionarPontos(String login, int pontos) {

		executeUpdate("UPDATE usuario SET pontos = pontos + ? WHERE login = ?;", pontos, login);

	}

	@Override
	public List<Usuario> ranking() {
		
		return executeQuery("SELECT * FROM usuario ORDER BY pontos DESC;");

	}

	private List<Usuario> executeQuery(String sql, Object... params) {
		List<Usuario> usuarios = new ArrayList<>();
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/usuario?user=usuario&password=usuario")){
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			for(int i=0; i<params.length; i++)
				preparedStatement.setObject(i+1, params[i]);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Usuario usuario = new Usuario();
				usuario.setLogin(resultSet.getString("login"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setSenha(resultSet.getString("senha"));
				usuario.setPontos(resultSet.getInt("pontos"));
				usuarios.add(usuario);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return usuarios;
	}

	private void executeUpdate(String sql, Object... params) {
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/usuario?user=usuario&password=usuario")){
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			for(int i=0; i<params.length; i++)
				preparedStatement.setObject(i+1, params[i]);
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
