public class Raid {
    public String[] genRaid() {
        String[] aggressiveChoices = {"Low", "Medium", "High"};
        int aggIndex = (int) (Math.random() * 3);
        String aggressive = aggressiveChoices[aggIndex];
        int food = (int)(( Math.random() * 20) + 5 * (1 + (aggIndex*.25)));
        int supplies = (int)(( Math.random() * 20) + 5 * (1 + (aggIndex*.25)));

        return new String[]{aggressive, food + "", supplies + ""};
    }
}
