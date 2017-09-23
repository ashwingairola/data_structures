/*
Print Common Nodes in Two Binary Search Trees

Given two Binary Search Trees, find common nodes in them.
In other words, find intersection of two BSTs.

Example:

root1:
      5
    /   \
   1     10
 /  \   /
0    4  7
        \
         9

root2:
       10
     /    \
    7     20
   / \
  4   9

Output: 4 7 9 10
*/
import java.util.HashSet;

class Node
{
  int key;
  Node left, right;

  public Node(int key)
  {
    this.key = key;
  }
}

class BinarySearchTree
{
  private Node root;

  public void add(Node node)
  {
    root = add(node, root);
  }

  private Node add(Node node, Node current)
  {
    if(current == null)
    {
      current = node;
      return current;
    }

    if(node.key < current.key)
    {
      current.left = add(node, current.left);
    }
    else if(node.key > current.key)
    {
      current.right = add(node, current.right);
    }

    return current;
  }

  public void inOrderTraversal()
  {
    inOrderTraversal(root);
  }

  private void inOrderTraversal(Node current)
  {
    if(current != null)
    {
      inOrderTraversal(current.left);
      System.out.print(current.key + " ");
      inOrderTraversal(current.right);
    }
  }

  public static void printCommonNodes(BinarySearchTree bst1, BinarySearchTree bst2)
  {
    HashSet<Integer> set = new HashSet<>();
    System.out.println("Common nodes are:");
    addTreeToSet(bst1.root, set);
    printCommonNodes(bst2.root, set);
    System.out.println("");
  }

  private static void addTreeToSet(Node current, HashSet<Integer> set)
  {
    if(current != null)
    {
      addTreeToSet(current.left, set);
      set.add(current.key);
      addTreeToSet(current.right, set);
    }
  }

  private static void printCommonNodes(Node current, HashSet<Integer> set)
  {
    if(current != null)
    {
      printCommonNodes(current.left, set);
      if(set.contains(current.key))
      {
        System.out.print(current.key + " ");
      }
      printCommonNodes(current.right, set);
    }
  }
}

public class BSTIntersection
{
  public static void main(String[] args)
  {
    BinarySearchTree bst1 = new BinarySearchTree();
    bst1.add(new Node(5));
    bst1.add(new Node(1));
    bst1.add(new Node(10));
    bst1.add(new Node(0));
    bst1.add(new Node(4));
    bst1.add(new Node(7));
    bst1.add(new Node(9));

    BinarySearchTree bst2 = new BinarySearchTree();
    bst2.add(new Node(10));
    bst2.add(new Node(7));
    bst2.add(new Node(4));
    bst2.add(new Node(9));
    bst2.add(new Node(20));

    System.out.println("Inorder representation of 1st BST:");
    bst1.inOrderTraversal();
    System.out.println("");

    System.out.println("Inorder representation of 2nd BST:");
    bst2.inOrderTraversal();
    System.out.println("");

    BinarySearchTree.printCommonNodes(bst1, bst2);
  }
}
