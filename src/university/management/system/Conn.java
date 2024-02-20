package university.management.system;

import java.sql.*;

public class Conn {
    Statement s;
    Conn() {
        
        /* Java Database Connectivity done in 5 steps :
           1. Register the Driver Class
           2. Creating Connection String
           3. Creating Statement
           4. Executing MySQL Queries
           5. Closing the Connection
        */
        
        Connection c;
//        Statement s;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem", "root", "Partho@2024#mysql");
            s = c.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
