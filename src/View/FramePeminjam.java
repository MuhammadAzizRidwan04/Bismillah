package View;

import Kelas.Barang;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Kelas.Peminjam;

import javax.swing.JOptionPane;

public class FramePeminjam extends javax.swing.JPanel {

    public FramePeminjam() {
        initComponents();
        loadTable();

        txtcaripeminjam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String keyword = txtcaripeminjam.getText().trim(); // Ambil teks pencarian
                cariPeminjam(keyword); // Panggil metode pencarian
            }
        });
    }

    void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Peminjam");
        model.addColumn("Nama");
        model.addColumn("No.Tlp");
        model.addColumn("Instansi");
        model.addColumn("Alamat");
        model.addColumn("NIK");

        try {
            Peminjam pem = new Peminjam();
            ResultSet data = pem.tampilPeminjam();

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("id_peminjam"),
                    data.getString("nama"),
                    data.getString("no_tlp"),
                    data.getString("instansi"),
                    data.getString("alamat"),
                    data.getString("nik"),});

            }

        } catch (SQLException sQLException) {

        }

        tblPeminjam.setModel(model);
    }

    void cariPeminjam(String keyword) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Peminjam");
        model.addColumn("Nama");
        model.addColumn("No.Tlp");
        model.addColumn("Instansi");
        model.addColumn("Alamat");
        model.addColumn("NIK");

        try {
            Peminjam p = new Peminjam(); // Instansiasi kelas Vendor
            ResultSet data = p.cariPeminjam(keyword); // Panggil metode dari kelas Vendor

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("id_peminjam"),
                    data.getString("nama"),
                    data.getString("no_tlp"),
                    data.getString("instansi"),
                    data.getString("alamat"),
                    data.getString("nik"),});

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

        tblPeminjam.setModel(model); // Set hasil pencarian ke tabel
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeminjam = new javax.swing.JTable();
        txtcaripeminjam = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblPeminjam.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        tblPeminjam.setForeground(new java.awt.Color(255, 255, 255));
        tblPeminjam.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPeminjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeminjamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPeminjam);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Cari");

        btnTambah.setBackground(new java.awt.Color(102, 102, 102));
        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(29, 29, 29)
                            .addComponent(txtcaripeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcaripeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void tblPeminjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeminjamMouseClicked
        try {

            int baris = tblPeminjam.rowAtPoint(evt.getPoint());
            if (baris >= 0) { // Pastikan baris valid
                String ID = tblPeminjam.getValueAt(baris, 0) != null ? tblPeminjam.getValueAt(baris, 0).toString() : "";
                String Nama = tblPeminjam.getValueAt(baris, 1) != null ? tblPeminjam.getValueAt(baris, 1).toString() : "";
                String NoTlp = tblPeminjam.getValueAt(baris, 2) != null ? tblPeminjam.getValueAt(baris, 2).toString() : "";
                String Instansi = tblPeminjam.getValueAt(baris, 3) != null ? tblPeminjam.getValueAt(baris, 3).toString() : "";
                String Alamat = tblPeminjam.getValueAt(baris, 4) != null ? tblPeminjam.getValueAt(baris, 4).toString() : "";
                String Nik = tblPeminjam.getValueAt(baris, 5) != null ? tblPeminjam.getValueAt(baris, 5).toString() : "";

                // Membuka FrameInputVendor dan mengirimkan data
                FrameInputPeminjam IP = new FrameInputPeminjam();
                IP.btnTambah.setVisible(false);
                IP.setData(ID, Nama, NoTlp, Instansi, Alamat, Nik);
                IP.setVisible(true);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memilih data: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblPeminjamMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        FrameInputPeminjam IP = new FrameInputPeminjam();
        IP.setVisible(true);

        // Menyembunyikan elemen yang tidak diperlukan
        IP.btnHapus.setVisible(false);
        IP.btnUbah.setVisible(false);
    }//GEN-LAST:event_btnTambahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPeminjam;
    private javax.swing.JTextField txtcaripeminjam;
    // End of variables declaration//GEN-END:variables
}
