package view;

import model.EmployeeDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OutputManager {

    public static final Logger logger = LogManager.getLogger(OutputManager.class);

    public static void printEmployeeDetails(EmployeeDTO employee) {
        System.out.println(employee.getEmployeeID());
        System.out.println(employee.getEmployeeTitle());
        System.out.println(employee.getEmployeeName());
        System.out.println(employee.getEmployeeInitial());
        System.out.println(employee.getEmployeeSurname());
        System.out.println(employee.getEmployeeGender());
        System.out.println(employee.getEmployeeEmail());
        System.out.println(employee.getEmployeeDOB().toString());
        System.out.println(employee.getEmployeeJoinDate().toString());
        System.out.println(employee.getEmployeeSalary().toString());

        System.out.println();
        System.out.println();
    }

    public static void headerFooter() {
        System.out.println();
        System.out.println();
    }
}
