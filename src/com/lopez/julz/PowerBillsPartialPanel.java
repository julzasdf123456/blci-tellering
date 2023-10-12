/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lopez.julz;

import db.BillMirrorDao;
import db.BillsDao;
import db.CollectiblesDao;
import db.CollectionDateAdjustmentsDao;
import db.DCRSummaryTransactionsDao;
import db.DatabaseConnection;
import db.OCLMonthlyDao;
import db.ORAssigningDao;
import db.PaidBillDetailsDao;
import db.PaidBillsDao;
import db.ServiceAccountsDao;
import helpers.Auth;
import helpers.ConfigFileHelpers;
import helpers.Notifiers;
import helpers.ObjectHelpers;
import helpers.PowerBillPrint;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.math.RoundingMode;
import java.net.URI;
import java.sql.Connection;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.NumberFormatter;
import pojos.BillMirror;
import pojos.Bills;
import pojos.CheckPayments;
import pojos.Collectibles;
import pojos.DCRSummaryTransactions;
import pojos.OCLMonthly;
import pojos.ORAssigning;
import pojos.PaidBills;
import pojos.Server;
import pojos.ServiceAccounts;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author julza
 */
public class PowerBillsPartialPanel extends javax.swing.JPanel {
    
    public pojos.Login login;
    String orNumber;
    
    public Server server;
    public String office;
    String officeCode;
    
    public DatabaseConnection db;
    public Connection connection;
    
    /**
     * ACTIVE SELECTIONS
     */
    public ServiceAccounts activeAccount;
    public List<Bills> billsList;
    public List<Bills> selectedBills;
    
    /**
     * Bills Table 
     */
    Object[] columnNames = {"*", "Bill Number", "Billing Month", "Due Date", "Amount Due", "Surcharge", "Billed Amount", "Others", "Total Amount Due"};
    DefaultTableModel model;
    
    /**
     * Paid bills area
     */
    public ORAssigning currentOr;
    int nextOrNumber = 0;
    double totalAmountPayable = 0;
    double totalSurcharge = 0;
    double suggestedPartial = 0;
    
    /**
     * Checks
     */
    public List<CheckPayments> checkLists;
    Object[] checkColNames = {"Bank", "Check No", "Amount"};
    DefaultTableModel checkModel;
    
    boolean isOrLocked = true;

    /**
     * Creates new form PowerBillsPartialPanel
     */
    public PowerBillsPartialPanel(pojos.Login login, String orNumber) {
        this.orNumber = orNumber;
        this.login = login;
        initComponents();
        
        server = ConfigFileHelpers.getServer();
        office = ConfigFileHelpers.getOffice();
        officeCode = ConfigFileHelpers.getOfficeCode();
    
        db = new DatabaseConnection();
        connection = db.getDbConnectionFromDatabase(server);
        
//        accountNumberSearch.setValue(officeCode); 
        accountNumberSearch.requestFocus();
//        accountNumberSearch.addFocusListener(new FocusAdapter() {
//            @Override
//            public void focusGained(FocusEvent arg0) {
//                EventQueue.invokeLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        accountNumberSearch.setCaretPosition(2);
//                    }
//                });
//            }
//        });
        
        billsList = new ArrayList<>();
        selectedBills = new ArrayList<>();
        fetchOR();
        
        checkLists = new ArrayList<>();
    }
    
    public pojos.Login getLogin() {
        return login;
    }

    public void setLogin(pojos.Login login) {
        this.login = login;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        accountNumber = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        meterNumber = new javax.swing.JTextField();
        clearBtn = new javax.swing.JButton();
        viewAccountButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        billsTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        orNumberField = new javax.swing.JTextField();
        unlockOrNumberBtn = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        orDateField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        NumberFormat format = NumberFormat.getInstance();
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        format.setRoundingMode(RoundingMode.HALF_UP);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Double.class);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        cashPaymentField = new javax.swing.JFormattedTextField(formatter);
        jScrollPane2 = new javax.swing.JScrollPane();
        checkTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        addCheckButton = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        totalAmountPaid = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        transactBtn = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        clearChecksBtn = new javax.swing.JButton();
        NumberFormat partialFormat = NumberFormat.getInstance();
        partialFormat.setMinimumFractionDigits(2);
        partialFormat.setMaximumFractionDigits(2);
        partialFormat.setRoundingMode(RoundingMode.HALF_UP);
        NumberFormatter partialFormatter = new NumberFormatter(partialFormat);
        partialFormatter.setValueClass(Double.class);
        partialFormatter.setAllowsInvalid(false);
        partialFormatter.setCommitsOnValidEdit(true);
        suggestedPartialAmount = new javax.swing.JFormattedTextField(partialFormatter);
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        advancedSearch = new javax.swing.JButton();
        consumerNameField = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        acctStatus = new javax.swing.JTextField();
        consumerAddress = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        accountType = new javax.swing.JTextField();
        accountNumberSearch = new javax.swing.JFormattedTextField();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/request_quote_FILL1_wght400_GRAD0_opsz24.png"))); // NOI18N
        jLabel1.setText("Power Bills Payment (Partial Payments)");
        jLabel1.setIconTextGap(10);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Account Type:");

