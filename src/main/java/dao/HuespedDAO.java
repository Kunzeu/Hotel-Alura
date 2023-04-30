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
import models.Huesped;

/*
 * DATOS TABLA:
 * 	
 * id, nombre, apellido, FECHA_NACIMIENTO, nacionalidad, telefono, ID_RESERVA. 
 * 
 * */
public class HuespedDAO {
	
	private Connection connection;
	private final String TABLE = "HUESPEDES";
	private final String SQL_INSERT = "INSERT INTO "
			+ TABLE +" (nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva) "
			+ "VALUES(?,?,?,?,?,?)";
	private final String SQL_SELECT_ALL = "SELECT * FROM " + TABLE;
	private final String SQL_SELECT_ONE = "SELECT * FROM " + TABLE +" WHERE APELLIDO=?";
	private final String SQL_UPDATE_ONE = "UPDATE "+ TABLE +" SET NOMBRE=?, APELLIDO=?, FECHA_NACIMIENTO=?, NACIONALIDAD=?, TELEFONO=? WHERE ID=?";
	private final String SQL_DELETE_ONE = "DELETE FROM " + TABLE + " WHERE ID=?";
	
	private List<Huesped> huespedes = new ArrayList<>();
	
	public HuespedDAO(Connection connection) { this.connection = connection;}
	
	public void guardar(Huesped huesped) {
		try {
			final PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			
			try(statement){
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setDate(3, huesped.getFECHA_NACIMIENTO());
				statement.setString(4, huesped.getNacionalidad());
				statement.setInt(5, huesped.getTelefono());
				statement.setInt(6, huesped.getID_RESERVA());
				huesped.setId(ConnectionFactory.addNewStatement(statement, huesped));
				
			}
		}catch(SQLException ex) {
			System.out.println("Error al guardar Huesped: " + ex.getMessage());
		}
	}
	
	public List<Huesped> listar(){
		try {
			huespedes = new ArrayList<>();
			final PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
			try(statement){
				final ResultSet resultSet = statement.executeQuery();
				try(resultSet){
					while(resultSet.next()) {
						final Integer ID = resultSet.getInt(1);
						final String NOMBRE = resultSet.getString(2);
						final String APELLIDO = resultSet.getString(3);
						final Date FECHA_NACIMIENTO = resultSet.getDate(4);
						final String NACIONALIDAD = resultSet.getString(5);
						final Integer TELEFONO = resultSet.getInt(6);
						final Integer ID_RESERVA = resultSet.getInt(7);
						
						Huesped huesped = new Huesped(ID, NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA);
						huespedes.add(huesped);
					}
					return huespedes;
				}
			}
			
		}catch(Exception ex) {
			System.out.println("Error al listar todos los huespedes: " + ex.getMessage());
			return null;
		}
	}


	public List<Huesped> listar(String apellido) {
		try {
			huespedes = new ArrayList<>();
			final PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ONE);
			try(statement){
				statement.setString(1, apellido);
				final ResultSet resultSet = statement.executeQuery();
				try(resultSet){
					while(resultSet.next()) {
						Huesped huesped = new Huesped(
								resultSet.getInt("ID"),
								resultSet.getString("NOMBRE"), 
								resultSet.getString("APELLIDO"),
								resultSet.getDate("FECHA_NACIMIENTO"),
								resultSet.getString("NACIONALIDAD"),
								resultSet.getInt("TELEFONO"),resultSet.getInt("ID_RESERVA")
								);
						huespedes.add(huesped);
					}
					
				}
				return huespedes;
			}
		}catch(Exception ex) {
			System.out.println("Error al listar un huesped por id: " + ex.getMessage());
		}
		return null;
	}
	
	public String actualizar(Huesped huesped) {
		try {
			final PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_ONE);
			statement.setString(1, huesped.getNombre());
			statement.setString(2, huesped.getApellido());
			statement.setDate(3, huesped.getFECHA_NACIMIENTO());
			statement.setString(4, huesped.getNacionalidad());
			statement.setInt(5, huesped.getTelefono());
			statement.setInt(6, huesped.getId());
			
			try(statement){
				final Integer modified = statement.executeUpdate();
				if(modified > 0) {
					System.out.println("Datos del huesped modificados: " + huesped);
					return "Se han actualizado los datos del huesped";
				}
			}
			
		}catch(Exception ex) {
			System.out.println("Error al actualizar el huesped: " + ex.getMessage());
		}
		
		
		
		return "No se ha actualizado";
	}
	
	public String eliminar(Integer id) {
	    try {
	        final PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ONE);
	        statement.setInt(1, id);
	        int rowsAffected = statement.executeUpdate();
	        if (rowsAffected == 1) {
	            return "Huesped eliminado correctamente";
	        } else {
	            return "No se encontró ningun huesped con el ID proporcionado: " + id;
	        }
	    } catch (SQLException ex) {
	        String message = "Error al eliminar la reserva: " + ex.getMessage();
	        System.out.println(message);
	        return message;
	    }
	}
	
}
