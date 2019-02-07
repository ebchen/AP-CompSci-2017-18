import java.util.Scanner;
public class LeapYear
{
    public static boolean isLeapYear(int year)
    {
        if (((year%100 == 0)&&(year%400!=0))||(year%4!=0))
        {
            return false;
        }
        
        else return true;
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int theYear = scan.nextInt();
        System.out.println("Year is a leap year: " + isLeapYear(theYear));
    }
}