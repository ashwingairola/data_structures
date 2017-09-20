/*
Lowest Common Ancestor in a Binary Search Tree.

Given values of two values n1 and n2 in a Binary Search Tree,
find the Lowest Common Ancestor (LCA).
You may assume that both the values exist in the tree.
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

  public Node getLCA(int node1, int node2)
  {
    return getLCA(node1, node2, root);
  }

  private Node getLCA(int node1, int node2, Node current)
  {
    if(current == null)
    {
      return null;
    }

    if(current.key > node1 && current.key > node2)
    {
      return getLCA(node1, node2, current.left);
    }
    else if(current.key < node1 && current.key < node2)
    {
      return getLCA(node1, node2, current.right);
    }

    return current;
  }
}

public class LCA
{
  public static void main(String[] args)
  {
    BinarySearchTree bst = new BinarySearchTree();
    bst.add(new Node(20));
    bst.add(new Node(8));
    bst.add(new Node(22));
    bst.add(new Node(4));
    bst.add(new Node(12));
    bst.add(new Node(10));
    bst.add(new Node(14));
    System.out.println("The BST is:");
    bst.inOrderTraversal();
    System.out.println("");

    System.out.println("The LCA of 10 & 14 is: " + bst.getLCA(10, 14).key);
    System.out.println("The LCA of 14 & 8 is: " + bst.getLCA(14, 8).key);
    System.out.println("The LCA of 10 & 22 is: " + bst.getLCA(10, 22).key);
  }
}
