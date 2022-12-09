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

        // method used to output proper door choices for user and handle input exceptions in all cases
        int userDoorChoice = getUserDoorChoice(doors);
        
        //the first fight in level one
        if (Objects.equals(doors.get(userDoorChoice), "Enemy One")) {

            // setting and fight code for enemyOne
            // combat(monster damange, monster health, player cahracter)
            boolean win = combat(5, 30, "Goblin", player);
            
            if (win) {
                // resets players health and potions, and awards coins for winning 
                whenPlayerWinsFightGeneralEnemy(player);
            }
            if (!win) {
                System.out.println("You died.");
                // reset player health to max and potion amount to 3
                player.playerStatReset();
                levelOne();
            }

            // check peices to get big key
            if (player.hasBigKey()) {
                checkPoint.pop();
            }
        }

        //the second fight in level one
        if (player.getKeyPieces() >= 1) {

            boolean win = combat(7, 35, "Vampire", player);
            if (win) {
                // resets players health and potions, and awards coins for winning
                whenPlayerWinsFightGeneralEnemy(player);
            }
            if (!win) {
                System.out.println("You died.");
                // reset player health to max and potion amount to 3
                player.playerStatReset();
                levelOne();
            }

            // check peices to get big key
            if (player.hasBigKey()) {
                checkPoint.pop();
            }
            
        }

        //the level one boss fight
        if (player.getKeyPieces() >= 2) {

            //boss fight for first room
            boolean win = bossCombat("Boss1", 100, 15, player);
            if (win) {
                // resets players health and potions, and awards coins for winning
                whenPlayerWinsFightGeneralEnemy(player);
            }
            if (!win) {
                System.out.println("You died.");
                // reset player health to max and potion amount to 3
                player.playerStatReset();
                levelOne();
            }

            // check peices to get big key
            if (player.getKeyPieces() >= 3) {
                levelTwo();
            }

        }

    }

    public void levelTwo() {

        System.out.println("");

        System.out.println("reached level 2");

        // method used to output proper door choices for user and handle input exceptions in all cases
        int userDoorChoice = getUserDoorChoice(doors);

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

    /*
     * return int for user making choice on which door they want to enter
     */
    public static int getUserDoorChoice(HashMap<Integer,String> doors)
    {
        // prints out user choices for doors
        for (int i = 1; i <= doors.size(); i++) {
            System.out.println(doors.get(i) + "(" + +i + ")");
        }

        System.out.println("\n");

        System.out.println("Choose a door: ");
        Scanner keyboard = new Scanner(System.in);
        String doorChoice = keyboard.nextLine();
        int doorChoiceInMap = -1; //holder number for handling input exceptions

        // loop used to handle input exceptions until user enters a correct door number
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
    /*
     * Method used when player wins a fight to reset stats and award coins
     * 
     */
    public static void whenPlayerWinsFightGeneralEnemy(Hero player)
    {
        Random randy = new Random();
        int coinage = 20 + randy.nextInt(20);
        System.out.println("You got a key peice and " + coinage + " gold coins!");
        player.addKeyPiece();
        player.addMoney(coinage);
        player.playerStatReset();
    }

    public static boolean combat(int monsterDMG, int monsterHP, String monsterName, Hero player) {
        Enemy monster = new Enemy(monsterDMG, monsterHP, monsterName);
        Random enemyAttackAdjust = new Random();

        System.out.println("\nYou have entered combat with a " + monsterName + "!" + " (Health: " + monsterHP + ")");

        while (monster.getMonsterHP() > 0) {
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

   public static boolean bossCombat(String bossName, int bossDMG, int bossHP, Hero player){
        Boss boss = new Boss(bossName, bossDMG, bossHP);
        Random enemyAttackAdjust = new Random();

        System.out.println("\nYou have entered combat with a " + bossName + "!" + " (Health: " + bossHP + ")");

        while (boss.getBossHP() > 0) {
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
                boss.setBossHP(boss.getBossHP() - player.getSwordDMG());

                if(boss.getBossHP() < 0)
                {
                    boss.setBossHP(0);
                }

                System.out.println("Monster HP remaining: " + boss.getBossHP());
            }
            if (combatInput.equals("b") || combatInput.equals("B")) {
                // get damage for player turn so that it does not
                // change for the HP difference and popup text
                int damageOUT = player.getBowDMG();
                System.out.println("You attack the monster dealing " + damageOUT + " damage!");
                boss.setBossHP(boss.getBossHP() - damageOUT);

                if(boss.getBossHP() < 0)
                {
                    boss.setBossHP(0);
                }

                System.out.println("Monster HP remaining: " + boss.getBossHP());
            }

            //exiting if player attack kills enemy
            if (boss.getBossHP() <= 0)// monster death notification
            {
                System.out.println("You defeated the " + bossName + "!");
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
                System.out.println("\nThe " + bossName + " missed his attack!");
            }

            if (enemyAttackStrength == 1) {
                System.out.println("\nThe " + bossName + " swings its weapon with malicious intent, but you block it with your sword.");
                int damageTAKEN = boss.getDMG() - 15;
                
                if (damageTAKEN <= 0) 
                {
                    damageTAKEN = 0;

                }

                System.out.println("You took " + damageTAKEN + " damage from the monster!");
                player.setHeroHP(player.getHeroHP() - damageTAKEN);
                System.out.println("Player HP remaining: " + player.getHeroHP());
            }

            if (enemyAttackStrength == 2) {
                System.out.println("\nThe " + bossName + " makes solid contact with his weapon, and you are knocked back.");
                int damageTAKEN = boss.getDMG();
                System.out.println("You took " + damageTAKEN + " damage from the monster!");
                player.setHeroHP(player.getHeroHP() - damageTAKEN);
                System.out.println("Player HP remaining: " + player.getHeroHP());
            }

            if (enemyAttackStrength == 3) {
                System.out.println("\nThe " + bossName + " bludgeons you causing signficant damage.");
                int damageTAKEN = boss.getDMG() + 10;
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
    
}





    