        accountNumber.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        meterNumber.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        clearBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 51, 0));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        viewAccountButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        viewAccountButton.setForeground(new java.awt.Color(0, 153, 153));
        viewAccountButton.setText("View Account");
        viewAccountButton.setEnabled(false);
        viewAccountButton.setMaximumSize(new java.awt.Dimension(97, 26));
        viewAccountButton.setMinimumSize(new java.awt.Dimension(97, 26));
        viewAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAccountButtonActionPerformed(evt);
            }
        });

        billsTable.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        billsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        billsTable.setRowHeight(28);
        jScrollPane1.setViewportView(billsTable);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Account Number:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment Config", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 51, 0))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("OR Number");

        orNumberField.setFont(new java.awt.Font("Arial", 1, 23)); // NOI18N
        orNumberField.setForeground(new java.awt.Color(204, 0, 0));
        orNumberField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        orNumberField.setEnabled(false);

        unlockOrNumberBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lock_open_FILL1_wght400_GRAD0_opsz20.png"))); // NOI18N
        unlockOrNumberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unlockOrNumberBtnActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("OR Date");

        orDateField.setFont(new java.awt.Font("Arial", 1, 23)); // NOI18N
        orDateField.setForeground(new java.awt.Color(204, 0, 0));
        orDateField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        orDateField.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(unlockOrNumberBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                        .addGap(63, 63, 63)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(unlockOrNumberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Consumer Name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Search Acount No:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Meter Number:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Cash Payment");

        cashPaymentField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        cashPaymentField.setEnabled(false);
        cashPaymentField.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cashPaymentField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cashPaymentFieldKeyReleased(evt);
            }
        });

        checkTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(checkTable);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Check Payments");

        addCheckButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        addCheckButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_FILL1_wght400_GRAD0_opsz20.png"))); // NOI18N
        addCheckButton.setText("Add Check");
        addCheckButton.setEnabled(false);
        addCheckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCheckButtonActionPerformed(evt);
            }
        });

        totalAmountPaid.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        totalAmountPaid.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalAmountPaid.setEnabled(false);
        totalAmountPaid.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Total Amount Paid");

        transactBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        transactBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/check_circle_FILL1_wght400_GRAD0_opsz20.png"))); // NOI18N
        transactBtn.setText("Transact");
        transactBtn.setFocusable(false);
        transactBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactBtnActionPerformed(evt);
            }
        });

        clearChecksBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        clearChecksBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_FILL1_wght400_GRAD0_opsz20.png"))); // NOI18N
        clearChecksBtn.setText("Clear Checks");
        clearChecksBtn.setEnabled(false);
        clearChecksBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearChecksBtnActionPerformed(evt);
            }
        });

        suggestedPartialAmount.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        suggestedPartialAmount.setEnabled(false);
        suggestedPartialAmount.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        suggestedPartialAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                suggestedPartialAmountKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Suggested Partial");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalAmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(46, 46, 46)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addCheckButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearChecksBtn))
                            .addComponent(cashPaymentField, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(transactBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(suggestedPartialAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suggestedPartialAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cashPaymentField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(addCheckButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearChecksBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalAmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transactBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Consumer Address:");

        advancedSearch.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advancedSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/travel_explore_FILL0_wght700_GRAD0_opsz20.png"))); // NOI18N
        advancedSearch.setText("Advanced Search");
        advancedSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advancedSearchActionPerformed(evt);
            }
        });

        consumerNameField.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        acctStatus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        consumerAddress.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Status:");

        accountType.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        accountNumberSearch.setForeground(new java.awt.Color(204, 0, 0));
        try {
            accountNumberSearch.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        accountNumberSearch.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        accountNumberSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                accountNumberSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(accountNumberSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(advancedSearch))
                    .addComponent(jSeparator3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(consumerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(consumerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(meterNumber)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accountType, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(acctStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(viewAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearBtn)))
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(advancedSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(accountNumberSearch)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(consumerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(accountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(accountType, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(acctStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(consumerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6)
                        .addComponent(meterNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(viewAccountButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        resetForm();
        accountNumberSearch.setValue(officeCode);
        consumerNameField.setText("");
        accountNumber.setText("");
        accountType.setText("");
        consumerAddress.setText("");
        acctStatus.setText("");
        meterNumber.setText("");
        cashPaymentField.setValue(null);
        cashPaymentField.setEnabled(false);
        addCheckButton.setEnabled(false);
        clearChecksBtn.setEnabled(false);
        if (checkModel != null) {
            checkModel.getDataVector().removeAllElements();
            checkModel.fireTableDataChanged();
        }
        if (model != null) {
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
        }
        accountNumberSearch.requestFocus();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void viewAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAccountButtonActionPerformed
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            if (activeAccount != null) {
                try {
                    Desktop.getDesktop().browse(new URI(ConfigFileHelpers.VIEW_ACCOUNT_URL + activeAccount.getId()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_viewAccountButtonActionPerformed

    private void unlockOrNumberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unlockOrNumberBtnActionPerformed
        if (isOrLocked) {
            orNumberField.setEnabled(true);
            isOrLocked = false;
        } else {
            orNumberField.setEnabled(false);
            isOrLocked = true;
        }
    }//GEN-LAST:event_unlockOrNumberBtnActionPerformed

    private void cashPaymentFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashPaymentFieldKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int selectedSize = selectedBills.size();
            if (selectedSize > 1) {
                Notifiers.showErrorMessage("One-at-a-Time Rule", "Multiple partial payments at once is not allowed. Select one bill only.");
            } else if (selectedSize < 1) {
                Notifiers.showErrorMessage("One-at-a-Time Rule", "Please select at least 1 (one) bill.");
            } else {
                if (getTotalAmount() < suggestedPartial) {
                    Notifiers.showErrorMessage("Insufficient Partial Amount", "Insufficient partial amount provided!");
                } else {
                    showTransactConfirmation();                
                }
            }
        } else {
            totalAmountPaid.setValue(getTotalAmount());
        }
    }//GEN-LAST:event_cashPaymentFieldKeyReleased

    private void addCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCheckButtonActionPerformed
        try {
            cashPaymentField.setValue(null);

            JDialog checkDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(getParent()));
            Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) size.getWidth();
            int y = (int) size.getHeight();
            checkDialog.setLocation(x/3, y/3);
            checkDialog.setTitle("Add Check");

            JPanel mainPanel = new JPanel(new GridLayout(0, 1, 0, 5));
            mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

            mainPanel.add(new JLabel("Input Check Number"));
            JTextField checkNoField = new JTextField();
            checkNoField.setPreferredSize(new Dimension(400, 36));
            checkNoField.setFont(new Font("Arial", Font.BOLD, 16));
            mainPanel.add(checkNoField);

            mainPanel.add(new JLabel("Input Check Amount"));
            NumberFormat format = NumberFormat.getInstance();
            format.setMinimumFractionDigits(2);
            format.setMaximumFractionDigits(2);
            format.setRoundingMode(RoundingMode.HALF_UP);
            NumberFormatter formatter = new NumberFormatter(format);
            formatter.setValueClass(Double.class);
            formatter.setAllowsInvalid(false);
            formatter.setCommitsOnValidEdit(true);
            JFormattedTextField amountField = new JFormattedTextField(formatter);
            amountField.setPreferredSize(new Dimension(400, 36));
            amountField.setFont(new Font("Arial", Font.BOLD, 16));
            amountField.setHorizontalAlignment(JTextField.RIGHT);
            amountField.setValue(getCashRemainFromCheck());
            amountField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            amountField.selectAll();
                        }
                    });
                }
            });
            mainPanel.add(amountField);

            mainPanel.add(new JLabel("Input Bank"));
            JTextField checkBank = new JTextField();
            checkBank.setPreferredSize(new Dimension(400, 36));
            checkBank.setFont(new Font("Arial", Font.BOLD, 16));
            mainPanel.add(checkBank);

            JButton saveCheckBtn = new JButton("Add Check");
            saveCheckBtn.setFont(new Font("Arial", Font.PLAIN, 12));
            saveCheckBtn.setPreferredSize(new Dimension(100, 32));
            saveCheckBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/check_circle_FILL1_wght400_GRAD0_opsz20.png")));
            mainPanel.add(saveCheckBtn);

            checkNoField.addKeyListener(new KeyListener() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        amountField.requestFocus();
                    }
                }

                @Override
                public void keyTyped(KeyEvent e) {
                }
                @Override
                public void keyPressed(KeyEvent e) {
                }
            });

            amountField.addKeyListener(new KeyListener() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        checkBank.requestFocus();
                    }
                }

                @Override
                public void keyTyped(KeyEvent e) {
                }
                @Override
                public void keyPressed(KeyEvent e) {
                }
            });

            checkBank.addKeyListener(new KeyListener() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        checkLists.add(new CheckPayments(
                            ObjectHelpers.generateIDandRandString(),
                            activeAccount.getId(),
                            null,
                            null,
                            orNumberField.getText(),
                            amountField.getValue().toString(),
                            "Check",
                            checkNoField.getText(),
                            checkBank.getText(),
                            null,
                            login.getId(),
                            ObjectHelpers.getCurrentTimestamp(),
                            ObjectHelpers.getCurrentTimestamp()
                        ));

                        populateCheckTable();
                        checkDialog.dispose();
                        transactBtn.requestFocus();
                        totalAmountPaid.setValue(getTotalAmount());
                    }
                }

                @Override
                public void keyTyped(KeyEvent e) {
                }
                @Override
                public void keyPressed(KeyEvent e) {
                }
            });

            saveCheckBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkLists.add(new CheckPayments(
                        ObjectHelpers.generateIDandRandString(),
                        activeAccount.getId(),
                        null,
                        null,
                        orNumberField.getText(),
                        amountField.getValue().toString(),
                        "Check",
                        checkNoField.getText(),
                        checkBank.getText(),
                        null,
                        login.getId(),
                        ObjectHelpers.getCurrentTimestamp(),
                        ObjectHelpers.getCurrentTimestamp()
                    ));

                    populateCheckTable();
                    checkDialog.dispose();
                    transactBtn.requestFocus();
                    totalAmountPaid.setValue(getTotalAmount());
                }
            });

            checkDialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    if(getCashRemainFromCheck() > 0) {
                        //                        addCheckButton.setEnabled(false);
                        cashPaymentField.setValue(getCashRemainFromCheck());
                    }
                }

                @Override
                public void windowClosed(WindowEvent e) {
                    if(getCashRemainFromCheck() > 0) {
                        //                        addCheckButton.setEnabled(false);
                        cashPaymentField.setValue(getCashRemainFromCheck());
                    }
                }
            });

            checkDialog.add(mainPanel);
            checkDialog.pack();
            checkDialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Adding Check Payment", e.getMessage());
        }
    }//GEN-LAST:event_addCheckButtonActionPerformed

    private void transactBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactBtnActionPerformed
        int selectedSize = selectedBills.size();
        if (selectedSize > 1) {
            Notifiers.showErrorMessage("One-at-a-Time Rule", "Multiple partial payments at once is not allowed. Select one bill only.");
        } else if (selectedSize < 1) {
            Notifiers.showErrorMessage("One-at-a-Time Rule", "Please select at least 1 (one) bill.");
        } else {
            if (getTotalAmount() < suggestedPartial) {
                Notifiers.showErrorMessage("Insufficient Partial Amount", "Insufficient partial amount provided!");
            } else {
                showTransactConfirmation();                
            }
        }
    }//GEN-LAST:event_transactBtnActionPerformed

    private void clearChecksBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearChecksBtnActionPerformed
        checkLists.clear();
        cashPaymentField.setValue(totalAmountPayable + totalSurcharge);
        totalAmountPaid.setValue(getTotalAmount());
        addCheckButton.setEnabled(true);
        transactBtn.requestFocus();
        if (checkModel != null) {
            checkModel.getDataVector().removeAllElements();
            checkModel.fireTableDataChanged();
        }
    }//GEN-LAST:event_clearChecksBtnActionPerformed

    private void advancedSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advancedSearchActionPerformed
        advancedSearch();
    }//GEN-LAST:event_advancedSearchActionPerformed

    private void accountNumberSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accountNumberSearchKeyReleased
        String acctNo = accountNumberSearch.getText().trim();
        if (acctNo.length() == 8) {
            getAccountByOldAccountNo(acctNo);
        }
    }//GEN-LAST:event_accountNumberSearchKeyReleased

    private void suggestedPartialAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suggestedPartialAmountKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_suggestedPartialAmountKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountNumber;
    private javax.swing.JFormattedTextField accountNumberSearch;
    private javax.swing.JTextField accountType;
    private javax.swing.JTextField acctStatus;
    private javax.swing.JButton addCheckButton;
    private javax.swing.JButton advancedSearch;
    private javax.swing.JTable billsTable;
    private javax.swing.JFormattedTextField cashPaymentField;
    private javax.swing.JTable checkTable;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton clearChecksBtn;
    private javax.swing.JTextField consumerAddress;
    private javax.swing.JTextField consumerNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField meterNumber;
    private javax.swing.JTextField orDateField;
    private javax.swing.JTextField orNumberField;
    private javax.swing.JFormattedTextField suggestedPartialAmount;
    private javax.swing.JFormattedTextField totalAmountPaid;
    private javax.swing.JButton transactBtn;
    private javax.swing.JButton unlockOrNumberBtn;
    private javax.swing.JButton viewAccountButton;
    // End of variables declaration//GEN-END:variables

    public void resetForm() {
        billsList.clear();
        selectedBills.clear();
        totalAmountPayable = 0;
        totalSurcharge = 0;
        suggestedPartial = 0;
        checkLists.clear();
        viewAccountButton.setEnabled(false);
    }
    
    public void getAccountByOldAccountNo(String oldAccountNo) {
        try {
            activeAccount = ServiceAccountsDao.getOneByOldAccountNumber(connection, oldAccountNo);
            
            resetForm();
            
            if (activeAccount != null) {
                viewAccountButton.setEnabled(true);
                addCheckButton.setEnabled(true);
                cashPaymentField.setEnabled(true);
                populateConsumerData();
                populateBillsTable();
            } else {
                addCheckButton.setEnabled(false);
                Notifiers.showErrorMessage("Account Not Found", "Account not found! Verify the account number you inputted.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Fetching Account", e.getMessage());
        }
    }
    
    public void populateConsumerData() {
        try {
            consumerNameField.setText(activeAccount.getServiceAccountName());
            accountNumber.setText(activeAccount.getOldAccountNo());
            accountType.setText(activeAccount.getAccountType());
            consumerAddress.setText(ServiceAccountsDao.getAddress(activeAccount));
            acctStatus.setText(activeAccount.getAccountStatus());
            if (activeAccount.getAccountStatus() != null && !activeAccount.getAccountStatus().equals("ACTIVE")) {
                acctStatus.setForeground(Color.red);
                JOptionPane.showMessageDialog(null, "This Account is " + activeAccount.getAccountStatus(), "WARNING", JOptionPane.WARNING_MESSAGE);
            } else {
                acctStatus.setForeground(Color.black);
            }
            meterNumber.setText(activeAccount.getMeterDetailsId());
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Populating Account Details", e.getMessage());
        }
    }
    
    public void populateBillsTable() {
        try {
            // PREPARE BILLS DATA
            billsList.addAll(BillsDao.getUnpaidBillsFromAccountId(connection, activeAccount.getId()));
            
            int billsSize = billsList.size();
            Object[][] data = new Object[billsSize][columnNames.length];
            for (int i=0; i<billsSize; i++) {
                Bills bill = billsList.get(i);
                Bills paidPartials = null;
                if (!ObjectHelpers.isAfterDue(bill)) {
                    data[i][0] = true;
                    paidPartials = BillMirrorDao.getPaidCharges(connection, bill.getAccountNumber(), bill.getServicePeriod());
                    if (paidPartials != null) {
                        suggestedPartial += ObjectHelpers.doubleStringNull(bill.getTermedPayments()) - ObjectHelpers.doubleStringNull(paidPartials.getTermedPayments());
                    } else {
                        suggestedPartial += ObjectHelpers.doubleStringNull(bill.getTermedPayments());
                    }
                } else { 
                    paidPartials = null;
                    data[i][0] = false;
                }
                double surcharge = Double.valueOf(ObjectHelpers.roundFourNoComma(BillsDao.getSurcharge(bill) + ""));
                bill.setAdditionalKwh(surcharge + "");
                data[i][1] = bill.getBillNumber();
                data[i][2] = ObjectHelpers.formatReadableDate(bill.getServicePeriod());
                data[i][3] = bill.getDueDate();
                data[i][4] = ObjectHelpers.roundTwo(bill.getNetAmount());
                data[i][5] = ObjectHelpers.roundTwo(surcharge + "");
                if (paidPartials != null) {     
                    double billedRemain = BillsDao.getBilledAmount(bill) - BillsDao.getBilledAmount(paidPartials);
                    double othersRemain = BillsDao.getOthersAmount(bill) - BillsDao.getOthersAmount(paidPartials);
                    data[i][6] = ObjectHelpers.roundTwo(billedRemain + "");
                    data[i][7] = ObjectHelpers.roundTwo(othersRemain + "");
                } else {                    
                    data[i][6] = ObjectHelpers.roundTwo(BillsDao.getBilledAmount(bill) + "");
                    data[i][7] = ObjectHelpers.roundTwo((BillsDao.getOthersAmount(bill) + ObjectHelpers.doubleStringNull(bill.getTermedPayments())) + "");
                }
                data[i][8] = ObjectHelpers.roundTwo(ObjectHelpers.getTotals(ObjectHelpers.doubleStringNull(bill.getBalance()), surcharge));
            }
            
            // DISPLAY TO TABLE
            model = new DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    Bills bill = billsList.get(row);
                    if (ObjectHelpers.isAfterDue(bill)) {
                        return false;
                    } else {
                        if (column == 0) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
                
                @Override
                public Class getColumnClass(int column) {
                    switch (column) {
                        case 0:
                            return Boolean.class;
                        case 1:
                            return String.class;
                        case 2:
                            return String.class;
                        case 3:
                            return String.class;
                        case 4:
                            return String.class;
                        case 5:
                            return String.class;
                        case 8:
                            return String.class;
                        default:
                            return String.class;
                    }
                }
            };
            DefaultTableCellRenderer rightRendererRed = new DefaultTableCellRenderer();
            rightRendererRed.setHorizontalAlignment(JLabel.RIGHT);
            rightRendererRed.setForeground(Color.red);
            
            DefaultTableCellRenderer rightRendererBlue = new DefaultTableCellRenderer();
            rightRendererBlue.setHorizontalAlignment(JLabel.RIGHT);
            rightRendererBlue.setForeground(Color.BLUE);
            
            DefaultTableCellRenderer rightRendererGreen = new DefaultTableCellRenderer();
            rightRendererGreen.setHorizontalAlignment(JLabel.RIGHT);
            rightRendererGreen.setForeground(Color.decode("#00675b"));

            billsTable.setModel(model);
            billsTable.getColumnModel().getColumn(0).setMaxWidth(40);
            billsTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
            billsTable.getModel().addTableModelListener(new TableModelListener() {
                @Override
                public void tableChanged(TableModelEvent e) {
                    try {
                        getSelectedBillsPayablesTotal();
                        cashPaymentField.setValue(totalAmountPayable + totalSurcharge);
                        totalAmountPaid.setValue(getTotalAmount());
                        transactBtn.requestFocus();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });     
            
            billsTable.setDefaultRenderer(Object.class, new DefaultTableCellHeaderRenderer(){
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                    super.getTableCellRendererComponent(table, value, hasFocus, hasFocus, row, row);
                    Bills bill = billsList.get(row);
                    if (ObjectHelpers.isAfterDue(bill)) {
                        setBackground(Color.decode("#989898"));
                        setForeground(Color.BLACK);
                    } else {
                        setFont(new Font("Arial", Font.BOLD, 12));
                        if (column == 4) {
                            setForeground(Color.BLUE);
                        } else if (column == 5) {
                            setForeground(Color.RED);
                        } else if (column == 6 | column == 7) {
                            setForeground(Color.decode("#00968B"));
                        } else if (column == 8) {
                            setForeground(Color.RED);
                        } else {
                            setForeground(Color.BLACK);
                        }
                        setBackground(Color.WHITE);
                    }
                    setValue(value);
                    return this;
                }
            });
            
            // VALIDATE TOTAL AMOUNT SELECTED
            getSelectedBillsPayablesTotal();
            cashPaymentField.setValue(totalAmountPayable + totalSurcharge);
            suggestedPartialAmount.setValue(suggestedPartial);
            totalAmountPaid.setValue(getTotalAmount());
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Bills", e.getMessage());
        }
    }
    
    public void getSelectedBillsPayablesTotal() {
        try {
            totalAmountPayable = 0;
            totalSurcharge = 0;
            selectedBills.clear();
        
            for (int i = 0; i < model.getRowCount(); i++) {
                if ((Boolean) model.getValueAt(i,0)) {  
                    totalSurcharge += (billsList.get(i).getAdditionalKwh() != null ? Double.valueOf(billsList.get(i).getAdditionalKwh()) : 0);
                    totalAmountPayable += Double.valueOf(billsList.get(i).getBalance());
                    selectedBills.add(billsList.get(i));
                }
            }
            
            cashPaymentField.requestFocus();
            selectCashAmount();
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Payables from Bills Table", e.getMessage());
        }
    }
    
    public void populateCheckTable() {
        try {
            clearChecksBtn.setEnabled(true);
            if (checkModel != null) {
                checkModel.getDataVector().removeAllElements();
                checkModel.fireTableDataChanged();
            }
            
            int checklistsize = checkLists.size();
            Object[][] data = new Object[checklistsize][checkColNames.length];
            for (int i=0; i<checklistsize; i++) {
                data[i][0] = checkLists.get(i).getBank();
                data[i][1] = checkLists.get(i).getCheckNo();
                data[i][2] = ObjectHelpers.roundTwo(checkLists.get(i).getAmount());
            }
            
            // DISPLAY TO TABLE
            checkModel = new DefaultTableModel(data, checkColNames);
            DefaultTableCellRenderer rightRendererBlue = new DefaultTableCellRenderer();
            rightRendererBlue.setHorizontalAlignment(JLabel.RIGHT);
            rightRendererBlue.setFont(new Font("Arial", Font.BOLD, 14));
            rightRendererBlue.setForeground(Color.BLUE);

            checkTable.setModel(checkModel);
            checkTable.setRowHeight(25);
            checkTable.getColumnModel().getColumn(2).setCellRenderer(rightRendererBlue);
            checkTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
            
            transactBtn.requestFocus();
            
            // VALIDATE TOTAL AMOUNT SELECTED
            getSelectedBillsPayablesTotal();
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Bills", e.getMessage());
        }
    }
 
    public double getTotalCheckPayments() {
        try {
             double ttl = 0;
             for(int i=0; i<checkLists.size(); i++) {
                ttl += Double.valueOf(checkLists.get(i).getAmount());
             }
             return ttl;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public double getTotalAmount() {
        double cash = Double.valueOf(cashPaymentField.getValue() != null ? cashPaymentField.getValue().toString() : "0");
        double check = getTotalCheckPayments();
        return cash + check;
    }
    
    public double getCashRemainFromCheck() {
        double check = getTotalCheckPayments();
        return (totalAmountPayable + totalSurcharge) - check;
    }
    
    public void selectCashAmount() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                cashPaymentField.selectAll();
            }
        });  
    }
    
    public void showTransactConfirmation() {
        try {
            // SHOW CONFIRMATION
            JDialog confirmationDialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(getParent()));
            Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) size.getWidth();
            int y = (int) size.getHeight();
            confirmationDialog.setLocation(x/3, y/3);
            confirmationDialog.setTitle("Payment Confirmation");

            JPanel mainPanel = new JPanel(new GridLayout(0, 2, 5, 5));
            mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

            // CASH AMOUNT
            JLabel cashAmntLabel = new JLabel("CASH AMOUNT");
            cashAmntLabel.setFont(new Font("Arial", Font.BOLD, 16));
            mainPanel.add(cashAmntLabel);

            NumberFormat format = NumberFormat.getInstance();
            format.setMinimumFractionDigits(2);
            format.setMaximumFractionDigits(2);
            format.setRoundingMode(RoundingMode.HALF_UP);
            NumberFormatter formatter = new NumberFormatter(format);
            formatter.setValueClass(Double.class);
            formatter.setAllowsInvalid(false);
            formatter.setCommitsOnValidEdit(true);

            JFormattedTextField cashAmountField = new JFormattedTextField(formatter);
            cashAmountField.setPreferredSize(new Dimension(250, 36));
            cashAmountField.setFont(new Font("Arial", Font.BOLD, 19)); 
            cashAmountField.setHorizontalAlignment(JTextField.RIGHT);
            cashAmountField.setValue(cashPaymentField.getValue());
            cashAmountField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            cashAmountField.selectAll();
                        }
                    });                    
                }                
            });                

            mainPanel.add(cashAmountField);

            // CHECK AMOUNT
            JLabel checkAmount = new JLabel("CHECK AMOUNT");
            checkAmount.setFont(new Font("Arial", Font.BOLD, 16));
            mainPanel.add(checkAmount);

            JFormattedTextField totalCheckAmountField = new JFormattedTextField(formatter);
            totalCheckAmountField.setPreferredSize(new Dimension(250, 36));
            totalCheckAmountField.setFont(new Font("Arial", Font.BOLD, 19)); 
            totalCheckAmountField.setHorizontalAlignment(JTextField.RIGHT);
            totalCheckAmountField.setValue(getTotalCheckPayments());
            totalCheckAmountField.setEnabled(false);
            mainPanel.add(totalCheckAmountField);

            // TOTAL AMOUNT PAID
            JLabel totalAmountPaidLabel = new JLabel("TOTAL AMOUNT PAID");
            totalAmountPaidLabel.setFont(new Font("Arial", Font.BOLD, 16));
            mainPanel.add(totalAmountPaidLabel);                

            JFormattedTextField totalAmountPaidField = new JFormattedTextField(formatter);
            totalAmountPaidField.setPreferredSize(new Dimension(250, 36));
            totalAmountPaidField.setFont(new Font("Arial", Font.BOLD, 19)); 
            totalAmountPaidField.setHorizontalAlignment(JTextField.RIGHT);
            totalAmountPaidField.setValue(getTotalAmount());
            totalAmountPaidField.setEnabled(false);
            mainPanel.add(totalAmountPaidField);

            // TOTAL AMOUNT DUE
            JLabel totalAmountDueLabel = new JLabel("TOTAL AMOUNT DUE");
            totalAmountDueLabel.setFont(new Font("Arial", Font.BOLD, 16));
            mainPanel.add(totalAmountDueLabel);                

            JFormattedTextField totalAmountDueField = new JFormattedTextField(formatter);
            totalAmountDueField.setPreferredSize(new Dimension(250, 36));
            totalAmountDueField.setFont(new Font("Arial", Font.BOLD, 19)); 
            totalAmountDueField.setForeground(Color.red);
            totalAmountDueField.setHorizontalAlignment(JTextField.RIGHT);
            totalAmountDueField.setValue((totalAmountPayable + totalSurcharge));
            mainPanel.add(totalAmountDueField);

            // TOTAL AMOUNT DUE
            JLabel changeLabel = new JLabel("CHANGE");
            changeLabel.setFont(new Font("Arial", Font.BOLD, 16));
            mainPanel.add(changeLabel);                

            JFormattedTextField changeField = new JFormattedTextField(formatter);
            changeField.setPreferredSize(new Dimension(250, 36));
            changeField.setFont(new Font("Arial", Font.BOLD, 19)); 
            changeField.setForeground(Color.BLUE);
            changeField.setHorizontalAlignment(JTextField.RIGHT);
            changeField.setValue(getTotalAmount() - (totalAmountPayable + totalSurcharge));
            mainPanel.add(changeField);

            cashAmountField.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }
                @Override
                public void keyPressed(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {
                    try {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            transact();
                            confirmationDialog.dispose();
                        } else {
                            cashAmountField.commitEdit();
                            cashPaymentField.setValue(cashAmountField.getValue());
                            totalAmountPaid.setValue(getTotalAmount());
                            totalAmountPaidField.setValue(getTotalAmount());
                            changeField.setValue(getTotalAmount() - (totalAmountPayable + totalSurcharge));  
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(PowerBillsPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            JButton transactButton = new JButton("CONFIRM", new javax.swing.ImageIcon(getClass().getResource("/icons/check_circle_FILL1_wght400_GRAD0_opsz20.png")));
            transactButton.setFont(new Font("Arial", Font.BOLD, 18)); 
            transactButton.setPreferredSize(new Dimension(100, 40));
            mainPanel.add(new JLabel());
            mainPanel.add(transactButton);
            
            transactButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    transact();
                    confirmationDialog.dispose();
                }
            });

            confirmationDialog.add(mainPanel);
            confirmationDialog.pack();
            confirmationDialog.setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Showing Payment Confirmation", e.getMessage());
        }
    }
    
    public void transact() {
        try {
            String paymentUsed = "";
            double[] checksRemains = new double[0];
            int checkIndex = 0;
            int checkSize = 0;
            double cashAmount = 0;
            if (cashPaymentField.getValue() != null && checkLists.size() > 0) {
                paymentUsed = "Cash and Check";

                checkSize = checkLists.size();
                checksRemains = new double[checkSize];
                for (int x=0; x<checkSize; x++) {
                    checksRemains[x] = Double.valueOf(checkLists.get(x).getAmount());
                }
                cashAmount = getCashRemainFromCheck();
            } else if (cashPaymentField.getValue() == null && checkLists.size() > 0) {
                paymentUsed = "Check";

                checkSize = checkLists.size();
                checksRemains = new double[checkSize];
                for (int x=0; x<checkSize; x++) {
                    checksRemains[x] = Double.valueOf(checkLists.get(x).getAmount());
                }
            } else {
                paymentUsed = "Cash";
            }
            boolean successStream = true;

            /**
             * =============================================================
             * CHECK FIRST IF THERE ARE MANY BILLS SELECTED
             * =============================================================
             */
            int selectedSize = selectedBills.size();
            if (selectedSize > 1) {
                Notifiers.showErrorMessage("One-at-a-Time Rule", "Multiple partial payments at once is not allowed. Select one bill only.");
            } else if (selectedSize < 1) {
                Notifiers.showErrorMessage("One-at-a-Time Rule", "Please select at least 1 (one) bill.");
            } else {
                /**
                * SAVE PAIDBILLS
                */
                List<PaidBills> paidBillsForPrint = new ArrayList<>();
                Bills bill = selectedBills.get(0);
                PaidBills paidBill = new PaidBills(
                       ObjectHelpers.generateIDandRandString(),
                       bill.getBillNumber(),
                       bill.getAccountNumber(),
                       bill.getServicePeriod(),
                       orNumberField.getText(),
                       orDateField.getText(),
                       null,
                       bill.getKwhUsed(),
                       login.getId(),
                       office,
                       ObjectHelpers.getSqlDate(),
                       ObjectHelpers.getSqlTime(),
                       ObjectHelpers.roundFourNoComma(bill.getAdditionalKwh()), // SURCHARGE
                       bill.getEvat2Percent(),
                       bill.getEvat5Percent(),
                       bill.getAdditionalCharges(),
                       bill.getDeductions(),
                       ObjectHelpers.roundTwoNoComma(getTotalAmount()),
                       "MONTHLY BILL",
                       bill.getId(),
                       login.getId(),
                       ObjectHelpers.getCurrentTimestamp(),
                       ObjectHelpers.getCurrentTimestamp(),
                       null,
                       null,
                       null,
                       null,
                       null,
                       null,
                       null,
                       null,
                       paymentUsed
                );

                /**
                 * =========================================================
                 * UPDATE BILL
                 * =========================================================
                 */
                double remainingBalance = ObjectHelpers.doubleStringNull(bill.getBalance());
                double pdAmnt = ObjectHelpers.doubleStringNull(paidBill.getNetAmount());
                remainingBalance = remainingBalance - pdAmnt;
                bill.setPaidAmount(paidBill.getNetAmount());
                bill.setBalance(ObjectHelpers.roundTwoNoComma(remainingBalance));
                BillsDao.updateBills(connection, bill);
                
                /**
                 * =========================================================
                 * SAVE TO Cashier_BillMirror
                 * =========================================================
                 */
                BillMirror billMirror = BillMirrorDao.getOne(connection, bill.getAccountNumber(), bill.getServicePeriod());
                boolean isNewBm = false;
                if (billMirror != null) {
                    isNewBm = false;
                } else {
                    billMirror = new BillMirror();
                    billMirror.setId(ObjectHelpers.generateIDandRandString());
                    billMirror.setORNumber(paidBill.getORNumber());
                    billMirror.setORDate(paidBill.getORDate());
                    billMirror.setTeller(paidBill.getTeller());
                    billMirror.setPaidBillId(paidBill.getId());
                    billMirror.setAccountNumber(paidBill.getAccountNumber());
                    billMirror.setServicePeriod(paidBill.getServicePeriod());
                    billMirror.setServiceDateFrom(bill.getServiceDateFrom());
                    billMirror.setServiceDateTo(bill.getServiceDateTo());
                    billMirror.setDueDate(bill.getDueDate());
                    billMirror.setNetAmount(bill.getNetAmount());
                    billMirror.setBillNumber(bill.getBillNumber());
                    isNewBm = true;
                }
                double remainingAmount = pdAmnt;
                double termedPayments = ObjectHelpers.doubleStringNull(bill.getTermedPayments());
                // SET TERMED PAYMENT FIRST
                if (termedPayments > 0) {
                    remainingAmount = BillMirrorDao.populateTermedPaymentAmountUpdate(pdAmnt, bill, billMirror);
                }
                
                if (remainingAmount >= BillsDao.getOthersAmount(bill)) {
                    // IF PAID AMOUNT IS GREATER THAN OTHERS AMOUNT, PAY OTHER AMOUNTS FIRST
                    remainingAmount = BillMirrorDao.populateOtherAmountUpdate(pdAmnt, bill, billMirror);
                    
                    if (remainingAmount > 0) {
                        BillMirrorDao.populateBilledAmountUpdate(remainingAmount, bill, billMirror);
                    }
                } else {
                    // IF PAID AMOUNT IS LESS THAN OTHERS AMOUNT, PAY BILLED AMOUNT FIRST
                    BillMirrorDao.populateBilledAmountUpdate(remainingAmount, bill, billMirror);
                }
                
                if (isNewBm) {
                    BillMirrorDao.insert(connection, billMirror);
                } else {
                    BillMirrorDao.update(connection, billMirror);
                }
                
                /**
                 * =========================================================
                 * UPDATE IF THERE ARE OCLs/TERMED PAYMENTS EMBEDDED
                 * =========================================================
                 */
                if (termedPayments > 0) {
                    List<OCLMonthly> termedList = OCLMonthlyDao.getTermedPaymentThisMonth(connection, bill.getServicePeriod(), bill.getAccountNumber());

                    int tsize = termedList.size();
                    if (tsize > 0) {
                        for (OCLMonthly tmonth : termedList) {
                            // UPDATE Bills_ArrearsLedgerDistribution
                            OCLMonthlyDao.setOclPaid(connection, tmonth.getId());
                            // UPDATE Bills_Collectibles
                            if (tmonth.getCollectibleId() != null) {
                                Collectibles collectible = CollectiblesDao.getOneById(connection, tmonth.getCollectibleId());

                                if (collectible != null) {
                                    double amnt = ObjectHelpers.roundTwoNoCommaDouble(ObjectHelpers.doubleStringNull(tmonth.getAmount()));
                                    double balance = ObjectHelpers.roundTwoNoCommaDouble(ObjectHelpers.doubleStringNull(collectible.getBalance()));
                                    if (amnt > 0) {
                                        balance = balance - amnt;
                                        CollectiblesDao.updateCollectibleById(connection, collectible.getId(), ObjectHelpers.roundTwoNoComma(balance));
                                    }
                                }
                            }                                
                        }
                    }
                }

               if (PaidBillsDao.insert(connection, paidBill)) {
                   successStream = true;
               } else {
                   successStream = false;
               }
               paidBill.setBank(bill.getDueDate());// SET FOR PRINT
               paidBillsForPrint.add(paidBill);

               /**
                * SAVE PAID BILL DETAILS
                */
               double surcharge = paidBill.getSurcharge() != null ? Double.valueOf(paidBill.getSurcharge()) : 0;
               if (cashPaymentField.getValue() != null) {
                   if (paymentUsed.equals("Cash and Check")) {
                       double netAmnt = Double.valueOf(paidBill.getNetAmount());

                           // TRANSACT CASH FIRST IF THERE IS CASH INPUTTED
                           if (cashAmount > 0) {
                               // TRANSACT CASH FIRST
                               if (cashAmount < netAmnt) {
                                   double excessCash = netAmnt - cashAmount;
                                   // SAVE FIRST EXCESS CASH
                                   CheckPayments details = new CheckPayments(
                                       ObjectHelpers.generateIDandRandString(),
                                       bill.getAccountNumber(),
                                       bill.getServicePeriod(),
                                       null,
                                       paidBill.getORNumber(),
                                       ObjectHelpers.roundTwoNoComma(cashAmount + ""),
                                       "Cash",
                                       null,
                                       null, 
                                       null,
                                       login.getId(),
                                       ObjectHelpers.getCurrentTimestamp(),
                                       ObjectHelpers.getCurrentTimestamp()
                                   );
                                   PaidBillDetailsDao.insert(connection, details);

                                   cashAmount = 0;

                                   // SAVE CHECK
                                   details = new CheckPayments(
                                           ObjectHelpers.generateIDandRandString(),
                                           bill.getAccountNumber(),
                                           bill.getServicePeriod(),
                                           null,
                                           paidBill.getORNumber(),
                                           ObjectHelpers.roundTwoNoComma(excessCash + ""),
                                           "Check",
                                           checkLists.get(checkIndex).getCheckNo(),
                                           checkLists.get(checkIndex).getBank(), 
                                           null,
                                           login.getId(),
                                           ObjectHelpers.getCurrentTimestamp(),
                                           ObjectHelpers.getCurrentTimestamp()
                                       );
                                   PaidBillDetailsDao.insert(connection, details);

                                   // DEDUCT THE EXCESS
                                   checksRemains[checkIndex] = checksRemains[checkIndex] - excessCash;
                               } else {
                                   // SAVE CASH NORMALLY
                                   CheckPayments details = new CheckPayments(
                                       ObjectHelpers.generateIDandRandString(),
                                       bill.getAccountNumber(),
                                       bill.getServicePeriod(),
                                       null,
                                       paidBill.getORNumber(),
                                       ObjectHelpers.roundTwoNoComma(netAmnt + ""),
                                       "Cash",
                                       null,
                                       null, 
                                       null,
                                       login.getId(),
                                       ObjectHelpers.getCurrentTimestamp(),
                                       ObjectHelpers.getCurrentTimestamp()
                                   );
                                   PaidBillDetailsDao.insert(connection, details);

                                   cashAmount = cashAmount - netAmnt;
                               }    
                           } else {
                               // START CHECK TRANSACTION
                               if (checksRemains[checkIndex] < netAmnt) {
                                   // GET FIRST THE EXCESS AMOUNT OF THE BILL AMOUNT AND SAVE PARTIALLY
                                   double excess = netAmnt - checksRemains[checkIndex];
                                   CheckPayments details = new CheckPayments(
                                       ObjectHelpers.generateIDandRandString(),
                                       bill.getAccountNumber(),
                                       bill.getServicePeriod(),
                                       null,
                                       paidBill.getORNumber(),
                                       ObjectHelpers.roundTwoNoComma(checksRemains[checkIndex] + ""),
                                       "Check",
                                       checkLists.get(checkIndex).getCheckNo(),
                                       checkLists.get(checkIndex).getBank(), 
                                       null,
                                       login.getId(),
                                       ObjectHelpers.getCurrentTimestamp(),
                                       ObjectHelpers.getCurrentTimestamp()
                                   );
                                   PaidBillDetailsDao.insert(connection, details);

                                   checksRemains[checkIndex] = 0;
                                   // MOVE TO THE NEXT CHECK
                                   checkIndex++;
                                   if (checkIndex < checkSize) {
                                       // DEDUCT THE EXCESS TO THE NEXT CHECK
                                       checksRemains[checkIndex] = checksRemains[checkIndex] - excess;

                                       // SAVE THE EXCESS
                                       details = new CheckPayments(
                                           ObjectHelpers.generateIDandRandString(),
                                           bill.getAccountNumber(),
                                           bill.getServicePeriod(),
                                           null,
                                           paidBill.getORNumber(),
                                           ObjectHelpers.roundTwoNoComma(excess + ""),
                                           "Check",
                                           checkLists.get(checkIndex).getCheckNo(),
                                           checkLists.get(checkIndex).getBank(), 
                                           null,
                                           login.getId(),
                                           ObjectHelpers.getCurrentTimestamp(),
                                           ObjectHelpers.getCurrentTimestamp()
                                       );
                                       PaidBillDetailsDao.insert(connection, details);
                                   } else {
//                                        Notifiers.showErrorMessage("Error", "Check amount insufficient!");
//                                        break;
                                   }                                    
                               } else {
                                   // SAVE NORMALLY
                                   checksRemains[checkIndex] = checksRemains[checkIndex] - netAmnt;

                                   CheckPayments details = new CheckPayments(
                                       ObjectHelpers.generateIDandRandString(),
                                       bill.getAccountNumber(),
                                       bill.getServicePeriod(),
                                       null,
                                       paidBill.getORNumber(),
                                       ObjectHelpers.roundTwoNoComma(netAmnt + ""),
                                       "Check",
                                       checkLists.get(checkIndex).getCheckNo(),
                                       checkLists.get(checkIndex).getBank(), 
                                       null,
                                       login.getId(),
                                       ObjectHelpers.getCurrentTimestamp(),
                                       ObjectHelpers.getCurrentTimestamp()
                                   );
                                   PaidBillDetailsDao.insert(connection, details);
                               }
                           }                                        
                   } else if (paymentUsed.equals("Cash")) {
                       CheckPayments details = new CheckPayments(
                               ObjectHelpers.generateIDandRandString(),
                               activeAccount.getId(),
                               bill.getServicePeriod(),
                               null,
                               orNumberField.getText(),
                               ObjectHelpers.roundTwoNoComma((Double.valueOf(bill.getNetAmount()) + surcharge) + ""),
                               "Cash",
                               null,
                               null, 
                               null,
                               login.getId(),
                               ObjectHelpers.getCurrentTimestamp(),
                               ObjectHelpers.getCurrentTimestamp()
                       );
                       PaidBillDetailsDao.insert(connection, details);
                   }                        
               } else {
                   if (paymentUsed.equals("Check")) { 
//                            if (i==0) {
//                                if (checkLists.size() > 0) {
//                                    for(int x=0; x<checkLists.size(); x++) {
//                                        CheckPayments chk = checkLists.get(x);
//                                        chk.setId(ObjectHelpers.generateIDandRandString());
//                                        chk.setServicePeriod(bill.getServicePeriod());
//                                        chk.setAmount(chk.getAmount() + "");
//                                        PaidBillDetailsDao.insert(connection, chk);
//                                    }                                            
//                                }
//                            }  
                       double netAmnt = Double.valueOf(paidBill.getNetAmount());

                       if (checksRemains[checkIndex] < netAmnt) {
                           // GET FIRST THE EXCESS AMOUNT OF THE BILL AMOUNT AND SAVE PARTIALLY
                           double excess = netAmnt - checksRemains[checkIndex];
                           CheckPayments details = new CheckPayments(
                               ObjectHelpers.generateIDandRandString(),
                               bill.getAccountNumber(),
                               bill.getServicePeriod(),
                               null,
                               paidBill.getORNumber(),
                               ObjectHelpers.roundTwoNoComma(checksRemains[checkIndex] + ""),
                               "Check",
                               checkLists.get(checkIndex).getCheckNo(),
                               checkLists.get(checkIndex).getBank(), 
                               null,
                               login.getId(),
                               ObjectHelpers.getCurrentTimestamp(),
                               ObjectHelpers.getCurrentTimestamp()
                           );
                           PaidBillDetailsDao.insert(connection, details);

                           checksRemains[checkIndex] = 0;
                           // MOVE TO THE NEXT CHECK
                           checkIndex++;
                           if (checkIndex < checkSize) {
                               // DEDUCT THE EXCESS TO THE NEXT CHECK
                               checksRemains[checkIndex] = checksRemains[checkIndex] - excess;

                               // SAVE THE EXCESS
                               details = new CheckPayments(
                                   ObjectHelpers.generateIDandRandString(),
                                   bill.getAccountNumber(),
                                   bill.getServicePeriod(),
                                   null,
                                   paidBill.getORNumber(),
                                   ObjectHelpers.roundTwoNoComma(excess + ""),
                                   "Check",
                                   checkLists.get(checkIndex).getCheckNo(),
                                   checkLists.get(checkIndex).getBank(), 
                                   null,
                                   login.getId(),
                                   ObjectHelpers.getCurrentTimestamp(),
                                   ObjectHelpers.getCurrentTimestamp()
                               );
                               PaidBillDetailsDao.insert(connection, details);
                           } else {
//                                        Notifiers.showErrorMessage("Error", "Check amount insufficient!");
//                                        break;
                           }                                    
                       } else {
                           // SAVE NORMALLY
                           checksRemains[checkIndex] = checksRemains[checkIndex] - netAmnt;

                           CheckPayments details = new CheckPayments(
                               ObjectHelpers.generateIDandRandString(),
                               bill.getAccountNumber(),
                               bill.getServicePeriod(),
                               null,
                               paidBill.getORNumber(),
                               ObjectHelpers.roundTwoNoComma(netAmnt + ""),
                               "Check",
                               checkLists.get(checkIndex).getCheckNo(),
                               checkLists.get(checkIndex).getBank(), 
                               null,
                               login.getId(),
                               ObjectHelpers.getCurrentTimestamp(),
                               ObjectHelpers.getCurrentTimestamp()
                           );
                           PaidBillDetailsDao.insert(connection, details);
                       }
                   }   
               }

               if (successStream) {   
                   /**
                    * SAVE OR ASSIGNING
                    */
                   ORAssigning orNew = new ORAssigning(
                           ObjectHelpers.generateIDandRandString(),
                           orNumberField.getText(),
                           login.getId(),
                           ObjectHelpers.getSqlDate(),
                           null,
                           ObjectHelpers.getSqlTime(),
                           office,
                           ObjectHelpers.getCurrentTimestamp(),
                           ObjectHelpers.getCurrentTimestamp()
                   );
                   ORAssigningDao.insert(connection, orNew);

                   /*
                    * SAVE EXCESS CHECKS
                    */
                   for (int y=0; y<checkSize; y++) {
                       if (checksRemains[y] > 0) {
                           CheckPayments details = new CheckPayments(
                               ObjectHelpers.generateIDandRandString(),
                               null,
                               null,
                               null,
                               "EXCESS CHECK PAYMENT",
                               ObjectHelpers.roundTwoNoComma(checksRemains[y] + ""),
                               "Check",
                               checkLists.get(y).getCheckNo(),
                               checkLists.get(y).getBank(), 
                               null,
                               login.getId(),
                               ObjectHelpers.getCurrentTimestamp(),
                               ObjectHelpers.getCurrentTimestamp()
                           );
                           PaidBillDetailsDao.insert(connection, details);
                       }
                   }

                   /**
                    * ===============================
                    * PRINT HERE YOU DUMBASS
                    * ===============================
                    */
                   print(activeAccount, paidBillsForPrint, orNumberField.getText(), login.getUsername());

                   // RESET EVERYTHING
                   fetchOR();
                   resetForm();
//                   accountNumberSearch.setValue(officeCode);
                   consumerNameField.setText("");
                   accountNumber.setText("");
                   accountType.setText("");
                   consumerAddress.setText("");
                   acctStatus.setText("");
                   meterNumber.setText("");
                   cashPaymentField.setValue(null);
                   cashPaymentField.setEnabled(false);
                   addCheckButton.setEnabled(false);
                   clearChecksBtn.setEnabled(false);
                   suggestedPartialAmount.setValue(null);
                   if (checkModel != null) {
                       checkModel.getDataVector().removeAllElements();
                       checkModel.fireTableDataChanged();
                   }
                   if (model != null) {
                       model.getDataVector().removeAllElements();
                       model.fireTableDataChanged();
                   }
                   accountNumberSearch.requestFocus();
               } else {
                   Notifiers.showErrorMessage("Error Saving Transaction", "An error occured during the transaction!");
               }       
            }     
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Saving Transaction", e.getMessage());
        }
    }
    
    public void fetchOR() {
        currentOr = ORAssigningDao.getCurrentOR(connection, login.getId());
        if (currentOr != null) {
            nextOrNumber = Integer.parseInt(currentOr.getORumber()) + 1;
            orNumberField.setText(nextOrNumber + "");
            accountNumberSearch.requestFocus();
        } else {
            nextOrNumber = Integer.parseInt(orNumber);
            orNumberField.setText(nextOrNumber + "");
            accountNumberSearch.requestFocus();
        }   
        // GET SCHEDULE OR DATE
        orDateField.setText(CollectionDateAdjustmentsDao.getActiveORDate(connection, login.getId()));    
    }    
    
    public void print(ServiceAccounts account, List<PaidBills> bills, String orNumber, String username) {
        PrinterJob job = PrinterJob.getPrinterJob();
        PageFormat pf = job.defaultPage();
        Paper paper = pf.getPaper();
        double width = 5d * 72d;
        double height = 4d * 72d;
        double margin = 0.1d * 72d;
        paper.setSize(width, height);
        paper.setImageableArea(
                margin,
                margin,
                width - (margin * 2),
                height - (margin * 2));
        pf.setPaper(paper);
        Book pBook = new Book();
        pBook.append(new PowerBillPrint(bills, account, orNumber, username), pf);
        job.setPageable(pBook);

//            job.setPrintable(new PowerBillPrint(bills.get(i), account));
        try {
            job.print();
        } catch (PrinterException e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Printing Payment", "Account No: " + account.getOldAccountNo() + "\n" + e.getMessage());
        }
    }
    
    public void advancedSearch() {
        try {
            JDialog advancedSearchDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(getParent()));
            Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) size.getWidth();
            int y = (int) size.getHeight();
            advancedSearchDialog.setLocation(x/5, y/5);
            advancedSearchDialog.setTitle("Advanced Search");
            
            JPanel mainPanel = new JPanel();
    
            JTextField searchField = new javax.swing.JTextField();
            JButton searchBtn = new javax.swing.JButton();
            JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
            JTable resultsTable = new javax.swing.JTable();
            
            final String searchCols[] = {"Account No", "Consumer Name", "Address", "Account Type", "Status"};

            searchField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

            searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/travel_explore_FILL0_wght700_GRAD0_opsz20.png"))); // NOI18N
            
            // SEARCH
            searchField.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    DefaultTableModel searchTableModel;
                    if (searchField.getText().length() > 3) {
                        List<ServiceAccounts> results = ServiceAccountsDao.search(connection, searchField.getText());
                        int searchSize = results.size();
                        Object[][] searchData = new Object[searchSize][searchCols.length];
                        for (int i=0; i<searchSize; i++) {
                            ServiceAccounts acctt = results.get(i);
                            searchData[i][0] = acctt.getOldAccountNo();
                            searchData[i][1] = acctt.getServiceAccountName();
                            searchData[i][2] = ServiceAccountsDao.getAddress(acctt);
                            searchData[i][3] = acctt.getAccountType();
                            searchData[i][4] = acctt.getAccountStatus();
                        }
                        
                        searchTableModel = new DefaultTableModel(searchData, searchCols) {
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }                            
                        };
                    
                        resultsTable.setModel(searchTableModel);
                        resultsTable.getColumnModel().getColumn(0).setWidth(40);
                        resultsTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
                    }
                }
            });
            
            resultsTable.setRowHeight(28);
            resultsTable.setFont(new Font("Arial", Font.PLAIN, 12));
            
            jScrollPane1.setViewportView(resultsTable);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(mainPanel);
            mainPanel.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(searchBtn)
                    .addContainerGap(143, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            
            resultsTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        String acct = resultsTable.getModel().getValueAt(resultsTable.getSelectedRow(), 0).toString();
                        accountNumberSearch.setValue(acct);
                        getAccountByOldAccountNo(acct);
                        advancedSearchDialog.dispose();
                    }
                }                
            });
            
            advancedSearchDialog.add(mainPanel);
            advancedSearchDialog.pack();
            advancedSearchDialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Saving Transaction", e.getMessage());
        }
    }
    
    public void updateOR() {
        fetchOR();
    }
    
    class ButtonRenderer extends JButton implements TableCellRenderer  {
        public ButtonRenderer() {
            setOpaque(true);
        }
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Waive" : value.toString());
            return this;
        }
    }
    
    class ButtonEditor extends DefaultCellEditor  {
        private String label;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "Waive" : value.toString();
            JButton removeBtn = new JButton(label);
            removeBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(getParent()));
                    
                    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
                    int x = (int) size.getWidth();
                    int y = (int) size.getHeight();
                    dialog.setLocation(x/5, y/5);
                    dialog.setTitle("Authentication");

                    JPanel mainPanel = new JPanel(new GridLayout(0, 1, 0, 5));
                    mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

                    JTextField username = new javax.swing.JTextField();
                    username.setText(login.getUsername());
                    JPasswordField password = new JPasswordField();
                    JButton loginBtn = new javax.swing.JButton("Authenticate");
                    
                    mainPanel.add(new JLabel("Username"));
                    username.setPreferredSize(new Dimension(250, 36));
                    username.setFont(new Font("Arial", Font.BOLD, 14));  
                    mainPanel.add(username);
                    
                    mainPanel.add(new JLabel("Password"));
                    password.setPreferredSize(new Dimension(250, 36));
                    password.setFont(new Font("Arial", Font.BOLD, 14));  
                    mainPanel.add(password);
                    
                    mainPanel.add(loginBtn);
                    
                    username.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyReleased(KeyEvent e) {
                            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                password.requestFocus();
                            }
                        }
                    });
                    
                    password.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyReleased(KeyEvent e) {
                            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                if (Auth.authenticate(username.getText(), password.getText(), login)) {
                                    dialog.dispose();
                                    waive(billsTable.getModel().getValueAt(billsTable.getSelectedRow(), 1).toString());
                                } else {
                                    Notifiers.showErrorMessage("Authentication Error", "Login Invalid");
                                }
                            }
                        }
                    });
                    
                    loginBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (Auth.authenticate(username.getText(), password.getText(), login)) {
                                dialog.dispose();
                                waive(billsTable.getModel().getValueAt(billsTable.getSelectedRow(), 1).toString());
                            } else {
                                Notifiers.showErrorMessage("Authentication Error", "Login Invalid");
                            }
                        }
                    });
                    
                    dialog.add(mainPanel);
                    dialog.pack();
                    dialog.setVisible(true);
                }     
            });
            return removeBtn;
        }
        
        public Object getCellEditorValue()  {
          return new String(label);
        }
    }
    
    public void waive(String billNo) {
        try {
            int indexOfSelected = BillsDao.getBillIndexFromBillNumber(selectedBills, billNo);
            if (indexOfSelected == -1) {
                Notifiers.showErrorMessage("Bill Not Selected", "This Bill is not selected. Select first to waive payment.");
            } else {
                Bills bill = selectedBills.get(indexOfSelected);

                if (bill != null) {
                    JDialog waiveDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(getParent()));
                    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
                    int x = (int) size.getWidth();
                    int y = (int) size.getHeight();
                    waiveDialog.setLocation(x/5, y/4);
                    waiveDialog.setTitle("Waive Certain Amounts");

                    JPanel mainPanel = new JPanel(new GridLayout(3, 5, 1, 3));
                    mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

                    mainPanel.add(new JLabel("Bill Number"));
                    mainPanel.add(new JLabel("Billing Month"));
                    mainPanel.add(new JLabel("Surcharge"));
                    mainPanel.add(new JLabel("2% EWT"));
                    mainPanel.add(new JLabel("5% EVAT"));

                    JTextField billNumber = new JTextField();
                    billNumber.setPreferredSize(new Dimension(110, 36));
                    billNumber.setFont(new Font("Arial", Font.BOLD, 16));  
                    billNumber.setEnabled(false);
                    billNumber.setText(billNo);
                    mainPanel.add(billNumber);
                    
                    JTextField periodField = new JTextField();
                    periodField.setPreferredSize(new Dimension(110, 36));
                    periodField.setFont(new Font("Arial", Font.BOLD, 16));  
                    periodField.setEnabled(false);
                    periodField.setText(bill.getServicePeriod());
                    mainPanel.add(periodField);

                    NumberFormat format = NumberFormat.getInstance();
                    format.setMinimumFractionDigits(2);
                    format.setMaximumFractionDigits(2);
                    format.setRoundingMode(RoundingMode.HALF_UP);
                    NumberFormatter formatter = new NumberFormatter(format);
                    formatter.setValueClass(Double.class);
                    formatter.setAllowsInvalid(false);
                    formatter.setCommitsOnValidEdit(true);

                    JFormattedTextField surchargeField = new JFormattedTextField(formatter);
                    surchargeField.setPreferredSize(new Dimension(120, 36));
                    surchargeField.setFont(new Font("Arial", Font.BOLD, 16)); 
                    surchargeField.setHorizontalAlignment(JTextField.RIGHT);
                    surchargeField.setValue(bill.getAdditionalKwh() != null ? Double.valueOf(bill.getAdditionalKwh()) : 0); // SRUCHARGE
                    mainPanel.add(surchargeField);
                    
                    JFormattedTextField ewtField = new JFormattedTextField(formatter);
                    ewtField.setPreferredSize(new Dimension(120, 36));
                    ewtField.setFont(new Font("Arial", Font.BOLD, 16)); 
                    ewtField.setHorizontalAlignment(JTextField.RIGHT);
                    ewtField.setValue(bill.getEvat2Percent() != null ? Double.valueOf(bill.getEvat2Percent()) : 0); 
                    mainPanel.add(ewtField);
                    
                    JFormattedTextField evatField = new JFormattedTextField(formatter);
                    evatField.setPreferredSize(new Dimension(120, 36));
                    evatField.setFont(new Font("Arial", Font.BOLD, 16)); 
                    evatField.setHorizontalAlignment(JTextField.RIGHT);
                    evatField.setValue(bill.getEvat5Percent() != null ? Double.valueOf(bill.getEvat5Percent()) : 0); 
                    mainPanel.add(evatField);
                    
                    mainPanel.add(new JLabel());
                    mainPanel.add(new JLabel());
                    mainPanel.add(new JLabel());
                    mainPanel.add(new JLabel());
                    
                    JButton saveBtn = new JButton("SAVE");
                    saveBtn.setFont(new Font("Arial", Font.BOLD, 16)); 
                    mainPanel.add(saveBtn);
                    
                    saveBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                double surchargeAmnt = surchargeField.getValue() != null ? Double.valueOf(surchargeField.getValue().toString()) : 0;
                                double ewtAmount = ewtField.getValue() != null ? Double.valueOf(ewtField.getValue().toString()) : 0;
                                double evatAmount = evatField.getValue() != null ? Double.valueOf(evatField.getValue().toString()) : 0;
                                
                                double originalEwt = bill.getEvat2Percent() != null ? Double.valueOf(bill.getEvat2Percent()) : 0;                                
                                double originalEvat = bill.getEvat5Percent() != null ? Double.valueOf(bill.getEvat5Percent()) : 0;
                                
                                double originalAmount = bill.getNetAmount()!= null ? Double.valueOf(bill.getNetAmount()) : 0;
                                originalAmount = originalAmount + (originalEvat + originalEwt); // ORIGINAL BILL AMOUNT MINUS THE EWT AND EVAT
                                
                                double newAmount = originalAmount + surchargeAmnt - (evatAmount + ewtAmount);
                                
                                int tblSelIndex = billsTable.getSelectedRow();
                                
                                billsList.get(tblSelIndex).setAdditionalKwh(ObjectHelpers.roundTwoNoComma(surchargeAmnt + ""));
                                billsList.get(tblSelIndex).setEvat2Percent(ObjectHelpers.roundTwoNoComma(ewtAmount + ""));
                                billsList.get(tblSelIndex).setEvat5Percent(ObjectHelpers.roundTwoNoComma(evatAmount + ""));
                                billsList.get(tblSelIndex).setNetAmount(ObjectHelpers.roundTwoNoComma((newAmount - surchargeAmnt) + ""));
                                
                                int selBillsIndex = getIndexOfSelectedList(billsList.get(tblSelIndex).getAccountNumber(), selectedBills);
                                selectedBills.get(selBillsIndex).setAdditionalKwh(ObjectHelpers.roundTwoNoComma(surchargeAmnt + ""));
                                selectedBills.get(selBillsIndex).setEvat2Percent(ObjectHelpers.roundTwoNoComma(ewtAmount + ""));
                                selectedBills.get(selBillsIndex).setEvat5Percent(ObjectHelpers.roundTwoNoComma(evatAmount + ""));
                                selectedBills.get(selBillsIndex).setNetAmount(ObjectHelpers.roundTwoNoComma((newAmount - surchargeAmnt) + ""));
                                
                                System.out.println("" + selectedBills.get(selBillsIndex).getAdditionalKwh());
                                
                                // UPDATE TABLE
//                                billsTable.getModel().setValueAt(ObjectHelpers.roundTwo(originalAmount + ""), tblSelIndex, 4);
                                billsTable.getModel().setValueAt(ObjectHelpers.roundTwo(surchargeAmnt + ""), tblSelIndex, 5);
                                billsTable.getModel().setValueAt(ObjectHelpers.roundTwo(ewtAmount + ""), tblSelIndex, 6);
                                billsTable.getModel().setValueAt(ObjectHelpers.roundTwo(evatAmount + ""), tblSelIndex, 7);
                                billsTable.getModel().setValueAt(ObjectHelpers.roundTwo(newAmount + ""), tblSelIndex, 9);
                                
                                getSelectedBillsPayablesTotal();
                                cashPaymentField.setValue(totalAmountPayable + totalSurcharge);
                                totalAmountPaid.setValue(getTotalAmount());
                                transactBtn.requestFocus();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                Notifiers.showErrorMessage("Error waiving amount", ex.getMessage());
                            }
                            waiveDialog.dispose();
                        }
                    });

                    waiveDialog.add(mainPanel);
                    waiveDialog.pack();
                    waiveDialog.setVisible(true);
                } else {
                    Notifiers.showErrorMessage("Bill Not Selected", "This Bill is not selected. Select first to waive payment.");
                }    
            }
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error waiving amount", e.getMessage());
        }
    }
    
    public int getIndexOfSelectedList(String regex, List<Bills> values) {
        try {
            int index = IntStream.range(0, values.size())
                .filter(i -> Objects.equals(values.get(i).getAccountNumber(), regex))
                .findFirst()
                .orElse(-1);
            
            return index;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
}
