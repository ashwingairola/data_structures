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

  public Node getRoot()
  {
    return root;
  }

  public void insert(Node node)
  {
    root = insert(node, root);
  }

  private Node insert(Node node, Node current)
  {
    if(current == null)
    {
      current = node;
      return current;
    }

    if(node.key < current.key)
    {
      current.left = insert(node, current.left);
    }
    else if(node.key > current.key)
    {
      current.right = insert(node, current.right);
    }

    return current;
  }

  public Node search(int key)
  {
    Node node = search(root, key);
    return node;
  }

  private Node search(Node node, int key)
  {
    if(node == null || node.key == key)
    {
      return node;
    }

    if(key < node.key)
    {
      return search(node.left, key);
    }
    
    return search(node.right, key);
  }

  public void inOrderTraversal()
  {
    inOrderTraversal(root);
  }

  private void inOrderTraversal(Node node)
  {
    if(node != null)
    {
      inOrderTraversal(node.left);
      System.out.print(node.key + " ");
      inOrderTraversal(node.right);
    }
  }

  public void preOrderTraversal()
  {
    preOrderTraversal(root);
  }

  private void preOrderTraversal(Node node)
  {
    if(node != null)
    {
      System.out.print(node.key + " ");
      preOrderTraversal(node.left);
      preOrderTraversal(node.right);
    }
  }

  public void postOrderTraversal()
  {
    postOrderTraversal(root);
  }

  private void postOrderTraversal(Node node)
  {
    if(node != null)
    {
      postOrderTraversal(node.left);
      postOrderTraversal(node.right);
      System.out.print(node.key + " ");
    }
  }
}

public class BST
{
  public static void main(String[] args)
  {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(new Node(20));
    bst.insert(new Node(12));
    bst.insert(new Node(22));
    bst.insert(new Node(13));
    bst.insert(new Node(9));
    bst.insert(new Node(10));
    bst.inOrderTraversal();
    System.out.println("");
    bst.preOrderTraversal();
    System.out.println("");
    bst.postOrderTraversal();
    System.out.println("");
    Node node = bst.search(9);
    System.out.println(node.key);
  }
}
