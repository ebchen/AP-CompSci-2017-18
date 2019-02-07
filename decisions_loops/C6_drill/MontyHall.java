import java.util.Random;

public class MontyHall
{
    public static void main ( String [] args)
    {
        Random generator = new Random();
        
        int doorWithCar;
        int playerChoice;
        int hostGoatChoice;
        int strategy1 = 0;
        int strategy2 = 0;
        
        for (int i = 0; i < 1000; i++)
        {
            doorWithCar = generator.nextInt(3) + 1;
            playerChoice = generator.nextInt(3) + 1;
            do
            {
                hostGoatChoice = generator.nextInt(3) + 1;
            }
            while((hostGoatChoice == doorWithCar) || (hostGoatChoice == playerChoice));
            if (playerChoice == doorWithCar)
            {
                strategy2++;
            }
            else
            {
                strategy1++;
            }
        }
        
        System.out.println("Strategy 1 wins: " + strategy1);
        System.out.println("Strategy 2 wins: " + strategy2);
    }
    
}
