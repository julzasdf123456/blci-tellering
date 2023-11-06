/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import helpers.ConfigFileHelpers;
import helpers.ObjectHelpers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import pojos.Bills;
import pojos.Collectibles;
import pojos.Ledger;

/**
 *
 * @author Julio Lopez
 */
public class BillsDao {
    private static String billsTableName = "Billing_Bills";
    private static String paidBillsTableName = "Cashier_PaidBills";
    
    public static List<Bills> getUnpaidBillsFromAccountId(Connection con, String accountId) {
        try {
            List<Bills> billsList = new ArrayList<>();
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM " + billsTableName + 
                    " WHERE AccountNumber=? AND (Balance > 0) " 
                            + "ORDER BY ServicePeriod");
            ps.setString(1, accountId);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                billsList.add(
                        new Bills(
                            rs.getString("id"),
                            rs.getString("BillNumber"),
                            rs.getString("AccountNumber"),
                            rs.getString("ServicePeriod"),
                            rs.getString("Multiplier"),
                            rs.getString("Coreloss"),
                            rs.getString("KwhUsed"),
                            rs.getString("PreviousKwh"),
                            rs.getString("PresentKwh"),
                            rs.getString("DemandPreviousKwh"),
                            rs.getString("DemandPresentKwh"),
                            rs.getString("AdditionalKwh"),
                            rs.getString("AdditionalDemandKwh"),
                            rs.getString("KwhAmount"),
                            rs.getString("EffectiveRate"),
                            rs.getString("AdditionalCharges"),
                            rs.getString("Deductions"),
                            rs.getString("NetAmount"),
                            rs.getString("BillingDate"),
                            rs.getString("ServiceDateFrom"),
                            rs.getString("ServiceDateTo"),
                            rs.getString("DueDate"),
                            rs.getString("MeterNumber"),
                            rs.getString("ConsumerType"),
                            rs.getString("BillType"),
                            rs.getString("GenerationSystemCharge"),
                            rs.getString("TransmissionDeliveryChargeKW"),
                            rs.getString("TransmissionDeliveryChargeKWH"),
                            rs.getString("SystemLossCharge"),
                            rs.getString("DistributionDemandCharge"),
                            rs.getString("DistributionSystemCharge"),
                            rs.getString("SupplyRetailCustomerCharge"),
                            rs.getString("SupplySystemCharge"),
                            rs.getString("MeteringRetailCustomerCharge"),
                            rs.getString("MeteringSystemCharge"),
                            rs.getString("RFSC"),
                            rs.getString("LifelineRate"),
                            rs.getString("InterClassCrossSubsidyCharge"),
                            rs.getString("PPARefund"),
                            rs.getString("SeniorCitizenSubsidy"),
                            rs.getString("MissionaryElectrificationCharge"),
                            rs.getString("EnvironmentalCharge"),
                            rs.getString("StrandedContractCosts"),
                            rs.getString("NPCStrandedDebt"),
                            rs.getString("FeedInTariffAllowance"),
                            rs.getString("MissionaryElectrificationREDCI"),
                            rs.getString("GenerationVAT"),
                            rs.getString("TransmissionVAT"),
                            rs.getString("SystemLossVAT"),
                            rs.getString("DistributionVAT"),
                            rs.getString("OthersVAT"),
                            rs.getString("RealPropertyTax"),
                            rs.getString("Notes"),
                            rs.getString("UserId"),
                            rs.getString("BilledFrom"),
                            rs.getString("AveragedCount"),
                            rs.getString("MergedToCollectible"),
                            rs.getString("OtherGenerationRateAdjustment"),
                            rs.getString("OtherTransmissionCostAdjustmentKW"),
                            rs.getString("OtherTransmissionCostAdjustmentKWH"),
                            rs.getString("OtherSystemLossCostAdjustment"),
                            rs.getString("OtherLifelineRateCostAdjustment"),
                            rs.getString("SeniorCitizenDiscountAndSubsidyAdjustment"),
                            rs.getString("FranchiseTax"),
                            rs.getString("BusinessTax"),
                            rs.getString("AdjustmentType"),
                            rs.getString("Form2307Amount"),
                            rs.getString("DeductedDeposit"),
                            rs.getString("ExcessDeposit"),
                            rs.getString("IsUnlockedForPayment"),
                            rs.getString("UnlockedBy"),
                            rs.getString("Evat2Percent"),
                            rs.getString("Evat5Percent"),
                            rs.getString("AdjustmentNumber"),
                            rs.getString("AdjustedBy"),
                            rs.getString("DateAdjusted"),
                            rs.getString("ForCancellation"),
                            rs.getString("CancelRequestedBy"),
                            rs.getString("CancelApprovedBy"),
                            rs.getString("KatasNgVat"),
                            rs.getString("SolarImportPresent"),
                            rs.getString("SolarImportPrevious"),
                            rs.getString("SolarExportPresent"),
                            rs.getString("SolarExportPrevious"),
                            rs.getString("SolarImportKwh"),
                            rs.getString("SolarExportKwh"),
                            rs.getString("GenerationChargeSolarExport"),
                            rs.getString("SolarResidualCredit"), // IF NEGATIVE ANG AMOUNT
                            rs.getString("SolarDemandChargeKW"),
                            rs.getString("SolarDemandChargeKWH"),
                            rs.getString("SolarRetailCustomerCharge"),
                            rs.getString("SolarSupplySystemCharge"),
                            rs.getString("SolarMeteringRetailCharge"),
                            rs.getString("SolarMeteringSystemCharge"),
                            rs.getString("Item1"), // CURRENT AMOUNT DU TO CUSTOMER / PARTIAL AMOUNT
                            rs.getString("Item2"), 
                            rs.getString("Item3"),
                            rs.getString("Item4"), // CURRENT AMOUNT CUSTOMER TO DU (Solar Gen - Residual sa Previous)
                            rs.getString("Item5"),
                            rs.getString("PaidAmount"),
                            rs.getString("Balance"),
                            rs.getString("ACRM"),
                            rs.getString("PowerActReduction"),
                            rs.getString("ACRMVAT"),
                            rs.getString("MissionaryElectrificationSPUG"),
                            rs.getString("MissionaryElectrificationSPUGTRUEUP"),
                            rs.getString("FranchiseTaxOthers"),
                            rs.getString("AdvancedMaterialDeposit"),
                            rs.getString("CustomerDeposit"),
                            rs.getString("TransformerRental"),
                            rs.getString("AdjustmentRequestedBy"),
                            rs.getString("AdjustmentApprovedBy"),
                            rs.getString("AdjustmentStatus"), // PENDING ADJUSTMENT APPROVAL, PENDING CANCELLATION APPROVAL, ADJUSTMENT APPROVED, CANCELLATION APPROVED
                            rs.getString("DateAdjustmentRequested"),
                            rs.getString("TermedPayments"),
                            rs.getString("SurchargeWaived"), // APPROVED, PENDING APPROVAL
                            rs.getString("SurchargeWaiveRequestedBy"),
                            rs.getString("SurchargeWaiveApprovedBy"),
                            rs.getString("SurchargeWaiveRequestDate"),
                            rs.getString("SurchargeWaiveApprovedDate")
                        )
                );
            }
            
