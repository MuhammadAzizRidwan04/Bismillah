package View;

import Kelas.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;


public class FrameSisaBarang extends javax.swing.JFrame {

    public FrameSisaBarang() {
        initComponents();
        loadDataToTextArea();
    }

    private void loadDataToTextArea() {
    txtLaporanBarang.setText(""); // Bersihkan teks di TextArea terlebih dahulu
    try {
        Koneksi koneksi = new Koneksi(); // Membuat instance kelas Koneksi
        Connection conn = koneksi.konekDB(); // Memanggil metode konekDB()
        String query = """
            SELECT 
                b.nama_barang, 
                b.jumlah AS total_barang, 
                COALESCE(SUM(p.jumlah), 0) AS sedang_dipinjam
            FROM 
                barang b
            LEFT JOIN 
                peminjaman p ON b.id_barang = p.id_barang AND p.status = 'Dipinjam'
            GROUP BY 
                b.id_barang, b.nama_barang, b.jumlah
        """;

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        // Iterasi data dan tambahkan ke TextArea
        StringBuilder laporan = new StringBuilder(); // Untuk menyusun teks laporan
        laporan.append("Nama Barang\tTotal Barang\tSedang Dipinjam      Sisa Barang\n");
        laporan.append("_____________________________________________________________________\n");
        
        while (rs.next()) {
            String namaBarang = rs.getString("nama_barang");
            int totalBarang = rs.getInt("total_barang");
            int sedangDipinjam = rs.getInt("sedang_dipinjam");
            int sisaBarang = totalBarang - sedangDipinjam; // Hitung sisa barang

            // Format string untuk setiap baris data
            laporan.append(String.format(
                "%-15s\t%-15d\t%-15d\t         %-15d\n", 
                namaBarang, totalBarang, sedangDipinjam, sisaBarang
            ));
        }

        // Set teks laporan ke dalam TextArea
        txtLaporanBarang.setText(laporan.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}




    // Komponen GUI lainnya
    private javax.swing.JPanel panelLaporanBarang;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtLaporanBarang = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sisa Barang");

        txtLaporanBarang.setBackground(new java.awt.Color(204, 204, 255));
        txtLaporanBarang.setColumns(20);
        txtLaporanBarang.setRows(5);
        txtLaporanBarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));
        jScrollPane1.setViewportView(txtLaporanBarang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrameSisaBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameSisaBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameSisaBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameSisaBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameSisaBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtLaporanBarang;
    // End of variables declaration//GEN-END:variables
}
