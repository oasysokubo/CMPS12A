//CongressMembers.java
//Oasys Okubo
//ookubo
//Programming Assignment 4: Sorting Approval Ratings
//This program inputs a file of congress members and 5 months of their approval 
//ratings. Then uses bubble sort to sort the congress members name in 
//alphabetical order as well as their average approval ratings from greatest to 
//lowest. Then outputs the results to a seperate file called "output.txt".

package congressmemberstest;

public class CongressMembers 
{
    //Instance variables with private access.
    private String congressMember;
    private double rate1, rate2, rate3, rate4, rate5;
    
    
    //Class constructor declaration gets data passed from CongressMembersTest class and sets the corresponding values. 
    CongressMembers(String member, String rate1, String rate2, String rate3, String rate4, String rate5) 
    {
        this.congressMember = member;
        this.rate1 = Double.parseDouble(rate1);
        this.rate2 = Double.parseDouble(rate2);
        this.rate3 = Double.parseDouble(rate3);
        this.rate4 = Double.parseDouble(rate4);
        this.rate5 = Double.parseDouble(rate5);
    }
     
    //toString() returns the formatted data of the sorted values of CongressMembers arrays. 
    @Override
    public String toString() 
    {
        String output = (this.getCongressMember() + " " + getRate1() + " " + getRate2() + " " + getRate3() + " " + getRate4() + " " + getRate5());
        return output;
    }
    
    //A method that returns the name of the congress member.
    public String getCongressMember() 
    {
        return congressMember;
    }
    
    //A method that sets the string value of congress member.
    public void setCongressMember(String name) 
    {
        congressMember = name;
    }
    
    //A method that returns rate 1.
    public double getRate1() 
    {
        return rate1;
    }
    
    //A method that sets the double value of rate 1.
    public void setRate1(double rating) 
    {
        rate1 = rating;
    }
    
    //A method that returns rate 2.
    public double getRate2() 
    {
        return rate2;
    }
    
    //A method that sets the double value of rate 2.
    public void setRate2(double rating2) 
    {
        rate2 = rating2;
    }
    
    //A method that returns rate 3.
    public double getRate3() 
    {
        return rate3;
    }
    
    //A method that sets the double value of rate 3.
    public void setRate3(double rating3) 
    {
        this.rate3 = rating3;
    }
    
    //A method that returns rate 4.
    public double getRate4() 
    {
        return rate4;
    }
    
    //A method that sets the double value of rate 4.
    public void setRate4(double rating4) 
    {
        rate4 = rating4;
    }
    
    //A method that returns rate 5.
    public double getRate5() 
    {
        return rate5;
    }
    
    //A method that sets the double value of rate 5.
    public void setRate5(double rating5) 
    {
        rate5 = rating5;
    }
    
    //A method that takes all the rates and calculates the average.
    public double getAverageRate() 
    {
        double average = (getRate1() + getRate2() + getRate3() + getRate4() + getRate5()) / 5;
        return average;
    }
}
