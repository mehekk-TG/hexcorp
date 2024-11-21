public class Moral {
    private int moralIndex = 50;
    private int max = 250;

    public int getMoralIndex() {
        return moralIndex;
    }

    public int getMax() {
        return max;
    }

    public void changeMoral(int add) {
        moralIndex += add;
    }
}