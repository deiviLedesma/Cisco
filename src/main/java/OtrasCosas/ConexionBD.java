package OtrasCosas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/ciscoITSON";
    private static final String USER = "root";
    private static final String PASSWORD = "Inunanash1";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error de conexión");
        }
        return conn;
    }
}
