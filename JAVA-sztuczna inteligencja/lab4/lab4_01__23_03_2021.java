import java.util.ArrayList;
public class lab4_01__23_03_2021
{      
    public static int liczba_bitów(double a,double b,double d)
    {
        return (int) (Math.log((b-a)*Math.pow(10,d))/Math.log(2));
    }
    public static int[] ciag_binary(double a,double b,int d)
    {       int tab1[]=new int[liczba_bitów(a, b, d)];
        do{

        
            int mi=liczba_bitów(a, b, d);
            tab1 = new int[liczba_bitów(a, b, d)];
            int decimal = 0;
            for(int i = 0; i<tab1.length; i++) {
                tab1[i] = (int) ((Math.random()*((1-0)+1))+0);
                
                decimal += tab1[i]*Math.pow(2, mi-i);
            }
        }while(zamiana_deci(tab1, a, b, d)<a ||zamiana_deci(tab1, a, b, d)>b);


            return tab1;
    }
    public static double zamiana_deci(int[] tab1,double a,double b,int d)
    {
        int mi=liczba_bitów(a, b, d);
        StringBuilder binString = new StringBuilder();
        for (int i = 0; i < tab1.length; i++) {
            if (i == 0 && tab1[i] == 0)
                continue;
            binString.append(tab1[i]);
        }
        long num = Long.parseLong(binString.toString());
        int decimalNumber = 0, i = 0;
        long remainder;
        while (num != 0) {
            remainder = num % 10;
            num /= 10;
            decimalNumber += remainder * Math.pow(2, i);
            ++i;
        }
            double x =(double) (a + decimalNumber*((b-a)/(Math.pow(2, mi)- 1)));
            return x;
    }
    public static int[] mutacja(double a,double b,int d,double Pm,int[] tab)
    {
        for(int i = 0; i<tab.length; i++)
        {
            System.out.print(tab[i]);
        }
        System.out.println();
        int licznik=0;
        for(int i =0;i<tab.length;i++)
        {
            double r =Math.random();
            if(r<Pm)
            {
                licznik++;
                if(tab[i]==0)
                {
                    tab[i]=1;
                }
                else{
                    tab[i]=0;
                }
            }
        }
        for(int i =0;i<tab.length;i++)
        {
            System.out.print(tab[i]);
        }
        System.out.println();
        
        System.out.println("Liczba mutacji "+licznik);
        return tab;
    }
    public static int[] mutacja_drugie(double a,double b,int d,double Pm,int[] tab)
    {
        int licznik=0;
        for(int i = 0; i<tab.length; i++)
        {
            System.out.print(tab[i]);
        }
        System.out.println();
        for(int i =0;i<tab.length;i++)
        {
            double r =Math.random();
            if(r<Pm)
            {
                licznik++;
                if(tab[i]==0)
                {
                    tab[i]=1;
                }
                else{
                    tab[i]=0;
                }
            }
        }
        for(int i =0;i<tab.length;i++)
        {
            System.out.print(tab[i]);
        }
        System.out.println();
        System.out.println("Liczba mutacji "+licznik);
        return tab;
    }
    public static double Funkcja(double x1, double x2) {
        return (-Math.pow(x1, 2)-Math.pow(x2,2)+2);
    }

    public static void Wyświetl_wartości_Pierwsze_zadanie(double a,double b,int d,double Pm)
    {
        int[] ciąg1=ciag_binary(a, b, d);
        int[] ciąg2=ciag_binary(a, b, d);
        System.out.println("Wartości funkcji przed mutacją:");
        System.out.println(Funkcja(zamiana_deci(ciąg1, a, b, d),zamiana_deci(ciąg2, a, b, d)));
        System.out.println("Wartości funkcji po mutacji:");
        System.out.println(Funkcja(zamiana_deci(mutacja(a, b, d, Pm, ciąg1) , a, b, d),zamiana_deci(mutacja(a, b, d, Pm, ciąg2), a, b, d)));
    }
    public static void Wyświetl_wartości_Drugie_zadanie(double a,double b,int d,double Pm,int n,double A)
    {
        double suma=0;
        ArrayList<int[]> lista=new ArrayList<int[]>();
        for( int i =0;i<n;i++)
        {   
            lista.add(ciag_binary(a, b, d));
            double xi=zamiana_deci(lista.get(i), a, b, d);
            suma+=Math.pow(xi, 2)-A*Math.cos(2*Math.PI*xi);
        }
        double wynik_4=A*n+suma;
        System.out.println("wynik funkcji przed mutacją(drugie zadanie): ");
        System.out.println(wynik_4);
        suma=0;
        for( int i =0;i<n;i++)
        {   
            
            double xi=zamiana_deci(mutacja(a, b, d, Pm, lista.get(i)) , a, b, d);
            suma+=Math.pow(xi, 2)-A*Math.cos(2*Math.PI*xi);
        }
        wynik_4=A*n+suma;
        System.out.println("wynik funkcji po mutacją(drugie zadanie): ");
        System.out.println(wynik_4);
    }
    public static void main(String[] args) {
        
        //Wyświetl_wartości_Pierwsze_zadanie(-2, 2, 5,0.1);
        Wyświetl_wartości_Drugie_zadanie(-5.21,5.21,3,0.1,10,10);
    }
}