package assignment6.person.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assignment6.person.model.Agent;

public class AgentDao {

	Connection connection;

	public int addAgentDetails(Agent agent) throws ClassNotFoundException {

		String getPersonDetails = "SELECT PersonId  \n" + "		FROM PERSON  \n" + "		ORDER BY PersonId DESC  \n"
				+ "		LIMIT 1";

		 agent.setPersonId(getPersonDetails(getPersonDetails));
		 
		 int newPersonId = agent.getPersonId() +1;

		System.out.printf("person id : ", agent.getPersonId());

		// we dont have primary kley PersonId in both the tables person and Agent hence
		// first check if license numberperson has already present in person table,
		// if not get the last personId from person table adn increement wit 1, insert
		// that record in agent table.

		String add_person_for_agent_sql = " INSERT INTO PERSON " + "(PersonId, PersonName) VALUES " + "(?,?);" ;
		
		String add_agent_sql = "INSERT INTO agents" + "  ( LicenseNum, PersonId) VALUES " + " ( ?,?);";

		int result = 0;

		try {
			connection = getConnection();
			// Step 2:Create a statement using connection object
			
			PreparedStatement preparedStatement = connection.prepareStatement(add_person_for_agent_sql);
			preparedStatement.setInt(1, newPersonId);
			preparedStatement.setString(2, " ");
			result = preparedStatement.executeUpdate();
			

			preparedStatement = connection.prepareStatement(add_agent_sql);

			preparedStatement.setInt(1, agent.getLicenseNum());
			preparedStatement.setInt(2, newPersonId);

			System.out.println("Agent insert: " + preparedStatement);

			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		}

		catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return result;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/CSI_real_estate_database?useSSL=false&serverTimezone=UTC", "root",
				"MyDatabase2023$");
		return connection;
	}

	public int getPersonDetails(String getPersonDetails) throws ClassNotFoundException {

		Connection connection = null;

		ResultSet rs = null;

		Agent agent = new Agent();

		try {
			connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(getPersonDetails);

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				agent.setPersonId(rs.getInt("PersonId"));

			}
		}

		catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return agent.getPersonId();
	}
}
