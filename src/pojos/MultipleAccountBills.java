/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author julza
 */
public class MultipleAccountBills {
    private String BillId;
    private String AccountName;
    private String AccountNumber;
    private String AccountId;
    private String Address;
    private String BillingMonth;
    private String DueDate;
    private String AmountDue;
    private String Surcharge;
    private String TotalAmountDue;
    private boolean Removable;
    private double ReconnectionFee;
    private double ReconnectionFeeVAT;

    public MultipleAccountBills() {
    }

    public MultipleAccountBills(String BillId, String AccountName, String AccountNumber, String AccountId, String Address, String BillingMonth, String DueDate, String AmountDue, String Surcharge, String TotalAmountDue, boolean Removable, double ReconnectionFee, double ReconnectionFeeVAT) {
        this.BillId = BillId;
        this.AccountName = AccountName;
        this.AccountNumber = AccountNumber;
        this.AccountId = AccountId;
        this.Address = Address;
        this.BillingMonth = BillingMonth;
        this.DueDate = DueDate;
        this.AmountDue = AmountDue;
        this.Surcharge = Surcharge;
        this.TotalAmountDue = TotalAmountDue;
        this.Removable = Removable;
        this.ReconnectionFee = ReconnectionFee;
        this.ReconnectionFeeVAT = ReconnectionFeeVAT;
    }

    public String getBillId() {
        return BillId;
    }

    public void setBillId(String BillId) {
        this.BillId = BillId;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String AccountName) {
        this.AccountName = AccountName;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String AccountId) {
        this.AccountId = AccountId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getBillingMonth() {
        return BillingMonth;
    }

    public void setBillingMonth(String BillingMonth) {
        this.BillingMonth = BillingMonth;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String DueDate) {
        this.DueDate = DueDate;
    }

    public String getAmountDue() {
        return AmountDue;
    }

    public void setAmountDue(String AmountDue) {
        this.AmountDue = AmountDue;
    }

    public String getSurcharge() {
        return Surcharge;
    }

    public void setSurcharge(String Surcharge) {
        this.Surcharge = Surcharge;
    }

    public String getTotalAmountDue() {
        return TotalAmountDue;
    }

    public void setTotalAmountDue(String TotalAmountDue) {
        this.TotalAmountDue = TotalAmountDue;
    }

    public boolean isRemovable() {
        return Removable;
    }

    public void setRemovable(boolean Removable) {
        this.Removable = Removable;
    }

    public double getReconnectionFee() {
        return ReconnectionFee;
    }

    public void setReconnectionFee(double ReconnectionFee) {
        this.ReconnectionFee = ReconnectionFee;
    }

    public double getReconnectionFeeVAT() {
        return ReconnectionFeeVAT;
    }

    public void setReconnectionFeeVAT(double ReconnectionFeeVAT) {
        this.ReconnectionFeeVAT = ReconnectionFeeVAT;
    }
    
    
}
