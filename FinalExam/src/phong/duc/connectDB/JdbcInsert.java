package phong.duc.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcInsert {
    Connection connection = null;
    public Statement getData () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/samsung", "root", "root");
            System.out.println("Connect Success!");
            Statement statement = connection.createStatement();
            return statement;
        } catch (Exception e) {
            System.out.println(1);
            System.out.println(e.getMessage());
            return null;
        }
    }
}