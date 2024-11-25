
import java.io.Serial;
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


    public void day() {
        percentLeft = 100;

        dayNum();
        stats();
        //raid();
        allocate();

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
            moral.changeMoral((int)(Math.random() * 20 + 10));

            stats();
            }
        }
    }

    public void allocate() {
        System.out.println("How would you like to allocate your soldiers, Commander? (Put a percent w/out the sign)");

        food.changeFood(getPerc("Farm"));

        supplies.changeSupply(getPerc("Forage"));

        defense.changeDefense(getPerc("Guard"));

        moral.changeMoral(percentLeft/2);
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

    public void attk() {

    }

}