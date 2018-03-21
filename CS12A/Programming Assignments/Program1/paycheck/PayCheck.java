// PayCheck.java
// Oasys Okubo
// ookubo
// Program 1 - Paycheck Calculator
// This program asks to input your hourly pay rate as well as the number of
// hours worked within a week to calculate your weekly paycheck.

package paycheck;
import java.util.Scanner;
public class PayCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter total hours worked Monday through Sunday: ");
        double hours = input.nextDouble();
        Scanner input3 = new Scanner(System.in);
        System.out.print("Please enter you hourly pay rate in dollars: $");
        double payrate = input3.nextDouble();
        
        if (hours > 40){
            double overTimerate = (hours - 40);
            double overTimepayrate = (payrate * 1.5);
            double semiCalculations = (overTimerate * overTimepayrate);
            double finalCalculations = (semiCalculations + (40 * payrate));
            System.out.print("Your paycheck for this week is $");
            System.out.println(finalCalculations);
        }
        else if (hours <= 40){
            double lessthanaverage = (payrate * hours);
            System.out.print("Your paycheck for this week is $");
            System.out.println(lessthanaverage);
        }
    }
    
}
