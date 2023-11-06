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
public class Ledger {
    private String BillNumber;
    private String BillingMonth;
    private String PreviousReading;
    private String PresentReading;
    private String KwhUsed;
    private String NetAmount;
    private String PaidAmount;
    private String Balance;
    private String DueDate;

    public Ledger(String BillNumber, String BillingMonth, String PreviousReading, String PresentReading, String KwhUsed, String NetAmount, String PaidAmount, String Balance, String DueDate) {
        this.BillNumber = BillNumber;
        this.BillingMonth = BillingMonth;
        this.PreviousReading = PreviousReading;
        this.PresentReading = PresentReading;
        this.KwhUsed = KwhUsed;
        this.NetAmount = NetAmount;
        this.PaidAmount = PaidAmount;
        this.Balance = Balance;
        this.DueDate = DueDate;
    }

    

    public Ledger() {
    }

    public String getBillNumber() {
        return BillNumber;
    }

    public void setBillNumber(String BillNumber) {
        this.BillNumber = BillNumber;
    }

    public String getBillingMonth() {
        return BillingMonth;
    }

    public void setBillingMonth(String BillingMonth) {
        this.BillingMonth = BillingMonth;
    }

    public String getPreviousReading() {
        return PreviousReading;
    }

    public void setPreviousReading(String PreviousReading) {
        this.PreviousReading = PreviousReading;
    }

    public String getPresentReading() {
        return PresentReading;
    }

    public void setPresentReading(String PresentReading) {
        this.PresentReading = PresentReading;
    }

    public String getKwhUsed() {
        return KwhUsed;
    }

    public void setKwhUsed(String KwhUsed) {
        this.KwhUsed = KwhUsed;
    }

    public String getNetAmount() {
        return NetAmount;
    }

    public void setNetAmount(String NetAmount) {
        this.NetAmount = NetAmount;
    }

    public String getPaidAmount() {
        return PaidAmount;
    }

    public void setPaidAmount(String PaidAmount) {
        this.PaidAmount = PaidAmount;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String Balance) {
        this.Balance = Balance;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String DueDate) {
        this.DueDate = DueDate;
    }
    
    
}
