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
}
