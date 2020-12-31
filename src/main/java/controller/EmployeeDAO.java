package controller;

import model.EmployeeDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class EmployeeDAO {

    private static Connection connection;
    public static final Logger logger = LogManager.getLogger(EmployeeDAO.class);

    public static void connectToDB() {
        String url = "jdbc:mysql://localhost:3306/employee_data";
        String username = "root";
        String password = "root";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        logger.info("Successfully connected to database:: " + url);
    }

    public static void insertEmployeeData(EmployeeDTO employee) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `employee_data`.`employee` (`id`, `title`, `name`, `initial`, `surname`, `gender`, `email`, `date_of_birth`, `join_date`, `salary`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, Integer.parseInt(employee.getEmployeeID()));
            preparedStatement.setString(2, employee.getEmployeeTitle());
            preparedStatement.setString(3, employee.getEmployeeName());
            preparedStatement.setString(4, employee.getEmployeeInitial());
            preparedStatement.setString(5, employee.getEmployeeSurname());
            preparedStatement.setString(6, employee.getEmployeeGender());
            preparedStatement.setString(7, employee.getEmployeeEmail());
            preparedStatement.setObject(8, employee.getEmployeeDOB());
            preparedStatement.setObject(9, employee.getEmployeeJoinDate());
            preparedStatement.setInt(10, employee.getEmployeeSalary());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
