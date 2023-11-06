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
public class MultipleAccountAddIns {
    private String AccountNumber;
    private String AccountId;
    private String AccountName;
    private String GLCode;
    private String AddOnName;
    private double AddOnAmount;

    public MultipleAccountAddIns() {
    }

    public MultipleAccountAddIns(String AccountNumber, String AccountId, String AccountName, String GLCode, String AddOnName, double AddOnAmount) {
        this.AccountNumber = AccountNumber;
        this.AccountId = AccountId;
        this.AccountName = AccountName;
        this.GLCode = GLCode;
        this.AddOnName = AddOnName;
        this.AddOnAmount = AddOnAmount;
    }

    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String AccountId) {
        this.AccountId = AccountId;
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

    public String getGLCode() {
        return GLCode;
    }

    public void setGLCode(String GLCode) {
        this.GLCode = GLCode;
    }

    public String getAddOnName() {
        return AddOnName;
    }

    public void setAddOnName(String AddOnName) {
        this.AddOnName = AddOnName;
    }

    public double getAddOnAmount() {
        return AddOnAmount;
    }

    public void setAddOnAmount(double AddOnAmount) {
        this.AddOnAmount = AddOnAmount;
    }
    
    
}
