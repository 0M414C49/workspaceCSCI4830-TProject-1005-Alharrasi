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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Servlet implementation class Attend
 */
@WebServlet("/Attend")
public class Attend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Attend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String hour = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		String id = String.format("%d", UtilDB.getEmployeeEmail(session.getAttribute("username").toString()).get(0).getId());
		String fIRST_NAME = UtilDB.getEmployeeEmail(session.getAttribute("username").toString()).get(0).getFIRST_NAME();
		String lAST_NAME = UtilDB.getEmployeeEmail(session.getAttribute("username").toString()).get(0).getLAST_NAME();
		
		UtilDB.addHour(id, hour);
		
		String wronginput = "<div class=\"alert alert-success\">\r\n" + 
				"  <strong>Success!</strong> Hour was punched.\r\n" + 
				"</div>";
		request.setAttribute("wronginput", wronginput);
		request.setAttribute("user", fIRST_NAME + " " + lAST_NAME);
		
		if (session.getAttribute("hr") == null && session.getAttribute("username") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("layout.jsp");
			rd.forward(request, response);
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
