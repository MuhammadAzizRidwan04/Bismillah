package View;

import Kelas.Kategori;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Kelas.Vendor;
import javax.swing.JOptionPane;

public class FrameVendor extends javax.swing.JPanel {
    
    public FrameVendor() {
        initComponents();
        loadTable();
        
        txtcarinamavendor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String keyword = txtcarinamavendor.getText().trim(); // Ambil teks pencarian
                cariVendor(keyword); // Panggil metode pencarian
            }
        });
        
    }
    
    void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Vendor");
        model.addColumn("Nama Vendor");
        model.addColumn("Alamat");
        model.addColumn("Nama CP");
        model.addColumn("No.Tlp");
        model.addColumn("Email");
        
        try {
            Vendor ven = new Vendor();
            ResultSet data = ven.tampilVendor();
            
            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("id_vendor"),
                    data.getString("nama_vendor"),
                    data.getString("alamat"),
                    data.getString("nama_cp"),
                    data.getString("no_tlp"),
                    data.getString("email"),});
                
            }
            
        } catch (SQLException sQLException) {
            
        }
        
        tblVendor.setModel(model);
    }
    
    
    
    void cariVendor(String keyword) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Vendor");
        model.addColumn("Nama Vendor");
        model.addColumn("Alamat");
        model.addColumn("Nama CP");
        model.addColumn("No.Tlp");
        model.addColumn("Email");
        
        try {
            Vendor ven = new Vendor(); // Instansiasi kelas Vendor
            ResultSet data = ven.cariVendor(keyword); // Panggil metode dari kelas Vendor

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("id_vendor"),
                    data.getString("nama_vendor"),
                    data.getString("alamat"),
                    data.getString("nama_cp"),
                    data.getString("no_tlp"),
                    data.getString("email"),});
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
        
        tblVendor.setModel(model); // Set hasil pencarian ke tabel
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendor = new javax.swing.JTable();
        txtcarinamavendor = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblVendor.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        tblVendor.setForeground(new java.awt.Color(255, 255, 255));
        tblVendor.setModel(new javax.swing.table.DefaultTableModel(
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
        tblVendor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVendor);

        btnTambah.setBackground(new java.awt.Color(102, 102, 102));
        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search (1).png"))); // NOI18N
        jLabel1.setText("Cari");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcarinamavendor, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcarinamavendor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        FrameInputVendor IV = new FrameInputVendor();
        IV.setVisible(true);

        // Menyembunyikan elemen yang tidak diperlukan
        IV.btnHapus.setVisible(false);
        IV.btnUbah.setVisible(false);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void tblVendorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendorMouseClicked

try {
        int baris = tblVendor.rowAtPoint(evt.getPoint());
        if (baris >= 0) {
            Vendor vendor = new Vendor();
            vendor.setData(
                tblVendor.getValueAt(baris, 0) != null ? tblVendor.getValueAt(baris, 0).toString() : "",
                tblVendor.getValueAt(baris, 1) != null ? tblVendor.getValueAt(baris, 1).toString() : "",
                tblVendor.getValueAt(baris, 2) != null ? tblVendor.getValueAt(baris, 2).toString() : "",
                tblVendor.getValueAt(baris, 3) != null ? tblVendor.getValueAt(baris, 3).toString() : "",
                tblVendor.getValueAt(baris, 4) != null ? tblVendor.getValueAt(baris, 4).toString() : "",
                tblVendor.getValueAt(baris, 5) != null ? tblVendor.getValueAt(baris, 5).toString() : ""
            );

            // Membuka FrameInputVendor dan meneruskan data
            FrameInputVendor IV = new FrameInputVendor();
            IV.btnTambah.setVisible(false);
            IV.setDataFromVendor(vendor);
            IV.setVisible(true);
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memilih data: " + ex.getMessage());
    }
    }//GEN-LAST:event_tblVendorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVendor;
    private javax.swing.JTextField txtcarinamavendor;
    // End of variables declaration//GEN-END:variables
}
