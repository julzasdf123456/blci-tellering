/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author Julio Lopez
 */
public class PaymentOrder {
    private String id;
    private String ServiceConnectionId;
    private String MaterialDeposit;
    private String TransformerRentalFees;
    private String Apprehension;
    private String OverheadExpenses;
    private String CIAC;
    private String ServiceFee;
    private String CustomerDeposit;
    private String TotalSales;
    private String Others;
    private String LocalFTax;
    private String SubTotal;
    private String VAT;
    private String OthersTotal;
    private String OverAllTotal;
    private String ORNumber;
    private String ORDate;
    private String Notes;
    private String MaterialTotal;
    private String AmountPaid;
    
    public PaymentOrder() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceConnectionId() {
        return ServiceConnectionId;
    }

    public void setServiceConnectionId(String ServiceConnectionId) {
        this.ServiceConnectionId = ServiceConnectionId;
    }

    public String getMaterialDeposit() {
        return MaterialDeposit;
    }

    public void setMaterialDeposit(String MaterialDeposit) {
        this.MaterialDeposit = MaterialDeposit;
    }

    public String getTransformerRentalFees() {
        return TransformerRentalFees;
    }

    public void setTransformerRentalFees(String TransformerRentalFees) {
        this.TransformerRentalFees = TransformerRentalFees;
    }

    public String getApprehension() {
        return Apprehension;
    }

    public void setApprehension(String Apprehension) {
        this.Apprehension = Apprehension;
    }

    public String getOverheadExpenses() {
        return OverheadExpenses;
    }

    public void setOverheadExpenses(String OverheadExpenses) {
        this.OverheadExpenses = OverheadExpenses;
    }

    public String getCIAC() {
        return CIAC;
    }

    public void setCIAC(String CIAC) {
        this.CIAC = CIAC;
    }

    public String getServiceFee() {
        return ServiceFee;
    }

    public void setServiceFee(String ServiceFee) {
        this.ServiceFee = ServiceFee;
    }

    public String getCustomerDeposit() {
        return CustomerDeposit;
    }

    public void setCustomerDeposit(String CustomerDeposit) {
        this.CustomerDeposit = CustomerDeposit;
    }

    public String getTotalSales() {
        return TotalSales;
    }

    public void setTotalSales(String TotalSales) {
        this.TotalSales = TotalSales;
    }

    public String getOthers() {
        return Others;
    }

    public void setOthers(String Others) {
        this.Others = Others;
    }

    public String getLocalFTax() {
        return LocalFTax;
    }

    public void setLocalFTax(String LocalFTax) {
        this.LocalFTax = LocalFTax;
    }

    public String getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(String SubTotal) {
        this.SubTotal = SubTotal;
    }

    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public String getOthersTotal() {
        return OthersTotal;
    }

    public void setOthersTotal(String OthersTotal) {
        this.OthersTotal = OthersTotal;
    }

    public String getOverAllTotal() {
        return OverAllTotal;
    }

    public void setOverAllTotal(String OverAllTotal) {
        this.OverAllTotal = OverAllTotal;
    }

    public String getORNumber() {
        return ORNumber;
    }

    public void setORNumber(String ORNumber) {
        this.ORNumber = ORNumber;
    }

    public String getORDate() {
        return ORDate;
    }

    public void setORDate(String ORDate) {
        this.ORDate = ORDate;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public String getMaterialTotal() {
        return MaterialTotal;
    }

    public void setMaterialTotal(String MaterialTotal) {
        this.MaterialTotal = MaterialTotal;
    }

    public String getAmountPaid() {
        return AmountPaid;
    }

    public void setAmountPaid(String AmountPaid) {
        this.AmountPaid = AmountPaid;
    }

    public PaymentOrder(String id, String ServiceConnectionId, String MaterialDeposit, String TransformerRentalFees, String Apprehension, String OverheadExpenses, String CIAC, String ServiceFee, String CustomerDeposit, String TotalSales, String Others, String LocalFTax, String SubTotal, String VAT, String OthersTotal, String OverAllTotal, String ORNumber, String ORDate, String Notes, String MaterialTotal, String AmountPaid) {
        this.id = id;
        this.ServiceConnectionId = ServiceConnectionId;
        this.MaterialDeposit = MaterialDeposit;
        this.TransformerRentalFees = TransformerRentalFees;
        this.Apprehension = Apprehension;
        this.OverheadExpenses = OverheadExpenses;
        this.CIAC = CIAC;
        this.ServiceFee = ServiceFee;
        this.CustomerDeposit = CustomerDeposit;
        this.TotalSales = TotalSales;
        this.Others = Others;
        this.LocalFTax = LocalFTax;
        this.SubTotal = SubTotal;
        this.VAT = VAT;
        this.OthersTotal = OthersTotal;
        this.OverAllTotal = OverAllTotal;
        this.ORNumber = ORNumber;
        this.ORDate = ORDate;
        this.Notes = Notes;
        this.MaterialTotal = MaterialTotal;
        this.AmountPaid = AmountPaid;
    }
    
    
}
