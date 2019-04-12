import java.util.Scanner;

/**
 * A simple calculator program
 * 
 * @author Nathaniel Waterman 
 * @version 1.0
 */

public class Calculator {
    public static void main(String[] args) {
        double n1, n2;
        boolean test = true;
        boolean test1 = true;
        boolean test2 = true;
        boolean invalid = false;
        char operat, response;
        Scanner input = new Scanner(System.in);
        
        System.out.println("*******************");
        System.out.println("* JAVA CALCULATOR *");
        System.out.println("*******************");
        
        System.out.println("1st Number");
        System.out.print(">");
        n1 = input.nextDouble();
        
        System.out.println("2nd Number");
        System.out.print(">");
        n2 = input.nextDouble();
        
        while (test1) {
            System.out.println("Operator");
            System.out.print(">");
            operat = input.next().charAt(0);
            
            switch(operat) {
                case '+':
                    System.out.println(n1 + n2);
                    break;
                case '-':
                    System.out.println(n1 - n2);
                    break;
                case '*':
                    System.out.println(n1 * n2);
                    break;
                case '/':
                    System.out.println(n1 / n2);
                    break;
                case '%':
                    System.out.println(n1 % n2);
                    break;
                default:
                    System.out.println("Invalid Operator");
                    invalid = true;
                    break;
            }
            
            while (test2 == true) {
                System.out.println("Perform another operation?");
                System.out.print(">");
                response = input.next().charAt(0);
                
                if (response == 'y') {
                    test2 = true;
                    test = false;
                } else if (response == 'n'){
                    test2 = false;
                    test = false;
                } else {
                    test2 = false;
                    test = true;
                    
                    System.out.println("Invalid Input");
                }
            }
            
            if (invalid) {
                    test1 = true;
                } else {
                    test1 = false;
                }
        }        
    }
}