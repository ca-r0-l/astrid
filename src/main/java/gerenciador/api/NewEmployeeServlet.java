package gerenciador.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.entity.Employee;
import gerenciador.persistence.EmployeeRepositoryImpl;

public class NewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeRepositoryImpl  employee = new EmployeeRepositoryImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Employee e = new Employee(
			request.getParameter("name"),
			request.getParameter("department"),
			Double.parseDouble(request.getParameter("salary"))
		);

		employee.save(e);
		
        response.setCharacterEncoding("UTF-8");
        out.print("Cadastrado");
        out.flush();
	}

}
