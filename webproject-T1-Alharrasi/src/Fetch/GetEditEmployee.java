package Fetch;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			response.sendRedirect("index.html");
		}

		if (session.getAttribute("hr") == null && session.getAttribute("username") != null) {
			response.sendRedirect("layout.jsp");
		}
		
		List<MyEmployeeAlharrasi> employee = UtilDB.getEmployee(request.getParameter("id"));
		String res = "<div>\r\n";
		
		
		
		res += String.format("<form class=\"form-horizontal\" action=\"EditEmployee\" method=\"post\">" +
										"<div class=\"form-group\">\r\n" + 
				"						<label for=\"Fname\">First Name : </label> <input type=\"text\" class=\"form-control\" name=\"FIRST_NAME\" value=\"%s\"> <br>\r\n" + 
				"						<label for=\"Lname\">Last Name : </label> <input type=\"text\" class=\"form-control\" name=\"LAST_NAME\" value=\"%s\"> <br>\r\n" + 
				"						<label for=\"JobRole\">Job Role : </label> <input type=\"text\" class=\"form-control\" name=\"POSITION\" value=\"%s\"> <br>\r\n" + 
				"						<label for=\"Age\">Age : </label> <input type=\"text\" class=\"form-control\" name=\"AGE\" value=\"%s\"> <br>\r\n" + 
				"						<label for=\"Date\">Start date : </label> <input type=\"date\" class=\"form-control\"name=\"DATE\" value=\"%s\"> <br>\r\n" + 
				"						<label for=\"Phone\">Phone : </label> <input type=\"text\" class=\"form-control\" name=\"PHONE\" value=\"%s\"> <br>\r\n" + 
				"						<label for=\"email\">Email : </label> <input type=\"email\" class=\"form-control\" name=\"EMAIL\" value=\"%s\"> <br>\r\n" + 
				"						<label for=\"salary\">Salary : </label> <input type=\"text\" class=\"form-control\" name=\"SALARY\" value=\"%s\"> <br>\r\n" + 
				"<input type=\"hidden\" name=\"id\" value=\"%s\" />" +
				"						\r\n" + 
				"						<button type=\"submit\">Edit Employee</button>\r\n" + 
				"					</div>"
				+ "</form>",
				employee.get(0).getFIRST_NAME(),
				employee.get(0).getLAST_NAME(),
				employee.get(0).getPOSITION(),
				employee.get(0).getAGE(),
				employee.get(0).getDATE(),
				employee.get(0).getPHONE(), 
				employee.get(0).getEMAIL(),
				employee.get(0).getSALARY(),
				employee.get(0).getId());
		
		
		res += "</div>";
		
		response.getWriter().append(res);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
