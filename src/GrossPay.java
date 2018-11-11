
import java.util.Scanner;
import java.text.NumberFormat;


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
        int personCount = 10;
        double[][] dSet = new double[personCount][4];
        NetPayCalc netPaymentCalc = new NetPayCalc();

        dSet = SetDataSet.setData(personCount, dSet);  // set DATA-SET for Person counts

        for (int i = 0; i < personCount; i++) {
            grossPay = netPaymentCalc.netPayCalc(dSet[i][0], dSet[i][1], dSet[i][2], dSet[i][3]);
            System.out.println(grossPay);
        }
        System.out.println("###################################");
        for (int i = 0; i < personCount; i++) {

            System.out.println(dSet[i][0]);
            System.out.println(dSet[i][1]);
            System.out.println(dSet[i][2]);
            System.out.println(dSet[i][3]);
            System.out.println("---------------------------");
        }
    }
}
