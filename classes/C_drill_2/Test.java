
/**
 * Write a description of class Converter here.
 *
 * @author ebchen   
 * @version 26 September 2017
 */
public class Test
{
    public static void main( String [] args)
    {
        double x = 2.5;
        double y = -1.5;
        int m = 18;
        int n = 4;
        System.out.println (x+n*y-(x+n)*y);
        System.out.println (m/n + m%n);
        System.out.println (5*x-n/5);
        System.out.println (1-(1-(1-(1-(1-n)))));
        System.out.println (Math.sqrt(Math.sqrt(n)));
        
        String s = "Hello";
        String t = "World";
        System.out.println(s.length() + t.length());
        System.out.println(s.substring(1,2));
        System.out.println(s.substring(s.length()/2, s.length()));
        System.out.println(s+t);
        System.out.println(t+s);
        
        System.out.println(3*1000*1000*1000);
        System.out.println(3.0*1000*1000*1000);
    }
}
