import java.util.*;

public class main {

    public Stack<Integer> checkPoint = new Stack<Integer>();
    public HashMap<Integer, String> doors = new HashMap<Integer, String>();
    public ArrayList<Integer> levelOneDoors = new ArrayList<Integer>();
    public ArrayList<Integer> levelTwoDoors = new ArrayList<Integer>();
    public ArrayList<Integer> levelThreeDoors = new ArrayList<Integer>();

    //create player charater object
    Hero player = new Hero(65);
    //random number genrator for random money drop
    Random randy = new Random();

    public void run() {

        checkPoint.push(1);
        checkPoint.push(2);
        checkPoint.push(3);
        checkPoint.push(4);

        rooms();
        levelOne();
        levelTwo();
        levelThree();

    }

    public void rooms() {

        doors.put(1, "Enemy One");
        doors.put(2, "Enemy Two");
        doors.put(3, "Boss");

        Random number = new Random();
        while (levelOneDoors.size() < 4) {
            int doorNum = number.nextInt(4) + 1;
            if (!levelOneDoors.contains(doorNum)) {
                levelOneDoors.add(doorNum);
            }
        }
        while (levelTwoDoors.size() < 4) {
            int doorNum = number.nextInt(4) + 1;
            if (!levelTwoDoors.contains(doorNum)) {
                levelTwoDoors.add(doorNum);
            }
        }
        while (levelThreeDoors.size() < 4) {
            int doorNum = number.nextInt(4) + 1;
            if (!levelThreeDoors.contains(doorNum)) {
                levelThreeDoors.add(doorNum);
            }
        }

    }

    public void levelOne() {

        for (Integer levelOneDoor : levelOneDoors) {
            System.out.print(doors.get(levelOneDoor) + "   ");
        }

        System.out.println("\n");

        System.out.println("Choose a door: ");
        Scanner keyboard = new Scanner(System.in);
        int doorChoice = keyboard.nextInt();

        if (Objects.equals(doors.get(doorChoice), "Enemy One")) {

            //setting and fight code for enemyOne
            //combat(monster damange, monster health, player cahracter)
            boolean win = combat(5, 30, player);
            if(win){
                //key pices and other things gold n stuff
                int coinage = 20 + randy.nextInt(10);
                System.out.println("You got a key peice and " + coinage + " gold coins!");
                player.addKeyPiece();
                player.addMoney(coinage);

            }
            if(!win){
                System.out.println("You died.");
                //set player paramerters back to normal (health)
                player.setHeroHP(player.getMaxHP());
            }
            
            //check peices to get big key
            if (player.hasBigKey()) {
                checkPoint.pop();
            }
            levelOne();
        }

        if (Objects.equals(doors.get(doorChoice), "Enemy Two")) {

            //setting and fight code for enemyTwo

            //setting and fight code for enemyOne
            //combat(monster damange, monster health, player cahracter)
            boolean win = combat(7, 35, player);
            if(win){
                //key pices and other things gold n stuff
                int coinage = 20 + randy.nextInt(10);
                System.out.println("You got a key peice and " + coinage + " gold coins!");
                player.addKeyPiece();
                player.addMoney(coinage);

            }
            if(!win){
                System.out.println("You died.");
                //set player paramerters back to normal (health)
                player.setHeroHP(player.getMaxHP());
            }
            
            //check peices to get big key
            if (player.hasBigKey()) {
                checkPoint.pop();
            }
            levelOne();
        }

        if (Objects.equals(doors.get(doorChoice), "Boss")) {

            if (player.hasBigKey()) {
                player.useKey();

                //setting and fight code for bossOne

                if (keyOne && bossOne.getHp() <= 0) {
                    bossOne.setKeyDrop(true);
                }

                if (!bossOne.isKeyDrop()) {
                    levelOne();
                } else {
                    //dialogue to move to next level
                }

            } else {
                System.out.println("You need a key to open this door.");
                levelOne();
            }

        }

    }

    public void levelTwo() {

        for (Integer levelTwoDoor : levelTwoDoors) {
            System.out.print(doors.get(levelTwoDoor) + "   ");
        }

        System.out.println("\n");

        System.out.println("Choose a door: ");
        Scanner keyboard = new Scanner(System.in);
        int doorChoice = keyboard.nextInt();

        if (Objects.equals(doors.get(doorChoice), "Enemy One")) {

            //setting and fight code for enemyOne
            boolean win = combat(10, 45, player);
            if(win){
                //key pices and other things gold n stuff
                int coinage = 20 + randy.nextInt(10);
                System.out.println("You got a key peice and " + coinage + " gold coins!");
                player.addKeyPiece();
                player.addMoney(coinage);

            }
            if(!win){
                System.out.println("You died.");
                //set player paramerters back to normal (health)
                player.setHeroHP(player.getMaxHP());
            }
            
            //check peices to get big key
            if (player.hasBigKey()) {
                checkPoint.pop();
            }
            levelTwo();
        }

        if (Objects.equals(doors.get(doorChoice), "Enemy Two")) {

            //setting and fight code for enemyOne
            boolean win = combat(12, 45, player);
            if(win){
                //key pices and other things gold n stuff
                int coinage = 20 + randy.nextInt(10);
                System.out.println("You got a key peice and " + coinage + " gold coins!");
                player.addKeyPiece();
                player.addMoney(coinage);

            }
            if(!win){
                System.out.println("You died.");
                //set player paramerters back to normal (health)
                player.setHeroHP(player.getMaxHP());
            }
            
            //check peices to get big key
            if (player.hasBigKey()) {
                checkPoint.pop();
            }
            levelTwo();
        }

        if (Objects.equals(doors.get(doorChoice), "Boss")) {

            if (inventory.contains("Key Two")) {

                //setting and fight code for bossTwo

                if (keyTwo && bossTwo.getHp() <= 0) {
                    bossTwo.setKeyDrop(true);
                }

                if (!bossTwo.isKeyDrop()) {
                    System.out.println("You died.");
                    levelTwo();
                } else {
                    //dialogue to move to next level
                }

            } else {
                System.out.println("You need a key to open this door.");
                levelTwo();
            }

        }

    }

