public class Supplies {
    private int supplyIndex = 50;
    private int max = 250;

    public int getSupplyIndex() {
        return supplyIndex;
    }

    public int getMax() {
        return max;
    }

    public void changeSupply(int add) {
        supplyIndex += add;
    }

    public void changeSupply(int perc, int moral) {
        supplyIndex += (int) ((perc/100.0 * ( (Math.random()*.5+1) * 50)) * (moral/125.0 ));
    }


}
