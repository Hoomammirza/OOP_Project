package Game;

import UserManagement.NoUserException;
import UserManagement.PasswordExeption;
import UserManagement.User;

public class GameController {
    public User host;
    public User quest;
    public boolean UsersReady = false;
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
