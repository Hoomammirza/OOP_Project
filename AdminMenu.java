import Misc.Misc;
import UserManagement.SQLhandler;

import java.util.Scanner;
import java.util.regex.Matcher;

public class AdminMenu {
    public static Scanner input = new Scanner(System.in);
    public static int run() {
        String in;
        boolean quit = false;

        Matcher addCard;
        Matcher changenickname;
        Matcher changeusername;
        Matcher changeemail;
        Matcher changepassword;
        Matcher back;
        Matcher showcurrrentmenu;
        Matcher exit;

        System.out.println("commands:\n" +
                "*  add card -n <name> -da <defence/attack> -d <duration> -pd <playerdamage> -u <upgrade level> -uc <upgradecost>\n" +
                "*  profile change -n <nickname>\n" +
                "*  profile change password -o <old-password> -n <new-password>\n" +
                "*  profile change -e <email>\n" +
                "*  profile change -n <nickname>\n" +
                "*  exit");

        while (!quit) {
            in = input.nextLine();
            addCard = Misc.getMatcher(in, "^add(\\s+)card(\\s+)-n(\\s+)(?<name>\\S+)(\\s+)-da(\\s+)(?<defenceattack>\\S+)(\\s+)-d(\\s+)(?<duration>\\S+)(\\s+)-pd(\\s+)(?<playerdamage>\\S+)(\\s+)-u(\\s+)(?<upgradelevel>\\S+)(\\s+)-uc(\\s+)(?<upgradecost>\\S+)(\\s*)$");
            changenickname = Misc.getMatcher(in, "^profile(\\s+)change(\\s+)-n(\\s+)(?<nickname>\\S+)(\\s*)$");
            changeusername = Misc.getMatcher(in, "^profile(\\s+)change(\\s+)-u(\\s+)(?<username>\\S+)(\\s*)$");
            changeemail = Misc.getMatcher(in, "^profile(\\s+)change(\\s+)-e(\\s+)(?<email>\\S+)(\\s*)$");
            changepassword = Misc.getMatcher(in, "^profile(\\s+)change(\\s+)password(\\s+)-o(\\s+)(?<oldpassword>\\S+)(\\s+)-n(\\s+)(?<newpassword>\\S+)(\\s*)$");
            back = Misc.getMatcher(in, "^back(\\s*)$");
            exit = Misc.getMatcher(in, "^exit(\\s*)$");
            showcurrrentmenu = Misc.getMatcher(in, "^show current menu(\\s*)$");

            if (addCard.find()) {
                showinformation();
            } else if (changenickname.find()) {
                changeNickname(changenickname);
            } else if (changeusername.find()) {
                changeUsername(changeusername);
            } else if (changeemail.find()) {
                changeEmail(changeemail);
            } else if (changepassword.find()) {
                changePassword(changepassword);
            } else if (showcurrrentmenu.find()) {
                System.out.println("ProfileMenu");
            } else if (back.find()) {
                return 4;
            } else if (exit.find()) {
                return 0;
            }

        }
    }
    public static void addCard(Matcher matcher){
        String name = matcher.group("name" );
        String defenceattack = matcher.group("defenceattack" );
        String duration = matcher.group("duration" );
        String playerdamage = matcher.group("playerdamage" );
        String upgradelevel = matcher.group("upgradelevel" );
        String upgradecost = matcher.group("upgradecost" );
        int defenceattackn;
        int durationn;
        int playerdamagen;
        int upgradeleveln;
        int upgradecostn;
        try {
            defenceattackn = Integer.parseInt(defenceattack);
            durationn = Integer.parseInt(duration);
            playerdamagen = Integer.parseInt(playerdamage);
            upgradeleveln = Integer.parseInt(upgradelevel);
            upgradecostn = Integer.parseInt(upgradecost);
        }catch (Exception e){
            System.out.println("some fields have invalid input");
            return;
        }
        if (!SQLhandler.existsCard(name)){
            if (defenceattackn >= 10 && defenceattackn <=100){
                if (1 <= durationn && 5>= durationn){
                    if (playerdamagen <= 50 && playerdamagen >= 10){
                        if (upgradeleveln>=1){
                            SQLhandler.addCard(name,defenceattackn,durationn,playerdamagen,upgradeleveln,upgradecostn);
                        }else {
                            System.out.println("invalid upgrade level");
                        }
                    }else {
                        System.out.println("invalid player damage");
                    }
                }else {
                    System.out.println("invalid duration");
                }
            }else {
                System.out.println("invalid defence attack");
            }
        }else {
            System.out.println("this card already exists!");
        }
    }
}
