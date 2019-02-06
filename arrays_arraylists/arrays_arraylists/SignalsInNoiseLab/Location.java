/**
 * Class that encapsulates a row-column pair for a location
 * 
 * @author @ebchen
 * @version 15 December 2017
 */
public class Location
{
    
    // the column value for the location
    private int column;
    
    // the row value for the location
    private int row;
    
    /**
     * Constructor for objects of class Location
     *      initializes the instance variables.
     * 
     * @param row the row the location is at
     * @param col the column the location is at
     */
    public Location(int row, int col)
    {
        this.row = row;
        this.column = col;
    }
    
    /**
     * Get the row value of the location
     * 
     * @return the row of the location
     */
    public int getRow()
    {
        return this.row;
    }
    
    /**
     * Get the col value of the location
     * 
     * @return the column of the location
     */
    public int getCol()
    {
        return this.column;
    }
}
