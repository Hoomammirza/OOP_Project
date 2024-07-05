package Game;

import Cards.Card;
import UserManagement.NoUserException;
import UserManagement.PasswordExeption;
import UserManagement.User;

import UserManagement.User;

public class GameController {
    static public User host;
    static public User quest;
    static public int round;
    static boolean roundFinish;
    public boolean UsersReady = false;
    public void initusers() throws NoUserException,PasswordExeption{
        try {
            quest = signin();
        }
        catch (NoUserException | PasswordExeption e){
            throw e;
        }
        host.timeline = new Card[10];
        quest.timeline = new Card[10];
    }
    public User signin() throws NoUserException, PasswordExeption {
        return null;
    };
    public void nextphase(){
    }
    public static void run(User host,User Guest)
    {
    }
    public static void setCardInGame(int n,int i)
    {
        if(i+host.hand.get(n).Duration>=21)
        {
            System.out.println("out of bounds!");
        }
        else
        {
            boolean empty=true;
            for(int j=i;j<i+host.hand.get(n).Duration && empty;j++)
            {
                if(host.timeline[j]!=null)
                {
                    empty=false;
                }
            }
            if(empty)
            {
                host.timeline[i]=host.hand.get(n);
                for(int j=i+1;j<i+host.hand.get(n).Duration && empty;j++)
                {
                    host.timeline[j]=new Card(host.timeline[i]);
                }
                TimelineController.doCard(host,quest,roundFinish,i);
            }
        }

    }
}
