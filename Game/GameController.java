package Game;

import Cards.Card;
import UserManagement.*;

import UserManagement.User;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameController {
    static public User host1;
    static public User quest1;
    static public int round;
    static boolean finish=false;
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
        round = 4;
        host1=host;
        quest1=Guest;
        host1.maxHP=User.getMaxHp(host1.Level);
        quest1.maxHP=User.getMaxHp(quest1.Level);
        host1.hitpoint=host1.maxHP;
        quest1.hitpoint=quest1.maxHP;
        while (!finish)
        {
            host1.comeInHound=new ArrayList<ArrayList<String>>();
            quest1.comeInHound=new ArrayList<ArrayList<String>>();
            host1.hand=get5CardHand(host1);
            quest1.hand=get5CardHand(quest1);
            while (round>0)
            {
                Game.timelineInputOutput(host1,quest1);
                Game.timelineInputOutput(quest1,host1);
                round--;
                if(host1.hand.size()<6 || host1.become6CardInHand || host1.become6CardInHandOneTime)
                {
                    host1.become6CardInHandOneTime=false;
                    getNewCardInHand(host1);
                }
                if(quest1.hand.size()<6 || quest1.become6CardInHand || quest1.become6CardInHandOneTime)
                {
                    getNewCardInHand(quest1);
                    quest1.become6CardInHandOneTime=false;
                }
            }
            attackUser(host1,quest1);
            endRound(host1,quest1);
        }
        endGame(host1,quest1);
        SQLhandler.updateUser(host1);
        SQLhandler.updateUser(quest1);
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
        answer.get(2).buffInHand(user);
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
        if(user.hand.size()%2==1)
        {
            user.hand.get(2).buffInHand(user);
        }
    }
    public static void attackUser(User host,User guest)
    {
        for (int i=0;i<21 && !finish;i++)
        {
            int a=i+1;
            TimelineController.cardVsCard(host,guest,i);
            int c=host.maxHP-host.hitpoint;
            System.out.println("user host: "+host.Nickname+"  damage:  "+c+"  HitPoint host:  "+host.hitpoint);
            System.out.println("card host block["+a+"] name:  "+host.timeline[i].name+"  card damage:  "+host.timeline[i].playerDamage);
            c=guest.maxHP-guest.hitpoint;
            System.out.println("user guest: "+guest.Nickname+"  damage:  "+c+"  HitPoint guest:  "+guest.hitpoint);
            System.out.println("card guest block["+a+"] name:  "+guest.timeline[i].name+"  card damage:  "+guest.timeline[i].playerDamage);
            host.hitpoint -= guest.timeline[i].playerDamage;
            guest.hitpoint -= host.timeline[i].playerDamage;
            if(host.hitpoint<=0 || guest.hitpoint<=0)
            {
                finish=true;
            }
        }
    }
    public static void endRound(User host,User guest)
    {
        host.become4CardInHand=false;
        host.become6CardInHandOneTime=false;
        host.become6CardInHand=false;
        guest.become4CardInHand=false;
        guest.become6CardInHandOneTime=false;
        guest.become6CardInHand=false;
    }
    public static void endGame(User host,User guest)
    {
        if(host.hitpoint>0)
        {
            System.out.println("user "+host.Nickname+" win!!");
            System.out.println("user"+host.Nickname+" get 50 coin");
            host.Coins+=50;
            System.out.println("user"+host.Nickname+" experience increase 60 ");
            host.XP+=60;
            System.out.println("user "+guest.Nickname+" lose!!");
            System.out.println("user"+guest.Nickname+" experience increase 5 ");
            guest.XP+=5;
        }
        else if(guest.hitpoint>0)
        {
            System.out.println("user "+guest.Nickname+" win!!");
            System.out.println("user"+guest.Nickname+" get 50 coin");
            guest.Coins+=50;
            System.out.println("user"+guest.Nickname+" experience increase 60 ");
            guest.XP+=60;
            System.out.println("user "+host.Nickname+" lose!!");
            System.out.println("user"+host.Nickname+" experience increase 5 ");
            host.XP+=5;
        }
        int perviousXpHost=host.XP;
        int perviousXpGuest=guest.XP;
        int perviousLevelHost=host.Level;
        int perviousLevelGuest=guest.Level;
        host.Level=User.updateLevel(perviousLevelHost,perviousXpHost);
        guest.Level=User.updateLevel(perviousLevelGuest,perviousXpGuest);
        host.XP=User.updateXp(perviousLevelHost,perviousXpHost);
        guest.XP=User.updateXp(perviousLevelGuest,perviousXpGuest);
        finish=false;
    }
}
