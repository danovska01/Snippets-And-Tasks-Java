package connect_sql_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class connection_PostgreSQL {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/public";
        String username = "root";
        String password = "Badger3802!!";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create the table
            String createTableQuery = "CREATE TABLE IF NOT EXISTS my_table (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(100), " +
                    "age INT, " +
                    "city VARCHAR(100)" +
                    ")";
            try (PreparedStatement statement = connection.prepareStatement(createTableQuery)) {
                statement.executeUpdate();
            }

            // Insert records
            String insertQuery = "INSERT INTO my_able (name, age, city) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                statement.setString(1, "John Doe");
                statement.setInt(2, 30);
                statement.setString(3, "New York");
                statement.executeUpdate();

                statement.setString(1, "Jane Smith");
                statement.setInt(2, 35);
                statement.setString(3, "Los Angeles");
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
