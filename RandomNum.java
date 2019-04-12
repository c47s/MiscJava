import java.util.Scanner;
import java.util.Random;
/**
 * Write a description of class RandomNum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomNum
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random generator = new Random();
        
        int min, max, rand;
        boolean run = true;
        char answer;
        
        while (run) {
            System.out.println("Enter minimum");
            System.out.print(">");
            min = input.nextInt();
            
            System.out.println("Enter maximum");
            System.out.print(">");
            max = input.nextInt();
            
            rand = generator.nextInt(max) + min;
            
            System.out.println("\n* *  " + rand + "  * *");
            
            System.out.println("\n\nGenerate another number?");
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
