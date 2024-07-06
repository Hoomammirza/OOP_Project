import UserManagement.PasswordExeption;
import UserManagement.SQLhandler;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SQLhandler.connect();
//        SQLhandler.setnewHistory("Host","Guest",true,1,1,1,1,1,1);
        SceneController.run();
    }
}