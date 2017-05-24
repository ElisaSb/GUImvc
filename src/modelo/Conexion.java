package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection conexion = null;
	
	private Conexion(){
		//creamos el objeto conexion (Connection)
		try {
			Class.forName("org.sqlite.JDBC");
			try {
				conexion = DriverManager.
						getConnection("jdbc:sqlite:BD/users.bd");
			} catch (SQLException e) {
				System.out.println("Error al acceso de la BD");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc no encotrador");
		}
	}
	
	public static Connection getInstance(){
		if (conexion == null)
			new Conexion();
		return conexion;
	}
	public static void main(String[] args) {
		Conexion.getInstance();
	}
}
