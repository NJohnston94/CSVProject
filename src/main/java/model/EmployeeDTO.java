package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 */
public class EmployeeDTO {
    //ID, title, name, initial, surname, gender, email, D.o.B, join date, salary
    //last three data can't stay as String, they will have to be set as something more appropriate

    String      employeeID;
    String      employeeTitle;
    String      employeeName;
    String      employeeInitial;
    String      employeeSurname;
    String      employeeGender;
    String      employeeEmail;
    LocalDate   employeeDOB;
    LocalDate   employeeJoinDate;
    Integer     employeeSalary;

    public EmployeeDTO(String employeeID, String employeeTitle, String employeeName, String employeeInitial, String employeeSurname, String employeeGender, String employeeEmail, String employeeDOB, String employeeJoinDate, String employeeSalary) {
        this.employeeID         = employeeID;
        this.employeeTitle      = employeeTitle;
        this.employeeName       = employeeName;
        this.employeeInitial    = employeeInitial;
        this.employeeSurname    = employeeSurname;
        this.employeeGender     = employeeGender;
        this.employeeEmail      = employeeEmail;
        /* employeeDOB = */     setEmployeeDOB(employeeDOB);
        /* employeeJoinDate = */setEmployeeJoinDate(employeeJoinDate);
        /* employeeSalary = */  setEmployeeSalary(employeeSalary);
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeTitle() {
        return employeeTitle;
    }

    public void setEmployeeTitle(String employeeTitle) {
        this.employeeTitle = employeeTitle;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeInitial() {
        return employeeInitial;
    }

    public void setEmployeeInitial(String employeeInitial) {
        this.employeeInitial = employeeInitial;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public LocalDate getEmployeeDOB() {
        return employeeDOB;
    }

    public void setEmployeeDOB(String employeeDOB) {
        this.employeeDOB = LocalDate.parse(employeeDOB, DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
    }

    public LocalDate getEmployeeJoinDate() {
        return employeeJoinDate;
    }

    public void setEmployeeJoinDate(String employeeJoinDate) {
        this.employeeJoinDate = LocalDate.parse(employeeJoinDate, DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
    }

    public Integer getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = Integer.valueOf(employeeSalary);
    }
}
