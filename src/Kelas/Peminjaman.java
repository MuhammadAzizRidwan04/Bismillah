package Kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class Peminjaman {

    String id_peminjaman, id_peminjam, id_barang, status, tanggal_pinjam, tanggal_kembali;
    int jumlah;

    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public Peminjaman() throws SQLException {
        Koneksi koneksi = new Koneksi();
        konek = koneksi.konekDB();
    }

    public String getId_peminjaman() {
        return id_peminjaman;
    }

    public void setId_peminjaman(String id_peminjaman) {
        this.id_peminjaman = id_peminjaman;
    }

    public String getId_peminjam() {
        return id_peminjam;
    }

    public void setId_peminjam(String id_peminjam) {
        this.id_peminjam = id_peminjam;
    }

    public String getId_barang() {
        return id_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTanggal_pinjam() {
        return tanggal_pinjam;
    }

    public void setTanggal_pinjam(String tanggal_pinjam) {
        this.tanggal_pinjam = tanggal_pinjam;
    }

    public String getTanggal_kembali() {
        return tanggal_kembali;
    }

    public void setTanggal_kembali(String tanggal_kembali) {
        this.tanggal_kembali = tanggal_kembali;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void tambahPeminjaman() {
        query = "INSERT INTO peminjaman VALUES(?,?,?,?,?,?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_peminjaman);
            ps.setString(2, id_peminjam);
            ps.setString(3, id_barang);
            ps.setString(4, status);
            ps.setInt(5, jumlah);
            ps.setString(6, tanggal_pinjam);
            ps.setString(7, tanggal_kembali);

            ps.executeUpdate();
            ps.close();
           // kurangiStokBarang();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal  Ditambahkan");
            System.out.println(sQLException);
        }
    }

    public ResultSet tampilPeminjaman() {
        query = "SELECT "
                + "pm.id_peminjaman AS ID, "
                + "p.nama AS Peminjam, " // Menggunakan p.nama karena kolom yang benar adalah 'nama'
                + "b.nama_barang AS Barang, "
                + "pm.status AS Status, "
                + "pm.jumlah AS Jumlah, "
                + "pm.tanggal_pinjam AS Tanggal_Pinjam, "
                + "pm.tanggal_kembali AS Tanggal_Kembali "
                + "FROM peminjaman pm "
                + "JOIN peminjam p ON pm.id_peminjam = p.id_peminjam " // join dengan 'peminjam' dan menggunakan 'p.nama'
                + "JOIN barang b ON pm.id_barang = b.id_barang";

        try {
            System.out.println("Query: " + query);
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            System.out.println(sQLException);

        }
        return rs;
    }

    public void hapusPeminjaman() {
        query = "DELETE FROM peminjaman WHERE id_peminjaman = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_peminjaman);

            ps.executeUpdate();
            ps.close();
            //JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
        }
    }

    public void ubahPeminjaman() {

        query = "UPDATE peminjaman "
                + "SET id_peminjam = ?, "
                + "id_barang = ?, "
                + "status = ?, "
                + "jumlah = ?, "
                + "tanggal_pinjam = ?, "
                + "tanggal_kembali = ? "
                + "WHERE id_peminjaman = ?";

        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_peminjam);
            ps.setString(2, id_barang);
            ps.setString(3, status);
            ps.setInt(4, jumlah);
            ps.setString(5, tanggal_pinjam);
            ps.setString(6, tanggal_kembali);
            ps.setString(7, id_peminjaman);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data berhasil Diubah");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }

    }

    public String autoID() {
        String newID = "IDPJ0001"; // Default jika tidak ada data
        query = "SELECT id_peminjaman AS ID FROM peminjaman ORDER BY id_peminjaman DESC LIMIT 1";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                String lastID = rs.getString("ID");
                if (lastID != null && lastID.startsWith("IDPJ")) {
                    int num = Integer.parseInt(lastID.substring(4)); // Ambil angka dari ID terakhir
                    num++; // Increment angka
                    newID = String.format("IDPJ%04d", num); // Format ke KTBR000X
                }
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil: " + sQLException.getMessage());
        }
        return newID;
    }

    public void kurangiStokBarang() {
        query = "UPDATE barang SET jumlah = jumlah - ? WHERE id_barang = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setInt(1, jumlah); // jumlah yang dipinjam
            ps.setString(2, id_barang); // id barang
            ps.executeUpdate();
            ps.close();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Gagal mengurangi stok barang: " + sQLException.getMessage());
        }
    }

    public void ubahStatusPeminjaman(String idPeminjaman, String status, String tglkembali) throws SQLException {
        query = "UPDATE peminjaman SET status = ?, tanggal_kembali = ? WHERE id_peminjaman = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, status);
            ps.setString(2, tglkembali);
            ps.setString(3, idPeminjaman);
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    public ResultSet cariPeminjaman(String keyword) {
        query = "SELECT peminjaman.id_peminjaman, peminjam.nama AS nama_peminjam, barang.nama_barang, "
                + "peminjaman.status, peminjaman.jumlah, peminjaman.tanggal_pinjam, peminjaman.tanggal_kembali "
                + "FROM peminjaman "
                + "JOIN peminjam ON peminjaman.id_peminjam = peminjam.id_peminjam "
                + "JOIN barang ON peminjaman.id_barang = barang.id_barang "
                + "WHERE peminjaman.id_peminjaman LIKE ? OR "
                + "peminjam.nama LIKE ? OR "
                + "barang.nama_barang LIKE ? OR "
                + "peminjaman.status LIKE ? "
                + "ORDER BY peminjaman.tanggal_pinjam DESC";

        try {
            ps = konek.prepareStatement(query);
            for (int i = 1; i <= 4; i++) {
                ps.setString(i, "%" + keyword + "%"); // Wildcard pencarian untuk semua kolom
            }
            rs = ps.executeQuery();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dicari: " + sQLException.getMessage());
        }
        return rs;
    }

}
