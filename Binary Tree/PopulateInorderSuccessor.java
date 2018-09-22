class Node {
  int data;
  Node left, right, next;

  public Node(int data) {
    this.data = data;
  }
}

class BinaryTree {
  public Node root = null;
  private static Node next;

  private void setInorderSuccessors(Node current) {
    if(current != null) {
      setInorderSuccessors(current.right);
      current.next = next;
      next = current;
      setInorderSuccessors(current.left);
    }
  }

  public void setInorderSuccessors() {
    setInorderSuccessors(root);
  }

  private void printInorderSuccession(Node current) {
    if(current == null || current.next == null) {
      return;
    }

    printInorderSuccession(current.left);
    System.out.println(current.data + "->" + current.next.data);
    printInorderSuccession(current.right);
  }

  public void printInorderSuccession() {
    printInorderSuccession(root);
  }
}

public class PopulateInorderSuccessor {
  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    bt.root = new Node(10);
    bt.root.left = new Node(8);
    bt.root.left.left = new Node(3);
    bt.root.right = new Node(12);

    bt.setInorderSuccessors();
    bt.printInorderSuccession();
  }
}
