import java.util.*;
import java.util.Scanner;

public class Main
{
   public static void main(String[] args)
   {
      Main main = new Main();
      main.go();
   }

   public void go()
   {
      int ary[] = {82, 79, 46, 16, 12, 39, 41, 6, 4, 11};

      createBinaryTree(ary);

      int root = getRoot(ary);
      System.out.printf("Root: %s%n", root);

      List leaves = getAllLeaves(ary);
      System.out.printf("Leaves: %s%n", leaves);

      List parents = getAllParents(ary);
      System.out.printf("Parents: %s%n", parents);

      boolean isMaxHeap1 = isMaxHeap(0, ary);
      System.out.printf("Is MaxHeap: %s%n", isMaxHeap1);
   }

   private Node addRecursive(Node current, int value) {
    if (current == null) {
        return new Node(value);
    }

    if (value < current.value) {
        current.left = addRecursive(current.left, value);
    } else if (value > current.value) {
        current.right = addRecursive(current.right, value);
    } else {
        // value already exists
        return current;
    }

    return current;
}

private BinaryTree createBinaryTree()
  {
    BinaryTree bt = new BinaryTree();

    for (i = 0; i < ary[].length; i++)
    {
      bt.add(ary[i]);
    }

    return bt;
  }

   // ---------------------------------------------------------------
   // return the value of the root of the tree represented by ary
   // ---------------------------------------------------------------
   public int getRoot(int ary[])
   {
      System.out.println(ary[0]);
      return -1;
   }

   // ---------------------------------------------------------------
   // return a list containing the values for all of the nodes in the
   // tree that are leaves
   // ---------------------------------------------------------------
   public List getAllLeaves(int ary[])
   {
      List l = new ArrayList();

      

      return l;
   }

   // ---------------------------------------------------------------
   // return a list containing the values for all of the nodes in the
   // tree that are parents
   // ---------------------------------------------------------------
   public List getAllParents(int ary[])
   {
      List l = new ArrayList();

      // your code goes here ...

      return l;
   }

   // ---------------------------------------------------------------
   // return true if the tree represented by ary is a valid max heap
   // ---------------------------------------------------------------
   public boolean isMaxHeap(int rootIndex, int ary[])
   {
      // your code goes here ...

      return false;
   }

   public void add(int value)
   {
      root = addRecursive(root, value);
   }
}
