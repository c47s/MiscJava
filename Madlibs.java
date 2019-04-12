import java.util.Scanner;
/**
 * Write a description of class Madlibs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Madlibs
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String n1, n2, n3, a1, a2, a3, a4, v1, v2, v3, v4;
        
        System.out.println("Enter a plural noun.");
        System.out.print(">");
        n1 = input.next();
        
        System.out.println("Enter a plural noun.");
        System.out.print(">");
        n2 = input.next();
        
        System.out.println("Enter a singular noun.");
        System.out.print(">");
        n3 = input.next();
        
        System.out.println("Enter an adjective.");
        System.out.print(">");
        a1 = input.next();
        
        System.out.println("Enter an adjective.");
        System.out.print(">");
        a2 = input.next();
        
        System.out.println("Enter an adjective.");
        System.out.print(">");
        a3 = input.next();
        
        System.out.println("Enter an adjective.");
        System.out.print(">");
        a4 = input.next();
        
        System.out.println("Enter a present tense verb. (Run, make, eat)");
        System.out.print(">");
        v1 = input.next();
        
        System.out.println("Enter a past tense verb, which can be done to something. (Whacked, made, ate)");
        System.out.print(">");
        v2 = input.next();
        
        System.out.println("Enter a past tense verb related to moving. (Bounced, skiied, floated)");
        System.out.print(">");
        v3 = input.next();
        
        System.out.println("Enter an 'ing' verb. (Running, making, eating)");
        System.out.print(">");
        v4 = input.next();
        
        System.out.printf("One day, a group of %s %s who liked to %s decided to take over Earth.\nThey mainly wanted to take Earth's rich supply of %s %s.\nA %s %s %s the %s %s, and the %s became extremely %s.\nThe %s %s %s were so ashamed at being %s that they %s as fast as they could away from Earth, %s the whole way.\nWhen the %s got home, they complained about how the %s %s %s them and how they got so %s.\nTheir fellow %s listened and imagined how horrible it would be to get %s by a %s %s and become %s. They were horrified, and decided they should never go to Earth, even though it had %s %s.\nThey were too afraid of the %s %s that %s the invasion party and made them %s.\n", a1, n1, v1, a2, n2, a3, n3, v2, a1, n1, n1, a4, a4, a1, n1, a4, v3, v4, n1, a3, n3, v2, a4, n1, v2, a3, n3, a4, a2, n2, a3, n3, v2, a4);
    }
}
