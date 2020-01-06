package gerenciador.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.persistence.EmployeeRepositoryImpl;

public class RemoveEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeRepositoryImpl  employee = new EmployeeRepositoryImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		employee.remove(Integer.valueOf(id));
		
		response.sendRedirect("listEmployee");
	}

}
