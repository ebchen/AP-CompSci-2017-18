import java.util.*;
import java.io.*;

public class Maze {
    private Square [][] maze;
    private int numRows;
    private int numCols;
    public Square start;
    public Square finish;

    public boolean loadMaze (String fname)
    {

        try {
            File f = new File(fname);
            Scanner s = new Scanner(f);

            this.numRows = s.nextInt();
            this.numCols = s.nextInt();

            this.maze = new Square[numRows][numCols];

            for (int r = 0; r < numRows; r++) {
                for (int c = 0; c < numCols; c++) {
                    int type = s.nextInt();
                    if (type == 2) {
                        this.start = new Square(r,c,type);
                        maze[r][c] = start;
                    }
                    else if (type == 3) {
                        this.finish = new Square(r,c,type);
                        maze[r][c] = finish;
                    }
                    else maze[r][c] = new Square(r, c, type);
                    //System.out.println(maze[r][c]);
                }
            }
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public ArrayList<Square> getNeighbors(Square sq)
    {
        int[] dX = {-1,0,1,0};
        int[] dY = {0,1,0,-1};
        ArrayList<Square> neighbors = new ArrayList<>();
        for (int i = 0; i < 4; i++)
        {

            int newX = sq.getRow() + dX[i];
            int newY = sq.getCol() + dY[i];

            if ((newX >= 0 && newX < numRows) && (newY >= 0 && newY < numCols))
            {
                if (maze[newX][newY].getType() != 1) neighbors.add(maze[newX][newY]);

            }
        }

        return neighbors;
    }

    public Square getStart()
    {
        return this.start;
    }
    public Square getFinish()
    {
        return this.finish;
    }

    public void reset()
    {
        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numCols; j++)
            {
                maze[i][j].reset();
            }
        }
    }

    public String toString()
    {
        String s = "";
        for (int i = 0; i < maze.length; i++)
        {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == start) sb.append("S");
                else if (maze[i][j] == finish) sb.append("E");
                else if (maze[i][j].status == 2) sb.append("x");
                else if (maze[i][j].status == 1) sb.append ("o");
                else sb.append(maze[i][j]);
            }
            s = s + new String(sb) + "\n";
        }
        return s;
    }

}
