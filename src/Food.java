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
}