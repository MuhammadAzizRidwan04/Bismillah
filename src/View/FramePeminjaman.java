package View;

import Kelas.Barang;
import Kelas.Peminjaman;
import Kelas.Koneksi;

import Kelas.Peminjam;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class FramePeminjaman extends javax.swing.JPanel {

    public FramePeminjaman() {
        initComponents();
        loadTable();

        txtcaripeminjaman.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String keyword = txtcaripeminjaman.getText().trim(); // Ambil teks pencarian
                cariPeminjaman(keyword); // Panggil metode pencarian
            }
        });

    }

    void loadTable() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID_Peminjaman");
        model.addColumn("Peminjam");
        model.addColumn("Barang");
        model.addColumn("Status");
        model.addColumn("Jumlah");
        model.addColumn("Tgl.Pinjam");
        model.addColumn("Tgl.Kembali");

        try {
            Peminjaman pm = new Peminjaman();
            ResultSet data = pm.tampilPeminjaman();

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("ID"),
                    data.getString("Peminjam"),
                    data.getString("Barang"),
                    data.getString("Status"),
                    data.getString("Jumlah"),
                    data.getString("Tanggal_Pinjam"),
                    data.getString("Tanggal_Kembali"),});

            }

        } catch (SQLException sQLException) {

        }

        tblPeminjaman.setModel(model);
    }

    private void cariPeminjaman(String keyword) {
        // Membuat model untuk JTable
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Peminjaman");
        model.addColumn("Nama Peminjam");
        model.addColumn("Nama Barang");
        model.addColumn("Status");
        model.addColumn("Jumlah");
        model.addColumn("Tanggal Pinjam");
        model.addColumn("Tanggal Kembali");

        try {
            Peminjaman peminjam = new Peminjaman(); // Instansiasi kelas Peminjaman
            ResultSet data = peminjam.cariPeminjaman(keyword); // Panggil metode dari kelas Peminjaman

            // Memasukkan data ke dalam JTable
            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("id_peminjaman"), // ID Peminjaman
                    data.getString("nama_peminjam"), // Nama Peminjam (dari hasil JOIN)
                    data.getString("nama_barang"), // Nama Barang (dari hasil JOIN)
                    data.getString("status"), // Status
                    data.getInt("jumlah"), // Jumlah
                    data.getDate("tanggal_pinjam"), // Tanggal Pinjam
                    data.getDate("tanggal_kembali") // Tanggal Kembali
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

        // Menetapkan model ke JTable untuk menampilkan hasil pencarian
        tblPeminjaman.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeminjaman = new javax.swing.JTable();
        txtcaripeminjaman = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnPindahkeFrameTampilPeminjaman = new javax.swing.JButton();
        btnSisaBarang = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblPeminjaman.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        tblPeminjaman.setForeground(new java.awt.Color(255, 255, 255));
        tblPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPeminjaman);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search (1).png"))); // NOI18N
        jLabel7.setText("Cari");

        btnPindahkeFrameTampilPeminjaman.setBackground(new java.awt.Color(102, 102, 102));
        btnPindahkeFrameTampilPeminjaman.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPindahkeFrameTampilPeminjaman.setForeground(new java.awt.Color(255, 255, 255));
        btnPindahkeFrameTampilPeminjaman.setText("Tambah");
        btnPindahkeFrameTampilPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPindahkeFrameTampilPeminjamanActionPerformed(evt);
            }
        });

        btnSisaBarang.setBackground(new java.awt.Color(0, 153, 153));
        btnSisaBarang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSisaBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnSisaBarang.setText("Sisa Barang");
        btnSisaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSisaBarangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnPindahkeFrameTampilPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSisaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcaripeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcaripeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSisaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPindahkeFrameTampilPeminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void tblPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeminjamanMouseClicked

        try {

            int baris = tblPeminjaman.rowAtPoint(evt.getPoint());
            if (baris >= 0) { // Pastikan baris valid
                String ID = tblPeminjaman.getValueAt(baris, 0) != null ? tblPeminjaman.getValueAt(baris, 0).toString() : "";
                String Peminjam = tblPeminjaman.getValueAt(baris, 1) != null ? tblPeminjaman.getValueAt(baris, 1).toString() : "";
                String Barang = tblPeminjaman.getValueAt(baris, 2) != null ? tblPeminjaman.getValueAt(baris, 2).toString() : "";
                String Status = tblPeminjaman.getValueAt(baris, 3) != null ? tblPeminjaman.getValueAt(baris, 3).toString() : "";
                String Jumlah = tblPeminjaman.getValueAt(baris, 4) != null ? tblPeminjaman.getValueAt(baris, 4).toString() : "";
                String TanggalP = tblPeminjaman.getValueAt(baris, 5) != null ? tblPeminjaman.getValueAt(baris, 5).toString() : "";
                String TanggalK = tblPeminjaman.getValueAt(baris, 6) != null ? tblPeminjaman.getValueAt(baris, 6).toString() : "";

                // Membuka FrameBarang dan mengirimkan data
                FrameInputPeminjaman IPB = new FrameInputPeminjaman();
                IPB.setData(ID, Peminjam, Barang, Status, Jumlah, TanggalP, TanggalK);
                IPB.btnTambah.setVisible(false);
                if (Status.equals("Dikembalikan")) {
                    IPB.btnKembalikan.setVisible(false);
                    IPB.cbStatus.removeAllItems();
                    IPB.cbStatus.addItem("Dikembalikan");
                }

                if (Status.equals("Dipinjam")) {

                    
                    IPB.txtTanggalKembali.setVisible(false);
                    IPB.lblTanggalKembali.setVisible(false);
                }

                IPB.setVisible(true);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memilih data: " + ex.getMessage());
        }


    }//GEN-LAST:event_tblPeminjamanMouseClicked

    private void btnPindahkeFrameTampilPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPindahkeFrameTampilPeminjamanActionPerformed
        // Membuka FrameTampilPeminjaman
        FrameInputPeminjaman IPB = new FrameInputPeminjaman();
        IPB.setVisible(true);

        // eMenyembunyikan elemen yang tidak diperlukan
        IPB.btnHapus.setVisible(false);
        IPB.btnUbah.setVisible(false);
        IPB.btnKembalikan.setVisible(false);
        IPB.txtTanggalKembali.setVisible(false);
        IPB.lblTanggalKembali.setVisible(false);

        // Menyesuaikan isi combo box cbStatus di Tampil_Peminjaman
        IPB.cbStatus.removeAllItems(); // Menghapus semua item di combo box
        IPB.cbStatus.addItem("Dipinjam"); // Menambahkan hanya item "Dipinjam"

    }//GEN-LAST:event_btnPindahkeFrameTampilPeminjamanActionPerformed

    private void btnSisaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSisaBarangActionPerformed
        new FrameLaporanBarang().setVisible(true);
    }//GEN-LAST:event_btnSisaBarangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPindahkeFrameTampilPeminjaman;
    private javax.swing.JButton btnSisaBarang;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPeminjaman;
    private javax.swing.JTextField txtcaripeminjaman;
    // End of variables declaration//GEN-END:variables
}
