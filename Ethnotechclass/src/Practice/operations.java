package Practice;

import java.sql.*;
import java.util.Scanner;

public class operations {

    static final String URL = "jdbc:mysql://localhost:3306/harshi12";
    static final String USER = "root";
    static final String PASSWORD = "Appi@12345";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("Connected to database!");

            while (true) {
                System.out.println("\n1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Delete");
                System.out.println("4. View");
                System.out.println("5. Exit");
                System.out.print("Choose option: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    // INSERT
                    case 1 -> {
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        String query = "INSERT INTO YD (name) VALUES (?)";
                        PreparedStatement ps = conn.prepareStatement(query);
                        ps.setString(1, name);
                        ps.executeUpdate();

                        System.out.println("Data inserted successfully!");
                    }

                    // UPDATE
                    case 2 -> {
                        System.out.print("Enter ID to update: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new Name: ");
                        String name = sc.nextLine();

                        String query = "UPDATE YD SET name=? WHERE id=?";
                        PreparedStatement ps = conn.prepareStatement(query);
                        ps.setString(1, name);
                        ps.setInt(2, id);

                        int rows = ps.executeUpdate();
                        if (rows > 0)
                            System.out.println("Data updated successfully!");
                        else
                            System.out.println("ID not found!");
                    }

                    // DELETE
                    case 3 -> {
                        System.out.print("Enter ID to delete: ");
                        int id = sc.nextInt();

                        String query = "DELETE FROM YD WHERE id=?";
                        PreparedStatement ps = conn.prepareStatement(query);
                        ps.setInt(1, id);

                        int rows = ps.executeUpdate();
                        if (rows > 0)
                            System.out.println("Data deleted successfully!");
                        else
                            System.out.println("ID not found!");
                    }

                    // VIEW
                    case 4 -> {
                        String query = "SELECT * FROM YD";
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(query);

                        System.out.println("\nID\tNAME");
                        while (rs.next()) {
                            System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));
                        }
                    }

                    // EXIT
                    case 5 -> {
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                    }

                    default -> System.out.println("Invalid choice!");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}