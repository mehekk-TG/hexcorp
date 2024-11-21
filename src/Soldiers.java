public class Soldiers {
    private int soldierNum = 2000;
    private int soldierGoal = 5000;

    public int getSoldierGoal()
    {
        return soldierGoal;
    }

    public int getNum() {
        return soldierNum;
    }

    public void changeSoldiers(int add) {
        soldierNum += add;
    }
}
