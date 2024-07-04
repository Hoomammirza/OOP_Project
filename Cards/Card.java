package Cards;

public class Card {
    public int Duration;
    public String name;
    public String feature;
    public int defence_attack;
    public int playerDamage;
    public int upgradeLevel;
    public double upgradeCost;
    public int level=1;
    String character;
    public Card(String name, int defence_attack, int Duration, int playerDamage, double upgradeCost, int upgradeLevel, String feature,String character)
    {
        this.name=name;
        this.defence_attack=defence_attack;
        this.Duration=Duration;
        this.playerDamage=playerDamage/Duration;
        this.upgradeLevel=upgradeLevel;
        this.upgradeCost=upgradeCost;
        this.feature=feature;
        this.character=character;
    }
}
