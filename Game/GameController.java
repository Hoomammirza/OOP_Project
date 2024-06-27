package Game;

import Cards.Card;
import UserManagement.NoUserException;
import UserManagement.PasswordExeption;
import UserManagement.User;

public class GameController {
    public User host;
    public User quest;
    public boolean UsersReady = false;
    public Card[] hosttimeline = new Card[10];
    public Card[] questtimeline = new Card[10];
    public void initusers() throws NoUserException,PasswordExeption{
        try {
            signin();
        }
        catch (NoUserException | PasswordExeption e){
            throw e;
        }
    }
    public void signin() throws NoUserException, PasswordExeption {

    };
    public void nextphase(){

    }
}
