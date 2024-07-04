package Game;

import Cards.Card;
import UserManagement.User;

public  class TimelineController {
    static User user;
    public static void AddCard( int i,int n)
    {
        Card card=user.hand.get(n);
        for (int j=0;j<card.Duration;j++)
        {
            user.timeline[i+j]=card;
        }
    }
    public static void init(User user1)
    {
        user=user1;
    }
}
