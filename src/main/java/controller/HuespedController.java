package controller;

import java.util.List;

import dao.HuespedDAO;
import factory.ConnectionFactory;
import models.Huesped;

public class HuespedController {
	private HuespedDAO huespedDAO;
	
	public HuespedController() { this.huespedDAO = new HuespedDAO(new ConnectionFactory().recuperarConexion()); }
	
	public void guardar(Huesped huesped) { this.huespedDAO.guardar(huesped); }
	
	public List<Huesped> listar(){ return this.huespedDAO.listar(); }
	
	public List<Huesped> listar(String apellido) { return this.huespedDAO.listar(apellido); }

	public String actualizar(Huesped huesped) { return this.huespedDAO.actualizar(huesped); }
	
	public String eliminar(Integer id) { return this.huespedDAO.eliminar(id); }

}
