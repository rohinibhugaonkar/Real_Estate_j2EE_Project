package assignment6.person.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment6.person.dao.PersonDao;
import assignment6.person.model.Person;

/**
 * Servlet implementation class PersonContrtollerView
 */
@WebServlet("/PersonControllerView")
public class PersonControllerView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PersonDao personDao;
	
	private Person person;
	
	   ArrayList<String> datalist = new ArrayList<String>();

	 public void init() {
		 personDao = new PersonDao();
	    }
	 
	 public void initi() {
		 person = new Person();
	 }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonControllerView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			List<Person> listPerson = new ArrayList<Person>();
			// person = new Person();
			listPerson = personDao.viewPersons();
			request.setAttribute("personData", listPerson);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/viewPerson.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
