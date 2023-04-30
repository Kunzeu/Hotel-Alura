package hotel_alura;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import factory.Encrypt;
import models.Reserva;

public class mainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		java.util.Date date = new java.util.Date();
		ReservaDAO reservaDAO = new ReservaDAO(new ConnectionFactory().recuperarConexion());
		
		//reservaDAO.guardar(new Reserva(new Date(date.getTime()), new Date(date.getTime()), 1234, "TARJETA DE CREDITO"));
		
		System.out.println(Encrypt.cryptWithMD5("root"));
		System.out.println(date.getTime());
		Date fechaActual = new Date();
		System.out.println(fechaActual);
		
	}

}
