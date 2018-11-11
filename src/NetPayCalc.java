public class NetPayCalc {

    final double STANDARD = 40;
    double rate = 0;


    public double netPayCalc(int staffType, int hours, int exHours, int workQuality) {

        double exPay=0;
        double netPay;

        if (staffType == 1) {
            rate = 1.6;
        } else if (staffType == 2) {
            rate = 2.2;
        } else if (staffType == 3) {
            rate = 3.1;
        }


        if ((hours >= 130) && ((exHours >= (hours*(25/100))) || (exHours >= 40))) {
            netPay = (STANDARD * rate) + ((hours - exHours - STANDARD) * (rate * 1.5));
        } else {
            netPay = STANDARD * rate + (exHours * (STANDARD*0.7));
        }

        if ((workQuality >= 80) || exHours >= 20) {
            exPay = netPay * (30/100);

        }

        netPay += netPay + exPay;

        return netPay;
    }


}
