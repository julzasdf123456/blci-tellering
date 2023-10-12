/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pojos.PaymentOrder;

/**
 *
 * @author Julio Lopez
 */
public class PaymentOrderDao {
    public static PaymentOrder getOneBySvcId(Connection conn, String svcId) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM CRM_PaymentOrder WHERE ServiceConnectionId=?");
            ps.setString(1, svcId);
            ResultSet rs = ps.executeQuery();
            
            PaymentOrder paymentOrder = null;
            
            if (rs.next()) {
                paymentOrder = new PaymentOrder(
                    rs.getString("id"),
                    rs.getString("ServiceConnectionId"),
                    rs.getString("MaterialDeposit"),
                    rs.getString("TransformerRentalFees"),
                    rs.getString("Apprehension"),
                    rs.getString("OverheadExpenses"),
                    rs.getString("CIAC"),
                    rs.getString("ServiceFee"),
                    rs.getString("CustomerDeposit"),
                    rs.getString("TotalSales"),
                    rs.getString("Others"),
                    rs.getString("LocalFTax"),
                    rs.getString("SubTotal"),
                    rs.getString("VAT"),
                    rs.getString("OthersTotal"),
                    rs.getString("OverAllTotal"),
                    rs.getString("ORNumber"),
                    rs.getString("ORDate"),
                    rs.getString("Notes"),
                    rs.getString("MaterialTotal"),
                    rs.getString("AmountPaid")
                );
            }
            
            return paymentOrder;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean updateOrOnServiceConPayments(Connection con, String svcId, String orNumber, String orDate, String amountPaid) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE CRM_PaymentOrder SET ORNumber=?, ORDate=?, AmountPaid=? WHERE ServiceConnectionId=?");
            ps.setString(1, orNumber);
            ps.setString(2, orDate);
            ps.setString(3, amountPaid);
            ps.setString(4, svcId);
            
            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
