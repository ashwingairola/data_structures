class Node
{
  int key;
  Node next;

  public Node(int key)
  {
    this.key = key;
  }
}

class MyLinkedList
{
  private Node start;

  public Node getStart()
  {
    return start;
  }

  public void addNode(Node node)
  {
    if(start == null)
    {
      start = node;
      return;
    }

    Node current = start;
    while(current.next != null)
    {
      current = current.next;
    }
    current.next = node;
  }

  public void display()
  {
    Node current = start;
    while(current != null)
    {
      System.out.print(current.key + " ");
      current = current.next;
    }
    System.out.println("");
  }

  // Method to rotate a list anticlockwise (left) by a given number of elements.
  public void leftRotate(int num)
  {
    Node current = start, start1 = start, prev = null;
    // Iterate till num = 0, i.e., we have found the node till which we need to rotate.
    while(num > 0)
    {
      prev = current;
      current = current.next;
      num--;
    }
    // The prev element will be the last element in the final list, thus prev.next = null
    prev.next = null;
    // The new start must be current.
    start = current;

    // Iterate from current till null is reached, then assign current.next = the old start
    while(current.next != null)
    {
      current = current.next;
    }
    current.next = start1;
    // The new list is obtained.
  }
}

public class RotateLinkedList
{
  public static void main(String[] args)
  {
    MyLinkedList list = new MyLinkedList();
    list.addNode(new Node(10));
    list.addNode(new Node(20));
    list.addNode(new Node(30));
    list.addNode(new Node(40));
    list.addNode(new Node(50));
    list.addNode(new Node(60));
    System.out.println("Original list:");
    list.display();
    list.leftRotate(4);
    System.out.println("After anticlockwise rotation of 4:");
    list.display();
  }
}
