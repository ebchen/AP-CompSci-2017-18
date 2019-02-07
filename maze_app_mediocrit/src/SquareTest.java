import junit.framework.TestCase;

public class SquareTest extends TestCase {

    public void testSetRow() {
        Square sq = new Square(1,2,3);
        sq.setRow(7);
        assertEquals(7,sq.getRow());
    }

    public void testSetCol() {
        Square sq = new Square(1,2,3);
        sq.setCol(6);
        assertEquals(6,sq.getCol());
    }

    public void testSetType() {
        Square sq = new Square(1,2,3);
        sq.setType(1);
        assertEquals(1,sq.getType());
    }

    public void testToString() {
        Square sq = new Square(1,2,3);
        String str = sq.toString();
        assertEquals("E",str);
    }


}