import Misc.Misc;
import UserManagement.Users;
import UserManagement.WeakPasswordException;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;

public class signup {
    signup(){
        initAsciiArt();
    }
    public static ArrayList<ArrayList<String>> ascii_art=new ArrayList<>();
    public static void initAsciiArt() {
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
    public static String createRandomNumber(){
        String answer="";
        Random random=new Random();
        for(int i=0;i<6;i++)
        {
            answer+=random.nextInt(10);
        }
        return answer;
    }
    public static ArrayList<String> showRandomCaptcha(String random) {
        initAsciiArt();
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
    public static int run()
    {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean quit=false;

        Matcher exit;
        Matcher showcurrrentmenu;

        while (!quit)
        {
            input=scanner.nextLine();
            exit = Misc.getMatcher(input, "^exit(\\s*)$");
            showcurrrentmenu = Misc.getMatcher(input, "^show current menu(\\s*)$");

        }
    }
//    private static void createUser(Matcher matcher, Scanner scanner)
//    {
//        String username=matcher.group("username");
//        String password=matcher.group("password");
//        String passwordConfirmation=matcher.group("passwordConfirmation");
//        String email=matcher.group("email");
//        String nickname=matcher.group("nickname");
//        if(Users.CorrectUserName(username))
//        {
//            if(!Users.ExistUsername(username))
//            {
//                if(Users.correctPassword(password) )
//                {
//                    if(Users.correctEmail(email))
//                    {
//                        System.out.println("User created successfully. Please choose a security question : ");
//                        System.out.println("1-What is your father’s name ? ");
//                        System.out.println("2-What is your favourite color ?");
//                        System.out.println("3-What was the name of your first pet? ");
//                        String input=scanner.nextLine();
//                        if(input.matches("question pick -q (?<questionNumber>\\d+) -a (?<answer>.+?) -c (?<answerConfirm>(?:\\S+\\s)*\\S+)"))
//                        {
//                            Matcher matcher1=Misc.getMatcher(input,"question pick -q (?<questionNumber>.+?) -a (?<answer>.+?) -c (?<answerConfirm>(?:\\S+\\s)*\\S+)");
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
//    private static void createUserWithNoPassword(Matcher matcher, Scanner scanner)
//    {
//        String username=matcher.group("username");
//        String email=matcher.group("email");
//        String nickname=matcher.group("nickname");
//        if(Users.CorrectUserName(username))
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

    public static boolean VerifyPassword(String input) throws WeakPasswordException {
        Matcher numberCeck = Misc.getMatcher(input,"[0-9]+");
        Matcher lowerCheck = Misc.getMatcher(input,"[a-z]+");
        Matcher upperCheck = Misc.getMatcher(input,"[A-Z]+");
        Matcher specialCheck = Misc.getMatcher(input,"[\\*\\!\\@\\$\\%\\^\\&\\#]+");
        Matcher lengthCeck = Misc.getMatcher(input,"(?<=^)[0-9a-zA-Z\\*\\!\\@\\$\\%\\^\\&\\#]{8,20}(?=$)");
        if (numberCeck.find()){
            if (lowerCheck.find() && upperCheck.find()){
                if (specialCheck.find()){
                    if (lengthCeck.find()){
                        return true;
                    }else {
                        throw new WeakPasswordException("Weak Password: must contain at least 8 characters!");
                    }
                }else {
                    throw new WeakPasswordException("Weak Password: must contain at least one special character!");
                }
            }else {
                throw new WeakPasswordException("Weak Password: must contain at least one lower and upper case letter!");
            }
        }else {
            throw new WeakPasswordException("Weak Password: must contain at least one number!");
        }
    }
}