package Game;

import Cards.Card;
import UserManagement.User;

import java.util.ArrayList;

public  class TimelineController {
    public static GameController gameController;
    public static void doCard(User Host,User Guest,boolean roundFinish,int i)
    {
        if(roundFinish)
        {
            CardsController.feature(Host.timeline[i].feature,Host,Guest,i,gameController.round);
            reduceHitpoint(Host,Guest,i);
        }
        else
        {
            if(CardsController.doActionNow(Host.timeline[i].name))
            {
                CardsController.feature(Host.timeline[i].feature,Host,Guest,i,gameController.round);
            }
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
}
