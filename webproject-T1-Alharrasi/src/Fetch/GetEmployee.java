package Fetch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		List<MyEmployeeAlharrasi> employees = UtilDB.listEmployees();
		
		for(int i = 0; i < employees.size(); i++)
		{
			
//			String res = String.format("<tr><td>%s %s</td>\r\n" + 
//					"							<td>%s</td>\r\n" + 
//					"							<td>%s</td>\r\n" +
//					"							<td>%s</td>\r\n" + 
//					"							<td>%d</td>\r\n" + 
//					"							<td>%s</td>\r\n" + 
//					"							<td>%s</td>\r\n" + 
//					"							<td><span class=\"table-remove\"><button\r\n" + 
//					"										type=\"button\" class=\"btn btn-danger btn-rounded btn-sm my-0\">\r\n" + 
//					"										Remove</button></span> <span class=\"table-remove\"><button\r\n" + 
//					"										type=\"button\" class=\"btn btn-warning btn-rounded btn-sm my-0\">\r\n" + 
//					"										Edit</button></span></td></tr>",
//					employees.get(i).getFIRST_NAME(),
//					employees.get(i).getLAST_NAME(),
//					employees.get(i).getPOSITION(),
//					employees.get(i).getPHONE(),
//					employees.get(i).getEMAIL(),
//					employees.get(i).getAGE(),
//					employees.get(i).getDATE(),
//					employees.get(i).getSALARY());
//			
//			out.append(res);
			
			
		}
		
		String res = "{\r\n" + 
				"\"draw\": 1,\r\n" + 
				"  \"recordsTotal\": 1,\r\n" + 
				"  \"recordsFiltered\": 1," +
				"  \"data\": [\r\n" + 
				"    [\r\n" + 
				"      \"Tiger Nixon\",\r\n" + 
				"      \"System Architect\",\r\n" + 
				"      \"Edinburgh\",\r\n" + 
				"      \"5421\",\r\n" + 
				"      \"2011/04/25\",\r\n" + 
				"      \"$320,800\",\r\n" + 
				"      \"$320,800\",\r\n" + 
				"      \"$320,800\"\r\n" + 
				"    ]]}";
		
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
