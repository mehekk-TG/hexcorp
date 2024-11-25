public class Defense {
    private int defenseIndex = 50;
    private int max = 250;

    public int getDefenseIndex() {
        return defenseIndex;
    }

    public int getMax() {
        return max;
    }

    public void changeDefense(int add) {
        defenseIndex += add;
    }

    public void changeDefense(int perc, int moral) {
        defenseIndex += (int) ((perc/100.0 * ( (Math.random()*.5+1) * 50)) * (moral/125.0 ));
    }
}