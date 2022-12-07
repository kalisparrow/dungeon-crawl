import java.util.*;

public class main {

    public Stack<Integer> checkPoint = new Stack<Integer>();
    public ArrayList<String> inventory = new ArrayList<String>();
    public HashMap<Integer, String> doors = new HashMap<Integer, String>();
    public ArrayList<Integer> levelOneDoors = new ArrayList<Integer>();
    public ArrayList<Integer> levelTwoDoors = new ArrayList<Integer>();
    public ArrayList<Integer> levelThreeDoors = new ArrayList<Integer>();

    public void run() {

        checkPoint.push(1);
        checkPoint.push(2);
        checkPoint.push(3);
        checkPoint.push(4);

        inventory.add("10 gold");

        rooms();
        levelOne();
        levelTwo();
        levelThree();

    }

    public void rooms() {

        doors.put(1, "Enemy One");
        doors.put(2, "Enemy Two");
        doors.put(3, "Miscellaneous");
        doors.put(4, "Boss");

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

        boolean keyOne = false;
        int keyPieces = 0;

        enemy enemyOne = new enemy("Goblin", 10, 1);
        enemy enemyTwo = new enemy("Big Goblin", 20, 1);
        boss bossOne = new boss("Mimic", 50, false);

        if (checkPoint.peek() == 3) {
            enemyOne.setHp(0);
            enemyTwo.setHp(0);
            keyPieces = 2;
        }

        for (Integer levelOneDoor : levelOneDoors) {
            System.out.print(doors.get(levelOneDoor) + "   ");
        }

        System.out.println("\n");

        System.out.println("Choose a door: ");
        Scanner keyboard = new Scanner(System.in);
        int doorChoice = keyboard.nextInt();

        if (Objects.equals(doors.get(doorChoice), "Miscellaneous")) {
            //code for misc room
            System.out.println("Insert misc room description here.");
            levelOne();
        }

        if (Objects.equals(doors.get(doorChoice), "Enemy One")) {

            //setting and fight code for enemyOne

            if (enemyOne.getHp() <= 0) {
                keyPieces += 1;
                levelOneDoors.remove(doorChoice);
            } else {
                System.out.println("You died.");
            }
            if (keyPieces >= 2) {
                inventory.add("Key One");
                keyOne = true;
                checkPoint.pop();
            }
            levelOne();
        }

        if (Objects.equals(doors.get(doorChoice), "Enemy Two")) {

            //setting and fight code for enemyTwo

            if (enemyTwo.getHp() <= 0) {
                keyPieces += 1;
                levelOneDoors.remove(doorChoice);
            } else {
                System.out.println("You died.");
            }
            if (keyPieces >= 2) {
                inventory.add("Key One");
                keyOne = true;
                checkPoint.pop();
            }
            levelOne();
        }

        if (Objects.equals(doors.get(doorChoice), "Boss")) {

            if (inventory.contains("Key One")) {

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

        boolean keyTwo = false;
        int keyPieces = 0;

        enemy enemyThree = new enemy("Orc", 30, 1);
        enemy enemyFour = new enemy("Big Orc", 40, 1);
        boss bossTwo = new boss("Medusa", 100, false);

        if (checkPoint.peek() == 2) {
            enemyThree.setHp(0);
            enemyFour.setHp(0);
            keyPieces = 2;
        }

        for (Integer levelTwoDoor : levelTwoDoors) {
            System.out.print(doors.get(levelTwoDoor) + "   ");
        }

        System.out.println("\n");

        System.out.println("Choose a door: ");
        Scanner keyboard = new Scanner(System.in);
        int doorChoice = keyboard.nextInt();

        if (Objects.equals(doors.get(doorChoice), "Miscellaneous")) {
            //code for misc room
            System.out.println("Insert misc room description here.");
            levelTwo();
        }

        if (Objects.equals(doors.get(doorChoice), "Enemy One")) {

            //setting and fight code for enemyThree

            if (enemyThree.getHp() <= 0) {
                keyPieces += 1;
                levelTwoDoors.remove(doorChoice);
            } else {
                System.out.println("You died.");
            }
            if (keyPieces >= 2) {
                inventory.add("Key Two");
                keyTwo = true;
                checkPoint.pop();
            }
            levelTwo();
        }

        if (Objects.equals(doors.get(doorChoice), "Enemy Two")) {

            //setting and fight code for enemyFour

            if (enemyFour.getHp() <= 0) {
                keyPieces += 1;
                levelTwoDoors.remove(doorChoice);
            } else {
                System.out.println("You died.");
            }
            if (keyPieces >= 2) {
                inventory.add("Key Two");
                keyTwo = true;
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

        boolean keyThree = false;
        int keyPieces = 0;

        enemy enemyFive = new enemy("Minotaur", 50, 1);
        enemy enemySix = new enemy("Big Minotaur", 60, 1);
        boss bossThree = new boss("Cyclops", 150, false);

        if (checkPoint.peek() == 1) {
            enemyFive.setHp(0);
            enemySix.setHp(0);
            keyPieces = 2;
        }

        for (Integer levelThreeDoor : levelThreeDoors) {
            System.out.print(doors.get(levelThreeDoor) + "   ");
        }

        System.out.println("\n");

        System.out.println("Choose a door: ");
        Scanner keyboard = new Scanner(System.in);
        int doorChoice = keyboard.nextInt();

        if (Objects.equals(doors.get(doorChoice), "Miscellaneous")) {
            //code for misc room
            System.out.println("Insert misc room description here.");
            levelThree();
        }

        if (Objects.equals(doors.get(doorChoice), "Enemy One")) {

            //setting and fight code for enemyFive

            if (enemyFive.getHp() <= 0) {
                keyPieces += 1;
                levelThreeDoors.remove(doorChoice);
            } else {
                System.out.println("You died.");
            }
            if (keyPieces >= 2) {
                inventory.add("Key Three");
                keyThree = true;
                checkPoint.pop();
            }
            levelThree();
        }

        if (Objects.equals(doors.get(doorChoice), "Enemy Two")) {

            //setting and fight code for enemySix

            if (enemySix.getHp() <= 0) {
                keyPieces += 1;
                levelThreeDoors.remove(doorChoice);
            }  else {
                System.out.println("You died.");
            }
            if (keyPieces >= 2) {
                inventory.add("Key Three");
                keyThree = true;
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

}