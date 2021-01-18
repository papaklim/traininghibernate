import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    final static String DB_URL = "jdbc:h2:file:./testdb";
    final static String DB_DRIVER = "org.h2.Driver";
    static Connection connection;

    public static void connect() {
        try {
            //Check JDBC Driver
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Connected to DB");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found: " + ex);
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Shit happens " + ex);
            ex.printStackTrace();
        }
    }

    public static void close() throws SQLException {
        connection.close();
        System.out.println("Disconnected from DB");
    }

    public static void main(String[] args) throws SQLException {

        connect();
        close();

    }
}