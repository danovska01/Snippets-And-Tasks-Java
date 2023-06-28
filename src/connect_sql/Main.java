package connect_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter username default (root): ");
//        String user = sc.nextLine();
//        user = user.equals("") ? "root" : user;
//        System.out.println();
//
//        System.out.print("Enter password default (empty):");
//        String password = sc.nextLine().trim();
//        System.out.println();
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "Badger3802!!");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/demo", props);

        PreparedStatement insertStmt = connection.prepareStatement("INSERT INTO demo (name, text) VALUES ('Hello, I succeeded', 'TEXT10');");
        int rowsAffected = insertStmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Insertion successful.");
        } else {
            System.out.println("Insertion failed.");
        }

        PreparedStatement selectStmt = connection.prepareStatement("SELECT name, text FROM demo;");
        ResultSet rs = selectStmt.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            String text = rs.getString("text");
            System.out.println(name + " " + text);
        }

        connection.close();
    }
}