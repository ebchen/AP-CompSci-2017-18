/**
 * PersonWithZip Class.
 * Encapsulates a person's name and zipcode
 *
 * @author ebchen
 * @version 15 December 2017
 */

public class PersonWithZip
{
    private String firstName;       //variable stores the first name
    private String lastName;        //variable stores the last name
    private int zipCode;            //variable stores the zipcode
    
    /**
     * PersonWithZip Class constructor,
     * initializes all instance variables
     * 
     * @param first first name
     * @param last last name
     * @param zip zipcode
     */
    public PersonWithZip(String first, String last, int zip)
    {
        this.firstName = first;
        this.lastName = last;
        this.zipCode = zip;
    }
    
    /**
     * returns the zipcode
     * 
     * @return the zipcode value
     */
    public int getZip()
    {
        return this.zipCode;
    }
    
    /**
     * returns a string containing all instance variables
     * 
     * @return string containing all instance variables
     */
    public String toString()
    {
        String output = "Name: " + this.firstName + " " + this.lastName + ", zipcode: " + this.zipCode;
        return output;
    }
}
