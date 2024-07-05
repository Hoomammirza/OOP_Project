package Game;

import Cards.Card;
import UserManagement.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class CardsController {
    public static void feature(String feature, User host, User guest, int i,int round)
    {
        if(Objects.equals(feature, "shield"))
        {
            guest.timeline[i].playerDamage=0;
        }
        else if(Objects.equals(feature,"healing"))
        {
            guest.hitpoint+=20;
        }
        else if(Objects.equals(feature,"randomBuff"))
        {
            Random random=new Random();
            int a=random.nextInt(21);
            boolean empty=true;
            while (empty)
            {
                if(host.timeline[a]!=null)
                {
                    if(!Objects.equals(host.timeline[a].name, "empty"))
                    {
                        for(int j=0;j<host.timeline[a].Duration;j++)
                        {
                            host.timeline[a+j].defence_attack=(int) (host.timeline[a+j].defence_attack*1.2);
                            empty=false;
                        }
                    }
                }
                if(empty)
                {
                    a=random.nextInt(21);
                }
            }
        }
        else if(Objects.equals(feature,"changeHole"))
        {
            Random random=new Random();
            int a=random.nextInt(2);
            if(a==0)
            {
                Boolean empty=false;
                a=random.nextInt(21);
                for (int j=0;j<21 && !empty;j++)
                {
                    if(host.timeline[j]!=null)
                    {
                        if(Objects.equals(host.timeline[j].name, "empty") && host.timeline[j].cardReference==null)
                        {
                            host.timeline[j]=null;
                            empty=true;
                        }
                    }
                }
                empty=false;
                while (!empty)
                {
                    if(host.timeline[a]==null)
                    {
                        host.timeline[a]=new Card(null);
                        empty=true;
                    }
                    a=random.nextInt(21);
                }
            }
            else if(a==1)
            {
                Boolean empty=false;
                a=random.nextInt(21);
                for (int j=0;j<21 && !empty;j++)
                {
                    if(guest.timeline[j]!=null)
                    {
                        if(Objects.equals(guest.timeline[j].name, "empty") && host.timeline[j].cardReference==null)
                        {
                            guest.timeline[j]=null;
                            empty=true;
                        }
                    }
                }
                empty=false;
                while (!empty)
                {
                    if(guest.timeline[a]==null)
                    {
                        guest.timeline[a]=new Card(null);
                        empty=true;
                    }
                    a=random.nextInt(21);
                }
            }
        }
        else if(Objects.equals(feature, "pairHole"))
        {
            Boolean empty=false;
            for (int j=0;j<21 && !empty;j++)
            {
                if(Objects.equals(host.timeline[j].name, "empty"))
                {
                    host.timeline[j]=null;
                    empty=true;
                }
            }
        }
        else if(Objects.equals(feature,"reduceRound"))
        {
            round--;
        }
        else if(Objects.equals(feature,"removeCardFromHand"))
        {
            Random random=new Random();
            int a=random.nextInt(5);
            Card card=guest.hand.get(a);
            host.hand.add(card);
            guest.become4CardInHand=true;
            guest.become6CardInHandOneTime=true;

        }
        else if(Objects.equals(feature,"reducePowerOpponentCard"))
        {
            Random random=new Random();
            int a=random.nextInt(21);
            Boolean empty=true;
            while (empty)
            {
                if(guest.timeline[a]!=null)
                {
                    if(!Objects.equals(guest.timeline[a].name, "empty"))
                    {
                        for(int j=0;j<guest.timeline[a].Duration;j++)
                        {
                            guest.timeline[a+j].playerDamage=(int) (guest.timeline[a+j].playerDamage*0.6);
                            empty=false;
                        }
                    }
                }
                if(empty)
                {
                    a=random.nextInt(21);
                }
            }
            empty=true;
            int b=random.nextInt(21);
            while (empty)
            {
                if(a!=b)
                {
                    if(guest.timeline[b]!=null)
                    {
                        if(!Objects.equals(guest.timeline[b].name, "empty"))
                        {
                            for (int j=0;j<guest.timeline[b].Duration;j++)
                            {
                                guest.timeline[b+j].defence_attack=(int) (guest.timeline[b+j].defence_attack*0.6);
                                empty=false;
                            }
                        }
                    }
                }
                if(empty)
                {
                    b=random.nextInt(21);
                }
            }
        }
        else if(Objects.equals(feature, "hider"))
        {
            guest.visibleCard=false;
            ArrayList<ArrayList<Integer>> duration=new ArrayList<ArrayList<Integer>>();
            duration.add(new ArrayList<Integer>());
            duration.add(new ArrayList<Integer>());
            duration.add(new ArrayList<Integer>());
            duration.add(new ArrayList<Integer>());
            duration.add(new ArrayList<Integer>());
            for(int j=0;j<21;j++)
            {
                if(guest.timeline[j]!=null)
                {
                    if(!Objects.equals(guest.timeline[j].name, "null"))
                    {
                        duration.get(guest.timeline[j].Duration).add(j);
                    }
                }
            }
            Random random=new Random();
            int a=random.nextInt(5);
            boolean change=false;
            while (!change)
            {
                if(duration.get(a).size()>=2)
                {
                    int b=random.nextInt(duration.get(a).size());
                    int c=random.nextInt(duration.get(a).size());
                    while (b==c)
                    {
                        c=random.nextInt(duration.get(a).size());
                    }
                    Card card1=guest.timeline[duration.get(a).get(b)];
                    Card card2=guest.timeline[duration.get(a).get(c)];
                    for (int j=0;j<card1.Duration;j++)
                    {
                        guest.timeline[duration.get(a).get(b)+j]=null;
                    }
                    for (int j=0;j<card2.Duration;j++)
                    {
                        guest.timeline[duration.get(a).get(c)+j]=null;
                    }
                    guest.timeline[duration.get(a).get(c)]=card1;
                    for(int j=1;j<card1.Duration;j++)
                    {
                        guest.timeline[duration.get(a).get(c)+j]=new Card(card1);
                    }
                    guest.timeline[duration.get(a).get(b)]=card2;
                    for(int j=1;j<card1.Duration;j++)
                    {
                        guest.timeline[duration.get(a).get(b)+j]=new Card(card2);
                    }
                    change=true;
                }
                else
                {
                    a=random.nextInt(5);
                }
            }
        }
    }
    public void featureDuplicator(User host,String feature,int n)
    {
        if(Objects.equals(feature, "duplicator"))
        {
            host.become6CardInHand=true;
            host.hand.add(host.hand.get(n));
        }
    }
    public static boolean doActionNow(String name)
    {
        if(Objects.equals(name,"Mover") || Objects.equals(name,"Scaffholding") ||Objects.equals(name,"Blackhole")|| Objects.equals(name,"Time God")||Objects.equals(name,"Poison pouch")||Objects.equals(name,"Duplicator")||Objects.equals(name,"Smoke bomb")||Objects.equals(name,"Strength poison")||Objects.equals(name,"shield"))
        {
            return true;
        }
        return false;
    }
}
