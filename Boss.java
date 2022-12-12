import java.util.*;
public class Boss extends Enemy{
	private int DMG;
    private int bossHP;
	String name;

    Boss(String name, int DMG, int bossHP){
        super(name, DMG ,bossHP);
		this.name = name;
		this.DMG = DMG;
		this.bossHP = bossHP;
    }

	public String getBossName() {
		return this.name;
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
