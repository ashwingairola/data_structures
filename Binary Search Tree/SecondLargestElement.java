/*
Second largest element in BST
Given a Binary Search Tree(BST), find the second largest element.

Examples:

Input: Root of below BST
    10
   /
  5

Output:  5

Input: Root of below BST
        10
      /   \
    5      20
             \
              30

Output:  20
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

  public Node get2ndLargestNode()
  {
    return get2ndLargestNode(root, root);
  }

  private Node get2ndLargestNode(Node current, Node prev)
  {
    if(current == null)
    {
      return null;
    }

    if(current.right == null)
    {
      return prev;
    }

    return get2ndLargestNode(current.right, current);
  }
}

class SecondLargestElement
{
  public static void main(String[] args)
  {
    BinarySearchTree bst = new BinarySearchTree();
    bst.add(new Node(10));
    bst.add(new Node(5));
    bst.add(new Node(20));
    bst.add(new Node(30));

    System.out.println("Inorder representation of tree:");
    bst.inOrderTraversal();
    System.out.println("");

    System.out.println("2nd largest node: " + bst.get2ndLargestNode().key);
  }
}
