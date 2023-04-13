package assignment6.person.controller;

import java.io.IOException;
import java.sql.Date;
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
 * Servlet implementation class PersonInfoController
 */
@WebServlet("/PersonInfoController")
public class PersonInfoController extends HttpServlet {
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
	public PersonInfoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {

			List<Person> listPerson = new ArrayList<Person>();
			// person = new Person();
			listPerson = personDao.viewPersons();
			request.setAttribute("personData", listPerson);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/personInfo.jsp");
			dispatcher.forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (request.getParameter("addNewPersonButton") != null) {
			// open new agents details page

			doGetNewPerson(request, response);
		}

		else if (request.getParameter("registerNewPerson") != null) {
			// open new agents details page

			doPostNewPersonDetails(request, response);
			doGet(request, response);
		}
		if (request.getParameter("updateDetails") != null && request.getParameter("personIdUpdate") != null) {

			// openupdateperson page with person id details

			String personIdUpdate = request.getParameter("personIdUpdate");
			System.out.println(" " + personIdUpdate);
			updatePersonDetails(request, response, personIdUpdate);
		}

//		Enumeration<String> parameterNames = request.getParameterNames();
//		// any click paramneternames will be [PersonId, update]
//
//		while (parameterNames.hasMoreElements()) {

		Map<String, String[]> parameterMap = request.getParameterMap();

//			for (String paramName : parameterMap.keySet()) {
//				//parameterMap.keySet() i =0 .equals PersonId
//				parameterMap.get("PersonId");
//
//			}
		List keys = new ArrayList(parameterMap.keySet());
		String key1 = (String) keys.get(0);
	
		String rowIndex = null;
		for (int i = 0; i < keys.size(); i++) {
			String[] rowIndexArray = parameterMap.get(keys.get(i));
			rowIndex = rowIndexArray[0];
			// Object obj = keys.get(i);
		}
		if (key1.equals("PersonId")) {
			System.out.println("person id");
			deletePersonDetails(request, response, rowIndex);

		}
		
		//update is also, don, need to print page after update, and check date filed how to populate date in input filed html
		if (request.getParameter("updateAndSave") != null) {
			updateAndSaveDetails(request,response);
			doGet(request, response);
			
		}

	}

	private void updateAndSaveDetails(HttpServletRequest request, HttpServletResponse response) {
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

			personDao.updatePerson(person);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void deletePersonDetails(HttpServletRequest request, HttpServletResponse response, String paramValue) {
		// TODO Auto-generated method stub

		try {

			int personId = Integer.parseInt(paramValue);
			personDao.deletePerson(personId);
			doGet(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void doPostNewPersonDetails(HttpServletRequest request, HttpServletResponse response) {
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

	}

	private void updatePersonDetails(HttpServletRequest request, HttpServletResponse response, String paramValue) {

		// TODO Auto-generated method stub

		List<Person> updatePerson = new ArrayList<Person>();

		int personId = Integer.parseInt(paramValue);

		try {

			updatePerson = personDao.editPersonRow(personId);

			request.setAttribute("updatePersonData", updatePerson);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/updatePerson.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void doGetNewPerson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/registerPerson.html");
		dispatcher.forward(request, response);

	}

}
