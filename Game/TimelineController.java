package Game;

import Cards.Card;
import UserManagement.User;

import java.util.ArrayList;

public  class TimelineController {
    public static void doCard(User Host,User Guest,String feauture)
    {
        if(CardsController.doActionNow(feauture))
        {
            CardsController.feature(feauture,Host,Guest,GameController.round);
        }
    }
    public static void doCard(User Host,User Guest,int i)
    {
        if(CardsController.doActionNow(Host.timeline[i].feature))
        {
           CardsController.featureShield(Host.timeline[i].feature,Guest,i);
        }
    }
    public static void doCard(User Host,User Guest,int n,String feature)
    {
        if(CardsController.doActionNow(feature))
        {
            CardsController.featureDuplicator(Host,feature,n);
        }
    }
    public static void reduceHitpoint(User Host,User Guest,int i)
    {
        if(Host.timeline[i].defence_attack>=Guest.timeline[i].defence_attack)
        {
            Guest.hitpoint-=Host.timeline[i].playerDamage;
        }
        else
        {
            Host.hitpoint-=Guest.timeline[i].playerDamage;
        }
    }
    public static void setCardInGameWithSpace(User host,User Guest,int n,int i)
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
                doCard(host,Guest,i);
            }
            else
            {
                System.out.println("this cell is full!");
            }
        }
    }
    public static void setCardInGameWithNoSpace(User host,User Guest,int n)
    {
        TimelineController.doCard(host,Guest,host.hand.get(n).feature);
    }
    public static void SetDuplicator(User host,User Guest,int n,int i)
    {
        doCard(host,Guest,i,host.hand.get(n).feature);
    }
}
