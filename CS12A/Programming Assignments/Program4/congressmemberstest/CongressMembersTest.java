//CongressMembersTest.java
//Oasys Okubo
//ookubo
//Programming Assignment 4: Sorting Approval Ratings
//This program inputs a file of congress members and 5 months of their approval 
//ratings. Then uses bubble sort to sort the congress members name in 
//alphabetical order as well as their average approval ratings from greatest to 
//lowest. Then outputs the results to a seperate file called "output.txt".

package congressmemberstest;

import java.util.*;
import java.io.*;

public class CongressMembersTest 
{
    public static void main(String[] args) 
    {    
        //Initialized a new class object
        CongressMembers[] congressmembers = new CongressMembers[53];
        
        //This try-catch imports text file data from "approval.txt", then each line is seperated by the split(), then the for loop gets the splitted data and
        //the sends them over to the class constructor to its corresponding index value. 
        try 
        {
            int c = 0;
            Scanner scnr = new Scanner(new File("approval.txt"));
            while(scnr.hasNextLine()) 
            {
               String data = scnr.nextLine();
               String[] data1 = data.split("\\s+");
               for(int x = 0; x < data1.length; x += 7)
               {
                   congressmembers[c] = new CongressMembers(data1[x] + " " + data1[x + 1], data1[x + 2], data1[x + 3], data1[x + 4], data1[x + 5], data1[x + 6]);
               }
               c++;
            } 
            scnr.close();
            
            
            //This nested try-catch sends the data from the program to a new text file called "output.txt" and outputs the sorted arrays of congress members.
            //Within this try-catch, the two methods are called from their corresponding placements.
            try 
            {
                PrintWriter print = new PrintWriter(new FileWriter("output.txt"));
                print.println("Number of Congress Members: "+c);
                //Calls sortByFirstName method, which returns the sorted data to sortedName.
                CongressMembers[] sortedName = sortByFirstName(congressmembers);
                print.println("");
                print.println("Sorted Alphabetically:");
                print.println("");
                for(int x = 0; x < sortedName.length; x++) 
                {
                    print.println(sortedName[x].toString());
                }
                
                print.println("");
                //Calls sortByApprovalRating method, which returns the sorted data to sortedRate.
                CongressMembers[] sortedRate = sortByApprovalRating(congressmembers);
                print.println("Sorted by Approval Rate:");
                print.println("");
                for(int x = 0; x < sortedRate.length; x++) 
                {
                    print.println(sortedRate[x].toString());
                }
                print.close();
            }
            
            catch(IOException e) 
            {
                System.out.println("File error!");
            }
            
        }
        
        catch(FileNotFoundException e) 
        {
            System.out.println("File not found!");
            System.exit(0);
        }  
    }    
    
    //This sortByFirstName() method sorts the data in alphabetical order. 
    public static CongressMembers[] sortByFirstName(CongressMembers[] name) 
    {
        CongressMembers name1;
        for(int x = 0; x < name.length; x++) 
        {
            for(int y = 0; y < name.length - x - 1; y++) 
            {
                if(name[y + 1].getCongressMember().compareTo(name[y].getCongressMember()) < 0) 
                {
                    name1 = name[y];
                    name[y] = name[y + 1];
                    name[y + 1] = name1;
                }
                
            }
        }
        return name;
        
    }
    
    //This sortByApprovalRating() method sorts the data in terms of greatest to lowest average approval rating.
    public static CongressMembers[] sortByApprovalRating(CongressMembers[] approvalRate) 
    {
        CongressMembers rate1;
        for(int x = 0; x < approvalRate.length; x++) 
        {
            for(int y = 0; y < approvalRate.length - x - 1; y++) 
            {
                if(approvalRate[y+1].getAverageRate() > approvalRate[y].getAverageRate()) 
                {
                    rate1 = approvalRate[y];
                    approvalRate[y] = approvalRate[y + 1];
                    approvalRate[y + 1] = rate1;
                }
                
            }
        }
        return approvalRate;
    }

}
