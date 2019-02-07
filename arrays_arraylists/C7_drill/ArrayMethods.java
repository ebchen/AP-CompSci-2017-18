public class ArrayMethods
{
    private int[] values;
    public ArrayMethods(int[] initialValues)
    {
        values = initialValues;
    }

    public void swapFirstAndLast()
    {
        int x = values[0];
        values [ 0] = values [values.length-1];
        values [values.length-1] = x;
        for (int i = 0; i < values.length ; i++)
        {
            System.out.print(values[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public void shiftRight()
    {
        int prevValue = 0;
        int currValue = 0;
        for (int i = 0; i < values.length ; i++)
        {
            if (i == 0)
            {
                currValue = values[i];
                values[i] = values[values.length-1];
                prevValue = currValue;
            }
            else
            {
                currValue = values[i];
                values[i] = prevValue;
                prevValue = currValue;

            }
        }

        for (int i = 0; i < values.length ; i++)
        {
            System.out.print(values[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public void replaceAllEvenWithZero()
    {
        for (int i = 0; i < values.length; i++)
        {
            if (values[i] % 2 == 0)
            {
                values[i] = 0;
            }
        }

        for (int i = 0; i < values.length ; i++)
        {
            System.out.print(values[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public void changeToLargeNeighbor()
    {
        int prev = values[0];
        int curr = values[0];
        for (int i = 1; i < values.length-1; i++)
        {
            if (prev > values[i+1])
            {
                curr = values[i];
                values[i] = prev;
                prev = curr;
            }

            else
            {
                curr = values[i];
                values[i] = values[i+1];
                prev = curr;
            }
        }

        for (int i = 0; i < values.length ; i++)
        {
            System.out.print(values[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public void removeMiddle()
    {
        int[] newValues;

        if (values.length%2 == 0)
        {
            newValues = new int[values.length-2];
            for (int i = 0; i < values.length; i ++)
            {
                if ((i != values.length/2 ) && (i != values.length/2 - 1))
                {
                    if (i > values.length/2)
                    {
                        newValues[i-1] = values[i];
                    }

                    else 
                    {
                        newValues[i] = values[i];
                    }
                }

            }
        }
        else
        {
            newValues = new int[values.length-1];
            for (int i = 0; i < values.length; i++ )
            {
                if (i != values.length/2 )
                {

                    if (i > values.length/2)
                    {
                        newValues[i-1] = values[i];
                    }

                    else 
                    {
                        newValues[i] = values[i];
                    }

                }

            }
        }
        values = newValues;

        for (int i = 0; i < values.length ; i++)
        {
            System.out.print(values[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public void moveEvens()
    {
        int[] newValues = new int [values.length];
        int counter = 0;
        for (int i = 0; i < values.length; i ++)
        {
            if (values[i] %2 == 0)
            {
                newValues[counter] = values[i];
                counter++;
            }
        }
        
        for (int i = 0; i < values.length; i ++)
        {
            if (values[i] %2 != 0)
            {
                newValues[counter] = values[i];
                counter++;
            }
        }
        
        values = newValues;

        for (int i = 0; i < values.length ; i++)
        {
            System.out.print(values[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
    
    public int secondLargest()
    {
        int max = values [0];
        for (int i = 0; i < values.length; i++ )
        {
            if (values[i] > max)
            {
                max = values[i];
            }
        }
        int secondMax = values[0];
        for (int i = 0; i < values.length; i++ )
        {
            if ((values[i] > secondMax) && (values[i] != max))
            {
                secondMax = values[i];
            }
        }
        return secondMax;
    }
    
    public boolean ifInOrder()
    {
        for (int i = 1; i < values.length; i ++)
        {
            if (values[i] < values[i-1])
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean adjacentDuplicates()
    {
        for (int i = 1; i < values.length; i ++)
        {
            if (values[i] == values[i-1])
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasDuplicates()
    {
        for (int i = 0; i < values.length; i++)
        {
            for (int j = i+1; j < values.length; j++)
            {
                if (values[i] == values[j])
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main( String[] args )
    {
        int[] testValues = { 3, 5, 6, 1 , 8, 10, 12, 4, 1, 5, 7, 9, 51/* add your own values */ };

        for (int i = 0; i < testValues.length ; i++)
        {
            System.out.print(testValues[i]);
            System.out.print(" ");
        }
        System.out.println();

        ArrayMethods tester1 = new ArrayMethods( testValues );
        System.out.println("Swap first and last: ");
        tester1.swapFirstAndLast();

        System.out.println("Shift right: ");
        tester1.shiftRight();

        System.out.println("Replace all evens with zero: ");
        tester1.replaceAllEvenWithZero();

        System.out.println("Replace with larger neighbor: ");
        tester1.changeToLargeNeighbor();

        System.out.println("Remove middle: ");
        tester1.removeMiddle();
        
        System.out.println("Move evens: ");
        tester1.moveEvens();
        
        System.out.println("Second largest: ");
        System.out.println(tester1.secondLargest());
        
        System.out.println("If in increasing order: ");
        System.out.println(tester1.ifInOrder());
        
        System.out.println("If has adjacent duplicates: ");
        System.out.println(tester1.adjacentDuplicates());
        
        System.out.println("If has duplicates: ");
        System.out.println(tester1.hasDuplicates());
    }
}