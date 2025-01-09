package View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.Timer;
import Kelas.Barang;
import Kelas.Peminjam;
import Kelas.Peminjaman;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class FrameInputPeminjaman extends javax.swing.JFrame {

    public FrameInputPeminjaman() {
        initComponents();

        loadTable();
        reset();
        setTanggalWaktu();

        comboBoxPeminjam();
        comboBoxBarang();
        // Mengaktifkan AutoComplete pada combo box
        AutoCompleteDecorator.decorate(cbPeminjam);
        AutoCompleteDecorator.decorate(cbBarang);
        AutoCompleteDecorator.decorate(cbStatus);
    }

    private void setTanggalWaktu() {
        // Format untuk tanggal dan jam
        SimpleDateFormat tanggalFormat = new SimpleDateFormat("EEEE dd MMMM yyyy", new Locale("id", "ID"));
        SimpleDateFormat jamFormat = new SimpleDateFormat("HH.mm"); // Format jam dan menit

        // Timer untuk memperbarui setiap menit
        Timer timer = new Timer(60000, e -> {
            Date now = new Date();
            String tanggal = tanggalFormat.format(now);
            String jam = jamFormat.format(now);
            txtTanggalPinjam.setText(tanggal + " ( Jam " + jam + " WIB )");
        });

        // Isi pertama kali sebelum timer berjalan
        Date now = new Date();
        String tanggal = tanggalFormat.format(now);
        String jam = jamFormat.format(now);
        txtTanggalPinjam.setText(tanggal + " ( Jam " + jam + " WIB )");
        timer.start();
    }

    public void setTanggalKembali() {
        // Format untuk tanggal dan jam
        SimpleDateFormat tanggalFormat = new SimpleDateFormat("EEEE dd MMMM yyyy", new Locale("id", "ID"));
        SimpleDateFormat jamFormat = new SimpleDateFormat("HH.mm"); // Format jam dan menit

        // Timer untuk memperbarui setiap menit
        Timer timer = new Timer(60000, e -> {
            Date now = new Date();
            String tanggal = tanggalFormat.format(now);
            String jam = jamFormat.format(now);
            txtTanggalKembali.setText(tanggal + " ( Jam " + jam + " WIB )");
        });

        // Isi pertama kali sebelum timer berjalan
        Date now = new Date();
        String tanggal = tanggalFormat.format(now);
        String jam = jamFormat.format(now);
        txtTanggalKembali.setText(tanggal + " ( Jam " + jam + " WIB )");
        timer.start();
    }

    private int getSelectedBarangId() {
        return Integer.parseInt(cbBarang.getSelectedItem().toString().split(" - ")[0]);
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

    }

    void reset() {
        autoID();
        //txtIDPeminjaman.setEditable(true);
        cbPeminjam.setSelectedItem(null);
        cbBarang.setSelectedItem(null);
        cbStatus.setSelectedItem(null);
        txtJumlah.setText(null);
        cbStatus.setSelectedItem(null);
        txtTanggalPinjam.setText(null);
        txtTanggalKembali.setText(null);
    }

    void comboBoxPeminjam() {

        try {
            Peminjam p = new Peminjam();
            ResultSet data = p.tampilComBoxPeminjam();

            while (data.next()) {
                String isi = data.getString("nama");
                cbPeminjam.addItem(isi);
            }

        } catch (SQLException ex) {

        }

    }

    void comboBoxBarang() {

        try {
            Barang brg = new Barang();
            ResultSet data = brg.tampilComBoxBarang();

            while (data.next()) {
                String isi = data.getString("nama_barang");
                cbBarang.addItem(isi);
            }

        } catch (SQLException ex) {

        }

    }

    void autoID() {
        try {
            Peminjaman pm = new Peminjaman();
            String id = pm.autoID(); // Memanggil method autoID() dari class Kategori
            txtIDPeminjaman.setText(id); // Set ID ke text field
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saat membuat ID: " + e.getMessage());
        }
    }

    public void setData(String ID, String Peminjam, String Barang, String Status, String Jumlah, String TanggalP, String TanggalK) {
        txtIDPeminjaman.setText(ID);
        cbPeminjam.setSelectedItem(Peminjam);
        cbBarang.setSelectedItem(Barang);
        cbStatus.setSelectedItem(Status);
        txtJumlah.setText(Jumlah);
        txtTanggalPinjam.setText(TanggalP);
        txtTanggalKembali.setText(TanggalK);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cbPeminjam = new javax.swing.JComboBox<>();
        cbBarang = new javax.swing.JComboBox<>();
        txtJumlah = new javax.swing.JTextField();
        cbStatus = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTanggalKembali = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnKembalikan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtIDPeminjaman = new javax.swing.JLabel();
        txtTanggalPinjam = new javax.swing.JTextField();
        txtTanggalKembali = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));

        jPanel2.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));

        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJumlahKeyReleased(evt);
            }
        });

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dipinjam", "Dikembalikan", " " }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Peminjam");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Barang");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Status");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jumlah");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tgl.Pinjam");

        lblTanggalKembali.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTanggalKembali.setForeground(new java.awt.Color(255, 255, 255));
        lblTanggalKembali.setText("Tgl.Kembali");

        btnTambah.setBackground(new java.awt.Color(255, 255, 51));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(153, 153, 255));
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnKembalikan.setBackground(new java.awt.Color(255, 102, 102));
        btnKembalikan.setText("Kembalikan");
        btnKembalikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembalikanActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(153, 153, 0));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        txtIDPeminjaman.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtIDPeminjaman.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        txtIDPeminjaman.setText("Id Peminjaman");

        txtTanggalPinjam.setEditable(false);

        txtTanggalKembali.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKembalikan, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtIDPeminjaman)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(lblTanggalKembali)
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(70, 70, 70)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbPeminjam, 0, 273, Short.MAX_VALUE)
                                .addComponent(cbBarang, 0, 273, Short.MAX_VALUE)
                                .addComponent(cbStatus, 0, 273, Short.MAX_VALUE)
                                .addComponent(txtJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                .addComponent(txtTanggalPinjam)
                                .addComponent(txtTanggalKembali)))))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtIDPeminjaman)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTanggalPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(lblTanggalKembali)
                        .addGap(51, 51, 51)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(txtTanggalKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnKembalikan, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 30, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 30, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed

        try {
            Peminjaman pm = new Peminjaman();
            Peminjam p = new Peminjam();
            Barang brg = new Barang();
            pm.setId_peminjaman(txtIDPeminjaman.getText());
            p.setNama(cbPeminjam.getSelectedItem().toString());
            brg.setNama_barang(cbBarang.getSelectedItem().toString());
            pm.setStatus(cbStatus.getSelectedItem().toString());
            pm.setJumlah(Integer.parseInt(txtJumlah.getText()));
            pm.setTanggal_pinjam(txtTanggalPinjam.getText());
            pm.setTanggal_kembali(txtTanggalKembali.getText());
            String namaBarang = cbBarang.getSelectedItem().toString();

            int jumlahPinjam = Integer.parseInt(txtJumlah.getText());

            // Dapatkan stok asli barang
            int stokAsli = brg.getStokBrg(namaBarang);

            // Hitung total barang yang sudah dipinjam
            int totalDipinjam = brg.getTotalBarangDipinjam(namaBarang);

            // Validasi apakah jumlah barang yang dipinjam akan melebihi stok asli
            if (totalDipinjam + jumlahPinjam > stokAsli) {
                JOptionPane.showMessageDialog(this, "Barang sudah mencapai batas stok dan tidak dapat dipinjam lagi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                txtJumlah.setText(null);
                return;
            }

            ResultSet datapeminjam = p.KonversiPeminjam();
            ResultSet databarang = brg.KonversiBarang();

            if (datapeminjam.next()) {
                String isipeminjam = datapeminjam.getString("id_peminjam");
                pm.setId_peminjam(isipeminjam);
            }
            if (databarang.next()) {
                String isibarang = databarang.getString("id_barang");
                pm.setId_barang(isibarang);
            }

            // Tambahkan peminjaman
            pm.tambahPeminjaman();

        } catch (SQLException sQLException) {
            System.out.println("Data tidak masuk: " + sQLException.getMessage());
        }
        loadTable();
        reset();
        Main.pConten.removeAll();
        Main.pConten.add(new FramePeminjaman());
        Main.pConten.repaint();
        Main.pConten.revalidate();
        dispose();


    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        try {
            Peminjaman pm = new Peminjaman();
            Peminjam p = new Peminjam();
            Barang brg = new Barang();
            pm.setId_peminjaman(txtIDPeminjaman.getText());
            p.setNama(cbPeminjam.getSelectedItem().toString());
            brg.setNama_barang(cbBarang.getSelectedItem().toString());
            pm.setStatus(cbStatus.getSelectedItem().toString());
            pm.setJumlah(Integer.parseInt(txtJumlah.getText()));
            pm.setTanggal_pinjam(txtTanggalPinjam.getText());
            pm.setTanggal_kembali(txtTanggalKembali.getText());
            String namaBarang = cbBarang.getSelectedItem().toString();

            int jumlahPinjam = Integer.parseInt(txtJumlah.getText());

            ResultSet datapeminjam = p.KonversiPeminjam();
            ResultSet databarang = brg.KonversiBarang();

            if (datapeminjam.next()) {
                String isipeminjam = datapeminjam.getString("id_peminjam");
                pm.setId_peminjam(isipeminjam);
            }
            if (databarang.next()) {
                String isibarang = databarang.getString("id_barang");
                pm.setId_barang(isibarang);
            }
            pm.ubahPeminjaman();
        } catch (SQLException sQLException) {
            System.out.println("data tidak masuk");
        }
        loadTable();
        reset();
        Main.pConten.removeAll();
        Main.pConten.add(new FramePeminjaman());
        Main.pConten.repaint();
        Main.pConten.revalidate();
        dispose();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnKembalikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembalikanActionPerformed
        lblTanggalKembali.setVisible(true);
        txtTanggalKembali.setVisible(true);
        setTanggalKembali();
        try {

            // Ambil data dari form atau tabel
            String idPeminjaman = txtIDPeminjaman.getText();
            String namaBarang = cbBarang.getSelectedItem().toString();
            String tglkembali = txtTanggalKembali.getText();
            int jumlah = Integer.parseInt(txtJumlah.getText());

            // Ubah status menjadi "Dikembalikan"
            Peminjaman pm = new Peminjaman();
            pm.ubahStatusPeminjaman(idPeminjaman, "Dikembalikan", tglkembali);

            JOptionPane.showMessageDialog(this, "Barang berhasil dikembalikan!");

        } catch (SQLException ex) {
            ex.printStackTrace(); // Debugging
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage());
        }

        // Refresh tabel dan reset form
        loadTable();
        reset();
        Main.pConten.removeAll();
        Main.pConten.add(new FramePeminjaman());
        Main.pConten.repaint();
        Main.pConten.revalidate();
        dispose();
    }//GEN-LAST:event_btnKembalikanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
            Peminjaman pm = new Peminjaman();
            pm.setId_peminjaman(txtIDPeminjaman.getText()); // ID yang berasal dari tabel
            pm.hapusPeminjaman();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan: " + sQLException.getMessage());
        }

        // Reset dan reload tabel setelah hapus
        reset();
        loadTable();

        Main.pConten.removeAll();
        Main.pConten.add(new FramePeminjaman());
        Main.pConten.repaint();
        Main.pConten.revalidate();
        dispose();

    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtJumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyReleased
        try {
            Barang brg = new Barang();
            String namaBarang = cbBarang.getSelectedItem().toString();

            // Ambil teks terbaru dari text field
            String inputJumlah = txtJumlah.getText().trim();

            // Validasi hanya jika input tidak kosong dan berupa angka
            if (!inputJumlah.isEmpty() && inputJumlah.matches("\\d+")) {
                int jumlahPinjam = Integer.parseInt(inputJumlah);

                // Ambil jumlah stok barang dari database
                int stokTersedia = brg.getJumlahBarang(namaBarang);

                // Validasi stok barang
                if (jumlahPinjam > stokTersedia) {
                    JOptionPane.showMessageDialog(this,
                            "Jumlah barang yang dipinjam melebihi stok tersedia!",
                            "Peringatan",
                            JOptionPane.WARNING_MESSAGE);
                    txtJumlah.setText(""); // Reset text field
                }
            } else if (!inputJumlah.isEmpty()) {
                // Jika input bukan angka, reset field dan tampilkan pesan
                JOptionPane.showMessageDialog(this,
                        "Input harus berupa angka!",
                        "Peringatan",
                        JOptionPane.WARNING_MESSAGE);
                txtJumlah.setText("");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Kesalahan saat memvalidasi stok barang: " + e.getMessage(),
                    "Kesalahan",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Input tidak valid: " + e.getMessage(),
                    "Kesalahan",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtJumlahKeyReleased

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
            java.util.logging.Logger.getLogger(FrameInputPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameInputPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameInputPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameInputPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameInputPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnHapus;
    public javax.swing.JButton btnKembalikan;
    public javax.swing.JButton btnTambah;
    public javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cbBarang;
    private javax.swing.JComboBox<String> cbPeminjam;
    public javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel lblTanggalKembali;
    private javax.swing.JLabel txtIDPeminjaman;
    private javax.swing.JTextField txtJumlah;
    public javax.swing.JTextField txtTanggalKembali;
    private javax.swing.JTextField txtTanggalPinjam;
    // End of variables declaration//GEN-END:variables
}
