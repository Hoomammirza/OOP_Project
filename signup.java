import UserManagement.User;
import UserManagement.Users;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup {
    public static Matcher getCommandMatcher(String input, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }
    public static ArrayList<ArrayList<String>> ascii_art=new ArrayList<ArrayList<String>>();
    public static void madeAsciiArt()
    {
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
    public static ArrayList<String> showRandomCaptcha(String random)
    {
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
    private String username;
    private String password;
    private String email;
    private String nickname;
    public void setUsername(String username)
    {
        this.username=username;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public void setNickname(String nickname)
    {
        this.nickname=nickname;
    }
    public String getUsername()
    {
        return this.username;
    }
    public String getPassword()
    {
        return this.password;
    }
    public String getEmail()
    {
        return this.email;
    }
    public String getNickname()
    {
        return this.nickname;
    }
    public static boolean CorrectUserName(String s)
    {
        if(s.matches("[a-zA-Z0-9_\\S]+"))
        {
            return true;
        }
        return false;
    }
    public boolean correctPassword(String s)
    {
        String SpecialChars1="0123456789";
        boolean correct1=false;
        for(char character :SpecialChars1.toCharArray())
        {
            if(s.contains(String.valueOf(character)))
            {
                correct1=true;
                break;
            }
        }
        String SpecialChars2 = "";
        for(int i=97;i<123;i++)
        {
            SpecialChars2+=(char)i;
        }
        boolean correct2=false;
        for(char character :SpecialChars2.toCharArray())
        {
            if(s.contains(String.valueOf(character)))
            {
                correct2=true;
                break;
            }
        }
        String SpecialChars3 = "";
        for(int i=65;i<91;i++)
        {
            SpecialChars3+=(char)i;
        }
        boolean correct3=false;
        for(char character :SpecialChars3.toCharArray())
        {
            if(s.contains(String.valueOf(character)))
            {
                correct3=true;
                break;
            }
        }

        if(correct1 && correct2 && correct3 && (s.length()>=8))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean correctEmail(String email)
    {
        if(email.contains("@") && email.endsWith(".com"))
            return true;
        return false;
    }
    private void createUser(Matcher matcher)
    {
        String username=matcher.group("username");
        String password=matcher.group("password");
        String passwordConfirmation=matcher.group("passwordConfirmation");
        String email=matcher.group("email");
        String nickname=matcher.group("nickname");
        if(CorrectUserName(username))
        {
            if(correctPassword(password) && !Users.ExistUsername(username))
            {
                this.username=username;
                this.password=password;
            }
        }
    }
    private void createUserWithNoPassword(Matcher matcher,Scanner scanner)
    {
        String username=matcher.group("username");
        String email=matcher.group("email");
        String nickname=matcher.group("nickname");
        if(CorrectUserName(username))
        {
            if(!Users.ExistUsername(username))
            {
                this.username=username;
                String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789*!@#$%^&*";
                int length = 10;
                Random random = new Random();
                String randomString ="";
                for (int i = 0; i < length; i++) {
                    int index = random.nextInt(characters.length());
                    randomString+=characters.charAt(index);
                }
                System.out.println("Your random password: "+randomString);
                System.out.print("Please enter your password: ");
                String input=scanner.nextLine();
                if(Objects.equals(input, randomString))
                {
                    System.out.println("correctPassword");
                }
            }
        }
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
            else if(input.matches("user create -u (?<username>.?+) -p (?<password>\\S+) (?<passwordConfirmation>.?+) –email (?<email>.?+) -n (?<nickname>(?:\\S+\\s)*\\S+)"))
            {
                Matcher matcher=getCommandMatcher(input,"user create -u (?<username>) -p (?<password>\\S+) (?<passwordConfirmation>.?+) –email (?<email>.?+) -n (?<nickname>(?:\\S+\\s)*\\S+)");
                matcher.find();

            }
            input=scanner.nextLine();
        }
    }
}