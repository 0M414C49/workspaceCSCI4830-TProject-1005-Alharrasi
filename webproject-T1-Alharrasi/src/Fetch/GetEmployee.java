package Fetch;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class GetEmployee
 */
@WebServlet("/GetEmployee")
public class GetEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployee() {
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
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		List<MyEmployeeAlharrasi> employees = UtilDB.listEmployees();
		String res = "{\r\n" + 
				"\"draw\": 1,\r\n" + 
				"  \"recordsTotal\": 1,\r\n" + 
				"  \"recordsFiltered\": 1," +
				"  \"data\": [\r\n";
		for(int i = 0; i < employees.size(); i++)
		{
			
			if (!(employees.get(i).getEMAIL() == null))
			{
				String btn = String.format("<a id=\\\"my-button\\\" class=\\\"btn btn-danger btn-rounded btn-sm my-0\\\" onclick=\\\"removeEmployee(%d)\\\"> Remove </a> <a class=\\\"btn btn-warning btn-rounded btn-sm my-0\\\" data-toggle=\\\"modal\\\" data-target=\\\"#myModal\\\" onclick=\\\"editEmployee(%d)\\\"> Edit </a>"
						+ " <a class=\\\"btn btn-warning btn-rounded btn-sm my-0\\\" data-toggle=\\\"modal\\\" data-target=\\\"#myModal\\\" onclick=\\\"getHRHours(%d)\\\"> Hours </a>",
						employees.get(i).getId(),
						employees.get(i).getId(),
						employees.get(i).getId());
				
				
				if (!session.getAttribute("username").equals(employees.get(i).getEMAIL()))
				{
					res += String.format(
							"    [\r\n" + 
									"      \"%s %s\",\r\n" + 
									"      \"%s\",\r\n" + 
									"      \"%s\",\r\n" + 
									"      \"%s\",\r\n" + 
									"      \"%s\",\r\n" + 
									"      \"%s\",\r\n" + 
									"      \"%s\",\r\n" + 
									"      \"%s\"\r\n" + 
									"    ]",
							employees.get(i).getFIRST_NAME(),
							employees.get(i).getLAST_NAME(),
							employees.get(i).getPOSITION(),
							employees.get(i).getPHONE(),
							employees.get(i).getEMAIL(),
							employees.get(i).getAGE(),
							employees.get(i).getDATE(),
							employees.get(i).getSALARY(),
							btn
							);
				}
				else if (session.getAttribute("username").equals(employees.get(i).getEMAIL()))
				{
					String btn2 = String.format(" <a class=\\\"btn btn-warning btn-rounded btn-sm my-0\\\" data-toggle=\\\"modal\\\" data-target=\\\"#myModal\\\" onclick=\\\"getHRHours(%d)\\\"> Hours </a>", employees.get(i).getId());
					res += String.format(
							"    [\r\n" + 
									"      \"%s %s\",\r\n" + 
									"      \"%s\",\r\n" + 
									"      \"%s\",\r\n" + 
									"      \"%s\",\r\n" + 
									"      \"%s\",\r\n" + 
									"      \"%s\",\r\n" + 
									"      \"%s\",\r\n" + 
									"      \"%s\"\r\n" + 
									"    ]",
							employees.get(i).getFIRST_NAME(),
							employees.get(i).getLAST_NAME(),
							employees.get(i).getPOSITION(),
							employees.get(i).getPHONE(),
							employees.get(i).getEMAIL(),
							employees.get(i).getAGE(),
							employees.get(i).getDATE(),
							employees.get(i).getSALARY(),
							btn2
							);
				}
				
				
				
				res += " , ";

			}
			
			
		}
		res = res.substring(0, res.length() - 2);
		res += "]}";
		
		out.append(res);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
