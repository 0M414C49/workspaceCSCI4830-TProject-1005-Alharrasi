package actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.UtilDB;

/**
 * Servlet implementation class ChangePass
 */
@WebServlet("/ChangePass")
public class ChangePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePass() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String confirm = request.getParameter("confirm");
		String password = request.getParameter("pass");
		
		if (password.equals(confirm))
		{
			HttpSession session = request.getSession();
			UtilDB.changePassword(session.getAttribute("username").toString(), password);
			String fIRST_NAME = UtilDB.getEmployeeEmail(session.getAttribute("username").toString()).get(0).getFIRST_NAME();
			String lAST_NAME = UtilDB.getEmployeeEmail(session.getAttribute("username").toString()).get(0).getLAST_NAME();
			String wronginput = "<div class=\"alert alert-success\">\r\n" + 
					"  <strong>Success!</strong> Password was changed.\r\n" + 
					"</div>";
			request.setAttribute("wronginput", wronginput);
			request.setAttribute("user", fIRST_NAME + " " + lAST_NAME);
			
			if (session.getAttribute("hr") == null && session.getAttribute("username") != null) {
				RequestDispatcher rd = request.getRequestDispatcher("layout.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("HRlayout.jsp");
				rd.forward(request, response);
			}
			
			
		}
		else
		{
			HttpSession session = request.getSession();
			String fIRST_NAME = UtilDB.getEmployeeEmail(session.getAttribute("username").toString()).get(0).getFIRST_NAME();
			String lAST_NAME = UtilDB.getEmployeeEmail(session.getAttribute("username").toString()).get(0).getLAST_NAME();
			String wronginput = "<div class=\"alert alert-warning\">\r\n" + 
					"  <strong>Warning!</strong> Passwords does not matches.\r\n" + 
					"</div>";
			request.setAttribute("wronginput", wronginput);
			request.setAttribute("user", fIRST_NAME + " " + lAST_NAME);
			
			if (session.getAttribute("hr") == null && session.getAttribute("username") != null) {
				RequestDispatcher rd = request.getRequestDispatcher("layout.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("HRlayout.jsp");
				rd.forward(request, response);
			}
		}
		
	}

}
