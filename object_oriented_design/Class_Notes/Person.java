
public class Person implements Comparable<Person>
{
    private String name;
    public Person(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int compareTo(Person other)
    {
        return this.name.compareTo(other.getName());
    }
}
