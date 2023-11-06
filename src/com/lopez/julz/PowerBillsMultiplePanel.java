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
import db.DatabaseConnection;
import db.OCLMonthlyDao;
import db.ORAssigningDao;
import db.PaidBillDetailsDao;
import db.PaidBillsDao;
import db.ServiceAccountsDao;
import db.TransactionIndexDao;
import helpers.ConfigFileHelpers;
import helpers.Notifiers;
import helpers.ObjectHelpers;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
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
import java.math.RoundingMode;
import java.sql.Connection;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import org.jdatepicker.JDatePicker;
import pojos.BillMirror;
import pojos.Bills;
import pojos.CheckPayments;
import pojos.Collectibles;
import pojos.MultipleAccountAddIns;
import pojos.MultipleAccountBills;
import pojos.OCLMonthly;
import pojos.ORAssigning;
import pojos.PaidBills;
import pojos.Server;
import pojos.ServiceAccounts;
import pojos.TransactionIndex;

/**
 *
 * @author julza
 */
public class PowerBillsMultiplePanel extends javax.swing.JPanel {

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
    public List<MultipleAccountBills> billsList;
    public List<MultipleAccountAddIns> addOns;
    
    /**
     * Bills Table 
     */
    Object[] columnNames = {"Payment For", "Account No", "Account Name", "Billing Month", "Due Date", "Amount Due", "Surcharge", "Total Amount Due", "Index"};
    DefaultTableModel model;
    
    /**
     * Paid bills area
     */
    public ORAssigning currentOr;
    int nextOrNumber = 0;
    double totalAmountPayable = 0;
    double totalSurcharge = 0;
    double totalReconnectionFee = 0;
    
    /**
     * Checks
     */
    public List<CheckPayments> checkLists;
    Object[] checkColNames = {"Bank", "Check No", "Amount"};
    DefaultTableModel checkModel;
    
    boolean isOrLocked = true;
    
