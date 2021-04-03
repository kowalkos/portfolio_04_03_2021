import java.util.ArrayList;
public class lab2_drugi_alg {
   
    public static double ciąg()
    {
        int tab1[] = new int[8];
        int decimal = 0;
        for(int i = 0; i<tab1.length; i++) {
            tab1[i] = (int) ((Math.random()*((1-0)+1))+0);
            //System.out.print(tab1[i]);
            decimal += tab1[i]*Math.pow(2, 7-i);
        }
        //System.out.println("\n" + decimal);
        double x = -5.21 + decimal*((5.21+5.21)/(Math.pow(2, 8)- 1));
        //System.out.println("\n" + x);
        return x;
    }
    public static ArrayList funkcja()
    {
    ArrayList<Double> lista=new ArrayList<Double>();
    int A=10;
    int n=10;
    double min=0;
    double xi;
    ArrayList<Double> xtab=new ArrayList<Double>();
    for ( double i =0;i<10;i++)
        {
         double suma=0;
        
        for ( double j =0;j<n;j++)
        {
            xi=ciąg();
            suma+=Math.pow(xi, 2)-A*Math.cos(2*Math.PI*xi);
            xtab.add(xi);
        }
        
        double f=A*n+suma;
        if(i==0)
        {   
            min=f;
    }
        else{
        if (min> f )
        {
            min=f;
        }
    }
        lista.clear();
        lista.add(f);
        xtab.forEach(x->lista.add(x));
        xtab.clear();
        
    }
    return lista;
    }
    public static void main(String[] args) {
        ArrayList b= new ArrayList();
        b=funkcja();
        b.forEach(x->System.out.println(x));  
    }
}
