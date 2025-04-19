package thogakade;

import java.sql.*;

public class ThogaKade {

    public static void main(String[] args) {
        try {
            String SQL = "select * from customer";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/thogakade", "root", "12345");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                double salary = resultSet.getDouble("salary");
                System.out.println(id + "\t" + name + "\t" + address + "\t" + salary);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver software not found");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
