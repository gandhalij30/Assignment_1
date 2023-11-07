package in.co.vwits.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import in.co.vwits.model.exception.EmployeeNotFoundException;
import in.co.vwits.sms.model.Employee;

public interface EmployeeService {


	//Print all whose name starts with P

	long countOfEmployeeNameStartingWithP(String name);

	List<Employee> findAllEmployeeNameStartingWithP(String name);

	//Using Sorted
	List<Employee> findAllEmployeeSortedBySalary();

	
	


	//Find Case 3
	Optional<Employee> findByEmpId(int EmpId) throws EmployeeNotFoundException;

	void deleteByEmpId(int EmpId);

	void updateByEmpId(int EmpId, double modifiedMarks);

	

	
	List<Employee> findAll();

	void save(Employee s);



}