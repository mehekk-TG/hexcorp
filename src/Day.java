
import java.util.Scanner;

public class Day {
    Food food = new Food();
    Supplies supplies = new Supplies();
    Defense defense = new Defense();
    Moral moral = new Moral();
    Soldiers sd = new Soldiers();

    StoryTell narr = new StoryTell();
    Raid raid = new Raid();

    Scanner scan = new Scanner(System.in);

    private int dayNum = 1;
    private int percentLeft = 100; //USED TO MAKE SURE PLAYER DOESN'T OVERSTATE


    public void day() {
        percentLeft = 100;

        dayNum();
        stats();

        //RAID
        System.out.println("Would you like to raid?:");
        String[] todayRaid = raid.genRaid();

        System.out.println("Aggressiveness: " + todayRaid[0]);
        System.out.println("Food: " + todayRaid[1]);
        System.out.println("Supplies: " + todayRaid[2]);

        String[] __ = {"Yes", "No"};
        narr.story("", __);

        //ALLOCATE SOLDIERS
        System.out.println("How would you like to allocate your soldiers, Commander? (Put a percent w/out the sign)");

        System.out.print("Farm: ");
        int change = (int) (scan.nextInt()/100.0 * 50 + 1);
        food.changeFood(change); //TODO: replace these with calculation functions in respective classes

        System.out.print("Forage: ");
        supplies.changeSupply(scan.nextInt()* 100/sd.getNum());

        System.out.print("Guard: ");
        defense.changeDefense(scan.nextInt() * 100/sd.getNum());
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
            System.out.print("How many soldiers would you like to deploy?: ");
            int percRaid = scan.nextInt();

            while (percRaid > percentLeft || percRaid < 10) {
                System.out.println("Invalid Input");
                System.out.print("How many soldiers would you like to deploy?: ");
                percRaid = scan.nextInt();
            }



        }

    }

}