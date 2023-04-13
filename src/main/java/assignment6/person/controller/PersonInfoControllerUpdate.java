package assignment6.person.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment6.person.dao.PersonDao;
import assignment6.person.model.Person;

/**
 * Servlet implementation class PersonInfoControllerUpdate
 */
@WebServlet("/PersonInfoControllerUpdate")
public class PersonInfoControllerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonDao personDao;

	private Person person;

	ArrayList<String> datalist = new ArrayList<String>();

	public void init() {
		personDao = new PersonDao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonInfoControllerUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		updatePersonDetails(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("update");
		System.out.println(username);
		doGet(request, response);
	}
	
	private void updatePersonDetails(HttpServletRequest request, HttpServletResponse response) {

		// TODO Auto-generated method stub

		List<Person> updatePerson = new ArrayList<Person>();
		 //person = new Person();
		// String[] id = request.getParameterValues("update");
			//System.out.println("id: " + id.toString());
			
		String personId = request.getParameter("person_id");


		 int id = Integer.parseInt(request.getParameter("PersonId"));
			System.out.println("id: " + personId);
			
		try {
			//if (request.getParameter("update") != null) {

				
			/*
			 * Person person = new Person(); person.setPersonId(id);
			 * System.out.println("id: " + id); }
			 */
			updatePerson = personDao.editPersonRow(1);

			request.setAttribute("updatePersonData", updatePerson);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/updatePerson.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
