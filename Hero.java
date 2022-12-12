import java.util.*;
public class Hero{
    //set HP
    private int heroHP;
    private int maxHP = 100;
    //set sword damage
    private int swordDMG = 20;
    //sets bow damage
    private int bowDMG = 15;
    //set heals
    private int healthPotions = 3;
    //set key pieces and key for unlocking dungeon door
    private int keyPieces = 0;
    //boolean used to see if player has all pieces of key necessary
    private boolean reachedCheckpoint = false;
    //set starting amount of gold for player
    private int moneyGold = 30;

    Hero(){
        this.heroHP = 100;
    }

    public void playerStatReset() {
        this.setHeroHP(this.getMaxHP());
        this.sethealthPotions();
    }

    public int getBowDMG() {
		return bowDMG;
	}

	public int getHeroHP() {
		//to make sure hero hp is never below 0
        if(this.heroHP < 0) {
            this.heroHP = 0;
        }
        
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
        this.keyPieces += 1;
    }
    public int getKeyPieces(){
        return keyPieces;
    }
    //getters and setters for key logic for doors
    public boolean getReachedCheckpoint(){
        return reachedCheckpoint;
    }

    public void setReachedCheckpoint(boolean reachedCheckpoint){
        this.reachedCheckpoint = reachedCheckpoint;
    }

    public void addMoney(int gold) {
        this.moneyGold += gold;
    }
    
    public int getGold() {
        return this.moneyGold;
    }

}