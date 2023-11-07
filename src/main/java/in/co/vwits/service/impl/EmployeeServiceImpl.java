
package in.co.vwits.service.impl;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import in.co.vwits.model.exception.EmployeeNotFoundException;
import in.co.vwits.service.EmployeeService;
import in.co.vwits.sms.dao.EmployeeDao;
import in.co.vwits.sms.dao.impl.EmployeeDaoImpl;
import in.co.vwits.sms.dao.impl.EmployeeJDBCDaoImpl;
import in.co.vwits.sms.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao dao;
	public EmployeeServiceImpl(){
		dao= new EmployeeJDBCDaoImpl();

	}

	
	
	//Print all whose name starts with P

	@Override
	public long countOfEmployeeNameStartingWithP(String name ){ return
			dao.findAll().stream() .filter(Employee->Employee.getName().startsWith("P"))
			.count();

	}


	//Count all whose name starts with P

	@Override
	public List<Employee> findAllEmployeeNameStartingWithP(String name ){
		return dao.findAll().stream()
				.filter(Employee->Employee.getName().startsWith("P"))
				.toList();

	}
	//Using Sorted
	@Override
	public List<Employee> findAllEmployeeSortedBySalary(){
		return dao.findAll().stream().sorted().collect(Collectors.toList()); 
	}
	


	

	

	@Override
	public List<Employee> findAll(){
		return dao.findAll();
	}
	@Override
	public void save(Employee s) {
		dao.save(s);
	}
	//Find Case 3
	@Override
	public Optional<Employee> findByEmpId(int EmpId) throws EmployeeNotFoundException {
		Optional<Employee> p=dao.findByEmpId(EmpId);
		if(p.isPresent()) {
			return p;
		}
		else {
			// throw user defined exception "EmployeeNotFound"
			throw new EmployeeNotFoundException();
		}

	}
	@Override
	public void deleteByEmpId(int EmpId) {
		dao.deleteByEmpId(EmpId);

	}



	@Override
	public void updateByEmpId(int EmpId, double modifiedMarks) {
		// TODO Auto-generated method stub
		
	}

	 
	
	


}
