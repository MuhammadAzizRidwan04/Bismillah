package View;

import Kelas.Vendor;
import Kelas.Kategori;
import Kelas.Peminjam;
import Kelas.Barang;
import Kelas.Peminjaman;
import com.formdev.flatlaf.FlatClientProperties;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrameDashboard extends javax.swing.JPanel {

    public FrameDashboard() {
        initComponents();
        tampilJumlahVendor();
        tampilJumlahKategori();
        tampilJumlahPeminjam();
        tampilJumlahBarangBaru();
        tampilJumlahBarangSecond();
        tampilJumlahBarang();
        tampilJumlahDipinjam();

        pVendor.putClientProperty(FlatClientProperties.STYLE, "arc:25");
        pKategori.putClientProperty(FlatClientProperties.STYLE, "arc:25");
        pPeminjam.putClientProperty(FlatClientProperties.STYLE, "arc:25");
        pNewB.putClientProperty(FlatClientProperties.STYLE, "arc:25");
        pBarangSecond.putClientProperty(FlatClientProperties.STYLE, "arc:25");
        pBarang.putClientProperty(FlatClientProperties.STYLE, "arc:25");
        pDipinjam.putClientProperty(FlatClientProperties.STYLE, "arc:25");
    }

    void tampilJumlahVendor() {
        try {
            Vendor jumVendor = new Vendor();
            int jumlahKode = jumVendor.TampilJumlahVendor();

            lblJumlahVendor.setText(String.valueOf(jumlahKode));
        } catch (SQLException ex) {
            Logger.getLogger(FrameDashboard.class.getName()).log(Level.SEVERE, null, ex);
            lblJumlahVendor.setText("Error");
        }
    }

    void tampilJumlahKategori() {
        try {
            Kategori jumKategori = new Kategori();
            int jumlahKode = jumKategori.TampilJumlahKategori();

            lblJumlahKategori.setText(String.valueOf(jumlahKode));
        } catch (SQLException ex) {
            Logger.getLogger(FrameDashboard.class.getName()).log(Level.SEVERE, null, ex);
            lblJumlahKategori.setText("Error");
        }
    }

    void tampilJumlahPeminjam() {
        try {
            Peminjam jumPeminjam = new Peminjam();
            int jumlahKode = jumPeminjam.TampilJumlahPeminjam();

            lblJumlahPeminjam.setText(String.valueOf(jumlahKode));
        } catch (SQLException ex) {
            Logger.getLogger(FrameDashboard.class.getName()).log(Level.SEVERE, null, ex);
            lblJumlahPeminjam.setText("Error");
        }
    }

    void tampilJumlahBarangBaru() {
        try {
            Barang jumBarangnew = new Barang();
            int jumlahKode = jumBarangnew.TampilJumlahBarangBaru();

            lblJumlahNewB.setText(String.valueOf(jumlahKode));
        } catch (SQLException ex) {
            Logger.getLogger(FrameDashboard.class.getName()).log(Level.SEVERE, null, ex);
            lblJumlahNewB.setText("Error");
        }
    }

    void tampilJumlahBarangSecond() {
        try {
            Barang jumBarangnew = new Barang();
            int jumlahKode = jumBarangnew.TampilJumlahBarangSecond();

            lblJumlahSecondB.setText(String.valueOf(jumlahKode));
        } catch (SQLException ex) {
            Logger.getLogger(FrameDashboard.class.getName()).log(Level.SEVERE, null, ex);
            lblJumlahSecondB.setText("Error");
        }
    }

    void tampilJumlahBarang() {
        try {
            Barang jumBarang = new Barang();
            int jumlahKode = jumBarang.TampilJumlahBarang();

            lblJumlahBarang.setText(String.valueOf(jumlahKode));
        } catch (SQLException ex) {
            Logger.getLogger(FrameDashboard.class.getName()).log(Level.SEVERE, null, ex);
            lblJumlahBarang.setText("Error");
        }
    }

    void tampilJumlahDipinjam() {
        try {
            Peminjaman jumDipinjam = new Peminjaman();
            int jumlahKode = jumDipinjam.TampilJumlahBarangDipinjam();

            lblJumlahDipinjam.setText(String.valueOf(jumlahKode));
        } catch (SQLException ex) {
            Logger.getLogger(FrameDashboard.class.getName()).log(Level.SEVERE, null, ex);
            lblJumlahDipinjam.setText("Error");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pVendor = new javax.swing.JPanel();
        lblJumlahVendor = new javax.swing.JLabel();
        pKategori = new javax.swing.JPanel();
        lblJumlahKategori = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        showVendor = new javax.swing.JLabel();
        showKategori = new javax.swing.JLabel();
        pPeminjam = new javax.swing.JPanel();
        lblJumlahPeminjam = new javax.swing.JLabel();
        showPeminjam = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pNewB = new javax.swing.JPanel();
        lblJumlahNewB = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        showBarangNew = new javax.swing.JLabel();
        pBarangSecond = new javax.swing.JPanel();
        lblJumlahSecondB = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pBarang = new javax.swing.JPanel();
        lblJumlahBarang = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        showBarang = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pDipinjam = new javax.swing.JPanel();
        lblJumlahDipinjam = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        showDipinjam = new javax.swing.JLabel();
        showBarangSecond1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pVendor.setBackground(new java.awt.Color(0, 153, 204));
        pVendor.setLayout(new java.awt.BorderLayout());

        lblJumlahVendor.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblJumlahVendor.setForeground(new java.awt.Color(255, 255, 255));
        lblJumlahVendor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJumlahVendor.setText("Vendor");
        pVendor.add(lblJumlahVendor, java.awt.BorderLayout.CENTER);

        pKategori.setBackground(new java.awt.Color(0, 153, 204));

        lblJumlahKategori.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblJumlahKategori.setForeground(new java.awt.Color(255, 255, 255));
        lblJumlahKategori.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJumlahKategori.setText("Kategori");

        javax.swing.GroupLayout pKategoriLayout = new javax.swing.GroupLayout(pKategori);
        pKategori.setLayout(pKategoriLayout);
        pKategoriLayout.setHorizontalGroup(
            pKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pKategoriLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblJumlahKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pKategoriLayout.setVerticalGroup(
            pKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pKategoriLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblJumlahKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Jumlah Kategori");

        showVendor.setBackground(new java.awt.Color(0, 153, 204));
        showVendor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showVendor.setForeground(new java.awt.Color(0, 153, 204));
        showVendor.setText("Show");
        showVendor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showVendorMouseClicked(evt);
            }
        });

        showKategori.setBackground(new java.awt.Color(0, 153, 204));
        showKategori.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showKategori.setForeground(new java.awt.Color(0, 153, 204));
        showKategori.setText("Show");
        showKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showKategoriMouseClicked(evt);
            }
        });

        pPeminjam.setBackground(new java.awt.Color(0, 153, 204));

        lblJumlahPeminjam.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblJumlahPeminjam.setForeground(new java.awt.Color(255, 255, 255));
        lblJumlahPeminjam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJumlahPeminjam.setText("Peminjam");

        javax.swing.GroupLayout pPeminjamLayout = new javax.swing.GroupLayout(pPeminjam);
        pPeminjam.setLayout(pPeminjamLayout);
        pPeminjamLayout.setHorizontalGroup(
            pPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
            .addGroup(pPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pPeminjamLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblJumlahPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pPeminjamLayout.setVerticalGroup(
            pPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pPeminjamLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblJumlahPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        showPeminjam.setBackground(new java.awt.Color(0, 153, 204));
        showPeminjam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showPeminjam.setForeground(new java.awt.Color(0, 153, 204));
        showPeminjam.setText("Show");
        showPeminjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showPeminjamMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total Barang");

        pNewB.setBackground(new java.awt.Color(0, 153, 204));

        lblJumlahNewB.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblJumlahNewB.setForeground(new java.awt.Color(255, 255, 255));
        lblJumlahNewB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJumlahNewB.setText("New Barang");

        javax.swing.GroupLayout pNewBLayout = new javax.swing.GroupLayout(pNewB);
        pNewB.setLayout(pNewBLayout);
        pNewBLayout.setHorizontalGroup(
            pNewBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
            .addGroup(pNewBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pNewBLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblJumlahNewB, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pNewBLayout.setVerticalGroup(
            pNewBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
            .addGroup(pNewBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pNewBLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblJumlahNewB, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Jumlah Barang Baru");

        showBarangNew.setBackground(new java.awt.Color(0, 153, 204));
        showBarangNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showBarangNew.setForeground(new java.awt.Color(0, 153, 204));
        showBarangNew.setText("Show");
        showBarangNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showBarangNewMouseClicked(evt);
            }
        });

        pBarangSecond.setBackground(new java.awt.Color(0, 153, 204));

        lblJumlahSecondB.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblJumlahSecondB.setForeground(new java.awt.Color(255, 255, 255));
        lblJumlahSecondB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJumlahSecondB.setText("Second Bar");

        javax.swing.GroupLayout pBarangSecondLayout = new javax.swing.GroupLayout(pBarangSecond);
        pBarangSecond.setLayout(pBarangSecondLayout);
        pBarangSecondLayout.setHorizontalGroup(
            pBarangSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
            .addGroup(pBarangSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pBarangSecondLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblJumlahSecondB, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pBarangSecondLayout.setVerticalGroup(
            pBarangSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
            .addGroup(pBarangSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pBarangSecondLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblJumlahSecondB, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Jumlah Barang Second");

        pBarang.setBackground(new java.awt.Color(0, 153, 204));

        lblJumlahBarang.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblJumlahBarang.setForeground(new java.awt.Color(255, 255, 255));
        lblJumlahBarang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJumlahBarang.setText("Barang");

        javax.swing.GroupLayout pBarangLayout = new javax.swing.GroupLayout(pBarang);
        pBarang.setLayout(pBarangLayout);
        pBarangLayout.setHorizontalGroup(
            pBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pBarangLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pBarangLayout.setVerticalGroup(
            pBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pBarangLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Jumlah Peminjam");

        showBarang.setBackground(new java.awt.Color(0, 153, 204));
        showBarang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showBarang.setForeground(new java.awt.Color(0, 153, 204));
        showBarang.setText("Show");
        showBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showBarangMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Jumlah Vendor");

        pDipinjam.setBackground(new java.awt.Color(0, 153, 204));

        lblJumlahDipinjam.setBackground(new java.awt.Color(0, 153, 204));
        lblJumlahDipinjam.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblJumlahDipinjam.setForeground(new java.awt.Color(255, 255, 255));
        lblJumlahDipinjam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJumlahDipinjam.setText("Dipinjam");

        javax.swing.GroupLayout pDipinjamLayout = new javax.swing.GroupLayout(pDipinjam);
        pDipinjam.setLayout(pDipinjamLayout);
        pDipinjamLayout.setHorizontalGroup(
            pDipinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
            .addGroup(pDipinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pDipinjamLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblJumlahDipinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pDipinjamLayout.setVerticalGroup(
            pDipinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
            .addGroup(pDipinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pDipinjamLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblJumlahDipinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Barang Dipinjam");

        showDipinjam.setBackground(new java.awt.Color(0, 153, 204));
        showDipinjam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showDipinjam.setForeground(new java.awt.Color(0, 153, 204));
        showDipinjam.setText("Show");
        showDipinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showDipinjamMouseClicked(evt);
            }
        });

        showBarangSecond1.setBackground(new java.awt.Color(0, 153, 204));
        showBarangSecond1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showBarangSecond1.setForeground(new java.awt.Color(0, 153, 204));
        showBarangSecond1.setText("Show");
        showBarangSecond1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showBarangSecond1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(pVendor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(74, 74, 74))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(showVendor)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pNewB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(showBarangNew)
                                    .addComponent(jLabel5)
                                    .addComponent(pDipinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel9)
                                .addComponent(jLabel8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(showDipinjam)
                        .addGap(293, 293, 293)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showKategori)
                    .addComponent(jLabel3)
                    .addComponent(pBarangSecond, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pPeminjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showPeminjam)
                        .addComponent(jLabel4)
                        .addComponent(pBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(showBarang)
                    .addComponent(jLabel7))
                .addGap(123, 123, 123))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(372, 372, 372)
                    .addComponent(showBarangSecond1)
                    .addContainerGap(673, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pPeminjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pVendor, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showVendor)
                    .addComponent(showKategori)
                    .addComponent(showPeminjam))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pBarangSecond, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pNewB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showBarangNew)
                    .addComponent(showBarang))
                .addGap(46, 46, 46)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pDipinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showDipinjam)
                .addGap(56, 56, 56))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(382, Short.MAX_VALUE)
                    .addComponent(showBarangSecond1)
                    .addGap(229, 229, 229)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1078, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void showVendorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showVendorMouseClicked
        Main.pConten.removeAll();
        Main.pConten.add(new FrameVendor());
        Main.pConten.repaint();
        Main.pConten.revalidate();
    }//GEN-LAST:event_showVendorMouseClicked

    private void showKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showKategoriMouseClicked
        Main.pConten.removeAll();
        Main.pConten.add(new FrameKategori());
        Main.pConten.repaint();
        Main.pConten.revalidate();
    }//GEN-LAST:event_showKategoriMouseClicked

    private void showPeminjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPeminjamMouseClicked
        Main.pConten.removeAll();
        Main.pConten.add(new FramePeminjam());
        Main.pConten.repaint();
        Main.pConten.revalidate();
    }//GEN-LAST:event_showPeminjamMouseClicked

    private void showBarangNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showBarangNewMouseClicked
        Main.pConten.removeAll();
        Main.pConten.add(new FrameBarang());
        Main.pConten.repaint();
        Main.pConten.revalidate();
    }//GEN-LAST:event_showBarangNewMouseClicked

    private void showBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showBarangMouseClicked
        Main.pConten.removeAll();
        Main.pConten.add(new FrameBarang());
        Main.pConten.repaint();
        Main.pConten.revalidate();
    }//GEN-LAST:event_showBarangMouseClicked

    private void showDipinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showDipinjamMouseClicked
        new FrameLaporanBarang().setVisible(true);
    }//GEN-LAST:event_showDipinjamMouseClicked

    private void showBarangSecond1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showBarangSecond1MouseClicked
        Main.pConten.removeAll();
        Main.pConten.add(new FrameBarang());
        Main.pConten.repaint();
        Main.pConten.revalidate();
    }//GEN-LAST:event_showBarangSecond1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblJumlahBarang;
    private javax.swing.JLabel lblJumlahDipinjam;
    private javax.swing.JLabel lblJumlahKategori;
    private javax.swing.JLabel lblJumlahNewB;
    private javax.swing.JLabel lblJumlahPeminjam;
    private javax.swing.JLabel lblJumlahSecondB;
    private javax.swing.JLabel lblJumlahVendor;
    private javax.swing.JPanel pBarang;
    private javax.swing.JPanel pBarangSecond;
    private javax.swing.JPanel pDipinjam;
    private javax.swing.JPanel pKategori;
    private javax.swing.JPanel pNewB;
    private javax.swing.JPanel pPeminjam;
    private javax.swing.JPanel pVendor;
    private javax.swing.JLabel showBarang;
    private javax.swing.JLabel showBarangNew;
    private javax.swing.JLabel showBarangSecond1;
    private javax.swing.JLabel showDipinjam;
    private javax.swing.JLabel showKategori;
    private javax.swing.JLabel showPeminjam;
    private javax.swing.JLabel showVendor;
    // End of variables declaration//GEN-END:variables
}