    /**
     * Creates new form PowerBillsMultiplePanel
     */
    public PowerBillsMultiplePanel(pojos.Login login, String orNumber) {
        this.orNumber = orNumber;
        this.login = login;
        initComponents();
        
        server = ConfigFileHelpers.getServer();
        office = ConfigFileHelpers.getOffice();
        officeCode = ConfigFileHelpers.getOfficeCode();
    
        db = new DatabaseConnection();
        connection = db.getDbConnectionFromDatabase(server);
        
        
        billsList = new ArrayList<>();
        addOns = new ArrayList<>();
        fetchOR();
        
        checkLists = new ArrayList<>();
        
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e); //To change body of generated methods, choose Tools | Templates.
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    advancedSearch();
                }
            }
            
        });
        
        addBillsTablePopupMenu(billsTable);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        orNumberField = new javax.swing.JTextField();
        unlockOrNumberBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        orDateField = new javax.swing.JTextField();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        billsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        addAccount = new javax.swing.JButton();
        clearBills = new javax.swing.JButton();

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

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("OR Date");

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
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orNumberField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unlockOrNumberBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                        .addGap(59, 59, 59)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(unlockOrNumberBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(orNumberField)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orDateField)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalAmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(transactBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(addCheckButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(clearChecksBtn))
                                .addComponent(cashPaymentField, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
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

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/request_quote_FILL1_wght400_GRAD0_opsz24.png"))); // NOI18N
        jLabel1.setText("Power Bills Payment (Full Payment, Multiple Accounts)");
        jLabel1.setIconTextGap(10);

        addAccount.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        addAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/travel_explore_FILL0_wght700_GRAD0_opsz20.png"))); // NOI18N
        addAccount.setText("Add Account (F3)");
        addAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAccountActionPerformed(evt);
            }
        });

        clearBills.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        clearBills.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_FILL1_wght400_GRAD0_opsz20.png"))); // NOI18N
        clearBills.setText("Clear");
        clearBills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBillsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addAccount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clearBills))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBills, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

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
            if (billsList != null && billsList.size() > 0) {
                showTransactConfirmation();
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
            checkDialog.setLocation(x/3, y/4);
            checkDialog.setTitle("Add Check");

            JPanel mainPanel = new JPanel(new GridLayout(0, 1, 0, 5));
            mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

            mainPanel.add(new JLabel("Input Check Number"));
            JTextField checkNoField = new JTextField();
            checkNoField.setPreferredSize(new Dimension(400, 36));
            checkNoField.setFont(new Font("Arial", Font.BOLD, 16));
            mainPanel.add(checkNoField);
            
            mainPanel.add(new JLabel("Input Check Date"));
            JDatePicker datePicker = new JDatePicker();
            datePicker.setPreferredSize(new Dimension(400, 36));
            datePicker.setFont(new Font("Arial", Font.BOLD, 16));
            datePicker.getFormattedTextField().setPreferredSize(new Dimension(360, 36));
            datePicker.getButton().setPreferredSize(new Dimension(40, 36));
            mainPanel.add(datePicker);

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
                        if (datePicker.getFormattedTextField().getValue() != null) {
                            if (ObjectHelpers.isBeforeToday(ObjectHelpers.formatSqlDate(datePicker.getFormattedTextField().getText()))) {
                                // IF POST DATED
                                Notifiers.showErrorMessage("Post-Dating Not Allowed", "Post-dated checks are not allowed!");
                            } else {
                                checkLists.add(new CheckPayments(
                                    ObjectHelpers.generateIDandRandString(),
                                    null,
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
                        } else {
                            Notifiers.showErrorMessage("No Check Date Provided", "Please input check date!");
                        }
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
                    if (datePicker.getFormattedTextField().getValue() != null) {
                        if (ObjectHelpers.isBeforeToday(ObjectHelpers.formatSqlDate(datePicker.getFormattedTextField().getText()))) {
                            // IF POST DATED
                            Notifiers.showErrorMessage("Post-Dating Not Allowed", "Post-dated checks are not allowed!");
                        } else {
                            checkLists.add(new CheckPayments(
                                ObjectHelpers.generateIDandRandString(),
                                null,
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
                    } else {
                        Notifiers.showErrorMessage("No Check Date Provided", "Please input check date!");
                    }
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
        if (billsList != null && billsList.size() > 0) {
            showTransactConfirmation();
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

    private void addAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAccountActionPerformed
        advancedSearch();
    }//GEN-LAST:event_addAccountActionPerformed

    private void clearBillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBillsActionPerformed
        try {
            billsList.clear();
            billsTable.setModel(new DefaultTableModel());
            resetForm();
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error clearing!", e.getMessage());
        }
    }//GEN-LAST:event_clearBillsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAccount;
    private javax.swing.JButton addCheckButton;
    private javax.swing.JTable billsTable;
    private javax.swing.JFormattedTextField cashPaymentField;
    private javax.swing.JTable checkTable;
    private javax.swing.JButton clearBills;
    private javax.swing.JButton clearChecksBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField orDateField;
    private javax.swing.JTextField orNumberField;
    private javax.swing.JFormattedTextField totalAmountPaid;
    private javax.swing.JButton transactBtn;
    private javax.swing.JButton unlockOrNumberBtn;
    // End of variables declaration//GEN-END:variables

    public void updateOR() {
        fetchOR();
        System.out.println("OR FETCHED FOR BILLS PAYMENT");
    }
    
    public void fetchOR() {
        currentOr = ORAssigningDao.getCurrentOR(connection, login.getId());
        if (currentOr != null) {
            nextOrNumber = Integer.parseInt(currentOr.getORumber()) + 1;
            orNumberField.setText(nextOrNumber + "");
//            accountNumberSearch.requestFocus();
        } else {
            nextOrNumber = Integer.parseInt(orNumber);
            orNumberField.setText(nextOrNumber + "");
//            accountNumberSearch.requestFocus();
        }
        // GET SCHEDULE OR DATE
        orDateField.setText(CollectionDateAdjustmentsDao.getActiveORDate(connection, login.getId()));
    }
    
    public double getCashRemainFromCheck() {
        double check = getTotalCheckPayments();
        return (totalAmountPayable + totalSurcharge) - check;
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
            
            cashPaymentField.setValue(getCashRemainFromCheck());
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
    
    public double getTotalAmount() {
        double cash = Double.valueOf(cashPaymentField.getValue() != null ? cashPaymentField.getValue().toString() : "0");
        double check = getTotalCheckPayments();
        return cash + check;
    }
    
    public void advancedSearch() {
        try {
            JDialog advancedSearchDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(getParent()));
            advancedSearchDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
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
            DefaultTableModel searchTableModel = new DefaultTableModel(searchCols, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                } 
            };

            searchField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

            searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/travel_explore_FILL0_wght700_GRAD0_opsz20.png"))); // NOI18N
            // SEARCH
            searchField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        if (searchTableModel != null && searchTableModel.getRowCount() > 0 && !resultsTable.isFocusOwner()) {
                            resultsTable.requestFocus();
                        }
                    } else {
                        if (searchField.getText().length() > 3) {
                            List<ServiceAccounts> results = ServiceAccountsDao.search(connection, searchField.getText());
                            int searchSize = results.size();
                            searchTableModel.setRowCount(searchSize);
                            for (int i=0; i<searchSize; i++) {
                                ServiceAccounts acctt = results.get(i);
                                searchTableModel.setValueAt(acctt.getOldAccountNo(), i, 0);
                                searchTableModel.setValueAt(acctt.getServiceAccountName(), i, 1);
                                searchTableModel.setValueAt(ServiceAccountsDao.getAddress(acctt), i, 2);
                                searchTableModel.setValueAt(acctt.getAccountType(), i, 3);
                                searchTableModel.setValueAt(acctt.getAccountStatus(), i, 4);
                            }

                            resultsTable.setModel(searchTableModel);
                            resultsTable.getColumnModel().getColumn(0).setWidth(40);
                            resultsTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
                        }
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
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
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
//                        accountNumberSearch.setValue(acct);
                        viewAccountForm(acct);
                        advancedSearchDialog.dispose();
                    }
                }                
            });
            
            resultsTable.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int selectedRow = resultsTable.getSelectedRow();
//                    super.keyReleased(e); //To change body of generated methods, choose Tools | Templates.
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        String acct = resultsTable.getModel().getValueAt(selectedRow, 0).toString();
//                        accountNumberSearch.setValue(acct);
                        viewAccountForm(acct);
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
    
    public void viewAccountForm(String accountNumber) {
        try {
            JDialog formDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(getParent()));
            formDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) size.getWidth();
            int y = (int) size.getHeight();
            formDialog.setLocation(x/6, y/6);
            formDialog.setTitle(accountNumber);
            
            /**
             * FETCH DATA
             */
            ServiceAccounts account = ServiceAccountsDao.getOneByOldAccountNumber(connection, accountNumber);
            List<Bills> billsList = BillsDao.getUnpaidBillsFromAccountId(connection, account.getId());
            
            JPanel mainPanel = new JPanel();
            
            JTable accountBillsTable;
            JLabel accountNameLabel;
            JLabel accountNumberLabel;
            JButton addBillsBtn;
            JLabel addressLabel;
            JLabel jLabel1;
            JScrollPane jScrollPane1;
            
            jScrollPane1 = new JScrollPane();
            accountBillsTable = new JTable();
            jLabel1 = new JLabel();
            accountNameLabel = new JLabel();
            accountNumberLabel = new JLabel();
            addressLabel = new JLabel();
            addBillsBtn = new JButton();
            
            Object[] columnNames = {"*", "Bill Number", "Billing Month", "Due Date", "Amount Due", "Surcharge", "Total Amount Due"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    Bills bill = billsList.get(row);
                    if (ObjectHelpers.isAfterDue(bill)) {
                        // DISABLE SELECT IF BILL IS DUE
                        // BUT CHECK FIRST IF SKIPPING IS ALLOWED
                        if (bill.getItem3() != null && (bill.getItem3().equals("SKIP_AUTO") | bill.getItem3().equals("SKIP_MANUAL"))) {
                            if (column == 0) {
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }                        
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
                        default:
                            return String.class;
                    }
                } 
            };
            
            /**
             * POPULATE TABLE
             */
            int listSize = billsList.size();
            model.setRowCount(listSize);
            for (int i=0; i<listSize; i++) {
                Bills bill = billsList.get(i);
                double surcharge = 0;
                if (bill.getSurchargeWaived() != null && bill.getSurchargeWaived().equals("APPROVED")) {
                    surcharge = 0;
                } else {
                    surcharge = Double.valueOf(ObjectHelpers.roundTwoNoComma(BillsDao.getSurcharge(bill) + ""));
                }
                
                // VALIDATE SKIP IN UI
                if (bill.getItem3() != null && bill.getItem3().equals("SKIP_AUTO")) {
                    model.setValueAt(false, i, 0);
                } else {                    
                    model.setValueAt(true, i, 0);
                }  
                model.setValueAt(bill.getBillNumber(), i, 1);
                model.setValueAt(bill.getServicePeriod(), i, 2);
                model.setValueAt(bill.getDueDate(), i, 3);
                model.setValueAt(bill.getBalance(), i, 4);
                model.setValueAt(surcharge, i, 5);
                model.setValueAt(ObjectHelpers.roundTwo(ObjectHelpers.getTotals(Double.valueOf(bill.getBalance()), surcharge)), i, 6);
            }            

            accountBillsTable.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
            accountBillsTable.setModel(model);
            accountBillsTable.setRowHeight(28);
            jScrollPane1.setViewportView(accountBillsTable);
            accountBillsTable.getColumnModel().getColumn(0).setMaxWidth(40);

            jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(153, 153, 153));
            jLabel1.setText("Select Bills to Pay");

            accountNameLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
            accountNameLabel.setText(account.getServiceAccountName());

            accountNumberLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
            accountNumberLabel.setText(account.getOldAccountNo());

            addressLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
            addressLabel.setForeground(new java.awt.Color(102, 102, 102));
            String address = ServiceAccountsDao.getAddress(account);
            addressLabel.setText(address);

            addBillsBtn.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
            addBillsBtn.setText("Add Bills");
            
            addBillsBtn.addActionListener((e) -> {
                if (account.getAccountStatus() != null && account.getAccountStatus().equals("DISCONNECTED")) {
                    if (JOptionPane.showConfirmDialog(null, "This account has been DISCONNECTED. Do you want to automatically add Reconnection Fee?", "Attach Reconnection Fee", JOptionPane.WARNING_MESSAGE) == 0) {
                        addOns.add(new MultipleAccountAddIns(account.getOldAccountNo(), account.getId(), account.getServiceAccountName(), "", "Reconnection Fee", 56));
                    }
                }
                
                for (int i=0; i<listSize; i++) {
                    if ((Boolean) model.getValueAt(i, 0)) {
                        Bills bill = billsList.get(i);                        
                        double surcharge = 0;
                        boolean isRemovable = false;
                        if (bill.getSurchargeWaived() != null && bill.getSurchargeWaived().equals("APPROVED")) {
                            surcharge = 0;
                        } else {
                            surcharge = Double.valueOf(ObjectHelpers.roundTwoNoComma(BillsDao.getSurcharge(bill) + ""));
                        }
                        
                        if (ObjectHelpers.isAfterDue(bill)) {
                            if (bill.getItem3() != null && bill.getItem3().equals("SKIP_AUTO")) {
                                isRemovable = true;
                            } else {                    
                                isRemovable = false;
                            }
                        } else {
                            isRemovable = true;
                        }
                        
                        MultipleAccountBills multipleAccountBills = new MultipleAccountBills(bill.getId(), 
                                account.getServiceAccountName(), 
                                account.getOldAccountNo(), 
                                account.getId(), 
                                address, 
                                bill.getServicePeriod(), 
                                bill.getDueDate(), 
                                bill.getBalance(), 
                                surcharge + "", 
                                ObjectHelpers.roundTwoNoComma(ObjectHelpers.getTotals(Double.valueOf(bill.getBalance()), surcharge)),
                                isRemovable,
                                0,
                                0
                        );
                        
                        if (this.billsList.stream().map(MultipleAccountBills::getBillId).anyMatch(multipleAccountBills.getBillId()::equals)) {
                            
                        } else {
                            this.billsList.add(multipleAccountBills);
                        }
                    }
                }   
                
                populateBillsTable();
                formDialog.dispose();
            });
            
            addBillsBtn.setFocusable(true);
            addBillsBtn.requestFocus();

            GroupLayout layout = new GroupLayout(mainPanel);
            mainPanel.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(accountNameLabel)
                                .addComponent(accountNumberLabel)
                                .addComponent(addressLabel))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(addBillsBtn)))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(accountNameLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(accountNumberLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(addressLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(addBillsBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            formDialog.add(mainPanel);
            formDialog.pack();
            formDialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error Getting Account", e.getMessage());
        }
    }
    
    public double getReconnectionFee(MultipleAccountBills mb) {
        return ObjectHelpers.roundTwoNoCommaDouble(mb.getReconnectionFee() + mb.getReconnectionFeeVAT());
    }
    
    public void populateBillsTable() {
        try {
            int billsSize = billsList.size();
            int addOnsSize = addOns.size();
            model = new DefaultTableModel(columnNames, billsSize + addOnsSize) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            
            totalAmountPayable = 0;
            totalSurcharge = 0;
            totalReconnectionFee = 0;
            int billCounter = 0;
            for (int i=0; i<billsSize; i++) {
                MultipleAccountBills bill = billsList.get(i);
                model.setValueAt("BILL", i, 0);
                model.setValueAt(bill.getAccountNumber(), i, 1);
                model.setValueAt(bill.getAccountName(), i, 2);                
                model.setValueAt(ObjectHelpers.formatReadableDate(bill.getBillingMonth()), i, 3);
                model.setValueAt(ObjectHelpers.formatShortDate(bill.getDueDate()), i, 4);
                model.setValueAt(bill.getAmountDue(), i, 5);
                model.setValueAt(bill.getSurcharge(), i, 6);
                model.setValueAt(bill.getTotalAmountDue(), i, 7);
                model.setValueAt(i, i, 8);
                
                totalAmountPayable += ObjectHelpers.doubleStringNull(bill.getAmountDue());
                totalSurcharge += ObjectHelpers.doubleStringNull(bill.getSurcharge());
                billCounter = i;
            }
            
            billCounter += 1;
            for (int x=0; x<addOnsSize; x++) {
                MultipleAccountAddIns addOn = addOns.get(x);
                model.setValueAt("ADD-ON", (x + billCounter), 0);
                model.setValueAt(addOn.getAccountNumber(), (x + billCounter), 1);
                model.setValueAt(addOn.getAccountName(), (x + billCounter), 2);                
                model.setValueAt(addOn.getAddOnName(), (x + billCounter), 3);
                model.setValueAt("", (x + billCounter), 4);
                model.setValueAt("", (x + billCounter), 5);
                model.setValueAt("", (x + billCounter), 6);
                model.setValueAt(addOn.getAddOnAmount(), (x + billCounter), 7);
                model.setValueAt(x, (x + billCounter), 8);
                
                totalReconnectionFee += ObjectHelpers.doubleStringNull(addOn.getAddOnAmount() + "");
            }
            
            billsTable.setModel(model);
            
            billsTable.getColumnModel().getColumn(8).setMinWidth(0);
            billsTable.getColumnModel().getColumn(8).setMaxWidth(0);
            billsTable.getColumnModel().getColumn(8).setWidth(0);
            
            cashPaymentField.setValue(getTotalPayable());
            cashPaymentField.requestFocus();
            if (billsSize > 0) {
                setPaymentModuleEnabled(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error populating bills table", e.getMessage());
        }
    }
    
    public Double getTotalPayable() {
        try {
            double total = totalAmountPayable + totalSurcharge + totalReconnectionFee;
            return total;
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error getting total", e.getMessage());
            return 0.0;
        }
    }
    
    public void showTotalPayable() {
        cashPaymentField.requestFocus();
        selectCashAmount();
    }
    
    public void selectCashAmount() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                cashPaymentField.selectAll();
            }
        });  
    }
    
    public void focus() {        
        setFocusable(true);
        requestFocusInWindow();
    }
    
    public void setPaymentModuleEnabled(boolean condition) {
        if (condition) {
            cashPaymentField.setEnabled(true);
            addCheckButton.setEnabled(true);
            clearChecksBtn.setEnabled(true);
        } else {
            cashPaymentField.setEnabled(false);
            addCheckButton.setEnabled(false);
            clearChecksBtn.setEnabled(false);
        }
    }
    
    public void addBillsTablePopupMenu(JTable table) {
        try {
            JPopupMenu popupMenu = new JPopupMenu();
            JMenuItem removeItem = new JMenuItem("Remove Item");
            JMenuItem viewAccount = new JMenuItem("View Account");
            
            removeItem.addActionListener((ActionEvent e) -> {
                try {
                    int index = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 8).toString());
                    if (table.getValueAt(table.getSelectedRow(), 0).toString().equals("BILL")) {
                        if (billsList.get(index).isRemovable()) {
                            billsList.remove(index);
                        } else {
                            Notifiers.showErrorMessage("Not Allowed", "Removing bill that's beyond due date is prohibited, unless allowed by the management.");
                        }
                    } else {
                        addOns.remove(index);
                    }
                    populateBillsTable();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Notifiers.showErrorMessage("Error removing item", ex.getMessage());
                }
            });
            
            viewAccount.addActionListener((ActionEvent e) -> {
                try {
                    JDialog formDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(getParent()));
                    formDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    formDialog.setLocation(50, 50);
                    formDialog.setTitle("View Account");
                    
                    int index = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 8).toString());
                    String accountId = "";
                    if (table.getValueAt(table.getSelectedRow(), 0).toString().equals("BILL")) {
                        accountId = billsList.get(index).getAccountId();
                    } else {
                        accountId = addOns.get(index).getAccountId();
                    }
                    
                    AccountBrowser browserPanel = new AccountBrowser(accountId);
                    
                    formDialog.add(browserPanel);
                    formDialog.pack();
                    formDialog.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
                    
            popupMenu.addPopupMenuListener(new PopupMenuListener() {
                @Override
                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            int rowAtPoint = table.rowAtPoint(SwingUtilities.convertPoint(popupMenu, new Point(0, 0), table));
                            if (rowAtPoint > -1) {
                                table.setRowSelectionInterval(rowAtPoint, rowAtPoint);
                            }
                        }
                    });
                }

                @Override
                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void popupMenuCanceled(PopupMenuEvent e) {
                    
                }
            });
            popupMenu.add(removeItem);
            popupMenu.add(viewAccount);
            table.setComponentPopupMenu(popupMenu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void transact() {
        try {   
            if (getTotalAmount() >= (totalAmountPayable + totalSurcharge + totalReconnectionFee)) {
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
                
                // SORT ACCOUNT FIRST
                Collections.sort(billsList, (o1, o2) -> o1.getAccountNumber().compareTo(o2.getAccountNumber()));
                
                int size = billsList.size();
                
                // STORE THE SAME ACCOUNT NUMBERS
                List<String> accountsList = new ArrayList();
                
                // GET STARTING OR
                int ORStart = Integer.parseInt(orNumberField.getText());
                String ORTransact = "";
                
                // LOOP ACCOUNTS FOR PAYMENT
                for (int i=0; i<size; i++) {
                    MultipleAccountBills multipleAccountBills = billsList.get(i);
                    
                    // STORE THE SAME ACCOUNT NUMBERS
                    if (!accountsList.contains(multipleAccountBills.getAccountNumber())) {
                        accountsList.add(multipleAccountBills.getAccountNumber());
                        
                        /**
                         * =========================================================
                         * SAVE OR ASSIGNING
                         * =========================================================
                         */
                        ORTransact = ORStart + "";
                        ORAssigning orNew = new ORAssigning(
                                ObjectHelpers.generateIDandRandString(),
                                ORTransact,
                                login.getId(),
                                ObjectHelpers.getSqlDate(),
                                null,
                                ObjectHelpers.getSqlTime(),
                                office,
                                ObjectHelpers.getCurrentTimestamp(),
                                ObjectHelpers.getCurrentTimestamp()
                        );
                        ORAssigningDao.insert(connection, orNew);
                        
                        ORStart += 1;
                    }
                    
                    Bills bill = BillsDao.getOneById(connection, multipleAccountBills.getBillId());
                    
                    /**
                     * =========================================================
                     * INSERT TO Cashier_PaidBills
                     * =========================================================
                     */
                    PaidBills paidBill = new PaidBills(
                            ObjectHelpers.generateIDandRandString(),
                            bill.getBillNumber(),
                            bill.getAccountNumber(),
                            bill.getServicePeriod(),
                            ORTransact,
                            orDateField.getText(),
                            null,
                            bill.getKwhUsed(),
                            login.getId(),
                            office,
                            ObjectHelpers.getSqlDate(),
                            ObjectHelpers.getSqlTime(),
                            ObjectHelpers.roundTwoNoComma(multipleAccountBills.getSurcharge()), // SURCHARGE
                            bill.getEvat2Percent(),
                            bill.getEvat5Percent(),
                            bill.getAdditionalCharges(),
                            bill.getDeductions(),
                            ObjectHelpers.roundTwoNoComma(multipleAccountBills.getTotalAmountDue()),
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
                    if (PaidBillsDao.insert(connection, paidBill)) {
                        successStream = true;
                    } else {
                        successStream = false;
                        break;
                    }
                    
                    /**
                     * =========================================================
                     * UPDATE BILL
                     * =========================================================
                     */
                    bill.setPaidAmount(multipleAccountBills.getTotalAmountDue());
                    bill.setBalance("0");
                    BillsDao.updateBills(connection, bill);
                    
                    /**
                     * =========================================================
                     * SAVE TO Cashier_BillMirror
                     * =========================================================
                     */
                    BillMirror billMirror = BillMirrorDao.bridgeFromBill(bill);
                    billMirror.setId(ObjectHelpers.generateIDandRandString());
                    billMirror.setORNumber(paidBill.getORNumber());
                    billMirror.setORDate(paidBill.getORDate());
                    billMirror.setTeller(paidBill.getTeller());
                    billMirror.setPaidBillId(paidBill.getId());
                    BillMirrorDao.insert(connection, billMirror);
                    
                    /**
                     * =========================================================
                     * UPDATE IF THERE ARE OCLs/TERMED PAYMENTS EMBEDDED
                     * =========================================================
                     */
                    double termedPayments = ObjectHelpers.doubleStringNull(bill.getTermedPayments());
                    if (termedPayments > 0) {
                        List<OCLMonthly> termedList = OCLMonthlyDao.getTermedPaymentThisMonth(connection, multipleAccountBills.getBillingMonth(), multipleAccountBills.getAccountId());
                        
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
                    
                    /**
                     * =========================================================
                     * SAVE ADDONS IF THERE ARE ANY
                     * =========================================================
                     */
                    int addInsId = getIndexOfSelectedList(multipleAccountBills.getAccountId(), addOns);
                    
                    if (addInsId > -1) {
                        MultipleAccountAddIns addIns = addOns.get(addInsId);
                        
                        String transId = i + ObjectHelpers.getTimeInMillis();
                        TransactionIndex transaction = new TransactionIndex(
                                transId,
                                office + "-" + transId,
                                addIns.getAccountName(),
                                addIns.getAddOnName() + " of " + addIns.getAccountName(),
                                paidBill.getORNumber(),
                                ObjectHelpers.getSqlDate(),
                                0 + "",
                                0 + "",
                                ObjectHelpers.roundTwoNoComma(addIns.getAddOnAmount() + ""),
                                null,
                                login.getId(),
                                null,
                                null,
                                null,
                                addIns.getAddOnName(),
                                paymentUsed,
                                null,
                                null,
                                null,
                                null,
                                null,
                                addIns.getAddOnName(),
                                null,
                                null, 
                                null,
                                paidBill.getAccountNumber(),
                                ObjectHelpers.getCurrentTimestamp(),
                                ObjectHelpers.getCurrentTimestamp()
                        );

                        TransactionIndexDao.insert(connection, transaction);
                    }
                    
                    /**
                     * =========================================================
                     * SAVE PAID BILL DETAILS
                     * =========================================================
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
                                    multipleAccountBills.getAccountId(),
                                    bill.getServicePeriod(),
                                    null,
                                    paidBill.getORNumber(),
                                    ObjectHelpers.roundTwoNoComma(multipleAccountBills.getTotalAmountDue() + ""),
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
                }
                
                /**
                 * LOOP ACCOUNTS FOR PRINTING
                 * MAKE SURE ITS SEGREGATED PER ACCOUNT
                 */
                for (int i=0; i<accountsList.size(); i++) {
                }
                
                fetchOR();
                resetForm();
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
            } else {
                Notifiers.showErrorMessage("Insufficient Amount", "The total amount paid should not be less than the total amount payable!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Notifiers.showErrorMessage("Error performing transaction", e.getMessage());
        }
    }
    
    public void resetForm() {
        billsList.clear();
        addOns.clear();
        totalAmountPayable = 0;
        totalSurcharge = 0;
        totalReconnectionFee = 0;
        checkLists.clear();
        cashPaymentField.setValue(0);
    }
    
    public int getIndexOfSelectedList(String regex, List<MultipleAccountAddIns> values) {
        try {
            int index = IntStream.range(0, values.size())
                .filter(i -> Objects.equals(values.get(i).getAccountId(), regex))
                .findFirst()
                .orElse(-1);
            
            return index;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
