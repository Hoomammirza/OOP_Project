import Misc.Misc;
import UserManagement.*;

import java.util.Scanner;
import java.util.regex.Matcher;

public class signin {
    static Scanner input = new Scanner(System.in);
    public static void run(){
        String in;
        boolean quit = false;

        Matcher login;
        Matcher ForgotPassword;

        while (!quit){
            in = input.nextLine();
            login = Misc.getMatcher(in,"^user(\\s+)login(\\s+)-u(\\s+)(?<username>\\S+)(\\s+)-p(\\s+)(?<password>\\S+)(\\s*)$");
            ForgotPassword = Misc.getMatcher(in,"^forgot(\\s+)my(\\s+)password(\\s+)-u(\\s+)(?<username>\\S+)$");

            if (login.find()){
                login(login);
            } else if (ForgotPassword.find()){
            }
        }
    }
    private static void login(Matcher matcher){
        try {
            Users.signin(matcher.group("username"), matcher.group("password"));
        } catch (NoUserException e) {
            System.out.println("Username doesn’t exist!");
        } catch (PasswordExeption e) {
            System.out.println("Password and Username don’t match!");
        } catch (TimerException e){
            System.out.println("Try again in "+e.time+" seconds");
        }
    }
    private static void forgotusername(Matcher matcher){
        String username = matcher.group("username");
        if (Users.ExistUsername(username)){
            switch (Users.getSQ(username)){
                case Father:
                    System.out.println("What is your father’s name ?");
                    break;
                case Pet:
                    System.out.println("What is your favourite color ?");
                    break;
                case Color:
                    System.out.println("What was the name of your first pet?");
            }
            String Answer = input.nextLine();
            if (Users.verifySQA(username,Answer)){
                System.out.println("enter you new password!");
                String password = input.nextLine();
                boolean passwordverify = false;
                while (!passwordverify){
                    try {
                        signup.VerifyPassword(password);
                        passwordverify = true;
                    }catch (WeakPasswordException e){
                        System.out.println(e.message);
                        System.out.println("enter you new password!");
                        password = input.nextLine();
                    }
                }

            }else {

            }
        }else {
            System.out.println("this username doesn't exist!");
        }
    }
}
