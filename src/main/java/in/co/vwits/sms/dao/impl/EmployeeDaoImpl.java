package in.co.vwits.sms.dao.impl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import in.co.vwits.sms.model.Employee;
// This class is responsible for talking to(Read,Insert, Update, Delete ) 
// underline data store (in memory/database).

public class EmployeeDaoImpl {
	
	private List<Employee> Employees;
	
	public EmployeeDaoImpl() {
		Employees = new ArrayList<Employee>();
		Employee s1= new Employee();
		s1.setEmpId(1);
		s1.setName("Anagha");
		s1.setSalary(40000);
		
		
		Employee s2= new Employee();
		s2.setEmpId(2);
		s2.setName("Pushkar");
		s2.setSalary(50000);
		
		
		Employee s3= new Employee();
		s3.setEmpId(3);
		s3.setName("Parth");
		s3.setSalary(73000);
		
		
		
		Employees.add(s1);
		Employees.add(s2);
		Employees.add(s3);
	}
	public List<Employee> findAll(){
		return Employees;
	}
	public void save(Employee s) {
		Employees.add(s);
	}
	
	public Optional<Employee> findByEmpId(int EmpId) {
		for(Employee s:Employees) {
			if(s.getEmpId()==EmpId) {
				return Optional.of(s);				
			}
		}
		return Optional.empty();
		
		
	}
	public void deleteByEmpId(int EmpId) {
		
		Iterator<Employee>i= Employees.iterator();
		while(i.hasNext()) {
			Employee s= i.next();
			if(s.getEmpId()==EmpId) {
				i.remove();
			}
		}
		
	}
    public void updateByEmpId(int EmpId, double modifiedMarks) {
		for(Employee s:Employees) {
			if(s.getEmpId()==EmpId) {
				s.setSalary(modifiedMarks);
			}
		}
		
	}
    
   

}

