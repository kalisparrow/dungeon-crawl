import java.util.*;

public class main {

    public Stack<Integer> checkPoint = new Stack<Integer>();
    public HashMap<Integer, String> doors = new HashMap<Integer, String>();
    public ArrayList<Integer> levelOneDoors = new ArrayList<Integer>();
    public ArrayList<Integer> levelTwoDoors = new ArrayList<Integer>();
    public ArrayList<Integer> levelThreeDoors = new ArrayList<Integer>();

    // create player charater object
    Hero player = new Hero();
    // random number genrator for random money drop
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

        System.out.println("");

        int userDoorChoice = getUserDoorChoice(doors);
        
        if (Objects.equals(doors.get(userDoorChoice), "Enemy One")) {

            // setting and fight code for enemyOne
            // combat(monster damange, monster health, player cahracter)
            boolean win = combat(5, 30, "Goblin", player);
            if (win) {
                // key pices and other things gold n stuff
                int coinage = 20 + randy.nextInt(10);
                System.out.println("You got a key piece and " + coinage + " gold coins!");
                player.addKeyPiece();
                player.addMoney(coinage);
                player.playerStatReset();

            }
            if (!win) {
                System.out.println("You died.");
                // set player paramerters back to normal (health)
                player.playerStatReset();
            }

            // check peices to get big key
            if (player.hasBigKey()) {
                checkPoint.pop();
            }
            levelOne();
        }

        if (Objects.equals(doors.get(userDoorChoice), "Enemy Two")) {

            // setting and fight code for enemyTwo

            // setting and fight code for enemyOne
            // combat(monster damange, monster health, player cahracter)
            boolean win = combat(7, 35, "tempName", player);
            if (win) {
                // key pices and other things gold n stuff
                int coinage = 20 + randy.nextInt(10);
                System.out.println("You got a key piece and " + coinage + " gold coins!");
                player.addKeyPiece();
                player.addMoney(coinage);
                player.playerStatReset();

            }
            if (!win) {
                System.out.println("You died.");
                // set player paramerters back to normal (health)
                player.playerStatReset();
            }

            // check peices to get big key
            if (player.hasBigKey()) {
                checkPoint.pop();
            }
            levelOne();
        }

        if (Objects.equals(doors.get(userDoorChoice), "Boss")) {

            if (player.hasBigKey()) {
                player.useKey();

                // setting and fight code for bossOne

                /*
                 * if (keyOne && bossOne.getHp() <= 0) {
                 * bossOne.setKeyDrop(true);
                 * }
                 * 
                 * if (!bossOne.isKeyDrop()) {
                 * levelOne();
                 * } else {
                 * //dialogue to move to next level
                 * }
                 */

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

            // setting and fight code for enemyOne
            boolean win = combat(10, 45, "tempName", player);
            if (win) {
                // key pices and other things gold n stuff
                int coinage = 20 + randy.nextInt(10);
                System.out.println("You got a key piece and " + coinage + " gold coins!");
                player.addKeyPiece();
                player.addMoney(coinage);
                player.playerStatReset();

            }
            if (!win) {
                System.out.println("You died.");
                // set player paramerters back to normal (health)
                player.playerStatReset();
            }

            // check peices to get big key
            if (player.hasBigKey()) {
                checkPoint.pop();
            }
            levelTwo();
        }

        if (Objects.equals(doors.get(doorChoice), "Enemy Two")) {

            // setting and fight code for enemyOne
            boolean win = combat(12, 45, "tempName", player);
            if (win) {
                // key pices and other things gold n stuff
                int coinage = 20 + randy.nextInt(10);
                System.out.println("You got a key piece and " + coinage + " gold coins!");
                player.addKeyPiece();
                player.addMoney(coinage);
                player.playerStatReset();

            }
            if (!win) {
                System.out.println("You died.");
                // set player paramerters back to normal (health)
                player.playerStatReset();
            }

            // check peices to get big key
            if (player.hasBigKey()) {
                checkPoint.pop();
            }
            levelTwo();
        }

        /*
         * if (Objects.equals(doors.get(doorChoice), "Boss")) {
         * 
         * if (inventory.contains("Key Two")) {
         * 
         * //setting and fight code for bossTwo
         * 
         * if (keyTwo && bossTwo.getHp() <= 0) {
         * bossTwo.setKeyDrop(true);
         * }
         * 
         * if (!bossTwo.isKeyDrop()) {
         * System.out.println("You died.");
         * levelTwo();
         * } else {
         * //dialogue to move to next level
         * }
         * 
         * } else {
         * System.out.println("You need a key to open this door.");
         * levelTwo();
         * }
         * 
         * }
         */

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

            // setting and fight code for enemyOne
            boolean win = combat(15, 50, "tempName", player);
            if (win) {
                // key pices and other things gold n stuff
                int coinage = 20 + randy.nextInt(10);
                System.out.println("You got a key peice and " + coinage + " gold coins!");
                player.addKeyPiece();
                player.addMoney(coinage);
                player.playerStatReset();

            }
            if (!win) {
                System.out.println("You died.");
                // set player paramerters back to normal (health)
                player.playerStatReset();
            }

            // check peices to get big key
            if (player.hasBigKey()) {
                checkPoint.pop();
            }
            levelThree();
        }

