package gerenciador.application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import gerenciador.entity.Employee;
import gerenciador.persistence.EmployeeRepositoryImpl;

@WebServlet(urlPatterns="/first")
public class Main extends HttpServlet {
    
	private Gson gson = new Gson();
    
    public Main() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeRepositoryImpl  employee = new EmployeeRepositoryImpl();
		List<Employee> lista = employee.getAll();
		
		String json = gson.toJson(lista);
        
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
	}

}
