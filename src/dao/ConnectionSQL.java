package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {

	public static String status = "Não conectou...";

	public ConnectionSQL() {

	}

	public static Connection getConnection() {

		Connection connection = null;

		try {

			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			String serverName = "localhost";
			String mydatabase = "TaxeFacile";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String username = "root";
			String password = "";
			connection = DriverManager.getConnection(url, username, password);

			if (connection != null) {

				status = ("STATUS--->Conectado com sucesso!");
			} else {

				status = ("STATUS--->Não foi possivel realizar conexão");
			}

			return connection;

		} catch (ClassNotFoundException e) {

			System.out.println("O driver especificado nao foi encontrado." + e);
			return null;
		} catch (SQLException e) {

			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			System.out.println(e);
			return null;
		}
	}

	public static String statusConection() {

		return status;
	}

	public static boolean closeConnection() {

		try {
			
			ConnectionSQL.getConnection().close();
			return true;
		} catch (SQLException e) {
			
			return false;
		}
	}

	public static Connection restartConnection() {
		
		closeConnection();
		return ConnectionSQL.getConnection();
	}
}