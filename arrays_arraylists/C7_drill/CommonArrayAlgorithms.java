import java.util.Arrays;

public class CommonArrayAlgorithms
{
    /*
     * Create array of the specified size filled with
     *      random values based on the maximum value.
     */
    public static int[] createRandomArray( int length, int maxValue )
    {
        int[] randomArray = new int[ length ];
        for( int i = 0; i < randomArray.length; i++ )
        {
            randomArray[ i ] = (int)( Math.random() * maxValue );
        }

        return randomArray;
    }

    /*
     * Prints the specified array to System.out
     */
    public static void printArray( int[] array )
    {
        System.out.println( Arrays.toString( array ));
    }

    /*
     * Array Algorithm #1: Sum and Average
     *  creates an array filled with random numbers
     *  calculates the sum and average of the numbers
     *  prints the array and the sum and average
     *  @returns the average
     */
    public static void sumAndAverage()
    {
        double sum = 0;
        double average = 0;
        int count = 0;

        int[] array = createRandomArray( 10, 50 );

        for( int i = 0; i < array.length; i++ )
        {
            sum += array[ i ];
            count++;
        }

        average = sum / count;

        printArray( array );
        System.out.println( "sum: " + sum + " average: " + average );
    }

    /*
     * Array Algorithm #2: Print Element Separators
     *  creates an array filled with random numbers
     *  prints each element of the array with a '|' between each element
     *      but not at the beginning or end of the array
     */
    public static void printElementSeparators()
    {
        int[] array1 = createRandomArray(10,50);

        for( int i = 0; i < array1.length; i++)
        {
            System.out.print( array1[i] );

            if( i != array1.length - 1)
            {
                System.out.print("|");
            }
        }
    }

    /*
     * Array Algorithm #3: Linear Search
     *  creates an array filled with random numbers
     *  find the index of the first element with the specified value
     *  prints the array and the index
     */
    public static void linearSearch( int valueToFind )
    {
        int[] array = createRandomArray( 10, 10 );
        int index = -1;

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == valueToFind)
            {
                index = i;
                break;
            }
        }
        printArray( array );
        if (index == -1)
        {
            System.out.println( "value was not found");
        }
        else 
        {
            System.out.println( "value found at index: " + index );
        }
    }

    /*
     * Array Algorithm #4: Swap Elements
     *  creates an array filled with random numbers
     *  prints the array
     *  swaps the elements at the two specified indexes
     *  prints the array
     */
    public static void swapElements( int index1, int index2 )
    {
        int[] array = createRandomArray( 10, 50 );
        printArray(array);
        int x = array[index1];
        array[index1] = array[index2];
        array[index2] = x;
        printArray(array);
    }

    /*
     * Array Algorithm #5.1: findMax
     *  creates an array filled with random numbers
     *  prints the array and the greatest number
     */
    public static void findMax() 
    {
        int[] randomArray = createRandomArray( 10, 100 );
        int highestValue = 0;
        for (int i = 0; i < randomArray.length; i++)
        {
            if (randomArray[i] > highestValue)
            {
                highestValue = randomArray[i];
            }
        }
        printArray( randomArray );
        System.out.println("The highest value is: " + highestValue);
    }

    /*
     * Array Algorithm #5.2: findMin
     *  creates an array filled with random numbers
     *  prints the array and the least number
     */
    public static void findMin()
    {
        int[] array = createRandomArray( 10, 50 );
        int min = 50;
        for( int i = 0; i < array.length; i++ )
        {
            if(array[i] < min)
            {
                min = array[i];
            }
        }

        printArray( array );
        System.out.println("min: " + min);
    }

    /*
     * Array Algorithm #6: Copying Arrays
     *  creates an array filled with random numbers
     *  creates a new array of the same size
     *  copies elements from the first array into the new array
     *  prints the original array and the new array
     *  returns the new array
     */
    public static int[] copyArray()
    {
        int[] array1= createRandomArray(10,20);
        int[] array2= new int[array1.length];

        for(int i=0; i<array1.length; i++)
        {
            array2[i]=array1[i];
        }

        printArray(array1);
        printArray(array2); 

        return array2;
    }

}