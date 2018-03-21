//Payroll.java
//Oasys Okubo
//ookubo
//Program 5 
//This program implements 7 classes and simulates how a company calculates
//a payroll for different types and levels of employees.

package employee;

public class Payroll {
    
    private Employee[] employees;                   // array of x Employee objects.
                                                    
    Payroll(int x) {                                // Constructor
        employees = new Employee[x];
    }
    
    void setEmployees(Employee[] x) {               // setter method for employee class object.
        this.employees = x;
    }
    
    Employee[] getEmployees() {                     // getter method for employee class object.
        return employees;
    }
    
    void sortEmployeesByRetirement() {              
        Employee temp;
        Employee[] yearsTillRetirement = employees;
        
        for(int i = 0; i < employees.length; i++) {
            for(int z = 0; z < employees.length - i - 1; z++) {
                if(yearsTillRetirement[z].yearsTillRetirement() > yearsTillRetirement[z + 1].yearsTillRetirement()) {
                    temp = yearsTillRetirement[z];
                    yearsTillRetirement[z] = yearsTillRetirement[z + 1];
                    yearsTillRetirement[z + 1] = temp;
                }
            }
        }
    } 
    /* sort employees in descending order of when the employee will retire. 
    Employees retiring the soonest will go at the beginning of the array. */
    
    void sortEmployeesByCost() {                      
        Employee temp;
        Employee[] YTDValue = employees;
        
        for(int i = 0; i < employees.length; i++) {
            for(int z = 0; z < employees.length - i - 1; z++) {
                if(YTDValue[z].YTDValue() < YTDValue[z + 1].YTDValue()) {
                    temp = YTDValue[z];
                    YTDValue[z] = YTDValue[z + 1];
                    YTDValue[z + 1] = temp;
                }
            }
        }
    }
    /* sort employees in descending order of the YTDValue() of each employee. 
    Employees having the lowest YTDValue() will go at the beginning of the array. */
}
