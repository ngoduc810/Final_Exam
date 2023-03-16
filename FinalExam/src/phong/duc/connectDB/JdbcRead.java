package phong.duc.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcRead {
    Connection connection = null;
    public ResultSet getData () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/samsung", "root", "root");
            System.out.println("Connect Successfully!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from admin;");
            return resultSet;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Not connect!");
            return null;
        }
    }
}
