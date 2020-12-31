package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CSVReader {

    public static final Logger logger = LogManager.getLogger(CSVReader.class);

    public static void readEmployees(String path) {
        try {
            BufferedReader bufferedReader = new BufferedReader((new FileReader(path)));
            String employeeData;

            bufferedReader.readLine();
            while((employeeData = bufferedReader.readLine()) != null) {
                String[] splitEmployeeData = employeeData.split(",");
                EmployeeManager.sortEmployeeData(splitEmployeeData);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        logger.info("Complete/unique employee data count::  " + EmployeeManager.getEmployeeCount());
        logger.info("Corrupt/duplicated employee data count::  " + EmployeeManager.getEmployeeCorruptedCount());
    }

    public static void readValues(String path) {

        try {
            BufferedReader bufferedReader = new BufferedReader((new FileReader(path)));
            String line;
            ArrayList<String[]> lineList = new ArrayList<>();

            bufferedReader.readLine();

            while((line = bufferedReader.readLine()) != null) {
                String[] splitLine = line.split(",");
                lineList.add(splitLine);
            }

            for(String[] splitLine:lineList) {
                for(String word:splitLine) {
                    System.out.print(word + ", ");
                }
                System.out.println();
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
