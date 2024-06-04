package UserManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
    public static User readUser(String username,String password) throws PasswordExeption,NoUserException{
        ResultSet rs;
        Statement statement;
        try {
            if (isConnected) {
                statement = con.createStatement();
                rs = statement.executeQuery("select * from user where Username = '"+username+"';");
                if (rs.next()){
                    System.out.println(rs.getString("Email"));
                }
            }

        } catch (Exception e){System.out.println(e);}
        return null;
    }
    public static boolean Userexists(String username){
        ResultSet rs;
        Statement statement;
        try {
            if (isConnected) {
                statement = con.createStatement();
                rs = statement.executeQuery("select * from user where Username = '" + username + "';");
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e){System.out.println(e);}
        return false;
    }
}
