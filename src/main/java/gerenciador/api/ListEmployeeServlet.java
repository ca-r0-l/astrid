package gerenciador.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import gerenciador.entity.Employee;
import gerenciador.persistence.EmployeeRepositoryImpl;

/**
 * Servlet implementation class ListEmployeeServlet
 */
public class ListEmployeeServlet extends HttpServlet {
	EmployeeRepositoryImpl  employee = new EmployeeRepositoryImpl();
	
	private Gson gson = new Gson();
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> lista = employee.getAll();
		String json = gson.toJson(lista);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
	}
}
