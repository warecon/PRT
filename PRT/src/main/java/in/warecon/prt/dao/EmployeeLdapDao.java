package in.warecon.prt.dao;

import java.util.List;

import in.warecon.prt.entity.Employee;

public interface EmployeeLdapDao {

	public List getAllEmployees();

	public boolean insertEmployee(Employee employee);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(Employee employee);
}
