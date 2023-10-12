/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import helpers.Notifiers;
import helpers.ObjectHelpers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pojos.CollectionDateAdjustments;

/**
 *
 * @author julza
 */
public class CollectionDateAdjustmentsDao {
    private static String tableName = "Cashier_CollectionDateAdjustments";
    
    public static CollectionDateAdjustments getLatest(Connection connection, String userId) {
        try {
            String stmt = "SELECT TOP 1 * FROM " + tableName + " WHERE UserId=? ORDER BY created_at DESC";
            PreparedStatement ps = connection.prepareStatement(stmt);
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                CollectionDateAdjustments collectionDateAdjustments = new CollectionDateAdjustments(
                    rs.getString("id"),
                    rs.getString("UserId"),
                    rs.getString("DateAssigned"),
                    rs.getString("Notes"),
                    rs.getString("Status"),
                    rs.getString("AssignedBy")
                );
                
                ps.close();
                rs.close();
                
                return collectionDateAdjustments;
            }
            
            ps.close();
            rs.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String getActiveORDate(Connection connection, String userId) {
        try {
            CollectionDateAdjustments collectionDateAdjustments = getLatest(connection, userId);
            
            if (collectionDateAdjustments != null) {
                System.out.println("" + collectionDateAdjustments.getDateAssigned());
                if (ObjectHelpers.isBeforeToday(collectionDateAdjustments.getDateAssigned())) {
                    return collectionDateAdjustments.getDateAssigned();
                } else {
                    return ObjectHelpers.getSqlDate();
                }
            } else {
                return ObjectHelpers.getSqlDate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error getting ORDate", "An error occurred while setting OR Date from Schedule.\n" + e.getMessage());
            return ObjectHelpers.getSqlDate();
        }
    }
}
