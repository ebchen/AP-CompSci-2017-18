import java.util.Scanner;

public class AnnuityCalculator
{
   public static void main(String[] args)
   {
      Scanner s = new Scanner(System.in);
      System.out.print ("Enter the PMT: ");
      double PMT = s.nextDouble();
      System.out.print ("Enter the i: ");
      double i = s.nextDouble();

      System.out.print ("Enter the n: ");
      double n = s.nextDouble();
      //double PMT = 10000;
      //double i = 0.08; 
      //double n = 20;
      
      double annuity = PMT  *  (( (Math.pow((1+i),(n-1)) - 1) / i ) / (Math.pow((1+i),(n-1))) + 1);
      
      System.out.println (annuity) ;
   }
}
