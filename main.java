/**
* The Dungeon Crawl program is a text-based game where a user traverses through a dungeon fighting enemies, finding
* the 6 needed pieces of a key to fight the final boss and escape from the dungeon wealthy
*
* @author Ted Korolishin
* @author Kali 
* @author Sean Ey
* @version 1.0
*/
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

        System.out.println("\nIn a mythic land far away there was a grand kingdom, full of pleasantries and adventure. The ruler of this kingdom bore no malice towards his people and shared the wealth \n and prosperity of the kingdom with its all of its people. " + 
        " That was until one day, the earth shook, causing buried evil to arise near the countryside that was entombed in \n the ancient mountainside. For centuries, the kingdom combatted these dark" +
        "forces. In all the fighting the prosperity of the kingdom dwindled, and the old king's royal line grew greedy, \n causing a significant rise in poverty across the kingdom. However, legends say that inside this dark tomb" +
        "lays a great fortune and the adventure to collect the magic keys \n and slay the evil monsters inside will claim it and return the kingdom's worth and prosperity! You, however, are a young adventure on the countryside with " +
        "your mother. \n Your father was a farmer, but with the temptation of great wealth, he entered the dark dungeon to help his struggling family, never to be seen again. \n Your family is in jeopardy losing everything as the local " +
        "mercenaries demand payment to protect the farm from the monsters that seep from the dungeon; money that your family does not have. \nSo, you decide to enter the dungeon, with bow and sword in hand, and succeed where your " +
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
        } else {
            player.setReachedCheckpoint(false);
            // story
            System.out.println("\nYou choose the wooden door. It creaks open loudly, almost falling off the hinges as you push it. \n" +
            "As you enter the room it appears to be quite dark due to four torches on the wall, lit by a dark purple flame. Your eyes \n" +
            "adjust to the dimly lit room, you see a shadowy figure, slouching before you. It turns to you slowly after hearing you enter \n" +
            "It's a goblin and it looks like it's protecting its protecting a gold trinket.");
        }

        if (!player.getReachedCheckpoint()) {
            // combat(monster damage, monster health, player character)
            Enemy goblin = new Enemy("Goblin", 10, 30);
            boolean level1Enemy1 = combat(goblin, player);

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
            System.out.println("\nYou come across a second room traversing through the beginning corridors of the dungeon. This room is lit much like \n" +
            "the last however you see no figure. You walk in closer to investigate. As you look around you see if there \n" +
            "is anything in there? Suddenly you feel a looming presence above you. As you turn a bat falls from the ceiling and in a plum of smoke \n" +
            "turns into a man, no, a vampire. You see a golden thing around its neck. Time to show this month that it is not your blood that will be spilled");

            Enemy vampire = new Enemy("Vampire", 12, 40);
            boolean level1Enemy2 = combat(vampire, player);

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
            System.out.println("\nAs you carry on through the dungeon you approach another room. This room is larger than the previous rooms. \n" +
            "Several pillars are scattered near the perimeter of the room, lit with a bright orange flame \n" +
            "making it much easier to see. In the middle of the room lays a chest! Getting the treasure was far easier than you thought! Approaching \n" + 
            "the chest you think of why so many adventures have failed when it was this easy. As timing would have it and as you are feet away from the \n" +
            "chest, you hear it grumble. You stop in your tracks and brandish your sword. On cue the chest opens up, exposing its razor sharp teeth \n" + 
            "as spiked tentacles fly out of its mouth. A mimic! You were almost as foolish as the other adventures that were tricked by such a misleading \n" +
            "beast. Among the chaos, you see something shiny dangling from one of the tentacles. Looks like this fake chest still has some treasure!");

            //name, damage, health points, player
            Boss mimic = new Boss("Mimic", 20, 90);
            boolean level1Boss = bossCombat(mimic, player);
            
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
        } else {
            player.setReachedCheckpoint(false);
            // story
            System.out.println("\nAnother door, this one is made of a slightly corroded metal. As you open the door it bears some weight to it, but its nothing you cannot manage.");
            
        }

        if (!player.getReachedCheckpoint()) {
            System.out.println("\nProgressing this far down in the dungeon there is no light other than that of the enchanted flames from the torches on the walls. \n" +
            "The walls expand some as you move down and the light from the flames fades as the darkness grows deeper down the hall. You reach into your satchel and \n" +
            "grab your jar of glow bugs to help illuminate your way. Suddenly, a shadowy wisp sporadically moves around you in the hall, phasing through walls and \n" +
            "circling you. It must be a wraith or some kind of phantom. Through its movement, you can see something shine in the middle of the shifting smoke.");

            Enemy wraith = new Enemy("Wraith", 16, 80);
            // combat(Enemy enemy, player character)
            boolean level2Enemy1 = combat(wraith, player);

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
            System.out.println("\nAnother room. It is round and surrounded by grand pillars, intimidatingly lit with torches. It appears to be some kind of warriors arena. \n" +
            "Pieces of armor start to shake and move towards the center of the room, culminating to forming a suit of armor. Once formed the armor started to move on its own, \n" +
            "an enchanted suit of armor! Another gold piece was on the guard of its sword.");

            Enemy knight = new Enemy("Knight", 18, 85);
            boolean level2Enemy2 = combat(knight, player);

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
            System.out.println("\nThe labyrinth has been tight and constricting, even with its monster rooms. This led to quite the surprise when you walked into a \n" +
            "large underground room, covered in... dirt? Everything this far has been stone a brick. Taking a better look around you find that this room is more like a field, \n" + 
            "with grass stretching far and wide. And onceiling were glowing shards that illuminated that whole place, much less grim that any room you have encountered thus \n" +
            "far in the dungeon. Then the ground began the shake and tremble. Over one of the hills comes a huge minotaur bearing a menacing axe. It stops atop the hill and \n" +
            "scapes the ground as though it is going to charge. As you ready yourself you see another golden object on the minotaur's horn.");

            //boss fight for second room
            Boss minotaur = new Boss("Minotaur", 22, 100);
            boolean level2Boss = bossCombat(minotaur, player);
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
        
        System.out.println("\nThe metal door screeches open slowly, narrowly opening enough for you to pass. The room is covered in debris and dark purple flame. The air here" +
        "is thick; it's difficult to breathe. There is a certain looming sense of doom that surrounds you. This room feels darker and more evil than any other room before. As you approach" +
        "a throne made of obsidian you see a near skeletal corpse dawning a raggedy robe with a scythe in hand. It must be that evil dark lord, or what is left of it. A deep growl comes" +
        "from the back of the throne. A three-headed canine beast slowly approaches you. Its eyes are blood red, lusting for death and destruction. If you want to get out alive with" +
        "treasures of this dungeon, you will need to kill the Cerberus");
        //boss fight for final room
        
        Boss cerberus = new Boss("Cerberus", 25, 120);
        boolean finalBoss = bossCombat(cerberus, player);
        if (finalBoss) {
            // resets players health and potions, and awards coins for winning
            whenPlayerWinsFightGeneralEnemy(player);
            //add text for ending
            System.out.println("\nOnce the beast of evil has been killed, a door behind the throne appeared. Inside was more treasure and gold than anyone ever thought could exist.\n" + 
            "You return home with a hoard of gold and treasures! Your mother greets you with tears of joy. \nThe wicked king was overthrown and the Kingdom was restored"+
            " to what it once was with you as its ruler.");
            System.out.println("Total Gold Found: " + player.getGold() + 1000);
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
     * method used to get the users choice for which door to enter, handles exceptions in input
     * @param doors
     * @return the users choice of 1, 2, or 3
     */
    public static int getUserDoorChoice(HashMap<Integer,String> doors)
    {
        // prints out user choices for doors
        for (int i = 1; i <= doors.size(); i++) {
            System.out.println(doors.get(i) + " (Press " + i + ")");
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
    
    /**
     * method used to award player coins after completion of a battle, reset their health and potions
     * , and rewards one of the six needed key pieces
     * @param player
     */
    public static void whenPlayerWinsFightGeneralEnemy(Hero player) {
        Random randy = new Random();
        int coinage = 20 + randy.nextInt(20);
        player.addKeyPiece();
        System.out.println("You got a key piece " + "("+ player.getKeyPieces()+ "/6)" + " and " + coinage + " gold coins!");
        player.addMoney(coinage);
        player.playerStatReset();
    }

    /**
     * method used when a player dies in combat, will give them the option to continue or quit the game 
     * @return boolean that determines whether the user wants to continue the game 
     */
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

    /**
     * method used for players to fight enemies and collect the 6 needed keys. method takes user input to choose an attack
     * and uses random digits to determine the strength of the attack. enemy attack strength is determined the same way. 
     * fight goes until one of the parameters runs out of health points
     * @param enemy
     * @param player
     * @return true if the user wins the fight
     */
    public static boolean combat(Enemy enemy, Hero player) {

        Scanner scan = new Scanner(System.in);

        System.out.println("\nYou have entered combat with a " + enemy.getEnemyName() + "!" + " (Health: " + enemy.getEnemyHP() + ")");

        while (enemy.getEnemyHP() > 0 && player.getHeroHP() > 0) {
            //random numbers used to determine strength of user and enemy attacks
            Random heroAttackAdjust = new Random();
            Random enemyAttackAdjust = new Random();
            // adjust the user and enemies damage output randomly
            int enemyAttackStrength = enemyAttackAdjust.nextInt(4);
            int heroAttackStrength = heroAttackAdjust.nextInt(4);

            System.out.println("\nChoose your move:");
            System.out.print("S = use Sword to Attack, ");
            System.out.print("B = use Bow to Attack, ");
            System.out.print("H = use a Health Potion\n");
            /*
             * scan the line to determine player input and react from that input
             * b = use bow to damage enemy
             * s = use sword to damage enemy
             * h = heath potions
             */
            String combatInput = scan.nextLine();

            if (!(combatInput.equalsIgnoreCase("S") || combatInput.equalsIgnoreCase("B") || combatInput.equalsIgnoreCase("H"))) {
                System.out.println("Incorrect input: try again.");
                continue;
            }

            if (combatInput.equalsIgnoreCase("S")) {
                //calls method to randomize user sword attack strength
                determineHeroSwordAttack(player, heroAttackStrength, enemy);
            }
            
            if (combatInput.equalsIgnoreCase("B")) {
                //calls method to randomize user bow attack strength
                determineHeroBowAttack(player, heroAttackStrength, enemy);
            }

            //exiting if player attack kills enemy
            if (enemy.getEnemyHP() <= 0)// monster death notification
            {
                System.out.println("\nYou defeated the " + enemy.getEnemyName() + "!");
                break;
            }

            if (combatInput.equalsIgnoreCase("H")) {
                if (player.gethealthPotions() == 0) {
                    System.out.println("You have run out of healing potions! oh no....");
                    continue;
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

            determineEnemyAttack(enemy, enemyAttackStrength, player);

        }
        if (player.getHeroHP() <= 0)
        {
            return false;
        }

        return true;
    }

    /**
     * method used to determine the strength of the users sword attack and damage enemy accordingly
     * @param player
     * @param heroAttackStrength
     * @param enemy
     */
    public static void determineHeroSwordAttack(Hero player, int heroAttackStrength, Enemy enemy) {
        //miss attack
        if (heroAttackStrength == 0) {
            System.out.println("\nYou swung your sword and missed the " + enemy.getEnemyName() + "!");
        }

        //light attack
        if (heroAttackStrength == 1) {
            System.out.println("\nYou graze the " + enemy.getEnemyName() + " with your sword.");

            enemy.setEnemyHP(enemy.getEnemyHP() - (player.getSwordDMG() - 10));

            System.out.println("You did " + (player.getSwordDMG() - 10) + " damage to the enemy!");
            System.out.println("Enemy HP remaining: " + enemy.getEnemyHP());
        }

        //normal attack
        if (heroAttackStrength == 2) {
            System.out.println("\nYou make solid contact with the enemies torso.");
            
            enemy.setEnemyHP(enemy.getEnemyHP() - player.getSwordDMG());

            System.out.println("You did " + player.getSwordDMG() + " damage to the enemy!");
            System.out.println("Enemy HP remaining: " + enemy.getEnemyHP());
        }

        //heavy attack
        if (heroAttackStrength == 3) {
            System.out.println("\nA severe strike to the " + enemy.getEnemyName() + "'s head with your sword!");

            enemy.setEnemyHP(enemy.getEnemyHP() - (player.getSwordDMG() + 10));

            System.out.println("You did " + (player.getSwordDMG() + 15) + " damage to the enemy!");
            System.out.println("Enemy HP remaining: " + enemy.getEnemyHP());
        }
    }

    /**
     * method used to determine strength of users bow attack and damage enemy accordingly
     * @param player
     * @param heroAttackStrength
     * @param enemy
     */
    public static void determineHeroBowAttack(Hero player, int heroAttackStrength, Enemy enemy) {
        //miss attack
        if (heroAttackStrength == 0) {
            System.out.println("\nYou shot your bow and missed the " + enemy.getEnemyName() + "!");
        }

        //light attack
        if (heroAttackStrength == 1) {
            System.out.println("\nYou scratch the enemy" + enemy.getEnemyName() + " with an arrow.");

            enemy.setEnemyHP(enemy.getEnemyHP() - (player.getBowDMG() - 10));

            System.out.println("You did " + (player.getBowDMG() - 10) + " damage to the enemy!");
            System.out.println("Enemy HP remaining: " + enemy.getEnemyHP());
        }

        //normal attack
        if (heroAttackStrength == 2) {
            System.out.println("\nYou pull back your bowstring and strike the " + enemy.getEnemyName() + ".");
            
            enemy.setEnemyHP(enemy.getEnemyHP() - player.getBowDMG());

            System.out.println("You did " + player.getBowDMG() + " damage to the enemy!");
            System.out.println("Enemy HP remaining: " + enemy.getEnemyHP());
        }

        //heavy attack
        if (heroAttackStrength == 3) {
            System.out.println("\nYou line up the shot and hit the " + enemy.getEnemyName() + " in the head!");

            enemy.setEnemyHP(enemy.getEnemyHP() - (player.getSwordDMG() + 20));

            System.out.println("You did " + (player.getSwordDMG() + 20) + " damage to the enemy!");
            System.out.println("Enemy HP remaining: " + enemy.getEnemyHP());
        }
    }

    /**
     * method used to determine the strength of enemy attack and damage player accordingly
     * @param enemy
     * @param enemyAttackStrength
     * @param player
     */
    public static void determineEnemyAttack(Enemy enemy, int enemyAttackStrength, Hero player) {
        //miss
        if (enemyAttackStrength == 0) {
            System.out.println("\nThe " + enemy.getEnemyName() + " missed their attack!");
        }

        //light hit
        if (enemyAttackStrength == 1) {
            System.out.println("\nThe " + enemy.getEnemyName() + " swings its weapon with malicious intent, but you block it with your sword.");
            int damageTAKEN = enemy.getWeaponDMG() - 15;

            if (damageTAKEN <= 0)
            {
                damageTAKEN = 0;

            }

            System.out.println("You took " + damageTAKEN + " damage from the enemy!");
            player.setHeroHP(player.getHeroHP() - damageTAKEN);
            System.out.println("Player HP remaining: " + player.getHeroHP());
        }

        //normal hit
        if (enemyAttackStrength == 2) {
            System.out.println("\nThe " + enemy.getEnemyName() + " makes solid contact with their weapon, and you are knocked back.");

            player.setHeroHP(player.getHeroHP() - enemy.getWeaponDMG());
        
            System.out.println("You took " + enemy.getWeaponDMG() + " damage from the monster!");
            System.out.println("Player HP remaining: " + player.getHeroHP());
        }

        //strong hit
        if (enemyAttackStrength == 3) {
            System.out.println("\nThe " + enemy.getEnemyName() + " bludgeons you causing signficant damage.");

            player.setHeroHP(player.getHeroHP() - (enemy.getWeaponDMG() + 10));
            
            System.out.println("You took " + (enemy.getWeaponDMG() + 10) + " damage from the monster!");
            System.out.println("Player HP remaining: " + player.getHeroHP());
        }
    }

    /**
     * method used to conduct combat between boss level enemies and the user
     * @param boss
     * @param player
     * @return
     */
    public static boolean bossCombat(Boss boss, Hero player) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nYou have entered combat with a " + boss.getBossName() + "!" + " (Health: " + boss.getBossHP() + ")");

        while (boss.getBossHP() > 0 && player.getHeroHP() > 0) {
            //random numbers used to determine strength of user and enemy attacks
            Random heroAttackAdjust = new Random();
            Random bossAttackAdjust = new Random();
            // adjust the user and enemies damage output randomly
            int heroAttackStrength = heroAttackAdjust.nextInt(4);
            int bossAttackStrength = bossAttackAdjust.nextInt(5);

            System.out.println("\nChoose your move:");
            System.out.print("S = use Sword to Attack, ");
            System.out.print("B = use Bow to Attack, ");
            System.out.print("H = use a Health Potion\n");
            /*
             * scan the line to determine player input and react from that input
             * b = use bow to damage enemy
             * s = use sword to damage enemy
             * h = heath potions
             */
            String combatInput = scan.nextLine();

            if (!(combatInput.equalsIgnoreCase("S") || combatInput.equalsIgnoreCase("B") || combatInput.equalsIgnoreCase("H"))) {
                System.out.println("Incorrect input: try again.");
                continue;
            }

            if (combatInput.equalsIgnoreCase("S")) {
                //calls method to randomize user sword attack strength
                determineHeroSwordAttack(player, heroAttackStrength, boss);
            }
            
            if (combatInput.equalsIgnoreCase("B")) {
                //calls method to randomize user bow attack strength
                determineHeroBowAttack(player, heroAttackStrength, boss);
            }

            //exiting if player attack kills enemy
            if (boss.getEnemyHP() <= 0)// monster death notification
            {
                System.out.println("\nYou defeated the " + boss.getEnemyName() + "!");
                break;
            }

            if (combatInput.equalsIgnoreCase("H")) {
                if (player.gethealthPotions() == 0) {
                    System.out.println("You have run out of healing potions! oh no....");
                    continue;
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
            
            //method called to randomized the strength of the bosses attack
            determineBossAttack(boss, bossAttackStrength, player);
            

        }
        if (player.getHeroHP() <= 0)
        {
            return false;
        }

        return true;
    }


    /**
     * method used to determine the strength of boss attack and damage player accordingly
     * @param boss
     * @param bossAttackStrength
     * @param player
     */
    public static void determineBossAttack(Boss boss, int bossAttackStrength, Hero player) {
        //miss
        if (bossAttackStrength == 0) {
            System.out.println("\nThe " + boss.getBossName() + " missed their attack!");
        }

        //light attack
        if (bossAttackStrength == 1) {
            System.out.println("\nThe " + boss.getBossName() + " clips your shoulder just barely, doing minimal damage.");

            player.setHeroHP(player.getHeroHP() - (boss.getDMG() - 15));

            System.out.println("You took " + (boss.getDMG() - 15) + " damage from the enemy!");
            System.out.println("Player HP remaining: " + player.getHeroHP());
        }

        //normal attack
        if (bossAttackStrength == 2) {
            System.out.println("\nThe " + boss.getBossName() + " makes direct contact, but you shield yourself well.");

            player.setHeroHP(player.getHeroHP() - (boss.getDMG()));

            System.out.println("You took " + (boss.getDMG()) + " damage from the enemy!");
            System.out.println("Player HP remaining: " + player.getHeroHP());
        }

        //heavy attack
        if (bossAttackStrength == 3) {
            System.out.println("\nIn a flash you have been struck heavily by the " + boss.getBossName() + ".");

            player.setHeroHP(player.getHeroHP() - (boss.getDMG() + 10));

            System.out.println("You took " + (boss.getDMG() + 10) + " damage from the enemy!");
            System.out.println("Player HP remaining: " + player.getHeroHP());
        }

        //critcal hit
        if (bossAttackStrength == 4) {
            System.out.println("\nThe " + boss.getBossName() + " conducts a near lethal hit.");

            player.setHeroHP(player.getHeroHP() / 2);

            System.out.println("Your health points have been split in half.");
            System.out.println("Player HP remaining: " + player.getHeroHP());
        }
    }
}
