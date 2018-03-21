//BoardMember.java
//Oasys Okubo
//ookubo
//Program 5
//This program implements 7 classes and simulates how a company calculates
//a payroll for different types and levels of employees.

package employee;

public class BoardMember extends Employee {
    
    BoardMember(int yearsWorked) {                      //constructor
        super(yearsWorked);
    }
    
    private final double YEARLY_BONUS = 20000;          // $/year
    private final int PAID_VACATION = 20;               // days
    private final int UNPAID_VACATION = 10;             // days
    private final int SICK_LEAVE = 10;                  // days
    private final double HEALTH_INSURANCE = 20000;      //$/year
    private final double INCOME = 200000;               // $/year  
    
    private int usedUnpaidVacation;                     // keeps track of how much 
                                                        //unpaid vacation has been used. 
    
    int getUsedUnpaidVacation() {                       // getter method for usedUnpaidVacation
        return usedUnpaidVacation;
    }
    
    void setUsedUnpaidVacation(int usedUnpaidVacation) {// setter method for usedUnpaidVacation
        this.usedUnpaidVacation = usedUnpaidVacation;
    }
    
    private int usedVacation;                           // keeps track of how much paid vacation 
                                                        // has been used.
    
    int getUsedVacation() {                             // getter method for usedVacation
        return usedVacation;
    }
    
    void setUsedVacation(int usedVacation) {            // setter method for usedVacation
        this.usedVacation = usedVacation;   
    }
                                            
    private int usedSickDays;                           // keeps track of how many sick days 
                                                        // have been used.
    
    int getUsedSickDays() {                             // getter method for usedSickDays
        return usedSickDays;
    }
    
    void setUsedSickDays(int usedSickDays) {            // setter method for usedSickDays
        this.usedSickDays = usedSickDays;
    }
    
    void usePaidVacation() {                            // adds one to
        usedVacation++;                                 // usedVacation
    }
        
    void useUnpaidVacation() {                          // adds one to
        usedUnpaidVacation++;                           // usedUnpaidVacation
    }
                                                      
    void useSickDay() {                                 // adds one to usedSickDays
        usedSickDays++;
    }
                         
    void workYear() {                                   // adds one to yearsWorked.
        super.setYears(super.getYears() + 1);
    }
    
    @Override
    double YTDValue() {
        return ((YEARLY_BONUS + HEALTH_INSURANCE + INCOME) + 
                (PAID_VACATION * (INCOME / 260)) + 
                ((SICK_LEAVE - usedSickDays) * ((INCOME / 260) / 2)));
    } 
        // overridden from Employee class. YTDValue() is calculated by taking the sum of:
        // YEARLY_BONUS
        // HEALTH_INSURANCE
        // INCOME
        // PAID_VACATION * (INCOME / 260)
        // (SICK_LEAVE – usedSickDays) * ((INCOME / 260) / 2) */
    
    
    @Override
    int yearsTillRetirement() {
        int calculateYearsTillRetirement = (int)(Math.round(((((float)35 - ((float)super.getYears() + 
                                               ((float)usedUnpaidVacation / 260) + 
                                               (((float)usedVacation / 260) * 2) + ((float)usedSickDays / 260)))))));
        
        return calculateYearsTillRetirement;
        
    } 
        // overridden from Employee class. This should be rounded up to the nearest int. 
        // The calculation should take place as floating point arithmetic to ensure precision 
        // (hint: cast as double where necessary). This number should not be below zero. 
        // This is calculated by: 35 – (yearsWorked + (usedUnpaidVacation / 260) + ((usedVacation / 260) * 2) + 
        // (usedSickDays / 260)) */
    
}
