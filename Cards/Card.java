package Cards;

public class Card {
    public int Duration;
    public String name;
    public String feature;
    public int defence_attack;
    public int playerDamage;
    public int upgradeLevel;
    public double upgradeCost;
    Card(String name,int defence_attack,int playerDamage,double upgradeCost,int upgradeLevel,String feature)
    {
        this.name=name;
        this.defence_attack=defence_attack;
        this.playerDamage=playerDamage;
        this.upgradeLevel=upgradeLevel;
        this.upgradeCost=upgradeCost;
        this.feature=feature;
    }
}
