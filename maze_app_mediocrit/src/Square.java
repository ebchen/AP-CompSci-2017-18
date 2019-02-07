import java.util.*;

public class Square {

    private int row;
    private int col;
    private int type; // 0 = empty, 1 = wall, 2 = start, 3 = exit
    public int status = 0; // 0 = unvisited, 1 = visited, 2 = the path

    public Square previous = null;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }




    public Square(int row, int col, int type)
    {
        this.row = row;
        this.col = col;
        this.type = type;
        this.previous = null;
    }

    public boolean equals(Square sq)
    {
        if (sq.row == this.row && sq.col == this.col && sq.type == this.type)
        {
            return true;
        }
        return false;
    }
    public void reset()
    {
        status = 0;
        previous = null;
    }

    public String toString()
    {
        String output ="";

        switch (type)
        {
            case 0:
                output += "_";
                break;
            case 1:
                output += "#";
                break;
            case 2:
                output += "S";
                break;
            case 3:
                output += "E";
                break;
        }

        return output;
    }
}
