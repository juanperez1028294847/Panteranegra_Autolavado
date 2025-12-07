/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantera_negra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author 52998
 */
public class ConnectionManager {
    // Init Database Constants
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/pantera_negra";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String MAX_POOL = "250";

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Init Connection Object
    private Connection connection;
    // Init Properties Object
    private Properties properties;

    // Create Properties
    private Properties getProperties() {
        if ( properties == null ) {
            properties = new Properties() ;
            properties.setProperty( "user", USERNAME ) ;
            properties.setProperty( "password", PASSWORD ) ;
            properties.setProperty( "MaxPooledStatements" , MAX_POOL ) ;
        }
        return properties;
    }

    // Connect Database
    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection( DATABASE_URL , getProperties() ) ;
                System.out.println( "Connected..." ) ;
            } catch ( ClassNotFoundException | SQLException e ) {
                e.printStackTrace() ;
            }
        }
        return connection;
    }

    // Disconnect Database
    public void disconnect() {
        if ( connection != null ) {
            try {
                connection.close() ;
                connection = null ;
            } catch ( SQLException e ) {
                e.printStackTrace() ;
            }
        }
    }

}
