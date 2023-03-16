package phong.duc;

import phong.duc.connectDB.JdbcRead;
import phong.duc.entity.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            boolean login = false;
            System.out.println("1. Login");
            System.out.println("2. Employee information");
            System.out.println("3. Department information");
            System.out.println("4. Logout");
            System.out.println("Please enter menu: ");
            int menu = scanner.nextInt();
            if (menu == 1) {
                List<Admin> admins = new ArrayList<>();
                JdbcRead jdbcRead = new JdbcRead();
                ResultSet resultSet = jdbcRead.getData();
                while (resultSet.next()) {
                    Admin admin = new Admin(resultSet.getString("username"), resultSet.getString("password"));
                    admins.add(admin);
                }
                System.out.println("Please enter User name: ");
                scanner.nextLine();
                String username = scanner.nextLine();
                System.out.println("Please enter password: ");
                String password = scanner.nextLine();
                for (Admin admin :admins) {
                    if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                        System.out.println("Login Successfully!");
                        login = true;
                    } else {
                        System.out.println("Wrong username or password, Please check!");
                    }
                }
            } else if (menu == 2) {
                if (login) {
                    System.out.println("Show Employee");
                    System.out.println("Insert Employee");
                    System.out.println("Update Employee");
                    System.out.println("Delete Employee");

                } else {
                    System.out.println("Please Login!");
                }

            } else {
                System.out.println("Please re-enter menu (0 < menu < 5): ");
            }
        }
    }
}