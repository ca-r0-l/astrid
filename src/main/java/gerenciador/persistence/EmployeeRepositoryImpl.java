package gerenciador.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gerenciador.entity.Employee;
import gerenciador.factory.ConnectionFactory;
import gerenciador.gateways.*;

public class EmployeeRepositoryImpl implements EmployeeRepository{

	Connection connection = new ConnectionFactory().connect();
	
	public List<Employee> getAll() {
		String sql = "select * from employee;";
		List<Employee> employees = new ArrayList<Employee>();
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			employees = mountListEmployees(stmt.executeQuery());
		} catch (SQLException e) {
			e.getMessage();
		} 
		
		return employees;
	}

	public void save(Employee e) {
		String sql = "insert into employee (name, department, salary) values (?, ?, ?);";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, e.getName());
			statement.setString(2, e.getDepartment());
			statement.setDouble(3, e.getSalary());
			statement.execute();
			
		} catch (SQLException ex) {
			ex.getMessage();
		}
	}
	
	private List<Employee> mountListEmployees(ResultSet rs) {
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			Employee e = null;
			while (rs.next()) {
				e = new Employee(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("department"),
					rs.getFloat("salary")
				);
				
				employees.add(e);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return employees;
	}	
}