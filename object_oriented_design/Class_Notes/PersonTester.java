import java.util.*;

public class PersonTester
{
    public static void main (String[] args)
    {
        Scanner s = new Scanner (System.in);
        ArrayList <Person> list = new ArrayList<Person>();
      
        for (int i = 0; i < 10; i++)
        {
            System.out.println("Give a name kid: ");
            String next = s.next();
            Person person = new Person(next);
            list.add(person);
           
        }
        
        Collections.sort(list);
        System.out.println("First: " + list.get(0).getName());
        System.out.println("Last: " + list.get(list.size()-1).getName());
        Person first = list.get(0);
        Person last = list.get(0);
        for (int i = 1; i < list.size(); i++)
        {
            if (list.get(i).compareTo(first) < 0 )
            {
                first = list.get(i);
            }
            if (list.get(i).compareTo(last) > 0 )
            {
                last = list.get(i);
            }
        }
        
        
        System.out.println("First: " + first.getName()+ "; Last: " + last.getName());
    }
}
