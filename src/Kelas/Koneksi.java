package Kelas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author M. Aziz Ridwan
 */
public class Koneksi {

    private Connection konekSQL;
    private String host = "localhost";
    private String db = "inventarizm";
    private String user = "root";
    private String password = "orangsukses";
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
