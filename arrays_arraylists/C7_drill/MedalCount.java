
public class MedalCount
{
    final int COUNTRIES = 7;
    final int MEDALS = 3;

    private int [][] counts = 
        {
            { 1 , 0 , 1 },
            { 1 , 1 , 0 },
            { 0 , 0 , 1 },
            { 1 , 0 , 0 },
            { 0 , 1 , 1 },
            { 0 , 1 , 1 },
            { 1 , 1 , 0 },
        };

    public MedalCount()
    {
        /*
         * Alternate ways to initialize a 2D array
         */
        //this.counts = new int[COUNTRIES][MEDALS];
    }

    /**
     * prints the entire medal table
     */
    public void printTable()
    {
        // good: for (int row= 0; row < COUNTRIES; row++)
        // better:
        for (int row= 0; row < this.counts.length; row++)
        {
            // good: for ( int col = 0; col < MEDALS; col++)
            // better: for ( int col = 0; col < this.counts[0].length; col++)
            // best: 
            for ( int col = 0; col < this.counts[row].length; col++)
            {
                System.out.print( this.counts[row][col] + "\t" );
            }
            System.out.println();
        }
    }

    /**
     * Sum the number of medals for the specifide couuntry index
     *
     * @param  countryIndex the index of the country in the table whose
     *                              medals to sum
     * @return the sum of the medals for the specified country index
     */
    public int sumMedals(int countryIndex)
    {
        int sum = 0;
        for (int col = 0; col < this.counts[countryIndex].length; col++)
        {
            sum += this.counts[countryIndex][col];

        }
        return sum;
    }

    /**
     * Sum the medals of a given type specified by the medal index
     *
     * @param  medalIndex the index of given type of medal to sum
     * @return sum of the medals of a given type specified by the medal index
     */
    public int sumMedalByType(int medalIndex)
    {
        int sum = 0;
        for (int row = 0; row < counts.length; row++)
        {
            sum += this.counts[row][medalIndex];
        }
        return sum;
    }

}

