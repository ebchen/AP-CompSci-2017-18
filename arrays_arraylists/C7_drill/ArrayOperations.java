
public class ArrayOperations
{
    public static void main (String [] args)
    {
        double [] x = { 8, 4, 5, 21, 7, 9, 18, 2, 100};
        System.out.println ( "number of items in array: " + x.length);
        System.out.println ( "the first item in the array: " + x[0]);
        System.out.println ( "the last item in the array: " + x[8]);
        System.out.println ( "x[x.length-1]: " + x[x.length-1]);
        // it is the same because the last index of an array is always length-1
        
        System.out.print ("the array without labels: ");
        for (int i = 0; i < x.length; i ++)
        {
            System.out.print ( x[i] + " ");
        }
        System.out.println();
        
        System.out.print ("the array with labels: ");
        for (int i = 0; i < x.length; i ++)
        {
            System.out.print ("x[" + i + "]: " + x[i] + " ");
        }
        System.out.println();
        
        System.out.print ("the array backwards: ");
        for (int i = x.length-1; i >= 0; i --)
        {
            System.out.print ("x[" + i + "]: " + x[i] + " ");
        }
        System.out.println();
        
        System.out.print ("the array without labels: ");
        
        for (double number : x )
        {
            System.out.print ( number + " ");
        }
    }
    
    
}
