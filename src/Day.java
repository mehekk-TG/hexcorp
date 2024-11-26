
import java.util.Scanner;

public class Day {
    Food food = new Food();
    Supplies supplies = new Supplies();
    Defense defense = new Defense();
    Moral moral = new Moral();
    Soldiers sd = new Soldiers();

    StoryTell narr = new StoryTell();
    Raid raid = new Raid();
    Attack attack = new Attack(true);
    Attack kidtack = new Attack(false);

    Scanner scan = new Scanner(System.in);

    private int dayNum = 1;
    private int percentLeft = 100; //USED TO MAKE SURE PLAYER DOESN'T OVERSTATE


    public boolean[] day() {
        percentLeft = 100;

        dayNum();
        stats();

        if (supplies.getSupplyIndex() > 25) {
            raid();
        }
        else {
            narr.storyBland("You don't have enough to raid today.");
        }
        allocate();
        attk();
        desert();

        return endCheck();
    }

    public void dayNum() {
        System.out.println("Day "+ dayNum + "\n");
        dayNum++;
    }

    public void stats() {
        System.out.println("Food Index: "+ food.getFoodIndex());
        System.out.println("Supplies Index: " + supplies.getSupplyIndex());
        System.out.println("Defense Index: "+ defense.getDefenseIndex());
        System.out.println("Moral Index: " + moral.getMoralIndex() + "\n");

        System.out.println("Soldiers: " + sd.getNum() + "\n");
        scan.nextLine();
    }

    public void raid() {
        System.out.println("Would you like to raid?:"); //ASKING IF WANT TO RAID
        String[] todayRaid = raid.genRaid();

        System.out.println("Aggressiveness: " + todayRaid[0]);
        System.out.println("Food: " + todayRaid[1]);
        System.out.println("Supplies: " + todayRaid[2]);

        String[] __ = {"Yes", "No"};

        if (narr.story("", __) == 1) { // CHOICE
            System.out.print("What percent of soldiers would you like to deploy?: ");
            int percRaid = scan.nextInt();

            while (percRaid > percentLeft || percRaid < 10) {
                System.out.println("Invalid Input");
                System.out.print("What percent of soldiers would you like to deploy?: ");
                percRaid = scan.nextInt();
            }

            percentLeft -= percRaid;

        if (raid.raidOutcome(percRaid, todayRaid[3], defense.getDefenseIndex(), moral.getMoralIndex())) { //OUTCOME: WIN
            System.out.println("Success!\n");

            food.changeFood(Integer.parseInt(todayRaid[1]));
            supplies.changeSupply(Integer.parseInt(todayRaid[2]));
            moral.changeMoral((int) (Math.random() * 10 + 1) * (Integer.parseInt(todayRaid[3]) + 1));
            sd.changeSoldiers((int) (Math.random() * 100 + 25) * (1 + Integer.parseInt(todayRaid[3])));

            stats();
        }
        else {
            System.out.println("Fail!\n");

            sd.changeSoldiers(-1* (int)(percRaid/400.0 * sd.getNum()));
            moral.changeMoral(-1*(int)(Math.random() * 20 + 10));

            stats();
            }
        }
    }

    public void allocate() {
        System.out.println("How would you like to allocate your soldiers, Commander? (Put a percent w/out the sign)");

        food.changeFood(getPerc("Farm"));

        supplies.changeSupply(getPerc("Forage"));

        defense.changeDefense(getPerc("Guard"));

        moral.changeMoral(percentLeft, food.getFoodIndex());
    }

    public void attk() {
        if (kidtack.shouldAttack(defense.getDefenseIndex())) {
            System.out.println("You got attacked!");

            int[] damage = kidtack.atk();
            food.changeFood(-1*damage[0]);
            supplies.changeSupply(-1*damage[1]);
            defense.changeDefense(-1*damage[2]);
            moral.changeMoral(-1*damage[3]);
            sd.changeSoldiers(-1*damage[4]);

            stats();
        }


        else if (attack.shouldAttack(defense.getDefenseIndex()) && attack.shouldAttack(defense.getDefenseIndex())) {
            System.out.println("You got attacked! (And it was pretty bad...)");

            int[] damage = attack.atk();
            food.changeFood(-1*damage[0]);
            supplies.changeSupply(-1*damage[1]);
            defense.changeDefense(-1*damage[2]);
            moral.changeMoral(-1*damage[3]);
            sd.changeSoldiers(-1*damage[4]);

            stats();
        }


    }

    public void desert() {
        if (Math.random() * 100 > (food.getFoodIndex()*moral.getMoralIndex())/100.0) {
            sd.changeSoldiers(-50);
            narr.storyBland("50 soldiers left because of a lack of food or moral!");

        }
    }

    public boolean[] endCheck() {
        if (sd.getNum() > 5000) {
            System.out.println("Wowzers! You got enough soldiers to beat Hexcorp and capture it's CEO (who was your long-lost sister btw)");
            System.out.println("Good job :)");
            return new boolean[] {true, false};
        }
        else if (sd.getNum() < 1000) {
            System.out.println("Oh, you lost too many soldiers and got cooked by Hexcorp. Also the CEO was your long-lost sister");
            System.out.println("Bad Commander! >:(");
            return new boolean[] {false, true};
        }
        else {
            return new boolean[] {false, false};
        }
    }

    public int getPerc(String prompt) {
        System.out.print(prompt + ": ");
        int perc = scan.nextInt();
        while (!(perc <= percentLeft && perc > -1)) {
            System.out.print(prompt + ": ");
            perc = scan.nextInt();
        }
        percentLeft -= perc;
        return perc;
    }



}