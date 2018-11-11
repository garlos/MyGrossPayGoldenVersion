public class SetDataSet {


    public static double[][] setData(int count, double[][] dataSet) {
        //double[][] dataSet = new double[0][3];
        for (int i = 0; i <= count; i++) {
            dataSet[i][1] = 1.0;
            dataSet[i][2] = (((200 - 100) + 1)) + 100;
            dataSet[i][3] = (((50) + 1));
            dataSet[i][4] = (((100 - 70) + 1)) + 70;
        }
        return dataSet;
    }
}
