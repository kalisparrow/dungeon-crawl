import java.util.*;
public class Enemy {
    //sets original weapon damage output
    private int weaponDMG;
    //sets enemy HP
    private int monsterHP;
	String name;

    Enemy(int weaponDMG, int monsterHP){
        this.monsterHP = monsterHP;
        this.weaponDMG = weaponDMG;
    }

	Enemy(int weaponDMG, int monsterHP, String name){
        this.monsterHP = monsterHP;
        this.weaponDMG = weaponDMG;
		this.name = name;
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
