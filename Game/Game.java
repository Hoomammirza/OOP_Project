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
    public static void initGuest() {
        boolean quit = false;
        Matcher login;
        Matcher showcurrrentmenu;

        System.out.println("commands:\n" +
                "*  user login -u <username> -p <password>\n"
                + "*  show current menu ");

        while (!quit) {
            String in = input.nextLine();
            login = Misc.getMatcher(in, "^user(\\s+)login(\\s+)-u(\\s+)(?<username>\\S+)(\\s+)-p(\\s+)(?<password>\\S+)(\\s*)$");
            showcurrrentmenu = Misc.getMatcher(in, "^show current menu(\\s*)$");
            if (login.find()) {
                if (login(login.group("username"), login.group("password")))
                    quit = true;
            } else if (showcurrrentmenu.find()) {
                System.out.println("Game menu: login");
            }
        }
        //=================================================================================================================
        System.out.println("Please select you character Player 1:\n" +
                "Gunner , Fighter , Dancer , Wizard ");
        quit = false;
        Matcher selectCharacter;

        System.out.println("commands:\n" +
                "*  select <character>\n"
                + "*  show current menu ");

        while (!quit) {
            String in = input.nextLine();
            selectCharacter = Misc.getMatcher(in, "^select(\\s+)(?<character>\\S+)(\\s*)$");
            showcurrrentmenu = Misc.getMatcher(in, "^show current menu(\\s*)$");
            if (selectCharacter.find()) {
                if (SelectCharacter(Host,selectCharacter))
                    quit = true;
            } else if (showcurrrentmenu.find()) {
                System.out.println("Game menu: Character Select");
            }
        }
        //=================================================================================================================
        System.out.println("Please select you character Player 2:\n" +
                "Gunner , Fighter , Dancer , Wizard ");
        quit = false;

        System.out.println("commands:\n" +
                "*  select <character>\n"
                + "*  show current menu ");

        while (!quit) {
            String in = input.nextLine();
            selectCharacter = Misc.getMatcher(in, "^select(\\s+)(?<character>\\S+)(\\s*)$");
            showcurrrentmenu = Misc.getMatcher(in, "^show current menu(\\s*)$");
            if (selectCharacter.find()) {
                if (SelectCharacter(Host,selectCharacter))
                    quit = true;
            } else if (showcurrrentmenu.find()) {
                System.out.println("Game menu: Character Select");
            }
        }

    }
    private static boolean login(String username,String password){
        try {
            User user = SQLhandler.readUser(username,password);
            Guest=user;
            return true;
        } catch (NoUserException e) {
            String s = e.toString();
            System.out.println("Username doesn't exist!");
        } catch (PasswordExeption e) {
            String s = e.toString();
            System.out.println("Password and Username don’t match!");
        }
        return false;
    }
    public static void timelineInputOutput(User Host,User Guest){
    }
    public static boolean SelectCharacter(User user,Matcher matcher){
        String character = matcher.group("character");
        switch (character){
            case "Gunner":
                user.character = User.Character.valueOf(character);
                break;
            case "Fighter":
                user.character = User.Character.valueOf(character);
                break;
            case "Dancer":
                user.character = User.Character.valueOf(character);
                break;
            case "Wizard":
                user.character = User.Character.valueOf(character);
                break;
            case "Default":
                System.out.println("invalid character name!");
                return false;
        }
        return true;
    }
}
