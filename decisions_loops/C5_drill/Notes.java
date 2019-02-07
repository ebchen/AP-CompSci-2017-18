import java.util.Scanner;

/**
 * Write a description of class Notes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Notes
{
    public static void main ( String[] args )
    {
        /*
         * Math.random() returns a double between 0.0 (inclusive) and
         *      1.0 (exclusive) [0.0. 1)
         * 
         *  To generate a random omteger netweem 0 (inclusive) and
         *      x (exclusive), multiply by x and cast to an int:
         *      
         *      (int)( Math.random() * x )
         */
        
        // model a coin flip ; 1: heads; 0: tails
        int coinFlip = (int)( Math.random() * 2 );
        
        /*
         * if statement
         *      statements are executed if the conditiojnal expression is true
         *      conditional expression must go inside of parentheses
         *      statements are group by blocks (i.e., { } )
         *          not by identation like in Python
         *          no colon after the conditional expression
         */
        if ( coinFlip == 1 )
        {
            System.out.println( "Coin is heads!" );
        }
        
        /*
         *  { } are not required for a single statement
         *      However, theya re a always a good idea.
         *      Leaving them out can lead to bugs like this: 
         */
        if ( coinFlip == 0 )
            System.out.println( "Coin is tails!" );
            System.out.println( "Better luck next time..." );
            
        /*
         * if-else is executed if the conditional for the if
         *      statement is false
         */
        if ( coinFlip == 1 )
        {
           System.out.println( "Coin is heads!" );
        }
        else
        {
            System.out.println( "Coin is tails!" );
            System.out.println( "Better luck next time..." );
        }
        
        //simulate the roll of a four-sided die (1-4)
        int dieRoll = (int)( Math.random() * 4 ) + 1;
        
        /*
         * if-else if-else statement
         *      In Java, "else if" is used instead of "elif" like Python
         */
        
        if ( dieRoll == 1 )
        {
            System.out.println( "rolled a 1" );
        }
        else if ( dieRoll == 2)
        {
            System.out.println( "rolled a 2" );
        }
        else if ( dieRoll == 3)
        {
            System.out.println( "rolled a 3" );
        }
        else
        {
            System.out.println( "rolled a 4" );
        }
    }
    
    public static boolean doublesAreEqual( double num1, double num2 )
    {
        /*
         * If we use the equality operator (==) for double, it
         *      will only return if all binary digits match.
         * This is probably not the case and now what we want.
         * We will check if they are "close enough" (i.e., epsilon value)
         */
        
        final double EPSILON = 1e-14;
        
        if (Math.abs( num1- num2) < EPSILON)
        {
            return true;
        }
        else
        {
            return false;
        }
        
        // don't have to use an if statement
        // return (Math.abs(num1-num2) < EPSILON );
    }
    
    public static void stringExample()
    {
        Scanner s = new Scanner(System.in);
        System.out.print( "enter two strings: " );
        String str1 = s.next();
        String str2 = s.next();
        
        /*
         * The equality operator (==) returns true if the two variables
         *      (e.g., str1 and str2) contatin the same value. For objects,
         *      including Strings, this means that the contain the same
         *      reference. That is, they refer to the same object in memory,
         *      not that the two Strings have the same sequence of characters
         */
        if (str1==str2)
        {
            System.out.println( "string references are equal.");
        }
        else 
        {
            System.out.println( "string references are not equal.");
        }
        
        /*
         * The equals method returns true if the two objects are "equal".
         *      What equals means is defined by that class. For Strings,
         *      it means that the two objects have the same sequence of
         *      characters.
         */
        if (str1.equals( str2 ))
        {
            System.out.println( "strings are equal" );
        }
        else
        {
            System.out.println( "strings are not equal" );
        }
        
        /*
         * We will determine which string comes first lexographically
         *      using the compareTo method of the String class
         *      
         * compareTo returns:
         *      0: if the strings are equal (same sequence of characters)
         *      < 0: if str1 < str2 lexographically
         *      > 0: if str1 > str2 lexographically
         */
        int result = str1.compareTo(str2);
        String firstStr = null;
        if (result < 0)
        {
            firstStr = str1;
        }
        else if (result > 0)
        {
            firstStr = str2;             
        }
        if (firstStr != null )
        {
            System.out.println( "The first string is: " + firstStr );
            System.out.println( "Its length is: " + firstStr.length());
        }
        else
        {
            System.out.println( "strings are equal." );
        }
        
        /*
         * This is an example of a "short circuit"
         *      If the left operand is false, the rigjht operand will
         *      not be evaluated because the AND opeation is already
         *      determined to be false.
         */
        if ( firstStr != null && firstStr.length() > 3)
        {
            System.out.println( "The first string has more than 3 characters." );
        }
        
        /*
         * This is another "short circuit" example.\
         *      If the left operand is true, the right operand will
         *      not be evaluated because the OR operation is already
         *      determined to be true.
         * This may result in a bug, if the first word entered is "kiwi",
         *      we will never read the second word from the terminal which
         *      may result in unexpected behavior later.
         */
        System.out.println( "Enter your two favorite fruits," );
        if( s.next().equals("kiwi") || s.next().equals("kiwi"))
        {
            System.out.println( "Kiwi is one of my favorite fruits too!" );
        }
        
        System.out.print( "Enter your favorite ice cream flavor." );
        String flavor = s.next();
        System.out.println("favorite flavor " + flavor );
    }
    
    public static String getStudentClass( int gradeNumber )
    {
        /*
         * switch statement
         *      another conditional decision statement (like if statement)
         *      preferred when evaluating several *discrete* values
         *      can only be used for byte, short, char, and int primitive types
         *      can also be used for enumerations and String objects
         *  The condition is evaluated, flow of execution jumps to the
         *      case that matches
         */
        String studentClass = "";
        switch( gradeNumber )
        {
            case 9:
            {
                studentClass = "freshman";
               
                /*
                 * break causes the flow of execution to leave the switch
                 * 
                 *  (without a break, the flow of execution continues
                 *      into the next case)
                 */
                break;
            }
            case 10:
            {
                studentClass = "sophmore";
                break;
            }
            case 11:
            {
                studentClass = "junior";
                break;
            }
            case 12:
            {
                studentClass = "senior";
                break;
            }
            
            /*
             * by leaving out the break, multiple cases can run the
             *      same code
             */
            case 6:
            case 7:
            case 8:
            {
                studentClass = "junior high";
                break;
            }
            
            /*
             * default matches everything not matched by one of the cases
             */
            default:
            {
                studentClass = "elementary";
                break;
            }
        }
        
        return studentClass;
    }
    
    public static void incrementExample()
    {
        /*
         * post increment/decrement operator
         *      equivalent to adding/subtracting 1
         *      returns the value before performing the increment/decrement
         */
        int x=3;
        x++;        //  x is now 4; this is equivalent to x += 1
        int a = 7;
        int b = a++;
        
        System.out.println( "a = " + a + "; b = " + b); //a = 8; b = 7
        
        /*
         * pre increment/decrement operator
         *      returns the value after performing the increment/decrement
         */
        int c = 7;
        int d = ++c;
        System.out.println( "c = " + c + "; d = " + d); //c = 8; d = 8
        
        /*
         * assignment operators: +=, -=, *=, /=, %=
         *      same as in Python
         *      performs the specified operation and then assigns the
         *          resulting value
         */
    }
    public static void stringCompare()
    {
        
        String word1 = "catalog";
        String word2 = "cat";
        
        int condition1 = word1.compareTo("aaa");
        int condition2 = word1.compareTo(word2);
        int condition4 = word1.substring(0,3).compareTo(word2.substring(0,3));
        
        if (condition1 < 0)
        {
            System.out.println("Word1 comes before aaa");
        }
        else if (condition1 > 0)
        {
            System.out.println("Word1 comes after aaa");
        }
        else
        {
            System.out.println("Word1 is equal to aaa");
        }
        
        if (condition2 < 0)
        {
            System.out.println("Word1 comes before word2");
        }
        else if (condition2 > 0)
        {
            System.out.println("Word1 comes after word2");
        }
        else
        {
            System.out.println("Word1 is equal to word2");
        }
        
        if (condition4 == 0)
        {
            System.out.println("Word1 and Word2 have the same three-letter prefix");
        }
        else
        {
            System.out.println("they dont have the same 3-letter prefix");
        }
        
    }
}
