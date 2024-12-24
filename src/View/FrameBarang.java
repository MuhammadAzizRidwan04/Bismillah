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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputFilter.Status;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import static javax.swing.text.html.HTML.Attribute.ID;

public class FrameBarang extends javax.swing.JPanel {
//
    private boolean isTableSelection = false;

    public FrameBarang() {
        initComponents();
        loadTable();

        txtcaribarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String keyword = txtcaribarang.getText().trim(); // Ambil teks pencarian
                cariBarang(keyword); // Panggil metode pencarian
            }
        });

    }
    
    


    void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID_Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Merk");
        model.addColumn("Vendor");
        model.addColumn("Kategori");
        model.addColumn("Kondisi");
        model.addColumn("Jenis");
        model.addColumn("Jumlah");
        model.addColumn("Status");

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
                    data.getString("Jumlah"),
                    data.getString("Kondisi"),});

            }

        } catch (SQLException sQLException) {

        }

        tblBarang.setModel(model);
    }

    private void cariBarang(String keyword) {
        // Membuat model untuk JTable
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
            Barang brg = new Barang(); // Instansiasi kelas Barang
            ResultSet data = brg.cariBarang(keyword); // Panggil metode dari kelas Barang

            // Memasukkan data ke dalam JTable
            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("id_barang"), // ID Barang
                    data.getString("nama_barang"), // Nama Barang
                    data.getString("merk"), // Merk
                    data.getString("nama_vendor"), // Vendor (dari hasil JOIN)
                    data.getString("nama_kategori"), // Kategori (dari hasil JOIN)
                    data.getString("status"), // Status
                    data.getString("jenis"), // Jenis
                    data.getInt("jumlah") // Jumlah
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

        // Menetapkan model ke JTable untuk menampilkan hasil pencarian
        tblBarang.setModel(model);
    }

    // Aksi tombol Tambah
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtIDBarang = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        txtcaribarang = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtIDBarang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtIDBarang.setForeground(new java.awt.Color(255, 255, 255));
        txtIDBarang.setText("ID Barang");

        tblBarang.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        tblBarang.setForeground(new java.awt.Color(255, 255, 255));
        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBarang);

        btnTambah.setBackground(new java.awt.Color(102, 102, 102));
        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Cari");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtIDBarang)
                            .addGap(252, 252, 252)
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(txtcaribarang, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIDBarang)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcaribarang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void tblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMouseClicked

        isTableSelection = true;
        try {

            int baris = tblBarang.rowAtPoint(evt.getPoint());
            if (baris >= 0) { // Pastikan baris valid
                String ID = tblBarang.getValueAt(baris, 0) != null ? tblBarang.getValueAt(baris, 0).toString() : "";
                String NamaBarang = tblBarang.getValueAt(baris, 1) != null ? tblBarang.getValueAt(baris, 1).toString() : "";
                String Merk = tblBarang.getValueAt(baris, 2) != null ? tblBarang.getValueAt(baris, 2).toString() : "";
                String Vendor = tblBarang.getValueAt(baris, 3) != null ? tblBarang.getValueAt(baris, 3).toString() : "";
                String Kategori = tblBarang.getValueAt(baris, 4) != null ? tblBarang.getValueAt(baris, 4).toString() : "";
                String Status = tblBarang.getValueAt(baris, 5) != null ? tblBarang.getValueAt(baris, 5).toString() : "";
                String Jenis = tblBarang.getValueAt(baris, 6) != null ? tblBarang.getValueAt(baris, 6).toString() : "";
                String Jumlah = tblBarang.getValueAt(baris, 7) != null ? tblBarang.getValueAt(baris, 7).toString() : "";
                FrameInputBarang.setEdit("true");
                // Membuka FrameBarang dan mengirimkan data
                FrameEdt_Dlt_Barang frameBarang = new FrameEdt_Dlt_Barang();
                frameBarang.setData(ID, NamaBarang, Merk, Vendor, Kategori, Status, Jenis, Jumlah);
                
                frameBarang.setVisible(true);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memilih data: " + ex.getMessage());
        } finally {
            isTableSelection = false; // Selesai seleksi dari tabel
        }


    }//GEN-LAST:event_tblBarangMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        FrameInputBarang IB = new FrameInputBarang();
        IB.setVisible(true);


        

    }//GEN-LAST:event_btnTambahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBarang;
    private javax.swing.JLabel txtIDBarang;
    private javax.swing.JTextField txtcaribarang;
    // End of variables declaration//GEN-END:variables
}
