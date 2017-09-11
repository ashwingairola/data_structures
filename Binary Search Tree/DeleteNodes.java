/*
When we delete a node, three possibilities arise:

1) Node to be deleted is leaf: Simply remove from the tree.

              50                            50
           /     \         delete(20)      /   \
          30      70       --------->    30     70
         /  \    /  \                     \    /  \
       20   40  60   80                   40  60   80
2) Node to be deleted has only one child: Copy the child to the node and delete the child.

              50                            50
           /     \         delete(30)      /   \
          30      70       --------->    40     70
            \    /  \                          /  \
            40  60   80                       60   80
3) Node to be deleted has two children: Find inorder successor of the node.
  Copy contents of the inorder successor to the node and delete the inorder successor.
  Note that inorder predecessor can also be used.

              50                            60
           /     \         delete(50)      /   \
          40      70       --------->    40    70
                 /  \                            \
                60   80                           80
The important thing to note is, inorder successor is needed only when right child is not empty.
In this particular case, inorder successor can be obtained by finding the minimum value in right child of the node.
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

  public Node getRoot()
  {
    return root;
  }

  // This method calls the recursive version of delete()
  public void delete(int key)
  {
    root = delete(key, root);
  }

  // A recursive function to insert a new key in BST
  private Node delete(int key, Node current)
  {
    // Base Case: If the tree is empty
    if(current == null)
    {
      return current;
    }

    // Otherwise, recur down the tree
    if(key < current.key)
    {
      current.left = delete(key, current.left);
    }
    else if(key > current.key)
    {
      current.right = delete(key, current.right);
    }
    // If the key is same as root's key, then This is the node to be deleted
    else
    {
      // Cases 1 & 2: Node with only one child or no child
      if(current.left == null)
      {
        return current.right;
      }
      else if(current.right == null)
      {
        return current.left;
      }

      // Case 3: Node with two children: Get the inorder successor (smallest in the right subtree)
      current.key = findMinInOrderSuccessor(current.right);
      // Delete the inorder successor
      current.right = delete(current.key, current.right);
    }
    return current;
  }

  private int findMinInOrderSuccessor(Node node)
  {
    int minKey = node.key;
    while(node.left != null)
    {
      minKey = node.left.key;
      node = node.left;
    }
    return minKey;
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
}

public class DeleteNodes
{
  public static void main(String[] args)
  {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(new Node(50));
    bst.insert(new Node(30));
    bst.insert(new Node(20));
    bst.insert(new Node(40));
    bst.insert(new Node(70));
    bst.insert(new Node(60));
    bst.insert(new Node(80));
    System.out.println("Original BST:");
    display(bst);

    bst.delete(20);
    System.out.println("\nBST after deleting 20:");
    display(bst);

    bst.delete(30);
    System.out.println("\nBST after deleting 30:");
    display(bst);

    bst.delete(50);
    System.out.println("\nBST after deleting 50:");
    display(bst);
  }

  public static void display(BinarySearchTree bst)
  {
    System.out.println("In-order traversal:");
    bst.inOrderTraversal();
    // System.out.println("\nPre-order traversal:");
    // bst.preOrderTraversal();
    // System.out.println("\nPost-order traversal:");
    // bst.postOrderTraversal();
    System.out.println("");
  }
}
