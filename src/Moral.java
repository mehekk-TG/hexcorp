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

    public void changeMoral(int perc, int food) {
        moralIndex += (int) ((perc/100.0 * ( (Math.random()*.5+1) * 50)) * (food/125.0 ));
    }
}