public class Raid {
    private String[] aggressiveChoices = {"Low", "Medium", "High"};

    public String[] genRaid() {

        int aggIndex = (int) (Math.random() * 3);
        String aggressive = aggressiveChoices[aggIndex];
        int food = (int)(( Math.random() * 20) + 5 * (1 + (aggIndex*.25)));
        int supplies = (int)(( Math.random() * 20) + 5 * (1 + (aggIndex*.25)));

        return new String[]{aggressive, food + "", supplies + "", aggIndex + ""};
    }

    public boolean raidOutcome(int soldier, String aggIndex, int def, int moral) {
        double chance = (soldier * 2)  * ((2 - Integer.parseInt(aggIndex) *.1) + .9) * (def /100.0) * (moral/100.0);
        if (Math.random() * 101 < chance) {
            return true;
        }
        else {
            return false;
        }

    }
}
