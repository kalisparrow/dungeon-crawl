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
        home();
        levelOne();
        levelTwo();
        levelThree();

    }

    public void rooms() {

        System.out.println("In a mythic land far away there was a grand kingdom, full of pleasantries and adventure. The ruler of this kingdom bore no malice towards his people and shared the wealth and prosperity of the kingdom \n" + 
        "with its all of its people. That was until one day, the earth shook, causing buried evil to arise near the countryside that was entombed in the ancient mountainside. For centuries, the kingdom combatted these dark \n" +
        "forces. In all the fighting the prosperity of the kingdom dwindled, and the old king's royal line grew greedy, causing a significant rise in poverty across the kingdom. However, legends say that inside this dark tomb \n" +
        "lays a great fortune and the adventure to collect the magic keys and slay the evil monsters inside will claim it and return the kingdom's worth and prosperity! You, however, are a young adventure on the countryside with \n" +
        "your mother. Your father was a farmer, but with the temptation of great wealth, he entered the dark dungeon to help his struggling family, never to be seen again. Your family is in jeopardy losing everything as the local \n" +
        "mercenaries demand payment to protect the farm from the monsters that seep from the dungeon; money that your family does not have. So, you decide to enter the dungeon, with bow and sword in hand, and succeed where your \n" +
        "father failed and save your family");

        doors.put(1, "A worn down wooden door with a sign above it that reads 'Not very scary'");
        doors.put(2, "A metal door with a sign above it that reads 'Kind of scary'");
        doors.put(3, "A reinforced polished steel door with a sign above it that reads 'Very scary'");

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

    public void home() {
        System.out.println("");

        // method used to output proper door choices for user and handle input exceptions in all cases
        int userDoorChoice = getUserDoorChoice(doors);

        if (Objects.equals(doors.get(userDoorChoice), "A worn down wooden door with a sign above it that reads 'Not very scary'")){
            levelOne();
        }

        if (Objects.equals(doors.get(userDoorChoice), "A metal door with a sign above it that reads 'Kind of scary'")){
            levelTwo();
        }

        if (Objects.equals(doors.get(userDoorChoice), "A reinforced polished steel door with a sign above it that reads 'Very scary'")){
            levelThree();
        }
    }

    public void levelOne() {

        if (player.getKeyPieces() >= 3) {
            System.out.println("\nWalking back inside you see the carnage left in your wake. There is nothing else to collect in here. You turn around and head back out.");
            home();
        }

        // check pieces to get big key
        if (checkPoint.peek() == 3) {
            player.setReachedCheckpoint(true);
            System.out.println("\nThe big baddie is in front of you. Fight!");
        } else {
            player.setReachedCheckpoint(false);
            // story
            System.out.println("You choose the wooden door. It creaks open loudly, almost falling off the hinges as you push it. \n" +
            "As you enter the room it appears to be quite dark due to four torches on the wall, lit by a dark purple flame. Your eyes \n" +
            "adjust to the dimly lit room, you see a shadowy figure, slouching before you. It turns to you slowly after hearing you enter \n" +
            "It's a goblin and it looks like it's protecting its protecting a gold trinket.");
        }

        if (!player.getReachedCheckpoint()) {a
            // combat(monster damage, monster health, player character)
            boolean level1Enemy1 = combat(5, 5, "Goblin", player);

            if (level1Enemy1) { //for a win
                // resets players health and potions, and awards coins for winning
                whenPlayerWinsFightGeneralEnemy(player);
            }
            if (!level1Enemy1) {
                if(death()) {
                    levelOne();
                }
            }
        }

        //the second fight in level one
        if (!player.getReachedCheckpoint()) {
            System.out.println("You come across a second room traversing through the beginning corridors of the dungeon. This room is lit much like \n" +
            "the last however you see no figure. You walk in closer to investigate. As you look around you see if there \n" +
            "is anything in there? Suddenly you feel a looming presence above you. As you turn a bat falls from the ceiling and in a plum of smoke \n" +
            "turns into a man, no, a vampire. You see a golden thing around its neck. Time to show this month that it is not your blood that will be spilled");

            boolean level1Enemy2 = combat(10, 5, "Vampire", player);

            if (level1Enemy2) {
                // resets players health and potions, and awards coins for winning
                checkPoint.pop();
                whenPlayerWinsFightGeneralEnemy(player);
                levelOne();
            }
            if (!level1Enemy2) {
                if(death()) {
                    levelOne();
                }
            }

        } else {
            //boss fight for first room
            System.out.println("As you carry on through the dungeon you approach another room. This room is larger than the previous rooms. \n" +
            "Several pillars are scattered near the perimeter of the room, lit with a bright orange flame \n" +
            "making it much easier to see. In the middle of the room lays a chest! Getting the treasure was far easier than you thought! Approaching \n" + 
            "the chest you think of why so many adventures have failed when it was this easy. As timing would have it and as you are feet away from the \n" +
            "chest, you hear it grumble. You stop in your tracks and brandish your sword. On cue the chest opens up, exposing its razor sharp teeth \n" + 
            "as spiked tentacles fly out of its mouth. A mimic! You were almost as foolish as the other adventures that were tricked by such a misleading \n" +
            "beast. Among the chaos, you see something shiny dangling from one of the tentacles. Looks like this fake chest still has some treasure!");

            boolean level1Boss = bossCombat("Mimic", 10, 25, player);
            if (level1Boss) {
                // resets players health and potions, and awards coins for winning
                whenPlayerWinsFightGeneralEnemy(player);
                home();
            }
            if (!level1Boss) {
                if(death()) {
                    levelOne();
                }
            }

            // check pieces to get big key
            if (player.getKeyPieces() >= 3) {
                home();
            }
        }

    }

    public void levelTwo() {

        if(player.getKeyPieces() < 3) {
            System.out.println("\nThis door is locked. You need at least 3 pieces of the master key.");
            home();
        }

        if (player.getKeyPieces() >= 6) {
            System.out.println("\nWalking back inside you see the carnage left in your wake. There is nothing else to collect in here. You turn around and head back out.");
            home();
        }

        // check pieces to get big key
        if (checkPoint.peek() == 2) {
            player.setReachedCheckpoint(true);
            System.out.println("\nThe big baddie is in front of you. Fight!");
        } else {
            player.setReachedCheckpoint(false);
            // story
            System.out.println("\nAnother door, this one is made of a slightly corroded metal. As you open the door it bears some weight to it, but its nothing you cannot manage.");
            
        }

        if (!player.getReachedCheckpoint()) {
            System.out.println("\n-add story text for encounter 1-");

            // combat(monster damage, monster health, player character)
            boolean level2Enemy1 = combat(10, 10, "Level2Enemy1", player);

            if (level2Enemy1) { //for a win
                // resets players health and potions, and awards coins for winning
                whenPlayerWinsFightGeneralEnemy(player);
            }
            if (!level2Enemy1) {
                if(death()) {
                    levelTwo();
                }
            }
        }

        //the second fight in level one
        if (!player.getReachedCheckpoint()) {
            System.out.println("\n-add story text for encounter 2-");

            boolean level2Enemy2 = combat(10, 10, "Level2Enemy2", player);

            if (level2Enemy2) {
                // resets players health and potions, and awards coins for winning
                checkPoint.pop();
                whenPlayerWinsFightGeneralEnemy(player);
                levelTwo();
            }
            if (!level2Enemy2) {
                if(death()) {
                    levelTwo();
                }
            }

        } else {
            System.out.println("\n-add story text for boss encounter-");

            //boss fight for second room
            boolean level2Boss = bossCombat("Boss2", 10, 10, player);
            if (level2Boss) {
                // resets players health and potions, and awards coins for winning
                whenPlayerWinsFightGeneralEnemy(player);
                player.setReachedCheckpoint(true);
                home();
            }
            if (!level2Boss) {
                if(death()) {
                    levelTwo();
                }
            }

            // check pieces to get big key
            if (player.getKeyPieces() >= 6) {
                home();
            }
        }
    }

    public void levelThree() {

        if(player.getKeyPieces() < 6)
        {
            System.out.println("\nThis door is locked. You must find the 6 pieces of the master key.");
            home();
        }

        System.out.println("\nThe metal door screeches open slowly, narrowly opening enough for you to pass.");
        //boss fight for first room
        boolean finalBoss = bossCombat("finalBoss", 10, 15, player);
        if (finalBoss) {
            // resets players health and potions, and awards coins for winning
            whenPlayerWinsFightGeneralEnemy(player);
            //add text for ending
            System.out.println("-text for ending of game-");
            System.exit(0);
        }
        if (!finalBoss) {
            System.out.println("You died.");
            // reset player health to max and potion amount to 3
            player.playerStatReset();
            levelThree();
        }


    }

    /**
     * 
     * 
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
    public static void whenPlayerWinsFightGeneralEnemy(Hero player) {
        Random randy = new Random();
        int coinage = 20 + randy.nextInt(20);
        System.out.println("You got a key piece and " + coinage + " gold coins!");
        player.addKeyPiece();
        player.addMoney(coinage);
        player.playerStatReset();
    }

    public boolean death() {
        boolean contGame = false;
        String continueGame = "";
        Scanner input = new Scanner(System.in);
        while (continueGame.equals("")) {
            System.out.println("\nYou died...");
            System.out.println("Continue? (Y/N)\n");
            continueGame = input.nextLine();
            if (continueGame.equalsIgnoreCase("Y")) {
                System.out.println("\nHatching the dragon eggs...\n");
                // reset player health to max and potion amount to 3
                player.playerStatReset();
                contGame = true;
                return contGame;
            }
            else if (continueGame.equalsIgnoreCase("N")) {
                System.out.println("\nThanks for playing!");
                System.exit(0);
            }
            else {
                System.out.println("\nInvalid input, please try again. (Enter Y or N)");
                continueGame = "";
            }
        }
        return contGame;
    }

    public static boolean combat(int monsterDMG, int monsterHP, String monsterName, Hero player) {
        Enemy monster = new Enemy(monsterDMG, monsterHP, monsterName);
        Random enemyAttackAdjust = new Random();

        System.out.println("\nYou have entered combat with a " + monsterName + "!" + " (Health: " + monsterHP + ")");

        while (monster.getMonsterHP() > 0 && player.getHeroHP() > 0) {
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

        while (boss.getBossHP() > 0 && player.getHeroHP() > 0) {
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
