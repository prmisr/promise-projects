
package za.ac.tut.entity;

import java.sql.Date;


public class Employee {
    private Integer idNo;
    private String name;
    private String surname;
    private Character gender;
    private Integer age;
    private Date dob;
    private Double salary;

    public Employee() {
        
    }

    public Employee(Integer idNo, String name, String surname, Character gender, Integer age, Date dob, Double salary) {
        this.idNo = idNo;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.dob = dob;
        this.salary = salary;
    }

    public Integer getIdNo() {
        return idNo;
    }

    public void setIdNo(Integer idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }


    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return idNo + "," + name + "," + surname + "," + gender + "," + age + "," + dob + "," + salary;
    }
    
    
    
}
