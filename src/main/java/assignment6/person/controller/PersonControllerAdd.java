package assignment6.person.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment6.person.dao.PersonDao;
import assignment6.person.model.Person;



/**
 * Servlet implementation class PersonContrtoller
 */
@WebServlet("/PersonContrtollerAdd")
public class PersonControllerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonDao personDao;

	 public void init() {
		 personDao = new PersonDao();
	    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonControllerAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/personInfo.jsp");
		//dispatcher.forward(request, response);	
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
	
		
		String personName = request.getParameter("PersonName");
		int ssnNUmber = Integer.parseInt(request.getParameter("SSN"));
        String driversLicenseNumber = request.getParameter("driversLicenseNr");
        String birthDate = request.getParameter("BirthDate");
        String birthPlace = request.getParameter("BirthPlace");

        Person person = new Person();
        person.setPersonName(personName);
        person.setSsn(ssnNUmber);
        person.setDriversLicenseNr(driversLicenseNumber);
        person.setBirthDate(Date.valueOf(birthDate));
        person.setBirthPlace(birthPlace);

        try {
                
        	personDao.addPerson(person);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeedetails.jsp");
		dispatcher.forward(request, response);	
	
	}

}
