package Game;

import Cards.Card;
import UserManagement.NoUserException;
import UserManagement.PasswordExeption;
import UserManagement.User;

import UserManagement.User;

public class GameController {
    public User host;
    public User quest;
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
}
