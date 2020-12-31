package controller;

import model.EmployeeDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class EmployeeManager {

    public static final Logger logger = LogManager.getLogger(EmployeeManager.class);

    private static int employeeCount = 0;
    private static int employeeCorruptedCount = 0;
    private static int successfulPushes = 0;
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
            logger.debug("Duplicate added to employeesCorrupted");
        }
    }

    public static void addEmployee(EmployeeDTO employee) {
        employees.add(employee);
        employeeCount++;
        logger.debug("Employee added to employees");
    }

    public static void addEmployeeCorrupted(EmployeeDTO employee) {
        employeesCorrupted.add(employee);
        employeeCorruptedCount++;
        logger.debug("Employee added to employeesCorrupted");
    }

    public static void pushToDB(ArrayList<EmployeeDTO> employees) {
        Long startTime = System.nanoTime();
        logger.info("Pushing " + employeeCount + " data to database");

        for(EmployeeDTO employee:employees) {
            EmployeeDAO.insertEmployeeData(employee);
            logger.debug("Employee data pushed to database");
            successfulPushes++;
        }

        Long finishTime = System.nanoTime();
        long timeTaken = finishTime - startTime;
        logger.info("Time taken to push " + successfulPushes + " to database:: " + (timeTaken/1_000_000_000) + "s");

    }

}
