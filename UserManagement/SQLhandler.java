package UserManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLhandler {
    public static boolean isConnected = false;
    private static Connection con = null;
    public static void connect(){
        try {
            if (isConnected)
                throw new Exception("AlreadyConnected");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","honor1384");
            isConnected = true;
        } catch (Exception e){System.out.println(e);}
    }
    public static User readUser(String username,String password){
        return null;
    }
}
