import java.util.ArrayList;
/**
 * The model for radar scan and accumulator
 * 
 * @author @gcschmit
 * @version 19 July 2014
 */
public class Radar
{

    // stores whether each cell triggered detection for the current scan of the radar
    // (true represents a detected monster, which may be a false positive)
    private boolean[][] currentScan;

    // value of each cell is incremented for each scan in which that cell triggers detection
    private int[][] accumulator;

    // location of the monster
    private Location monsterLocation;

    private ArrayList<Location>monsterLocations = new ArrayList<Location>();

    // probability that a cell will trigger a false detection (must be >= 0 and < 1)
    private double noiseFraction;

    // number of scans of the radar since construction
    private int numScans;

    /**
     * Constructor for objects of class Radar
     * 
     * @param   rows    the number of rows in the radar grid
     * @param   cols    the number of columns in the radar grid
     */
    public Radar(int rows, int cols)
    {
        // initialize the currentScan 2D array and the accumulator 2D array

        currentScan = new boolean[rows][cols];
        accumulator = new int[rows][cols];

        // randomly set the location of the monster (can be explicity set through the
        //  setMonsterLocation method for the unit test
        
        
        // I replaced this with the randomizeMonsterLocations method,
        // to add support for multiple monsters.
        // randomizeMonsterLocations is called in the RadarViewer class.
        /*
        int row = (int)(Math.random() * rows);
        int col = (int)(Math.random() * cols);
        this.monsterLocation = new Location( row, col );
        */
       
        this.noiseFraction = 0.05;
        this.numScans= 0;
    }
    
    /**
     * Sets monster locations.
     * Used when user choose to manually input monster locations.
     * Reads in data from an array list in RadarViewer
     * 
     * @param locations a list of locations to be set
     */
    public void setMonsterLocations(ArrayList<Location>locations)
    {
        for (int i = 0; i < locations.size(); i++)
        {
            monsterLocations.add(locations.get(i));
        }
    }
    
    /**
     * Randomizes a number of monster locations.
     * Used when user chooses not to manually input monster locations.
     * 
     * @param numberOfMonsters the number of monster locations to be generated
     */
    public void randomizeMonsterLocations(int numberOfMonsters)
    {
        for (int i = 0; i< numberOfMonsters; i++)
        {
            int row = (int)(Math.random() * accumulator.length);
            int col = (int)(Math.random() * accumulator[0].length);
            monsterLocations.add(new Location(row, col));
        }
    }

    /**
     * Performs a scan of the radar. Noise is injected into the grid and the accumulator is updated.
     * 
     */
    public void scan()
    {
        // algorithm for performing a scan:
        //    1. set all cells in the currentScan 2D array to false
        //    2. set the location of the monster in the currentScan 2D array
        //    3. inject noise into the grid by invoking the injectNoise method
        //    4. update the accumulator 2D array based on the state of the currentScan 2D array
        //    5. increment the numScans instance variable

        // 1)
        for (int i = 0; i < currentScan.length; i++)
        {
            for (int j = 0; j < currentScan[i].length; j++)
            {
                currentScan[i][j] = false;
            }
        }

        // 2)
        for (int i = 0; i < monsterLocations.size(); i++)
        {
            currentScan[monsterLocations.get(i).getRow()][monsterLocations.get(i).getCol()] = true;
        }
        

        // 3)
        injectNoise();

        // 4)
        for (int i = 0; i < currentScan.length; i++)
        {
            for (int j = 0; j < currentScan[i].length; j++)
            {
                if (currentScan[i][j] == true)
                {
                    accumulator[i][j]++;
                }
            }
        }

        // 5)
        numScans++;

    }

