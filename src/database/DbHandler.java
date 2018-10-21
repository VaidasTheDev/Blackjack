package database;

import participants.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
                String query = "INSERT INTO users " +
                        "(name,username,password,balance) " +
                        "VALUES (" +
                        "'" + p.getName() + "'," +
                        "'" + p.getUsername() + "'," +
                        "'" + p.getPassword() + "'," +
                        p.getBalance() +
                        ");";
                stmt.executeUpdate(query);
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

    public Player getPlayer(String username, String password) {
        if (this.c != null) {
            try {
                Statement stmt = c.createStatement();
                String query = "SELECT name,balance " +
                        "FROM users " +
                        "WHERE username = '" + username + "' " +
                        "AND password = '" + password + "'" +
                        ";";
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next()) {
                    // user exists, check password
                    final Player p = new Player(rs.getString("name").trim(), username, password, rs.getFloat("balance"));
                    stmt.close();
                    return p;
                } else {
                    // user doesn't exist OR password is incorrect
                    stmt.close();
                    return null;
                }
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
                return null;
            }
        } else {
            System.err.println("Database Error: connection isn't established");
            return null;
        }
    }
}
