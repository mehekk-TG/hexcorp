import java.util.Scanner;

public class StoryTell {
    Scanner scan = new Scanner(System.in);
    Soldiers sd = new Soldiers();

    // Method to display text and wait for user to press Enter
    public void storyBland(String text) {
        System.out.println(text); // Print text
        scan.nextLine();
    }

    // Method to display a prompt with choices and return the user's selection
    public int story(String text, String[] choices) {
        System.out.println(text);

        // Print the choices with numbering
        for (int i = 1; i <= choices.length; i++) {
            System.out.print(i + ". ");
            System.out.println(choices[i - 1]);
        }

        System.out.println(); // Add a blank line for better readability
        return scan.nextInt(); // Get the user's choice
    }

    public void tutorial() {
        System.out.println("This game is a turn-based resource management game where you need to get at least " + sd.getSoldierGoal() +"\n to kick Hexcorp's butt! To do this, you must manage four indexes, which are: ");
        System.out.println("1. Food");
        System.out.println("2. Supplies");
        System.out.println("3. Defense");
        System.out.println("4. Moral\n");

        System.out.println("The consequences of letting any of these get low could be fatal!");
        System.out.println("Food:\n- Decreases moral\n- Increases desertion risk\n");
        System.out.println("Supplies:\n- Decreases defense\n- Prevents raiding if too low\n");
        System.out.println("Defense:\n- Increase risk of attacks\n- Reduces success of raids\n");
        System.out.println("Moral:\n- Reduces effectiveness of soldiers\n");

        System.out.println("To raise your stats, you have the ability to assign your soldiers to various tasks:");
        System.out.println("- Farm --> Food");
        System.out.println("- Forage --> Supplies, Food");
        System.out.println("- Guard --> Defense, Soldiers");
        System.out.println("- Raid --> Soldiers, Food, Supplies, Moral\n");
        System.out.println("Leftover soldiers will Rest, which increases Moral\n");

        System.out.println("Raiding is risky! If you lose, you'll lose at least 25% of deployed soldiers and your\nMoral will drop! Make sure to take into account your Defense and Moral before raiding!\nThe bases you can raid will vary from day to day, with variations in their numbers,\nthe supplies they have, and their aggressiveness.\n");

        System.out.println("Last but not least, random events may occur. Some of these require you to make a choice,\nwhich will affect your stats accordingly. Attacks from Hexcorp can also happen, so make\nsure to keep your Defense high to reduce and prevent them from happening.\n");

        System.out.println("That's all! Do your best, Commander!");
        scan.nextLine();
    }


}
