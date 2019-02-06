

public class StringReverse
{
    public static String reverse(String str)
    {
        // 1. check the terminating case
        if ( str.equals(""))
        {
            return str;
        }
        
        // 2. simply the problem
        String firstChar = str.substring(0,1);
        
        // 3. solve a simpler problem
        String restOfString  = str.substring (1);
        String restOfStringReversed = reverse(restOfString);
        
        String strReversed =  restOfStringReversed + firstChar;
        return strReversed;
    } 
}
