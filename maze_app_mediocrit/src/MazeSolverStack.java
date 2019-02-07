
public class MazeSolverStack extends MazeSolver
{
    private MyStack<Square> s;

    public MazeSolverStack(Maze m)
    {
        super(m);
        s = new MyStack<>();
        add(maze.start);
    }
    public void makeEmpty()
    {
        s = new MyStack<>();
    }
    public boolean isEmpty()
    {
        return s.isEmpty();
    }
    public void add(Square sq)
    {
        s.push(sq);
    }
    public Square next()
    {
        if (s.isEmpty()) return null;
        return s.pop();
    }


    public static void main ( String[] args)
    {
        System.out.println("Path for maze 1: ");
        Maze mazeTest1 = new Maze();
        mazeTest1.loadMaze("src/maze-1");
        MazeSolverStack s1 = new MazeSolverStack(mazeTest1);
        s1.solve();

        System.out.println("Path for maze 2: ");
        Maze mazeTest2 = new Maze();
        mazeTest2.loadMaze("src/maze-2");
        MazeSolverStack s2 = new MazeSolverStack(mazeTest2);
        s2.solve();

        System.out.println("Path for maze 3: ");
        Maze mazeTest3 = new Maze();
        mazeTest3.loadMaze("src/maze-3");
        MazeSolverStack s3 = new MazeSolverStack(mazeTest3);
        s3.solve();

        System.out.println("Path for maze 81: ");
        Maze mazeTest81 = new Maze();
        mazeTest81.loadMaze("src/maze-81a");
        MazeSolverStack s81 = new MazeSolverStack(mazeTest81);
        s81.solve();

    }

}