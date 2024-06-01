package universitysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private Connection conn = null;
    private String userName;
    private String password;
    private String dbms;
    private String serverName;
    private int portNumber;
    private String dbName;
    
    public DatabaseConnection() {
        this.userName = "root";
        this.password = "admin";
        this.dbms = "mysql";
        this.serverName = "localhost";
        this.portNumber = 3306;
        this.dbName = "universitydb";
    }
    

    
    public Connection getConnection() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);

        try {
            conn = DriverManager.getConnection(
                   "jdbc:" + this.dbms + "://" +
                   this.serverName +
                   ":" + this.portNumber + "/" +
                   this.dbName,
                   connectionProps); 

          //  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb", "root", "admin");
            
           // System.out.println("Connected to database");
            return conn;
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }
}
