package UserManagement;


import Cards.Card;

import javax.swing.*;
import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Random;

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
    public ArrayList<Card> cards;
    public  User(String Username,String Password,String Nickname,String Email,String SecurityQ,String SecurityQA,boolean isAdmin){
        this.Username = Username;
        this.Password = Password;
        this.Nickname = Nickname;
        this.Email = Email;
        this.SecurityQ = securityQ.valueOf(SecurityQ);
        this.SecurityQA = SecurityQA;
        this.isAdmin = isAdmin;
    }
    public  User(String Username,String Password,String Nickname,String Email,String SecurityQ,String SecurityQA,boolean isAdmin,int Level,int Coins){
        this.Username = Username;
        this.Password = Password;
        this.Nickname = Nickname;
        this.Email = Email;
        this.SecurityQ = securityQ.valueOf(SecurityQ);
        this.SecurityQA = SecurityQA;
        this.isAdmin = isAdmin;
        this.Level = Level;
        this.Coins = Coins;
    }


    //Game=====================================================================================================

    public int hitpoint;
    public ArrayList<Card> hand;
    public int gamescore;
    public boolean visibleCard=true;
    public Card[] timeline = new Card[10];
    public enum securityQ{
        Father,
        Color,
        Pet;
    }
    public enum Character{
        Gunner,
        Fighter,
        Dancer,
        Wizard;
    }
}
