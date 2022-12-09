import java.util.*;
public class Boss {
    //sets original damage output for boss
	private int DMG;
	//sets boss health points
    private int bossHP;
	String name;

    Boss(String name, int bossHP, int DMG){
        this.bossHP = bossHP;
        this.DMG = DMG;
    }

    public int getDMG() {
		return DMG;
	}
	
	public void setDMG(int DMG) {
		this.DMG = DMG;
	}

    public int getBossHP() {
		return bossHP;
	}
	
	public void setBossHP(int bossHP) {
		this.bossHP = bossHP;
	}
}
