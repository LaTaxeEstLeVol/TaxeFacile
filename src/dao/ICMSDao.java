package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import icms.ICMS;

public class ICMSDao {

	private static Connection connectionSQL;

	public ICMSDao() {

		connectionSQL = ConnectionSQL.getConnection();
	}

	public static Connection getConnection() {

		return connectionSQL;
	}

	public static void setConnection(Connection connection) {

		ICMSDao.connectionSQL = connection;
	}

	/*
	 * Os scripts de inserção estão no arquivo database.sql
	 * o método de baixo funciona já, mas ta mais como um exemplo
	 * por que ainda não foi feito o ICMS
	 */
	
	public boolean getAliquotOrigin(ICMS icms) {
				
		boolean valid = true;
		String queryOrigin = "SELECT * FROM ICMS WHERE stateOrigin = '" + icms.getStateOrigin() + "'" 
						+ " AND stateDestiny = '" + icms.getStateDestiny() + "'";
		
		try {
			
			connectionSQL = ConnectionSQL.getConnection();
			Statement statement = connectionSQL.createStatement();
			
			ResultSet resultSet = statement.executeQuery(queryOrigin);
			
			if (resultSet.next()) {
								
				icms.setAliquot(resultSet.getDouble("aliquot"));
				valid = true;
			} else {
				
				icms.setAliquot(0.12);
				valid = true;
			}
						
			statement.close();
			connectionSQL.close();
		} catch (Exception e) {
			System.out.println("Erro misterioso");
			valid = false;
		}
		return valid;
	}
	
	public boolean getAliquotDestiny(ICMS icms) {
		
		boolean valid = true;
		
		String queryDestiny = "SELECT * FROM ICMS WHERE stateOrigin = '" + icms.getStateDestiny() + "'" 
				+ " AND stateDestiny = '" + icms.getStateOrigin() + "'";
		
		try {
			
			connectionSQL = ConnectionSQL.getConnection();
			Statement statement = connectionSQL.createStatement();
			
			ResultSet resultSet = statement.executeQuery(queryDestiny);
			
			if (resultSet.next()) {
								
				icms.setAliquot(resultSet.getDouble("aliquot"));
				valid = true;
			} else {
				
				icms.setAliquot(0.12);
				valid = true;
			}
						
			statement.close();
			connectionSQL.close();
		} catch (Exception e) {
			System.out.println("Erro misterioso");
			valid = false;
		}
		return valid;
	}
}