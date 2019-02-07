
/**
 * Write a description of class Converter here.
 *
 * @author ebchen   
 * @version 26 September 2017
 */
public class Converter
{
    public static double calculateAreaOfCircle( double radius )
    {
        /*
         * Instead of using a "magic number" (e.g., 3.14159), use 
         *      constants defined by the Java Standard Library.
         *      
         * For example, in Math.java:
         * 
         * public static final double PI = 3.141592654;
         * 
         * Static: one value for the variable for all objects of the class;
         *      can be accessed directly through the class
         *      (e.g., Math.PI)
         */
        double area = Math.PI * radius * radius;
        return area;
    }
    
    public static double convertFeetToLightyears ( double feet)
    {
        /*
         * Declare a constant with the final keyword.
         * 
         * If we try to change the value, a compiler error will be generated.
         */
        final double LIGHTYEARS_FOR_EVERY_FOOT = 3.22174e-17;
        double lightYears = feet * LIGHTYEARS_FOR_EVERY_FOOT;
        
        //LIGHTYEARS_FOR_EVERY_FOOT = 2;
        
        return lightYears;
    }
    
    public static void penniesToDollarsAndCents( int pennies )
    {
        final int PENNIES_FOR_EVERY_DOLLAR = 100;
        
        /*
         * Use integer division to calculate how many whole dollars
         *      based on the specificed number of dollars
         * 
         * Integer division discards the remainder (truncates)
         *      For example: (3/4) evaluates to 0; (3.0 / 4 ) evaluates to 0.75
         * If one or more of the operands are double,
         *      then it doesnt floating point division
         */
        int dollars = pennies / PENNIES_FOR_EVERY_DOLLAR;
        
        /*
         * Use the modulo (mod, remainder) operator to calculate how many
         *      cents remain.
         *      
         * The mod (%) operatore returns the remainder of the division operation.
         * 
         * It can be very useful when paired with integer division.
         * 
         * Examples:
         *      7 % 2 = 1;
         *      11 % 3 = 2;
         *      6 % 2 = 0;
         */
        int cents = pennies % PENNIES_FOR_EVERY_DOLLAR;
        
        System.out.println( "Dollars: " + dollars + ", Cents: " + cents );
    }
    
    public static void conversionExample()
    {
        /*
         * A conversion is when a data value is converted from one type
         *      to another (e.g., int to double, double to int, int to long
         *      
         * Widening: preserves information (e.g., int to double, int to long)
         * Narrowing (Lossy): may loose information (e.g., double to int)
         */
        int dollars = 25;
        double money = dollars; // okay; widening conversion
        
        //dollars = money; //compile-time error; narrowing conversion
        
        /*
         * Arithmetic Promotion
         * 
         *  If the two operands are of different types, Java attempts to
         *      promote one of the types (widening conversion) and then
         *      performs the operation.
         *      
         *  In this example, the value 4 is promoted to a double (4.0) and then
         *      floating point division is performed resulting in 4.25
         *      which is assigned to average.
         */
        double miles = 17.0;
        int days = 4;
        double average = miles/days;
        
        /*
         * This is another example of promotion
         * 
         *  In this case, both miles2 and days2 are ints, so Java doesn't
         *      perform any promotion, and instead, performs integer division.
         *      The result, 4, is promoted to a double, 4.0, and then assigned
         *      to average2.
         */
        int miles2 = 17;
        int days2 = 4;
        double average2 = miles2/days2;  
        
        /*
         * A cast is the "I know what I'm doing; trust me" conversion
         * 
         *  A cast can perform a narrowing conversion because we are 
         *      explcitly doing so.
         *      
         *  (int) 84.69 --> truncated to an int, specifically, 84
         */
        double price = 84.69;
        int wholeDollars = (int) price;
        
        /*
         * If we want to round a double to the nearest int value, use the
         *      Math.round static method:
         *      
         *      public static long round ( double value );
         *      public static int round( float value );
         *  This converts 84.69 to 85.0
         */
        int nearestDollar = (int)(Math.round( price ));
    }
    
}
