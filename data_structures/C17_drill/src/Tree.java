import java.util.List;
import java.util.ArrayList;

/**
   A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
   private Node root;

   class Node
   {

       public Object data;
       public List<Node> children;


      /**
         Computes the size of the subtree whose root is this node.
         @return the number of nodes in the subtree
      */
      public int size()
      {
         int sum = 1;
         for (Node child : children)
         {
             sum += child.size();
         }
         return sum;
      }
   }

   /**
      Constructs an empty tree.
   */
   public Tree()
   {
      this.root = null;
   }

   /**
      Constructs a tree with one node and no children.
      @param rootData the data for the root
   */
   public Tree(Object rootData)
   {
      this.root = new Node();
      this.root.data = rootData;
      this.root.children = new ArrayList<>();
   }

   /**
      Adds a subtree as the last child of the root.
   */
   public void addSubtree(Tree subtree)
   {
      this.root.children.add(subtree.root);
   }

   /**
      Computes the size of this tree.
      @return the number of nodes in the tree
   */
   public int size() 
   {
       if (this.root == null) return 0;
       else return this.root.size();
   }

   // Additional methods will be added in later sections.

   /**
    * A visitor whose visit method is called for each visited node during a tree traversal.
    */
   public interface Visitor
   {
      /**
       * This method is called for each visited node.
       * @param data the data of the node
       *
       */
      void visit (Object data);
   }

   /**
    * Traverses this tree in preorder.
    * @param v the visitor to be invoked at each node
    */
   public void preorder(Visitor v)
   {
      Tree.preorder(this.root,v);
   }

   /**
    * Traverses the tree with a given root in preorder.
    * @param n the root of the tree
    * @param v the visitor to be invoked at each node
    */
   private static void preorder(Node n, Visitor v) {
      if (n == null)
      {
         return;
      }
      v.visit(n.data);
      for (Node c: n.children)
      {
         Tree.preorder(c,v);
      }
   }

   /**
    * Traverses this tree in postorder.
    * @param v the visitor to be invoked at each node
    */
   public void postorder(Visitor v)
   {
      Tree.postorder(this.root,v);
   }

   /**
    * Traverses the tree with a given root in postorder.
    * @param n the root of the tree
    * @param v the visitor to be invoked at each node
    */
   private static void postorder(Node n, Visitor v) {
      if (n == null)
      {
         return;
      }

      for (Node c: n.children)
      {
         Tree.postorder(c,v);
      }
      v.visit(n.data);
   }

   /**
    * Traverses this tree in inorder.
    * @param v the visitor to be invoked at each node
    */
   public void inorder(Visitor v)
   {
      Tree.postorder(this.root,v);
   }

   /**
    * Traverses the tree with a given root in inorder.
    * @param n the root of the tree
    * @param v the visitor to be invoked at each node
    */
   private static void inorder(Node n, Visitor v) {
      if (n == null)
      {
         return;
      }

      for (Node c: n.children)
      {
         Tree.preorder(c,v);
         v.visit(n.data);
      }

   }
}
