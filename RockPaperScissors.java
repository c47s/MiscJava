import java.util.Scanner;
import java.util.Random;
/**
 * Write a description of class RockPaperScissors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RockPaperScissors
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random generator = new Random();
        
        String plrHand;
        String cmpHand = "";
        int cmpInt;
        boolean run = true;
        char answer;
        
        System.out.println("***********************");
        System.out.println("* Rock Paper Scissors *");
        System.out.println("***********************\n");
        
        do {
            cmpInt = generator.nextInt(3)+1;
            
            switch (cmpInt) {
                case 1:
                    cmpHand = "rock";
                    break;
                case 2:
                    cmpHand = "paper";
                    break;
                case 3:
                    cmpHand = "scissors";
                    break;
            }
            
            System.out.println("Rock, paper, or scissors? (lowercase)");
            System.out.print(">");
            plrHand = input.next();
            
            if (plrHand.equals(cmpHand)) {
                if (cmpHand.equals("rock")) {
                    System.out.println("Tie!\nRock <-> Rock");
                } else if (cmpHand.equals("paper")) {
                    System.out.println("Tie!\nPaper <-> Paper");
                } else if (cmpHand.equals("scissors")) {
                    System.out.println("Tie!\nScissors <-> Scissors");
                }
            } else if (plrHand.equals("rock")) {
                if (cmpHand.equals("paper")) {
                    System.out.println("Computer wins!\nPaper --> Rock");
                } else if (cmpHand.equals("scissors")) {
                    System.out.println("Player wins!\nRock --> Scissors");
                }
            } else if (plrHand.equals("paper")) {
                if (cmpHand.equals("rock")) {
                    System.out.println("Player wins!\nPaper --> Rock");
                } else if (cmpHand.equals("scissors")) {
                    System.out.println("Computer wins!\nScissors --> Paper");
                }
            } else if (plrHand.equals("scissors")) {
                if (cmpHand.equals("rock")) {
                    System.out.println("Computer wins!\nRock --> Scissors");
                } else if (cmpHand.equals("paper")) {
                    System.out.println("Player wins!\nScissors --> Paper");
                }
            } else if (plrHand.equals("ChuckNorris")) {
                System.out.println("Player wins!");
            } else {
                System.out.println("Invalid Input - Enter \"rock\" \"paper\" or \"scissors\".");
            }
            
            System.out.println("Play another game?");
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
        } while (run);
    }
}
