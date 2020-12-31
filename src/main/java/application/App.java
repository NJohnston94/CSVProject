package application;

import controller.CSVReader;
import controller.EmployeeDAO;
import controller.EmployeeManager;
import view.OutputManager;

/**
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        OutputManager.headerFooter();

        EmployeeDAO.connectToDB();
        CSVReader.readEmployees("src/main/resources/EmployeeRecords.csv");
        EmployeeManager.pushToDB(EmployeeManager.employees);

        OutputManager.headerFooter();
    }
}
