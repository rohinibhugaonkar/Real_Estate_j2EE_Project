package assignment6.person.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assignment6.person.model.Person;

public class PersonDao {

	

	Connection connection;
	
    public int addPerson(Person person) throws ClassNotFoundException {
        String add_person_sql = "INSERT INTO person" +
            "  ( PersonName, SSN, driversLicenseNr, BirthDate, BirthPlace) VALUES " +
            " ( ?, ?, ?, ?,?);";
        
        int result = 0;
        

       

     try {			 
    	 	connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(add_person_sql);
        			
            preparedStatement.setString(1, person.getPersonName());
            preparedStatement.setInt(2, person.getSsn());
            preparedStatement.setString(3, person.getDriversLicenseNr());
            preparedStatement.setDate(4, person.getBirthDate());
            preparedStatement.setString(5,person.getBirthPlace());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

            
        } 
        		 
        		 catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
    
    public int deletePerson(int personID) throws ClassNotFoundException {
        String delete_agents_sql = "DELETE FROM agents WHERE PersonId = ?";
        //String delete_owner_sql = "DELETE FROM owners WHERE PersonId = ?";
        //String delete_nowowns_sql = "DELETE FROM nowowns WHERE PersonId = ?"; 
       // String delete_worksfor_sql = "DELETE FROM worksfor WHERE agent = ?";       
        String delete_person_sql ="DELETE FROM person WHERE PersonId= ?";
        

        int result = 0;
        

       

     try {			 
    	 	connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement  = connection.prepareStatement(delete_agents_sql);
            preparedStatement.setInt(1, personID);
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            
            
            
            //delete parent row
            preparedStatement = connection.prepareStatement(delete_person_sql);
            preparedStatement.setInt(1, personID);
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            
        } 
        		 
        		 catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    
    public List<Person> editPersonRow(int id) throws ClassNotFoundException {
		
		 
		List<Person> listPerson = new ArrayList<Person>();
		
		Connection connection = null;
		
		ResultSet rs = null;
		
	   String viewPersons = "SELECT * FROM PERSON WHERE PersonId = ?";
	        

	     try {			 
	    	 	connection = getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(viewPersons);

	            preparedStatement.setInt(1, id);
	            
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            rs = preparedStatement.executeQuery();
	         
	            
	            while (rs.next()) {
	            	
	            	Person	person = new Person();
	            	
	            	person.setPersonId(rs.getInt("PersonId"));
	      
	            	person.setPersonName(rs.getString("PersonName"));
	            	
	            	person.setSsn(rs.getInt("SSN"));
	            	
	            	person.setDriversLicenseNr(rs.getString("driversLicenseNr"));
	            	
	            	person.setBirthDate(rs.getDate("BirthDate"));
	            	
	            	person.setBirthPlace(rs.getString("BirthPlace"));
	            	
	            	listPerson.add(person);
	                     
	            }

	        } 
	        		 
	        		 catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }finally {
	        	try {
	        		if(connection != null) {
	        			connection.close();
	        		}
	        	}catch (SQLException e) {
					// TODO: handle exception
	        		e.printStackTrace();
				}
	        }
	        
    	return listPerson;
    }
	public List<Person> viewPersons() throws ClassNotFoundException {
		
		 
		List<Person> listPerson = new ArrayList<Person>();
		
		Connection connection = null;
		
		ResultSet rs = null;
		
	   String viewPersons = "SELECT * FROM PERSON";
	        

	     try {			 
	    	 	connection = getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(viewPersons);

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            rs = preparedStatement.executeQuery();
	         
	            
	            while (rs.next()) {
	            	
	            	Person	person = new Person();
	            	
	            	person.setPersonId(rs.getInt("PersonId"));
	      
	            	person.setPersonName(rs.getString("PersonName"));
	            	
	            	person.setSsn(rs.getInt("SSN"));
	            	
	            	person.setDriversLicenseNr(rs.getString("driversLicenseNr"));
	            	
	            	person.setBirthDate(rs.getDate("BirthDate"));
	            	
	            	person.setBirthPlace(rs.getString("BirthPlace"));
	            	
	            	listPerson.add(person);
	                     
	            }

	        } 
	        		 
	        		 catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }finally {
	        	try {
	        		if(connection != null) {
	        			connection.close();
	        		}
	        	}catch (SQLException e) {
					// TODO: handle exception
	        		e.printStackTrace();
				}
	        }
	        
    	return listPerson;
    }

	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
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
    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CSI_real_estate_database?useSSL=false&serverTimezone=UTC", "root", "MyDatabase2023$");
		return connection;
	}

	public int updatePerson(Person person2) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		 String update_person_sql = "UPDATE person SET " +
		            "PersonName = ?, "
		            + "SSN = ?, "
		            + "driversLicenseNr = ?, "
		            + "BirthDate = ?, "
		            + "BirthPlace = ? " +
		            "WHERE SSN = ?;";
		        
		        int result = 0;
		        

		       

		     try {			 
		    	 	connection = getConnection();
		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(update_person_sql);
		        			
		            preparedStatement.setString(1, person2.getPersonName());
		            preparedStatement.setInt(2, person2.getSsn());
		            preparedStatement.setString(3, person2.getDriversLicenseNr());
		            preparedStatement.setDate(4, person2.getBirthDate());
		            preparedStatement.setString(5,person2.getBirthPlace());
		            preparedStatement.setInt(6, person2.getSsn());

		            System.out.println(preparedStatement);
		            
		            // Step 3: Execute the query or update query
		            result = preparedStatement.executeUpdate();

		            
		        } 
		        		 
		        		 catch (SQLException e) {
		            // process sql exception
		            printSQLException(e);
		        }
		        return result;

		
	}


}
