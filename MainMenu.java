import Misc.Misc;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenu {
    private static Scanner input = new Scanner(System.in);
    public static int run(){
        String in;
        boolean quit = false;

        Matcher login;
        Matcher ForgotPassword;
        Matcher exit;
        Matcher showcurrrentmenu;

        System.out.println("commands:\n" +
                "*  user login -u <username> -p <password>\n" +
                "*  forgot my password -u <username>\n" +
                "*  show current menu\n" +
                "*  exit");

        while (!quit){
            in = input.nextLine();
            login = Misc.getMatcher(in,"^user(\\s+)login(\\s+)-u(\\s+)(?<username>\\S+)(\\s+)-p(\\s+)(?<password>\\S+)(\\s*)$");
            ForgotPassword = Misc.getMatcher(in,"^forgot(\\s+)my(\\s+)password(\\s+)-u(\\s+)(?<username>\\S+)$");
            exit = Misc.getMatcher(in, "^exit(\\s*)$");
            showcurrrentmenu = Misc.getMatcher(in, "^show current menu(\\s*)$");

            if (login.find()){
                if (login(login))
                    return 4;
            } else if (ForgotPassword.find()){
                forgotpassword(ForgotPassword);
            }else if (showcurrrentmenu.find()) {
                System.out.println("signin");
            }else if (exit.find()) {
                return 0;
            }
        }
        return 0;
    }


}
