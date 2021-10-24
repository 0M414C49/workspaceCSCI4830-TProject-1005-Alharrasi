package Authentication;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datamodel.MyEmployeeAlharrasi;
import util.UtilDB;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		
		try {
			  
			List<MyEmployeeAlharrasi> employee = UtilDB.getEmployeeEmail(username);
			if (username.equals(employee.get(0).getEMAIL()) && password.equals(employee.get(0).getPASSWORD()) &&
					!employee.get(0).getPOSITION().equals("HR"))
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("hr", null);
				request.setAttribute("user", employee.get(0).getFIRST_NAME() + " " + employee.get(0).getLAST_NAME());
				RequestDispatcher rd = request.getRequestDispatcher("layout.jsp");
				rd.forward(request, response);
			}
			else if (username.equals(employee.get(0).getEMAIL()) && password.equals(employee.get(0).getPASSWORD()))
			{
				String hr = "HR";
				HttpSession session = request.getSession();
				session.setAttribute("hr", hr);
				session.setAttribute("username", username);
				request.setAttribute("user", employee.get(0).getFIRST_NAME() + " " + employee.get(0).getLAST_NAME());
				RequestDispatcher rd = request.getRequestDispatcher("HRlayout.jsp");
				rd.forward(request, response);
			}
			else if (username.equals(""))
			{
				String wronginput = "<div class=\"alert alert-warning\">\r\n" + 
						"  <strong>Warning!</strong> Please Enter Username!.\r\n" + 
						"</div>";
				request.setAttribute("wronginput", wronginput);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				
			}
			else if (password.equals(""))
			{
				String wronginput = "<div class=\"alert alert-warning\">\r\n" + 
						"  <strong>Warning!</strong> Please Enter Password!.\r\n" + 
						"</div>";
				request.setAttribute("wronginput", wronginput);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				
			}
			else
			{
				String wronginput = "<div class=\"alert alert-warning\">\r\n" + 
						"  <strong>Warning!</strong> You entered wrong credetionals!.\r\n" + 
						"</div>";
				request.setAttribute("wronginput", wronginput);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			}
			catch(Exception e) {
				String wronginput = "<div class=\"alert alert-warning\">\r\n" + 
						"  <strong>Warning!</strong> You entered wrong credetionals!.\r\n" + 
						"</div>";
				request.setAttribute("wronginput", wronginput);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		
		
	}

}
