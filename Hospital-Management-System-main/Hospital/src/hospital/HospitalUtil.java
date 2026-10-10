package hospital;

import java.sql.Connection;  //Java program-um database-um connect aagura connection -entire process
import java.sql.DriverManager;  //db connection create panna help pannum

public class HospitalUtil {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hospitaldb1", 
                "root", 
                "Nsn@071808"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}

