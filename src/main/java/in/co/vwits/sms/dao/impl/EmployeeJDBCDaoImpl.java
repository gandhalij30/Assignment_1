package in.co.vwits.sms.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import in.co.vwits.sms.dao.EmployeeDao;
import in.co.vwits.sms.model.Employee;

public class EmployeeJDBCDaoImpl implements EmployeeDao{
	//Insert 
	public int save(Employee s) { 
		try (Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/employees_db","root",
					"root");
		PreparedStatement pstmt =con.prepareStatement("INSERT INTO tbl_employees (id, name, salary) VALUES(?,?,?)");) {
		pstmt.setInt(1, s.getEmpId()); 
		pstmt.setString(2,s.getName());
		pstmt.setDouble(3,s.getSalary());
		
		
		
	int noOfRowSpaceUpdated = pstmt.executeUpdate();// firing query...
		

		//System.out.println("No of records updated are "+ noOfRowSpaceUpdated); 
		return noOfRowSpaceUpdated;
		}
	catch (SQLException e) { e.printStackTrace(); }
     return 0;
	}
	
	//Delete
	public void deleteByEmpId(int EmpId) {
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees_db","root","root");
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM tbl_employees WHERE id = ?"); 
				){
			// Before actually firing the query we must set the values for all the ? marks
			pstmt.setInt(1, EmpId);
			int noOfRowsUpdated = pstmt.executeUpdate(); // firing query
			System.out.println("No of records affected are: "+ noOfRowsUpdated);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Update
	public void updateByEmpId(int EmpId, double modifiedSalary) {
		try 
		(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees_db","root","root");
		 PreparedStatement pstmt = con.prepareStatement("UPDATE tbl_employees SET salary =? WHERE id =?");)
		 {
	    pstmt.setDouble(1,modifiedSalary);
        pstmt.setInt(2,EmpId);
      
              
        int noOfRowSpaceUpdated = pstmt.executeUpdate();// firing query...

        System.out.println("No of records updated are "+ noOfRowSpaceUpdated);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
	
	
	//Find by EmpId
	
	public Optional<Employee> findByEmpId(int EmpId)
	{
		try 
		(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees_db","root","root");
	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbl_employees WHERE id= ?");)
		
		{Employee foundEmployee = new Employee();
         pstmt.setInt(1, EmpId);
       
        ResultSet rs = pstmt.executeQuery();//firing query- 
        if(rs.next()) {                          //this method returns true if any 
                                                 //records are present
        	foundEmployee.setEmpId(rs.getInt(1));
        	foundEmployee.setName(rs.getString(2));
        	foundEmployee.setSalary(rs.getDouble(3));
        	
    	
        }
        return Optional.of(foundEmployee);
       
	} catch (SQLException e) {
		e.printStackTrace();
	}
	/*
	 * finally { try { pstmt.close(); con.close(); }catch(SQL Exception e) {
	 * e.printStackTrace(); } }
	 */
		return Optional.empty();
		
	}
	//Find All
	public List<Employee> findAll(){
		List<Employee> Employees= new ArrayList<>();
		try 
		(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees_db","root","root");
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbl_employees ");)
		{
			
			ResultSet rs = pstmt.executeQuery();//firing query- 
			while(rs.next()) {                          //this method returns true if any 
				//records are present
				Employee foundEmployee=new Employee();
				foundEmployee.setEmpId(rs.getInt(1));
	        	foundEmployee.setName(rs.getString(2));
	        	foundEmployee.setSalary(rs.getDouble(3));
	        	
				Employees.add(foundEmployee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Employees;
	}
		 
		
}


	


