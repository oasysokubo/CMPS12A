//Intern.java
//Oasys Okubo
//ookubo
//Program 5
//This program implements 7 classes and simulates how a company calculates
//a payroll for different types and levels of employees.

package employee;

public class Intern extends Employee {
    
    Intern(int yearsWorked) {                       // constructor
        super(yearsWorked);
    }                    
    
    private final int UNPAID_VACATION = 10;                 // days
    private final double HEALTH_INSURANCE = 5000;           // $/year 
    private final double INCOME = 40000;                    // $/year
    
    private int usedUnpaidVacation;                         // keeps track of how much
                                                            //unpaid vacation has been used.
    
    int getUsedUnpaidVacation() {                           //getter method for getUsedUnPaidVacation
        return usedUnpaidVacation;
    }
    
    void setUsedUnPaidVacation(int usedUnpaidVacation) {    //setter method for getUsedUnPaidVacation
        this.usedUnpaidVacation = usedUnpaidVacation;
    }
    
    void useUnpaidVacation() {                              // adds one to // usedUnpaidVacation
            usedUnpaidVacation++;
    }                       
    
    void workYear() {                                       // Adds one to yearsWorked.
        super.setYears(super.getYears() + 1);
    }                                 
    
    @Override
    double YTDValue() {
        return (HEALTH_INSURANCE + INCOME);
    }
        /* Overridden from Employee class. This is calculated by taking the sum of:
        HEALTH_INSURANCE
        INCOME */
    
    @Override
    int yearsTillRetirement() {
        int yearsTillRetirement = (int)(Math.round((((float)35 - ((float)super.getYears() + 
                ((float)usedUnpaidVacation / 260))))));
        
        return yearsTillRetirement;
    } 
    /* Overridden from Employee class. This should be rounded up to the nearest int. 
    The calculation should take place as floating point arithmetic to ensure precision 
    (hint: cast as double where necessary). This is calculated by: 35 – (yearsWorked + 
    (usedUnpaidVacation / 260)) */
}
