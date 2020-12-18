package application;

import controller.CSVReader;
import view.OutputManager;

/**
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        OutputManager.headerFooter();

        CSVReader.readEmployees("src/main/resources/EmployeeRecords.csv");

        OutputManager.headerFooter();
    }
}
