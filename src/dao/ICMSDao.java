package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fgts.FGTS;

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
	
	/*public List<FGTS> listICMS() {

		List<FGTS> list = new ArrayList<FGTS>();

		try {
			connectionSQL = ConnectionSQL.getConnection();
			Statement statement = connectionSQL.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ICMS");

			while (resultSet.next()) {

				FGTS fgts = new FGTS();
				
				fgts.setId(resultSet.getInt("idICMS"));
				fgts.setState(resultSet.getString("state"));
				fgts.setAliquot(resultSet.getDouble("aliquot"));

				list.add(fgts);
			}
			statement.close();
			connectionSQL.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}*/
}
