package defaut;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import in.co.vwits.model.exception.EmployeeNotFoundException;
import in.co.vwits.service.EmployeeService;
import in.co.vwits.service.impl.EmployeeServiceImpl;
import in.co.vwits.sms.model.Employee;

public class TestEmployee {

	public static void main(String[] args) {
		int option = 1;
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			EmployeeService service = new EmployeeServiceImpl();

			// Show all Employees
			do {
				System.out.println("Welcome to Employee mangement ");
				System.out.println("1 Find all records");
				System.out.println("2 Insert Records");
				System.out.println("3 Find Employee by Emp Id ");
				System.out.println("4 Delete Employee by Emp Id ");
				System.out.println("5 Update Employee by Emp Id ");
				System.out.println("7 Sort Employee by Salary ");

				System.out.println("6 Find all whose name starts with P");
				
				System.out.println("-1 to Exit");
				System.out.println("Enter choice");

				option = sc.nextInt();

				switch (option) {
				case 1:
					List<Employee> employees = service.findAll();
					System.out.println(employees);
					break;
				case 2:
					//
					Employee s = new Employee();
					s.setName("Anagha");
					s.setEmpId(1);
					s.setSalary(40000);
					service.save(s);
					break;
				case 3:
					System.out.println("Enter the Emp Id");
					int empId = sc.nextInt();
					Optional<Employee> foundemployee;

					try {

						foundemployee = service.findByEmpId(empId);
						System.out.println("Found Employee" + foundemployee.get());
					} catch (EmployeeNotFoundException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						System.out.println("Employee Not Found");
					}

					break;
				case 4:
					System.out.println("Enter the Emp Id");
					try {
						empId = sc.nextInt();
						service.deleteByEmpId(empId);
					} catch (InputMismatchException e) {
						System.out.println("Roll number must be an Integer value");
						sc.nextLine(); // This statement is used to discard the input.
					}

					break;

				case 5:
					double modifiedSalary;
					System.out.println("Enter the Emp Id");
					empId = sc.nextInt();
					System.out.println("Enter new Salary");
					modifiedSalary = sc.nextDouble();
					service.updateByEmpId(empId, modifiedSalary);
					break;

				
			
				case 8:
					String name;
					System.out.println("Enter name :");
					name = sc.toString();
					System.out.println(service.countOfEmployeeNameStartingWithP(name));
					break;

				case 9:
					System.out.println(service.findAllEmployeeSortedBySalary());
					break;

			

				
					



				
			
				case -1:
					System.out.println("--------------------Thank You---------------------");
					break;

				}

			} while (option != -1);
		} finally {
			sc.close();
		}

	}

}
