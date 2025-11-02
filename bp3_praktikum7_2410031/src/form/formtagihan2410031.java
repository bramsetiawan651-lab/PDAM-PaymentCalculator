/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import config.koneksi;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author THINKPAD
 */
public class formtagihan2410031 extends javax.swing.JFrame {
private Connection conn;
    /**
     * Creates new form formtagihan2410031
     */
    public formtagihan2410031() {
        initComponents();
        conn = koneksi.getConnection();
        tampilData();
          jComboBox1.removeAllItems();
        jComboBox1.addItem("1A");
        jComboBox1.addItem("1B");
        jComboBox1.addItem("2A");
        jComboBox1.addItem("2B");
        jComboBox1.addItem("2C");
         jComboBox1.addItem("2D");
          jComboBox1.addItem("2E");
    
    }
   private void tampilData() {
           DefaultTableModel tabelModel = new DefaultTableModel();
        tabelModel.addColumn("NO TAGIHAN");
        tabelModel.addColumn("NAMA PELANGGAN");
        tabelModel.addColumn("KODE TARIF");
        tabelModel.addColumn("METER BULAN LALU");
        tabelModel.addColumn("METER BULAN SEKARANG");
        tabelModel.addColumn("PEMAKAIAN");
        tabelModel.addColumn("DISKON (%)");
        tabelModel.addColumn("TOTAL BAYAR");

try {
String sql = "SELECT notagihan2410031, namapelanggan2410031, kodetarif2410031, meterlalu2410031 , metersekarang2410031, pemakaian2410031, diskon2410031, totalbayar2410031 FROM tagihan2410031";
             
            

PreparedStatement st = conn.prepareStatement(sql);
ResultSet rs = st.executeQuery();

while (rs.next()) {
    String notagihan = rs.getString("notagihan2410031");
    String namapelanggan = rs.getString("namapelanggan2410031");
    String kodetarif = rs.getString("kodetarif2410031"); 
    String meterlalu = rs.getString("meterlalu2410031");
    String metersekarang = rs.getString("metersekarang2410031");
    String pemakaian = rs.getString("pemakaian2410031");
    String diskon = rs.getString("diskon2410031");
     String totalbayar = rs.getString("totalbayar2410031");
    Object[] rowData = {notagihan, namapelanggan, kodetarif, meterlalu,metersekarang,pemakaian,diskon,totalbayar};
    tabelModel.addRow(rowData);
}
        jTable1.setModel(tabelModel);
        rs.close();
        st.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error tampil data: " + e.getMessage());
    }
}
   private void clear() {
        jTextField1.setText("");
        jTextField2.setText("");
        jComboBox1.setSelectedIndex(-1);
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField1.requestFocus();
    }
   private double hitungTarif(String kode, int pemakaian) {
    double hargaPerKubik = 0;

    if (kode.equals("1A")) {
        hargaPerKubik = 1100;
    } 
    else if (kode.equals("1B")) {
        hargaPerKubik = 1200;
    } 
    else if (kode.equals("2A")) {
        if (pemakaian <= 10) hargaPerKubik = 2100;
        else if (pemakaian <= 20) hargaPerKubik = 3100;
        else if (pemakaian <= 30) hargaPerKubik = 3800;
        else hargaPerKubik = 4500;
    } 
    else if (kode.equals("2B")) {
        if (pemakaian <= 10) hargaPerKubik = 2500;
        else if (pemakaian <= 20) hargaPerKubik = 3200;
        else if (pemakaian <= 30) hargaPerKubik = 4500;
        else hargaPerKubik = 6300;
    } 
    else if (kode.equals("2C")) {
        if (pemakaian <= 10) hargaPerKubik = 3000;
        else if (pemakaian <= 20) hargaPerKubik = 4000;
        else if (pemakaian <= 30) hargaPerKubik = 5200;
        else hargaPerKubik = 7000;
    } 
    else if (kode.equals("2D")) {
        if (pemakaian <= 10) hargaPerKubik = 3800;
        else if (pemakaian <= 20) hargaPerKubik = 5100;
        else if (pemakaian <= 30) hargaPerKubik = 6900;
        else hargaPerKubik = 8700;
    } 
    else if (kode.equals("2E")) {
        if (pemakaian <= 10) hargaPerKubik = 4500;
        else if (pemakaian <= 20) hargaPerKubik = 5700;
        else if (pemakaian <= 30) hargaPerKubik = 7100;
        else hargaPerKubik = 9000;
    }

    return hargaPerKubik;
}
private void validasi() {
    String notagihan = jTextField1.getText();
    try {
      String sql = "select * from tagihan2410031 where notagihan2410031='"+ notagihan +"'";
      PreparedStatement st = conn.prepareStatement(sql);
      ResultSet rs = st.executeQuery();
      if (rs.next()) {
          JOptionPane.showMessageDialog(this,"Kode Sudah Ada");
          jTextField1.setText("");
          jTextField1.requestFocus();
      }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error" + e);
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("BRAM SETIAWAN 2410031");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("NO TAGIHAN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("NAMA PELANGGAN");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("KODE TARIF");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("METER BULAN SEKARANG");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("METER BULAN LALU");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("JUMLAH PEMAKAIAN");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("TOTAL BAYAR");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("DISKON (%)");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("SIMPAN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("HAPUS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("LAPORAN");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox1, 0, 209, Short.MAX_VALUE)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6)
                            .addComponent(jTextField7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(74, 74, 74))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(143, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))))
        );

