package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

			valid = false;
		}
		return valid;
	}

	public List<ICMS> getListStates() {

		List<ICMS> listIcms = new ArrayList<ICMS>();

		try {
			
			connectionSQL = ConnectionSQL.getConnection();
			Statement statement = connectionSQL.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ICMS GROUP BY stateOrigin");

			System.out.println(resultSet.next());
			int i =0;
			
			do  {

				ICMS icms = new ICMS();

				icms.setStateOrigin(resultSet.getString("stateOrigin"));
				
				System.out.println(resultSet.next()+" "+ i);
				i++;
				listIcms.add(icms);
			} while (resultSet.next());
			resultSet.close();
			statement.close();
			connectionSQL.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return listIcms;
	}
}