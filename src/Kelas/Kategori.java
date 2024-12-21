package Kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Kategori {

    String id_kategori, nama_kategori;

    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public Kategori() throws SQLException {
        Koneksi koneksi = new Koneksi();
        konek = koneksi.konekDB();
    }

    public String getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public void tambahKategori() {
        query = "INSERT INTO kategori VALUES(?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_kategori);
            ps.setString(2, nama_kategori);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal  Ditambahkan");
        }
    }

    public ResultSet tampilKategori() {
        query = "SELECT * FROM kategori";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }

    public void hapusKategori() {
        query = "DELETE FROM kategori WHERE id_kategori = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_kategori);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
        }
    }

    public void ubahKategori() {

        query = "UPDATE kategori SET "
                + "nama_kategori = ?"
                + "WHERE id_kategori = ?";

        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_kategori);
            ps.setString(2, id_kategori);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data berhasil Diubah");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }

    }

    public ResultSet tampilComBoxKategori() {
        query = "SELECT nama_kategori FROM kategori";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }

    public ResultSet KonversiKategori() {
        query = "SELECT id_kategori FROM kategori WHERE nama_kategori = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_kategori);

            rs = ps.executeQuery();
            System.out.println("data masuk");
        } catch (SQLException sQLException) {
            System.out.println("data tak masuk");
        }
        return rs;
    }

    public String autoID() {
        String newID = "KTBR0001"; // Default jika tidak ada data
        query = "SELECT id_kategori AS ID FROM kategori ORDER BY id_kategori DESC LIMIT 1";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                String lastID = rs.getString("ID");
                if (lastID != null && lastID.startsWith("KTBR")) {
                    int num = Integer.parseInt(lastID.substring(4)); // Ambil angka dari ID terakhir
                    num++; // Increment angka
                    newID = String.format("KTBR%04d", num); // Format ke KTBR000X
                }
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil: " + sQLException.getMessage());
        }
        return newID;
    }

    String getID(String kategoriName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ResultSet cariKategori(String keyword) {
    query = "SELECT * FROM kategori WHERE "
          + "id_kategori LIKE ? OR "
          + "nama_kategori LIKE ?";
          
    try {
        ps = konek.prepareStatement(query);
        for (int i = 1; i <= 2; i++) {
            ps.setString(i, "%" + keyword + "%"); // Wildcard pencarian untuk semua kolom
        }
        rs = ps.executeQuery();
    } catch (SQLException sQLException) {
        JOptionPane.showMessageDialog(null, "Data Gagal Dicari: " + sQLException.getMessage());
    }
    return rs;
}
    
   

    
}
