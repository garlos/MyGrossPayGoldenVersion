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
        int personCount = 100;
        int[][] dSet = new int[personCount][4];
        NetPayCalc netPaymentCalc = new NetPayCalc();

        dSet = SetDataSet.setData(personCount, dSet);  // set DATA-SET for Person counts

        for (int i = 0; i < personCount; i++) {

            System.out.println("No." + (i + 1));
            System.out.println("staff type: " + dSet[i][0]);
            System.out.println("work hours: " + dSet[i][1]);
            System.out.println("ex-hours  : " + dSet[i][2]);
            System.out.println("Quality   : " + dSet[i][3]);

            netPay = Math.round(netPaymentCalc.netPayCalc(dSet[i][0], dSet[i][1], dSet[i][2], dSet[i][3]));
            System.out.println("---------");
            System.out.println("Net Pay  : " + netPay);

            grossPay = Math.round(netPay - TaxCalc.taxCalc(netPay));   // - tax ;
            System.out.println("Gross Pay: " + grossPay);
            System.out.println("==========================");
        }
        BarChart barChart = new BarChart();
        barChart.drawBarChart();
    }
}
