import java.util.Random;
public class DrunkardsWalk
{
    public static void main (String [] args)
    {
        Random generator = new Random();
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        
        for (int i = 0; i < 100; i++)
        {
            int choice = generator.nextInt(4);
            switch ( choice)
            {
                case 0:
                    up++;
                    break;
                case 1:
                    down++;
                    break;
                case 2:
                    left++;
                    break;
                case 3:
                    right++;
                    break;
            }
            
        }
        int x = right - left;
        int y = up - down;
        System.out.println( "(x,y): " + "(" + x + "," + y + ")");
        
    }
}
