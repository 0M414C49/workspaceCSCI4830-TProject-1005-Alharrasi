package Authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		if (username.equals("admin") && password.equals("admin"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("hr", null);
			response.sendRedirect("layout.jsp");
		}
		else if (username.equals("a") && password.equals("a"))
		{
			String hr = "HR";
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("hr", hr);
			session.setAttribute("username", username);
			response.sendRedirect("HRlayout.jsp");
		}
		else if (username.equals(""))
		{
			String wronginput = "Please Enter Username!";
			request.setAttribute("wronginput", wronginput);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		}
		else if (password.equals(""))
		{
			String wronginput = "Please Enter Password!";
			request.setAttribute("wronginput", wronginput);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			String wronginput = "You entered wrong credetionals!";
			response.sendRedirect("login.jsp");
		}
	}

}
