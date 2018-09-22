import java.util.Scanner;

class Node {
  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
  }
}

class BinaryTree {
  public Node root;
  private static int index;

  public BinaryTree(Node root) {
    this.root = root;
  }

  public void findNthNode(int n) {
    findNthNode(root, n);
  }

  private void findNthNode(Node current, int n) {
    if(current == null) {
      return;
    }

    findNthNode(current.left, n);
    index++;
    if(index == n) {
      System.out.println(current.data);
    }
    findNthNode(current.right, n);
  }
}

public class FindNthNode {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BinaryTree bt = new BinaryTree(new Node(10));
    bt.root.left = new Node(20);
    bt.root.left.left = new Node(40);
    bt.root.left.right = new Node(50);
    bt.root.right = new Node(30);
    System.out.print("Enter n to find nth node: ");
    int n = sc.nextInt();
    bt.findNthNode(n);
  }
}
