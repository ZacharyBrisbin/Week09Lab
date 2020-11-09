package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GroupDBException extends Exception {
    
    public GroupDBException() {
        
        Connection connection = null;
        
        try {           
            Class.forName("com.mysql.jdbc.Driver");
            
            String dbURL = "jdbc:mysql://localhost:3308/NotesDB";
            String username = "root";
            String password = "password";
            
            connection = DriverManager.getConnection(dbURL, username, password);
        } catch(SQLException e) {
            for (Throwable t : e)
                t.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(" Check MySQL JDBC Driver");
            e.printStackTrace();
        }
        
        if (connection != null) {
            System.out.println("Connection made to Database");
        }
    }

    GroupDBException(String error_inserting_user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
