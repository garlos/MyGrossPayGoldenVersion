import java.text.DecimalFormat;

public class SetDataSet {

    public static double[][] setData(int pCount, double[][] dataSet) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        for (int i = 0; i < pCount; i++) {
            dataSet[i][0] = Math.round(Rand.intRandom(1, 3) * 100) / 100.0;          //staff type
            dataSet[i][1] = Math.round(Rand.dblRandom(151, 200) * 100) / 100.0;      //work hour
            dataSet[i][2] = Math.round(Rand.dblRandom(1, 50) * 100) / 100.0;         //ex- hour
            dataSet[i][3] = Math.round(Rand.dblRandom(71, 90) * 100) / 100.0;        //quality
        }
        return dataSet;
    }
}
