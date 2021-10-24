package actions;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		String fIRST_NAME, lAST_NAME, id, pHONE, eMAIL, dATE, sALARY, pPOSITION;
		int aGE;
		
		fIRST_NAME = request.getParameter("FIRST_NAME");
		lAST_NAME = request.getParameter("LAST_NAME");
		id = request.getParameter("id");
		pHONE = request.getParameter("PHONE");
		eMAIL = request.getParameter("EMAIL");
		aGE = Integer.parseInt(request.getParameter("AGE"));
		dATE = request.getParameter("DATE");
		sALARY = request.getParameter("SALARY");
		pPOSITION = request.getParameter("POSITION");

		
		
		
		List<MyEmployeeAlharrasi> employee = UtilDB.getEmployee(id);
		List<MyEmployeeAlharrasi> employee2 = UtilDB.getEmployeeEmail(eMAIL);
		
		
		if (employee2.size() != 0 && !employee.get(0).getEMAIL().equals(eMAIL))
		{
			String wronginput = "<div class=\"alert alert-warning\">\r\n" + 
					"  <strong>Warning!</strong> Employee cannot be edited because " + eMAIL + " is already exists.\r\n" + 
					"</div>";
			request.setAttribute("wronginput", wronginput);
			RequestDispatcher rd = request.getRequestDispatcher("HRlayout.jsp");
			rd.forward(request, response);
		}
		else
		{
			UtilDB.editEmployee(id, fIRST_NAME, lAST_NAME, pHONE, eMAIL, aGE, dATE, sALARY, pPOSITION);
			
			String wronginput = "<div class=\"alert alert-success\">\r\n" + 
					"  <strong>Success!</strong> " + fIRST_NAME + " " + lAST_NAME + " was edited in the database.\r\n" + 
					"</div>";
			request.setAttribute("wronginput", wronginput);
			request.setAttribute("user", fIRST_NAME + " " + lAST_NAME);
			RequestDispatcher rd = request.getRequestDispatcher("HRlayout.jsp");
			rd.forward(request, response);
		}
		
		

		
	}

}
