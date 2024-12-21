package Kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Vendor {

    String id_vendor, nama_vendor, alamat, nama_cp, no_tlp, email;

    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public Vendor() throws SQLException {
        Koneksi koneksi = new Koneksi();
        konek = koneksi.konekDB();
    }

    public String getId_vendor() {
        return id_vendor;
    }

    public void setId_vendor(String id_vendor) {
        this.id_vendor = id_vendor;
    }

    public String getNama_vendor() {
        return nama_vendor;
    }

    public void setNama_vendor(String nama_vendor) {
        this.nama_vendor = nama_vendor;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama_cp() {
        return nama_cp;
    }

    public void setNama_cp(String nama_cp) {
        this.nama_cp = nama_cp;
    }

    public String getNo_tlp() {
        return no_tlp;
    }

    public void setNo_tlp(String no_tlp) {
        this.no_tlp = no_tlp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void tambahVendor() {
        query = "INSERT INTO vendor VALUES(?,?,?,?,?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_vendor);
            ps.setString(2, nama_vendor);
            ps.setString(3, alamat);
            ps.setString(4, nama_cp);
            ps.setString(5, no_tlp);
            ps.setString(6, email);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal  Ditambahkan");
        }
    }

    public ResultSet tampilVendor() {
        query = "SELECT * FROM vendor";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }

    public void hapusVendor() {
        query = "DELETE FROM vendor WHERE id_vendor = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_vendor);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
        }
    }

    public void ubahVendor() {
        query = "UPDATE vendor SET "
                + "nama_vendor = ?, "
                + "alamat = ?, "
                + "nama_cp = ?, "
                + "no_tlp = ?, "
                + "email = ? "
                + "WHERE id_vendor = ?";

        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_vendor);
            ps.setString(2, alamat);
            ps.setString(3, nama_cp);
            ps.setString(4, no_tlp);
            ps.setString(5, email);
            ps.setString(6, id_vendor);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data berhasil Diubah");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }
    }

    public ResultSet tampilComBoxVendor() {
        query = "SELECT nama_vendor FROM vendor";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }

    public ResultSet KonversiVendor() {
        query = "SELECT id_vendor FROM vendor WHERE nama_vendor = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_vendor);

            rs = ps.executeQuery();
            System.out.println("data masuk");
        } catch (SQLException sQLException) {
            System.out.println("data tak masuk");
        }
        return rs;
    }

    public String autoID() {
        String newID = "VDBR0001"; // Default jika tidak ada data
        query = "SELECT id_vendor AS ID FROM vendor ORDER BY id_vendor DESC LIMIT 1";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                String lastID = rs.getString("ID");
                if (lastID != null && lastID.startsWith("VDBR")) {
                    int num = Integer.parseInt(lastID.substring(4)); // Ambil angka dari ID terakhir
                    num++; // Increment angka
                    newID = String.format("VDBR%04d", num); // Format ke KTBR000X
                }
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil: " + sQLException.getMessage());
        }
        return newID;
    }

    String getID(String vendorName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ResultSet cariVendor(String keyword) {
        query = "SELECT * FROM vendor WHERE "
                + "id_vendor LIKE ? OR "
                + "nama_vendor LIKE ? OR "
                + "alamat LIKE ? OR "
                + "nama_cp LIKE ? OR "
                + "no_tlp LIKE ? OR "
                + "email LIKE ?";
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
