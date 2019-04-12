import java.util.Scanner;
/**
 * Write a description of class Loops here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int time;
        char answer;
        boolean run = true;
        while (run) {
            System.out.println("Enter timer duration in seconds.");
            System.out.print(">");
            time = input.nextInt();
            
            for (int i = time; i > 0; i --) {
                System.out.print("\n" + i + " - ");
                for (int ii = 10; ii > 0; ii --) {
                    System.out.print(ii + " ");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
            System.out.println("Start another timer?");
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
