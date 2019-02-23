//inputs:
//	1-	staffType: 1:office		2:worker	3:Engineer
//  2-	work Hours: 100-200
//  3-	extra Hours: 0-50
//	4-	work Quality: 70-100
//outputs:
//	grossPay = netPay + rewardPay - tax - insurance


public class GrossPay {


    public static void main(String[] args) {
        double grossPay;
        double netPay;
        int personCount = 4000;
        double[][] dSet = new double[personCount][4];
        NetPayCalc netPaymentCalc = new NetPayCalc();

        dSet = SetDataSet.setData(personCount, dSet);  // set DataSet for all personCount


        for (int i = 0; i < personCount; i++) {
            System.out.print("salam");
            System.out.println("No." + (i + 1));
            System.out.println("staff type: " + dSet[i][0]);
            System.out.println("work hours: " + dSet[i][1]);
            System.out.println("ex-hours  : " + dSet[i][2]);
            System.out.println("Quality   : " + dSet[i][3]);

            netPay = netPaymentCalc.netPayCalc(dSet[i][0], dSet[i][1], dSet[i][2], dSet[i][3]);
            System.out.println("---------");
            netPay = Math.round((netPay * 100) / 100.0);
            System.out.println("Net Pay  : " + netPay);

            grossPay = Math.round((netPay - TaxCalc.taxCalc(netPay)) * 100) / 100.0;   // {{grossPay = netPay - tax}} ;
            System.out.println("Gross Pay: " + grossPay);
            System.out.println("==========================");

            BarChart barChart = new BarChart();
            barChart.barChartGenerator(grossPay, dSet, i);


        }
    }
}
