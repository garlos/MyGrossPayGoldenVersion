public class SetDataSet {

    public static int[][] setData(int pCount, int[][] dataSet) {
        for (int i = 0; i < pCount; i++) {
            dataSet[i][0] = Rand.intRandom(1, 3)* 33;
            dataSet[i][1] = Rand.intRandom(100, 200);
            dataSet[i][2] = Rand.intRandom(0, 50);
            dataSet[i][3] = Rand.intRandom(70, 100);
        }
        return dataSet;
    }
}
