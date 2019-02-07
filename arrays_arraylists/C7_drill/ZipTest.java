import java.util.Scanner;
/**
 * ZipTest Class.
 * Takes in names and zipcodes and prints the person with the smallest zipcode
 *
 * @author ebchen
 * @version 15 December 2017
 */

public class ZipTest
{
    public static void main( String [] args)
    {
        PersonWithZip[] arrayZips = new PersonWithZip[3];       //initializes array that can store 3 PersonWithZip objects
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < arrayZips.length; i++)              //fills the array with 3 names and zipcodes
        {
            System.out.println ("Enter first name, last name, and zip code for person #" + (i+1) + " with fields separated by a space");
            String firstname = s.next();
            String lastname = s.next();
            int zipcode = s.nextInt();
            
            PersonWithZip person = new PersonWithZip(firstname, lastname, zipcode);     //creates new object with inputs
            arrayZips[i] = person;                                                      //new object goes into array
        }
        
        for (PersonWithZip person : arrayZips)                                      //enhanced for loop prints all objects in array
        {
            System.out.println(person.toString());      // or could just be person; automatically prints with toString
        }
        
        System.out.println("The following person has the least numbered zip code");
        int min = arrayZips[0].getZip();                                            //stores the smallest zipcode
        int index = 0;                                                              //stores the index of the smallest zipcode
        for (int i = 0; i < arrayZips.length; i++)                                  //loops through array
        {
            if (arrayZips[i].getZip() < min)        
            {
                min = arrayZips[i].getZip();
                index = i;
            }
        }
        System.out.println(arrayZips[index].toString());                            //prints the person with smallest zipcode and the zipcode
       
        
    }
}
