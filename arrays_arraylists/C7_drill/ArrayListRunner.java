import java.util.ArrayList;

public class ArrayListRunner
{
    public static void main(String[] args)
    {
        ArrayList<String> names = new ArrayList<String>();
        System.out.println(names);

        //a
        names.add("Alice");
        names.add("Bob");
        names.add("Connie");
        names.add("David");
        names.add("Edward");
        names.add("Fran");
        names.add("Gomez");
        names.add("Harry");
        System.out.println(names);

        //b
        System.out.println("First: " + names.get(0));
        System.out.println("Last: " + names.get(names.size()-1));

        //c
        System.out.println(names.size());

        //d
        System.out.println("Last: " + names.get(names.size()-1));

        //e
        names.set(0, "Alice B. Toklas");
        System.out.println(names);

        //f
        names.add(4, "Doug");
        System.out.println(names);

        //g
        for (String name: names)
        {
            System.out.println(name);
        }

        //h
        ArrayList<String> names2 = new ArrayList<String>(names);
        System.out.println(names);
        
        //i
        names.remove(0);
        System.out.println(names);
        System.out.println(names2);
        
    }
} 