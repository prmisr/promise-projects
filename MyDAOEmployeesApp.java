
package mydaoemployeesapp;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import za.ac.tut.bl.EployeesManagerDB;
import za.ac.tut.entity.Employee;

public class MyDAOEmployeesApp {

    public static void main(String[] args)throws SQLException, ParseException {
        // declare varieble
        EployeesManagerDB db = new EployeesManagerDB("jdbc:derby://localhost:1527/EmployeesDB;create=true", "app", "123");
        int option, employeeID;
        Employee employee;
        
        option = displayChoices();
        
        while(option != 6){
            switch(option){
                case 1:
                   employee = getEmployee();
                   db.add(employee);
                   break;
                case 2:
                    employeeID = getID();
                    db.delete(employeeID);
                    break;
                case 3:
                    employee=getEmployeeToUpdate();
                    db.update(employee);
                    break;
                case 4:
                    employeeID = getID();
                    employee= db.get(employeeID);
                    display(employee);
                    break;
                case 5:
                    List<Employee> emplys = db.getAll();
                    display(emplys);
                    break;
                case 6:
                    System.out.println("GoodBye!!!"); 
                    break;
                default:
                    System.out.println(option+" is invalid."); 
            }
            option = displayChoices();
        }
        
    }

    public static int displayChoices() {
        Scanner sc = new Scanner(System.in);
        int option;
        
        System.out.println("Please choose an option :"+"\n"+
                "1 -- Add employee"+"\n"+
                "2 -- Delete employee"+"\n"+
                "3 -- Update employee"+"\n"+
                "4 -- Get employee"+"\n"+
                "5 -- Get all employee"+"\n"+
                "6 -- Exit");
        option = sc.nextInt();
        
        return option;
    }

    private static Employee getEmployee()throws ParseException {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);
        Scanner sc5 = new Scanner(System.in);
        Scanner sc6 = new Scanner(System.in);
        int idNo,age;
        String name,surname,dob;
        char gender;
        double salary;
        
        System.out.print("Enter employee IDno :");
        idNo = sc.nextInt();
        System.out.print("Enter employee name :");
        name = sc1.next();
        System.out.print("Enter employee surname :");
        surname = sc2.next();
        System.out.print("Enter employee gender[F or M] :");
        gender = sc3.nextLine().charAt(0);
        System.out.print("Enter employee age :");
        age = sc4.nextInt();
        System.out.print("Enter employee salary :");
        salary = sc6.nextDouble();
        System.out.print("Enter employee date of birth (yyyy-mm-dd):");
        dob = sc5.next();
        
        Date date = Date.valueOf(dob);
        
        Employee employee = new Employee(idNo,name,surname,gender,age,date,salary);
        
        return employee;
    }

    private static Integer getID() {
        Scanner sc = new Scanner(System.in);
        int idNo;
        System.out.print("Enter employee IDno :");
        idNo = sc.nextInt();
        
        return idNo;
    }

    private static Employee getEmployeeToUpdate() {
        double salary;
        int idNo;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter employee salary :");
        salary = sc.nextDouble();
        
        System.out.print("Enter employee IDno :");
        idNo = sc.nextInt();
 
        Employee employee = new Employee();
        employee.setSalary(salary);
        employee.setIdNo(idNo);

        return employee;
    }

    private static void display(Employee employee) {
        System.out.println(employee+"\n");
    }

    private static void display(List<Employee> emplys) {
        System.out.println(emplys+"\n");
    }
    
}
