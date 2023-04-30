package models;

import factory.Encrypt;

public class Usuario {
	private int id;
	private String password;
	private String usuario;
	
	
	public Usuario(String usuario, String password) {

		this.usuario = usuario;
		this.password = Encrypt.cryptWithMD5(password);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	@Override
	public String toString() {
		return String.format("Id: %d, Usuario: %s", id, usuario);
	}
	

}
