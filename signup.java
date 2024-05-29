import com.sun.imageio.plugins.bmp.BMPMetadata;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup {
    public static Matcher getCommandMatcher(String input, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
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
            if(correctPassword(password))
            {
                this.username=username;
                this.password=password;
            }
        }
    }
    public static void run()
    {
        Scanner scanner=new Scanner(System.in);
        String input= scanner.nextLine();
        boolean SignUp=false;
        while (!SignUp)
        {
            if(input.matches("user create -u (?<username>.?+) -p (?<password>\\S+) (?<passwordConfirmation>.?+) –email (?<email>.?+) -n(?<nickname>(?:\\S+\\s)*\\S+)"))
            {
                Matcher matcher=getCommandMatcher(input,"user create -u (?<username>) -p (?<password>\\S+) (?<passwordConfirmation>.?+) –email (?<email>.?+) -n(?<nickname>(?:\\S+\\s)*\\S+)");
                matcher.find();

            }
        }
    }
}