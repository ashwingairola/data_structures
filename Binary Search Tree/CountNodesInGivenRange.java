/*
Count BST nodes that lie in a given range
Given a Binary Search Tree (BST) and a range,
count number of nodes that lie in the given range.

Examples:

Input:
        10
      /    \
    5       50
   /       /  \
 1       40   100
Range: [5, 45]

Output:  3
There are three nodes in range, 5, 10 and 40
*/
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

  public int getRange(int min, int max)
  {
    return getRange(min, max, root, 0);
  }

  /*
  Perform inorder traversal and check each node's key for the range.
  Use a count1 variable to store the value of count received from a recursive call.
  */
  private int getRange(int min, int max, Node current, int count)
  {
    int count1 = count;
    if(current != null)
    {
      count1 = getRange(min, max, current.left, count1);
      if(current.key >= min && current.key <= max)
      {
        ++count1;
        count = count1;
      }
      count1 = getRange(min, max, current.right, count1);
    }
    return count1;
  }
}

public class CountNodesInGivenRange
{
  public static void main(String[] args)
  {
    BinarySearchTree bst = new BinarySearchTree();
    bst.add(new Node(10));
    bst.add(new Node(5));
    bst.add(new Node(50));
    bst.add(new Node(1));
    bst.add(new Node(40));
    bst.add(new Node(100));

    System.out.println("Inorder representation of the tree:");
    bst.inOrderTraversal();
    System.out.println("");

    System.out.println("No. of nodes b/w range 5 and 45 is: " + bst.getRange(5, 45));
    System.out.println("No. of nodes b/w range 0 and 500 is: " + bst.getRange(0, 500));
    System.out.println("No. of nodes b/w range 1 and 1 is: " + bst.getRange(1, 1));
    System.out.println("No. of nodes b/w range 0 and 0 is: " + bst.getRange(0, 0));
  }
}
