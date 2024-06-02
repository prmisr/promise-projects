
package za.ac.tut.bl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.ac.tut.entity.Employee;

public class EployeesManagerDB implements DAOInterface<Employee>{
    private Connection connection;

    public EployeesManagerDB(String dbURL, String username, String password)throws SQLException {
        connection = getConnection(dbURL,username,password);
    }

    @Override
    public boolean add(Employee t) throws SQLException {
        String sql = "INSERT INTO EMPLOYEESTBL(IDNO,NAME,SURNAME,GENDER,AGE,DOB,SALARY) VALUES(?,?,?,?,?,?,?)";
        
        PreparedStatement ps = connection.prepareStatement(sql);
        
        ps.setInt(1, t.getIdNo());
        ps.setString(2, t.getName());
        ps.setString(3, t.getSurname());
        ps.setString(4, t.getGender().toString());
        ps.setInt(5, t.getAge());
        ps.setDate(6, t.getDob());
        ps.setDouble(7, t.getSalary());
        
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean delete(Integer idNum) throws SQLException {
        String sql = "DELETE FROM EMPLOYEESTBL WHERE IDNO =?";
        
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idNum);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean update(Employee t) throws SQLException {
        String sql = "UPDATE EMPLOYEESTBL SET SALARY =? WHERE IDNO =?";
        
        PreparedStatement ps = connection.prepareStatement(sql);
        
        ps.setDouble(1, t.getSalary());
        ps.setInt(2, t.getIdNo());       
        ps.executeUpdate();       
        ps.close();      
        return true;
    }

    @Override
    public Employee get(Integer idNum) throws SQLException {
        String sql = "SELECT IDNO,NAME,SURNAME,GENDER,AGE,DOB,SALARY FROM EMPLOYEESTBL WHERE IDNO =?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idNum);
        
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            Integer idNo = rs.getInt("IDNO");
            String name = rs.getString("NAME");
            String surname = rs.getString("SURNAME");
            Character gender =rs.getString("GENDER").charAt(0);
            Integer age = rs.getInt("AGE");
            Date dob = rs.getDate("DOB");
            Double salary = rs.getDouble("SALARY");
            
            Employee employee = new Employee(idNo,name,surname,gender,age,dob,salary);
            ps.close();
            return employee;
            
        }else{
            ps.close();
            return null;
        }
        
        
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT *FROM EMPLOYEESTBL";
        
        PreparedStatement ps = connection.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Integer idNo = rs.getInt("IDNO");
            String name = rs.getString("NAME");
            String surname = rs.getString("SURNAME");
            Character gender =rs.getString("GENDER").charAt(0);
            Integer age = rs.getInt("AGE");
            Date dob = rs.getDate("DOB");
            Double salary = rs.getDouble("SALARY");
            
            Employee employee = new Employee(idNo,name,surname,gender,age,dob,salary);
            employees.add(employee);
        }
        ps.close();
        
        return employees;
    }

    private Connection getConnection(String dbURL, String username, String password)throws SQLException {
        Connection theConnection;
        theConnection = DriverManager.getConnection(dbURL, username, password);
        
        return theConnection;
    }
    
}
