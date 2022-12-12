import java.util.*;
public class Enemy {
    private int weaponDMG;
    private int enemyHP;
	String name;

	Enemy(String name, int weaponDMG, int monsterHP){
        this.name = name;
		this.enemyHP = monsterHP;
        this.weaponDMG = weaponDMG;
    }

	public String getEnemyName() {
		return this.name;
	}

	public int getEnemyHP() {
		//to make sure enemy hp is never below 0
		if(this.enemyHP < 0) {
			this.enemyHP = 0;
		}
		
		return enemyHP;
	}


	public void setEnemyHP(int monsterHP) {
		this.enemyHP = monsterHP;
	}

    public int getWeaponDMG() {
		return weaponDMG;
	}


	public void setWeaponDMG(int weaponDMG) {
		this.weaponDMG = weaponDMG;
	}

}
