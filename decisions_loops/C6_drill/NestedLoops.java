
public class NestedLoops
{
    public static void nestedFor()
    {
        for (int i = 1; i <=2; i++)
        {
            for (int j = 1; j <= 4; j++)
            {
                System.out.println ( i + " " + j);
            }
        }
    }
    
    public static void nestedWhile()
    {
        int i = 1;
        int j = 1;
        while ( i <= 2)
        {
            j = 1;
            while (j <= 4)
            {
                System.out.println ( i + " " + j);
                j++;
            }
            i++;
        }
    }
    
    
    public static void nestedDo()
    {
        int i = 1;
        int j = 1;
        do
        {
            j = 1;
            do
            {
               System.out.println ( i + " " + j); 
               j++;
            }
            while (j <= 4);
            i++;
        }
        while (i <= 2);
    }
}
