import java.util.*;

public class Grid
{
   private static final int SIZE = 10;
   int[][] pixels = new int[SIZE][SIZE];
   Stack<Pair> stack = new Stack<>();
   private int count = 1;
   /**
      Flood fill, starting with the given row and column.
   */
   public void floodfill(int row, int column)
   {
      int []dX = {-1,0,1,0};
      int [] dY = {0,1,0,-1};
      stack.push(new Pair(row,column));
      while (count <= SIZE*SIZE)
      {
         Pair coord = stack.pop();
         pixels[coord.row][coord.column] = count;
         count++;

         for (int i = 0; i < 4; i++)
         {
            int newX = coord.row + dX[i];
            int newY = coord.column + dY[i];

            if (newY < SIZE && newY >= 0 && newX < SIZE && newX >= 0 && pixels[newX][newY] == 0)
            {
               stack.push(new Pair(newX, newY));
            }
         }

      }
   }

   @Override
   public String toString()
   {
      String r = "";
      for (int i = 0; i < SIZE; i++)
      {
         for (int j = 0; j < SIZE; j++)
            r = r + String.format("%4d", pixels[i][j]);
         r = r + "\n";
      }
      return r;
   }
}

class Pair
{
   public int row;
   public int column;

   public Pair(int r, int c)
   {
      row = r;
      column = c;
   }
}