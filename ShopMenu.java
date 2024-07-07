import Cards.Card;
import Misc.Misc;
import UserManagement.SQLhandler;
import UserManagement.User;
import UserManagement.Users;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;

public class ShopMenu {
    public static Scanner input = new Scanner(System.in);
    public static User user;
    public static ArrayList<Card> buycards;
    public static int run() {
        user = Users.LoginUser;
        String in;
        boolean quit = false;

        Matcher shownewcards;
        Matcher showallcards;
        Matcher editCard;
        Matcher removecard;
        Matcher showallplayers;
        Matcher back;
        Matcher showcurrrentmenu;
        Matcher exit;

        System.out.println("commands:\n" +
                "*  show upgradable cards\n" +
                "*  show new cards\n" +
                "*  remove card <number>\n" +
                "*  show all cards\n" +
                "*  show all players\n" +
                "*  exit");

        while (!quit) {
            in = input.nextLine();
            shownewcards = Misc.getMatcher(in, "^show new cards$");
            showallcards = Misc.getMatcher(in, "^show all cards$");
            editCard = Misc.getMatcher(in, "^edit(\\s+)card(\\s+)-nu(\\s+)(?<cardnumber>\\S+)(\\s+)-n(\\s+)(?<name>.+)(\\s+)-da(\\s+)(?<defenceattack>\\S+)(\\s+)-d(\\s+)(?<duration>\\S+)(\\s+)-pd(\\s+)(?<playerdamage>\\S+)(\\s+)-u(\\s+)(?<upgradelevel>\\S+)(\\s+)-uc(\\s+)(?<upgradecost>\\S+)(\\s*)$");
            removecard = Misc.getMatcher(in, "^remove(\\s+)card(\\s+)(?<cardnumber>\\d+)(\\s*)$");
            showallplayers = Misc.getMatcher(in, "^show all players$");
            back = Misc.getMatcher(in, "^back(\\s*)$");
            exit = Misc.getMatcher(in, "^exit(\\s*)$");
            showcurrrentmenu = Misc.getMatcher(in, "^show current menu(\\s*)$");

            if (shownewcards.find()) {
                shownewcards();
            } else if (showallcards.find()) {
                showallcards();
            } else if (editCard.find()) {
                editcard(editCard);
            } else if (removecard.find()) {
                removecard(removecard);
            } else if (showallplayers.find()) {
                showallusers();
            } else if (showcurrrentmenu.find()) {
                System.out.println("ProfileMenu");
            } else if (back.find()) {
                return 1;
            } else if (exit.find()) {
                return 0;
            }else {
                System.out.println("invalid command");
            }
        }
        return 0;
    }
    public static void refreshbuycard(){
        buycards = new ArrayList<>();
        for (Card card:SQLhandler.getallcards()){
            boolean temp = false;
            for (Card usercard: user.hand){
                if ( usercard.name.equals(card.name)){
                    temp = true;
                    break;
                }
            }
            if (!temp)
                buycards.add(card);
        }
    }
    public static boolean shownewcards(){
        refreshbuycard();
        for (int i = 0; i < buycards.size(); i++) {

        }
    }

}
