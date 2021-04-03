import java.util.Random;
public class lab2_09_03
{   public static double Funkcja(double x1, double x2) {
    return (-Math.pow(x1, 2)-Math.pow(x2,2)+2);
    }
    public static double ciąg()
    {
        int tab1[] = new int[8];
        int decimal = 0;
        for(int i = 0; i<tab1.length; i++) {
            tab1[i] = (int) ((Math.random()*((1-0)+1))+0);
            //System.out.print(tab1[i]);
            decimal += tab1[i]*Math.pow(2, 7-i);
        }
        System.out.println( decimal);
        double x = -2 + decimal*((2+2)/(Math.pow(2, 8)- 1));
        System.out.println( x);
        return x;
    }
    public static void main(String[] args) {
        double x1=ciąg();
        double x2=ciąg();
        System.out.println();
        System.out.println(Funkcja(x1, x2));
    }
}