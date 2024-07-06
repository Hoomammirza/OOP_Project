import UserManagement.PasswordExeption;
import UserManagement.SQLhandler;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SQLhandler.connect();
        SceneController.run();
    }
}