    /**
     * Sets the location of the monster
     * 
     * @param   row     the row in which the monster is located
     * @param   col     the column in which the monster is located
     * @pre row and col must be within the bounds of the radar grid
     */
    public void setMonsterLocation(Location loc)
    {
        // remember the monster's location
        this.monsterLocation = loc;
        monsterLocations.add(loc);

        // update the radar grid to show that something was detected at the specified location
        for (int i = 0; i < monsterLocations.size(); i++)
        {
            currentScan[ this.monsterLocations.get(i).getRow() ][ this.monsterLocations.get(i).getCol() ] = true;
        }

    }

    /**
     * Sets the probability that a given cell will generate a false detection
     * 
     * @param   fraction    the probability that a given cell will generate a flase detection expressed
     *                      as a fraction (must be >= 0 and < 1)
     */
    public void setNoiseFraction(double fraction)
    {   
        this.noiseFraction = fraction;
    }

    /**
     * Returns true if the specified location in the radar grid triggered a detection.
     * 
     * @param   row     the row of the location to query for detection
     * @param   col     the column of the location to query for detection
     * @return true if the specified location in the radar grid triggered a detection
     */
    public boolean isDetected(Location loc)
    {
        return this.currentScan[ loc.getRow() ][ loc.getCol() ];
    }

    /**
     * Returns a Location object containing the row and column of the detected monster based on analyzing the
     *  accumulator (not based on the monsterLocationRow and monsterLocationCol instance variables).
     * 
     * @return the location of the detected monster
     */
    public Location findMonster()
    {
        int max = accumulator[0][0];
        int x = 0;
        int y = 0;
        for (int i = 0; i < accumulator.length; i++)
        {
            for (int j = 0; j < accumulator[i].length; j++)
            {
                if (accumulator[i][j] > max)
                {
                    max = accumulator[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        return new Location(x,y);
    }

    /**
     * Returns the number of times that the specified location in the radar grid has triggered a
     *  detection since the constructor of the radar object.
     * 
     * @param   row     the row of the location to query for accumulated detections
     * @param   col     the column of the location to query for accumulated detections
     * @return the number of times that the specified location in the radar grid has
     *          triggered a detection since the constructor of the radar object
     */
    public int getAccumulatedDetection(Location loc)
    {
        return accumulator[ loc.getRow() ][ loc.getCol() ];
    }

    /**
     * Returns the number of rows in the radar grid
     * 
     * @return the number of rows in the radar grid
     */
    public int getNumRows()
    {
        return currentScan.length;
    }

    /**
     * Returns the number of columns in the radar grid
     * 
     * @return the number of columns in the radar grid
     */
    public int getNumCols()
    {
        return currentScan[0].length;
    }

    /**
     * Returns the number of scans that have been performed since the radar object was constructed
     * 
     * @return the number of scans that have been performed since the radar object was constructed
     */
    public int getNumScans()
    {
        return numScans;
    }

    /**
     * Sets cells as falsely triggering detection based on the specified probability
     * 
     */
    private void injectNoise()
    {
        // Iterate through all cells in the currentScan 2D array to inject noise by setting false positives
        // (detected monster where is there none) or false negatives (missed detection of a monster where is one).
        // The noiseFraction instance variable is the probability that a given cell will be
        // detected as a false positive or false negative. You must handle the cell containing the monster as a
        // special case since, if noise is being injected into that cell, that is a false negative and the cell must
        // be set to false.
        
        /*
        int monsterRow = monsterLocation.getRow();
        int monsterColumn = monsterLocation.getCol();
        */
       
       // sets false-positives
        for (int i = 0; i < currentScan.length; i++)
        {
            for (int j = 0; j < currentScan[i].length; j++)
            {
                double rand = Math.random();

                if (rand <= noiseFraction)
                {
                    currentScan[i][j] = true;
                }
            }
        }
        
        // sets false-negatives for monster locations
        for (int i = 0; i < monsterLocations.size(); i ++)
        {
            double rand = Math.random();
            if (rand <= noiseFraction)
            {
                currentScan[monsterLocations.get(i).getRow()][monsterLocations.get(i).getCol()] = false;
            }

        }

    }
}