        jPanel2.setBackground(new java.awt.Color(51, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("CARI DATA");

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addGap(157, 157, 157)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   int baris = jTable1.getSelectedRow();
    if (baris == -1) {
        JOptionPane.showMessageDialog(this, "Klik terlebih dahulu data yang akan diupdate!");
        return;
    }

    String notagihan = jTextField1.getText();
    String namapelanggan = jTextField2.getText();
    String kodetarif = jComboBox1.getSelectedItem() != null ? jComboBox1.getSelectedItem().toString() : "";
    String meterlalu = jTextField3.getText();
    String metersekarang = jTextField4.getText();
    String pemakaian = jTextField5.getText();
    String diskon = jTextField6.getText();
    String totalbayar = jTextField7.getText();
  
    if (notagihan.isEmpty() || namapelanggan.isEmpty() || kodetarif.isEmpty() ||
        meterlalu.isEmpty() || metersekarang.isEmpty() || pemakaian.isEmpty() || diskon.isEmpty() || totalbayar.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Lengkapi semua isian terlebih dahulu!");
        return;
    }

    try {
        String sql = "UPDATE tagihan2410031 SET namapelanggan2410031=?, kodetarif2410031=?, meterlalu2410031=?, metersekarang2410031=?, pemakaian2410031=? ,diskon2410031=?, totalbayar2410031=? WHERE notagihan2410031=?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, namapelanggan);
        st.setString(2, kodetarif);
        st.setInt(3, Integer.parseInt(meterlalu));
        st.setInt(4, Integer.parseInt(metersekarang));
        st.setInt(5, Integer.parseInt(pemakaian));
        st.setDouble(6, Double.parseDouble(diskon));
        st.setDouble(7, Double.parseDouble(totalbayar));
        st.setString(8, notagihan);
        
        int rowUpdated = st.executeUpdate();
        if(rowUpdated > 0 ){
            JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
        }
        tampilData();
        clear();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error update: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String notagihan = jTextField1.getText();
    String namapelanggan = jTextField2.getText();
    String kodetarif = jComboBox1.getSelectedItem() != null ? jComboBox1.getSelectedItem().toString() : "";
    String meterlalu = jTextField3.getText();
    String metersekarang = jTextField4.getText();
    String pemakaian = jTextField5.getText();
    String diskon = jTextField6.getText();
    String totalbayar = jTextField7.getText();
  
    if (notagihan.isEmpty() || namapelanggan.isEmpty() || kodetarif.isEmpty() ||
        meterlalu.isEmpty() || metersekarang.isEmpty() || pemakaian.isEmpty() || diskon.isEmpty() || totalbayar.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Lengkapi semua isian terlebih dahulu!");
        return;
    }

    try {
        String cekSql = "SELECT * FROM tagihan2410031 WHERE notagihan2410031=?";
        PreparedStatement cekPs = conn.prepareStatement(cekSql);
        cekPs.setString(1, notagihan);
        ResultSet rs = cekPs.executeQuery();
        if (rs.next()) {
            JOptionPane.showMessageDialog(this, "Nomor tagihan sudah ada!");
            rs.close();
            cekPs.close();
            return;
        }
        rs.close();
        cekPs.close();

        String sql = "INSERT INTO tagihan2410031 VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, notagihan);
        st.setString(2, namapelanggan);
        st.setString(3, kodetarif);
        st.setInt(4, Integer.parseInt(meterlalu));
        st.setInt(5, Integer.parseInt(metersekarang));
        st.setInt(6, Integer.parseInt(pemakaian));
        st.setDouble(7, Double.parseDouble(diskon));
        st.setDouble(8, Double.parseDouble(totalbayar));
        
        int rowInserted = st.executeUpdate();
        if(rowInserted > 0 ){
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
        }
        tampilData();
        clear();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error simpan: " + e.getMessage());
    }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  int baris = jTable1.getSelectedRow();
    if (baris == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus terlebih dahulu!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(
        this,
        "Yakin ingin menghapus data ini?",
        "Konfirmasi",
        JOptionPane.YES_NO_OPTION
    );

    if (confirm == JOptionPane.YES_OPTION) {
        String id = jTextField1.getText(); 
        try {
            String sql = "DELETE FROM tagihan2410031 WHERE notagihan2410031=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            int rowDelete = st.executeUpdate();

            if (rowDelete > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                tampilData();
                clear();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
        }
    }
                 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       int baris = jTable1.getSelectedRow();
    if (baris != -1) {
        jTextField1.setText(jTable1.getValueAt(baris, 0).toString());
        jTextField2.setText(jTable1.getValueAt(baris, 1).toString());
        jComboBox1.setSelectedItem(jTable1.getValueAt(baris, 2).toString());
        jTextField3.setText(jTable1.getValueAt(baris, 3).toString());
        jTextField4.setText(jTable1.getValueAt(baris, 4).toString());
        jTextField5.setText(jTable1.getValueAt(baris, 5).toString());
        jTextField6.setText(jTable1.getValueAt(baris, 6).toString());
          jTextField7.setText(jTable1.getValueAt(baris, 7).toString());
    }    
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
      try {
        int meterLalu = Integer.parseInt(jTextField3.getText());
        int meterSekarang = Integer.parseInt(jTextField4.getText());
        int pemakaian = meterSekarang - meterLalu;
        if (pemakaian < 0) {
             jTextField4.setText("");
             jTextField4.requestFocus();
             jTextField5.setText("");
            JOptionPane.showMessageDialog(this, "Meter sekarang tidak boleh lebih besar dari meter lalu!");
            return;
        }

        jTextField5.setText(String.valueOf(pemakaian));

        String kodeTarif = jComboBox1.getSelectedItem().toString();
        double harga = hitungTarif(kodeTarif, pemakaian);
        double total = harga * pemakaian;

        double diskon = 0;
        if (!jTextField6.getText().isEmpty()) {
            diskon = Double.parseDouble(jTextField6.getText());
        }

        double totalBayar = total - (total * diskon / 100);
        jTextField7.setText(String.valueOf(totalBayar));
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Input tidak valid: " + e.getMessage());
    }
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed

    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
 
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
          try {
        if (jTextField5.getText().isEmpty() || jTextField6.getText().isEmpty()) {
            return;
        }

        int pemakaian = Integer.parseInt(jTextField5.getText());
        String kodeTarif = jComboBox1.getSelectedItem() != null 
                ? jComboBox1.getSelectedItem().toString() 
                : "";
        if (kodeTarif.isEmpty()) return;

        double harga = hitungTarif(kodeTarif, pemakaian);
        double total = harga * pemakaian;

        double diskon = Double.parseDouble(jTextField6.getText());
        double totalBayar = total - (total * diskon / 100);
        jTextField7.setText(String.valueOf(totalBayar));
    } catch (NumberFormatException e) {
        jTextField7.setText("");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Masukkan angka diskon yang valid!");
    }
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
                                           
    try {
       
        if (jTextField5.getText().isEmpty()) {
            return;
        }

        int pemakaian = Integer.parseInt(jTextField5.getText());
        String kodeTarif = jComboBox1.getSelectedItem() != null 
                ? jComboBox1.getSelectedItem().toString() 
                : "";
        if (kodeTarif.isEmpty()) return;

        
        double harga = hitungTarif(kodeTarif, pemakaian);
        double total = harga * pemakaian;

      
        double diskon = 0;
        if (!jTextField6.getText().isEmpty()) {
            diskon = Double.parseDouble(jTextField6.getText());
        }

        
        double totalBayar = total - (total * diskon / 100);
        jTextField7.setText(String.valueOf(totalBayar));

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengganti kode tarif: " + e.getMessage());
    }


    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
                                         
    DefaultTableModel tabelModel = (DefaultTableModel) jTable1.getModel();
    tabelModel.setRowCount(0);

    String cari = jTextField8.getText();

    try {
        String sql = "SELECT * FROM tagihan2410031 "
                   + "WHERE notagihan2410031 LIKE ? "
                   + "OR namapelanggan2410031 LIKE ? "
                   + "OR kodetarif2410031 LIKE ?";
        
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, "%" + cari + "%");
        st.setString(2, "%" + cari + "%");
        st.setString(3, "%" + cari + "%");
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Object[] rowData = {
                rs.getString("notagihan2410031"),
                rs.getString("namapelanggan2410031"),
                rs.getString("kodetarif2410031"),
                rs.getInt("meterlalu2410031"),
                rs.getInt("metersekarang2410031"),
                rs.getInt("pemakaian2410031"),
                rs.getDouble("diskon2410031"),
                rs.getDouble("totalbayar2410031")
            };
            tabelModel.addRow(rowData);
        }
        rs.close();
        st.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error cari data: " + e.getMessage());
    }


    }//GEN-LAST:event_jTextField8KeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      try{
      
        String nmfile="./laptagihan.jasper";
        HashMap parameter=new HashMap();
        JasperPrint jprint=JasperFillManager.fillReport(nmfile, parameter, conn);
        JasperViewer.viewReport(jprint, false);
        JasperViewer.setDefaultLookAndFeelDecorated(true);
        conn.close();
        
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Laporan Tidak Dapat Di Cetak !\n" + e.getMessage(), "Cetak Laporan", JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
     validasi();
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(formtagihan2410031.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formtagihan2410031.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formtagihan2410031.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formtagihan2410031.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formtagihan2410031().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
