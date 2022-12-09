import java.util.*;
public class Enemy {
    //set monster weapon
    Random randy = new Random();
    private int weaponBASE;
    private int weaponDMG = weaponBASE + randy.nextInt(5);
    //set monster HP
    private int monsterHP;
	String name;

    Enemy(int weaponBASE, int monsterHP){
        this.monsterHP = monsterHP;
        this.weaponBASE = weaponBASE;
    }

	Enemy(int weaponBASE, int monsterHP, String name){
        this.monsterHP = monsterHP;
        this.weaponBASE = weaponBASE;
		this.name = name;
    }

    public int getWeaponBASE() {
		return weaponBASE;
	}


	public void setWeaponBASE(int weaponBASE) {
		this.weaponBASE = weaponBASE;
	}

    public int getMonsterHP() {
		return monsterHP;
	}


	public void setMonsterHP(int monsterHP) {
		this.monsterHP = monsterHP;
	}

    public int getWeaponDMG() {
		return weaponDMG;
	}


	public void setWeaponDMG(int weaponDMG) {
		this.weaponDMG = weaponDMG;
	}

    
}
