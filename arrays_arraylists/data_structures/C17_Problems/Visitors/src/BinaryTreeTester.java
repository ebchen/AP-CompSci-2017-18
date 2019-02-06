package Visitors;

import java.util.Scanner;

public class BinaryTreeTester
{
   public static void main(String[] args)
   {
      // Tree from page 777 in sorted order
      BinaryTree names =
         new BinaryTree("Juliet",
            new BinaryTree("Diana",
               new BinaryTree(), new BinaryTree("Harry")),
            new BinaryTree("Tom",
               new BinaryTree("Romeo"), new BinaryTree()));

      // Lambda expression (Section 10.4) for visitor
      Visitor visitor = (data) -> System.out.print(data + " ");

      System.out.print("Inorder traversal: ");
      names.inorder(visitor);
      System.out.println();
      System.out.println("Expected: Diana Harry Juliet Romeo Tom");

      System.out.print("Preorder traversal: ");
      names.preorder(visitor);
      System.out.println();
      System.out.println("Expected: Juliet Diana Harry Tom Romeo ");


      System.out.print("Postorder traversal: ");
      names.postorder(visitor);
      System.out.println();
      System.out.println("Expected: Harry Diana Romeo Tom Juliet");
   }
}
