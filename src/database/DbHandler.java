package database;

import participants.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbHandler {

    private Connection c = null;

    /**
     * Empty constructor
     */
    public DbHandler() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:8000/blackjack",
                            "postgres", "admin");
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Database: opened successfully");
    }

    /**
     * Registers a new user within the database
     * @param p Player object
     */
    public void insertUser(Player p) {
        if (this.c != null) {
            try {
                Statement stmt = c.createStatement();
                String sql = "INSERT INTO users " +
                        "(name,username,password,balance) " +
                        "VALUES (" +
                        "'" + p.getName() + "'," +
                        "'" + p.getUsername() + "'," +
                        "'" + p.getPassword() + "'," +
                        p.getBalance() +
                        ");";
                System.out.println(sql);
                stmt.executeUpdate(sql);
                stmt.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Database: username " + p.getUsername() + " has been registered");
        } else {
            System.err.println("Database Error: connection isn't established");
        }
    }
}
