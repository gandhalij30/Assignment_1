package in.co.vwits.sms.dao;

import java.util.List;
import java.util.Optional;

import in.co.vwits.sms.model.Employee;

public interface EmployeeDao {
	public int save(Employee s);
	public Optional<Employee> findByEmpId(int EmpId);
	public List<Employee> findAll();
	public void deleteByEmpId(int EmpId);
	  public void updateByEmpId(int EmpId, double modifiedMarks);

}
