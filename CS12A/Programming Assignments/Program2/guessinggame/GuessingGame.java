//GuessingGame.java
//Oasys Okubo
//ookubo
//Program 2 - Number Guessing Game
//This program gives you 3 chances to guess the right number (1-10) and 
//tells you whether to go up or down in value.

package guessinggame;
import java.util.Scanner;
public class GuessingGame {
    public static void main(String[] args) {
        int numTries = 0;
        int success = 0;
        Scanner scnr = new Scanner(System.in);
        int randomNumber = (int)((Math.random()*10)+1);
        System.out.println("Welcome to number guessing game. What is your name?");
        String name = scnr.next();
        System.out.println("");
        System.out.println("I'm thinking of an integer between 1 and 10. You have 3 guesses.");
        System.out.println("");
        
        while(success == 0 && numTries<3){
        numTries++;
        if(numTries == 1)
        {
        System.out.print("Your first guess: ");
        }
        if(numTries == 2)
        {
        System.out.print("Your second guess: ");
        }
        if(numTries == 3)
        {
        System.out.print("Your third guess: ");
        }
        double guess = scnr.nextDouble();
        if(guess == randomNumber && numTries>1){
            success++;
            System.out.println("Congratulations "+name+"! You won in "+(numTries)+" guesses.");
        }
        else if(guess==randomNumber && numTries==1){
            System.out.println("Congratulations "+name+"! You won in "+(numTries)+" guess.");
            ++success;
        }
        else if(guess>randomNumber && numTries<3){
            System.out.println("Too high, guess lower.");
            System.out.println("");
        }
        else if(guess<randomNumber && numTries<3){
            System.out.println("Too low, guess higher.");
            System.out.println("");
        }
        else if(numTries == 3){
            System.out.println("Game over "+name+", you lose.");
        }
        }
    }
}
