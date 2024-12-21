package View;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Kelas.Barang;
import Kelas.Vendor;
import Kelas.Kategori;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import View.FrameBarang;
import View.Main;

public class FrameInputBarang extends javax.swing.JFrame {

    private boolean isTableSelection = false;

    public FrameInputBarang() {
        initComponents();
        loadTable();
//        reset();

        comboBoxvendor();
        comboBoxkategori();
        AutoCompleteDecorator.decorate(cbVendor);
        AutoCompleteDecorator.decorate(cbKategori);
    }
   

    void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID_Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Merk");
        model.addColumn("Vendor");
        model.addColumn("Kategori");
        model.addColumn("Status");
        model.addColumn("Jenis");
        model.addColumn("Jumlah");

        try {
            Barang brg = new Barang();
            ResultSet data = brg.tampilBarang();

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("ID"),
                    data.getString("Nama"),
                    data.getString("Merk"),
                    data.getString("Vendor"),
                    data.getString("Kategori"),
                    data.getString("Status"),
                    data.getString("Jenis"),
                    data.getString("Jumlah"),});

            }

        } catch (SQLException sQLException) {

        }

        
    }

    void reset() {
        txtNamaBarang.setText(null);
        txtMerk.setText(null);
        cbVendor.setSelectedItem(null);
        cbKategori.setSelectedItem(null);
        cbStatus.setSelectedItem(null);
        cbJenis.setSelectedItem(null);
        txtJumlah.setText(null);
    }

    void comboBoxvendor() {

        try {
            Vendor ven = new Vendor();
            ResultSet data = ven.tampilComBoxVendor();

            while (data.next()) {
                String isi = data.getString("nama_vendor");
                cbVendor.addItem(isi);
            }

        } catch (SQLException ex) {

        }

    }

    void comboBoxkategori() {

        try {
            Kategori kat = new Kategori();
            ResultSet data = kat.tampilComBoxKategori();

            while (data.next()) {
                String isi = data.getString("nama_kategori");
                cbKategori.addItem(isi);
            }

        } catch (SQLException ex) {

        }

    }

    public static String edit;

    public static String getEdit() {
        return edit;
    }

    public static void setEdit(String edit) {
        FrameInputBarang.edit = edit;
    }

    

    public void setData(String ID, String NamaBarang, String Merk, String Vendor, String Kategori, String Status, String Jenis, String Jumlah) {
        txtIDBarang.setText(ID);
        txtNamaBarang.setText(NamaBarang);
        txtMerk.setText(Merk);
        cbVendor.setSelectedItem(Vendor);
        cbKategori.setSelectedItem(Kategori);
        cbStatus.setSelectedItem(Status);
        cbJenis.setSelectedItem(Jenis);
        txtJumlah.setText(Jumlah);
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNamaBarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMerk = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbVendor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbKategori = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbJenis = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        txtIDBarang = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Barang");
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 8));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama Barang");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Merk");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Vendor");

        cbVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVendorActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kategori");

        cbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKategoriActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Status");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baru", "Bekas" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Jenis");

        cbJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleh Dipinjam", "Tidak Boleh Dipinjam" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Jumlah");

        txtIDBarang.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        txtIDBarang.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        txtIDBarang.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        txtIDBarang.setText("ID Barang");

        btnTambah.setBackground(new java.awt.Color(255, 255, 51));
        btnTambah.setText("TAMBAH");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(txtIDBarang))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMerk, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbKategori, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbJenis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbVendor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtJumlah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMerk, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel5)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel7)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIDBarang)
                        .addGap(134, 134, 134))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVendorActionPerformed
         if (isTableSelection) {
            return; // Jangan eksekusi jika dipicu oleh klik tabel
        }
        String vendorName = cbVendor.getSelectedItem() != null ? cbVendor.getSelectedItem().toString() : "";
        String kategoriName = cbKategori.getSelectedItem() != null ? cbKategori.getSelectedItem().toString() : "";

        try {
            Barang barang = new Barang();
            if (vendorName.isEmpty() || kategoriName.isEmpty()) {
                txtIDBarang.setText("");
            } else {
                String fullID = barang.generateFullID(vendorName, kategoriName);
                txtIDBarang.setText(fullID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_cbVendorActionPerformed

    private void cbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKategoriActionPerformed

        if (isTableSelection) {
            return; // Jangan eksekusi jika dipicu oleh klik tabel
        }
        String vendorName = cbVendor.getSelectedItem() != null ? cbVendor.getSelectedItem().toString() : "";
        String kategoriName = cbKategori.getSelectedItem() != null ? cbKategori.getSelectedItem().toString() : "";

        try {
            Barang barang = new Barang();
            if (vendorName.isEmpty() || kategoriName.isEmpty()) {
                txtIDBarang.setText("");
            } else {
                String fullID = barang.generateFullID(vendorName, kategoriName);
                txtIDBarang.setText(fullID);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_cbKategoriActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed

        // btnHapus.setVisible(false);
        try {
            Barang brg = new Barang();
            Vendor ven = new Vendor();
            Kategori kat = new Kategori();
            brg.setId_barang(txtIDBarang.getText());
            brg.setNama_barang(txtNamaBarang.getText());
            brg.setMerk(txtMerk.getText());
            ven.setNama_vendor(cbVendor.getSelectedItem().toString());
            kat.setNama_kategori(cbKategori.getSelectedItem().toString());
            brg.setStatus(cbStatus.getSelectedItem().toString());
            brg.setJenis(cbJenis.getSelectedItem().toString());
            brg.setJumlah(Integer.parseInt(txtJumlah.getText()));

            ResultSet datavendor = ven.KonversiVendor();
            ResultSet datakategori = kat.KonversiKategori();

            if (datavendor.next()) {
                String isivendor = datavendor.getString("id_vendor");
                brg.setId_vendor(isivendor);
            }
            if (datakategori.next()) {
                String isikategori = datakategori.getString("id_kategori");
                brg.setId_kategori(isikategori);
            }
            brg.tambahBarang();
                    loadTable();
        reset();
        
        
        } catch (SQLException sQLException) {
            System.out.println("data tidak masuk");
        }
       
        Main.pConten.removeAll();
        Main.pConten.add(new FrameBarang());
        Main.pConten.repaint();
        Main.pConten.revalidate();
         dispose();



    }//GEN-LAST:event_btnTambahActionPerformed

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
            java.util.logging.Logger.getLogger(FrameInputBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameInputBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameInputBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameInputBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameInputBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cbJenis;
    private javax.swing.JComboBox<String> cbKategori;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JComboBox<String> cbVendor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel txtIDBarang;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtMerk;
    private javax.swing.JTextField txtNamaBarang;
    // End of variables declaration//GEN-END:variables
}
