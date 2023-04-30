package factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	private static final String URL = "jdbc:mysql://localhost/";

    private static final String BD = "hotel_alura";
    private static final String PARAMETERS = "?useTimeZone=true&serverTimeZone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Fajardo24";

	private DataSource dataSource;
	
	public ConnectionFactory(){
        var pooledDataSource = new ComboPooledDataSource();
        pooledDataSource.setJdbcUrl(URL+BD+PARAMETERS);
        pooledDataSource.setUser(USER);
        pooledDataSource.setPassword(PASSWORD);
        pooledDataSource.setMaxPoolSize(10);

        this.dataSource = pooledDataSource;
    }
	
	public Connection recuperarConexion()  {
        try{
            return this.dataSource.getConnection();
        }catch (Exception ex){
            System.out.println("Error Ocurrido: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
	
	public static <T> Integer addNewStatement(PreparedStatement statement, T object) throws SQLException {
		
		var estado = statement.executeUpdate();
		if( estado > 0) {
			ResultSet generatedKeys = statement.getGeneratedKeys();
	        if (generatedKeys.next()) {
	            int id = generatedKeys.getInt(1);
	            System.out.println("ID generado: " + id);
				System.out.println("Guardado con Exito: " + object.toString());
	           return id;
	        }

			return -1;
		}
		else {
			System.out.println("No se ha guardado: " + object.toString());
		}
		return null;
	}

}
