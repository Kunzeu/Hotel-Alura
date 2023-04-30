package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import models.Reserva;

public class ReservaDAO {
	/*
	 * DATOS TABLA RESERVA:
	 * FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO
	 * 
	 * */
	private Connection connection;
	private final String TABLE="RESERVAS";
	private final String SQL_INSERT = "INSERT INTO " + TABLE + " (FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO) VALUES(?,?,?,?)";
	private final String SQL_SELECT_ALL = "SELECT ID, FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO FROM " + TABLE;
	private final String SQL_SELECT_ONE = "SELECT * FROM " + TABLE + " WHERE ID=?;";
	private final String SQL_UPDATE_ONE = "UPDATE " + TABLE + " SET FECHA_ENTRADA=?, FECHA_SALIDA=?, VALOR=?, FORMA_PAGO=? WHERE ID=?";
	private final String SQL_DELETE_ONE = "DELETE FROM " + TABLE + " WHERE ID=?";	
	
	private List<Reserva> reservas = new ArrayList<>();
	
	public ReservaDAO(Connection connection)
	{
		this.connection = connection;
	}
	
	
	public Reserva guardar(Reserva reserva) {
		try {
			final PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			try(statement){
				statement.setDate(1, reserva.getFECHA_ENTRADA());
				statement.setDate(2, reserva.getFECHA_SALIDA());
				statement.setLong(3, reserva.getValor());
				statement.setString(4, reserva.getForma_Pago());
				reserva.setId(ConnectionFactory.addNewStatement(statement, reserva));
				return reserva;
			}
		}catch(Exception ex) {
			System.out.println("Error al guardar la reserva: " + ex.getMessage());
		}
		return null;
	}
	
	public List<Reserva> listar(){
		try {
			reservas = new ArrayList<>();
			final PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
			try(statement){
				final ResultSet resultSet = statement.executeQuery();
				try(resultSet){
					while(resultSet.next()) {
						Integer ID = resultSet.getInt(1);
						Date FECHA_ENTRADA = resultSet.getDate(2);
						Date FECHA_SALIDA = resultSet.getDate(3);
						if(FECHA_ENTRADA != null && FECHA_SALIDA != null) {
							Integer VALOR = resultSet.getInt(4);
							String FORMA_PAGO = resultSet.getString(5);
							
							Reserva reserva = new Reserva(ID, FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO);
							reservas.add(reserva);
						}
					}
					return reservas;
				}
			}
		}catch(Exception ex) {
			System.out.println("Error al lista en reservas: " + ex.getMessage());

			return null;
		}
		
	}


	public List<Reserva> listar(Integer id){
		
		try {
			reservas = new ArrayList<>();
			final PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ONE);
			try(statement){
				statement.setInt(1, id);
				final ResultSet resultSet = statement.executeQuery();
				try(resultSet){
					while(resultSet.next()) {
						Reserva reserva = new Reserva(
								resultSet.getInt("ID"),
								resultSet.getDate("FECHA_ENTRADA"),
								resultSet.getDate("FECHA_SALIDA"),
								resultSet.getInt("VALOR"),
								resultSet.getString("FORMA_PAGO")
								);
						reservas.add(reserva);
					}
				}
				return reservas;
			}
		}catch(Exception ex) {
			System.out.println("Error al obtener una reserva: " + ex.getMessage());
		}
		return null;
	}
	
	public String actualizar(Reserva reserva) {
		try {
			final PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_ONE);
			statement.setDate(1, reserva.getFECHA_ENTRADA());
			statement.setDate(2, reserva.getFECHA_SALIDA());
			statement.setLong(3, reserva.getValor());
			statement.setString(4, reserva.getForma_Pago());
			statement.setInt(5, reserva.getId());
			try(statement){
				final Integer modificados = statement.executeUpdate();
				if(modificados > 0) {
					System.out.println("Reserva modificada: " + reserva);
					return "La reserva ha sido modificada con exito";
				}
			}
		}catch(Exception ex) {
			System.out.println("Un error al actualizar los datos de reserva: " + ex.getMessage());
		}
		
		return "No se ha podido actualizar la reserva";
	}

	public String eliminar(Integer id) {
	    try {
	        final PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ONE);
	        statement.setInt(1, id);
	        int rowsAffected = statement.executeUpdate();
	        if (rowsAffected == 1) {
	            return "Reserva eliminada correctamente";
	        } else {
	            return "No se encontró ninguna reserva con el ID proporcionado: " + id;
	        }
	    } catch (SQLException ex) {
	        String message = "Error al eliminar la reserva: " + ex.getMessage();
	        System.out.println(message);
	        return message;
	    }
	}
}
