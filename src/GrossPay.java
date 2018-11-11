
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
        double[][] dSet = new double[0][0];
        int personCount = 10;

        dSet = SetDataSet.setData(personCount, dSet);

        NetPayCalc netPaymentCalc = new NetPayCalc();
        for (int i = 1; i <= 10; i++) {
            grossPay = netPaymentCalc.netPayCalc(dSet[i][1], dSet[i][2], dSet[i][3], dSet[i][4]);
            System.out.print(grossPay);
        }
    }
}
