
import java.util.Scanner;
import java.text.NumberFormat;

public class GrossPay {
	public static void main(String[] args) {
		
		final double STANDARD = 40;
		final double RATE = 35.265;
		double hours, pay, dbTimeHours, dbTimePay;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the number of hours you worked: ");
		hours = in.nextDouble();
	
		System.out.print("Where any of these hours Double Time? [y or n] ");
		String dbTime = in.next().toLowerCase();
		if (dbTime.equals("y")) {
			System.out.print("Enter the number of Double Time hours: ");
			dbTimeHours = in.nextDouble();
			dbTimePay = dbTimeHours * (STANDARD * 2);
		}
		else{
			dbTimeHours = 0.0;
			dbTimePay = 0.0;
		}
		
		System.out.println();
		
		if (hours > STANDARD){
			pay = (STANDARD * RATE) + ((hours - dbTimeHours - STANDARD) * (RATE * 1.5)) + dbTimePay;
		}
		else {
			pay = STANDARD * RATE;
		}
			
		
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		System.out.println("Gross Pay: " + fmt.format(pay));
	}
}
