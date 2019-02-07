
/**
 * This class models a car.
 * 
 * @author EBChen
 * @version 11 September 2017
 */
public class Car
{
    /*
     * Instance variables store the object's properties
     *      specify the visibility (e.g., private)
     *          public: accessible by anyone
     *          private: only accessible by methods in this class
     *      specify the type (e.g., double)
     *      specify the name (e.g., efficiency)
     *      
     *  Instance variables differ from local variables in the following ways:
     *      scoped to their object (accessible from all methods)
     *      automatically initialized to a default value (0, false, null)
     *      
     */
    private double fuelEfficiency; // in units of miles per gallon
    private double fuelInTank; // in units of gallons
    
    /*
     * When defining a method, specify:
     *      the visibility (e.g., public)
     *      the return type (e.g., void)
     *      the method name (e.g., drive)
     *      the parameters and their types (e.g., distance of type double)
     *      
     */
    
    /*
     * Constructor:
     *      responsible for initializing newly created objects
     *      invoked automatically via the new operator
     *      name of the constructor must match the name of the class
     *      has no return type (not even void)
     *      multiple contructors may be defined for a class
     *      one constructor may call another constructor (with restrictions)
     */
    
    /**
     * Default constructor for the Car class.
     *  Sets the fuel efficienct to 30 mpg.
     */
    public Car()
    {
        
    }
    
    /**
     * Constructs a Car object with the specified initial fuel efficiency.
     * 
     * @param initialEfficiency the initial fuel efficiency, in miles per gallon,
     *              of this new car
     */
    public Car (double fuelEfficiency)
    {
        /*
         * If the parameter was named fuelEfficiency, it would "shadow" the
         *      instance variable fuelEfficiency.
         * Local and parameter variable "shadow" instance variables of the
         *      same name. In this code, fuelEfficiency would refer to the
         *      parameter and not the instance variable.
         * To refer to the instance variable, use "this", which is
         *      is a reserved word that references the current object
         *      (like self in Python)
         * I think it is good practice to use "this" almost always
         * When it is possible, use unique parameter names
         */
        this.fuelEfficiency = fuelEfficiency;
        this.fuelInTank = 0;
    }
    
    /**
     * Drives this car the specified distance, consuming fuel
     * 
     * @param distance the distance, in miles, this car drives
     */
    public void drive (double distance)
    {
        this.fuelInTank -= (distance / this.fuelEfficiency );
    }
    
    /**
     * add the specified amount of fuel to this car's tank
     * 
     * @param amount the amount of fuel, in gallons, to add to this car's tank
     */
    public void addGas ( double amount)
    {
        this.fuelInTank += amount;
    }
    
    /**
     * Returns the amount of fuel in this car's tank
     * 
     * @return the amount of fuel, in gallons, in this car's tank
     */
    public double getGasInTank()
    {
        return this.fuelInTank;
    }
    
    /**
     * Returns a String that describes this object.
     * 
     * @return a String that describes this object.
     */
    public String toString()
    {
        String str = "fuel efficiency: " + this.fuelEfficiency + "; " + 
            "fuel in tank: " + this.fuelInTank;
        return str;
    }
}
