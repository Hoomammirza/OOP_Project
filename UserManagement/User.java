package UserManagement;

import com.mysql.cj.protocol.a.NativeConstants;

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
}
enum securityQ{
    Father,
    Color,
    Pet;
}