    public void levelThree() {

        for (Integer levelThreeDoor : levelThreeDoors) {
            System.out.print(doors.get(levelThreeDoor) + "   ");
        }

        System.out.println("\n");

        System.out.println("Choose a door: ");
        Scanner keyboard = new Scanner(System.in);
        int doorChoice = keyboard.nextInt();

        if (Objects.equals(doors.get(doorChoice), "Enemy One")) {

            //setting and fight code for enemyOne
            boolean win = combat(15, 50, player);
            if(win){
                //key pices and other things gold n stuff
                int coinage = 20 + randy.nextInt(10);
                System.out.println("You got a key peice and " + coinage + " gold coins!");
                player.addKeyPiece();
                player.addMoney(coinage);

            }
            if(!win){
                System.out.println("You died.");
                //set player paramerters back to normal (health)
                player.setHeroHP(player.getMaxHP());
            }
            
            //check peices to get big key
            if (player.hasBigKey()) {
                checkPoint.pop();
            }
            levelThree();
        }

        if (Objects.equals(doors.get(doorChoice), "Enemy Two")) {

            //setting and fight code for enemyOne
            boolean win = combat(17, 55, player);
            if(win){
                //key pices and other things gold n stuff
                int coinage = 20 + randy.nextInt(10);
                System.out.println("You got a key peice and " + coinage + " gold coins!");
                player.addKeyPiece();
                player.addMoney(coinage);

            }
            if(!win){
                System.out.println("You died.");
                //set player paramerters back to normal (health)
                player.setHeroHP(player.getMaxHP());
            }
            
            //check peices to get big key
            if (player.hasBigKey()) {
                checkPoint.pop();
            }
            levelThree();
        }

        if (Objects.equals(doors.get(doorChoice), "Boss")) {

            if (inventory.contains("Key Three")) {

                //setting and fight code for bossThree

                if (keyThree && bossThree.getHp() <= 0) {
                    bossThree.setKeyDrop(true);
                }

                if (!bossThree.isKeyDrop()) {
                    System.out.println("You died.");
                    levelThree();
                } else {
                    //dialogue to end game
                }

            } else {
                System.out.println("You need a key to open this door.");
                levelThree();
            }

        }

    }

    public static boolean combat(int monsterDMG, int moneterHP, Hero player){
        Enemy monster = new Enemy(monsterDMG, moneterHP);
        while(monster.getMonsterHP() > 0){
            //text before the fight
			System.out.println("");
            Scanner scan = new Scanner(System.in);
            /*scan the line to determine player input and react from that input
            b = use bow to damage enemy
            s = use sword to damage enemy
            h = heath potions
            */
			String combatInput = scan.nextLine();

			if(combatInput.equals("s"))
			{
				System.out.println("You attack the monster dealing " + player.getSwordDMG() + " damage!");
				monster.setMonsterHP(monster.getMonsterHP() - player.getSwordDMG());
				System.out.println("Monster HP: " + monster.getMonsterHP());
			}
            if(combatInput.equals("b"))
			{
                //get damage for player turn so that it does not 
                //change for the HP difference and popup text
                int damageOUT = player.getBowDMG();
				System.out.println("You attack the monster dealing" + damageOUT + " damage!");
                monster.setMonsterHP(monster.getMonsterHP() - damageOUT);
				System.out.println("Monster HP: " + monster.getMonsterHP());
			}
			if(combatInput.equals("h"))
			{
                if(player.getHealing() == 0){
                    System.out.println("You have run out of healing potions! oh no....");
                }
				else if(player.getHeroHP() == player.getMaxHP())
				{
					System.out.println("You are at full health. You can't drink any health potions.");
				}
				else if(player.getHeroHP() < player.getMaxHP())
				{
					System.out.println("You drank a health potion.");
					System.out.println("Hmmm... Tates like strawberries...");
					System.out.println("HP fully restored!");
					player.useHealing();
				}
			}
			//monster attacking player
			System.out.println("The monster swings its weapon with malicious intent. You block it with your sword but the swing knocks you back due to the force.");
			//get damage for player turn so that it does not 
            //change for the HP difference and popup text
            int damageTAKEN = monster.getWeaponDMG();
			System.out.println("You took " + damageTAKEN + " damage from the monster!");
			player.setHeroHP(player.getHeroHP() - damageTAKEN);
			System.out.println("Player HP:" + player.getHeroHP());

			if(monster.getMonsterHP() <= 0)//monster death notification
			{
				System.out.println("You defeated the monster!");
				break;
			}
        }
        if(player.getHeroHP() <= 0)
            return false;
        return true;
    }

}