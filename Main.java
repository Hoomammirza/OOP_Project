import UserManagement.PasswordExeption;
import UserManagement.SQLhandler;

public class Main {
    public static void main(String[] args) {
        SQLhandler.connect();
        try {
            SQLhandler.readUser("Hello", "H");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}