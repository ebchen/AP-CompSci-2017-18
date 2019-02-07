

import java.util.*;
/**
   Below is a renamed and modified version of the DecisionTreeDemo
   program from Section 17.2. Implement the animal guessing game described
   in Section 17.2.1. Start with the tree in Figure 4, but present
   the leaves as "Is it a(n) X?" If it wasn't, ask the user what the
   animal was, and ask for a question that is true for that animal
   but false for X. For example:

      Is it a mammal? Y
      Does it have stripes? N
      Is it a pig? N
      I give up. What is it? A hamster
      Please give me a question that is true for a hamster and false for a pig.
      Is it small and cuddly?

   In this way, the program learns additional facts.
   Use the BinaryTree class from Section 17.2.
*/
public class GuessingGame
{
    public static BinaryTree clone(BinaryTree tree, Queue<Integer> path, boolean onPath, String oldAnimal, String newAnimal, String question)
    {
        BinaryTree left = null;
        BinaryTree right = null;
        BinaryTree result = null;
        if (onPath)
        {
            if (path.isEmpty())
            {
                left = new BinaryTree(newAnimal);
                right = new BinaryTree(oldAnimal);
                return new BinaryTree(question, left, right);

            }
            else if (path.peek() == 0)
            {
                path.remove();
                left = clone(tree.left(), path, true, oldAnimal, newAnimal, question);
                BinaryTree r = tree.right();
                if (r.isEmpty()) right = null;
                else right = clone(tree.right(), path, false, oldAnimal, newAnimal, question);
            }
            else if(path.peek() == 1)
            {
                path.remove();
                BinaryTree l = tree.left();
                if (l.isEmpty()) left = null;
                else left = clone(tree.left(), path, false, oldAnimal, newAnimal, question);
                right = clone(tree.right(), path, true, oldAnimal, newAnimal, question);
            }
        }
        else
        {
            BinaryTree l = tree.left();
            if (l.isEmpty()) left = null;
            else left = clone (tree.left(), path, false, oldAnimal, newAnimal, question);
            BinaryTree r = tree.right();
            if (r.isEmpty()) right = null;
            else right = clone (tree.right(), path, false, oldAnimal, newAnimal, question);
        }

        result = new BinaryTree(tree.data(), left, right);


        return result;
    }
   public static void main(String[] args)
   {
      BinaryTree questionTree = new BinaryTree("Is it a mammal?",
         new BinaryTree("Does it have stripes?",
            new BinaryTree("Is it a carnivore?",
               new BinaryTree("Is it a tiger?"),
               new BinaryTree("Is it a zebra?")),
            new BinaryTree("Is it a pig?")),
         new BinaryTree("Does it fly?",
            new BinaryTree("Is it an eagle?"),
            new BinaryTree("Does it swim?",
               new BinaryTree("Is it a penguin?"),
               new BinaryTree("Is it an ostrich?"))));

      BinaryTree current = questionTree;
       Queue<Integer> path = new LinkedList<>();

      String response;
      Scanner in = new Scanner(System.in);
      System.out.println("Let's play a guessing game.");

      boolean keepGoing = true;
      while (keepGoing) {
          boolean done = false;
          current = questionTree;
          path = new LinkedList<>();
          while (!done) {
              BinaryTree left = current.left();
              BinaryTree right = current.right();
              if (left.isEmpty() && right.isEmpty()) {
                  done = true;
              } else {
                  do {
                      System.out.print(current.data() + " (Y/N) ");
                      response = in.nextLine().toUpperCase();
                  }
                  while (!response.equals("Y") && !response.equals("N"));

                  if (response.equals("Y")) {
                      current = left;
                      path.add(0);
                  } else {
                      current = right;
                      path.add(1);
                  }

              }
          }


          System.out.print(current.data() + " (Y/N) ");
          String answer = in.nextLine().toUpperCase();
          if (answer.equals("Y"))
          {
              String message = "Great, " + current.data();
              System.out.println(message.replace("Is it", "it is")
                      .replace("?", "."));
          }
          else {
              System.out.println("I give up. What is it?");
              String newAnimal = in.nextLine();
              String currAnimal = (String) current.data();
              currAnimal = currAnimal.replace("Is it a ", "").replace("?", "");
              System.out.println("Please give me a question that is true for a " + newAnimal + " and false for a " + currAnimal);
              String newQ = in.nextLine();
              questionTree = clone(questionTree, path, true, currAnimal, newAnimal, newQ);

          }
      }/*
      done = false;
      current = questionTree;
      while (!done)
      {
         BinaryTree left = current.left();
         BinaryTree right = current.right();
         if (left.isEmpty() && right.isEmpty())
         {
            done = true;
         }
         else
         {
            do
            {
               System.out.print(current.data() + " (Y/N) ");
               response = in.nextLine().toUpperCase();
            }
            while (!response.equals("Y") && !response.equals("N"));

            if (response.equals("Y"))
            {
               current = left;
            }
            else
            {
               current = right;
            }

         }
      }
      String message = "Great, " + current.data();
      System.out.println(message.replace("Is it", "it is")
         .replace("?", "."));
*/
   }
}
