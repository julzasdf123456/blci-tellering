/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pojos.AccountPayables;

/**
 *
 * @author Julio Lopez
 */
public class AccountPayablesDao {
    public static List<AccountPayables> getPayables(Connection con) {
        try {
            List<AccountPayables> payablesList = new ArrayList<>();
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Cashier_AccountGLCodes g "
                    + "LEFT JOIN Cashier_AccountPayables p WHERE g.AccountCode=p.AccountCode ORDER BY g.Notes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                payablesList.add(new AccountPayables(
                        rs.getString("g.id"),
                        rs.getString("g.AccountCode"),
                        rs.getString("g.Notes"),
                        rs.getString("p.AccountDescription"),
                        rs.getString("p.DefaultAmount"),
                        rs.getString("p.VATPercentage"),
                        rs.getString("p.Notes"),
                        rs.getString("p.created_at"),
                        rs.getString("p.updated_at")
                ));
            }
            
            return payablesList;
        } catch  (Exception e) {
            e.printStackTrace();
            return null;
        }                
    }
    
    public static List<AccountPayables> searchPayable(Connection con, String regex) {
        try {
            List<AccountPayables> payablesList = new ArrayList<>();
            
            PreparedStatement ps = con.prepareStatement("SELECT FROM Cashier_AccountGLCodes g "
                    + "LEFT JOIN Cashier_AccountPayables p WHERE g.AccountCode LIKE '%" + regex + "%' OR g.Notes LIKE '%" + regex + "%' ORDER BY g.Notes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                payablesList.add(new AccountPayables(
                        rs.getString("g.id"),
                        rs.getString("g.AccountCode"),
                        rs.getString("g.Notes"),
                        rs.getString("p.AccountDescription"),
                        rs.getString("p.DefaultAmount"),
                        rs.getString("p.VATPercentage"),
                        rs.getString("p.Notes"),
                        rs.getString("p.created_at"),
                        rs.getString("p.updated_at")
                ));
            }
            
            return payablesList;
        } catch  (Exception e) {
            e.printStackTrace();
            return null;
        }                
    }
}
