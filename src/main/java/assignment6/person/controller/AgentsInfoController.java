package assignment6.person.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment6.person.dao.AgentDao;
import assignment6.person.model.Agent;
import assignment6.person.model.Person;

/**
 * Servlet implementation class AgentsInfo
 */
@WebServlet("/AgentsInfoController")
public class AgentsInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AgentDao agentDao;

	private Person person;

	ArrayList<String> datalist = new ArrayList<String>();

	public void init() {
		agentDao = new AgentDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgentsInfoController() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/agentsInfo.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("addNewAgentButton") != null) {
			// open new agents details page

			doGetNewAgents(request, response);

		}
		
		if(request.getParameter("registerNewAgent") != null) {
			doGetSubmitNewAgentDetailsSuccess(request, response);
		}
	}

	private void doGetNewAgents(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/registerNewAgent.html");
		dispatcher.forward(request, response);
	}
	
	private void doGetSubmitNewAgentDetailsSuccess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int LicenseNum = Integer.parseInt(request.getParameter("LicenseNum"));
		
       
       System.out.printf("license no ", LicenseNum);
       

        Agent agent = new Agent();
       
        agent.setLicenseNum(LicenseNum);
       

        try {
                
        	agentDao.addAgentDetails(agent);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/agentSuccess.jsp");
		dispatcher.forward(request, response);
	}

}
