package gerenciador.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import gerenciador.gateways.ConnectionRepository;

public class ConnectionFactory implements ConnectionRepository {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3307/dev";
	
	static final String USER = "root";
	static final String PASS = "";
	Connection conn = null;
	
	public Connection connect() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
}