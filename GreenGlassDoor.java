import java.util.Scanner;
/**
 * Write a description of class GreenGlassDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenGlassDoor
{
    public static void println(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static String getInput(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.println(prompt);
        System.out.print("> ");
        return input.nextLine();
    }
    
    public static String getChoice(String prompt, String op1, String op2) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        String answer = "";
        while (!valid) {
            System.out.println(prompt + "\n\"" + op1 + "\" / \"" + op2 + "\"");
            System.out.print("> ");
            answer = input.next();
            if (answer.equals(op1) || answer.equals(op2)) {
                valid = true;
            }
        }
        return answer;
    }
    
    public static boolean getYesNo(String prompt) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        String answer = "";
        while (!valid) {
            System.out.println(prompt + "\n\"yes\" / \"no\"");
            System.out.print("> ");
            answer = input.next();
            if (answer.equals("yes") || answer.equals("no")) {
                valid = true;
            }
        }
        return answer.equals("yes");
    }

    public static void main(String[] args) {
        println("**********************\n*     Weclome To     *\n*  Green Glass Door  *\n**********************\n\n\nIn this game, you may ask if things go through the green glass door.\nYour goal is to figure out what the rule is.");
        
        String answer;
        boolean win = false;
        boolean correct;
        int numCorrect = 0;
        while (!win) {
            if (getYesNo("Do you think you know the rule of the green glass door?")) {
                println("This is the green glass test!\nEnter 10 words that make it through the green glass door, and you win!");
                numCorrect = 0;
                for (int i = 0; i < 10; i ++) {
                    answer = getInput("Enter something to try to put through the green glass door.");
                    char prev = answer.charAt(0);
                    correct = false;
                    
                    for (int c = 1; c < answer.length(); c ++) {
                        prev = answer.charAt(i);
                    }
                    
                    if (correct) {
                        numCorrect ++;
                    }
                }
                if (numCorrect >= 10) {
                    println("You Win!");
                }
            } else {
                answer = getInput("Enter something to try to put through the green glass door.");
                char prev = answer.charAt(0);
                correct = false;
                numCorrect = 0;
                for (int i = 1; i < answer.length(); i ++) {
                    correct = (answer.charAt(i) == prev);
                    if (correct) {
                        numCorrect ++;
                    }
                    prev = answer.charAt(i);
                }
                if (numCorrect > 0) {
                    println(answer + " goes through the green glass door.");
                } else {
                    println(answer + " does not go through the green glass door.");
                }
            }
        }
    }
}
