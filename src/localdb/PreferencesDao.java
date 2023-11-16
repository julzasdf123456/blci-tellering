/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author julza
 */
public class PreferencesDao {
    public static Preferences getPreferences(Connection con) {
        try {
            Preferences preferences = null;
            String stmt = "SELECT * FROM Settings";
            PreparedStatement ps = con.prepareStatement(stmt);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                preferences = new Preferences(rs.getString("id"), 
                        rs.getString("Username"), 
                        rs.getString("UserId"), 
                        rs.getString("UserPassword"), 
                        rs.getString("Office"), 
                        rs.getString("OfficeCode"), 
                        rs.getString("ServerHostName"), 
                        rs.getString("DatabaseName"), 
                        rs.getString("DatabaseSuperAdminUsername"), 
                        rs.getString("DatabaseSuperAdminPassword"), 
                        rs.getString("HostWebLink"), 
                        rs.getString("HostWebIPAddress")
                );
            } 
            
            ps.close();
            rs.close();
            return preferences;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void insertPreferences(Connection con, Preferences preferences) {
        try {
            String stmt = "INSERT INTO Settings (Username, UserId, UserPassword, Office, OfficeCode, ServerHostName, DatabaseName, DatabaseSuperAdminUsername, DatabaseSuperAdminPassword, HostWebLink, HostWebIPAddress) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(stmt);
            ps.setString(1, preferences.getUsername()); 
            ps.setString(2, preferences.getUserId()); 
            ps.setString(3, preferences.getUserPassword()); 
            ps.setString(4, preferences.getOffice()); 
            ps.setString(5, preferences.getOfficeCode()); 
            ps.setString(6, preferences.getServerHostName()); 
            ps.setString(7, preferences.getDatabaseName()); 
            ps.setString(8, preferences.getDatabaseSuperAdminUsername()); 
            ps.setString(9, preferences.getDatabaseSuperAdminPassword()); 
            ps.setString(10, preferences.getHostWebLink()); 
            ps.setString(11, preferences.getHostWebIPAddress());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void updatePreferences(Connection con, Preferences preferences) {
        try {
            String stmt = "UPDATE Settings SET Username=?, UserId=?, UserPassword=?, Office=?, OfficeCode=?, ServerHostName=?, DatabaseName=?, DatabaseSuperAdminUsername=?, DatabaseSuperAdminPassword=?, HostWebLink=?, HostWebIPAddress=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(stmt);
            ps.setString(1, preferences.getUsername()); 
            ps.setString(2, preferences.getUserId()); 
            ps.setString(3, preferences.getUserPassword()); 
            ps.setString(4, preferences.getOffice()); 
            ps.setString(5, preferences.getOfficeCode()); 
            ps.setString(6, preferences.getServerHostName()); 
            ps.setString(7, preferences.getDatabaseName()); 
            ps.setString(8, preferences.getDatabaseSuperAdminUsername()); 
            ps.setString(9, preferences.getDatabaseSuperAdminPassword()); 
            ps.setString(10, preferences.getHostWebLink()); 
            ps.setString(11, preferences.getHostWebIPAddress());
            ps.setString(12, preferences.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