            return billsList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Bills getOneById(Connection con, String id) {
        try {
            Bills bill;
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Bills WHERE id=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                bill = new Bills(
                            rs.getString("id"),
                            rs.getString("BillNumber"),
                            rs.getString("AccountNumber"),
                            rs.getString("ServicePeriod"),
                            rs.getString("Multiplier"),
                            rs.getString("Coreloss"),
                            rs.getString("KwhUsed"),
                            rs.getString("PreviousKwh"),
                            rs.getString("PresentKwh"),
                            rs.getString("DemandPreviousKwh"),
                            rs.getString("DemandPresentKwh"),
                            rs.getString("AdditionalKwh"),
                            rs.getString("AdditionalDemandKwh"),
                            rs.getString("KwhAmount"),
                            rs.getString("EffectiveRate"),
                            rs.getString("AdditionalCharges"),
                            rs.getString("Deductions"),
                            rs.getString("NetAmount"),
                            rs.getString("BillingDate"),
                            rs.getString("ServiceDateFrom"),
                            rs.getString("ServiceDateTo"),
                            rs.getString("DueDate"),
                            rs.getString("MeterNumber"),
                            rs.getString("ConsumerType"),
                            rs.getString("BillType"),
                            rs.getString("GenerationSystemCharge"),
                            rs.getString("TransmissionDeliveryChargeKW"),
                            rs.getString("TransmissionDeliveryChargeKWH"),
                            rs.getString("SystemLossCharge"),
                            rs.getString("DistributionDemandCharge"),
                            rs.getString("DistributionSystemCharge"),
                            rs.getString("SupplyRetailCustomerCharge"),
                            rs.getString("SupplySystemCharge"),
                            rs.getString("MeteringRetailCustomerCharge"),
                            rs.getString("MeteringSystemCharge"),
                            rs.getString("RFSC"),
                            rs.getString("LifelineRate"),
                            rs.getString("InterClassCrossSubsidyCharge"),
                            rs.getString("PPARefund"),
                            rs.getString("SeniorCitizenSubsidy"),
                            rs.getString("MissionaryElectrificationCharge"),
                            rs.getString("EnvironmentalCharge"),
                            rs.getString("StrandedContractCosts"),
                            rs.getString("NPCStrandedDebt"),
                            rs.getString("FeedInTariffAllowance"),
                            rs.getString("MissionaryElectrificationREDCI"),
                            rs.getString("GenerationVAT"),
                            rs.getString("TransmissionVAT"),
                            rs.getString("SystemLossVAT"),
                            rs.getString("DistributionVAT"),
                            rs.getString("OthersVAT"),
                            rs.getString("RealPropertyTax"),
                            rs.getString("Notes"),
                            rs.getString("UserId"),
                            rs.getString("BilledFrom"),
                            rs.getString("AveragedCount"),
                            rs.getString("MergedToCollectible"),
                            rs.getString("OtherGenerationRateAdjustment"),
                            rs.getString("OtherTransmissionCostAdjustmentKW"),
                            rs.getString("OtherTransmissionCostAdjustmentKWH"),
                            rs.getString("OtherSystemLossCostAdjustment"),
                            rs.getString("OtherLifelineRateCostAdjustment"),
                            rs.getString("SeniorCitizenDiscountAndSubsidyAdjustment"),
                            rs.getString("FranchiseTax"),
                            rs.getString("BusinessTax"),
                            rs.getString("AdjustmentType"),
                            rs.getString("Form2307Amount"),
                            rs.getString("DeductedDeposit"),
                            rs.getString("ExcessDeposit"),
                            rs.getString("IsUnlockedForPayment"),
                            rs.getString("UnlockedBy"),
                            rs.getString("Evat2Percent"),
                            rs.getString("Evat5Percent"),
                            rs.getString("AdjustmentNumber"),
                            rs.getString("AdjustedBy"),
                            rs.getString("DateAdjusted"),
                            rs.getString("ForCancellation"),
                            rs.getString("CancelRequestedBy"),
                            rs.getString("CancelApprovedBy"),
                            rs.getString("KatasNgVat"),
                            rs.getString("SolarImportPresent"),
                            rs.getString("SolarImportPrevious"),
                            rs.getString("SolarExportPresent"),
                            rs.getString("SolarExportPrevious"),
                            rs.getString("SolarImportKwh"),
                            rs.getString("SolarExportKwh"),
                            rs.getString("GenerationChargeSolarExport"),
                            rs.getString("SolarResidualCredit"), // IF NEGATIVE ANG AMOUNT
                            rs.getString("SolarDemandChargeKW"),
                            rs.getString("SolarDemandChargeKWH"),
                            rs.getString("SolarRetailCustomerCharge"),
                            rs.getString("SolarSupplySystemCharge"),
                            rs.getString("SolarMeteringRetailCharge"),
                            rs.getString("SolarMeteringSystemCharge"),
                            rs.getString("Item1"), // CURRENT AMOUNT DU TO CUSTOMER / PARTIAL AMOUNT
                            rs.getString("Item2"), 
                            rs.getString("Item3"),
                            rs.getString("Item4"), // CURRENT AMOUNT CUSTOMER TO DU (Solar Gen - Residual sa Previous)
                            rs.getString("Item5"),
                            rs.getString("PaidAmount"),
                            rs.getString("Balance"),
                            rs.getString("ACRM"),
                            rs.getString("PowerActReduction"),
                            rs.getString("ACRMVAT"),
                            rs.getString("MissionaryElectrificationSPUG"),
                            rs.getString("MissionaryElectrificationSPUGTRUEUP"),
                            rs.getString("FranchiseTaxOthers"),
                            rs.getString("AdvancedMaterialDeposit"),
                            rs.getString("CustomerDeposit"),
                            rs.getString("TransformerRental"),
                            rs.getString("AdjustmentRequestedBy"),
                            rs.getString("AdjustmentApprovedBy"),
                            rs.getString("AdjustmentStatus"), // PENDING ADJUSTMENT APPROVAL, PENDING CANCELLATION APPROVAL, ADJUSTMENT APPROVED, CANCELLATION APPROVED
                            rs.getString("DateAdjustmentRequested"),
                            rs.getString("TermedPayments"),
                            rs.getString("SurchargeWaived"), // APPROVED, PENDING APPROVAL
                            rs.getString("SurchargeWaiveRequestedBy"),
                            rs.getString("SurchargeWaiveApprovedBy"),
                            rs.getString("SurchargeWaiveRequestDate"),
                            rs.getString("SurchargeWaiveApprovedDate")
                        
                );
                ps.close();
                rs.close();
                return bill;
            }
            ps.close();
            rs.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String getLatestBillingMonthFromRates(Connection con) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT TOP 1 ServicePeriod FROM Billing_Rates ORDER BY ServicePeriod DESC");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String period = rs.getString("ServicePeriod");
                ps.close();
                rs.close();
                return period;
            }
            ps.close();
            rs.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Bills getOneByAccountAndPeriod(Connection con, String accountNo, String servicePeriod) {
        try {
            Bills bill;
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Bills WHERE AccountNumber=? AND ServicePeriod=?");
            ps.setString(1, accountNo);
            ps.setString(2, servicePeriod);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                bill = new Bills(
                            rs.getString("id"),
                            rs.getString("BillNumber"),
                            rs.getString("AccountNumber"),
                            rs.getString("ServicePeriod"),
                            rs.getString("Multiplier"),
                            rs.getString("Coreloss"),
                            rs.getString("KwhUsed"),
                            rs.getString("PreviousKwh"),
                            rs.getString("PresentKwh"),
                            rs.getString("DemandPreviousKwh"),
                            rs.getString("DemandPresentKwh"),
                            rs.getString("AdditionalKwh"),
                            rs.getString("AdditionalDemandKwh"),
                            rs.getString("KwhAmount"),
                            rs.getString("EffectiveRate"),
                            rs.getString("AdditionalCharges"),
                            rs.getString("Deductions"),
                            rs.getString("NetAmount"),
                            rs.getString("BillingDate"),
                            rs.getString("ServiceDateFrom"),
                            rs.getString("ServiceDateTo"),
                            rs.getString("DueDate"),
                            rs.getString("MeterNumber"),
                            rs.getString("ConsumerType"),
                            rs.getString("BillType"),
                            rs.getString("GenerationSystemCharge"),
                            rs.getString("TransmissionDeliveryChargeKW"),
                            rs.getString("TransmissionDeliveryChargeKWH"),
                            rs.getString("SystemLossCharge"),
                            rs.getString("DistributionDemandCharge"),
                            rs.getString("DistributionSystemCharge"),
                            rs.getString("SupplyRetailCustomerCharge"),
                            rs.getString("SupplySystemCharge"),
                            rs.getString("MeteringRetailCustomerCharge"),
                            rs.getString("MeteringSystemCharge"),
                            rs.getString("RFSC"),
                            rs.getString("LifelineRate"),
                            rs.getString("InterClassCrossSubsidyCharge"),
                            rs.getString("PPARefund"),
                            rs.getString("SeniorCitizenSubsidy"),
                            rs.getString("MissionaryElectrificationCharge"),
                            rs.getString("EnvironmentalCharge"),
                            rs.getString("StrandedContractCosts"),
                            rs.getString("NPCStrandedDebt"),
                            rs.getString("FeedInTariffAllowance"),
                            rs.getString("MissionaryElectrificationREDCI"),
                            rs.getString("GenerationVAT"),
                            rs.getString("TransmissionVAT"),
                            rs.getString("SystemLossVAT"),
                            rs.getString("DistributionVAT"),
                            rs.getString("OthersVAT"),
                            rs.getString("RealPropertyTax"),
                            rs.getString("Notes"),
                            rs.getString("UserId"),
                            rs.getString("BilledFrom"),
                            rs.getString("AveragedCount"),
                            rs.getString("MergedToCollectible"),
                            rs.getString("OtherGenerationRateAdjustment"),
                            rs.getString("OtherTransmissionCostAdjustmentKW"),
                            rs.getString("OtherTransmissionCostAdjustmentKWH"),
                            rs.getString("OtherSystemLossCostAdjustment"),
                            rs.getString("OtherLifelineRateCostAdjustment"),
                            rs.getString("SeniorCitizenDiscountAndSubsidyAdjustment"),
                            rs.getString("FranchiseTax"),
                            rs.getString("BusinessTax"),
                            rs.getString("AdjustmentType"),
                            rs.getString("Form2307Amount"),
                            rs.getString("DeductedDeposit"),
                            rs.getString("ExcessDeposit"),
                            rs.getString("IsUnlockedForPayment"),
                            rs.getString("UnlockedBy"),
                            rs.getString("Evat2Percent"),
                            rs.getString("Evat5Percent"),
                            rs.getString("AdjustmentNumber"),
                            rs.getString("AdjustedBy"),
                            rs.getString("DateAdjusted"),
                            rs.getString("ForCancellation"),
                            rs.getString("CancelRequestedBy"),
                            rs.getString("CancelApprovedBy"),
                            rs.getString("KatasNgVat"),
                            rs.getString("SolarImportPresent"),
                            rs.getString("SolarImportPrevious"),
                            rs.getString("SolarExportPresent"),
                            rs.getString("SolarExportPrevious"),
                            rs.getString("SolarImportKwh"),
                            rs.getString("SolarExportKwh"),
                            rs.getString("GenerationChargeSolarExport"),
                            rs.getString("SolarResidualCredit"), // IF NEGATIVE ANG AMOUNT
                            rs.getString("SolarDemandChargeKW"),
                            rs.getString("SolarDemandChargeKWH"),
                            rs.getString("SolarRetailCustomerCharge"),
                            rs.getString("SolarSupplySystemCharge"),
                            rs.getString("SolarMeteringRetailCharge"),
                            rs.getString("SolarMeteringSystemCharge"),
                            rs.getString("Item1"), // CURRENT AMOUNT DU TO CUSTOMER / PARTIAL AMOUNT
                            rs.getString("Item2"), 
                            rs.getString("Item3"),
                            rs.getString("Item4"), // CURRENT AMOUNT CUSTOMER TO DU (Solar Gen - Residual sa Previous)
                            rs.getString("Item5"),
                            rs.getString("PaidAmount"),
                            rs.getString("Balance"),
                            rs.getString("ACRM"),
                            rs.getString("PowerActReduction"),
                            rs.getString("ACRMVAT"),
                            rs.getString("MissionaryElectrificationSPUG"),
                            rs.getString("MissionaryElectrificationSPUGTRUEUP"),
                            rs.getString("FranchiseTaxOthers"),
                            rs.getString("AdvancedMaterialDeposit"),
                            rs.getString("CustomerDeposit"),
                            rs.getString("TransformerRental"),
                            rs.getString("AdjustmentRequestedBy"),
                            rs.getString("AdjustmentApprovedBy"),
                            rs.getString("AdjustmentStatus"), // PENDING ADJUSTMENT APPROVAL, PENDING CANCELLATION APPROVAL, ADJUSTMENT APPROVED, CANCELLATION APPROVED
                            rs.getString("DateAdjustmentRequested"),
                            rs.getString("TermedPayments"),
                            rs.getString("SurchargeWaived"), // APPROVED, PENDING APPROVAL
                            rs.getString("SurchargeWaiveRequestedBy"),
                            rs.getString("SurchargeWaiveApprovedBy"),
                            rs.getString("SurchargeWaiveRequestDate"),
                            rs.getString("SurchargeWaiveApprovedDate")
                        
                );
                ps.close();
                rs.close();
                return bill;
            }
            ps.close();
            rs.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void updateBills(Connection connection, Bills... b) {
        try {
            for (Bills bill : b) {
                String stmt = "UPDATE Billing_Bills SET " +
                        "PaidAmount='" + bill.getPaidAmount() + "', " +
                        "Balance='" + bill.getBalance() + "' " +
                        "WHERE id='" + bill.getId() + "'";
                
                PreparedStatement ps = connection.prepareStatement(stmt);
                
                ps.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getAccountType(String acctType) {
        try {
            if (acctType.equals("RURAL RESIDENTIAL") || acctType.equals("RESIDENTIAL RURAL")) {
                return "RESIDENTIAL";
            } else {
                return acctType;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "RESIDENTIAL";
        }
    }
    
    public static double getSurcharge(Bills bill) {
        try {
            if (ObjectHelpers.isAfterDue(bill)) {
                return ObjectHelpers.roundTwoNoCommaDouble((Double.valueOf(bill.getBalance()) * .0226));
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static double getSurchargeFromRaw(String dueDate, double value) {
        try {
            if (ObjectHelpers.isAfterToday(dueDate)) {
                return ObjectHelpers.roundTwoNoCommaDouble((value * .0226));
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static double getInterest(Bills bill) {
        try {
            DatabaseConnection db = new DatabaseConnection();
            Connection con = db.getDbConnectionFromDatabase(ConfigFileHelpers.getServer());
            String latestRate = getLatestBillingMonthFromRates(con);
        
            long months = ChronoUnit.MONTHS.between(
                    LocalDate.parse(bill.getServicePeriod()).withDayOfMonth(1),
                    LocalDate.parse(latestRate).withDayOfMonth(1));
            
            if (months >= 2) {
                return (Double.valueOf(bill.getNetAmount()) * .02) * (months-1);
            } else {
                return 0;
            }            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static double getBilledAmount(Bills bill) {
        try {
            double billedAmount = ObjectHelpers.doubleStringNull(bill.getGenerationSystemCharge()) +
                    ObjectHelpers.doubleStringNull(bill.getACRM()) +
                    ObjectHelpers.doubleStringNull(bill.getTransmissionDeliveryChargeKWH()) +
                    ObjectHelpers.doubleStringNull(bill.getSystemLossCharge()) +
                    ObjectHelpers.doubleStringNull(bill.getDistributionDemandCharge()) +
                    ObjectHelpers.doubleStringNull(bill.getDistributionSystemCharge()) +
                    ObjectHelpers.doubleStringNull(bill.getSupplyRetailCustomerCharge()) +
                    ObjectHelpers.doubleStringNull(bill.getSupplySystemCharge()) +
                    ObjectHelpers.doubleStringNull(bill.getMeteringSystemCharge()) +
                    ObjectHelpers.doubleStringNull(bill.getMeteringRetailCustomerCharge()) +
                    ObjectHelpers.doubleStringNull(bill.getLifelineRate());                    
                    
            return ObjectHelpers.roundTwoNoCommaDouble(billedAmount);
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
    
    public static double getOthersAmount(Bills bill) {
        try {
            double othersAmount = ObjectHelpers.doubleStringNull(bill.getFranchiseTax()) +
                    ObjectHelpers.doubleStringNull(bill.getFranchiseTaxOthers()) +
                    ObjectHelpers.doubleStringNull(bill.getBusinessTax()) +
                    ObjectHelpers.doubleStringNull(bill.getRealPropertyTax()) +
                    ObjectHelpers.doubleStringNull(bill.getInterClassCrossSubsidyCharge()) +
                    ObjectHelpers.doubleStringNull(bill.getPowerActReduction()) +
                    ObjectHelpers.doubleStringNull(bill.getSeniorCitizenSubsidy()) +
                    ObjectHelpers.doubleStringNull(bill.getEnvironmentalCharge()) +
                    ObjectHelpers.doubleStringNull(bill.getStrandedContractCosts()) +
                    ObjectHelpers.doubleStringNull(bill.getNPCStrandedDebt()) +
                    ObjectHelpers.doubleStringNull(bill.getFeedInTariffAllowance()) +
                    ObjectHelpers.doubleStringNull(bill.getMissionaryElectrificationREDCI()) +
                    ObjectHelpers.doubleStringNull(bill.getMissionaryElectrificationSPUG()) +
                    ObjectHelpers.doubleStringNull(bill.getMissionaryElectrificationSPUGTRUEUP()) +
                    ObjectHelpers.doubleStringNull(bill.getGenerationVAT()) +
                    ObjectHelpers.doubleStringNull(bill.getACRMVAT()) +
                    ObjectHelpers.doubleStringNull(bill.getTransmissionVAT()) +
                    ObjectHelpers.doubleStringNull(bill.getSystemLossVAT()) +
                    ObjectHelpers.doubleStringNull(bill.getDistributionVAT()) +
                    ObjectHelpers.doubleStringNull(bill.getOthersVAT());                    
                    
            return ObjectHelpers.roundTwoNoCommaDouble(othersAmount);
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
    
    public static int getBillIndexFromBillNumber(List<Bills> bills, String billNo) {
        try {
            int index = -1;
            for (int i=0; i<bills.size(); i++) {
                if (billNo.equals(bills.get(i).getBillNumber())) {
                    index = i;
                    break;
                }
            }
            return index;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public static List<Ledger> getLedger(Connection con, String accountId) {
        try {
            List<Ledger> ledgers = new ArrayList<>();
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM " + billsTableName +
                    " WHERE AccountNumber=? " +
                    "ORDER BY ServicePeriod DESC");
            ps.setString(1, accountId);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ledgers.add(new Ledger(rs.getString("BillNumber"),
                        rs.getString("ServicePeriod"), 
                        rs.getString("PreviousKwh"), 
                        rs.getString("PresentKwh"),
                        rs.getString("KwhUsed"),
                        rs.getString("NetAmount"),
                        rs.getString("PaidAmount"),
                        rs.getString("Balance"),
                        rs.getString("DueDate"))
                );
            }
            
            return ledgers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<Collectibles> getTermedPaymentProfiles(Connection con, String accountId) {
        try {
            List<Collectibles> termedPaymentProfiles = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Billing_Collectibles WHERE AccountNumber=? ORDER BY created_at DESC", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, accountId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                termedPaymentProfiles.add(new Collectibles(
                        rs.getString("id"),
                        rs.getString("AccountNumber"), 
                        rs.getString("Balance"), 
                        rs.getString("Notes"), 
                        rs.getString("created_at"),
                        rs.getString("updated_at")
                )) ;
            }
            
            return termedPaymentProfiles;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
//        DatabaseConnection db = new DatabaseConnection();
//        Connection connection = db.getDbConnectionFromDatabase(ConfigFileHelpers.getServer());
//        Bills b = BillsDao.getOneById(connection, "1658446624390-PD5AV7RTO8PL4O2T5V");
//        
//        System.out.println(b.getNetAmount() + " - " + BillsDao.getSurcharge(b));
    }
}
