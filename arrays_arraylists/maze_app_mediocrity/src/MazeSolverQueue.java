import java.util.*;
import java.io.*;

public class MazeSolverQueue extends MazeSolver{

    private MyQueue<Square> q;

    public MazeSolverQueue(Maze m)
    {
        super(m);
        q = new MyQueue<>();
        add(maze.start);
    }
    public void makeEmpty() //create an empty worklist
    {
        q = new MyQueue<>();
    }
    public boolean isEmpty() //return true if the worklist is empty
    {
        return q.isEmpty();
    }
    public void add(Square sq) // add the given Square to the worklist
    {
        q.enqueue(sq);
    }
    public Square next() //return the "next" item from the worklist
    {
        return q.dequeue();
    }

    public static void main ( String[] args)
    {
        System.out.println("Path for maze 1: ");
        Maze mazeTest1 = new Maze();
        mazeTest1.loadMaze("src/maze-1");
        MazeSolverQueue s1 = new MazeSolverQueue(mazeTest1);
        s1.solve();

        System.out.println("Path for maze 2: ");
        Maze mazeTest2 = new Maze();
        mazeTest2.loadMaze("src/maze-2");
        MazeSolverQueue s2 = new MazeSolverQueue(mazeTest2);
        s2.solve();

        System.out.println("Path for maze 3: ");
        Maze mazeTest3 = new Maze();
        mazeTest3.loadMaze("src/maze-3");
        MazeSolverQueue s3 = new MazeSolverQueue(mazeTest3);
        s3.solve();

        System.out.println("Path for maze 81: ");
        Maze mazeTest81 = new Maze();
        mazeTest81.loadMaze("src/maze-81a");
        MazeSolverQueue s81 = new MazeSolverQueue(mazeTest81);
        s81.solve();
    }
}
