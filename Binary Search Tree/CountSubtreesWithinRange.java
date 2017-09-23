/*
Count BST subtrees that lie in given range

Given a Binary Search Tree (BST) of integer values and a range [low, high],
return count of nodes where all the nodes under that node (or subtree rooted with that node)
lie in the given range.

Examples:

Input:
        10
      /    \
    5       50
   /       /  \
 1       40   100
Range: [5, 45]
Output:  1
There is only 1 node whose subtree is in the given range.
The node is 40


Input:
        10
      /    \
    5       50
   /       /  \
 1       40   100
Range: [1, 45]
Output:  3
There are three nodes whose subtree is in the given range.
The nodes are 1, 5 and 40
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
  private int count;

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

  public int getSubtreesInRange(int min, int max)
  {
    getSubtreesInRange(root, min, max);
    int count1 = count;
    count = 0;
    return count1;
  }

  /*
  Algorithm:
  1.  Perform postorder traversal on the tree.
  2.  For each node, check the entire left and right subtrees.
  3.  If they satisfy the condition and the current node lies within the given
      range, increment the counter.
  */
  private boolean getSubtreesInRange(Node node, int min, int max)
  {
    if(node == null)
    {
      return true;
    }

    boolean l = getSubtreesInRange(node.left, min, max);
    boolean r = getSubtreesInRange(node.right, min, max);
    if(l && r && node.key >= min && node.key <= max)
    {
      System.out.println(node.key);
      ++count;
      return true;
    }
    return false;
  }
}

public class CountSubtreesWithinRange
{
  public static void main(String[] args)
  {
    BinarySearchTree bst = new BinarySearchTree();
    bst.add(new Node(10));
    bst.add(new Node(5));
    bst.add(new Node(1));
    bst.add(new Node(50));
    bst.add(new Node(40));
    bst.add(new Node(100));

    System.out.println("Inorder representation of the tree:");
    bst.inOrderTraversal();
    System.out.println("");

    System.out.println("No. of subtrees within 5 and 45: " + bst.getSubtreesInRange(5, 45));
    System.out.println("No. of subtrees within 1 and 45: " + bst.getSubtreesInRange(1, 45));
  }
}
