/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luis
 */
public class Connect {
    private static final String URL = "localhost";
    private static final String SCHEMA = "configurafacil";
    private static final String USERNAME = "LFCC";
    private static final String PASSWORD = "55luis14";
    private static final String OPT = "useSSL=false";
    
    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection
            ("jdbc:mysql://"+URL+"/"+SCHEMA+"?"+"user="+USERNAME+"&password="+PASSWORD+"&"+OPT);
            return cn;
        } catch (ClassNotFoundException | SQLException e) {}
        return null;
    }
    
    public static void close(Connection connection) {
        try {
        connection.close();
        } catch (SQLException e) {}
    } 
}
