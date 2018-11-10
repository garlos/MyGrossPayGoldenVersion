public class NetPayCalc {

    final double STANDARD = 40;
    final double RATE = 35.265;
    double staffType, hours, exHours, workQuality;
    double pay, exPay;

    public double netPayCalc() {

        if (exHours > 1) {
            exPay = exHours * (STANDARD * 2);
        } else {
            exHours = 0.0;
            exPay = 0.0;
        }


        if (hours > STANDARD) {
            pay = (STANDARD * RATE) + ((hours - dbTimeHours - STANDARD) * (RATE * 1.5)) + dbTimePay;
        } else {
            pay = STANDARD * RATE;
        }
        return pay;
    }


}
