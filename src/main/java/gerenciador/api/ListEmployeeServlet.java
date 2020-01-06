package gerenciador.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.entity.Employee;
import gerenciador.persistence.EmployeeRepositoryImpl;

public class ListEmployeeServlet extends HttpServlet {
	EmployeeRepositoryImpl  employee = new EmployeeRepositoryImpl();
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> lista = employee.getAll();
		
		RequestDispatcher rd = request.getRequestDispatcher("/listEmployee.jsp");
		request.setAttribute("employees", lista);
        rd.forward(request, response);
	}
}
