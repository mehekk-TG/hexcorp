public class Main {
    public static void main(String[] args) {
        storyTell narr = new storyTell();

        narr.storyBland("Note: press enter to progress");
        narr.storyBland("It's 20XX and some big meanies called Hexcorp have decided to take over the world using \nbrainwashing helmets!");
        narr.storyBland("However, it's okay because you are the Commander of the Faction of Passion! Your job is to\nrally enough soldiers to kick their butts!");

        String[] blah = {"Yes", "No"};
        if (narr.story("Would you like to read the instructions?", blah) == 1) {
            narr.tutorial();
        }
    }
}