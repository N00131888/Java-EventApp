package EventAppNB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//test comment for commit
public class DBConnection {
    //another test comment
    private static Connection sConnection;

    // implement the DBConnection as a Singleton
    public static Connection getInstance() throws ClassNotFoundException, SQLException {
        String host, db, user, password;
        
        host = "daneel";
        db = "n00131888";
        user = "N00131888";
        password = "N00131888";

        if (sConnection == null || sConnection.isClosed()) {
            String url = "jdbc:mysql://" + host + "/" + db;
            Class.forName("com.mysql.jdbc.Driver");
            sConnection = DriverManager.getConnection(url, user, password);
        }

        return sConnection;
    }
}