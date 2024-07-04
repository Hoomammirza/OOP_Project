package UserManagement;


import Cards.Card;

import java.util.ArrayList;

public class User {
    public String Username;
    public String Password;
    public String Nickname;
    public String Email;
    public String SecurityQA;
    public securityQ SecurityQ;
    public int Level = 1;
    public int maxHP = 100;
    public int Coins = 100;
    public boolean isAdmin = false;
    ArrayList<Card> cards;
    public  User(String Username,String Password,String Nickname,String Email,String SecurityQ,String SecurityQA){
        this.Username = Username;
        this.Password = Password;
        this.Nickname = Nickname;
        this.Email = Email;
        this.SecurityQ = securityQ.valueOf(SecurityQ);
        this.SecurityQA = SecurityQA;
    }


    //Game=====================================================================================================

    public int hitpoint;
    public ArrayList<Card> hand;
    public int gamescore;
    public Card[] timeline = new Card[10];
    public enum securityQ{
        Father,
        Color,
        Pet;
    }
}
