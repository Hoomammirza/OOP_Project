import Misc.Misc;
import UserManagement.User;
import UserManagement.Users;
import UserManagement.WeakPasswordException;

import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.util.ArrayList;
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
        Matcher signup;
        Matcher back;

        while (!quit)
        {
            input=scanner.nextLine();
            exit = Misc.getMatcher(input, "^exit(\\s*)$");
            back = Misc.getMatcher(input, "^back(\\s*)$");
            showcurrrentmenu = Misc.getMatcher(input, "^show current menu(\\s*)$");
            signup = Misc.getMatcher(input, "^user(\\s+)create(\\s+)-u(\\s+)(?<username>\\S*)(\\s+)-p(\\s+)(?<password>\\S*)(\\s+)(?<passwordconfirmation>\\S*)(\\s+)–email(\\s+)(?<email>\\S*)(\\s+)-n(\\s+)(?<nickname>\\S*)(\\s*)?");

            if (exit.find()){
                return 0;
            }else if (showcurrrentmenu.find()){
                System.out.println("Registermenu");
            }else if (signup.find()){
                signup(signup);
            }else if (back.find()){
                return 1;
            }
        }
        return 0;
    }
    public static void signup(Matcher matcher){
        String username=matcher.group("username");
        String password=matcher.group("password");
        String passwordconfirmation=matcher.group("passwordconfirmation");
        String email=matcher.group("email");
        String nickname=matcher.group("nickname");
        String securityQA;
        String securityQAc;
        User.securityQ securityQ;
        if (!username.isEmpty()&&!password.isEmpty()&&!passwordconfirmation.isEmpty()&&!email.isBlank()&&!nickname.isEmpty()){
            if (verifyUsername(username)) {
                if (!Users.ExistUsername(username)) {
                    try {
                        verifyPassword(password);
                        if (password.equals(passwordconfirmation)){
                            if (verifyEmail(email)){
                                System.out.println("User created successfully. Please choose a security question :\n" +
                                        "• 1-What is your father’s name ?\n" +
                                        "• 2-What is your favourite color ?\n" +
                                        "• 3-What was the name of your first pet?\n" +
                                        "answer using this format:" +
                                        "question pick -q <question-number> -a <answer> -c <answer- confirm>\n");
                                String input = new Scanner(System.in).nextLine();
                                Matcher matcher1 = Misc.getMatcher(input,"^question(\\s+)pick(\\s+)-q(\\s+)(?<questionnumber>\\S+)(\\s+)-a(\\s+)(?<answer>\\S+)(\\s+)-c(\\s+)(?<answerconfirm>\\S+)$");
                                if (matcher1.find()){
                                    matcher1.group("questionnumber");
                                }

                            }else {
                                System.out.println("invalid email!");
                            }
                        }else {
                            System.out.println("password doesn't match password confirmation!");
                        }
                    } catch (WeakPasswordException e) {
                        System.out.println(e);
                    }
                } else {
                    System.out.println("a user with this username already exists!");
                }
            }else {
                System.out.println("invalid username: username should contain only letters numbers and underscore!");
            }
        }else {
            System.out.println("please fill all fields!");
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

    public static boolean verifyPassword(String input) throws WeakPasswordException {
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
    public static boolean verifyUsername(String usename){
        Matcher verify = Misc.getMatcher(usename,"^([a-zA-z_0-9]+)$");
        return verify.matches();
    }
    public static boolean verifyEmail(String email){
        Matcher verify = Misc.getMatcher(email,"^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        return verify.matches();
    }
}