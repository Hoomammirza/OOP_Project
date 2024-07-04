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

        System.out.println("commands:\n" +
                "* start game\n"+
                "* show my cards:\n" +
                "* show history game\n" +
                "* show current menu\n" +
                "* go to shop menu\n"+
                "* go to profile menu"+
                "* exit account");

        while (!quit){
            in = input.nextLine();
            startGame = Misc.getMatcher(in,"start game");
            showCard = Misc.getMatcher(in,"show my cards:");
            HistoryGame = Misc.getMatcher(in, "show history game");
            ProfileMenu = Misc.getMatcher(in, "go to profile menu");
            showMenu=Misc.getMatcher(in,"show current menu");
            showMenu=Misc.getMatcher(in,"go to shop menu");
            exitAccount=Misc.getMatcher(in,"exit account");
            if (startGame.find()){
                printCard();
            }
            else if (showCard.find()){

            }
            else if (exitAccount.find()) {
                return 1;
            }
            else if(showMenu.find())
            {
                System.out.println("Main Menu");
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
