package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	public static Connection getConnection() {

		String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root&password=root";
		Connection conn;
		
		try {
			conn = DriverManager.getConnection(jdbcURL);			
			
		}catch(SQLException e){
			System.out.println("Errore connessione al db");
			throw new RuntimeException(e);
		}
		return conn;
		
	}

}
