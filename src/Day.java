
import java.util.Scanner;

public class Day {
    Food food = new Food();
    Supplies supplies = new Supplies();
    Defense defense = new Defense();
    Moral moral = new Moral();
    Soldiers sd = new Soldiers();

    StoryTell narr = new StoryTell();
    Scanner scan = new Scanner(System.in);

    private int dayNum = 1;

    public void day() {
        System.out.println("Day "+ dayNum + "\n");
        dayNum++;

        System.out.println("Food Index: "+ food.getFoodIndex());
        System.out.println("Supplies Index: " + supplies.getSupplyIndex());
        System.out.println("Defense Index: "+ defense.getDefenseIndex());
        System.out.println("Moral Index: " + moral.getMoralIndex() + "\n");

        System.out.println("Soldiers: " + sd.getNum() + "\n");

        System.out.println("How would you like to allocate your soldiers, Commander? (Put a percent w/out the sign)");

        System.out.print("Farm: ");
        int change = (int) (scan.nextInt()/100.0 * 50 + 1);
        food.changeFood(change); //TODO: replace these with calculation functions in respective classes

        System.out.print("Forage: ");
        supplies.changeSupply(scan.nextInt()* 100/sd.getNum());

        System.out.print("Guard: ");
        defense.changeDefense(scan.nextInt() * 100/sd.getNum());


        System.out.print("Moral: ");
        moral.changeMoral(scan.nextInt()*100/sd.getNum());



    }

}