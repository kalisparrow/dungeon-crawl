import java.util.*;
public class Boss {
    //bosses will have two attacks
    //
    Random randy = new Random();
    private int BASE;
    private int DMG = BASE - randy.nextInt(5);
    //set monster HP
    private int bossHP;

    Boss(int BASE, int bossHP){
        this.bossHP = bossHP;
        this.BASE = BASE;
    }

    public int getBASE() {
		return BASE;
	}


	public void setBASE(int BASE) {
		this.BASE = BASE;
	}

    public int getBossHP() {
		return bossHP;
	}


	public void setBossHP(int bossHP) {
		this.bossHP = bossHP;
	}

    public int getDMG() {
		return DMG;
	}


	public void setDMG(int DMG) {
		this.DMG = DMG;
	}

    
}
