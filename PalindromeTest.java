import java.util.Scanner;
/**
 * Write a description of class Palindrome here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PalindromeTest
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String original, reverse = "";
        boolean run = true;
        char answer;
        
        while (run) {
            System.out.println("Enter a word to test if it is palindromic - no spaces");
            System.out.print(">");
            original = input.next();
            
            System.out.print("Original - ");
            for (int i = 0; i <= original.length() - 1; i ++) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.print(original.charAt(i));
            }
            
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            
            System.out.print("\nReverse  - ");
            int length = original.length();
            for (int i = length - 1; i >= 0; i --) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    System.out.println(e);
                }
                reverse += original.charAt(i);
                System.out.print(original.charAt(i));
            }
            
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            
            if (original.equals(reverse)) {
                System.out.println("\nPalindrome: YES\n");
            } else {
                System.out.println("\nPalindrome: NO\n");
            }
            
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            
            System.out.println("Test another palindrome?");
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
