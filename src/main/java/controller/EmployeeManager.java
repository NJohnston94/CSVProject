package controller;

import model.EmployeeDTO;
import view.OutputManager;

import java.util.ArrayList;

public class EmployeeManager {

    private static int employeeCount = 0;
    private static int employeeCorruptedCount = 0;
    private static boolean missingEntry = false;

    public  static ArrayList<EmployeeDTO> employees            = new ArrayList<>();
    public  static ArrayList<EmployeeDTO> employeesCorrupted   = new ArrayList<>();

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static int getEmployeeCorruptedCount() {
        return employeeCorruptedCount;
    }

    public static void sortEmployeeData(String[] splitEmployeeData) {
        EmployeeManager.checkMissingData(splitEmployeeData);
        EmployeeDTO employee = EmployeeManager.createEmployee(splitEmployeeData);

        if(!EmployeeManager.isMissingEntry()) {
            if(EmployeeManager.checkUniqueID(employee)) {
                EmployeeManager.checkUniqueID(employee);
                EmployeeManager.addEmployee(employee);
            }
        } else {
            EmployeeManager.addEmployeeCorrupted(employee);
        }
    }

    public static void checkMissingData(String[] splitEmployeeData) {

        for(String attribute:splitEmployeeData){
            if (attribute.equals("") || attribute.equals(" ")) {
                missingEntry = true;
                break;
            }
        }
    }

    public static EmployeeDTO createEmployee(String[] splitLine) {
        return new EmployeeDTO(
                splitLine[0],
                splitLine[1],
                splitLine[2],
                splitLine[3],
                splitLine[4],
                splitLine[5],
                splitLine[6],
                splitLine[7],
                splitLine[8],
                splitLine[9]);
    }

    public static boolean isMissingEntry() {
        return missingEntry;
    }

    public static boolean checkUniqueID(EmployeeDTO employee) {
        ArrayList<EmployeeDTO> employeesToBeRemoved = new ArrayList<>();
        boolean uniqueID = true;

        for (EmployeeDTO loggedEmployee:employees) {
            if(employee.getEmployeeID().equals(loggedEmployee.getEmployeeID())) {
                employeesToBeRemoved.add(loggedEmployee);
                employeeCount--;
                addEmployeeCorrupted(loggedEmployee);
                uniqueID = false;
            }
        }

        addDuplicateToCorrupted(employee, uniqueID);
        employees.removeAll(employeesToBeRemoved);

        return uniqueID;
    }

    private static void addDuplicateToCorrupted(EmployeeDTO employee, boolean uniqueID) {
        if(!uniqueID) {
            addEmployeeCorrupted(employee);
            OutputManager.logger.info("Duplicate added to employeesCorrupted");
        }
    }

    public static void addEmployee(EmployeeDTO employee) {
        employees.add(employee);
        employeeCount++;
        OutputManager.logger.info("Employee added to employees");
    }

    public static void addEmployeeCorrupted(EmployeeDTO employee) {
        employeesCorrupted.add(employee);
        employeeCorruptedCount++;
        OutputManager.logger.info("Employee added to employeesCorrupted");
    }

}
