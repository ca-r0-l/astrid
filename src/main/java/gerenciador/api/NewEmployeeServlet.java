package gerenciador.api;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.entity.Employee;
import gerenciador.persistence.EmployeeRepositoryImpl;

public class NewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeRepositoryImpl  employee = new EmployeeRepositoryImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee e = new Employee(
			request.getParameter("name"),
			request.getParameter("department"),
			Double.parseDouble(request.getParameter("salary"))
		);
		
		employee.save(e);

		RequestDispatcher rd = request.getRequestDispatcher("/employeeSaved.jsp");
		request.setAttribute("employeeName", e.getName());
        rd.forward(request, response);
	}

}
