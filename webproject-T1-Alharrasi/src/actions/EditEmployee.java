package actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditEmployee
 */
@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/**
		"<div class=\"form-group\">\r\n" + 
		"						<label for=\"Fname\">First Name : </label> <input type=\"text\" class=\"form-control\" name=\"FIRST_NAME\" value=\"\"> <br>\r\n" + 
		"						<label for=\"Lname\">Last Name : </label> <input type=\"text\" class=\"form-control\" name=\"LAST_NAME\"> <br>\r\n" + 
		"						<label for=\"JobRole\">Job Role : </label> <input type=\"text\" class=\"form-control\" name=\"POSITION\"> <br>\r\n" + 
		"						<label for=\"Age\">Age : </label> <input type=\"text\" class=\"form-control\" name=\"AGE\"> <br>\r\n" + 
		"						<label for=\"Date\">Start date : </label> <input type=\"date\" class=\"form-control\"name=\"DATE\"> <br>\r\n" + 
		"						<label for=\"Phone\">Phone : </label> <input type=\"text\" class=\"form-control\" name=\"PHONE\"> <br>\r\n" + 
		"						<label for=\"email\">Email : </label> <input type=\"email\" class=\"form-control\" name=\"EMAIL\"> <br>\r\n" + 
		"						<label for=\"pass\">Password : </label> <input type=\"text\" class=\"form-control\" name=\"PASSWORD\"> <br>\r\n" + 
		"						<label for=\"salary\">Salary : </label> <input type=\"text\" class=\"form-control\" name=\"SALARY\"> <br>\r\n" + 
		"						\r\n" + 
		"						<button type=\"submit\">Add Employee</button>\r\n" + 
		"					</div>"
		
		**/
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
