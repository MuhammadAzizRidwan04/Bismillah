package Kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Peminjam {

    String id_peminjam, nama, no_tlp, instansi, alamat, nik;

    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public Peminjam() throws SQLException {
        Koneksi koneksi = new Koneksi();
        konek = koneksi.konekDB();
    }

    public String getId_peminjam() {
        return id_peminjam;
    }

    public void setId_peminjam(String id_peminjam) {
        this.id_peminjam = id_peminjam;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_tlp() {
        return no_tlp;
    }

    public void setNo_tlp(String no_tlp) {
        this.no_tlp = no_tlp;
    }

    public String getInstansi() {
        return instansi;
    }

    public void setInstansi(String instansi) {
        this.instansi = instansi;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    

    public void tambahPeminjam() {
        query = "INSERT INTO peminjam VALUES(?,?,?,?,?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_peminjam);
            ps.setString(2, nama);
            ps.setString(3, no_tlp);
            ps.setString(4, instansi);
            ps.setString(5, alamat);
            ps.setString(6, nik);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal  Ditambahkan");
        }
    }

    public ResultSet tampilPeminjam() {
        query = "SELECT * FROM peminjam";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }

    public void hapusPeminjam() {
        query = "DELETE FROM peminjam WHERE id_peminjam = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_peminjam);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
        }
    }

    public void ubahPeminjam() {
        query = "UPDATE peminjam SET "
                + "nama = ?, "
                + "no_tlp = ?, "
                + "instansi = ?, "
                + "alamat = ?, "
                + "nik = ? "
                + "WHERE id_peminjam = ?";

        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama);
            ps.setString(2, no_tlp);
            ps.setString(3, instansi);
            ps.setString(4, alamat);
            ps.setString(5, nik);
            ps.setString(6, id_peminjam);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data berhasil Diubah");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }
    }

    public ResultSet tampilComBoxPeminjam() {
        query = "SELECT nama FROM peminjam";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }

    public ResultSet KonversiPeminjam() {
        query = "SELECT id_peminjam FROM peminjam WHERE nama = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama);

            rs = ps.executeQuery();
            System.out.println("data masuk");
        } catch (SQLException sQLException) {
            System.out.println("data tak masuk");
        }
        return rs;
    }

    public String autoID() {
        String newID = "IDPM0001"; // Default jika tidak ada data
        query = "SELECT id_peminjam AS ID FROM peminjam ORDER BY id_peminjam DESC LIMIT 1";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                String lastID = rs.getString("ID");
                if (lastID != null && lastID.startsWith("IDPM")) {
                    int num = Integer.parseInt(lastID.substring(4)); // Ambil angka dari ID terakhir
                    num++; // Increment angka
                    newID = String.format("IDPM%04d", num); // Format ke KTBR000X
                }
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil: " + sQLException.getMessage());
        }
        return newID;
    }
    
    public ResultSet cariPeminjam(String keyword) {
        query = "SELECT * FROM peminjam WHERE "
                + "id_peminjam LIKE ? OR "
                + "nama LIKE ? OR "
                + "no_tlp LIKE ? OR "
                + "instansi LIKE ? OR "
                + "alamat LIKE ? OR "
                + "nik LIKE ?";
        try {
            ps = konek.prepareStatement(query);
            for (int i = 1; i <= 6; i++) {
                ps.setString(i, "%" + keyword + "%"); // Wildcard pencarian untuk semua kolom
            }
            rs = ps.executeQuery();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dicari: " + sQLException.getMessage());
        }
        return rs;
    }
}
