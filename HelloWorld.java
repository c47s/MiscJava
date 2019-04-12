
/**
 * A starting program for experimenting and learning the basics of Java.
 * This program doesn't do much, it's just an experimentation playground.
 * 
 * @author Nathaniel Waterman 
 * @version 1.0
 */
public class HelloWorld
{
    public static void main(String[] args) {
       int rand;
       for (int i = 0; i < 100; i ++) {
           rand = (int) ((Math.random() * 10)+1);
           System.out.println(rand);
           try {
               Thread.sleep(250);
           } catch(InterruptedException ex) {
               Thread.currentThread().interrupt();
           }
       }
    }
}
