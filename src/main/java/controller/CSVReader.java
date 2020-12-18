package controller;

import model.EmployeeDTO;
import view.OutputManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public static ArrayList<EmployeeDTO> readEmployees(String path) {
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
        OutputManager.logger.info("Complete/unique employee data count::  " + EmployeeManager.getEmployeeCount());
        OutputManager.logger.info("Corrupt/duplicated employee data count::  " + EmployeeManager.getEmployeeCorruptedCount());

        return EmployeeManager.employees;
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
