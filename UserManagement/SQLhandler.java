package UserManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLhandler {
    public static boolean isConnected = false;
    public static void connect(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","honor1384");
        } catch (Exception e){System.out.println(e);}
    }
}
