import java.util.*;

public abstract class MazeSolver {

    protected Maze maze;
    protected boolean foundFinish;
    public boolean noPath;
    protected ArrayList<Square> path;
    public abstract void makeEmpty(); //create an empty worklist
    public abstract boolean isEmpty(); //return true if the worklist is empty
    public abstract void add(Square sq); // add the given Square to the worklist
    public abstract Square next(); //return the "next" item from the worklist
    MazeSolver(Maze maze) //  Create a (non-abstract) constructor that takes a Maze as a parameter and stores it in a variable that the children classes can access.
    {
        this.maze = maze;
        foundFinish = false;
        this.path = new ArrayList<>();
    }

    public boolean isSolved()//A non-abstract method that the application program can use to see if this algorithm has solved this maze. That is, has it determined the path to the exit or if there is no path.
    //This method will return true if either:
    // A path from the start to the exit has been found; OR
    // You determine there is no such path (worklist is now empty)
    {
        return foundFinish;
    }

    public String getPath() //using retrace() method instead
    //Returns either a string of the solution path as a list of coordinates [i,j] from the start to the exit or a message indicating no such path exists
    //If the maze isn't solved, you should probably return a message indicating such.
    {
        String p = "";
        if (foundFinish = true) {

            for (Square s : path) {
                String coords = "[" + s.getRow() + "," + s.getCol() + "]";
                p = p+ coords + " ";
            }
        }
        else {
            p = "no path";
        }
        return p;
    }
    public Square step()
    //perform one iteration of the algorithm above (i.e., steps 1 through 5) and return the Square that was just explored (and null if no such Square exists). Note that this is not an abstract method, that is, you should implement this method in the MazeSolver class by calling the abstract methods listed above.
    //In order to keep track of which squares have previously been added to the worklist, you will "mark" each square that you place in the worklist. Then, before you add a square to the worklist, you should first check that it is not marked (and if it is, refrain from adding it).
    //Here is the suggestion for marking a Square: have each Square keep track of which Square added it to the worklist (i.e., "Which Square was being explored when this Square was added to the worklist?"). That is, add a new class member Square previous to the Square class, which will represent the Square previous to the current one; initialize this variable to null in the constructor/reset method. Then, when a Square is being added to the list for the first time, you will set the previous variable to point to the current Square (the Square that is being explored). If the previous variable is already non-null, then this Square has already been placed on the list, and you should not do so again.
    //You may also want to add in additional methods to your Square class to help you with this.
    {
        if (isEmpty() && !isSolved())
        {
            noPath = true;
            return null;
        }
        Square n = next();
        if (n != null) {
            n.status = 1;
            for (Square s : maze.getNeighbors(n)) {
                if (s.previous == null && s != maze.start) {
                    s.previous = n;
                    String x = "" + s.getRow() + s.getCol();
                    String y = "" + n.getRow() + n.getCol();
                    add(s);
                }
            }
            if (n == maze.finish) {
                foundFinish = true;
                Square curr = maze.finish;
                while (curr.previous != null) {
                    curr.status = 2;
                    curr = curr.previous;
                }
                maze.start.status = 2;
            } else {
                foundFinish = false;
            }
        }
        else
        {
            noPath = true;
        }

        return n;
    }


    public String retrace(Square result)
    {
        String s = "";
        if (result == null)
        {
            s = s + "No path";
        }
        else if (isSolved()) {
            Stack<Square> stack = new Stack<>();
            stack.push(result);
            while (result.previous != null) {
                result = result.previous;
                stack.push(result);
                //String x = "" + result.getRow() + result.getCol() + result.getType();
                //System.out.println (x);
            }

            while (!stack.isEmpty()) {
                Square r = stack.pop();
                String x = "["+r.getRow()+","+r.getCol()+"]";
                s = s + x;
            }

        }
        else {
            s = s + "No path";
        }

        return s;
    }

    public void solve()
    {
        add(maze.start);
        Square result = step();
        while (result !=  maze.finish && !isEmpty() && !isSolved() && !noPath)
        {

            result = step();
            if (result == null) noPath = true;
            else if (result == maze.finish) foundFinish = true;
        }
        String output = retrace(result);
        System.out.println(output);
        return;
    }
    //repeatedly call step() until you get to the exit square or the worklist is empty.
}
