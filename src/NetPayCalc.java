public class NetPayCalc {

    final double STANDARD = 40;
    double rate = 0;


    public double netPayCalc(double staffType, double hours, double exHours, double workQuality) {

        double exPay, netPay;

        if(staffType == 1){
            rate = 32.5;
        } else if(staffType == 2) {
            rate = 40.7;
        } else if(staffType == 3) {
            rate = 52;
        }

        if (exHours >= 20) {
            exPay = exHours * (STANDARD * 2);
        } else {
            exHours = 0.0;
            exPay = 0.0;
        }

        if ((hours >= 150) && (workQuality >= 85)) {
            netPay = (STANDARD * rate) + ((hours - exHours - STANDARD) * (rate * 1.5)) + exPay;
        } else {
            netPay = STANDARD * rate;
        }


        return netPay;
    }


}
