import java.util.*;
public class Boss {
	private int DMG;
    private int bossHP;
	String name;

    Boss(String name, int DMG, int bossHP){
        this.DMG = DMG;
		this.bossHP = bossHP;
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
