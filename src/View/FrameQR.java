package View;

import Kelas.Barang;
import com.barcodelib.barcode.Linear;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FrameQR extends javax.swing.JPanel {

    /**
     * Creates new form Barcode
     */
    public FrameQR() {
        initComponents();
        reset();
        loadTable();
        isiTanggalOtomatis();
        txtcaribarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String keyword = txtcaribarang.getText().trim(); // Ambil teks pencarian
                cariBarang(keyword); // Panggil metode pencarian
            }
        });
    }

    void reset() {
        qr_text.setText("");
        txtNama.setText("");
        labelBarcode.setIcon(null);
        txtJumlahCetak.setText(null);
    }

    void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID_Barang");
        model.addColumn("Nama Barang");

        try {
            Barang brg = new Barang();
            ResultSet data = brg.tampilBarang();

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("ID"),
                    data.getString("Nama"),});

            }

        } catch (SQLException sQLException) {

        }

        tblBarcode.setModel(model);
    }

    private void cariBarang(String keyword) {
        // Membuat model untuk JTable
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID_Barang");
        model.addColumn("Nama Barang");

        try {
            Barang brg = new Barang(); // Instansiasi kelas Barang
            ResultSet data = brg.cariBarang(keyword); // Panggil metode dari kelas Barang

            // Memasukkan data ke dalam JTable
            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("id_barang"), // ID Barang
                    data.getString("nama_barang") // Nama Barang
                // Jumlah
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
        tblBarcode.setModel(model);
    }

    private void isiTanggalOtomatis() {
        // Format tanggal yang diinginkan
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Mendapatkan tanggal saat ini
        LocalDate tanggalSaatIni = LocalDate.now();

        // Mengisi txtTanggal dengan tanggal yang diformat
        txtTanggal.setText(tanggalSaatIni.format(formatter));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        qr_text = new javax.swing.JTextField();
        btnCetak = new javax.swing.JButton();
        labelBarcode = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarcode = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtcaribarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtJumlahCetak = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnCetak.setBackground(new java.awt.Color(255, 255, 0));
        btnCetak.setText("Cetak QR");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        labelBarcode.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        labelBarcode.setForeground(new java.awt.Color(255, 255, 255));
        labelBarcode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBarcode.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"), 3));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        jLabel2.setText("Nama");

        tblBarcode.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        tblBarcode.setForeground(new java.awt.Color(255, 255, 255));
        tblBarcode.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBarcode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBarcodeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBarcode);

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("New QR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Cari");

        txtJumlahCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahCetakActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        jLabel4.setText("Jumlah Cetak");

        txtTanggal.setEditable(false);
        txtTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        jLabel5.setText("Tgl. Cetak");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(58, 58, 58)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtJumlahCetak)
                                            .addComponent(qr_text)
                                            .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                            .addComponent(txtTanggal))))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(27, 27, 27)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcaribarang, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qr_text, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJumlahCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtcaribarang, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed

        try {
            // Membaca input dari user
            String namaFile = txtNama.getText().trim();
            String jumlahCetakStr = txtJumlahCetak.getText().trim();
            String tanggal = txtTanggal.getText().trim();

            if (namaFile.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong!");
                return;
            }

            if (jumlahCetakStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Jumlah cetak tidak boleh kosong!");
                return;
            }

            if (tanggal.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tanggal tidak boleh kosong!");
                return;
            }

            // Parsing jumlah cetak
            int jumlahCetak;
            try {
                jumlahCetak = Integer.parseInt(jumlahCetakStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Jumlah cetak harus berupa angka!");
                return;
            }

            if (jumlahCetak <= 0) {
                JOptionPane.showMessageDialog(null, "Jumlah cetak harus lebih dari 0!");
                return;
            }

            // Generate satu barcode
            ByteArrayOutputStream out = QRCode.from(qr_text.getText()).to(ImageType.PNG).stream();
            byte[] barcodeData = out.toByteArray();
            ImageIcon barcodeIcon = new ImageIcon(barcodeData);

            // Resize gambar barcode
            int barcodeWidth = 216;
            int barcodeHeight = 190;
            Image barcodeImage = barcodeIcon.getImage().getScaledInstance(barcodeWidth, barcodeHeight, Image.SCALE_SMOOTH);

            // Set gambar ke labelBarcode (hanya satu barcode)
            labelBarcode.setIcon(new ImageIcon(barcodeImage));

            // Membuat gambar baru untuk menyimpan barcode sebanyak jumlahCetak
            int kolom = 3; // Jumlah kolom barcode dalam satu baris
            int baris = (int) Math.ceil((double) jumlahCetak / kolom); // Hitung jumlah baris yang dibutuhkan
            int gambarLebar = kolom * barcodeWidth;
            int gambarTinggi = baris * barcodeHeight;

            BufferedImage combinedImage = new BufferedImage(gambarLebar, gambarTinggi, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = combinedImage.createGraphics();

            // Menggambar barcode secara berulang
            for (int i = 0; i < jumlahCetak; i++) {
                int x = (i % kolom) * barcodeWidth; // Posisi X berdasarkan kolom
                int y = (i / kolom) * barcodeHeight; // Posisi Y berdasarkan baris
                g2d.drawImage(barcodeImage, x, y, null);
            }
            g2d.dispose();

            // Simpan gambar ke dalam satu file PNG
            String pathName = "D:\\QRCode\\"; // Path penyimpanan
            String fileName = pathName + namaFile + "_" + tanggal + ".PNG";
            ImageIO.write(combinedImage, "PNG", new File(fileName));

            // Tampilkan pesan sukses
            JOptionPane.showMessageDialog(null, "Barcode berhasil dicetak dalam satu file PNG!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
        }


    }//GEN-LAST:event_btnCetakActionPerformed

    private void tblBarcodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarcodeMouseClicked
        int baris = tblBarcode.rowAtPoint(evt.getPoint());
        String ID = tblBarcode.getValueAt(baris, 0).toString();
        String NamaBarang = tblBarcode.getValueAt(baris, 1).toString();

        // Set data ke form
        qr_text.setText(ID);

        txtNama.setText(NamaBarang);

    }//GEN-LAST:event_tblBarcodeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalActionPerformed
        isiTanggalOtomatis();
    }//GEN-LAST:event_txtTanggalActionPerformed

    private void txtJumlahCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahCetakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahCetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBarcode;
    private javax.swing.JTextField qr_text;
    private javax.swing.JTable tblBarcode;
    private javax.swing.JTextField txtJumlahCetak;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtcaribarang;
    // End of variables declaration//GEN-END:variables
}