        if (Objects.equals(doors.get(doorChoice), "Enemy Two")) {

            // setting and fight code for enemyOne
            boolean win = combat(17, 55, "tempName", player);
            if (win) {
                // key pices and other things gold n stuff
                int coinage = 20 + randy.nextInt(10);
                System.out.println("You got a key peice and " + coinage + " gold coins!");
                player.addKeyPiece();
                player.addMoney(coinage);
                player.playerStatReset();

            }
            if (!win) {
                System.out.println("You died.");
                // set player paramerters back to normal (health)
                player.playerStatReset();
            }

            // check peices to get big key
            if (player.hasBigKey()) {
                checkPoint.pop();
            }
            levelThree();
        }

        /*
         * if (Objects.equals(doors.get(doorChoice), "Boss")) {
         * 
         * if (inventory.contains("Key Three")) {
         * 
         * //setting and fight code for bossThree
         * 
         * if (keyThree && bossThree.getHp() <= 0) {
         * bossThree.setKeyDrop(true);
         * }
         * 
         * if (!bossThree.isKeyDrop()) {
         * System.out.println("You died.");
         * levelThree();
         * } else {
         * //dialogue to end game
         * }
         * 
         * } else {
         * System.out.println("You need a key to open this door.");
         * levelThree();
         * }
         * 
         * }
         */

    }

    public static int getUserDoorChoice(HashMap<Integer,String> doors)
    {
        for (int i = 1; i <= doors.size(); i++) {
            System.out.println(doors.get(i) + "(" + +i + ")");
        }

        System.out.println("\n");

        System.out.println("Choose a door: ");
        Scanner keyboard = new Scanner(System.in);
        String doorChoice = keyboard.nextLine();
        int doorChoiceInMap = -1; //holder number for handling input exceptions

        while(true)
        {
            if(!doorChoice.matches("^\\d+"))
            {
                System.out.println("Incorrect input: try again");

                doorChoice = keyboard.nextLine(); 

                continue;
            }

            doorChoiceInMap = Integer.valueOf(doorChoice);

            if(!(doorChoiceInMap == 1 || doorChoiceInMap == 2 || doorChoiceInMap == 3)){
                System.out.println("Incorrect input: try again");

                doorChoice = keyboard.nextLine();

                continue;
            }

            break;
        }

        return doorChoiceInMap;
    }

    public static boolean combat(int monsterDMG, int monsterHP, String monsterName, Hero player) {
        Enemy monster = new Enemy(monsterDMG, monsterHP, monsterName);
        Random enemyAttackAdjust = new Random();

        System.out.println("\nYou have entered combat with a " + monsterName + "!" + " (Health: " + monsterHP + ")");

        while (monster.getMonsterHP() > 0) {
            // text before the fight
            System.out.println("\nChoose your move:");
            System.out.print("S = use Sword to Attack, ");
            System.out.print("B = use Bow to Attack, ");
            System.out.print("H = use a Health Potion\n");
            Scanner scan = new Scanner(System.in);
            /*
             * scan the line to determine player input and react from that input
             * b = use bow to damage enemy
             * s = use sword to damage enemy
             * h = heath potions
             */
            String combatInput = scan.nextLine();

            if (!(combatInput.equals("s") || combatInput.equals("S") || combatInput.equals("b")
                    || combatInput.equals("B")
                    || combatInput.equals("h") || combatInput.equals("H"))) {
                System.out.println("Incorrect input: try again.");
                continue;
            }

            if (combatInput.equals("s") || combatInput.equals("S")) {
                System.out.println("You attack the monster dealing " + player.getSwordDMG() + " damage!");
                monster.setMonsterHP(monster.getMonsterHP() - player.getSwordDMG());

                if(monster.getMonsterHP() < 0)
                {
                    monster.setMonsterHP(0);
                }

                System.out.println("Monster HP remaining: " + monster.getMonsterHP());
            }
            if (combatInput.equals("b") || combatInput.equals("B")) {
                // get damage for player turn so that it does not
                // change for the HP difference and popup text
                int damageOUT = player.getBowDMG();
                System.out.println("You attack the monster dealing " + damageOUT + " damage!");
                monster.setMonsterHP(monster.getMonsterHP() - damageOUT);

                if(monster.getMonsterHP() < 0)
                {
                    monster.setMonsterHP(0);
                }

                System.out.println("Monster HP remaining: " + monster.getMonsterHP());
            }

            //exiting if player attack kills enemy
            if (monster.getMonsterHP() <= 0)// monster death notification
            {
                System.out.println("You defeated the " + monsterName + "!");
                break;
            }

            if (combatInput.equals("h") || combatInput.equals("H")) {
                if (player.gethealthPotions() == 0) {
                    System.out.println("You have run out of healing potions! oh no....");
                } else if (player.getHeroHP() == 100) {
                    System.out.println("You are at full health. You can't drink any health potions.");
                    continue;
                } else if (player.getHeroHP() < 100) {
                    System.out.println("You drank a health potion.");
                    System.out.println("Hmmm... Tates like strawberries...");
                    System.out.println("HP fully restored!");
                    player.useHealing();
                }
            }
            // monster attacking player
            // adjust the enemies damage output randomly
            int enemyAttackStrength = enemyAttackAdjust.nextInt(4);

            if (enemyAttackStrength == 0) {
                System.out.println("\nThe " + monsterName + " missed his attack!");
            }

            if (enemyAttackStrength == 1) {
                System.out.println("\nThe " + monsterName+ " swings its weapon with malicious intent, but you block it with your sword.");
                int damageTAKEN = monster.getWeaponDMG() - 15;
                
                if (damageTAKEN <= 0) 
                {
                    damageTAKEN = 0;

                }

                System.out.println("You took " + damageTAKEN + " damage from the monster!");
                player.setHeroHP(player.getHeroHP() - damageTAKEN);
                System.out.println("Player HP remaining: " + player.getHeroHP());
            }

            if (enemyAttackStrength == 2) {
                System.out.println("\nThe " + monsterName + " makes solid contact with his weapon, and you are knocked back.");
                int damageTAKEN = monster.getWeaponDMG();
                System.out.println("You took " + damageTAKEN + " damage from the monster!");
                player.setHeroHP(player.getHeroHP() - damageTAKEN);
                System.out.println("Player HP remaining: " + player.getHeroHP());
            }

            if (enemyAttackStrength == 3) {
                System.out.println("\nThe " + monsterName + " bludgeons you causing signficant damage.");
                int damageTAKEN = monster.getWeaponDMG() + 10;
                System.out.println("You took " + damageTAKEN + " damage from the monster!");
                player.setHeroHP(player.getHeroHP() - damageTAKEN);
                System.out.println("Player HP remaining: " + player.getHeroHP());
            }

        }
        if (player.getHeroHP() <= 0)
        {
            return false;
        }
        
        return true;
    }

   /* public static boolean bossCombat(int bossDMG, int bossHP, Hero player){
        Boss bossMan = new Boss(bossDMG, bossHP);
        Scanner combatInput = new Scanner(System.in);
        Random rand = new Random();
        //add dragon attack counter as dragon will do a lot of damage to player
        int dragonAttack = 3;
        while(bossMan.getMonsterHP() > 0)
        {
            //text before a boss fight
            System.out.println("");
            if(combatInput.equals("s"))
            {
                System.out.println("You attack the eliete mosnter with your sword dealing " + player.getSwordDMG() + " damage!");
                bossMan.setMonsterHP(bossMan.getMonsterHP() - player.getSwordDMG());
                System.out.println("Boss HP: " + bossMan.getMonsterHP());
            }
            if(combatInput.equals("b"))
            {
                //get damage for player turn so that it does not
                //change for the HP difference and popup text
                int damageOUT = player.getBowDMG();
                System.out.println("You attack the elite monster with your bow dealing" + damageOUT + " damage!");
                bossMan.setMonsterHP(bossMan.getMonsterHP() - damageOUT);
                System.out.println("Boss HP: " + bossMan.getMonsterHP());
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
                    System.out.println("Hmmm... Tastes like strawberries...");
                    System.out.println("HP fully restored!");
                    player.useHealing();
                }
            }
            //boss attacking player
            System.out.println("This elite monster uses some kind of dark magic. You try to block it with your sword but you are knocked back due to the force.");
            //get damage for player turn so that it does not
            //change for the HP difference and popup text
            int damageTAKEN = bossMan.getDMG();
            System.out.println("You took " + damageTAKEN + " damage from the elite monster!");
            player.setHeroHP(player.getHeroHP() - damageTAKEN);
            System.out.println("Player HP:" + player.getHeroHP());

            if(bossMan.getMonsterHP() <= 0)//monster death notification and end of fight
            {
                System.out.println("You defeated the boss monster!");
                return true;
            }
        }
        return true;
    }
    */
}





    



