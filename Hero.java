import java.util.*;
public class Hero{
    //set bow parameters. use bow base for upgrading bow from shop.
    Random randy = new Random();
    private int bowBase = 25;
    private int bowDMG = bowBase - randy.nextInt(15);
    //set HP
    private int heroHP;
    private int fullHP = heroHP;
    //set damage
    private int swordDMG = 15;
    /*set block stance
    Blocking has not been integrated as there was 
    no proper way to do so that would be fun for
    the player. 
    private boolean blocking = false;
    */
    //set heals
    private int healing = 3;
    //set key perices and key for unlocking dungeon door
    private int keyPieces = 0;
    private boolean hasKey= false;
    //set starting amount of gold for player
    private int moneyGold = 30;

    Hero(int heroHP){
        this.heroHP = heroHP;
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

    //Bow damage is calcualted and does not need a setter. This should also prevent bugs.
	// public void setBowDMG(int bowDMG) {
	// 	this.bowDMG = bowDMG;
	// }


	public int getHeroHP() {
		return heroHP;
	}


	public void setHeroHP(int heroHP) {
		this.heroHP = heroHP;
	}


	public int getSwordDMG() {
		return swordDMG;
	}


	public void setSwordDMG(int swordDMG) {
		this.swordDMG = swordDMG;
	}

    /* 
	public boolean isBlocking() {
		return blocking;
	}


	public void setBlocking(boolean blocking) {
		this.blocking = blocking;
	}
   
    //methods to calculate damage taken to player
    public void damageRecieved(int dmgTaken){
        if(isBlocking()){
            setHeroHP((getHeroHP()-dmgTaken)+7);
        }
        else
            setHeroHP(getHeroHP()-dmgTaken);
    }
     */
    //methods for healing incombat
    public int getHealing(){
        return healing;
    }
    public void addHealing() {
        healing++;
    }

    public void useHealing() {
        heroHP = fullHP;
        healing--;
    }

    public int getMaxHP(){
        return fullHP;
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