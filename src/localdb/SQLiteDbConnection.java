/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julza
 */
public class SQLiteDbConnection {
    public Connection con;
    
    public SQLiteDbConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLiteDbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteDbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public void createTables() {
        try {
            String settings = "CREATE TABLE IF NOT EXISTS Settings (id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "Username TEXT,"
                    + "UserId TEXT,"
                    + "UserPassword TEXT,"
                    + "Office TEXT,"
                    + "OfficeCode TEXT,"
                    + "ServerHostName TEXT, "
                    + "DatabaseName TEXT, "
                    + "DatabaseSuperAdminUsername TEXT, "
                    + "DatabaseSuperAdminPassword TEXT, "
                    + "HostWebLink TEXT, "
                    + "HostWebIPAddress TEXT)";
            
            
            Statement stmt = con.createStatement();
            stmt.executeUpdate(settings);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
