package Game;

import Misc.Misc;
import UserManagement.*;

import java.util.Scanner;
import java.util.regex.Matcher;

public class Game {
    public static User Host,Guest;
    private static Scanner input = new Scanner(System.in);
    public static int run()  {
        String in;
        boolean quit = false;
        Host= Users.LoginUser;

        Matcher showinformation;
        Matcher changenickname;
        Matcher changeusername;
        Matcher changeemail;
        Matcher changepassword;
        Matcher back;
        Matcher showcurrrentmenu;
        Matcher exit;
        System.out.println("add user Guest\n");
        try {
            initGuest();
        }
        catch (Exception e)
        {

        }
//        while (!quit){
//            in = input.nextLine();
//            showinformation = Misc.getMatcher(in,"^Show(\\s+)information(\\s*)$");
//            changenickname = Misc.getMatcher(in,"^profile(\\s+)change(\\s+)-n(\\s+)(?<nickname>\\S+)(\\s*)$");
//            changeusername = Misc.getMatcher(in,"^profile(\\s+)change(\\s+)-u(\\s+)(?<username>\\S+)(\\s*)$");
//            changeemail = Misc.getMatcher(in,"^profile(\\s+)change(\\s+)-e(\\s+)(?<email>\\S+)(\\s*)$");
//            changepassword = Misc.getMatcher(in,"^profile(\\s+)change(\\s+)password(\\s+)-o(\\s+)(?<oldpassword>\\S+)(\\s+)-n(\\s+)(?<newpassword>\\S+)(\\s*)$");
//            back = Misc.getMatcher(in, "^back(\\s*)$");
//            exit = Misc.getMatcher(in, "^exit(\\s*)$");
//            showcurrrentmenu = Misc.getMatcher(in, "^show current menu(\\s*)$");
//
//            if (showinformation.find()){
//                showinformation();
//            } else if (changenickname.find()){
//                changeNickname(changenickname);
//            } else if (changeusername.find()){
//                changeUsername(changeusername);
//            } else if (changeemail.find()){
//                changeEmail(changeemail);
//            } else if (changepassword.find()){
//                changePassword(changepassword);
//            }else if (showcurrrentmenu.find()) {
//                System.out.println("ProfileMenu");
//            }else if (back.find()) {
//                return 4;
//            }else if (exit.find()) {
//                return 0;
//            }
//        }
        return 0;
    }
    public static void initGuest() throws NoUserException, PasswordExeption {
        boolean quit=false;
        Matcher login;
        Matcher showcurrrentmenu;

        System.out.println("commands:\n" +
                "*  user login -u <username> -p <password>\n"
        +       "*  show current menu ");

        while (!quit){
            String in = input.nextLine();
            login = Misc.getMatcher(in,"^user(\\s+)login(\\s+)-u(\\s+)(?<username>\\S+)(\\s+)-p(\\s+)(?<password>\\S+)(\\s*)$");
            showcurrrentmenu = Misc.getMatcher(in, "^show current menu(\\s*)$");
            if (login.find()){
                login(login.group("username"),login.group("password"));
            }
            else if(showcurrrentmenu.find())
            {
                System.out.println("Gamemenu: login");
            }
        }
    }
    private static void login(String username,String password) throws NoUserException, PasswordExeption{
        try {
            User user = SQLhandler.readUser(username,password);
            Guest=user;
        }
        catch (NoUserException | PasswordExeption e){
            throw e;
        }
    }
}
