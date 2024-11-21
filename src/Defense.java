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
}