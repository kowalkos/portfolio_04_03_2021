public class lab5 {
    public static int liczba_bitów(double a,double b,double d)
    {
        return (int) (Math.log((b-a)*Math.pow(10,d))/Math.log(2));
    }
    public static int[][] ciag_binary(double a,double b,int d, int N)
    {   
        int tab1[][]=new int[2*N][liczba_bitów(a, b, d)];
        for(int j=0;j<2*N;j++)
        do{
            for(int i = 0; i<liczba_bitów(a, b, d); i++) {
                tab1[j][i] = (int) ((Math.random()*((1-0)+1))+0);
            }
        }while(zamiana_deci(tab1[j], a, b, d)<a ||zamiana_deci(tab1[j], a, b, d)>b);
        return tab1;
    }
    public static int[][][] ciąg_binary2(double a,double b,int d, int N,int ni)
    {   
        int tab1[][][]=new int[2*N][ni][liczba_bitów(a, b, d)];
        for(int j=0;j<2*N;j++)
        {
            for(int i = 0; i<ni; i++) {
                do{
                for(int k = 0; k<liczba_bitów(a, b, d); k++) {
                tab1[j][i][k] = (int) ((Math.random()*((1-0)+1))+0);
                }
            }while(zamiana_deci(tab1[j][i], a, b, d)<a ||zamiana_deci(tab1[j][i], a, b, d)>b);
        }
    }
        /*for(int j=0;j<2*N;j++)
        {
            for(int i = 0; i<ni; i++)
            {
                for(int k = 0; k<liczba_bitów(a, b, d); k++)
                {
                    System.out.print(tab1[j][i][k]);
                }
                System.out.println();
            }

        }*/
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
    public static void drukujwartości(int N,int[][] tab,int a,int b,int d)
    {
        System.out.println("Drukowanie zamiany na decimal ");
        for (int i=0;i<2*N;i++)
        {
            System.out.println(zamiana_deci(tab[i], a, b, d));
        }
    }
    public static double[] wartości_funkcji2(int[][][] tab,int n,int a ,int b,int d,int A,int N)
    {
        double tab1[]=new double[n];

        for(int j=0;j<2*n;j++)
        {

                double suma=0;
                for(int k=0;k<N;k++)
                {
                    suma+=Math.pow(zamiana_deci(tab[j][k], a, b, d), 2)-A*Math.cos(2*Math.PI*zamiana_deci(tab[j][k], a, b, d));
                }
                double f=A*n+suma;
                tab1[j/2]=f; 
            
        }
        for(int i=0;i<n;i++)
        {
            System.out.println(tab1[i]);
        }

        return tab1;
    }
    public static void drukuj_chromofun2(int[][][] tab,double[] tabf,int n,int a,int b,int d,int ni)
    {
        for(int j=0;j<n;j++)
        {
            for(int i = 0; i<ni; i++)
            {
                for(int k = 0; k<liczba_bitów(a, b, d); k++)
                {
                    System.out.print(tab[j][i][k]);
                }
                System.out.println();
                
            }
            System.out.print(" Wartość funkcji dla podanych dwóch chromosomów: "+tabf[j]);
        System.out.println();

        }
        
    }


    public static double[] wartości_funkcji(int[][] tab,int n,int a,int b,int d)
    {
        double tab1[]=new double[n];
        System.out.println("Drukowanie wartości funkcji dla każdej populacji");
        for(int i=0;i<n;i++)
        {
            tab1[i]=Funkcja(zamiana_deci(tab[i*2], a, b, d),zamiana_deci(tab[i*2+1], a, b, d));
        }
        return tab1;
    }
    public static void drukuj_chromofun(int[][] tab,double[] tabf,int n,int a,int b,int d)
    {
        for(int i = 0; i<2*n; i++)
    {
        for(int j = 0; j<liczba_bitów(a, b, d); j++)
        {
             System.out.print(tab[i][j]);
        }
        if(i%2==1)
        {
            System.out.print(" Wartość funkcji dla podanych dwóch chromosomów: "+tabf[Math.floorDiv(i, 2)]);
        }
        System.out.println();
    }
    }
    public static double Funkcja(double x1, double x2) {
        return (-Math.pow(x1, 2)-Math.pow(x2,2)+2);
    }
    public static double średnia(double[] tab)
    {
        double suma=0;
        for(int i=0;i<tab.length;i++)
        {
            suma+=tab[i];
        }
        System.out.println("Średnia wartość z wartości funkcjii wynosi: "+suma/tab.length);
        return suma/tab.length;
    }
    public static void less_than_avg(double avg,double[] tab)
    {
        System.out.println("Wartości funkcjii mniejsze od średniej:");
        for(int i=0;i<tab.length;i++)
        {
            if(tab[i]<avg)
            {
                System.out.println(tab[i]);
            }
        }
    }
    public static void more_than_avg(double avg,double[] tab)
    {
        System.out.println("Wartości funkcjii większe od średniej:");
        for(int i=0;i<tab.length;i++)
        {
            if(tab[i]>=avg)
            {
                System.out.println(tab[i]);
            }
        }
    }
    public static void main(String[] args) {
        //podawać N razy 2
        /*int n=10;
        int a=-2;
        int b=2;
        int d=5;
        int tab[][]=ciag_binary(a, b, d, n);
        drukujwartości(n, tab,a,b,d);
        double tabf[]=wartości_funkcji(tab, n,a,b,d);
        drukuj_chromofun(tab, tabf, n, a, b, d);
        double średnia=średnia(tabf);
        less_than_avg(średnia, tabf);
        more_than_avg(średnia, tabf);*/
        int n=5;
        int a=-2;
        int b=2;
        int d=5;
        int Ni=10;
        int lista[][][]=ciąg_binary2(a, b, d, n, Ni);
        /*for(int j=0;j<2*n;j++)
        {
            for(int i = 0; i<Ni; i++) {
                System.out.println(zamiana_deci(lista[j][i], a, b, d));
            }
        }*/
        double tabf[]=wartości_funkcji2(lista, n, a, b, d, 10, Ni);
        drukuj_chromofun2(lista, tabf, n, a, b, d, Ni);
        double średnia=średnia(tabf);
        less_than_avg(średnia, tabf);
        more_than_avg(średnia, tabf);
    }
}
