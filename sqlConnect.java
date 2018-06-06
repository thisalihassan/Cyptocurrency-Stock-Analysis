package sproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlConnect {

    private static Connection mycon;
    private final static String URL = "jdbc:oracle:thin:@LocalHost:1521:ORCl";
    
    public sqlConnect(){
    try {
           mycon = DriverManager.getConnection(URL,"system", "bazoooka");
        } catch (SQLException ex) {
             System.out.println("Connection to ORACLE FAILED");
        }
        
    }

    public final Connection getConnection(){
        return mycon;
    }
    
    
    public final String getURL(){
        return URL;
    }
    
   
}
