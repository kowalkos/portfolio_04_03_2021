import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class lab1_drug_alg {
    private static Scanner in = new Scanner(System.in);

    public static double Funkcja(double x1, double x2) {
        return (-Math.pow(x1, 2)-Math.pow(x2,2)+2);
    }

    public static void alg1(int M,double T,Double y) throws IOException{
        Random rnd = new Random();
        FileWriter fmax_plik = new FileWriter("bs2.txt");
        FileWriter f_plik = new FileWriter("obecny2.txt");
        String res_fmax="", res_f="";

        double X[] = new double[2];
        double Xmax[] = new double[2];
        double Xk[] = new double[2];
        double Xprim[]=new double[2];
        int min = -2;
        int max = 2;

        Xmax[0] = X[0] = min + (max- min)*rnd.nextDouble();
        Xmax[1] = X[1] = min + (max- min)*rnd.nextDouble();

        double fmax = Funkcja(X[0], X[1]);
        for(int i =0;i<M;i++)
        {
            if(i==0)
            {
                Xk[0]=X[0];
                Xk[1]=X[1];
            }
            double w=0+(1-0)*rnd.nextDouble();
            if(w==1)
                {
                Xprim[0]=Xk[0]+y*(0+(1-0)*rnd.nextDouble());
                Xprim[1]=Xk[1]+y*(0+(1-0)*rnd.nextDouble());
                }
            else{
                Xprim[0]=Xk[0]-y*(0+(1-0)*rnd.nextDouble());
                Xprim[1]=Xk[1]-y*(0+(1-0)*rnd.nextDouble());
                }
            
            if( Funkcja(Xprim[0], Xprim[1])>fmax)
            {
                fmax=Funkcja(Xprim[0], Xprim[1]);
                Xmax[0]=Xprim[0];
                Xmax[1]=Xprim[1];
                Xk[0]=Xprim[0];
                Xk[1]=Xprim[1];
            }
            else
            {
                double Z=0+(1-0)*rnd.nextDouble();
                if(Z<Math.exp(1)*(-(Funkcja(Xprim[0], Xprim[1])-Funkcja(Xk[0], Xk[1])/T)));
                {
                    fmax=Funkcja(Xprim[0], Xprim[1]);
                }
                Xmax[0]=Xprim[0];
                Xmax[1]=Xprim[1];
                Xk[0]=Xprim[0];
                Xk[0]=Xprim[1];

            }
            double f=Funkcja(Xk[0], Xk[1]);
            res_fmax += fmax + "\n";
            res_f += f + "\n";
            
        }
        fmax_plik.write(res_fmax);
        f_plik.write(res_f);
        fmax_plik.close();
        f_plik.close();
        System.out.println("F max: " + fmax + " X1: " + Xmax[0] + " X2: " + Xmax[1]);
    }
    public static void main(String[] args) {
        System.out.print("");
        int M = in.nextInt();

        try {
            alg1(M,0.0001,0.0001);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }
    
}
