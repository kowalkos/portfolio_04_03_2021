import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class lab1_2_03_2021 {
//(Math.random()((max-min)+1))+min;
    private static Scanner in = new Scanner(System.in);

    public static double Funkcja(double x1, double x2) {
        return (-Math.pow(x1, 2)-Math.pow(x2,2)+2);
    }

    public static void alg1(int M) throws IOException{
        Random rnd = new Random();
        FileWriter fmax_plik = new FileWriter("bs.txt");
        FileWriter f_plik = new FileWriter("obecny.txt");
        String res_fmax="", res_f="";

        double X[] = new double[2];
        double Xmax[] = new double[2];
        int min = -2;
        int max = 2;

        Xmax[0] = X[0] = min + (max- min)*rnd.nextDouble();
        Xmax[1] = X[1] = min + (max- min)*rnd.nextDouble();

        double fmax = Funkcja(X[0], X[1]);
        for(int i=0; i < M; i++) {
            X[0] = min + (max- min)*rnd.nextDouble();
            X[1] = min + (max- min)*rnd.nextDouble();
            double f = Funkcja(X[0], X[1]);

            res_fmax += fmax + "\n";
            res_f += f + "\n";

            if(f>fmax) {
                fmax = f;
                Xmax[0]=X[0];
                Xmax[1]=X[1];
            }
        }

        fmax_plik.write(res_fmax);
        f_plik.write(res_f);
        fmax_plik.close();
        f_plik.close();
        System.out.println("F max: " + fmax + " X1: " + Xmax[0] + " X2: " + Xmax[1]);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.print("");
        int M = in.nextInt();

        try {
            alg1(M);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }
}