import java.util.Random;
/**
 * Write a description of class NameForge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NameForge
{
    public static void main(String[] args) {
        for (int i = 10; i > 0; i --) {
            System.out.println(randName(1, 2));
        }
    }
    
    public static String randName(int min, int max) {
        Random random = new Random();
        String[] con = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z", "", "", "", ""};
        String[] vow = {"a", "e", "i", "o", "u", ""};
        String name = "";
        
        for (int j = random.nextInt(max) + min; j >= 0; j --) {
            name = name + con[random.nextInt(con.length)];
            name = name + vow[random.nextInt(vow.length)];
        }
        
        name = name + " ";
        
        for (int j = random.nextInt(max) + min; j >= 0; j --) {
            name = name + con[random.nextInt(con.length)];
            name = name + vow[random.nextInt(vow.length)];
        }
        
        return name;
    }
}
