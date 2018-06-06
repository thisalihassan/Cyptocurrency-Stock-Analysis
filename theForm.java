package sproject2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class theForm extends javax.swing.JFrame {

    /**
     * Creates new form theForm
     */
    private int a, b;
    sqlConnect sql;
    ArrayList<String> arr;
    private String selected = null;
    private String selected2 = null;

    public theForm() {
        initComponents();
        sql = new sqlConnect();
        arr = tableList("company");
        jGraph.setVisible(false);
        sdate.setVisible(false);
        searchPanel.setVisible(false);
        jPanel9.setVisible(false);
        Drop.setVisible(false);
        
        searchbox.addItemListener((e)->
                {
                    selectSection((String)searchbox.getSelectedItem());
                    addDates();
                }
           );     
        jComboBox2.addItemListener((e)->
        {
            selected2=(String)jComboBox2.getSelectedItem();
             addDates2();
        });
        
    }
    
    public void reset(){
        arr = tableList("company");
        searchbox.addItemListener((e)->
                {
                    selectSection((String)searchbox.getSelectedItem());
                    addDates();
                }
        );
    }
    
    private void addDates(){
        if(selected != null){
            StartDate.removeAllItems();
            EndDate.removeAllItems();
        try {
            String query = "select Datee from "+selected;
            Statement st = (Statement) sql.getConnection().createStatement();
            ResultSet myRs = st.executeQuery(query);
            while(myRs.next()){
                StartDate.addItem(myRs.getString("Datee"));
                EndDate.addItem(myRs.getString("Datee"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(theForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    private void addDates2(){
        if(selected2 != null){
            jComboBox3.removeAllItems();
        try {
            String query = "select Datee from "+selected2;
            Statement st = (Statement) sql.getConnection().createStatement();
            ResultSet myRs = st.executeQuery(query);
            while(myRs.next()){
                jComboBox3.addItem(myRs.getString("Datee"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(theForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    } 

    private ArrayList<String> tableList(String choice) {
        ArrayList<String> tableList = new ArrayList<>();
        ArrayList<String> tableList2 = new ArrayList<>();
        CompanyCombo.removeAllItems();
        graphCombo.removeAllItems();
        searchbox.removeAllItems();
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        try {
            String query = "select Company,Symbol from StockMarket";
            Statement st = (Statement) sql.getConnection().createStatement();
            ResultSet myRs = st.executeQuery(query);
            while (myRs.next()) {
                CompanyCombo.addItem(myRs.getString("Company"));
                jComboBox1.addItem(myRs.getString("Company"));
                graphCombo.addItem(myRs.getString("Company"));
                searchbox.addItem(myRs.getString("Company"));
                jComboBox2.addItem(myRs.getString("Company"));
                tableList.add(myRs.getString("Company"));
                tableList2.add(myRs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(theForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (choice.equalsIgnoreCase("symbol")) {
            return tableList2;
        } else {
            return tableList;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sdate = new javax.swing.JPanel();
        symbolLabel = new javax.swing.JLabel();
        company = new javax.swing.JTextField();
        symbol = new javax.swing.JTextField();
        insertTable = new javax.swing.JLabel();
        companyLabel1 = new javax.swing.JLabel();
        stockInsert = new javax.swing.JButton();
        stockNoteLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        CloseLabel = new javax.swing.JLabel();
        valueInStock = new javax.swing.JButton();
        open = new javax.swing.JTextField();
        close = new javax.swing.JTextField();
        High = new javax.swing.JTextField();
        Low = new javax.swing.JTextField();
        StockLabel1 = new javax.swing.JLabel();
        StockLabel = new javax.swing.JLabel();
        lowPrice = new javax.swing.JLabel();
        Manual1 = new javax.swing.JLabel();
        highPrice1 = new javax.swing.JLabel();
        CompanyCombo = new javax.swing.JComboBox<>();
        volume = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jGraph = new javax.swing.JPanel();
        last7days = new javax.swing.JButton();
        PlotGraph = new javax.swing.JLabel();
        Company1 = new javax.swing.JTextField();
        Company2 = new javax.swing.JTextField();
        versus = new javax.swing.JLabel();
        last3Months = new javax.swing.JButton();
        last30Days = new javax.swing.JButton();
        PlotGraph1 = new javax.swing.JLabel();
        last7days1 = new javax.swing.JButton();
        last3Months1 = new javax.swing.JButton();
        last30Days1 = new javax.swing.JButton();
        AllTime = new javax.swing.JButton();
        graphCombo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        PlotGraph2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1012 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        searchPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        searchbox = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        setStock = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        StartDate = new javax.swing.JComboBox<>();
        EndDate = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Drop = new javax.swing.JPanel();
        insertTable1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        insertTable2 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        high2 = new javax.swing.JTextField();
        open2 = new javax.swing.JTextField();
        volume2 = new javax.swing.JTextField();
        close2 = new javax.swing.JTextField();
        low2 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        HomePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(780, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sdate.setBackground(new java.awt.Color(32, 47, 90));
        sdate.setMinimumSize(new java.awt.Dimension(780, 500));
        sdate.setPreferredSize(new java.awt.Dimension(780, 500));
        sdate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        symbolLabel.setForeground(new java.awt.Color(255, 255, 255));
        symbolLabel.setText("Symbol");
        sdate.add(symbolLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));
        sdate.add(company, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 120, 30));
        sdate.add(symbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 120, 30));

        insertTable.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        insertTable.setForeground(new java.awt.Color(255, 255, 255));
        insertTable.setText("New Stock");
        sdate.add(insertTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        companyLabel1.setForeground(new java.awt.Color(255, 255, 255));
        companyLabel1.setText("Company");
        sdate.add(companyLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        stockInsert.setText("Insert");
        stockInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockInsertActionPerformed(evt);
            }
        });
        sdate.add(stockInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 120, 40));

        stockNoteLabel.setText("Note: You must Enter a unique Company Name and Symbol.");
        sdate.add(stockNoteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 530, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CloseLabel.setBackground(new java.awt.Color(255, 255, 255));
        CloseLabel.setText("Close Price");
        jPanel1.add(CloseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 120, -1));

        valueInStock.setText("Insert");
        valueInStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueInStockActionPerformed(evt);
            }
        });
        jPanel1.add(valueInStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 120, 40));
        jPanel1.add(open, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 120, 30));
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 120, 30));
        jPanel1.add(High, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 120, 30));
        jPanel1.add(Low, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 120, 30));

        StockLabel1.setBackground(new java.awt.Color(255, 255, 255));
        StockLabel1.setText("Stock");
        jPanel1.add(StockLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 60, -1));

        StockLabel.setBackground(new java.awt.Color(255, 255, 255));
        StockLabel.setText("Open Price");
        jPanel1.add(StockLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 110, -1));

        lowPrice.setBackground(new java.awt.Color(255, 255, 255));
        lowPrice.setText("Low");
        jPanel1.add(lowPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 60, -1));

        Manual1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Manual1.setText("Insert in Stock");
        jPanel1.add(Manual1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        highPrice1.setBackground(new java.awt.Color(255, 255, 255));
        highPrice1.setText("High");
        jPanel1.add(highPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 60, -1));

        CompanyCombo.setModel(CompanyCombo.getModel());
        CompanyCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompanyComboActionPerformed(evt);
            }
        });
        jPanel1.add(CompanyCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 30));
        jPanel1.add(volume, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 120, 30));

        jLabel21.setText("Volume");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        sdate.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 760, 180));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel15MouseDragged(evt);
            }
        });
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });
        jPanel12.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 700, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sproject2/IMAGES/Close Window_25px.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, -1, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sproject2/IMAGES/Go Back_25px.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        sdate.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 30));

        getContentPane().add(sdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 610));

        jPanel9.setMinimumSize(new java.awt.Dimension(780, 500));
        jPanel9.setPreferredSize(new java.awt.Dimension(780, 500));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company", "Symbol", "Date", "Open", "High", "Low", "Close", "AdjClose", "Volume"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel9.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 86, 770, 410));

        jPanel14.setBackground(new java.awt.Color(32, 47, 90));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("Go!");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sproject2/IMAGES/Go Back_25px.png"))); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 30, 30));

        jPanel9.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 770, 90));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, -1));

        jGraph.setBackground(new java.awt.Color(230, 230, 240));
        jGraph.setMinimumSize(new java.awt.Dimension(780, 500));
        jGraph.setPreferredSize(new java.awt.Dimension(780, 500));
        jGraph.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        last7days.setText("Last 7D");
        last7days.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last7daysActionPerformed(evt);
            }
        });
        jGraph.add(last7days, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        PlotGraph.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        PlotGraph.setText("Total Volume in Industry");
        jGraph.add(PlotGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        Company1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        jGraph.add(Company1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 120, 30));

        Company2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));
        jGraph.add(Company2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 120, 30));

        versus.setBackground(new java.awt.Color(255, 255, 255));
        versus.setText("       Vs.");
        jGraph.add(versus, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 60, -1));

        last3Months.setText("Last 3 Months");
        last3Months.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last3MonthsActionPerformed(evt);
            }
        });
        jGraph.add(last3Months, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        last30Days.setText("Last 30D");
        last30Days.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last30DaysActionPerformed(evt);
            }
        });
        jGraph.add(last30Days, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        PlotGraph1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        PlotGraph1.setText("Compare Graphs");
        jGraph.add(PlotGraph1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        last7days1.setText("Last 7D");
        last7days1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last7days1ActionPerformed(evt);
            }
        });
        jGraph.add(last7days1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, -1, -1));

        last3Months1.setText("Last 3 Months");
        last3Months1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last3Months1ActionPerformed(evt);
            }
        });
        jGraph.add(last3Months1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, -1));

        last30Days1.setText("Last 30D");
        last30Days1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last30Days1ActionPerformed(evt);
            }
        });
        jGraph.add(last30Days1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, -1, -1));

        AllTime.setText("AllTime");
        AllTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllTimeActionPerformed(evt);
            }
        });
        jGraph.add(AllTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 90, -1));

        graphCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        graphCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphComboActionPerformed(evt);
            }
        });
        jGraph.add(graphCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sproject2/IMAGES/Close Window_25px.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jGraph.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, -1, 30));

        PlotGraph2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        PlotGraph2.setText("Single Graphs");
        jGraph.add(PlotGraph2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        jButton1.setText("Crypto Currency Volume");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jGraph.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 170, 50));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel10MouseDragged(evt);
            }
        });
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });
        jPanel11.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 720, 30));

        jLabel1012.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sproject2/IMAGES/Go Back_25px.png"))); // NOI18N
        jLabel1012.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1012MouseClicked(evt);
            }
        });
        jPanel11.add(jLabel1012, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, -1));

        jGraph.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        jPanel4.setBackground(new java.awt.Color(32, 47, 90));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sproject2/IMAGES/Stocks_96px.png"))); // NOI18N
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 100, 180));

        jGraph.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 210, 470));

        getContentPane().add(jGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 450));

        searchPanel.setMinimumSize(new java.awt.Dimension(780, 500));
        searchPanel.setPreferredSize(new java.awt.Dimension(780, 500));
        searchPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(32, 47, 90));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });
        jPanel3.add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, -1, -1));

        setStock.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        setStock.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(setStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 350, 60));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sproject2/IMAGES/Google Web Search_48px.png"))); // NOI18N
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        StartDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "StartDate" }));
        StartDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartDateActionPerformed(evt);
            }
        });
        jPanel3.add(StartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        EndDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EndDate" }));
        jPanel3.add(EndDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("To");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, -1, -1));

        jButton4.setText("Search two");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 160, 40));

        searchPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 780, 210));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Open", "High", "Low", "Close", "AdjClose", "Volume"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        searchPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 780, 260));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel18MouseDragged(evt);
            }
        });
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel18MousePressed(evt);
            }
        });
        jPanel13.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 700, 30));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sproject2/IMAGES/Close Window_25px.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel13.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, -1, 30));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sproject2/IMAGES/Go Back_25px.png"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel13.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        searchPanel.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 30));

        getContentPane().add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Drop.setBackground(new java.awt.Color(32, 47, 90));
        Drop.setMinimumSize(new java.awt.Dimension(780, 500));
        Drop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        insertTable1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        insertTable1.setForeground(new java.awt.Color(255, 255, 255));
        insertTable1.setText("Alter Stocks");
        Drop.add(insertTable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        Drop.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jButton5.setText("Drop Stock!");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Drop.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 110, 30));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Warning: When Stock Remove, it cannot be restored");
        Drop.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        Drop.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        Drop.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        insertTable2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        insertTable2.setForeground(new java.awt.Color(255, 255, 255));
        insertTable2.setText("Drop Stock");
        Drop.add(insertTable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Low");
        Drop.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, -1, -1));
        Drop.add(high2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 90, 30));
        Drop.add(open2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 90, 30));
        Drop.add(volume2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 90, 30));
        Drop.add(close2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 90, 30));
        Drop.add(low2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 90, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Dates");
        Drop.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Open");
        Drop.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("High");
        Drop.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Volume");
        Drop.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Close");
        Drop.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, -1));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sproject2/IMAGES/Go Back_25px.png"))); // NOI18N
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });
        Drop.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton6.setText("AlterStock");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Drop.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, 110, 30));

        getContentPane().add(Drop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 500));

        HomePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        HomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(32, 47, 90));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(106, 116, 145));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sproject2/IMAGES/Google Web Search_96px.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, 110));

        jLabel3.setText("Search");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 150, 150));

        jPanel6.setBackground(new java.awt.Color(106, 116, 145));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sproject2/IMAGES/Form_96px.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, 110));

        jLabel5.setText("Insert Stocks");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 150, 150));

        jPanel8.setBackground(new java.awt.Color(106, 116, 145));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sproject2/IMAGES/Stocksgra_96px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, 110));

        jLabel7.setText("    Graphs");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 150, 150));

        jPanel15.setBackground(new java.awt.Color(106, 116, 145));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sproject2/IMAGES/Delete Database_104px.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel15.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel24.setText("Delete/Alter");
        jPanel15.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jPanel2.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 150, 150));

        HomePanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 750, 320));

        jPanel7.setBackground(new java.awt.Color(0, 18, 50));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        HomePanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sproject2/IMAGES/Stocks_96px.png"))); // NOI18N
        jLabel1.setText("Crypto Stock Analysis");
        HomePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel9MouseDragged(evt);
            }
        });
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 720, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sproject2/IMAGES/Close Window_25px.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, -1, 30));

        HomePanel.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 30));

        getContentPane().add(HomePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void valueInStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueInStockActionPerformed
            InsertData into = new InsertData((String)CompanyCombo.getSelectedItem(),open.getText(),High.getText(),Low.getText(),close.getText(),volume.getText());
            open.setText("");
            High.setText("");
            Low.setText("");
            close.setText("");
            volume.setText("");
    }//GEN-LAST:event_valueInStockActionPerformed

    private void CompanyComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompanyComboActionPerformed

    }//GEN-LAST:event_CompanyComboActionPerformed

    private void last7daysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_last7daysActionPerformed
        if (!Company1.getText().isEmpty() && !Company2.getText().isEmpty()) {
            SwingUtilities.invokeLater(() -> {
                LineClass a = new LineClass(Company1.getText(), Company2.getText(), 7);
                a.setAlwaysOnTop(true);
            a.pack();
            a.setSize(600, 400);
            a.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            a.setVisible(true);
            });
        } else {
            JOptionPane.showMessageDialog(null, "Please enter both Company names");
            company.setText("");
            symbol.setText("");
        }
    }//GEN-LAST:event_last7daysActionPerformed

    private void stockInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockInsertActionPerformed
        if (company.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Unique Company and Symbol");
        } else if (symbol.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Unique Company and Symbol");
        } else {
            Boolean matched = false;        
            String val = (String) CompanyCombo.getSelectedItem();
            for (int i = 0; i < arr.size(); i++) {
                if (company.getText().equalsIgnoreCase(arr.get(i))) {
                    matched = true;
                }
            }

            if (!matched) {
                InsertData b = new InsertData(company.getText(), symbol.getText());
                b.InsertData();
                company.setText("");
                symbol.setText("");
                reset();
            } else {
                JOptionPane.showMessageDialog(null, "Company and Symbol must be unique");
                company.setText("");
                symbol.setText("");
            }
        }

    }//GEN-LAST:event_stockInsertActionPerformed

    private void last3MonthsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_last3MonthsActionPerformed
        if (!Company1.getText().isEmpty() && !Company2.getText().isEmpty()) {
            SwingUtilities.invokeLater(() -> {
                LineClass a = new LineClass(Company1.getText(), Company2.getText(), 90);
                a.setAlwaysOnTop(true);
            a.pack();
            a.setSize(600, 400);
            a.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            a.setVisible(true);
            });
        } else {
            JOptionPane.showMessageDialog(null, "Please enter both Company names");
            company.setText("");
            symbol.setText("");
        }
    }//GEN-LAST:event_last3MonthsActionPerformed

    private void last30DaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_last30DaysActionPerformed
        if (!Company1.getText().isEmpty() && !Company2.getText().isEmpty()) {
            SwingUtilities.invokeLater(() -> {
                LineClass a = new LineClass(Company1.getText(), Company2.getText(), 30);
                a.setAlwaysOnTop(true);
            a.pack();
            a.setSize(600, 400);
            a.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            a.setVisible(true);
            });
        } else {
            JOptionPane.showMessageDialog(null, "Please enter both Company names");

        }
    }//GEN-LAST:event_last30DaysActionPerformed

    private void last7days1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_last7days1ActionPerformed

        SwingUtilities.invokeLater(() -> {
            LineClass a = new LineClass((String) graphCombo.getSelectedItem(), 7);
           a.setAlwaysOnTop(true);
            a.pack();
            a.setSize(600, 400);
            a.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            a.setVisible(true);
        });
    }//GEN-LAST:event_last7days1ActionPerformed

    private void last3Months1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_last3Months1ActionPerformed

        SwingUtilities.invokeLater(() -> {
            LineClass a = new LineClass((String) graphCombo.getSelectedItem(), 90);
            a.setAlwaysOnTop(true);
            a.pack();
            a.setSize(600, 400);
            a.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            a.setVisible(true);
        });
    }//GEN-LAST:event_last3Months1ActionPerformed

    private void last30Days1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_last30Days1ActionPerformed

        SwingUtilities.invokeLater(() -> {
            LineClass a = new LineClass((String) graphCombo.getSelectedItem(), 30);
           a.setAlwaysOnTop(true);
            a.pack();
            a.setSize(600, 400);
            a.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            a.setVisible(true);
        });
    }//GEN-LAST:event_last30Days1ActionPerformed

    private void graphComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_graphComboActionPerformed

    private void AllTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllTimeActionPerformed

        SwingUtilities.invokeLater(() -> {
            LineClass a = new LineClass((String) graphCombo.getSelectedItem(), 0);
            a.setAlwaysOnTop(true);
            a.pack();
            a.setSize(600, 400);
            a.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            a.setVisible(true);
        });
    }//GEN-LAST:event_AllTimeActionPerformed

    private void jLabel9MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - a, y - b);
    }//GEN-LAST:event_jLabel9MouseDragged

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        a = getX();
        b = getY();
    }//GEN-LAST:event_jLabel9MousePressed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        HomePanel.setVisible(false);
        searchPanel.setVisible(true);
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        HomePanel.setVisible(false);
        jGraph.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel10MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseDragged

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        jGraph.setVisible(false);
        HomePanel.setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel1012MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1012MouseClicked

        jGraph.setVisible(false);
        HomePanel.setVisible(true);
    }//GEN-LAST:event_jLabel1012MouseClicked

    private void jLabel15MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseDragged

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MousePressed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        sdate.setVisible(false);
        HomePanel.setVisible(true);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        HomePanel.setVisible(false);
        sdate.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       SwingUtilities.invokeLater(() -> {
      PieChart a = new PieChart("Total Volume of CryptoCurrency");
      a.setSize(800, 400);
      a.setLocationRelativeTo(null);
      a.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
      a.setVisible(true);
    });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel18MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseDragged

    private void jLabel18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MousePressed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        searchPanel.setVisible(false);
        HomePanel.setVisible(true);
    }//GEN-LAST:event_jLabel20MouseClicked

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        
    }//GEN-LAST:event_searchboxActionPerformed

    private void StartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StartDateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        showList();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        searchPanel.setVisible(false);
        jPanel9.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        showList2();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
       jPanel9.setVisible(false);
       searchPanel.setVisible(true);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        HomePanel.setVisible(false);
        Drop.setVisible(true);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       if((String)jComboBox1.getSelectedItem()!=null){
           Table newT = new Table((String)jComboBox1.getSelectedItem(),1);
           String query = "DELETE FROM StockMarket WHERE Company = '"+(String)jComboBox1.getSelectedItem()+"'";
          Statement mystatement;
           try {
               mystatement = (Statement) sql.getConnection().createStatement();
               mystatement.executeUpdate(query);
           } catch (SQLException ex) {
               Logger.getLogger(theForm.class.getName()).log(Level.SEVERE, null, ex);
           }
       
       }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.out.println("Here Done");
        if(!volume2.getText().isEmpty()){
             System.out.println("Here Done1");
        if(!open2.getText().isEmpty() && !close2.getText().isEmpty()){
             System.out.println("Here Done2");
             if(!high2.getText().isEmpty() && !low2.getText().isEmpty()){
                  System.out.println("Here Done3");
        try {
            String query = "update "+(String)jComboBox2.getSelectedItem()+" set open = "+new Double(open2.getText())+", high = "+new Double(high2.getText())+", low = "+new Double(low2.getText())+", close = "+new Double(close2.getText())+", ADJClose = "+new Double(close2.getText())+", Volume = "+new Double(volume2.getText())+" where Datee = TO_DATE('"+subStr((String)jComboBox3.getSelectedItem())+"', 'YYYY-MM-DD HH24:MI:SS')";
            Statement mystatement = (Statement) sql.getConnection().createStatement();
            mystatement.execute(query);
            System.out.println("Update Done");
        } catch (SQLException ex) {
            Logger.getLogger(theForm.class.getName()).log(Level.SEVERE, null, ex);
        }
             }
                }
                    }else{
                      System.out.println("Not Done");
                     }
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        Drop.setVisible(false);
        HomePanel.setVisible(true);
    }//GEN-LAST:event_jLabel32MouseClicked
    
    
        public ArrayList<StockMarket> tableList2(){
        ArrayList<StockMarket> tableList = new ArrayList<StockMarket>();
        
        Statement st;
        try {
            String query = "Select * from StockMarket where company = '" +selected+"'";
            st = (Statement) sql.getConnection().createStatement();
            ResultSet myRs = st.executeQuery(query);
            
            while(myRs.next()){
             StockMarket a = new StockMarket(myRs.getString(1), myRs.getString(2));
               tableList.add(a);
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(theForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tableList;
    }
        
             public ArrayList<TheTable> tableList3(){
        ArrayList<TheTable> tableList2 = new ArrayList<TheTable>();
        
        Statement st2;
        try {
            String query2 = " select * from "+selected;
            st2 = (Statement) sql.getConnection().createStatement();
            ResultSet myRs = st2.executeQuery(query2);
            
            
            while(myRs.next()){
             TheTable a = new TheTable(myRs.getString("Datee"),myRs.getString("Open"),myRs.getString("High"),myRs.getString("low"),myRs.getString("Close"),myRs.getString("AdjClose"),myRs.getString("Volume"));
               tableList2.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(theForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tableList2;
    }
    
        
    public void showList2(){
        ArrayList<StockMarket> theList = tableList2();
        ArrayList<TheTable> thelist2 = tableList3();
        DefaultTableModel tabelmodel =  (DefaultTableModel)jTable1.getModel();
        Object[] rows = new Object[10];
        
        for(int i =0; i<theList.size();i++){
            rows[0] = theList.get(i).getCompany();
            rows[1] = theList.get(i).getSymbol();
            tabelmodel.addRow(rows);
        }
        
        for(int i=0;i<thelist2.size();i++){
             rows[2] = thelist2.get(i).getDatee();
            rows[3] = thelist2.get(i).getOpen();
            rows[4] = thelist2.get(i).getHigh();
            rows[5] = thelist2.get(i).getLow();
            rows[6] = thelist2.get(i).getClose();
            rows[7] = thelist2.get(i).getAdjClose();
            rows[8] = thelist2.get(i).getVolume();
            tabelmodel.addRow(rows);
                     
              
        }
        
    }
    
    
    public String subStr(String str) {
        str = str.substring(0, str.length() - 2);
    return str;
}
    
     public ArrayList<TheTable> tableList(){
        ArrayList<TheTable> tableList = new ArrayList<TheTable>();
        Statement st;
        String startdate = subStr((String)StartDate.getSelectedItem());
        String lastdate = subStr((String)EndDate.getSelectedItem());
        try {
           String query = "select * from "+selected+" where Datee between TO_DATE('"+startdate+"', 'YYYY-MM-DD HH24:MI:SS') and TO_DATE('"+lastdate+"', 'YYYY-MM-DD HH24:MI:SS')";
 //   String query = "Select * from StockMarket where company = '" +selected+"'";  
     st = (Statement) sql.getConnection().createStatement();
            ResultSet myRs = st.executeQuery(query);
            
            while(myRs.next()){
                TheTable a = new TheTable(myRs.getString("Datee"),myRs.getString("Open"),myRs.getString("High"),myRs.getString("low"),myRs.getString("Close"),myRs.getString("AdjClose"),myRs.getString("Volume"));
               //StockMarket a = new StockMarket(myRs.getString(1), myRs.getString(2));
               tableList.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(theForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tableList;
    }
    
    public void showList(){
        ArrayList<TheTable> theList = tableList();
        DefaultTableModel tabelmodel =  (DefaultTableModel)jTable.getModel();
        Object[] rows = new Object[8];
        
        for(int i =0; i<theList.size();i++){
            rows[0] = theList.get(i).getDatee();
            rows[1] = theList.get(i).getOpen();
            rows[2] = theList.get(i).getHigh();
            rows[3] = theList.get(i).getLow();
            rows[4] = theList.get(i).getClose();
            rows[5] = theList.get(i).getAdjClose();
            rows[6] = theList.get(i).getVolume();
            tabelmodel.addRow(rows);
        }
        
    }
    
    
    
    private void selectSection(String item){
        selected = item;
         String query = "SELECT Close FROM ( SELECT Close FROM "+item+" ORDER BY Datee DESC ) WHERE ROWNUM <= 2";
            Statement st;
        try {
            st = (Statement) sql.getConnection().createStatement();
            ResultSet myRs = st.executeQuery(query);
            int i =0;
            float first = 0;
            float sec = 0;
            String val = null;
            while(myRs.next()){
                if(i==0){
                    first = new Float(myRs.getString("Close"));
                  val= String.format("%.2f", new Float(myRs.getString("Close")));
                  
                }
                if(i==1){
                    sec = new Float(myRs.getString("Close"));
                    val += String.format(" Change %.2f", (first-sec));
                }
                i++;
            }
              setStock.setText(val);
        } catch (SQLException ex) {
            Logger.getLogger(theForm.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(theForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(theForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(theForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(theForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new theForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AllTime;
    private javax.swing.JLabel CloseLabel;
    private javax.swing.JTextField Company1;
    private javax.swing.JTextField Company2;
    private javax.swing.JComboBox<String> CompanyCombo;
    private javax.swing.JPanel Drop;
    private javax.swing.JComboBox<String> EndDate;
    private javax.swing.JTextField High;
    private javax.swing.JPanel HomePanel;
    private javax.swing.JTextField Low;
    private javax.swing.JLabel Manual1;
    private javax.swing.JLabel PlotGraph;
    private javax.swing.JLabel PlotGraph1;
    private javax.swing.JLabel PlotGraph2;
    private javax.swing.JComboBox<String> StartDate;
    private javax.swing.JLabel StockLabel;
    private javax.swing.JLabel StockLabel1;
    private javax.swing.JTextField close;
    private javax.swing.JTextField close2;
    private javax.swing.JTextField company;
    private javax.swing.JLabel companyLabel1;
    private javax.swing.JComboBox<String> graphCombo;
    private javax.swing.JTextField high2;
    private javax.swing.JLabel highPrice1;
    private javax.swing.JLabel insertTable;
    private javax.swing.JLabel insertTable1;
    private javax.swing.JLabel insertTable2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JPanel jGraph;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel1012;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton last30Days;
    private javax.swing.JButton last30Days1;
    private javax.swing.JButton last3Months;
    private javax.swing.JButton last3Months1;
    private javax.swing.JButton last7days;
    private javax.swing.JButton last7days1;
    private javax.swing.JTextField low2;
    private javax.swing.JLabel lowPrice;
    private javax.swing.JTextField open;
    private javax.swing.JTextField open2;
    private javax.swing.JPanel sdate;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JComboBox<String> searchbox;
    private javax.swing.JLabel setStock;
    private javax.swing.JButton stockInsert;
    private javax.swing.JLabel stockNoteLabel;
    private javax.swing.JTextField symbol;
    private javax.swing.JLabel symbolLabel;
    private javax.swing.JButton valueInStock;
    private javax.swing.JLabel versus;
    private javax.swing.JTextField volume;
    private javax.swing.JTextField volume2;
    // End of variables declaration//GEN-END:variables

}
