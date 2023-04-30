package controller;

import dao.UsuarioDAO;
import factory.ConnectionFactory;
import models.Usuario;

public class UsuarioController {
	private UsuarioDAO usuarioDAO;
	
	public UsuarioController()
	{
		this.usuarioDAO = new UsuarioDAO(new ConnectionFactory().recuperarConexion());
	}
	
	public boolean IniciarSesion(Usuario usuario) {
		return usuarioDAO.iniciarSesion(usuario);
	}
	

}
