import Misc.Misc;
import UserManagement.NoUserException;
import UserManagement.PasswordExeption;
import UserManagement.TimerException;
import UserManagement.Users;
import java.util.Scanner;
import java.util.regex.Matcher;

public class signin {
    public static void run(){
        String in;
        boolean quit = false;
        Scanner input = new Scanner(System.in);
        Matcher login;

        while (!quit){
            in = input.nextLine();
            login = Misc.getMatcher(in,"^user(\\s+)login(\\s+)-u(\\s+)(?<username>\\S+)(\\s+)-p(\\s+)(?<password>\\S+)(\\s*)$");

            if (login.find()){
                try {
                    Users.signin(login.group("username"), login.group("password"));
                } catch (NoUserException e) {
                    System.out.println("Username doesn’t exist!");
                } catch (PasswordExeption e) {
                    System.out.println("Password and Username don’t match!");
                } catch (TimerException e){
                    System.out.println("Try again in "+e.time+" seconds");
                }
            }
        }
    }
}
