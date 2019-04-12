
/**
 * Write a description of class Abacaba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Abacaba
{
    public static void main(String[] args) {
        abacaba(0, 2, "");
    }
    public static void abacaba(int myLvl,int maxLvl,String str) {
        char[] int2char = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        str = str + int2char[myLvl] + str;
        if (myLvl == maxLvl) {
            System.out.println(str);
        } else {
            abacaba(myLvl + 1, maxLvl, str);
        }
    }
}
