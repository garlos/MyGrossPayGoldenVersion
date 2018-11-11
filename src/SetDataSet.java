public class SetDataSet {

    public static double[][] setData(int pCount, double[][] dataSet) {
        for (int i = 0; i < pCount; i++) {
            dataSet[i][0] = Rand.intRandom(1, 3);
            dataSet[i][1] = Rand.dblRandom(100, 200);
            dataSet[i][2] = Rand.dblRandom(0, 50);
            dataSet[i][3] = Rand.dblRandom(70, 100);
        }
        return dataSet;
    }
}
