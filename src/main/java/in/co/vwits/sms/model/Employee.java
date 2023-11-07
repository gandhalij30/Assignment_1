package in.co.vwits.sms.model;

import java.time.LocalDate;
import java.util.List;

public class Employee implements Comparable<Employee>{
	private int EmpId;
	private String name;
	private double Salary;
	private int numberOfAttempts;
	private List<String> subjectsLearning;
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int EmpId) {
		this.EmpId = EmpId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double Salary) {
		this.Salary = Salary;
	}
	
	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}
	public void setNumberOfAttempts(int numberOfAttempts) {
		this.numberOfAttempts = numberOfAttempts;
	}
	
	
	public List<String> getSubjectsLearning() {
		return subjectsLearning;
	}
	public void setSubjectsLearning(List<String> subjectsLearning) {
		this.subjectsLearning = subjectsLearning;
	}
	
	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", name=" + name + ", Salary=" + Salary + ", numberOfAttempts="
				+ numberOfAttempts + ", subjectsLearning=" + subjectsLearning + "]";
	}
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return (int) (o.Salary - this.Salary);
	}
	public LocalDate getDateOfBirth() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setDateOfBirth(LocalDate of) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}