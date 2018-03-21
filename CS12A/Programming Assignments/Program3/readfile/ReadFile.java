//ReadFile.java
//Oasys Okubo
//ookubo
//Program 3 - Data Analysis
//This program imports a text file with the amount of rainfall (inches) from 1849
//to 2016 and puts them in an array, then calculates the average, the highest, and
//the lowest amount of rainfall. 
package readfile;
import java.util.*;
import java.io.*;
import java.text.*;
public class ReadFile 
{
    public static Scanner scnr = new Scanner(System.in);
    public static void main(String[] args) 
    { 
        String input = "";
        double[] rainfall = populateArray();
        
        while(input != "quit")
        {
            System.out.println("Enter the option \"average\", \"highest\", \"lowest\":");
            input = scnr.next();
      
            //If user enters, "highest", a method is called and returns an integer, then it displays the highest amount of rainfall.
            if(input.equals("highest"))
            {
                int highYear = findHighestYearIndex(rainfall);
                System.out.println("Highest rainfall since 1849: " +rainfall[highYear]+ " inches which occured during year " +(1849+highYear));
                System.out.println();
            }
        
            //If user enters, "lowest", a method is called and returns an integer, it displays the lowest amount of rainfall. 
            if(input.equals("lowest"))
            {
                int lowYear = findLowestYearIndex(rainfall);
                System.out.println("Lowest rainfall since 1849: " +rainfall[lowYear]+ " inches which occured during year " +(1849+lowYear));
                System.out.println();
            }
        
            //Formatted average output with 2 decimal places, user enters "average", method is called and returns a double value.
            DecimalFormat format = new DecimalFormat(".##");
            if(input.equals("average"))
            {
                double average = findAverage(rainfall);
                System.out.println("Average rainfall since 1849: " +format.format(average)+ " inches");
                System.out.println();
            }
        
            //Anything else other than the required inputs will output, "Invalid input".
            if(!(input.equals("highest") || input.equals("lowest") || input.equals("average") || input.equals("quit")))
            {
                System.out.println("Invalid input");
                System.out.println();
            }
        
            //Program is terminated when user input is "quit".
            if(input.equals("quit"))
            {
                System.out.println("Program done.");
                System.exit(0);
            }
        
        }
    }
    
    //This method imports the "rainfall.txt" file and puts the values into an array, then returns the array.
    public static double[] populateArray()
    {
        double[] rainfall = new double[168]; 
        int i = 0;
        
        try
        {
            Scanner data = new Scanner(new File("rainfall.txt"));
            while(data.hasNextDouble())
            {
                rainfall[i] = data.nextDouble();
                i++;
            }
        }
        
        catch(FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
         
        return rainfall;
    }
    
    //This method calculates the highest amount of rainfall in San Fransisco and returns the index as an integer.
    public static int findHighestYearIndex(double[] rainfall)
    {
        double max = rainfall[0];
        int highest = 0;
        for(int i = 1; i < (rainfall.length - 1); i++)
        {
            if(rainfall[i] > max)
            {
                max = rainfall[i];
                highest = i;
            }
        }
        return highest;
    }
    
    //This method calculates the lowest amount of rainfall and returns the index as an integer.
    public static int findLowestYearIndex(double[] rainfall)
    {
        int lowest = 0;
        double min = rainfall[rainfall.length - 1];
        
        for(int i = (rainfall.length - 1); i > 0; i--)
        {
            if(rainfall[i] < min)
            {
                min = rainfall[i];
                lowest = i;
            }
        }
        
        return lowest;
    }
    
    //Calculates the average of all rainfalls from every year and returns an average. 
    public static double findAverage(double[] rainfall)
    {
        double average = 0;
        double sum = 0;
        
        for(int i = 0; i < rainfall.length; i++)
        {
            sum += rainfall[i];
        }
        
        average = sum / rainfall.length;
        return average;
    }
}
