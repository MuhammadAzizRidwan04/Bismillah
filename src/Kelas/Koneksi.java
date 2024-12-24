package Kelas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author M. Aziz Ridwan
 */
public class Koneksi {
//////
    private Connection konekSQL;
    private String host = "37.27.90.134";
    private String db = "w_16sup";
    private String user = "w_16pus";
    private String password = ")bzA4idQj(NPjE4f";
    private String port = "3306";
    private String url = "jdbc:mysql://" + host + ":" + port + "/" + db;

    public Connection konekDB() throws SQLException {

        try {
            konekSQL = DriverManager.getConnection(url, user, password);
            System.out.println("");
        } catch (SQLException sQLException) {
            System.out.println("Koneksi gagal");
        }

        return konekSQL;

    }

}
