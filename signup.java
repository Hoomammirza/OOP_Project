import UserManagement.Users;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup {
    signup(){
        madeAsciiArt();
    }
    public static ArrayList<ArrayList<String>> ascii_art=new ArrayList<ArrayList<String>>();
    public static void madeAsciiArt() {
        ascii_art.add(new ArrayList<String>());
        ascii_art.get(0).add(" .d8888b. ");
        ascii_art.get(0).add("d88P  Y88b");
        ascii_art.get(0).add("888    888");
        ascii_art.get(0).add("888    888");
        ascii_art.get(0).add("888    888");
        ascii_art.get(0).add("888    888");
        ascii_art.get(0).add("Y88b  d88P");
        ascii_art.get(0).add("  Y8888P  ");
        ascii_art.add(new ArrayList<String>());
        ascii_art.get(1).add(" d888  ");
        ascii_art.get(1).add("d8888  ");
        ascii_art.get(1).add("  888  ");
        ascii_art.get(1).add("  888  ");
        ascii_art.get(1).add("  888  ");
        ascii_art.get(1).add("  888  ");
        ascii_art.get(1).add("  888  ");
        ascii_art.get(1).add("8888888");
        ascii_art.add(new ArrayList<String>());
        ascii_art.get(2).add(" .d8888b. ");
        ascii_art.get(2).add("d88P  Y88b");
        ascii_art.get(2).add("       888");
        ascii_art.get(2).add("     .d88P");
        ascii_art.get(2).add(" .od888P\" ");
        ascii_art.get(2).add("d88P\"     ");
        ascii_art.get(2).add("888\"      ");
        ascii_art.get(2).add("888888888 ");
        ascii_art.add(new ArrayList<String>());
        ascii_art.get(3).add(" .d8888b. ");
        ascii_art.get(3).add("d88P  Y88b");
        ascii_art.get(3).add("     .d88P");
        ascii_art.get(3).add("    8888\" ");
        ascii_art.get(3).add("     \"Y8b.");
        ascii_art.get(3).add("888    888");
        ascii_art.get(3).add("Y88b  d88P");
        ascii_art.get(3).add(" \"Y8888P\" ");
        ascii_art.add(new ArrayList<String>());
        ascii_art.get(4).add("    d8888 ");
        ascii_art.get(4).add("   d8P888 ");
        ascii_art.get(4).add("  d8P 888 ");
        ascii_art.get(4).add(" d8P  888 ");
        ascii_art.get(4).add("d88   888 ");
        ascii_art.get(4).add("8888888888");
        ascii_art.get(4).add("      888 ");
        ascii_art.get(4).add("      888 ");
        ascii_art.add(new ArrayList<String>());
        ascii_art.get(5).add("888888888 ");
        ascii_art.get(5).add("888       ");
        ascii_art.get(5).add("888       ");
        ascii_art.get(5).add("8888888b. ");
        ascii_art.get(5).add("     \"Y88b");
        ascii_art.get(5).add("       888");
        ascii_art.get(5).add("Y88b  d88P");
        ascii_art.get(5).add(" \"Y8888P\" ");
        ascii_art.add(new ArrayList<String>());
        ascii_art.get(6).add(" .d8888b. ");
        ascii_art.get(6).add("d88P  Y88b");
        ascii_art.get(6).add("888       ");
        ascii_art.get(6).add("888d888b. ");
        ascii_art.get(6).add("888P \"Y88b");
        ascii_art.get(6).add("888    888");
        ascii_art.get(6).add("Y88b  d88P");
        ascii_art.get(6).add(" \"Y8888P\" ");
        ascii_art.add(new ArrayList<String>());
        ascii_art.get(7).add("8888888888");
        ascii_art.get(7).add("      d88P");
        ascii_art.get(7).add("     d88P ");
        ascii_art.get(7).add("    d88P  ");
        ascii_art.get(7).add(" 88888888 ");
        ascii_art.get(7).add("  d88P    ");
        ascii_art.get(7).add(" d88P     ");
        ascii_art.get(7).add("d88P      ");
        ascii_art.add(new ArrayList<String>());
        ascii_art.get(8).add(" .d8888b. ");
        ascii_art.get(8).add("d88P  Y88b");
        ascii_art.get(8).add("Y88b. d88P");
        ascii_art.get(8).add(" \"Y88888\" ");
        ascii_art.get(8).add(".d8P\"\"Y8b.");
        ascii_art.get(8).add("888    888");
        ascii_art.get(8).add("Y88b  d88P");
        ascii_art.get(8).add(" \"Y8888P\" ");
        ascii_art.add(new ArrayList<String>());
        ascii_art.get(9).add(" .d8888b. ");
        ascii_art.get(9).add("d88P  Y88b");
        ascii_art.get(9).add("888    888");
        ascii_art.get(9).add("Y88b. d888");
        ascii_art.get(9).add(" \"Y888P888");
        ascii_art.get(9).add("       888");
        ascii_art.get(9).add("Y88b  d88P");
        ascii_art.get(9).add(" \"Y8888P\" ");
    }
    public String createRandomNumber()
    {
        String answer="";
        Random random=new Random();
        for(int i=0;i<4;i++)
        {
            answer+=random.nextInt(10);
        }
        return answer;
    }
    public static ArrayList<String> showRandomCaptcha(String random)
    {
        madeAsciiArt();
        ArrayList<String>answer=new ArrayList<String>();
        for(int i=0;i<8;i++)
        {
            String a="";
            for(int j=0;j<random.length();j++)
            {
                String b= String.valueOf(random.charAt(j));
                a+=ascii_art.get(Integer.parseInt(b)).get(i);
                a+="  ";
            }
            answer.add(a);
        }
        return answer;
    }
    public  void run()
    {
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine();
        boolean SignUp=false;
        while (!SignUp)
        {
            if(input.matches("user create -u (?<username>.+?) -p random –email (?<email>.+?) -n (?<nickname>(?:\\S+\\s)*\\S+)"))
            {
                Matcher matcher=getCommandMatcher(input,"user create -u (?<username>.+?) -p random –email (?<email>.+?) -n (?<nickname>(?:\\S+\\s)*\\S+)");
                matcher.find();
                createUserWithNoPassword(matcher,scanner);
            }
            else if(input.matches("user create -u (?<username>.+?) -p (?<password>\\S+) (?<passwordConfirmation>.+?) –email (?<email>.+?) -n (?<nickname>(?:\\S+\\s)*\\S+)"))
            {
                Matcher matcher=getCommandMatcher(input,"user create -u (?<username>.+?) -p (?<password>\\S+) (?<passwordConfirmation>.+?) –email (?<email>.+?) -n (?<nickname>(?:\\S+\\s)*\\S+)");
                matcher.find();
                createUser(matcher,scanner);
            }
            input=scanner.nextLine();
        }
    }
}