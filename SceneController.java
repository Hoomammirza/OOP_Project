import Misc.Misc;

import java.util.Scanner;
import java.util.regex.Matcher;

public class SceneController {
    public static void run(){
        int n = 1;
        boolean quit = false;
        while (!quit){
            switch (n){
                case 0:
                    return;
                case 1:
                    n = MenuSelect.run();
                    break;
                case 2:
                    n = signin.run();
                    break;
                case 3:
                    n = signup.run();
                    break;
            }
        }
    }
}
