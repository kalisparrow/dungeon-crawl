import java.util.*;
public class Hero{
    //set bow parameters. use bow base for upgrading bow from shop.
    Random randy = new Random();
    private int bowBase = 25;
    private int bowDMG = bowBase - randy.nextInt(15);
    //set HP
    private int heroHP;
    private int maxHP = 100;
    //set sword damage
    private int swordDMG = 15;
    //set heals
    private int healthPotions = 3;
    //set key pieces and key for unlocking dungeon door
    private int keyPieces = 0;
    //boolean used to see if player has all pieces of key necessary
    private boolean hasKey = false;
    //set starting amount of gold for player
    private int moneyGold = 30;

    Hero(){
        this.heroHP = 100;
    }

    public void playerStatReset() {
        this.setHeroHP(this.getMaxHP());
        this.sethealthPotions();
    }

    public int getBowBase() {
		return bowBase;
	}


	public void setBowBase(int bowBase) {
		this.bowBase = bowBase;
	}


	public int getBowDMG() {
		return bowDMG;
	}

	public int getHeroHP() {
		return heroHP;
	}

    public void setHeroHP(int heroHP) {
		this.heroHP = heroHP;
	}

    public int getMaxHP()
    {
        return this.maxHP;
    }

    public int gethealthPotions() {
		return healthPotions;
	}

    public void sethealthPotions() {
		this.healthPotions = 3;
	}

    // method to heal player, capping health at 100 and incrementing potions held negatively
    public void useHealing() {
        this.setHeroHP(this.getHeroHP() + 20); 
        
        if(this.getHeroHP() > this.getMaxHP())
        {
            this.setHeroHP(100);
        }
        
        healthPotions--;

        System.out.println("Your player health is now " + this.getHeroHP() + ".");

        System.out.println("You have " + healthPotions + " left!");
        
    }


	public int getSwordDMG() {
		return swordDMG;
	}


	public void setSwordDMG(int swordDMG) {
		this.swordDMG = swordDMG;
	}

    //Key methods to interact with
    public void addKeyPiece(){
        if(keyPieces == 2){
            hasKey = true;
            System.out.println("You have made a Key from the Key peices!");
        }
        else if(keyPieces < 2){
            keyPieces++;
        }
    }
    public int getKeyPieces(){
        return keyPieces;
    }
    public void useKey(){
        if(hasKey){
            keyPieces = 0;
            hasKey = false;
        }
    }
    public boolean hasBigKey(){
        return hasKey;
    }
    //add and spend money
    public void addMoney(int coinGained){
        moneyGold = moneyGold + coinGained;
    }
    public void spendMoney(int itemCost){
        moneyGold = moneyGold - itemCost;
    }

}