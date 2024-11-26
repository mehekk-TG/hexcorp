public class Main {
    public static void main(String[] args) {
        StoryTell narr = new StoryTell();
        Day d = new Day();

        boolean win = false;
        boolean lose = false;


        narr.storyBland("Note: Press enter to progress");
        narr.storyBland("It's 20XX and some big meanies called Hexcorp have decided to take over the world using \nbrainwashing helmets!");
        narr.storyBland("However, it's okay because you are the Commander of the Faction of Passion! Your job is to\nrally enough soldiers to kick their butts!");

        String[] blah = {"Yes", "No"};
        if (narr.story("Would you like to read the instructions?", blah) == 1) {
            narr.tutorial();
        }


        while (!win && !lose) {
            boolean[] __ = d.day();
            win = __[0];
            lose = __[1];

        }
    }
}