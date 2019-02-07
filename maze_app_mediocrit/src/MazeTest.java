import junit.framework.TestCase;
import java.util.*;

public class MazeTest extends TestCase{
    Maze mazeTest;

    public void testLoadMaze()
    {
        this.mazeTest = new Maze();
        mazeTest.loadMaze("src/maze-1");
        assertEquals("S__\n___\n__E\n", mazeTest.toString());
    }
    public void testGetNeighbors()
    {
        this.mazeTest = new Maze();
        mazeTest.loadMaze("src/maze-1");
        Square testSquare = new Square(1,1,0);
        ArrayList<Square> testNeighbors = mazeTest.getNeighbors(testSquare);

        Square result = testNeighbors.get(0);
        assertEquals (0,result.getRow());
        assertEquals(1,result.getCol());
        assertEquals (0, result.getType());

        result = testNeighbors.get(1);
        assertEquals (1,result.getRow());
        assertEquals(2,result.getCol());
        assertEquals (0, result.getType());

        result = testNeighbors.get(2);
        assertEquals (2,result.getRow());
        assertEquals(1,result.getCol());
        assertEquals (0, result.getType());

        result = testNeighbors.get(3);
        assertEquals (1,result.getRow());
        assertEquals(0,result.getCol());
        assertEquals (0, result.getType());
    }

    public void testGetStart()
    {
        this.mazeTest = new Maze();
        mazeTest.loadMaze("src/maze-1");
        Square result = mazeTest.getStart();
        assertEquals (0,result.getRow());
        assertEquals(0,result.getCol());
        assertEquals (2, result.getType());
    }
    public void testGetFinish()
    {
        this.mazeTest = new Maze();
        mazeTest.loadMaze("src/maze-1");
        Square result = mazeTest.getFinish();
        assertEquals (2,result.getRow());
        assertEquals(2,result.getCol());
        assertEquals (3, result.getType());
    }
}

