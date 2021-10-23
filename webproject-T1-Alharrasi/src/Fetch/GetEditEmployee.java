package Fetch;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.MyEmployeeAlharrasi;
import util.UtilDB;

/**
 * Servlet implementation class GetEditEmployee
 */
@WebServlet("/GetEditEmployee")
public class GetEditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEditEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MyEmployeeAlharrasi> employee = UtilDB.getEmployee(request.getParameter("id"));
		
		String res = "<div class=\"form-group\">\r\n" + 
				"						<label for=\"Fname\">First Name : </label> <input type=\"text\" class=\"form-control\" name=\"FIRST_NAME\" value=\"%s\"> <br>\r\n" + 
				"						<label for=\"Lname\">Last Name : </label> <input type=\"text\" class=\"form-control\" name=\"LAST_NAME\" value=\"%s\"> <br>\r\n" + 
				"						<label for=\"JobRole\">Job Role : </label> <input type=\"text\" class=\"form-control\" name=\"POSITION\" value=\"%s\"> <br>\r\n" + 
				"						<label for=\"Age\">Age : </label> <input type=\"text\" class=\"form-control\" name=\"AGE\" value=\"%s\"> <br>\r\n" + 
				"						<label for=\"Date\">Start date : </label> <input type=\"date\" class=\"form-control\"name=\"DATE\" value=\"%s\"> <br>\r\n" + 
				"						<label for=\"Phone\">Phone : </label> <input type=\"text\" class=\"form-control\" name=\"PHONE\" value=\"%s\"> <br>\r\n" + 
				"						<label for=\"email\">Email : </label> <input type=\"email\" class=\"form-control\" name=\"EMAIL\" value=\"%s\"> <br>\r\n" + 
				"						<label for=\"salary\">Salary : </label> <input type=\"text\" class=\"form-control\" name=\"SALARY\" value=\"%s\"> <br>\r\n" + 
				"						\r\n" + 
				"						<button type=\"submit\">Add Employee</button>\r\n" + 
				"					</div>";
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
