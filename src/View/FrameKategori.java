package View;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Kelas.Kategori;
import javax.swing.JOptionPane;

public class FrameKategori extends javax.swing.JPanel {

    public FrameKategori() {
        initComponents();
        loadTable();

        txtcarinamakategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String keyword = txtcarinamakategori.getText().trim(); // Ambil teks pencarian
                cariKategori(keyword); // Panggil metode pencarian
            }
        });
    }

    void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Kategori");
        model.addColumn("Nama Kategori");

        try {
            Kategori kat = new Kategori();
            ResultSet data = kat.tampilKategori();

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("id_kategori"),
                    data.getString("nama_kategori"),});

            }

        } catch (SQLException sQLException) {

        }

        tblKategori.setModel(model);
    }

    

    void cariKategori(String keyword) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Kategori");
        model.addColumn("Nama Kategori");

        try {
            Kategori kat = new Kategori(); // Instansiasi kelas Vendor
            ResultSet data = kat.cariKategori(keyword); // Panggil metode dari kelas Vendor

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("id_kategori"),
                    data.getString("nama_kategori"),});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

        tblKategori.setModel(model); // Set hasil pencarian ke tabel
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKategori = new javax.swing.JTable();
        txtcarinamakategori = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblKategori.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        tblKategori.setForeground(new java.awt.Color(255, 255, 255));
        tblKategori.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKategori);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Cari");

        btnTambah.setBackground(new java.awt.Color(102, 102, 102));
        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(785, 785, 785)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addComponent(txtcarinamakategori, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcarinamakategori, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, "card2");

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void tblKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKategoriMouseClicked
        try {

            int baris = tblKategori.rowAtPoint(evt.getPoint());
            if (baris >= 0) { // Pastikan baris valid
                String ID = tblKategori.getValueAt(baris, 0) != null ? tblKategori.getValueAt(baris, 0).toString() : "";
                String Nama = tblKategori.getValueAt(baris, 1) != null ? tblKategori.getValueAt(baris, 1).toString() : "";

                // Membuka FrameInputKategori dan mengirimkan data
                FrameInputKategori IK = new FrameInputKategori();
                IK.btnTambah.setVisible(false);
                IK.setData(ID, Nama);
                IK.setVisible(true);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memilih data: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblKategoriMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        FrameInputKategori IK = new FrameInputKategori();
        IK.setVisible(true);

        // Menyembunyikan elemen yang tidak diperlukan
        IK.btnHapus.setVisible(false);
        IK.btnUbah.setVisible(false);
    }//GEN-LAST:event_btnTambahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKategori;
    private javax.swing.JTextField txtcarinamakategori;
    // End of variables declaration//GEN-END:variables
}
