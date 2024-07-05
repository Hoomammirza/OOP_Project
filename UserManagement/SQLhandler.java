package UserManagement;

import Cards.Card;
import Game.AddCardException;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

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
                        return new User(rs.getString("Username"),rs.getString("Password"),rs.getString("Nickname"),rs.getString("Email"),rs.getString("SecurityQ"),rs.getString("SecurityQA"),rs.getBoolean("isAdmin"),rs.getInt("Level"),rs.getInt("Coins"));
                    }else throw new PasswordExeption();
                } else throw new NoUserException();
            }

        } catch (SQLException e){System.out.println(e);}
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
    public static void changeUsername( User user ,String Username){
        Statement statement;
        String username = user.Username;
        try {
            if (isConnected) {
                statement = con.createStatement();
                statement.executeUpdate("update user set Username = '"+Username+"' WHERE Username = '"+username+"';");

            }
        } catch (Exception e){System.out.println(e);}
    }
    public static void changeEmail( User user ,String Email){
        Statement statement;
        String username = user.Username;
        try {
            if (isConnected) {
                statement = con.createStatement();
                statement.executeUpdate("update user set Email = '"+Email+"' WHERE Username = '"+username+"';");

            }
        } catch (Exception e){System.out.println(e);}
    }
    public static void changeNickname( User user ,String Nickname){
        Statement statement;
        String username = user.Username;
        try {
            if (isConnected) {
                statement = con.createStatement();
                statement.executeUpdate("update user set Nickname = '"+Nickname+"' WHERE Username = '"+username+"';");

            }
        } catch (Exception e){System.out.println(e);}
    }
    public static void giveCard (Card card, User user, int level) {
        Statement statement;
        try {
            if (isConnected) {
                statement = con.createStatement();
                statement.execute("insert into usercard (Username,Name,level) values ('" + user.Username + "','" + card.name + "'," + level + ");");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static boolean existsCard(String name){
        ResultSet rs;
        Statement statement;
        try {
            if (isConnected) {
                statement = con.createStatement();
                rs = statement.executeQuery("select * from cards where Name = '" + name + "';");
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e){System.out.println(e);}
        return false;
    }
    public static Card getCard(String name){
        ResultSet rs;
        Statement statement;
        try {
            if (isConnected) {
                statement = con.createStatement();
                rs = statement.executeQuery("select * from cards where Name = '" + name + "';");
                if (rs.next()) {
                    return new Card(rs.getString("Name"),rs.getInt("Defence/Attack"),rs.getInt("Duration"),rs.getInt("Damage"),rs.getInt("Upcost"),rs.getInt("Minlevel"), rs.getString("feature"),rs.getString("Type"),1);
                } else {
                    return null;
                }
            }
        } catch (Exception e){System.out.println(e);}
        return null;
    }
    public static Card getCard(User user, String name){
        ResultSet rs;
        Statement statement;
        try {
            if (isConnected) {
                statement = con.createStatement();
                rs = statement.executeQuery("select * from cards where Name = '" + name + "';");
                if (rs.next()) {
                    return new Card(rs.getString("Name"),rs.getInt("Defence/Attack"),rs.getInt("Duration"),rs.getInt("Damage"),rs.getInt("Upcost"),rs.getInt("Minlevel"), rs.getString("feature"),rs.getString("Type"),getCardlevel(user, name));
                } else {
                    return null;
                }
            }
        } catch (Exception e){System.out.println(e);}
        return null;
    }
    public static boolean hasCard(User user,  String name){
        ResultSet rs;
        Statement statement;
        try {
            if (isConnected) {
                statement = con.createStatement();
                rs = statement.executeQuery("select * from usercard where Name = '" + name + "' and Username = '"+user.Username+"';");
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e){System.out.println(e);}
        return false;
    }
    public static int getCardlevel(User user,  String name){
        ResultSet rs;
        Statement statement;
        try {
            if (isConnected) {
                statement = con.createStatement();
                rs = statement.executeQuery("select * from usercard where Name = '" + name + "' and Username = '"+user.Username+"';");
                if (rs.next()) {
                    return rs.getInt("level");
                }
            }
        } catch (Exception e){System.out.println(e);}
        return 0;
    }
    public static ArrayList<Card> getallcards(){
        ResultSet rs;
        Statement statement;
        ArrayList<Card> cards = new ArrayList<>();
        try {
            if (isConnected) {
                statement = con.createStatement();
                rs = statement.executeQuery("select * from cards ;");
                while (rs.next()) {
                    cards.add(new Card(rs.getString("Name"),rs.getInt("Defence/Attack"),rs.getInt("Duration"),rs.getInt("Damage"),rs.getInt("Upcost"),rs.getInt("Minlevel"), rs.getString("feature"),rs.getString("Type"),1));
                }
            }
        } catch (Exception e){System.out.println(e);}
        return cards;
    }
    public static ArrayList<Card> getUsercards(User user){
        ResultSet rs;
        Statement statement;
        ArrayList<Card> cards = new ArrayList<>();
        try {
            if (isConnected) {
                statement = con.createStatement();
                rs = statement.executeQuery("select * from cards where Username = '"+user.Username+"';");
                while (rs.next()) {
                    cards.add(getCard(user,rs.getString(rs.getString("Name"))));
                }
            }
        } catch (Exception e){System.out.println(e);}
        return cards;
    }
    public static int updateCard(User user,  String name, int level){
        Statement statement;
        try {
            if (isConnected) {
                statement = con.createStatement();
                statement.executeUpdate("update usercard set level = "+ (level)+" where Name = '" + name + "' and Username = '"+user.Username+"';");
            }
        } catch (Exception e){System.out.println(e);}
        return 0;
    }


}
