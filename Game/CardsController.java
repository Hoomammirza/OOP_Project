package Game;

import Cards.Card;
import UserManagement.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class CardsController {
    public void feature(String feature, User host, User guest, int i,int round)
    {
        if(Objects.equals(feature, "shield"))
        {
            guest.timeline[i].playerDamage=0;
        }
        else if(Objects.equals(feature,"healing"))
        {
            guest.hitpoint+=20;
        }
        else if(Objects.equals(feature,"changeHole"))
        {
            Random random=new Random();
            int a=random.nextInt(2);
            if(a==0)
            {
                Boolean empty=false;
                a=random.nextInt(10);
                for (int j=0;j<10 && !empty;j++)
                {
                    if(Objects.equals(host.timeline[j].name, "empty"))
                    {
                        host.timeline[j]=null;
                        empty=true;
                    }
                }
                empty=false;
                while (!empty)
                {
                    if(host.timeline[a]==null)
                    {
                        host.timeline[a]=new Card("empty",0,1,0,1,0,null);
                        empty=true;
                    }
                    a=random.nextInt(10);
                }
            }
            else if(a==1)
            {
                Boolean empty=false;
                a=random.nextInt(10);
                for (int j=0;j<10 && !empty;j++)
                {
                    if(Objects.equals(guest.timeline[j].name, "empty"))
                    {
                        guest.timeline[j]=null;
                        empty=true;
                    }
                }
                empty=false;
                while (!empty)
                {
                    if(guest.timeline[a]==null)
                    {
                        guest.timeline[a]=new Card("empty",0,1,0,1,0,null);
                        empty=true;
                    }
                    a=random.nextInt(10);
                }
            }
        }
        else if(Objects.equals(feature, "pairHole"))
        {
            Boolean empty=false;
            for (int j=0;j<10 && !empty;j++)
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

        }
        else if(Objects.equals(feature,"reducePowerOpponentCard"))
        {
            Random random=new Random();
            int a=random.nextInt(10);
            Boolean empty=true;
            while (empty)
            {
                if(guest.timeline[a]!=null)
                {
                    guest.timeline[a].playerDamage=(int) (guest.timeline[a].playerDamage*0.6);
                    empty=false;
                }
                else
                {
                    a=random.nextInt(10);
                }
            }
            empty=true;
            int b=random.nextInt(10);
            while (empty)
            {
                if(a!=b)
                {
                    if(guest.timeline[a]!=null)
                    {
                        guest.timeline[a].defence_attack=(int) (guest.timeline[a].defence_attack*0.6);
                        empty=false;
                    }
                    else
                    {
                        a=random.nextInt(10);
                    }
                }
                else
                {
                    b=random.nextInt(10);
                }
            }
        }
    }
}
