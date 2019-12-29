package gerenciador.gateways;

import java.util.List;

import gerenciador.entity.Employee;

public interface EmployeeRepository {
	
	List<Employee> getAll();
	
	void save(Employee e);
}