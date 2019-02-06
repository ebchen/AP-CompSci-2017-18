import java.util.ArrayList;

public class ListMethodsRunner
{
    // public static void main(String[] args)
    // {
    // ArrayList<Integer> tempList = ListMethods.makeList(100);
    // //ArrayList<Integer> reverseList = ListMethods.reverseList(tempList);
    // ArrayList <Integer> evenList = ListMethods.even(tempList);
    // ArrayList <Integer> oddList = ListMethods.odd(tempList);
    // if (tempList.size() == 0)
    // {
    // System.out.println("The list is empty");
    // }
    // else
    // {
    // for (Integer i : tempList)
    // {
    // System.out.println(i);
    // }
    // }

    // // if (reverseList.size() == 0)
    // // {
    // // System.out.println("The reverse list is empty");
    // // }
    // // else
    // // {
    // // for (Integer i : reverseList)
    // // {
    // // System.out.println(i);
    // // }
    // // }

    // if (oddList.size() == 0)
    // {
    // System.out.println("The odd list is empty");
    // }
    // else
    // {
    // for (Integer i : oddList)
    // {
    // System.out.println(i);
    // }
    // }

    public static void main(String[] args)
    {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(9);
        list1.add(22);
        list1.add(38);
        list1.add(56);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(4);
        list2.add(7);
        list2.add(8);
        list2.add(23);
        list2.add(37);      
        ArrayList<Integer> tempList = ListMethods.merge(list1, list2);
        if (tempList.size() == 0)
        {
            System.out.println("The list is empty");
        }
        else
        {
            for (Integer i : tempList)
            {
                System.out.println(i);
            }
        }
    }
}
