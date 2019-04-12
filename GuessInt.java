import java.util.Scanner;
import java.util.Random;
/**
 * Write a description of class GuessInt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuessInt
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random generator = new Random();
        
        int num, guess, attempt, difficulty;
        int[] guesses = new int[100];
        boolean[] directions = new boolean[100];
        boolean run = true;
        char answer;
        
        while (run) {
            num = generator.nextInt(50)+1;
            guess = 0;
            attempt = 0;
            
            System.out.println("***********************");
            System.out.println("* Guess That Integer! *");
            System.out.println("***********************\n");
            System.out.println("In this game, you must");
            System.out.println("guess an integer which");
            System.out.println("is some number from 1 to 50.");
            System.out.println("After your guess, you will");
            System.out.println("recieve \"Too high.\" or");
            System.out.println("\"Too low.\" This will be");
            System.out.println("a lie sometimes, watch out!\n");
            
            System.out.println("Enter difficulty, 0-100.");
            System.out.println("This is the percentage chance");
            System.out.println("for the direction to be a lie.");
            System.out.print(">");
            difficulty = input.nextInt();
            
            while (guess != num) {
                guess = 0;
                
                while (guess < 1 || guess > 50) {
                    System.out.println("Enter your guess - Attempt " + (attempt + 1));
                    System.out.print(">");
                    guess = input.nextInt();
                }
                
                guesses[attempt] = guess;
                
                int unreliability = generator.nextInt(100);
                
                if (guess != num) {
                    if (unreliability > (99 - difficulty)) {
                        if (guess < num) {
                            System.out.println("Too high.");
                            directions[attempt] = true;
                        } else if (guess > num) {
                            System.out.println("Too low.");
                            directions[attempt] = false;
                        }
                    } else {
                        if (guess < num) {
                            System.out.println("Too low.");
                            directions[attempt] = false;
                        } else if (guess > num) {
                            System.out.println("Too high.");
                            directions[attempt] = true;
                        }
                    }
                }
                
                attempt ++;
            }
            
            System.out.println("Correct! You guessed the integer in " + attempt + " tries!");
            
            System.out.println("\nGuess playback:");
            System.out.println("< and > mark guesses and which direction you were told to go");
            System.out.println("| marks the goal number\n* marks the winning guess");
            
            for (int i = 0; i < attempt; i ++) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e);
                }
                for (int c = 0; c <= 50; c ++) {
                    if (c == guesses[i] && c == num) {
                        System.out.print("*");
                    } else if (c == num) {
                        System.out.print("|");
                    } else if (c == guesses[i]) {
                        if (directions[i]) {
                            System.out.print("<");
                        } else {
                            System.out.print(">");
                        }
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.print("\n");
            }
            
            System.out.println("\nPlay another game?");
            System.out.print(">");
            answer = input.next().charAt(0);
            
            if (answer == 'y') {
                run = true;
            } else if (answer == 'n') {
                run = false;
            } else {
                run = false;
                System.out.println("Invalid Input");
            }
        }
    }
}
