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
        Matcher showCard;
        Matcher HistoryGame;
        Matcher ProfileMenu;
        Matcher exitAccount;
        Matcher showMenu;
        Matcher shopMenu;

        System.out.println("commands:\n" +
                "* start game\n"+
                "* show my cards:\n" +
                "* show history game\n" +
                "* show current menu\n" +
                "* shop menu\n"+
                "* profile menu\n"+
                "* exit account");

        while (!quit){
            in = input.nextLine();
            startGame = Misc.getMatcher(in,"start game");
            showCard = Misc.getMatcher(in,"show my cards:");
            HistoryGame = Misc.getMatcher(in, "show history game");
            ProfileMenu = Misc.getMatcher(in, "profile menu");
            showMenu=Misc.getMatcher(in,"show current menu");
            showMenu=Misc.getMatcher(in,"shop menu");
            exitAccount=Misc.getMatcher(in,"exit account");
            if (startGame.find()){
                return
            }
            else if (showCard.find()){
                printCard();
            }
            else if (exitAccount.find()) {
                return 1;
            }
            else if(showMenu.find())
            {
                System.out.println("Main Menu");
            }
            else if(ProfileMenu.find())
            {
                return 5;
            }
        }
        return 0;
    }
    public static void printCard()
    {
        for (int i=0;i<Users.LoginUser.cards.size();i++)
        {
            System.out.println("name:  "+Users.LoginUser.cards.get(i).name+"\n"
                    +"duration: "+Users.LoginUser.cards.get(i).Duration+"\n"+
                    "card attack/defences:  "+Users.LoginUser.cards.get(i).defence_attack+"\n"+
                    "player damage:  "+Users.LoginUser.cards.get(i).playerDamage+"\n"+
                    "level:  "+Users.LoginUser.cards.get(i).level);
        }
    }
}
