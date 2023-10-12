/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import helpers.ObjectHelpers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pojos.BillMirror;
import pojos.Bills;

/**
 *
 * @author julza
 */
public class BillMirrorDao {
    private static String tableName = "Cashier_BillMirror";
    
    public static void insert(Connection connection, BillMirror... billMirror) {
        try {
            for (BillMirror bill : billMirror) {
                String stmt = "INSERT INTO " + tableName +
                            "(id," +
                            "BillNumber," +
                            "AccountNumber," +
                            "ServicePeriod," +
                            "AdditionalCharges," +
                            "Deductions," +
                            "NetAmount," +
                            "BillingDate," +
                            "ServiceDateFrom," +
                            "ServiceDateTo," +
                            "DueDate," +
                            "GenerationSystemCharge," +
                            "TransmissionDeliveryChargeKW," +
                            "TransmissionDeliveryChargeKWH," +
                            "SystemLossCharge," +
                            "DistributionDemandCharge," +
                            "DistributionSystemCharge," +
                            "SupplyRetailCustomerCharge," +
                            "SupplySystemCharge," +
                            "MeteringRetailCustomerCharge," +
                            "MeteringSystemCharge," +
                            "RFSC," +
                            "LifelineRate," +
                            "InterClassCrossSubsidyCharge," +
                            "PPARefund," +
                            "SeniorCitizenSubsidy," +
                            "MissionaryElectrificationCharge," +
                            "EnvironmentalCharge," +
                            "StrandedContractCosts," +
                            "NPCStrandedDebt," +
                            "FeedInTariffAllowance," +
                            "MissionaryElectrificationREDCI," +
                            "GenerationVAT," +
                            "TransmissionVAT," +
                            "SystemLossVAT," +
                            "DistributionVAT," +
                            "RealPropertyTax," +
                            "Notes," +
                            "UserId," +
                            "OtherGenerationRateAdjustment," +
                            "OtherTransmissionCostAdjustmentKW," +
                            "OtherTransmissionCostAdjustmentKWH," +
                            "OtherSystemLossCostAdjustment," +
                            "OtherLifelineRateCostAdjustment," +
                            "SeniorCitizenDiscountAndSubsidyAdjustment," +
                            "FranchiseTax," +
                            "BusinessTax," +
                            "AdjustmentType," +
                            "Form2307Amount," +
                            "DeductedDeposit," +
                            "ExcessDeposit," +
                            "IsUnlockedForPayment," +
                            "UnlockedBy," +
                            "Evat2Percent," +
                            "Evat5Percent," +
                            "AdjustmentNumber," +
                            "AdjustedBy," +
                            "DateAdjusted," +
                            "ForCancellation," +
                            "CancelRequestedBy," +
                            "CancelApprovedBy," +
                            "KatasNgVat," +
                            "SolarImportPresent," +
                            "SolarImportPrevious," +
                            "SolarExportPresent," +
                            "SolarExportPrevious," +
                            "SolarImportKwh," +
                            "SolarExportKwh," +
                            "GenerationChargeSolarExport," +
                            "SolarResidualCredit," +
                            "SolarDemandChargeKW," +
                            "SolarDemandChargeKWH," +
                            "SolarRetailCustomerCharge," +
                            "SolarSupplySystemCharge," +
                            "SolarMeteringRetailCharge," +
                            "SolarMeteringSystemCharge," +
                            "Item1," +
                            "Item2," +
                            "Item3," +
                            "Item4," +
                            "Item5," +
                            "PaidAmount," +
                            "Balance," +
                            "ACRM," +
                            "PowerActReduction," +
                            "ACRMVAT," +
                            "MissionaryElectrificationSPUG," +
                            "MissionaryElectrificationSPUGTRUEUP," +
                            "FranchiseTaxOthers," +
                            "OthersVAT," +
                            "AdvancedMaterialDeposit," +
                            "CustomerDeposit," +
                            "TransformerRental," +
                            "AdjustmentRequestedBy," +
                            "AdjustmentApprovedBy," +
                            "AdjustmentStatus," +
                            "DateAdjustmentRequested," +
                            "TermedPayments," +
                            "ORNumber," +
                            "ORDate," +
                            "BatchNumber," +
                            "Teller," +
                            "PaidBillId, "
                            + "created_at,"
                            + "updated_at) VALUES (" + 
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?," +
                            "?)";
                
                PreparedStatement ps = connection.prepareStatement(stmt);
                
                ps.setString(1, bill.getId());
                ps.setString(2, bill.getBillNumber());
                ps.setString(3, bill.getAccountNumber());
                ps.setString(4, bill.getServicePeriod());
                ps.setString(5, bill.getAdditionalCharges());
                ps.setString(6, bill.getDeductions());
                ps.setString(7, bill.getNetAmount());
                ps.setString(8, bill.getBillingDate());
                ps.setString(9, bill.getServiceDateFrom());
                ps.setString(10, bill.getServiceDateTo());
                ps.setString(11, bill.getDueDate());
                ps.setString(12, bill.getGenerationSystemCharge());
                ps.setString(13, bill.getTransmissionDeliveryChargeKW());
                ps.setString(14, bill.getTransmissionDeliveryChargeKWH());
                ps.setString(15, bill.getSystemLossCharge());
                ps.setString(16, bill.getDistributionDemandCharge());
                ps.setString(17, bill.getDistributionSystemCharge());
                ps.setString(18, bill.getSupplyRetailCustomerCharge());
                ps.setString(19, bill.getSupplySystemCharge());
                ps.setString(20, bill.getMeteringRetailCustomerCharge());
                ps.setString(21, bill.getMeteringSystemCharge());
                ps.setString(22, bill.getRFSC());
                ps.setString(23, bill.getLifelineRate());
                ps.setString(24, bill.getInterClassCrossSubsidyCharge());
                ps.setString(25, bill.getPPARefund());
                ps.setString(26, bill.getSeniorCitizenSubsidy());
                ps.setString(27, bill.getMissionaryElectrificationCharge());
                ps.setString(28, bill.getEnvironmentalCharge());
                ps.setString(29, bill.getStrandedContractCosts());
                ps.setString(30, bill.getNPCStrandedDebt());
                ps.setString(31, bill.getFeedInTariffAllowance());
                ps.setString(32, bill.getMissionaryElectrificationREDCI());
                ps.setString(33, bill.getGenerationVAT());
                ps.setString(34, bill.getTransmissionVAT());
                ps.setString(35, bill.getSystemLossVAT());
                ps.setString(36, bill.getDistributionVAT());
                ps.setString(37, bill.getRealPropertyTax());
                ps.setString(38, bill.getNotes());
                ps.setString(39, bill.getUserId());
                ps.setString(40, bill.getOtherGenerationRateAdjustment());
                ps.setString(41, bill.getOtherTransmissionCostAdjustmentKW());
                ps.setString(42, bill.getOtherTransmissionCostAdjustmentKWH());
                ps.setString(43, bill.getOtherSystemLossCostAdjustment());
                ps.setString(44, bill.getOtherLifelineRateCostAdjustment());
                ps.setString(45, bill.getSeniorCitizenDiscountAndSubsidyAdjustment());
                ps.setString(46, bill.getFranchiseTax());
                ps.setString(47, bill.getBusinessTax());
                ps.setString(48, bill.getAdjustmentType());
                ps.setString(49, bill.getForm2307Amount());
                ps.setString(50, bill.getDeductedDeposit());
                ps.setString(51, bill.getExcessDeposit());
                ps.setString(52, bill.getIsUnlockedForPayment());
                ps.setString(53, bill.getUnlockedBy());
                ps.setString(54, bill.getEvat2Percent());
                ps.setString(55, bill.getEvat5Percent());
                ps.setString(56, bill.getAdjustmentNumber());
                ps.setString(57, bill.getAdjustedBy());
                ps.setString(58, bill.getDateAdjusted());
                ps.setString(59, bill.getForCancellation());
                ps.setString(60, bill.getCancelRequestedBy());
                ps.setString(61, bill.getCancelApprovedBy());
                ps.setString(62, bill.getKatasNgVat());
                ps.setString(63, bill.getSolarImportPresent());
                ps.setString(64, bill.getSolarImportPrevious());
                ps.setString(65, bill.getSolarExportPresent());
                ps.setString(66, bill.getSolarExportPrevious());
                ps.setString(67, bill.getSolarImportKwh());
                ps.setString(68, bill.getSolarExportKwh());
                ps.setString(69, bill.getGenerationChargeSolarExport());
                ps.setString(70, bill.getSolarResidualCredit());
                ps.setString(71, bill.getSolarDemandChargeKW());
                ps.setString(72, bill.getSolarDemandChargeKWH());
                ps.setString(73, bill.getSolarRetailCustomerCharge());
                ps.setString(74, bill.getSolarSupplySystemCharge());
                ps.setString(75, bill.getSolarMeteringRetailCharge());
                ps.setString(76, bill.getSolarMeteringSystemCharge());
                ps.setString(77, bill.getItem1());
                ps.setString(78, bill.getItem2());
                ps.setString(79, bill.getItem3());
                ps.setString(80, bill.getItem4());
                ps.setString(81, bill.getItem5());
                ps.setString(82, bill.getPaidAmount());
                ps.setString(83, bill.getBalance());
                ps.setString(84, bill.getACRM());
                ps.setString(85, bill.getPowerActReduction());
                ps.setString(86, bill.getACRMVAT());
                ps.setString(87, bill.getMissionaryElectrificationSPUG());
                ps.setString(88, bill.getMissionaryElectrificationSPUGTRUEUP());
                ps.setString(89, bill.getFranchiseTaxOthers());
                ps.setString(90, bill.getOthersVAT());
                ps.setString(91, bill.getAdvancedMaterialDeposit());
                ps.setString(92, bill.getCustomerDeposit());
                ps.setString(93, bill.getTransformerRental());
                ps.setString(94, bill.getAdjustmentRequestedBy());
                ps.setString(95, bill.getAdjustmentApprovedBy());
                ps.setString(96, bill.getAdjustmentStatus());
                ps.setString(97, bill.getDateAdjustmentRequested());
                ps.setString(98, bill.getTermedPayments());
                ps.setString(99, bill.getORNumber());
                ps.setString(100, bill.getORDate());
                ps.setString(101, bill.getBatchNumber());
                ps.setString(102, bill.getTeller());
                ps.setString(103, bill.getPaidBillId());
                ps.setString(104, ObjectHelpers.getCurrentTimestamp());
                ps.setString(105, ObjectHelpers.getCurrentTimestamp());
                
                ps.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void update(Connection connection, BillMirror... billMirror) {
        try {
            for (BillMirror bill : billMirror) {
                String stmt = "UPDATE " + tableName + " SET " +
                            "BillNumber=?, " +
                            "AccountNumber=?, " +
                            "ServicePeriod=?, " +
                            "AdditionalCharges=?, " +
                            "Deductions=?, " +
                            "NetAmount=?, " +
                            "BillingDate=?, " +
                            "ServiceDateFrom=?, " +
                            "ServiceDateTo=?, " +
                            "DueDate=?, " +
                            "GenerationSystemCharge=?, " +
                            "TransmissionDeliveryChargeKW=?, " +
                            "TransmissionDeliveryChargeKWH=?, " +
                            "SystemLossCharge=?, " +
                            "DistributionDemandCharge=?, " +
                            "DistributionSystemCharge=?, " +
                            "SupplyRetailCustomerCharge=?, " +
                            "SupplySystemCharge=?, " +
                            "MeteringRetailCustomerCharge=?, " +
                            "MeteringSystemCharge=?, " +
                            "RFSC=?, " +
                            "LifelineRate=?, " +
                            "InterClassCrossSubsidyCharge=?, " +
                            "PPARefund=?, " +
                            "SeniorCitizenSubsidy=?, " +
                            "MissionaryElectrificationCharge=?, " +
                            "EnvironmentalCharge=?, " +
                            "StrandedContractCosts=?, " +
                            "NPCStrandedDebt=?, " +
                            "FeedInTariffAllowance=?, " +
                            "MissionaryElectrificationREDCI=?, " +
                            "GenerationVAT=?, " +
                            "TransmissionVAT=?, " +
                            "SystemLossVAT=?, " +
                            "DistributionVAT=?, " +
                            "RealPropertyTax=?, " +
                            "Notes=?, " +
                            "UserId=?, " +
                            "OtherGenerationRateAdjustment=?, " +
                            "OtherTransmissionCostAdjustmentKW=?, " +
                            "OtherTransmissionCostAdjustmentKWH=?, " +
                            "OtherSystemLossCostAdjustment=?, " +
                            "OtherLifelineRateCostAdjustment=?, " +
                            "SeniorCitizenDiscountAndSubsidyAdjustment=?, " +
                            "FranchiseTax=?, " +
                            "BusinessTax=?, " +
                            "AdjustmentType=?, " +
                            "Form2307Amount=?, " +
                            "DeductedDeposit=?, " +
                            "ExcessDeposit=?, " +
                            "IsUnlockedForPayment=?, " +
                            "UnlockedBy=?, " +
                            "Evat2Percent=?, " +
                            "Evat5Percent=?, " +
                            "AdjustmentNumber=?, " +
                            "AdjustedBy=?, " +
                            "DateAdjusted=?, " +
                            "ForCancellation=?, " +
                            "CancelRequestedBy=?, " +
                            "CancelApprovedBy=?, " +
                            "KatasNgVat=?, " +
                            "SolarImportPresent=?, " +
                            "SolarImportPrevious=?, " +
                            "SolarExportPresent=?, " +
                            "SolarExportPrevious=?, " +
                            "SolarImportKwh=?, " +
                            "SolarExportKwh=?, " +
                            "GenerationChargeSolarExport=?, " +
                            "SolarResidualCredit=?, " +
                            "SolarDemandChargeKW=?, " +
                            "SolarDemandChargeKWH=?, " +
                            "SolarRetailCustomerCharge=?, " +
                            "SolarSupplySystemCharge=?, " +
                            "SolarMeteringRetailCharge=?, " +
                            "SolarMeteringSystemCharge=?, " +
                            "Item1=?, " +
                            "Item2=?, " +
                            "Item3=?, " +
                            "Item4=?, " +
                            "Item5=?, " +
                            "PaidAmount=?, " +
                            "Balance=?, " +
                            "ACRM=?, " +
                            "PowerActReduction=?, " +
                            "ACRMVAT=?, " +
                            "MissionaryElectrificationSPUG=?, " +
                            "MissionaryElectrificationSPUGTRUEUP=?, " +
                            "FranchiseTaxOthers=?, " +
                            "OthersVAT=?, " +
                            "AdvancedMaterialDeposit=?, " +
                            "CustomerDeposit=?, " +
                            "TransformerRental=?, " +
                            "AdjustmentRequestedBy=?, " +
                            "AdjustmentApprovedBy=?, " +
                            "AdjustmentStatus=?, " +
                            "DateAdjustmentRequested=?, " +
                            "TermedPayments=?, " +
                            "ORNumber=?, " +
                            "ORDate=?, " +
                            "BatchNumber=?, " +
                            "Teller=?, " +
                            "PaidBillId=?,  " +
                            "created_at=?, " +
                            "updated_at=? " +
                            "WHERE id=?";
                
                PreparedStatement ps = connection.prepareStatement(stmt);
                
                ps.setString(1, bill.getBillNumber());
                ps.setString(2, bill.getAccountNumber());
                ps.setString(3, bill.getServicePeriod());
                ps.setString(4, bill.getAdditionalCharges());
                ps.setString(5, bill.getDeductions());
                ps.setString(6, bill.getNetAmount());
                ps.setString(7, bill.getBillingDate());
                ps.setString(8, bill.getServiceDateFrom());
                ps.setString(9, bill.getServiceDateTo());
                ps.setString(10, bill.getDueDate());
                ps.setString(11, bill.getGenerationSystemCharge());
                ps.setString(12, bill.getTransmissionDeliveryChargeKW());
                ps.setString(13, bill.getTransmissionDeliveryChargeKWH());
                ps.setString(14, bill.getSystemLossCharge());
                ps.setString(15, bill.getDistributionDemandCharge());
                ps.setString(16, bill.getDistributionSystemCharge());
                ps.setString(17, bill.getSupplyRetailCustomerCharge());
                ps.setString(18, bill.getSupplySystemCharge());
                ps.setString(19, bill.getMeteringRetailCustomerCharge());
                ps.setString(20, bill.getMeteringSystemCharge());
                ps.setString(21, bill.getRFSC());
                ps.setString(22, bill.getLifelineRate());
                ps.setString(23, bill.getInterClassCrossSubsidyCharge());
                ps.setString(24, bill.getPPARefund());
                ps.setString(25, bill.getSeniorCitizenSubsidy());
                ps.setString(26, bill.getMissionaryElectrificationCharge());
                ps.setString(27, bill.getEnvironmentalCharge());
                ps.setString(28, bill.getStrandedContractCosts());
                ps.setString(29, bill.getNPCStrandedDebt());
                ps.setString(30, bill.getFeedInTariffAllowance());
                ps.setString(31, bill.getMissionaryElectrificationREDCI());
                ps.setString(32, bill.getGenerationVAT());
                ps.setString(33, bill.getTransmissionVAT());
                ps.setString(34, bill.getSystemLossVAT());
                ps.setString(35, bill.getDistributionVAT());
                ps.setString(36, bill.getRealPropertyTax());
                ps.setString(37, bill.getNotes());
                ps.setString(38, bill.getUserId());
                ps.setString(39, bill.getOtherGenerationRateAdjustment());
                ps.setString(40, bill.getOtherTransmissionCostAdjustmentKW());
                ps.setString(41, bill.getOtherTransmissionCostAdjustmentKWH());
                ps.setString(42, bill.getOtherSystemLossCostAdjustment());
                ps.setString(43, bill.getOtherLifelineRateCostAdjustment());
                ps.setString(44, bill.getSeniorCitizenDiscountAndSubsidyAdjustment());
                ps.setString(45, bill.getFranchiseTax());
                ps.setString(46, bill.getBusinessTax());
                ps.setString(47, bill.getAdjustmentType());
                ps.setString(48, bill.getForm2307Amount());
                ps.setString(49, bill.getDeductedDeposit());
                ps.setString(50, bill.getExcessDeposit());
                ps.setString(51, bill.getIsUnlockedForPayment());
                ps.setString(52, bill.getUnlockedBy());
                ps.setString(53, bill.getEvat2Percent());
                ps.setString(54, bill.getEvat5Percent());
                ps.setString(55, bill.getAdjustmentNumber());
                ps.setString(56, bill.getAdjustedBy());
                ps.setString(57, bill.getDateAdjusted());
                ps.setString(58, bill.getForCancellation());
                ps.setString(59, bill.getCancelRequestedBy());
                ps.setString(60, bill.getCancelApprovedBy());
                ps.setString(61, bill.getKatasNgVat());
                ps.setString(62, bill.getSolarImportPresent());
                ps.setString(63, bill.getSolarImportPrevious());
                ps.setString(64, bill.getSolarExportPresent());
                ps.setString(65, bill.getSolarExportPrevious());
                ps.setString(66, bill.getSolarImportKwh());
                ps.setString(67, bill.getSolarExportKwh());
                ps.setString(68, bill.getGenerationChargeSolarExport());
                ps.setString(69, bill.getSolarResidualCredit());
                ps.setString(70, bill.getSolarDemandChargeKW());
                ps.setString(71, bill.getSolarDemandChargeKWH());
                ps.setString(72, bill.getSolarRetailCustomerCharge());
                ps.setString(73, bill.getSolarSupplySystemCharge());
                ps.setString(74, bill.getSolarMeteringRetailCharge());
                ps.setString(75, bill.getSolarMeteringSystemCharge());
                ps.setString(76, bill.getItem1());
                ps.setString(77, bill.getItem2());
                ps.setString(78, bill.getItem3());
                ps.setString(79, bill.getItem4());
                ps.setString(80, bill.getItem5());
                ps.setString(81, bill.getPaidAmount());
                ps.setString(82, bill.getBalance());
                ps.setString(83, bill.getACRM());
                ps.setString(84, bill.getPowerActReduction());
                ps.setString(85, bill.getACRMVAT());
                ps.setString(86, bill.getMissionaryElectrificationSPUG());
                ps.setString(87, bill.getMissionaryElectrificationSPUGTRUEUP());
                ps.setString(88, bill.getFranchiseTaxOthers());
                ps.setString(89, bill.getOthersVAT());
                ps.setString(90, bill.getAdvancedMaterialDeposit());
                ps.setString(91, bill.getCustomerDeposit());
                ps.setString(92, bill.getTransformerRental());
                ps.setString(93, bill.getAdjustmentRequestedBy());
                ps.setString(94, bill.getAdjustmentApprovedBy());
                ps.setString(95, bill.getAdjustmentStatus());
                ps.setString(96, bill.getDateAdjustmentRequested());
                ps.setString(97, bill.getTermedPayments());
                ps.setString(98, bill.getORNumber());
                ps.setString(99, bill.getORDate());
                ps.setString(100, bill.getBatchNumber());
                ps.setString(101, bill.getTeller());
                ps.setString(102, bill.getPaidBillId());
                ps.setString(103, ObjectHelpers.getCurrentTimestamp());
                ps.setString(104, ObjectHelpers.getCurrentTimestamp());
                ps.setString(105, bill.getId());
                
                ps.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static BillMirror bridgeFromBill(Bills bill) {
        try {
            BillMirror billMirror = new BillMirror();
            
            billMirror.setBillNumber(bill.getBillNumber());
            billMirror.setAccountNumber(bill.getAccountNumber());
            billMirror.setServicePeriod(bill.getServicePeriod());
            billMirror.setAdditionalCharges(bill.getAdditionalCharges());
            billMirror.setDeductions(bill.getDeductions());
            billMirror.setNetAmount(bill.getNetAmount());
            billMirror.setBillingDate(bill.getBillingDate());
            billMirror.setServiceDateFrom(bill.getServiceDateFrom());
            billMirror.setServiceDateTo(bill.getServiceDateTo());
            billMirror.setDueDate(bill.getDueDate());
            billMirror.setGenerationSystemCharge(bill.getGenerationSystemCharge());
            billMirror.setTransmissionDeliveryChargeKW(bill.getTransmissionDeliveryChargeKW());
            billMirror.setTransmissionDeliveryChargeKWH(bill.getTransmissionDeliveryChargeKWH());
            billMirror.setSystemLossCharge(bill.getSystemLossCharge());
            billMirror.setDistributionDemandCharge(bill.getDistributionDemandCharge());
            billMirror.setDistributionSystemCharge(bill.getDistributionSystemCharge());
            billMirror.setSupplyRetailCustomerCharge(bill.getSupplyRetailCustomerCharge());
            billMirror.setSupplySystemCharge(bill.getSupplySystemCharge());
            billMirror.setMeteringRetailCustomerCharge(bill.getMeteringRetailCustomerCharge());
            billMirror.setMeteringSystemCharge(bill.getMeteringSystemCharge());
            billMirror.setRFSC(bill.getRFSC());
            billMirror.setLifelineRate(bill.getLifelineRate());
            billMirror.setInterClassCrossSubsidyCharge(bill.getInterClassCrossSubsidyCharge());
            billMirror.setPPARefund(bill.getPPARefund());
            billMirror.setSeniorCitizenSubsidy(bill.getSeniorCitizenSubsidy());
            billMirror.setMissionaryElectrificationCharge(bill.getMissionaryElectrificationCharge());
            billMirror.setEnvironmentalCharge(bill.getEnvironmentalCharge());
            billMirror.setStrandedContractCosts(bill.getStrandedContractCosts());
            billMirror.setNPCStrandedDebt(bill.getNPCStrandedDebt());
            billMirror.setFeedInTariffAllowance(bill.getFeedInTariffAllowance());
            billMirror.setMissionaryElectrificationREDCI(bill.getMissionaryElectrificationREDCI());
            billMirror.setGenerationVAT(bill.getGenerationVAT());
            billMirror.setTransmissionVAT(bill.getTransmissionVAT());
            billMirror.setSystemLossVAT(bill.getSystemLossVAT());
            billMirror.setDistributionVAT(bill.getDistributionVAT());
            billMirror.setRealPropertyTax(bill.getRealPropertyTax());
            billMirror.setNotes(bill.getNotes());
            billMirror.setUserId(bill.getUserId());
            billMirror.setOtherGenerationRateAdjustment(bill.getOtherGenerationRateAdjustment());
            billMirror.setOtherTransmissionCostAdjustmentKW(bill.getOtherTransmissionCostAdjustmentKW());
            billMirror.setOtherTransmissionCostAdjustmentKWH(bill.getOtherTransmissionCostAdjustmentKWH());
            billMirror.setOtherSystemLossCostAdjustment(bill.getOtherSystemLossCostAdjustment());
            billMirror.setOtherLifelineRateCostAdjustment(bill.getOtherLifelineRateCostAdjustment());
            billMirror.setSeniorCitizenDiscountAndSubsidyAdjustment(bill.getSeniorCitizenDiscountAndSubsidyAdjustment());
            billMirror.setFranchiseTax(bill.getFranchiseTax());
            billMirror.setBusinessTax(bill.getBusinessTax());
            billMirror.setAdjustmentType(bill.getAdjustmentType());
            billMirror.setForm2307Amount(bill.getForm2307Amount());
            billMirror.setDeductedDeposit(bill.getDeductedDeposit());
            billMirror.setExcessDeposit(bill.getExcessDeposit());
            billMirror.setIsUnlockedForPayment(bill.getIsUnlockedForPayment());
            billMirror.setUnlockedBy(bill.getUnlockedBy());
            billMirror.setEvat2Percent(bill.getEvat2Percent());
            billMirror.setEvat5Percent(bill.getEvat5Percent());
            billMirror.setAdjustmentNumber(bill.getAdjustmentNumber());
            billMirror.setAdjustedBy(bill.getAdjustedBy());
            billMirror.setDateAdjusted(bill.getDateAdjusted());
            billMirror.setForCancellation(bill.getForCancellation());
            billMirror.setCancelRequestedBy(bill.getCancelRequestedBy());
            billMirror.setCancelApprovedBy(bill.getCancelApprovedBy());
            billMirror.setKatasNgVat(bill.getKatasNgVat());
            billMirror.setSolarImportPresent(bill.getSolarImportPresent());
            billMirror.setSolarImportPrevious(bill.getSolarImportPrevious());
            billMirror.setSolarExportPresent(bill.getSolarExportPresent());
            billMirror.setSolarExportPrevious(bill.getSolarExportPrevious());
            billMirror.setSolarImportKwh(bill.getSolarImportKwh());
            billMirror.setSolarExportKwh(bill.getSolarExportKwh());
            billMirror.setGenerationChargeSolarExport(bill.getGenerationChargeSolarExport());
            billMirror.setSolarResidualCredit(bill.getSolarResidualCredit());
            billMirror.setSolarDemandChargeKW(bill.getSolarDemandChargeKW());
            billMirror.setSolarDemandChargeKWH(bill.getSolarDemandChargeKWH());
            billMirror.setSolarRetailCustomerCharge(bill.getSolarRetailCustomerCharge());
            billMirror.setSolarSupplySystemCharge(bill.getSolarSupplySystemCharge());
            billMirror.setSolarMeteringRetailCharge(bill.getSolarMeteringRetailCharge());
            billMirror.setSolarMeteringSystemCharge(bill.getSolarMeteringSystemCharge());
            billMirror.setItem1(bill.getItem1());
            billMirror.setItem2(bill.getItem2());
            billMirror.setItem3(bill.getItem3());
            billMirror.setItem4(bill.getItem4());
            billMirror.setItem5(bill.getItem5());
            billMirror.setPaidAmount(bill.getPaidAmount());
            billMirror.setBalance(bill.getBalance());
            billMirror.setACRM(bill.getACRM());
            billMirror.setPowerActReduction(bill.getPowerActReduction());
            billMirror.setACRMVAT(bill.getACRMVAT());
            billMirror.setMissionaryElectrificationSPUG(bill.getMissionaryElectrificationSPUG());
            billMirror.setMissionaryElectrificationSPUGTRUEUP(bill.getMissionaryElectrificationSPUGTRUEUP());
            billMirror.setFranchiseTaxOthers(bill.getFranchiseTaxOthers());
            billMirror.setOthersVAT(bill.getOthersVAT());
            billMirror.setAdvancedMaterialDeposit(bill.getAdvancedMaterialDeposit());
            billMirror.setCustomerDeposit(bill.getCustomerDeposit());
            billMirror.setTransformerRental(bill.getTransformerRental());
            billMirror.setAdjustmentRequestedBy(bill.getAdjustmentRequestedBy());
            billMirror.setAdjustmentApprovedBy(bill.getAdjustmentApprovedBy());
            billMirror.setAdjustmentStatus(bill.getAdjustmentStatus());
            billMirror.setDateAdjustmentRequested(bill.getDateAdjustmentRequested());
            billMirror.setTermedPayments(bill.getTermedPayments());
            
            return billMirror;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static BillMirror getOne(Connection connection, String acctNo, String period) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Cashier_BillMirror WHERE AccountNumber=? AND ServicePeriod=?");
            ps.setString(1, acctNo);
            ps.setString(2, period);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                BillMirror billMirror = new BillMirror(
                        rs.getString("id"),
                        rs.getString("BillNumber"),
                        rs.getString("AccountNumber"),
                        rs.getString("ServicePeriod"),
                        rs.getString("AdditionalCharges"),
                        rs.getString("Deductions"),
                        rs.getString("NetAmount"),
                        rs.getString("BillingDate"),
                        rs.getString("ServiceDateFrom"),
                        rs.getString("ServiceDateTo"),
                        rs.getString("DueDate"),
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
                        rs.getString("RealPropertyTax"),
                        rs.getString("Notes"),
                        rs.getString("UserId"),
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
                        rs.getString("SolarResidualCredit"),
                        rs.getString("SolarDemandChargeKW"),
                        rs.getString("SolarDemandChargeKWH"),
                        rs.getString("SolarRetailCustomerCharge"),
                        rs.getString("SolarSupplySystemCharge"),
                        rs.getString("SolarMeteringRetailCharge"),
                        rs.getString("SolarMeteringSystemCharge"),
                        rs.getString("Item1"),
                        rs.getString("Item2"),
                        rs.getString("Item3"),
                        rs.getString("Item4"),
                        rs.getString("Item5"),
                        rs.getString("PaidAmount"),
                        rs.getString("Balance"),
                        rs.getString("ACRM"),
                        rs.getString("PowerActReduction"),
                        rs.getString("ACRMVAT"),
                        rs.getString("MissionaryElectrificationSPUG"),
                        rs.getString("MissionaryElectrificationSPUGTRUEUP"),
                        rs.getString("FranchiseTaxOthers"),
                        rs.getString("OthersVAT"),
                        rs.getString("AdvancedMaterialDeposit"),
                        rs.getString("CustomerDeposit"),
                        rs.getString("TransformerRental"),
                        rs.getString("AdjustmentRequestedBy"),
                        rs.getString("AdjustmentApprovedBy"),
                        rs.getString("AdjustmentStatus"),
                        rs.getString("DateAdjustmentRequested"),
                        rs.getString("TermedPayments"),
                        rs.getString("ORNumber"),
                        rs.getString("ORDate"),
                        rs.getString("BatchNumber"),
                        rs.getString("Teller"),
                        rs.getString("PaidBillId")
                );
                
                ps.close();
                rs.close();
                
                return billMirror;
            }
            
            ps.close();
            rs.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static double populateTermedPaymentAmount(double amount, Bills bill, BillMirror billMirror) {
        try {            
            // TERMED PAYMENTS
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getTermedPayments());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setTermedPayments(amnt + "");
                amount = amount - amnt;
            }
            
            return amount;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static double populateTermedPaymentAmountUpdate(double amount, Bills bill, BillMirror billMirror) {
        try {            
            // TERMED PAYMENTS
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getTermedPayments());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getTermedPayments());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setTermedPayments((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            return amount;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static double populateOtherAmount(double amount, Bills bill, BillMirror billMirror) {
        try {
            // FRANCHISE TAX
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getFranchiseTax());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setFranchiseTax(amnt + "");
                amount = amount - amnt;
            }
            
            // FRANCHIX TAX OTHERS
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getFranchiseTaxOthers());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setFranchiseTaxOthers(amnt + "");
                amount = amount - amnt;
            }
            
            // BUSINESS TAX
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getBusinessTax());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setBusinessTax(amnt + "");
                amount = amount - amnt;
            }
            
            // RPT
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getRealPropertyTax());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setRealPropertyTax(amnt + "");
                amount = amount - amnt;
            }
            
            // ICCS
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getInterClassCrossSubsidyCharge());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setInterClassCrossSubsidyCharge(amnt + "");
                amount = amount - amnt;
            }
            
            // POWER ACT REDUCTION
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getPowerActReduction());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setPowerActReduction(amnt + "");
                amount = amount - amnt;
            }
            
            // SC
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getSeniorCitizenSubsidy());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setSeniorCitizenSubsidy(amnt + "");
                amount = amount - amnt;
            }
            
            // ENVIRONMENTAL CHARGE
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getEnvironmentalCharge());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setEnvironmentalCharge(amnt + "");
                amount = amount - amnt;
            }
            
            // STRANDED CC
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getStrandedContractCosts());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setStrandedContractCosts(amnt + "");
                amount = amount - amnt;
            }
            
            // NPC STRANDED DEBT
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getNPCStrandedDebt());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setNPCStrandedDebt(amnt + "");
                amount = amount - amnt;
            }
            
            // FIT ALL
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getFeedInTariffAllowance());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setFeedInTariffAllowance(amnt + "");
                amount = amount - amnt;
            }
            
            // REDCI
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getMissionaryElectrificationREDCI());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setMissionaryElectrificationREDCI(amnt + "");
                amount = amount - amnt;
            }
            
            // SPUG
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getMissionaryElectrificationSPUG());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setMissionaryElectrificationSPUG(amnt + "");
                amount = amount - amnt;
            }
            
            // SPUG TRUE UP 
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getMissionaryElectrificationSPUGTRUEUP());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setMissionaryElectrificationSPUGTRUEUP(amnt + "");
                amount = amount - amnt;
            }            
            
            // GENVAT
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getGenerationVAT());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setGenerationVAT(amnt + "");
                amount = amount - amnt;
            }
            
            // ACRM VAT
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getACRMVAT());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setACRMVAT(amnt + "");
                amount = amount - amnt;
            }
            
            // TRANSVAT
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getTransmissionVAT());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setTransmissionVAT(amnt + "");
                amount = amount - amnt;
            }
            
            // SYSLOSSVAT
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getSystemLossVAT());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setSystemLossVAT(amnt + "");
                amount = amount - amnt;
            }
            
            // DISTVAT
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getDistributionVAT());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setDistributionVAT(amnt + "");
                amount = amount - amnt;
            }
            
            // OTHERS VAT
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getOthersVAT());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setOthersVAT(amnt + "");
                amount = amount - amnt;
            }
            
            return amount;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static double populateOtherAmountUpdate(double amount, Bills bill, BillMirror billMirror) {
        try {
            // FRANCHISE TAX
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getFranchiseTax());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getFranchiseTax());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setFranchiseTax((amnt + existingValue) + "");
                    amount = amount - amnt;    
                }
            }
            
            // FRANCHIX TAX OTHERS
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getFranchiseTaxOthers());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getFranchiseTaxOthers());                
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setFranchiseTaxOthers((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // BUSINESS TAX
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getBusinessTax());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getBusinessTax());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setBusinessTax((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // RPT
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getRealPropertyTax());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getRealPropertyTax());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setRealPropertyTax((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // ICCS
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getInterClassCrossSubsidyCharge());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getInterClassCrossSubsidyCharge());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setInterClassCrossSubsidyCharge((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // POWER ACT REDUCTION
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getPowerActReduction());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getPowerActReduction());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                billMirror.setPowerActReduction((amnt + existingValue) + "");
                amount = amount - amnt;
            }
            
            // SC
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getSeniorCitizenSubsidy());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getSeniorCitizenSubsidy());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setSeniorCitizenSubsidy((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // ENVIRONMENTAL CHARGE
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getEnvironmentalCharge());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getEnvironmentalCharge());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setEnvironmentalCharge((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // STRANDED CC
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getStrandedContractCosts());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getStrandedContractCosts());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setStrandedContractCosts((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // NPC STRANDED DEBT
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getNPCStrandedDebt());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getNPCStrandedDebt());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setNPCStrandedDebt((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // FIT ALL
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getFeedInTariffAllowance());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getFeedInTariffAllowance());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setFeedInTariffAllowance((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // REDCI
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getMissionaryElectrificationREDCI());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getMissionaryElectrificationREDCI());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setMissionaryElectrificationREDCI((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // SPUG
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getMissionaryElectrificationSPUG());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getMissionaryElectrificationSPUG());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setMissionaryElectrificationSPUG((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // SPUG TRUE UP 
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getMissionaryElectrificationSPUGTRUEUP());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getMissionaryElectrificationSPUGTRUEUP());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setMissionaryElectrificationSPUGTRUEUP((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }            
            
            // GENVAT
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getGenerationVAT());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getGenerationVAT());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setGenerationVAT((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // ACRM VAT
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getACRMVAT());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getACRMVAT());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setACRMVAT((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // TRANSVAT
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getTransmissionVAT());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getTransmissionVAT());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setTransmissionVAT((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // SYSLOSSVAT
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getSystemLossVAT());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getSystemLossVAT());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setSystemLossVAT((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // DISTVAT
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getDistributionVAT());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getDistributionVAT());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setDistributionVAT((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // OTHERS VAT
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getOthersVAT());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getOthersVAT());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setOthersVAT((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            return amount;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static double populateBilledAmount(double amount, Bills bill, BillMirror billMirror) {
        try {
            // GENERATION
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getGenerationSystemCharge());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setGenerationSystemCharge(amnt + "");
                amount = amount - amnt;
            }
            
            // ACRM
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getACRM());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setACRM(amnt + "");
                amount = amount - amnt;
            }
            
            // TRANSMISSION
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getTransmissionDeliveryChargeKWH());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setTransmissionDeliveryChargeKWH(amnt + "");
                amount = amount - amnt;
            }
            
            // SYSTE LOSS
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getSystemLossCharge());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setSystemLossCharge(amnt + "");
                amount = amount - amnt;
            }
            
            // DISTRIBUTION DEMAND
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getDistributionDemandCharge());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setDistributionDemandCharge(amnt + "");
                amount = amount - amnt;
            }
            
            // DISTRIBUTION SYSTEM
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getDistributionSystemCharge());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setDistributionSystemCharge(amnt + "");
                amount = amount - amnt;
            }
            
            // SUPLY RETAIL
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getSupplyRetailCustomerCharge());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setSupplyRetailCustomerCharge(amnt + "");
                amount = amount - amnt;
            }
            
            // SUPPLY SYSTEM
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getSupplySystemCharge());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setSupplySystemCharge(amnt + "");
                amount = amount - amnt;
            }
            
            // METERING SYSTEM
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getMeteringSystemCharge());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setMeteringSystemCharge(amnt + "");
                amount = amount - amnt;
            }
            
            // METERING RETAIL
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getMeteringRetailCustomerCharge());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setMeteringRetailCustomerCharge(amnt + "");
                amount = amount - amnt;
            }
            
            // LIFELINE
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getLifelineRate());
                double amnt = ObjectHelpers.roundTwoNoCommaDouble(distribute(amount, dist));
                billMirror.setLifelineRate(amnt + "");
                amount = amount - amnt;
            }
            
            return amount;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static double populateBilledAmountUpdate(double amount, Bills bill, BillMirror billMirror) {
        try {
            // GENERATION
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getGenerationSystemCharge());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getGenerationSystemCharge());                
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setGenerationSystemCharge((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // ACRM
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getACRM());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getACRM());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setACRM((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // TRANSMISSION
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getTransmissionDeliveryChargeKWH());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getTransmissionDeliveryChargeKWH());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setTransmissionDeliveryChargeKWH((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // SYSTE LOSS
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getSystemLossCharge());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getSystemLossCharge());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setSystemLossCharge((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // DISTRIBUTION DEMAND
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getDistributionDemandCharge());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getDistributionDemandCharge());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setDistributionDemandCharge((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // DISTRIBUTION SYSTEM
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getDistributionSystemCharge());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getDistributionSystemCharge());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setDistributionSystemCharge((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // SUPLY RETAIL
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getSupplyRetailCustomerCharge());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getSupplyRetailCustomerCharge());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setSupplyRetailCustomerCharge((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // SUPPLY SYSTEM
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getSupplySystemCharge());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getSupplySystemCharge());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setSupplySystemCharge((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // METERING SYSTEM
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getMeteringSystemCharge());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getMeteringSystemCharge());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setMeteringSystemCharge((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // METERING RETAIL
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getMeteringRetailCustomerCharge());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getMeteringRetailCustomerCharge());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setMeteringRetailCustomerCharge((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            // LIFELINE
            if (amount > 0) {
                double dist = ObjectHelpers.doubleStringNull(bill.getLifelineRate());
                double existingValue = ObjectHelpers.doubleStringNull(billMirror.getLifelineRate());
                if (existingValue == dist) {
                    
                } else if (existingValue < dist) {
                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(distributeUpdate(amount, dist, existingValue));
                    billMirror.setLifelineRate((amnt + existingValue) + "");
                    amount = amount - amnt;
                }
            }
            
            return amount;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static double distribute(double amount, double charges) {
        try {
            if (amount >= charges) {
                return charges;
            } else {
                double dif = charges - amount;
                return charges - dif;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }     
    }
    
    public static double distributeUpdate(double amount, double charges, double existingValue) {
        try {
            double remaining = charges - existingValue;
                        
            if (amount >= remaining) {
                return remaining;
            } else {
                double dif = remaining - amount;
                return remaining - dif;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }     
    }
    
    public static Bills getPaidCharges(Connection connection, String acctNo, String period) {
        try {
            Bills bill = new Bills();
            
            String stmt = "SELECT " +
                "SUM(TRY_CAST(GenerationSystemCharge AS DECIMAL(12,2))) AS GenerationSystemCharge, " +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKW AS DECIMAL(12,2))) AS TransmissionDeliveryChargeKW, " +
                "SUM(TRY_CAST(TransmissionDeliveryChargeKWH AS DECIMAL(12,2))) AS TransmissionDeliveryChargeKWH, " +
                "SUM(TRY_CAST(SystemLossCharge AS DECIMAL(12,2))) AS SystemLossCharge, " +
                "SUM(TRY_CAST(DistributionDemandCharge AS DECIMAL(12,2))) AS DistributionDemandCharge, " +
                "SUM(TRY_CAST(DistributionSystemCharge AS DECIMAL(12,2))) AS DistributionSystemCharge, " +
                "SUM(TRY_CAST(SupplyRetailCustomerCharge AS DECIMAL(12,2))) AS SupplyRetailCustomerCharge, " +
                "SUM(TRY_CAST(SupplySystemCharge AS DECIMAL(12,2))) AS SupplySystemCharge, " +
                "SUM(TRY_CAST(MeteringRetailCustomerCharge AS DECIMAL(12,2))) AS MeteringRetailCustomerCharge, " +
                "SUM(TRY_CAST(MeteringSystemCharge AS DECIMAL(12,2))) AS MeteringSystemCharge, " +
                "SUM(TRY_CAST(RFSC AS DECIMAL(12,2))) AS RFSC, " +
                "SUM(TRY_CAST(LifelineRate AS DECIMAL(12,2))) AS LifelineRate, " +
                "SUM(TRY_CAST(InterClassCrossSubsidyCharge AS DECIMAL(12,2))) AS InterClassCrossSubsidyCharge, " +
                "SUM(TRY_CAST(PPARefund AS DECIMAL(12,2))) AS PPARefund, " +
                "SUM(TRY_CAST(SeniorCitizenSubsidy AS DECIMAL(12,2))) AS SeniorCitizenSubsidy, " +
                "SUM(TRY_CAST(MissionaryElectrificationCharge AS DECIMAL(12,2))) AS MissionaryElectrificationCharge, " +
                "SUM(TRY_CAST(EnvironmentalCharge AS DECIMAL(12,2))) AS EnvironmentalCharge, " +
                "SUM(TRY_CAST(StrandedContractCosts AS DECIMAL(12,2))) AS StrandedContractCosts, " +
                "SUM(TRY_CAST(NPCStrandedDebt AS DECIMAL(12,2))) AS NPCStrandedDebt, " +
                "SUM(TRY_CAST(FeedInTariffAllowance AS DECIMAL(12,2))) AS FeedInTariffAllowance, " +
                "SUM(TRY_CAST(MissionaryElectrificationREDCI AS DECIMAL(12,2))) AS MissionaryElectrificationREDCI, " +
                "SUM(TRY_CAST(GenerationVAT AS DECIMAL(12,2))) AS GenerationVAT, " +
                "SUM(TRY_CAST(TransmissionVAT AS DECIMAL(12,2))) AS TransmissionVAT, " +
                "SUM(TRY_CAST(SystemLossVAT AS DECIMAL(12,2))) AS SystemLossVAT, " +
                "SUM(TRY_CAST(DistributionVAT AS DECIMAL(12,2))) AS DistributionVAT, " +
                "SUM(TRY_CAST(RealPropertyTax AS DECIMAL(12,2))) AS RealPropertyTax, " +
                "SUM(TRY_CAST(OtherGenerationRateAdjustment AS DECIMAL(12,2))) AS OtherGenerationRateAdjustment, " +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKW AS DECIMAL(12,2))) AS OtherTransmissionCostAdjustmentKW, " +
                "SUM(TRY_CAST(OtherTransmissionCostAdjustmentKWH AS DECIMAL(12,2))) AS OtherTransmissionCostAdjustmentKWH, " +
                "SUM(TRY_CAST(OtherSystemLossCostAdjustment AS DECIMAL(12,2))) AS OtherSystemLossCostAdjustment, " +
                "SUM(TRY_CAST(OtherLifelineRateCostAdjustment AS DECIMAL(12,2))) AS OtherLifelineRateCostAdjustment, " +
                "SUM(TRY_CAST(SeniorCitizenDiscountAndSubsidyAdjustment AS DECIMAL(12,2))) AS SeniorCitizenDiscountAndSubsidyAdjustment, " +
                "SUM(TRY_CAST(FranchiseTax AS DECIMAL(12,2))) AS FranchiseTax, " +
                "SUM(TRY_CAST(BusinessTax AS DECIMAL(12,2))) AS BusinessTax, " +
                "SUM(TRY_CAST(Form2307Amount AS DECIMAL(12,2))) AS Form2307Amount, " +
                "SUM(TRY_CAST(DeductedDeposit AS DECIMAL(12,2))) AS DeductedDeposit, " +
                "SUM(TRY_CAST(ExcessDeposit AS DECIMAL(12,2))) AS ExcessDeposit, " +
                "SUM(TRY_CAST(Evat2Percent AS DECIMAL(12,2))) AS Evat2Percent, " +
                "SUM(TRY_CAST(Evat5Percent AS DECIMAL(12,2))) AS Evat5Percent, " +
                "SUM(TRY_CAST(KatasNgVat AS DECIMAL(12,2))) AS KatasNgVat, " +
                "SUM(TRY_CAST(SolarImportPresent AS DECIMAL(12,2))) AS SolarImportPresent, " +
                "SUM(TRY_CAST(SolarImportPrevious AS DECIMAL(12,2))) AS SolarImportPrevious, " +
                "SUM(TRY_CAST(SolarExportPresent AS DECIMAL(12,2))) AS SolarExportPresent, " +
                "SUM(TRY_CAST(SolarExportPrevious AS DECIMAL(12,2))) AS SolarExportPrevious, " +
                "SUM(TRY_CAST(SolarImportKwh AS DECIMAL(12,2))) AS SolarImportKwh, " +
                "SUM(TRY_CAST(SolarExportKwh AS DECIMAL(12,2))) AS SolarExportKwh, " +
                "SUM(TRY_CAST(GenerationChargeSolarExport AS DECIMAL(12,2))) AS GenerationChargeSolarExport, " +
                "SUM(TRY_CAST(SolarResidualCredit AS DECIMAL(12,2))) AS SolarResidualCredit, " +
                "SUM(TRY_CAST(SolarDemandChargeKW AS DECIMAL(12,2))) AS SolarDemandChargeKW, " +
                "SUM(TRY_CAST(SolarDemandChargeKWH AS DECIMAL(12,2))) AS SolarDemandChargeKWH, " +
                "SUM(TRY_CAST(SolarRetailCustomerCharge AS DECIMAL(12,2))) AS SolarRetailCustomerCharge, " +
                "SUM(TRY_CAST(SolarSupplySystemCharge AS DECIMAL(12,2))) AS SolarSupplySystemCharge, " +
                "SUM(TRY_CAST(SolarMeteringRetailCharge AS DECIMAL(12,2))) AS SolarMeteringRetailCharge, " +
                "SUM(TRY_CAST(SolarMeteringSystemCharge AS DECIMAL(12,2))) AS SolarMeteringSystemCharge, " +
                "SUM(TRY_CAST(ACRM AS DECIMAL(12,2))) AS ACRM, " +
                "SUM(TRY_CAST(PowerActReduction AS DECIMAL(12,2))) AS PowerActReduction, " +
                "SUM(TRY_CAST(ACRMVAT AS DECIMAL(12,2))) AS ACRMVAT, " +
                "SUM(TRY_CAST(MissionaryElectrificationSPUG AS DECIMAL(12,2))) AS MissionaryElectrificationSPUG, " +
                "SUM(TRY_CAST(MissionaryElectrificationSPUGTRUEUP AS DECIMAL(12,2))) AS MissionaryElectrificationSPUGTRUEUP, " +
                "SUM(TRY_CAST(FranchiseTaxOthers AS DECIMAL(12,2))) AS FranchiseTaxOthers, " +
                "SUM(TRY_CAST(OthersVAT AS DECIMAL(12,2))) AS OthersVAT, " +
                "SUM(TRY_CAST(AdvancedMaterialDeposit AS DECIMAL(12,2))) AS AdvancedMaterialDeposit, " +
                "SUM(TRY_CAST(CustomerDeposit AS DECIMAL(12,2))) AS CustomerDeposit, " +
                "SUM(TRY_CAST(TransformerRental AS DECIMAL(12,2))) AS TransformerRental, " +
                "SUM(TRY_CAST(TermedPayments AS DECIMAL(12,2))) AS TermedPayments " +
                "FROM Cashier_BillMirror " +
                "WHERE AccountNumber=? AND ServicePeriod=?  " +
                "GROUP BY AccountNumber, ServicePeriod";
            
            PreparedStatement ps = connection.prepareStatement(stmt);
            ps.setString(1, acctNo);
            ps.setString(2, period);
            ResultSet rs = ps.executeQuery();
            
            bill.setAccountNumber(acctNo);
            bill.setServicePeriod(period);
            if (rs.next()) {
                bill.setGenerationSystemCharge (rs.getString("GenerationSystemCharge"));
                bill.setTransmissionDeliveryChargeKW (rs.getString("TransmissionDeliveryChargeKW"));
                bill.setTransmissionDeliveryChargeKWH (rs.getString("TransmissionDeliveryChargeKWH"));
                bill.setSystemLossCharge (rs.getString("SystemLossCharge"));
                bill.setDistributionDemandCharge (rs.getString("DistributionDemandCharge"));
                bill.setDistributionSystemCharge (rs.getString("DistributionSystemCharge"));
                bill.setSupplyRetailCustomerCharge (rs.getString("SupplyRetailCustomerCharge"));
                bill.setSupplySystemCharge (rs.getString("SupplySystemCharge"));
                bill.setMeteringRetailCustomerCharge (rs.getString("MeteringRetailCustomerCharge"));
                bill.setMeteringSystemCharge (rs.getString("MeteringSystemCharge"));
                bill.setRFSC (rs.getString("RFSC"));
                bill.setLifelineRate (rs.getString("LifelineRate"));
                bill.setInterClassCrossSubsidyCharge (rs.getString("InterClassCrossSubsidyCharge"));
                bill.setPPARefund (rs.getString("PPARefund"));
                bill.setSeniorCitizenSubsidy (rs.getString("SeniorCitizenSubsidy"));
                bill.setMissionaryElectrificationCharge (rs.getString("MissionaryElectrificationCharge"));
                bill.setEnvironmentalCharge (rs.getString("EnvironmentalCharge"));
                bill.setStrandedContractCosts (rs.getString("StrandedContractCosts"));
                bill.setNPCStrandedDebt (rs.getString("NPCStrandedDebt"));
                bill.setFeedInTariffAllowance (rs.getString("FeedInTariffAllowance"));
                bill.setMissionaryElectrificationREDCI (rs.getString("MissionaryElectrificationREDCI"));
                bill.setGenerationVAT (rs.getString("GenerationVAT"));
                bill.setTransmissionVAT (rs.getString("TransmissionVAT"));
                bill.setSystemLossVAT (rs.getString("SystemLossVAT"));
                bill.setDistributionVAT (rs.getString("DistributionVAT"));
                bill.setRealPropertyTax (rs.getString("RealPropertyTax"));
                bill.setOtherGenerationRateAdjustment (rs.getString("OtherGenerationRateAdjustment"));
                bill.setOtherTransmissionCostAdjustmentKW (rs.getString("OtherTransmissionCostAdjustmentKW"));
                bill.setOtherTransmissionCostAdjustmentKWH (rs.getString("OtherTransmissionCostAdjustmentKWH"));
                bill.setOtherSystemLossCostAdjustment (rs.getString("OtherSystemLossCostAdjustment"));
                bill.setOtherLifelineRateCostAdjustment (rs.getString("OtherLifelineRateCostAdjustment"));
                bill.setSeniorCitizenDiscountAndSubsidyAdjustment (rs.getString("SeniorCitizenDiscountAndSubsidyAdjustment"));
                bill.setFranchiseTax (rs.getString("FranchiseTax"));
                bill.setBusinessTax (rs.getString("BusinessTax"));
                bill.setForm2307Amount (rs.getString("Form2307Amount"));
                bill.setDeductedDeposit (rs.getString("DeductedDeposit"));
                bill.setExcessDeposit (rs.getString("ExcessDeposit"));
                bill.setEvat2Percent (rs.getString("Evat2Percent"));
                bill.setEvat5Percent (rs.getString("Evat5Percent"));
                bill.setKatasNgVat (rs.getString("KatasNgVat"));
                bill.setSolarImportPresent (rs.getString("SolarImportPresent"));
                bill.setSolarImportPrevious (rs.getString("SolarImportPrevious"));
                bill.setSolarExportPresent (rs.getString("SolarExportPresent"));
                bill.setSolarExportPrevious (rs.getString("SolarExportPrevious"));
                bill.setSolarImportKwh (rs.getString("SolarImportKwh"));
                bill.setSolarExportKwh (rs.getString("SolarExportKwh"));
                bill.setGenerationChargeSolarExport (rs.getString("GenerationChargeSolarExport"));
                bill.setSolarResidualCredit (rs.getString("SolarResidualCredit"));
                bill.setSolarDemandChargeKW (rs.getString("SolarDemandChargeKW"));
                bill.setSolarDemandChargeKWH (rs.getString("SolarDemandChargeKWH"));
                bill.setSolarRetailCustomerCharge (rs.getString("SolarRetailCustomerCharge"));
                bill.setSolarSupplySystemCharge (rs.getString("SolarSupplySystemCharge"));
                bill.setSolarMeteringRetailCharge (rs.getString("SolarMeteringRetailCharge"));
                bill.setSolarMeteringSystemCharge (rs.getString("SolarMeteringSystemCharge"));
                bill.setACRM (rs.getString("ACRM"));
                bill.setPowerActReduction (rs.getString("PowerActReduction"));
                bill.setACRMVAT (rs.getString("ACRMVAT"));
                bill.setMissionaryElectrificationSPUG (rs.getString("MissionaryElectrificationSPUG"));
                bill.setMissionaryElectrificationSPUGTRUEUP (rs.getString("MissionaryElectrificationSPUGTRUEUP"));
                bill.setFranchiseTaxOthers (rs.getString("FranchiseTaxOthers"));
                bill.setOthersVAT (rs.getString("OthersVAT"));
                bill.setAdvancedMaterialDeposit (rs.getString("AdvancedMaterialDeposit"));
                bill.setCustomerDeposit (rs.getString("CustomerDeposit"));
                bill.setTransformerRental (rs.getString("TransformerRental"));
                bill.setTermedPayments (rs.getString("TermedPayments"));
            } else {
                bill.setGenerationSystemCharge ("0");
                bill.setTransmissionDeliveryChargeKW ("0");
                bill.setTransmissionDeliveryChargeKWH ("0");
                bill.setSystemLossCharge ("0");
                bill.setDistributionDemandCharge ("0");
                bill.setDistributionSystemCharge ("0");
                bill.setSupplyRetailCustomerCharge ("0");
                bill.setSupplySystemCharge ("0");
                bill.setMeteringRetailCustomerCharge ("0");
                bill.setMeteringSystemCharge ("0");
                bill.setRFSC ("0");
                bill.setLifelineRate ("0");
                bill.setInterClassCrossSubsidyCharge ("0");
                bill.setPPARefund ("0");
                bill.setSeniorCitizenSubsidy ("0");
                bill.setMissionaryElectrificationCharge ("0");
                bill.setEnvironmentalCharge ("0");
                bill.setStrandedContractCosts ("0");
                bill.setNPCStrandedDebt ("0");
                bill.setFeedInTariffAllowance ("0");
                bill.setMissionaryElectrificationREDCI ("0");
                bill.setGenerationVAT ("0");
                bill.setTransmissionVAT ("0");
                bill.setSystemLossVAT ("0");
                bill.setDistributionVAT ("0");
                bill.setRealPropertyTax ("0");
                bill.setOtherGenerationRateAdjustment ("0");
                bill.setOtherTransmissionCostAdjustmentKW ("0");
                bill.setOtherTransmissionCostAdjustmentKWH ("0");
                bill.setOtherSystemLossCostAdjustment ("0");
                bill.setOtherLifelineRateCostAdjustment ("0");
                bill.setSeniorCitizenDiscountAndSubsidyAdjustment ("0");
                bill.setFranchiseTax ("0");
                bill.setBusinessTax ("0");
                bill.setForm2307Amount ("0");
                bill.setDeductedDeposit ("0");
                bill.setExcessDeposit ("0");
                bill.setEvat2Percent ("0");
                bill.setEvat5Percent ("0");
                bill.setKatasNgVat ("0");
                bill.setSolarImportPresent ("0");
                bill.setSolarImportPrevious ("0");
                bill.setSolarExportPresent ("0");
                bill.setSolarExportPrevious ("0");
                bill.setSolarImportKwh ("0");
                bill.setSolarExportKwh ("0");
                bill.setGenerationChargeSolarExport ("0");
                bill.setSolarResidualCredit ("0");
                bill.setSolarDemandChargeKW ("0");
                bill.setSolarDemandChargeKWH ("0");
                bill.setSolarRetailCustomerCharge ("0");
                bill.setSolarSupplySystemCharge ("0");
                bill.setSolarMeteringRetailCharge ("0");
                bill.setSolarMeteringSystemCharge ("0");
                bill.setACRM ("0");
                bill.setPowerActReduction ("0");
                bill.setACRMVAT ("0");
                bill.setMissionaryElectrificationSPUG ("0");
                bill.setMissionaryElectrificationSPUGTRUEUP ("0");
                bill.setFranchiseTaxOthers ("0");
                bill.setOthersVAT ("0");
                bill.setAdvancedMaterialDeposit ("0");
                bill.setCustomerDeposit ("0");
                bill.setTransformerRental ("0");
                bill.setTermedPayments ("0");
            }
            
            rs.close();
            ps.close();
            return bill;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
