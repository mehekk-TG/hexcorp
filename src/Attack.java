public class Attack {
    boolean severity;

    public Attack(boolean severe) {
        severity = severe;
    }

    public boolean shouldAttack(int defense) {
        if (defense < 100) {
            if ((Math.random() * 101) < defense) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public int[] atk() {
        int[] statsLoss = {(int) (Math.random() * 10), (int) (Math.random() * 10), (int) (Math.random() * 10),(int) (Math.random() * 10), (int) (Math.random() * 50)};

        if (severity) {
            for (int i = 0; i < statsLoss.length; i++) {
                statsLoss[i] *= 2;
            }
        }

        return statsLoss;
    }
}
