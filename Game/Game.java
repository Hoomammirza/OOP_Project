package Game;

import Misc.Misc;

import java.util.Scanner;
import java.util.regex.Matcher;

public class Game {
    private static Scanner input = new Scanner(System.in);
    public static int run(){
        String in;
        boolean quit = false;

        Matcher showinformation;
        Matcher changenickname;
        Matcher changeusername;
        Matcher changeemail;
        Matcher changepassword;
        Matcher back;
        Matcher showcurrrentmenu;
        Matcher exit;

        System.out.println("commands:\n" +
                "*  show information\n" +
                "*  profile change -n <nickname>\n" +
                "*  profile change password -o <old-password> -n <new-password>\n" +
                "*  profile change -e <email>\n" +
                "*  profile change -n <nickname>\n" +
                "*  exit");

        while (!quit){
            in = input.nextLine();
            showinformation = Misc.getMatcher(in,"^Show(\\s+)information(\\s*)$");
            changenickname = Misc.getMatcher(in,"^profile(\\s+)change(\\s+)-n(\\s+)(?<nickname>\\S+)(\\s*)$");
            changeusername = Misc.getMatcher(in,"^profile(\\s+)change(\\s+)-u(\\s+)(?<username>\\S+)(\\s*)$");
            changeemail = Misc.getMatcher(in,"^profile(\\s+)change(\\s+)-e(\\s+)(?<email>\\S+)(\\s*)$");
            changepassword = Misc.getMatcher(in,"^profile(\\s+)change(\\s+)password(\\s+)-o(\\s+)(?<oldpassword>\\S+)(\\s+)-n(\\s+)(?<newpassword>\\S+)(\\s*)$");
            back = Misc.getMatcher(in, "^back(\\s*)$");
            exit = Misc.getMatcher(in, "^exit(\\s*)$");
            showcurrrentmenu = Misc.getMatcher(in, "^show current menu(\\s*)$");

            if (showinformation.find()){
                showinformation();
            } else if (changenickname.find()){
                changeNickname(changenickname);
            } else if (changeusername.find()){
                changeUsername(changeusername);
            } else if (changeemail.find()){
                changeEmail(changeemail);
            } else if (changepassword.find()){
                changePassword(changepassword);
            }else if (showcurrrentmenu.find()) {
                System.out.println("ProfileMenu");
            }else if (back.find()) {
                return 4;
            }else if (exit.find()) {
                return 0;
            }
        }
        return 0;
    }

}
