class Node {
  public int val;
  public Node left;
  public Node right;

  public Node(int val) {
    this.val = val;
  }
}

class BinaryTree {
  public Node root = null;
  public int[] left = new int[100];
  public int[] right = new int[100];
  public int leftCount = 0, rightCount = 0;

  public void traverse(Node current, int distance, int maxLeft, int maxRight) {
    if(current == null) {
      return;
    }
    System.out.println("current: " + current.val);
    System.out.println("distance: " + distance + " maxLeft: " + maxLeft + " maxRight: " + maxRight);
    if(maxLeft == 0 && maxRight == 0 && current == root) {
      left[leftCount++] = current.val;
    }
    else if(distance < maxLeft) {
      left[leftCount++] = current.val;
      maxLeft = distance;
    }
    else if(distance > maxRight) {
      right[rightCount++] = current.val;
      maxRight = distance;
    }

    traverse(current.left, distance - 1, maxLeft, maxRight);
    traverse(current.right, distance + 1, maxLeft, maxRight);
  }

  public void getTopView() {
    traverse(root, 0, 0, 0);
    for(int i=leftCount-1; i>=0; --i) {
      System.out.print(left[i] + " ");
    }
    for(int i=0; i<rightCount; ++i) {
      System.out.print(right[i] + " ");
    }
  }
}

public class TopView {
  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    bt.root = new Node(1);
    bt.root.left = new Node(2);
    bt.root.right = new Node(3);
    bt.root.left.right = new Node(4);
    bt.root.left.right.right = new Node(5);
    bt.root.left.right.right.right = new Node(6);
    bt.getTopView();
  }
}
