import java.util.*;
public class Boss {
    //bosses will have two attacks
    //
    Random randy = new Random();
    private int BASE;
    private int DMG = BASE - randy.nextInt(5);
    //set monster HP
    private int monsterHP;

    Boss(int BASE, int monsterHP){
        this.monsterHP = monsterHP;
        this.BASE = BASE;
    }

    public int getBASE() {
		return BASE;
	}


	public void setBASE(int BASE) {
		this.BASE = BASE;
	}

    public int getMonsterHP() {
		return monsterHP;
	}


	public void setMonsterHP(int monsterHP) {
		this.monsterHP = monsterHP;
	}

    public int getDMG() {
		return DMG;
	}


	public void setDMG(int DMG) {
		this.DMG = DMG;
	}

    
}
