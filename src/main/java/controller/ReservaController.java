package controller;

import java.util.List;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import models.Reserva;

public class ReservaController {
	private ReservaDAO reservaDAO;
	
	public ReservaController() {
		this.reservaDAO = new ReservaDAO(new ConnectionFactory().recuperarConexion());
	}
	
	public Reserva guardar(Reserva reserva) {
		return this.reservaDAO.guardar(reserva);
	}
	
	public List<Reserva> listar(){ return this.reservaDAO.listar(); }
	
	public List<Reserva> listar(Integer id){ return this.reservaDAO.listar(id); }
	
	public String actualizar(Reserva reserva) { return this.reservaDAO.actualizar(reserva);}
	
	public String eliminr(Integer id) { return this.reservaDAO.eliminar(id); }

}
