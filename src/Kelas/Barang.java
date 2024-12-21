package Kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Barang {

    int jumlah;
    String id_barang, id_vendor, id_kategori, nama_barang, merk, status, jenis;

    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public Barang() throws SQLException {
        Koneksi koneksi = new Koneksi();
        konek = koneksi.konekDB();
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getId_barang() {
        return id_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public String getId_vendor() {
        return id_vendor;
    }

    public void setId_vendor(String id_vendor) {
        this.id_vendor = id_vendor;
    }

    public String getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void tambahBarang() {
        query = "INSERT INTO barang VALUES(?,?,?,?,?,?,?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_barang);
            ps.setString(2, nama_barang);
            ps.setString(3, merk);
            ps.setString(4, id_vendor);
            ps.setString(5, id_kategori);
            ps.setString(6, status);
            ps.setString(7, jenis);
            ps.setInt(8, jumlah);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal  Ditambahkan");
        }
    }

    public ResultSet tampilBarang() {
        query = "SELECT "
                + "b.id_barang AS ID, "
                + "b.nama_barang AS Nama, "
                + "b.merk AS Merk, "
                + "v.nama_vendor AS Vendor, "
                + "k.nama_kategori AS Kategori, "
                + "b.status AS Status, "
                + "b.jenis AS Jenis, "
                + "b.jumlah AS Jumlah "
                + "FROM barang b "
                + "JOIN vendor v ON b.id_vendor = v.id_vendor "
                + "JOIN kategori k ON b.id_kategori = k.id_kategori";
        try {
            System.out.println("Query: " + query);
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            System.out.println(sQLException);

        }
        return rs;
    }

    public void hapusBarang() {
        query = "DELETE FROM barang WHERE id_barang = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_barang);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
        }
    }


    public void ubahBarang() {

        query = "UPDATE barang "
                + "SET nama_barang = ?, "
                + "merk = ?, "
                + "id_vendor = ?, "
                + "id_kategori = ?, "
                + "status = ?, "
                + "jenis = ?, "
                + "jumlah = ? "
                + "WHERE id_barang = ?";

        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_barang);
            ps.setString(2, merk);
            ps.setString(3, id_vendor);
            ps.setString(4, id_kategori);
            ps.setString(5, status);
            ps.setString(6, jenis);
            ps.setInt(7, jumlah);
            ps.setString(8, id_barang);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data berhasil Diubah");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }

    }


    public String getVendorID(String vendorName) {
        String vendorID = "";
        query = "SELECT id_vendor FROM vendor WHERE nama_vendor = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, vendorName);
            rs = ps.executeQuery();
            if (rs.next()) {
                vendorID = rs.getString("id_vendor");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendorID;
    }

    public String getKategoriID(String kategoriName) {
        String kategoriID = "";
        query = "SELECT id_kategori FROM kategori WHERE nama_kategori = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, kategoriName);
            rs = ps.executeQuery();
            if (rs.next()) {
                kategoriID = rs.getString("id_kategori");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kategoriID;
    }

    public String generateAutoID() {
        String autoID = "";
        query = "SELECT MAX(id_barang) AS maxID FROM barang";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                String maxID = rs.getString("maxID");
                if (maxID == null) {
                    autoID = "001"; // ID pertama
                } else {
                    int id = Integer.parseInt(maxID.substring(maxID.length() - 3)) + 1;
                    autoID = String.format("%03d", id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autoID;
    }

    

    
    public String generateFullID(String vendorName, String kategoriName) {
        String vendorID = getVendorID(vendorName);
        String kategoriID = getKategoriID(kategoriName);
        String autoID = generateAutoID(); // Generate ID baru untuk penambahan barang
        return vendorID + kategoriID + autoID;
    }


    public ResultSet tampilComBoxBarang() {
    query = "SELECT nama_barang FROM barang WHERE jenis = 'Boleh Dipinjam'";
    try {
        st = konek.createStatement();
        rs = st.executeQuery(query);
    } catch (SQLException sQLException) {
        JOptionPane.showMessageDialog(null, "Data Gagal Tampil: " + sQLException.getMessage());
    }
    return rs;
}

    
     public ResultSet KonversiBarang() {
        query = "SELECT id_barang FROM barang WHERE nama_barang = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, nama_barang);

            rs = ps.executeQuery();
            System.out.println("data masuk");
        } catch (SQLException sQLException) {
            System.out.println("data tak masuk");
        }
        return rs;
    }
     
    public int getStokBarang(String namaBarang) throws SQLException {
    query = "SELECT jumlah FROM barang WHERE nama_barang = ?";
    int stok = 0;

    try {
        ps = konek.prepareStatement(query);
        ps.setString(1, namaBarang);
        rs = ps.executeQuery();

        if (rs.next()) {
            stok = rs.getInt("jumlah");
        }
    } finally {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
    }
    return stok;
}
    
    

    public ResultSet cariBarang(String keyword) {
    query = "SELECT b.id_barang, b.nama_barang, b.merk, b.status, b.jenis, b.jumlah, " +
            "v.nama_vendor, k.nama_kategori " +
            "FROM barang b " +
            "JOIN vendor v ON b.id_vendor = v.id_vendor " +
            "JOIN kategori k ON b.id_kategori = k.id_kategori " +
            "WHERE b.id_barang LIKE ? OR " +
            "b.nama_barang LIKE ? OR " +
            "b.merk LIKE ? OR " +
            "b.status LIKE ? OR " +
            "b.jenis LIKE ? OR " +
            "v.nama_vendor LIKE ? OR " +
            "k.nama_kategori LIKE ?";

    try {
        ps = konek.prepareStatement(query);

        // Mengisi parameter pencarian dengan keyword untuk semua kolom
        for (int i = 1; i <= 7; i++) {
            ps.setString(i, "%" + keyword + "%");
        }

        rs = ps.executeQuery();
    } catch (SQLException sQLException) {
        JOptionPane.showMessageDialog(null, "Data Gagal Dicari: " + sQLException.getMessage());
    }
    return rs;
}









}
