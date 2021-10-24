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
 * Servlet implementation class GetHours
 */
@WebServlet("/GetHours")
public class GetHours extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetHours() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String res = "";

		if (request.getParameter("id") == null) {
			String id = String.format("%d",
					UtilDB.getEmployeeEmail(session.getAttribute("username").toString()).get(0).getId());
			List<MyEmployeeAlharrasi> employees = UtilDB.getEmployeeHours(id);

			for (int i = 0; i < employees.size(); i++) {
				res += employees.get(i).getHOUR() + "<br>";
			}
		} else {
			List<MyEmployeeAlharrasi> employees = UtilDB.getEmployeeHours(request.getParameter("id"));

			for (int i = 0; i < employees.size(); i++) {
				res += employees.get(i).getHOUR() + "<br>";
			}
		}

		out.append(res);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
