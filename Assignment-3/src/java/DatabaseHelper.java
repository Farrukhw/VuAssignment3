/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Farrukh
 */
import java.sql.*;


public class DatabaseHelper {

    public Connection initDBConn(String database) {
        String url_uCanAccess;
        Connection conDb;

        //Connecting to MS Access database without using DSN.
        // using some code from https://www.javatpoint.com/connectivity-with-access-without-dsn
        try {

            /*Note: Getting database file path and name from Servlet because on web server , relative names has to be resolved via
            servlets */
            
            //database = "../../web/Resources/bc170400071.accdb";
            
            url_uCanAccess = "jdbc:ucanaccess://" + database;
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conDb = DriverManager.getConnection(url_uCanAccess);
            return conDb;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
