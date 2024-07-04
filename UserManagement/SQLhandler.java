package UserManagement;

import javax.swing.plaf.nimbus.State;
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
                    if (rs.getString("Password").equals(password)){
                        return new User(rs.getString("Username"),rs.getString("Password"),rs.getString("Nickname"),rs.getString("Email"),rs.getString("SecurityQ"),rs.getString("SecurityQA"),rs.getBoolean("SecurityQA"));
                    }else throw new PasswordExeption();
                } else throw new NoUserException();
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
    public static String getSQ(String username){
        ResultSet rs;
        Statement statement;
        try {
            if (isConnected) {
                statement = con.createStatement();
                rs = statement.executeQuery("select * from user where Username = '" + username + "';");
                if (rs.next()) {
                    return rs.getString("SecurityQ");
                } else {
                    throw new RuntimeException();
                }
            }
        } catch (Exception e){System.out.println(e);}
        throw new RuntimeException();
    }
    public static boolean verifySQA(String username,String Answer){
        ResultSet rs;
        Statement statement;
        try {
            if (isConnected) {
                statement = con.createStatement();
                rs = statement.executeQuery("select * from user where Username = '" + username + "';");
                if (rs.next()) {
                    return rs.getString("SecurityQA").equals(Answer);
                } else {
                    throw new RuntimeException();
                }
            }
        } catch (Exception e){System.out.println(e);}
        throw new RuntimeException();
    }
    public static void changePassword( String username ,String password){
        ResultSet rs;
        Statement statement;
        try {
            if (isConnected) {
                statement = con.createStatement();
                statement.executeUpdate("update user set Password = '"+password+"' WHERE Username = '"+username+"';");

            }
        } catch (Exception e){System.out.println(e);}
    }
    public static void createuser(User user){
        Statement statement;
        try {
            statement = con.createStatement();
            statement.execute("insert into user (Username,Password,Nickname,Email,SecurityQ,SecurityQA,isAdmin) VALUES ('"+user.Username+"','"+user.Password+"','"+user.Nickname+"','"+user.Email+"','"+user.SecurityQ.toString()+"','"+user.SecurityQA+"','"+user.isAdmin+"');");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
