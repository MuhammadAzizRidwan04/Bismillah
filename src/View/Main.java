package View;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
public class Main extends javax.swing.JFrame {

    private int xPos; // Posisi X label
    private Timer timer;
    private boolean isYellow = false; // Status warna

    public Main() {
        initComponents();
        setupTimer();
        updateDateTime();
    }
    private void updateDateTime() {
        // Membuat format tanggal dan waktu
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
        
        // Timer untuk memperbarui label setiap detik
        Timer timer = new Timer(1000, e -> {
            // Mendapatkan waktu sekarang
            Date now = new Date();
            // Mengatur teks label dengan waktu terbaru
            labelWaktu.setText(formatter.format(now));
        });
        timer.start();
    }

    private void setupTimer() {
    // Timer untuk menggerakkan label
    timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            xPos -= 2; // Gerakkan label ke kiri
            if (xPos + labelNama.getWidth() < 0) { // Jika label keluar dari layar di sebelah kiri
                xPos = getWidth(); // Reset ke posisi di sebelah kanan layar
            }
            labelNama.setBounds(xPos, labelNama.getY(), labelNama.getWidth(), labelNama.getHeight());
        }
    });
    timer.start(); // Mulai timer

    Timer colorTimer = new Timer(500, new ActionListener() {
        private boolean isYellow = false; // Status warna

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isYellow) {
                labelNama.setForeground(Color.WHITE); // Kembali ke putih
                labelLogo.setForeground(Color.WHITE); // Kembali ke putih
            } else {
                labelNama.setForeground(Color.YELLOW); // Ubah menjadi kuning
                labelLogo.setForeground(Color.YELLOW); // Ubah menjadi kuning
            }
            isYellow = !isYellow; // Ganti status warna
        }
    });
    colorTimer.start(); // Mulai timer warna
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        pVendor = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        bVendor = new javax.swing.JLabel();
        pKategori = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bKategori = new javax.swing.JLabel();
        pBarang = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        bBarang = new javax.swing.JLabel();
        pPeminjam = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        bPeminjam = new javax.swing.JLabel();
        pPeminjaman = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        bPeminjaman = new javax.swing.JLabel();
        pQR = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        bQR = new javax.swing.JLabel();
        pKeluar = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        bKeluar = new javax.swing.JLabel();
        labelWaktu = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelNama = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pConten = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Inventaris ITM");
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(153, 102, 255));

        jPanel2.setBackground(new java.awt.Color(0, 51, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Logo  (1).png"))); // NOI18N

        labelLogo.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        labelLogo.setForeground(new java.awt.Color(255, 255, 255));
        labelLogo.setText("INVENTARIS ");

        pVendor.setBackground(new java.awt.Color(0, 51, 153));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/stores.png"))); // NOI18N

        bVendor.setBackground(new java.awt.Color(0, 51, 153));
        bVendor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bVendor.setForeground(new java.awt.Color(255, 255, 255));
        bVendor.setText("Vendor");
        bVendor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bVendorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bVendorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bVendorMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pVendorLayout = new javax.swing.GroupLayout(pVendor);
        pVendor.setLayout(pVendorLayout);
        pVendorLayout.setHorizontalGroup(
            pVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVendorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(bVendor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pVendorLayout.setVerticalGroup(
            pVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVendorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pVendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bVendor)
                    .addComponent(jLabel5))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pKategori.setBackground(new java.awt.Color(0, 51, 153));
        pKategori.setPreferredSize(new java.awt.Dimension(126, 58));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/application.png"))); // NOI18N

        bKategori.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bKategori.setForeground(new java.awt.Color(255, 255, 255));
        bKategori.setText("Kategori");
        bKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bKategoriMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bKategoriMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bKategoriMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pKategoriLayout = new javax.swing.GroupLayout(pKategori);
        pKategori.setLayout(pKategoriLayout);
        pKategoriLayout.setHorizontalGroup(
            pKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pKategoriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(bKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pKategoriLayout.setVerticalGroup(
            pKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pKategoriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bKategori)
                    .addComponent(jLabel3))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pBarang.setBackground(new java.awt.Color(0, 51, 153));
        pBarang.setPreferredSize(new java.awt.Dimension(126, 58));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/package.png"))); // NOI18N

        bBarang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bBarang.setForeground(new java.awt.Color(255, 255, 255));
        bBarang.setText("Barang");
        bBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBarangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBarangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bBarangMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pBarangLayout = new javax.swing.GroupLayout(pBarang);
        pBarang.setLayout(pBarangLayout);
        pBarangLayout.setHorizontalGroup(
            pBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(bBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pBarangLayout.setVerticalGroup(
            pBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(bBarang))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pPeminjam.setBackground(new java.awt.Color(0, 51, 153));
        pPeminjam.setPreferredSize(new java.awt.Dimension(126, 58));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/group.png"))); // NOI18N

        bPeminjam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bPeminjam.setForeground(new java.awt.Color(255, 255, 255));
        bPeminjam.setText("Peminjam");
        bPeminjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bPeminjamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bPeminjamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bPeminjamMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pPeminjamLayout = new javax.swing.GroupLayout(pPeminjam);
        pPeminjam.setLayout(pPeminjamLayout);
        pPeminjamLayout.setHorizontalGroup(
            pPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPeminjamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(bPeminjam)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pPeminjamLayout.setVerticalGroup(
            pPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPeminjamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(bPeminjam))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pPeminjaman.setBackground(new java.awt.Color(0, 51, 153));
        pPeminjaman.setPreferredSize(new java.awt.Dimension(126, 58));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/folder.png"))); // NOI18N

        bPeminjaman.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bPeminjaman.setForeground(new java.awt.Color(255, 255, 255));
        bPeminjaman.setText("Pinjam Barang");
        bPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bPeminjamanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bPeminjamanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bPeminjamanMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pPeminjamanLayout = new javax.swing.GroupLayout(pPeminjaman);
        pPeminjaman.setLayout(pPeminjamanLayout);
        pPeminjamanLayout.setHorizontalGroup(
            pPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPeminjamanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(bPeminjaman)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pPeminjamanLayout.setVerticalGroup(
            pPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPeminjamanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bPeminjaman)
                    .addComponent(jLabel9))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pQR.setBackground(new java.awt.Color(0, 51, 153));
        pQR.setPreferredSize(new java.awt.Dimension(126, 58));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/qr.png"))); // NOI18N

        bQR.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bQR.setForeground(new java.awt.Color(255, 255, 255));
        bQR.setText("QR Code Barang");
        bQR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bQRMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bQRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bQRMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pQRLayout = new javax.swing.GroupLayout(pQR);
        pQR.setLayout(pQRLayout);
        pQRLayout.setHorizontalGroup(
            pQRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pQRLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(bQR)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pQRLayout.setVerticalGroup(
            pQRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pQRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pQRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bQR)
                    .addComponent(jLabel10))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pKeluar.setBackground(new java.awt.Color(0, 51, 153));
        pKeluar.setPreferredSize(new java.awt.Dimension(126, 58));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logout (1).png"))); // NOI18N

        bKeluar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bKeluar.setForeground(new java.awt.Color(255, 255, 255));
        bKeluar.setText("Keluar");
        bKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bKeluarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bKeluarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bKeluarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pKeluarLayout = new javax.swing.GroupLayout(pKeluar);
        pKeluar.setLayout(pKeluarLayout);
        pKeluarLayout.setHorizontalGroup(
            pKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pKeluarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(bKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pKeluarLayout.setVerticalGroup(
            pKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pKeluarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bKeluar)
                    .addComponent(jLabel12))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        labelWaktu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelWaktu.setForeground(new java.awt.Color(255, 255, 255));
        labelWaktu.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelWaktu)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pVendor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pKategori, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(pBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(pPeminjam, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(pPeminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(pQR, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelLogo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(pKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogo)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelWaktu)
                .addGap(28, 28, 28)
                .addComponent(pVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pQR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));

        labelNama.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        labelNama.setForeground(new java.awt.Color(255, 255, 255));
        labelNama.setText("SELAMAT DATANG DI INVENTARIS INSTITUT TEKNOLOGI MOJOSARI NGANJUK");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cropped-Logo-2-1 (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(labelNama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(labelNama))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pConten.setBackground(new java.awt.Color(255, 255, 255));
        pConten.setLayout(new java.awt.BorderLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Business PROPOSAL.png"))); // NOI18N
        pConten.add(jLabel13, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pConten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pConten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bVendorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bVendorMouseEntered
        pVendor.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_bVendorMouseEntered

    private void bVendorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bVendorMouseExited
        pVendor.setBackground(new Color(0, 51, 153));
    }//GEN-LAST:event_bVendorMouseExited

    private void bVendorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bVendorMouseClicked
        pConten.removeAll();
        pConten.add(new FrameVendor());
        pConten.repaint();
        pConten.revalidate();
        pVendor.setBackground(new Color(102, 204, 255));
    }//GEN-LAST:event_bVendorMouseClicked

    private void bKategoriMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKategoriMouseEntered
        pKategori.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_bKategoriMouseEntered

    private void bKategoriMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKategoriMouseExited
        pKategori.setBackground(new Color(0, 51, 153));
    }//GEN-LAST:event_bKategoriMouseExited

    private void bKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKategoriMouseClicked
        pConten.removeAll();
        pConten.add(new FrameKategori());
        pConten.repaint();
        pConten.revalidate();
        pKategori.setBackground(new Color(102, 204, 255));
    }//GEN-LAST:event_bKategoriMouseClicked

    private void bBarangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBarangMouseEntered
        pBarang.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_bBarangMouseEntered

    private void bBarangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBarangMouseExited
        pBarang.setBackground(new Color(0, 51, 153));
    }//GEN-LAST:event_bBarangMouseExited

    private void bBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBarangMouseClicked
        pConten.removeAll();
        pConten.add(new FrameBarang());
        pConten.repaint();
        pConten.revalidate();
        pBarang.setBackground(new Color(102, 204, 255));
    }//GEN-LAST:event_bBarangMouseClicked

    private void bPeminjamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPeminjamMouseEntered
        pPeminjam.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_bPeminjamMouseEntered

    private void bPeminjamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPeminjamMouseExited
        pPeminjam.setBackground(new Color(0, 51, 153));
    }//GEN-LAST:event_bPeminjamMouseExited

    private void bPeminjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPeminjamMouseClicked
        pConten.removeAll();
        pConten.add(new FramePeminjam());
        pConten.repaint();
        pConten.revalidate();
        pPeminjam.setBackground(new Color(102, 204, 255));
    }//GEN-LAST:event_bPeminjamMouseClicked

    private void bPeminjamanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPeminjamanMouseEntered
        pPeminjaman.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_bPeminjamanMouseEntered

    private void bPeminjamanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPeminjamanMouseExited
        pPeminjaman.setBackground(new Color(0, 51, 153));
    }//GEN-LAST:event_bPeminjamanMouseExited

    private void bPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPeminjamanMouseClicked
        pConten.removeAll();
        pConten.add(new FramePeminjaman());
        pConten.repaint();
        pConten.revalidate();
        pPeminjaman.setBackground(new Color(102, 204, 255));
    }//GEN-LAST:event_bPeminjamanMouseClicked

    private void bQRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bQRMouseEntered
        pQR.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_bQRMouseEntered

    private void bQRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bQRMouseExited
        pQR.setBackground(new Color(0, 51, 153));
    }//GEN-LAST:event_bQRMouseExited

    private void bQRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bQRMouseClicked
        pConten.removeAll();
        pConten.add(new FrameQR());
        pConten.repaint();
        pConten.revalidate();
        pQR.setBackground(new Color(102, 204, 255));
    }//GEN-LAST:event_bQRMouseClicked

    private void bKeluarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKeluarMouseEntered
        pKeluar.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_bKeluarMouseEntered

    private void bKeluarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKeluarMouseExited
        pKeluar.setBackground(new Color(0, 51, 153));
    }//GEN-LAST:event_bKeluarMouseExited

    private void bKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKeluarMouseClicked
        pKeluar.setBackground(new Color(102, 204, 255));
        new Main().setVisible(true);
        dispose();
    }//GEN-LAST:event_bKeluarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
            UIManager.put("Button.arc", 15);
            UIManager.put("TextComponent.arc", 15);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bBarang;
    private javax.swing.JLabel bKategori;
    private javax.swing.JLabel bKeluar;
    private javax.swing.JLabel bPeminjam;
    private javax.swing.JLabel bPeminjaman;
    private javax.swing.JLabel bQR;
    private javax.swing.JLabel bVendor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelWaktu;
    private javax.swing.JPanel pBarang;
    public static javax.swing.JPanel pConten;
    private javax.swing.JPanel pKategori;
    private javax.swing.JPanel pKeluar;
    private javax.swing.JPanel pPeminjam;
    private javax.swing.JPanel pPeminjaman;
    private javax.swing.JPanel pQR;
    private javax.swing.JPanel pVendor;
    // End of variables declaration//GEN-END:variables
}
