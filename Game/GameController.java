package Game;

import Cards.Card;
import UserManagement.*;

import UserManagement.User;

import java.util.ArrayList;
import java.util.Random;

public class GameController {
    static public User host1;
    static public User quest1;
    static public int round;
    static boolean roundFinish;
    public boolean UsersReady = false;
    public void initusers() throws NoUserException,PasswordExeption{
        try {
            quest1 = signin();
        }
        catch (NoUserException | PasswordExeption e){
            throw e;
        }
        host1.timeline = new Card[10];
        quest1.timeline = new Card[10];
    }
    public User signin() throws NoUserException, PasswordExeption {
        return null;
    };
    public void nextphase(){
    }
    public static void run(User host,User Guest) {
        host1=host;
        quest1=Guest;
        host1.comeInHound=new ArrayList<ArrayList<String>>();
        quest1.comeInHound=new ArrayList<ArrayList<String>>();
        while (host1.hitpoint<=0 || quest1.hitpoint<=0)
        {
            host1.hand=get5CardHand(host1);
            quest1.hand=get5CardHand(quest1);
            while (round>0)
            {
                Game.timelineInputOutput(host1,quest1);
                Game.timelineInputOutput(quest1,host1);
                round--;
                getNewCardInHand(host1);
                getNewCardInHand(quest1);
            }
        }
    }
    public static ArrayList<Card> get5CardHand(User user)
    {
        ArrayList<Card> answer=new ArrayList<Card>();
        ArrayList<Card> cardThatNormal=SQLhandler.getUsercardsnormal(user);
        ArrayList<Card> special= SQLhandler.getUsercardsspecial(user);
        for (int i=0;i<cardThatNormal.size();i++)
        {
            user.comeInHound.add(new ArrayList<String>());
            user.comeInHound.getLast().add(cardThatNormal.get(i).name);
            user.comeInHound.getLast().add("0");
        }
        for (int i=0;i<special.size();i++)
        {
            user.comeInHound.add(new ArrayList<String>());
            user.comeInHound.getLast().add(special.get(i).name);
            user.comeInHound.getLast().add("1");
        }
        int n=0;
        Random random=new Random();
        int a=random.nextInt(user.comeInHound.size());
        while (n<5)
        {
            if(Integer.parseInt(user.comeInHound.get(a).getLast())==0)
            {
                answer.add(SQLhandler.getCard(user,user.comeInHound.get(a).getFirst()));
                Integer b=Integer.parseInt(user.comeInHound.get(a).getLast());
                b++;
                user.comeInHound.get(a).set(1,b.toString());
                n++;
            }
            else
            {
                Integer b=Integer.parseInt(user.comeInHound.get(a).getLast());
                b--;
                user.comeInHound.get(a).set(1,b.toString());
            }
            a=random.nextInt(user.comeInHound.size());
        }
        return answer;
    }
    public static void getNewCardInHand(User user)
    {
        Random random=new Random();
        int a=random.nextInt(user.comeInHound.size());
        boolean getNewCard=false;
        while (!getNewCard)
        {
            if(Integer.parseInt(user.comeInHound.get(a).getLast())==0)
            {
                user.hand.add(SQLhandler.getCard(user,user.comeInHound.get(a).getFirst()));
                Integer b=Integer.parseInt(user.comeInHound.get(a).getLast());
                b++;
                user.comeInHound.get(a).set(1,b.toString());
                getNewCard=true;
            }
            else
            {
                Integer b=Integer.parseInt(user.comeInHound.get(a).getLast());
                b--;
                user.comeInHound.get(a).set(1,b.toString());
            }
            a=random.nextInt(user.comeInHound.size());
        }
    }
}
