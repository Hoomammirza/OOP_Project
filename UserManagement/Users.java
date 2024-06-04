package UserManagement;

import Misc.Timer;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Users {
    public static User LoginUser = null;
    public static boolean ExistUsername(String username)
    {
        return false;
    }
    private static Misc.Timer FailLoginTimer = new Misc.Timer(0);
    private static int NumberOfTries = 0;
    public static User signin (String Username,String Password) throws NoUserException, PasswordExeption, TimerException {
        if (FailLoginTimer.running()){
            throw new TimerException(( int)FailLoginTimer.getTimeRemaining() / 1000);
        }
        try {
            User user = SQLhandler.readUser(Username,Password);
            NumberOfTries = 0;
            return user;
        }catch (NoUserException | PasswordExeption e){
            NumberOfTries++;
            FailLoginTimer = new Timer(5000 * NumberOfTries);
            throw e;
        }
    }



//    public static boolean CorrectUserName(String s)
//    {
//        if(s.matches("[a-zA-Z0-9_\\S]+"))
//        {
//            return true;
//        }
//        return false;
//    }
//    public boolean correctPassword(String s)
//    {
//        String SpecialChars1="0123456789";
//        boolean correct1=false;
//        for(char character :SpecialChars1.toCharArray())
//        {
//            if(s.contains(String.valueOf(character)))
//            {
//                correct1=true;
//                break;
//            }
//        }
//        String SpecialChars2 = "";
//        for(int i=97;i<123;i++)
//        {
//            SpecialChars2+=(char)i;
//        }
//        boolean correct2=false;
//        for(char character :SpecialChars2.toCharArray())
//        {
//            if(s.contains(String.valueOf(character)))
//            {
//                correct2=true;
//                break;
//            }
//        }
//        String SpecialChars3 = "";
//        for(int i=65;i<91;i++)
//        {
//            SpecialChars3+=(char)i;
//        }
//        boolean correct3=false;
//        for(char character :SpecialChars3.toCharArray())
//        {
//            if(s.contains(String.valueOf(character)))
//            {
//                correct3=true;
//                break;
//            }
//        }
//
//        if(correct1 && correct2 && correct3 && (s.length()>=8))
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//    }
//    public boolean correctEmail(String email)
//    {
//        if(email.contains("@") && email.endsWith(".com"))
//            return true;
//        return false;
//    }
//    private void createUser(Matcher matcher, Scanner scanner)
//    {
//        String username=matcher.group("username");
//        String password=matcher.group("password");
//        String passwordConfirmation=matcher.group("passwordConfirmation");
//        String email=matcher.group("email");
//        String nickname=matcher.group("nickname");
//        if(CorrectUserName(username))
//        {
//            if( !Users.ExistUsername(username))
//            {
//                if(correctPassword(password) )
//                {
//                    if(correctEmail(email))
//                    {
//                        System.out.println("User created successfully. Please choose a security question : ");
//                        System.out.println("1-What is your father’s name ? ");
//                        System.out.println("2-What is your favourite color ?");
//                        System.out.println("3-What was the name of your first pet? ");
//                        String input=scanner.nextLine();
//                        if(input.matches("question pick -q (?<questionNumber>\\d+) -a (?<answer>.+?) -c (?<answerConfirm>(?:\\S+\\s)*\\S+)"))
//                        {
//                            Matcher matcher1=getCommandMatcher(input,"question pick -q (?<questionNumber>.+?) -a (?<answer>.+?) -c (?<answerConfirm>(?:\\S+\\s)*\\S+)");
//                            matcher1.find();
//                            if(Integer.parseInt(matcher1.group("questionNumber"))>0 &&Integer.parseInt(matcher1.group("questionNumber"))<4)
//                            {
//                                if(Objects.equals(matcher1.group("answer"), matcher1.group("answerConfirm")))
//                                {
//                                    this.QuestionAnswer=matcher1.group("answer");
//                                    String random=createRandomNumber();
//                                    for (int i=0;i<showRandomCaptcha(random).size();i++)
//                                    {
//                                        System.out.println(showRandomCaptcha(random).get(i));
//                                    }
//                                    input=scanner.nextLine();
//                                    if(Objects.equals(input, random))
//                                    {
//                                        System.out.println("correct");
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//    private void createUserWithNoPassword(Matcher matcher,Scanner scanner)
//    {
//        String username=matcher.group("username");
//        String email=matcher.group("email");
//        String nickname=matcher.group("nickname");
//        if(CorrectUserName(username))
//        {
//            if(!Users.ExistUsername(username))
//            {
//                this.username=username;
//                String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789*!@#$%^&*";
//                int length = 10;
//                Random random = new Random();
//                String randomString ="";
//                for (int i = 0; i < length; i++) {
//                    int index = random.nextInt(characters.length());
//                    randomString+=characters.charAt(index);
//                }
//                System.out.println("Your random password: "+randomString);
//                System.out.print("Please enter your password: ");
//                String input=scanner.nextLine();
//                if(Objects.equals(input, randomString))
//                {
//                    System.out.println("correctPassword");
//                }
//            }
//        }
//    }
}
