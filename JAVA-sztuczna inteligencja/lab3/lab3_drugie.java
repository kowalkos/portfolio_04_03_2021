
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.Random;
    public class lab3_drugie {


    public static int liczba_bitów(double a,double b,double d)
    {
        return (int) (Math.log((b-a)*Math.pow(10,d))/Math.log(2));
    }
    public static int ciąg(int a,int b,int d)
    {
        int mi=liczba_bitów(a, b, d);
        int tab1[] = new int[8];
        int decimal = 0;
        for(int i = 0; i<tab1.length; i++) {
            tab1[i] = (int) ((Math.random()*((1-0)+1))+0);
            System.out.print(tab1[i]);
            decimal += tab1[i]*Math.pow(2, mi-i);
        }
        //System.out.println("\n" + decimal);
        int x =(int) (a + decimal*((b-a)/(Math.pow(2, mi)- 1)));
        //System.out.println("\n" + x);
        return x;
    }
    public static int[] ciag_binary(double a,double b,double d)
    {
            int mi=liczba_bitów(a, b, d);
            int tab1[] = new int[liczba_bitów(a, b, d)];
            int decimal = 0;
            for(int i = 0; i<tab1.length; i++) {
                tab1[i] = (int) ((Math.random()*((1-0)+1))+0);
                System.out.print(tab1[i]);
                decimal += tab1[i]*Math.pow(2, mi-i);
            }
            return tab1;
    }
    public static double Funkcja(int a, int b,int d,int n,int A) {
        double suma=0;
        
        for ( double j =0;j<n;j++)
        {
            double xi=ciąg(a,b,d);
            suma+=Math.pow(xi, 2)-A*Math.cos(2*Math.PI*xi);
        }
        
        return A*n+suma;
        }
    public static void krzyżowanie_jedno(double   a ,double b,int d,int n,int A)
    {
        Random rand=new Random();
        int tab_1[]=new int[liczba_bitów(a, b, d)];
        int tab_2[]=new int[liczba_bitów(a, b, d)];
        int losowy_punkt=rand.nextInt(liczba_bitów(a, b, d));
        System.out.println(losowy_punkt);
        tab_1=ciag_binary(a, b, d);
        System.out.println();
        tab_2=ciag_binary(a, b, d);
        int tab_1_pot[]=new int[tab_1.length];
        int tab_2_pot[]=new int[tab_2.length];
        for(int i=0;i<tab_1.length;i++)
        {
            if(i<=losowy_punkt)
            {
                tab_1_pot[i]=tab_1[i];
                tab_2_pot[i]=tab_2[i];
            }
            else{
                tab_1_pot[i]=tab_2[i];
                tab_2_pot[i]=tab_1[i];
            }
        }
        System.out.println();
        double x1,x2,x1pot,x2pot;
        x1=zamiana_deci(tab_1, a, b, d);
        x2=zamiana_deci(tab_2, a, b, d);
        x1pot=zamiana_deci(tab_1_pot, a, b, d);
        x2pot=zamiana_deci(tab_2_pot, a, b, d);
        if(x1>=a&&x1<=b&&x2>=a&&x2<=b&&x2pot>=a&&x2pot<=b&&x1pot>=a&&x1pot<=b)
        {
            ;
        }
        else{
            krzyżowanie_jedno(a, b, d,n,A);
        }
        for(int i=0;i<tab_1.length;i++)
        {
            System.out.print(tab_1_pot[i]);
        }
        System.out.println();
        for(int i=0;i<tab_1.length;i++)
        {
            System.out.print(tab_2_pot[i]);
        }
        double suma=0;
        System.out.println();
        
        for ( double j =0;j<n;j++)
        {
            double xi=zamiana_deci(tab_1, a, b, d);
            suma+=Math.pow(xi, 2)-A*Math.cos(2*Math.PI*xi);
        }
        double wynik_1=A*n+suma;
        suma=0;
        System.out.println("poszczególne wektory x1,x1pot,x2,x2pot\n"+x1+"\n"+x1pot+"\n"+x2+"\n"+x2pot);
        System.out.println("Wynik funkcji na rodzicach pierwszych "+wynik_1);
        for ( double j =0;j<n;j++)
        {
            double xi=zamiana_deci(tab_2, a, b, d);
            suma+=Math.pow(xi, 2)-A*Math.cos(2*Math.PI*xi);
        }
        double wynik_2=A*n+suma;
        System.out.println("Wynik funkcji na rodzicach drugich "+wynik_2);
        suma=0;
        for ( double j =0;j<n;j++)
        {
            double xi=zamiana_deci(tab_1_pot, a, b, d);
            suma+=Math.pow(xi, 2)-A*Math.cos(2*Math.PI*xi);
        }
        double wynik_3=A*n+suma;
        System.out.println("Wynik funkcji na potomków pierwszego "+wynik_3);
        suma=0;
        for ( double j =0;j<n;j++)
        {
            double xi=zamiana_deci(tab_2_pot, a, b, d);
            suma+=Math.pow(xi, 2)-A*Math.cos(2*Math.PI*xi);
        }
        double wynik_4=A*n+suma;
        System.out.println("Wynik funkcji na potomków drugiego "+wynik_4);

        
        
  
    }
    public static void krzyżowanie_wielo(int   a ,int b,int d,int ile,int n,int A)
    {
        Random rand=new Random();
        int tab_1[]=new int[liczba_bitów(a, b, d)];
        int tab_2[]=new int[liczba_bitów(a, b, d)];
        ArrayList<Integer> lista_punkt=new ArrayList<Integer>();
        boolean zmiana=true;
        for(int i =0;i<ile;i++)
        {
            lista_punkt.add(rand.nextInt(liczba_bitów(a, b, d)));
        }
        Collections.sort(lista_punkt);
        lista_punkt.forEach(x->System.out.println(x));
        tab_1=ciag_binary(a, b, d);
        System.out.println();
        tab_2=ciag_binary(a, b, d);
        int tab_1_pot[]=new int[tab_1.length];
        int tab_2_pot[]=new int[tab_2.length];
        int j=0;
        System.out.println();
        for(int i=0;i<ile;i++)
        {
            for(;j<lista_punkt.get(i);j++)
            {
                if(zmiana)
                {
                    tab_1_pot[j]=tab_1[j];
                    tab_2_pot[j]=tab_2[j];
                }
                else{
                    tab_1_pot[j]=tab_2[j];
                    tab_2_pot[j]=tab_1[j];
                }
                
            }
            zmiana=!zmiana;
        }
        for(int i=lista_punkt.get(lista_punkt.size()-1);i<tab_1.length;i++)
        {
            if(zmiana)
            {
                tab_1_pot[i]=tab_1[i];
                tab_2_pot[i]=tab_2[i];
            }
            else{
                tab_1_pot[i]=tab_2[i];
                tab_2_pot[i]=tab_1[i];
            }
        }
        System.out.println();
        double x1,x2,x1pot,x2pot;
        x1=zamiana_deci(tab_1, a, b, d);
        x2=zamiana_deci(tab_2, a, b, d);
        x1pot=zamiana_deci(tab_1_pot, a, b, d);
        x2pot=zamiana_deci(tab_2_pot, a, b, d);
        if(x1>=a&&x1<=b&&x2>=a&&x2<=b&&x2pot>=a&&x2pot<=b&&x1pot>=a&&x1pot<=b)
        {
            ;
        }
        else{
            krzyżowanie_wielo(a, b, d,ile,n,A);
        }
        for(int i=0;i<tab_1.length;i++)
        {
            System.out.print(tab_1_pot[i]);
        }
        System.out.println();
        for(int i=0;i<tab_1.length;i++)
        {
            System.out.print(tab_2_pot[i]);
        }
        double suma=0;
        System.out.println();
        
        for ( double k =0;k<n;k++)
        {
            double xi=zamiana_deci(tab_1, a, b, d);
            suma+=Math.pow(xi, 2)-A*Math.cos(2*Math.PI*xi);
        }
        double wynik_1=A*n+suma;
        suma=0;
        System.out.println("poszczególne wektory x1,x1pot,x2,x2pot\n"+x1+"\n"+x1pot+"\n"+x2+"\n"+x2pot);
        System.out.println("Wynik funkcji na rodzicach pierwszych "+wynik_1);
        for ( double k =0;k<n;k++)
        {
            double xi=zamiana_deci(tab_2, a, b, d);
            suma+=Math.pow(xi, 2)-A*Math.cos(2*Math.PI*xi);
        }
        double wynik_2=A*n+suma;
        System.out.println("Wynik funkcji na rodzicach drugich "+wynik_2);
        suma=0;
        for ( double k =0;k<n;k++)
        {
            double xi=zamiana_deci(tab_1_pot, a, b, d);
            suma+=Math.pow(xi, 2)-A*Math.cos(2*Math.PI*xi);
        }
        double wynik_3=A*n+suma;
        System.out.println("Wynik funkcji na potomków pierwszego "+wynik_3);
        suma=0;
        for ( double k =0;k<n;k++)
        {
            double xi=zamiana_deci(tab_2_pot, a, b, d);
            suma+=Math.pow(xi, 2)-A*Math.cos(2*Math.PI*xi);
        }
        double wynik_4=A*n+suma;
        System.out.println("Wynik funkcji na potomków drugiego "+wynik_4);

    
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
    /*public static ArrayList funkcja(double a, double b,double d)
    {
    ArrayList<Double> lista=new ArrayList<Double>();
    ArrayList<Double> xtab=new ArrayList<Double>();       
    }*/
    public static void main(String[] args) {
        krzyżowanie_jedno(-5.21,5.21, 5,10,10); 
        krzyżowanie_wielo(-2, 2, 5, 3,10,10);
    }
}



