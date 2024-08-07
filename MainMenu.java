import Game.Game;
import Misc.Misc;
import UserManagement.User;
import UserManagement.Users;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenu {
    public static User user;
    private static Scanner input = new Scanner(System.in);
    public static int run(){
        user=Users.LoginUser;
        String in;
        boolean quit = false;

        Matcher startGame;
        Matcher startGamewager;
        Matcher showCard;
        Matcher HistoryGame;
        Matcher ProfileMenu;
        Matcher exitAccount;
        Matcher shopMenu;
        Matcher showcurrentMenu;

        System.out.println("commands:\n" +
                "* start game normal\n"+
                "* start game wager\n"+
                "* show my cards:\n" +
                "* show history game\n" +
                "* show current menu\n" +
                "* shop menu\n"+
                "* profile menu\n"+
                "* exit account");

        while (!quit){
            in = input.nextLine();
            startGame = Misc.getMatcher(in,"start game normal");
            startGamewager = Misc.getMatcher(in,"start game wager");
            showCard = Misc.getMatcher(in,"show my cards:");
            HistoryGame = Misc.getMatcher(in, "show history game");
            ProfileMenu = Misc.getMatcher(in, "profile menu");
            showcurrentMenu=Misc.getMatcher(in,"show current menu");
            shopMenu=Misc.getMatcher(in,"shop menu");
            exitAccount=Misc.getMatcher(in,"exit account");

            if (startGame.find()){
                Game.wager = false;
                return 6;
            }if (startGamewager.find()){
                Game.wager = true;
                return 6;
            }else if (showCard.find()){
                printCard();
            }else if (exitAccount.find()) {
                return 1;
            }else if(showcurrentMenu.find()) {
                System.out.println("Main Menu");
            }else if(ProfileMenu.find()) {
                return 5;
            }else if (HistoryGame.find()){
                return 7;
            }else if (shopMenu.find()){
                return 9;
            }
        }
        return 0;
    }
    public static void printCard()
    {
        for (int i=0;i<Users.LoginUser.cards.size();i++)
        {
            int a=Users.LoginUser.cards.get(i).playerDamage*Users.LoginUser.cards.get(i).Duration;
            System.out.println("name:  "+Users.LoginUser.cards.get(i).name+"\n"
                    +"duration: "+Users.LoginUser.cards.get(i).Duration+"\n"+
                    "card attack/defences:  "+Users.LoginUser.cards.get(i).defence_attack+"\n"+
                    "player damage:  "+a+"\n"+
                    "level:  "+Users.LoginUser.cards.get(i).level);
        }
    }
}
