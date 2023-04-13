package assignment6.person.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoMain {

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CSI_real_estate_database?useSSL=false&serverTimezone=UTC", "root", "MyDatabase2023$");
		return connection;
	}
}
