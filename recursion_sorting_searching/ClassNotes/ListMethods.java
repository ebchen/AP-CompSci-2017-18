import java.util.*;

public class ListMethods
{
    public static ArrayList<Integer> makeList(int n)
    {
        ArrayList<Integer> tempList = null;
        if (n <= 0)  // The smallest list we can make
        {
            tempList = new ArrayList<Integer>();
            return tempList;
        }

        else        // All other size lists are created here
        {
            tempList = makeList(n-1);
            tempList.add(n);
        }
        return tempList;
    }

    public static ArrayList<Integer> reverseList(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = ListMethods.deepClone(tList); 
        if (list.size() <= 1)
        {
            return list;
        }
        else
        {
            int first = list.remove(0);
            list = reverseList(list);
            list.add(first);
        }
        return list;
    }

    public static ArrayList<Integer> deepClone(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        for (Integer i : tList)
        {
            list.add(new Integer(i));
        }
        return list;
    }

    public static ArrayList even(ArrayList<Integer> list)
    {
        ArrayList<Integer> result = ListMethods.deepClone(list); 
        if (list.size() <= 2)
        {
            ArrayList <Integer> p = new ArrayList<Integer>();
            p.add(result.get(0));
            return p;
        }

        else
        {
            int front =  result.remove(0);
            System.out.println("Front " + front);
            result.remove(0);
            result = even(result);
            result.add(0,front);
        }

        return result;
    }

    public static ArrayList odd(ArrayList<Integer> list)
    {
        ArrayList<Integer> result = ListMethods.deepClone(list); 
        if (list.size() <= 1)
        {
            ArrayList <Integer> p = new ArrayList<Integer>();

            return p;
        }

        else
        {
            result.remove(0);
            int front =  result.remove(0);
            result = odd(result);
            result.add(0,front);
        }

        return result;
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> list1, 
    ArrayList<Integer> list2)
    {
        if (list1.size() == 0)
            return list2;
        if (list2.size() == 0)
            return list1;

        ArrayList result = new ArrayList<Integer>();

        if (list1.get(0) < list2.get(0))// sorting
            result.add(list1.remove(0));
        else
            result.add(list2.remove(0));

        result.addAll(merge(list1, list2));

        return result;
    }
}