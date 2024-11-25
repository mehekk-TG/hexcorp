public class Food {
    private int foodIndex = 50;
    private int max = 250;

    public int getFoodIndex() {
        return foodIndex;
    }

    public int getMax() {
        return max;
    }

    public void changeFood(int add) {
        foodIndex += add;
    }

    public void changeFood(int perc, int moral) {
        foodIndex +=(int) ((perc/100.0 * ( (Math.random()*.5+1) * 50)) * (moral/125.0 ));
    }
}