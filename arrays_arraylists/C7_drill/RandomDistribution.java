import java.util.Scanner;
public class RandomDistribution
{
    private int totalRolls;
    private int range;
    private int[] counter;

    public RandomDistribution(int x, int y)
    {
        totalRolls = x;
        range = y;
        counter = new int[range];
    }

    public void generate()
    {
        for (int i = 0; i < totalRolls; i++)
        {
            int x = (int)(Math.random() * range);
            counter[x]++;
        }
    }

    public void print()
    {
        for (int i = 0; i < counter.length; i++)
        {
            System.out.println (i + "   " + counter[i]);
        }
    }
    
    public static void main(String [] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("How many random numbers do you want to generate? ");
        int x = s.nextInt();
        System.out.println("What is the number of values for each random draw? ");
        int y = s.nextInt();
        
        RandomDistribution rand = new RandomDistribution(x,y);
        rand.generate();
        rand.print();
    }
}
