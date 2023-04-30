package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Usuario;

public class UsuarioDAO {
	private final Connection connection;
	private String sql_select = "SELECT USUARIO, PASSWORD FROM USUARIOS WHERE (USUARIO=?) AND (PASSWORD=?)";
	
	public UsuarioDAO(Connection connection) { this.connection = connection; }
	private boolean isLogin = false;
	
	public boolean iniciarSesion(Usuario usuario) {
		try{
			var statement = connection.prepareStatement(sql_select);
			statement.setString(1, usuario.getUsuario());
			statement.setString(2, usuario.getPassword());
			
			final ResultSet resultSet = statement.executeQuery();
			try(resultSet){
				while(resultSet.next()) {
					String usuarioBD = resultSet.getString("USUARIO");
					String passwordBD = resultSet.getString("PASSWORD");
					if(usuarioBD.equals(usuario.getUsuario()) && passwordBD.equals(usuario.getPassword())) {
						System.out.println("Usuario encontrado: "+ usuarioBD + "\n"+passwordBD);
						isLogin = true;
					}
				}
			}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return isLogin;
	}

}
